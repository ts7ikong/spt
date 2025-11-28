package org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx.entity.Stsjgxx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx.service.IStsjgxxService;

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
 * @Description: 企业三同时监管信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="企业三同时监管信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/aqscxzxkgl/qystsjgxx/stsjgxx")
@Slf4j
public class StsjgxxController extends JeecgController<Stsjgxx, IStsjgxxService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IStsjgxxService stsjgxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param stsjgxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "企业三同时监管信息-分页列表查询")
	@ApiOperation(value="企业三同时监管信息-分页列表查询", notes="企业三同时监管信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Stsjgxx>> queryPageList(Stsjgxx stsjgxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("projectType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("projectStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("approvalStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("designStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("buildStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("testProductionStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("acceptanceStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Stsjgxx> queryWrapper = QueryGenerator.initQueryWrapper(stsjgxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<Stsjgxx> page = new Page<Stsjgxx>(pageNo, pageSize);
		IPage<Stsjgxx> pageList = stsjgxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param stsjgxx
	 * @return
	 */
	@AutoLog(value = "企业三同时监管信息-添加")
	@ApiOperation(value="企业三同时监管信息-添加", notes="企业三同时监管信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Stsjgxx stsjgxx) {
		stsjgxxService.save(stsjgxx);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param stsjgxx
	 * @return
	 */
	@AutoLog(value = "企业三同时监管信息-编辑")
	@ApiOperation(value="企业三同时监管信息-编辑", notes="企业三同时监管信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Stsjgxx stsjgxx) {
		stsjgxxService.updateById(stsjgxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业三同时监管信息-通过id删除")
	@ApiOperation(value="企业三同时监管信息-通过id删除", notes="企业三同时监管信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		stsjgxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业三同时监管信息-批量删除")
	@ApiOperation(value="企业三同时监管信息-批量删除", notes="企业三同时监管信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.stsjgxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业三同时监管信息-通过id查询")
	@ApiOperation(value="企业三同时监管信息-通过id查询", notes="企业三同时监管信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Stsjgxx> queryById(@RequestParam(name="id",required=true) String id) {
		Stsjgxx stsjgxx = stsjgxxService.getById(id);
		if(stsjgxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(stsjgxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param stsjgxx
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Stsjgxx stsjgxx) {
        return super.exportXls(request, stsjgxx, Stsjgxx.class, "企业三同时监管信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Stsjgxx.class);
    }

}
