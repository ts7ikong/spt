package org.jeecg.modules.sptsjzx.scyf.gwyjczk.controller;

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
import org.jeecg.modules.sptsjzx.scyf.gwyjczk.entity.AcceptDisposalFormal;
import org.jeecg.modules.sptsjzx.scyf.gwyjczk.service.IAcceptDisposalFormalService;

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
 * @Description: 应急岗位处置卡
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="应急岗位处置卡")
@RestController
@RequestMapping("/sptsjzx/scyf/gwyjczk/acceptDisposalFormal")
@Slf4j
public class AcceptDisposalFormalController extends JeecgController<AcceptDisposalFormal, IAcceptDisposalFormalService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptDisposalFormalService acceptDisposalFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptDisposalFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急岗位处置卡-分页列表查询")
	@ApiOperation(value="应急岗位处置卡-分页列表查询", notes="应急岗位处置卡-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptDisposalFormal>> queryPageList(AcceptDisposalFormal acceptDisposalFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcceptDisposalFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptDisposalFormal, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptDisposalFormal> page = new Page<AcceptDisposalFormal>(pageNo, pageSize);
		IPage<AcceptDisposalFormal> pageList = acceptDisposalFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptDisposalFormal
	 * @return
	 */
	@AutoLog(value = "应急岗位处置卡-添加")
	@ApiOperation(value="应急岗位处置卡-添加", notes="应急岗位处置卡-添加")
	@RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptDisposalFormal acceptDisposalFormal) {
		acceptDisposalFormalService.save(acceptDisposalFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptDisposalFormal
	 * @return
	 */
	@AutoLog(value = "应急岗位处置卡-编辑")
	@ApiOperation(value="应急岗位处置卡-编辑", notes="应急岗位处置卡-编辑")
	@RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptDisposalFormal acceptDisposalFormal) {
		acceptDisposalFormalService.updateById(acceptDisposalFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急岗位处置卡-通过id删除")
	@ApiOperation(value="应急岗位处置卡-通过id删除", notes="应急岗位处置卡-通过id删除")
	@RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptDisposalFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急岗位处置卡-批量删除")
	@ApiOperation(value="应急岗位处置卡-批量删除", notes="应急岗位处置卡-批量删除")
	@RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptDisposalFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急岗位处置卡-通过id查询")
	@ApiOperation(value="应急岗位处置卡-通过id查询", notes="应急岗位处置卡-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptDisposalFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptDisposalFormal acceptDisposalFormal = acceptDisposalFormalService.getById(id);
		if(acceptDisposalFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptDisposalFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptDisposalFormal
    */
    @RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptDisposalFormal acceptDisposalFormal) {
        return super.exportXls(request, acceptDisposalFormal, AcceptDisposalFormal.class, "应急岗位处置卡");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.scyf.gwyjczk:accept_disposal_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptDisposalFormal.class);
    }

}
