package org.jeecg.modules.sptsjzx.scyf.aqfxdy.controller;

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
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.scyf.aqfxdy.entity.AcceptUnitFormal;
import org.jeecg.modules.sptsjzx.scyf.aqfxdy.service.IAcceptUnitFormalService;

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
 * @Description: 安全风险单元
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="安全风险单元")
@RestController
@RequestMapping("/sptsjzx/scyf/aqfxdy/acceptUnitFormal")
@Slf4j
public class AcceptUnitFormalController extends JeecgController<AcceptUnitFormal, IAcceptUnitFormalService> {
	
	@Autowired
	private IAcceptUnitFormalService acceptUnitFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptUnitFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "安全风险单元-分页列表查询")
	@ApiOperation(value="安全风险单元-分页列表查询", notes="安全风险单元-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptUnitFormal>> queryPageList(AcceptUnitFormal acceptUnitFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcceptUnitFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptUnitFormal, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = DataScopeHelper.getCompanyCodesByOrgCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptUnitFormal> page = new Page<AcceptUnitFormal>(pageNo, pageSize);
		IPage<AcceptUnitFormal> pageList = acceptUnitFormalService.page(page, queryWrapper);

		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptUnitFormal
	 * @return
	 */
	@AutoLog(value = "安全风险单元-添加")
	@ApiOperation(value="安全风险单元-添加", notes="安全风险单元-添加")
	@RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptUnitFormal acceptUnitFormal) {
		acceptUnitFormalService.save(acceptUnitFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptUnitFormal
	 * @return
	 */
	@AutoLog(value = "安全风险单元-编辑")
	@ApiOperation(value="安全风险单元-编辑", notes="安全风险单元-编辑")
	@RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptUnitFormal acceptUnitFormal) {
		acceptUnitFormalService.updateById(acceptUnitFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "安全风险单元-通过id删除")
	@ApiOperation(value="安全风险单元-通过id删除", notes="安全风险单元-通过id删除")
	@RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptUnitFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "安全风险单元-批量删除")
	@ApiOperation(value="安全风险单元-批量删除", notes="安全风险单元-批量删除")
	@RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptUnitFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "安全风险单元-通过id查询")
	@ApiOperation(value="安全风险单元-通过id查询", notes="安全风险单元-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptUnitFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptUnitFormal acceptUnitFormal = acceptUnitFormalService.getById(id);
		if(acceptUnitFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptUnitFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptUnitFormal
    */
    @RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptUnitFormal acceptUnitFormal) {
        return super.exportXls(request, acceptUnitFormal, AcceptUnitFormal.class, "安全风险单元");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.scyf.aqfxdy:accept_unit_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptUnitFormal.class);
    }

}
