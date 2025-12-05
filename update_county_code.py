#!/usr/bin/env python3
"""
Script to add countyCode support to controllers and entities
"""
import os
import re
from pathlib import Path

# Controller configurations: module -> [(controller_path, entity_var, entity_class, has_data_scope), ...]
CONTROLLERS = {
    "rydwsj": [
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbrybjsj/controller/RybjsjController.java", "rybjsj", "Rybjsj", True),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbqybjsj/controller/QybjsjController.java", "qybjsj", "Qybjsj", True),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbqybjxx/controller/ZoneGeoController.java", "zoneGeo", "ZoneGeo", True),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/rydwsssj/controller/RydwqyzxztController.java", "rydwqyzxzt", "Rydwqyzxzt", False),
    ],
}

# Entities: module -> [(entity_path, entity_class), ...]
ENTITIES = {
    "rydwsj": [
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/ryjjbj/entity/Ryjj.java", "Ryjj"),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbrybjsj/entity/Rybjsj.java", "Rybjsj"),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbqybjsj/entity/Qybjsj.java", "Qybjsj"),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/sbqybjxx/entity/ZoneGeo.java", "ZoneGeo"),
        ("zagy-sptsjzx-rydwsj/zagy-sptsjzx-rydwsj-biz/src/main/java/org/jeecg/modules/sptsjzx/rydwsj/rydwsssj/entity/Rydwqyzxzt.java", "Rydwqyzxzt"),
    ],
}

def add_import_if_missing(content, import_statement):
    """Add import if it's not already present"""
    if import_statement not in content:
        # Find the last import statement
        import_pattern = r'(import .*?;\n)'
        matches = list(re.finditer(import_pattern, content))
        if matches:
            last_import = matches[-1]
            insert_pos = last_import.end()
            content = content[:insert_pos] + import_statement + '\n' + content[insert_pos:]
    return content

def update_controller(filepath, entity_var, entity_class, has_data_scope):
    """Update a controller file to add countyCode support"""
    base_path = "/home/user/spt"
    full_path = os.path.join(base_path, filepath)

    if not os.path.exists(full_path):
        print(f"  ❌ File not found: {full_path}")
        return False

    with open(full_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Check if already processed
    if f"{entity_var}.getCountyCode()" in content:
        print(f"  ✓ Already processed (skipping)")
        return True

    # Add CollectionUtils import if missing
    content = add_import_if_missing(content, "import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;")

    # Add acceptCompanyService if missing
    if "acceptCompanyService" not in content and has_data_scope:
        content = add_import_if_missing(content, "import org.jeecg.common.util.DataScopeHelper;")
        content = add_import_if_missing(content, "import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;")
        # Add @Autowired IAcceptCompanyService field if needed
        if "@Autowired\n\tprivate IAcceptCompanyService acceptCompanyService;" not in content:
            # Find the class declaration and add the field
            class_pattern = rf'public class \w+Controller.*?\{{'
            match = re.search(class_pattern, content, re.DOTALL)
            if match:
                insert_pos = match.end()
                field_code = "\n\t\n\n\t@Autowired\n\tprivate IAcceptCompanyService acceptCompanyService;\n"
                content = content[:insert_pos] + field_code + content[insert_pos:]

    # Find all methods that need updating
    # Pattern 1: Methods with existing data scope logic
    pattern1 = rf'(// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）)\s*(Page<{entity_class}> page = new Page<{entity_class}>\(pageNo, pageSize\);\s*IPage<{entity_class}> pageList = \w+\.page\(page, queryWrapper\);\s*return Result\.OK\(pageList\);)'

    def replace_with_county_code_logic(match):
        comment = match.group(1)
        rest = match.group(2)

        county_code_logic = f'''if ({entity_var}.getCountyCode() != null) {{
\t\t\tString orgCode = {entity_var}.getCountyCode();
\t\t\tList<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
\t\t\tif (companyCodes == null) {{
\t\t\t\t// 请求的企业不在当前区县权限范围内，返回空结果
\t\t\t\treturn Result.OK(new Page<>(pageNo, pageSize));
\t\t\t}}
\t\t\tDataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
\t\t}}
\t\t'''

        # Update the return statement to add setCountyCode logic
        page_and_return = rest
        # Find the return statement
        return_pattern = rf'(Page<{entity_class}> page = new Page<{entity_class}>\(pageNo, pageSize\);\s*IPage<{entity_class}> pageList = \w+\.page\(page, queryWrapper\);)\s*(return Result\.OK\(pageList\);)'

        def add_set_county_code(m):
            page_logic = m.group(1)
            return_stmt = m.group(2)

            set_county_code = f'''if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {{
\t\t\tfor ({entity_class} item : pageList.getRecords()) {{
\t\t\t\t// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
\t\t\t\titem.setCountyCode(item.getCompanyCode());
\t\t\t}}
\t\t}}
\t\t'''
            return f"{page_logic}\n\t\t{set_county_code}{return_stmt}"

        updated_rest = re.sub(return_pattern, add_set_county_code, rest)
        return f"{comment}\n\t\t{county_code_logic}{updated_rest}"

    content = re.sub(pattern1, replace_with_county_code_logic, content)

    # Pattern 2: Methods without existing data scope logic (like RydwqyzxztController)
    # Find methods that DON'T have data scope logic yet
    if not has_data_scope:
        # Look for methods with queryWrapper but no data scope filtering
        pattern2 = rf'(QueryWrapper<{entity_class}> queryWrapper = QueryGenerator\.initQueryWrapper\({entity_var},.*?\);)\s*(Page<{entity_class}> page = new Page<{entity_class}>\(pageNo, pageSize\);\s*IPage<{entity_class}> pageList = \w+\.page\(page, queryWrapper\);\s*return Result\.OK\(pageList\);)'

        def add_county_code_and_data_scope(match):
            query_wrapper = match.group(1)
            rest = match.group(2)

            county_code_logic = f'''
\n\t\t// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
\t\tif ({entity_var}.getCountyCode() != null) {{
\t\t\tString orgCode = {entity_var}.getCountyCode();
\t\t\tList<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
\t\t\tif (companyCodes == null) {{
\t\t\t\t// 请求的企业不在当前区县权限范围内，返回空结果
\t\t\t\treturn Result.OK(new Page<>(pageNo, pageSize));
\t\t\t}}
\t\t\tDataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
\t\t}}
\t\t'''

            # Add setCountyCode logic
            return_pattern = rf'(Page<{entity_class}> page = new Page<{entity_class}>\(pageNo, pageSize\);\s*IPage<{entity_class}> pageList = \w+\.page\(page, queryWrapper\);)\s*(return Result\.OK\(pageList\);)'

            def add_set_county(m):
                page_logic = m.group(1)
                return_stmt = m.group(2)

                set_county_code = f'''if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {{
\t\t\tfor ({entity_class} item : pageList.getRecords()) {{
\t\t\t\t// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
\t\t\t\titem.setCountyCode(item.getCompanyCode());
\t\t\t}}
\t\t}}
\t\t'''
                return f"{page_logic}\n\t\t{set_county_code}{return_stmt}"

            updated_rest = re.sub(return_pattern, add_set_county, rest)
            return f"{query_wrapper}{county_code_logic}{updated_rest}"

        content = re.sub(pattern2, add_county_code_and_data_scope, content)

    # Write back
    with open(full_path, 'w', encoding='utf-8') as f:
        f.write(content)

    print(f"  ✓ Updated")
    return True

def update_entity(filepath, entity_class):
    """Update an entity file to add countyCode field"""
    base_path = "/home/user/spt"
    full_path = os.path.join(base_path, filepath)

    if not os.path.exists(full_path):
        print(f"  ❌ File not found: {full_path}")
        return False

    with open(full_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Check if already processed
    if "private java.lang.String countyCode;" in content:
        print(f"  ✓ Already has countyCode (skipping)")
        return True

    # Add TableField import if needed
    if "import com.baomidou.mybatisplus.annotation.*;" not in content:
        # Replace individual imports with wildcard import
        if "import com.baomidou.mybatisplus.annotation." in content:
            content = re.sub(
                r'import com\.baomidou\.mybatisplus\.annotation\.[^;]+;\n',
                '',
                content
            )
            content = add_import_if_missing(content, "import com.baomidou.mybatisplus.annotation.*;")

    # Find the last field before the closing brace
    # Look for the pattern of the last field
    pattern = r'(private java\.lang\.String \w+;)\s*\n}'

    county_code_field = '''\t/**区县Code*/
\t@TableField(exist = false)
\t@ApiModelProperty(value = "区县Code")
\t@Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
\tprivate java.lang.String countyCode;
}'''

    def add_county_code(match):
        last_field = match.group(1)
        return f"{last_field}\n{county_code_field}"

    content = re.sub(pattern, add_county_code, content)

    # Write back
    with open(full_path, 'w', encoding='utf-8') as f:
        f.write(content)

    print(f"  ✓ Added countyCode field")
    return True

def main():
    print("Starting countyCode update process...\n")

    total_controllers = 0
    total_entities = 0
    errors = []

    for module, controllers in CONTROLLERS.items():
        print(f"\n{'='*60}")
        print(f"Processing module: {module}")
        print(f"{'='*60}")

        for controller_path, entity_var, entity_class, has_data_scope in controllers:
            print(f"\nController: {os.path.basename(controller_path)}")
            print(f"  Entity var: {entity_var}, Entity class: {entity_class}, Has data scope: {has_data_scope}")
            try:
                if update_controller(controller_path, entity_var, entity_class, has_data_scope):
                    total_controllers += 1
            except Exception as e:
                errors.append(f"Controller {controller_path}: {str(e)}")
                print(f"  ❌ Error: {str(e)}")

    for module, entities in ENTITIES.items():
        print(f"\n--- Entities for module: {module} ---")
        for entity_path, entity_class in entities:
            print(f"\nEntity: {os.path.basename(entity_path)}")
            try:
                if update_entity(entity_path, entity_class):
                    total_entities += 1
            except Exception as e:
                errors.append(f"Entity {entity_path}: {str(e)}")
                print(f"  ❌ Error: {str(e)}")

    print(f"\n{'='*60}")
    print(f"Summary:")
    print(f"{'='*60}")
    print(f"Total controllers updated: {total_controllers}")
    print(f"Total entities updated: {total_entities}")
    if errors:
        print(f"\nErrors encountered ({len(errors)}):")
        for error in errors:
            print(f"  - {error}")
    else:
        print(f"\n✓ All files processed successfully!")

if __name__ == "__main__":
    main()
