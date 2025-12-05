#!/usr/bin/env python3
"""
Batch script to add countyCode support to all controllers and entities across all modules
"""
import os
import re
import sys

BASE_PATH = "/home/user/spt"

def read_file(filepath):
    """Read file content"""
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            return f.read()
    except Exception as e:
        print(f"Error reading {filepath}: {e}")
        return None

def write_file(filepath, content):
    """Write content to file"""
    try:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(content)
        return True
    except Exception as e:
        print(f"Error writing {filepath}: {e}")
        return False

def add_import(content, import_stmt):
    """Add import if not already present"""
    if import_stmt in content:
        return content

    # Find last import and add after it
    import_pattern = r'(import .*?;\n)'
    matches = list(re.finditer(import_pattern, content))
    if matches:
        last_import = matches[-1]
        insert_pos = last_import.end()
        return content[:insert_pos] + import_stmt + '\n' + content[insert_pos:]
    return content

def process_controller(filepath, entity_var, entity_class):
    """Add countyCode logic to a controller"""
    content = read_file(filepath)
    if not content:
        return False

    # Skip if already processed
    if f"{entity_var}.getCountyCode()" in content:
        print(f"  ✓ Already has countyCode logic")
        return True

    # Add necessary imports
    content = add_import(content, "import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;")
    content = add_import(content, "import org.jeecg.common.util.DataScopeHelper;")
    content = add_import(content, "import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;")

    # Add acceptCompanyService field if missing
    if "acceptCompanyService" not in content:
        # Find class body start
        class_match = re.search(r'(public class \w+Controller[^{]+\{)', content, re.DOTALL)
        if class_match:
            insert_pos = class_match.end()
            field = "\n\n\t@Autowired\n\tprivate IAcceptCompanyService acceptCompanyService;\n"
            content = content[:insert_pos] + field + content[insert_pos:]

    # Add county code logic after the comment
    county_code_block = f'''if ({entity_var}.getCountyCode() != null) {{
\t\t\tString orgCode = {entity_var}.getCountyCode();
\t\t\tList<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
\t\t\tif (companyCodes == null) {{
\t\t\t\t// 请求的企业不在当前区县权限范围内，返回空结果
\t\t\t\treturn Result.OK(new Page<>(pageNo, pageSize));
\t\t\t}}
\t\t\tDataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
\t\t}}
\t\t'''

    # Pattern to find where to insert county code logic
    pattern1 = r'(// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）)\s*(Page<' + entity_class + r'> page = new Page)'

    def replace_with_county_logic(match):
        comment = match.group(1)
        page_part = match.group(2)
        return f"{comment}\n\t\t{county_code_block}{page_part}"

    content = re.sub(pattern1, replace_with_county_logic, content)

    # If no data scope comment found, add after QueryWrapper initialization
    if f"{entity_var}.getCountyCode()" not in content:
        pattern2 = r'(QueryWrapper<' + entity_class + r'> queryWrapper = QueryGenerator\.initQueryWrapper\([^;]+;\s*)\n(\s*Page<' + entity_class + r'> page)'

        def add_county_after_wrapper(match):
            wrapper_part = match.group(1)
            page_part = match.group(2)
            comment = "\n\t\t// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）\n\t\t"
            return f"{wrapper_part}{comment}{county_code_block}{page_part}"

        content = re.sub(pattern2, add_county_after_wrapper, content)

    # Add setCountyCode logic before return Result.OK(pageList)
    set_county_block = f'''if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {{
\t\t\tfor ({entity_class} item : pageList.getRecords()) {{
\t\t\t\t// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
\t\t\t\titem.setCountyCode(item.getCompanyCode());
\t\t\t}}
\t\t}}
\t\t'''

    pattern3 = r'(IPage<' + entity_class + r'> pageList = \w+\.page\(page, queryWrapper\);)\s*(return Result\.OK\(pageList\);)'

    def add_set_county(match):
        page_logic = match.group(1)
        return_stmt = match.group(2)
        return f"{page_logic}\n\t\t{set_county_block}{return_stmt}"

    content = re.sub(pattern3, add_set_county, content)

    return write_file(filepath, content)

def process_entity(filepath):
    """Add countyCode field to an entity"""
    content = read_file(filepath)
    if not content:
        return False

    # Skip if already has countyCode
    if "private java.lang.String countyCode;" in content:
        print(f"  ✓ Already has countyCode field")
        return True

    # Fix imports - use wildcard if needed
    if "import com.baomidou.mybatisplus.annotation.*;" not in content:
        # Replace specific imports with wildcard
        content = re.sub(
            r'import com\.baomidou\.mybatisplus\.annotation\.(IdType|TableId|TableName|TableLogic|TableField);\n',
            '',
            content
        )
        content = add_import(content, "import com.baomidou.mybatisplus.annotation.*;")

    # Add countyCode field before closing brace
    county_field = '''\t/**区县Code*/
\t@TableField(exist = false)
\t@ApiModelProperty(value = "区县Code")
\t@Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
\tprivate java.lang.String countyCode;
}'''

    # Find the last field before }
    pattern = r'(private \S+ \w+;)\s*\n}'

    def add_county_field(match):
        last_field = match.group(1)
        return f"{last_field}\n{county_field}"

    content = re.sub(pattern, add_county_field, content)

    return write_file(filepath, content)

def get_entity_info_from_controller(controller_path):
    """Extract entity variable and class name from controller"""
    content = read_file(controller_path)
    if not content:
        return None, None

    # Find queryPageList method
    match = re.search(r'public Result<IPage<(\w+)>> queryPageList\((\w+) (\w+),', content)
    if match:
        entity_class = match.group(1)
        entity_var = match.group(3)
        return entity_var, entity_class

    return None, None

def find_entity_path(controller_path, entity_class):
    """Find the entity file path based on controller path"""
    # Replace controller/...Controller.java with entity/EntityClass.java
    dir_path = os.path.dirname(controller_path)
    parent_dir = os.path.dirname(dir_path)
    entity_path = os.path.join(parent_dir, "entity", f"{entity_class}.java")

    if os.path.exists(entity_path):
        return entity_path

    return None

def process_all_controllers(controller_files):
    """Process all controllers in a list"""
    total_processed = 0
    total_entities = 0
    errors = []

    for controller_file in controller_files:
        print(f"\nProcessing: {os.path.basename(controller_file)}")

        # Extract entity info
        entity_var, entity_class = get_entity_info_from_controller(controller_file)
        if not entity_var or not entity_class:
            print(f"  ⚠ Could not extract entity info")
            errors.append(f"Could not extract entity info from {controller_file}")
            continue

        print(f"  Entity: {entity_class}, Var: {entity_var}")

        # Process controller
        if process_controller(controller_file, entity_var, entity_class):
            print(f"  ✓ Controller updated")
            total_processed += 1
        else:
            print(f"  ✗ Controller failed")
            errors.append(f"Failed to process controller: {controller_file}")

        # Find and process entity
        entity_path = find_entity_path(controller_file, entity_class)
        if entity_path:
            print(f"  Entity file: {os.path.basename(entity_path)}")
            if process_entity(entity_path):
                print(f"  ✓ Entity updated")
                total_entities += 1
            else:
                print(f"  ✗ Entity failed")
                errors.append(f"Failed to process entity: {entity_path}")
        else:
            print(f"  ⚠ Entity file not found for {entity_class}")
            errors.append(f"Entity not found: {entity_class}")

    return total_processed, total_entities, errors

def main():
    # Get all controller files from all modules except rydwsj (already done)
    from glob import glob

    modules = [
        "zagy-sptsjzx-scyf",
        "zagy-sptsjzx-tszyaqgk",
        "zagy-sptsjzx-zdwxyaqgl",
        "zagy-sptsjzx-aqjcgl",
        "zagy-sptsjzx-mjyj",
        "zagy-sptsjzx-fbhgl",
        "zagy-sptsjzx-qtxljcgkpt",
        "zagy-sptsjzx-ggglaqfxjcyj",
        "zagy-sptsjzx-gygcaqfxgz",
        "zagy-sptsjzx-jypx",
        "zagy-sptsjzx-dsfdwgl",
    ]

    all_controllers = []
    for module in modules:
        pattern = f"{BASE_PATH}/{module}/**/*Controller.java"
        controllers = glob(pattern, recursive=True)
        # Filter out test files and specific excluded files
        controllers = [c for c in controllers if '/test/' not in c and 'Base' not in c]
        all_controllers.extend(controllers)

    print(f"Found {len(all_controllers)} controllers to process across {len(modules)} modules\n")
    print("="*70)

    total_controllers, total_entities, errors = process_all_controllers(all_controllers)

    print("\n" + "="*70)
    print(f"SUMMARY:")
    print(f"="*70)
    print(f"Total controllers processed: {total_controllers}/{len(all_controllers)}")
    print(f"Total entities processed: {total_entities}")

    if errors:
        print(f"\nErrors ({len(errors)}):")
        for error in errors[:10]:  # Show first 10 errors
            print(f"  - {error}")
        if len(errors) > 10:
            print(f"  ... and {len(errors) - 10} more")
    else:
        print("\n✓ All files processed successfully!")

    return 0 if not errors else 1

if __name__ == "__main__":
    sys.exit(main())
