package org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.entity.CheckSpecialDangerFormal;
import org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.service.ICheckSpecialDangerFormalService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 专项检查隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-25
 * @Version: V1.0
 */
@Api(tags="专项检查隐患信息")
@RestController
@RequestMapping("/sptsjzx/scyf/zxjcyhxx/checkSpecialDangerFormal")
@Slf4j
public class CheckSpecialDangerFormalController extends JeecgController<CheckSpecialDangerFormal, ICheckSpecialDangerFormalService> {
	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private ICheckSpecialDangerFormalService checkSpecialDangerFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param checkSpecialDangerFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "专项检查隐患信息-分页列表查询")
	@ApiOperation(value="专项检查隐患信息-分页列表查询", notes="专项检查隐患信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CheckSpecialDangerFormal>> queryPageList(CheckSpecialDangerFormal checkSpecialDangerFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("checkType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("taskSource", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<CheckSpecialDangerFormal> queryWrapper = QueryGenerator.initQueryWrapper(checkSpecialDangerFormal, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<CheckSpecialDangerFormal> page = new Page<CheckSpecialDangerFormal>(pageNo, pageSize);
		IPage<CheckSpecialDangerFormal> pageList = checkSpecialDangerFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param checkSpecialDangerFormal
	 * @return
	 */
	@AutoLog(value = "专项检查隐患信息-添加")
	@ApiOperation(value="专项检查隐患信息-添加", notes="专项检查隐患信息-添加")
	@RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CheckSpecialDangerFormal checkSpecialDangerFormal) {
		checkSpecialDangerFormalService.save(checkSpecialDangerFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param checkSpecialDangerFormal
	 * @return
	 */
	@AutoLog(value = "专项检查隐患信息-编辑")
	@ApiOperation(value="专项检查隐患信息-编辑", notes="专项检查隐患信息-编辑")
	@RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CheckSpecialDangerFormal checkSpecialDangerFormal) {
		checkSpecialDangerFormalService.updateById(checkSpecialDangerFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "专项检查隐患信息-通过id删除")
	@ApiOperation(value="专项检查隐患信息-通过id删除", notes="专项检查隐患信息-通过id删除")
	@RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		checkSpecialDangerFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "专项检查隐患信息-批量删除")
	@ApiOperation(value="专项检查隐患信息-批量删除", notes="专项检查隐患信息-批量删除")
	@RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.checkSpecialDangerFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "专项检查隐患信息-通过id查询")
	@ApiOperation(value="专项检查隐患信息-通过id查询", notes="专项检查隐患信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CheckSpecialDangerFormal> queryById(@RequestParam(name="id",required=true) String id) {
		CheckSpecialDangerFormal checkSpecialDangerFormal = checkSpecialDangerFormalService.getById(id);
		if(checkSpecialDangerFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(checkSpecialDangerFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param checkSpecialDangerFormal
    */
    @RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CheckSpecialDangerFormal checkSpecialDangerFormal) {
        return super.exportXls(request, checkSpecialDangerFormal, CheckSpecialDangerFormal.class, "专项检查隐患信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.scyf.zxjcyhxx:check_special_danger_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CheckSpecialDangerFormal.class);
    }

}
