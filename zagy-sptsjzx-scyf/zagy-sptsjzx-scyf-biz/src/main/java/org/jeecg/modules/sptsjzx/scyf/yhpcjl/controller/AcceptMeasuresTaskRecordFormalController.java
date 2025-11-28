package org.jeecg.modules.sptsjzx.scyf.yhpcjl.controller;

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
import org.jeecg.modules.sptsjzx.scyf.yhpcjl.entity.AcceptMeasuresTaskRecordFormal;
import org.jeecg.modules.sptsjzx.scyf.yhpcjl.service.IAcceptMeasuresTaskRecordFormalService;

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
 * @Description: 隐患排查记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="隐患排查记录")
@RestController
@RequestMapping("/sptsjzx/scyf/yhpcjl/acceptMeasuresTaskRecordFormal")
@Slf4j
public class AcceptMeasuresTaskRecordFormalController extends JeecgController<AcceptMeasuresTaskRecordFormal, IAcceptMeasuresTaskRecordFormalService> {
	
	@Autowired
	private IAcceptMeasuresTaskRecordFormalService acceptMeasuresTaskRecordFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptMeasuresTaskRecordFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "隐患排查记录-分页列表查询")
	@ApiOperation(value="隐患排查记录-分页列表查询", notes="隐患排查记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptMeasuresTaskRecordFormal>> queryPageList(AcceptMeasuresTaskRecordFormal acceptMeasuresTaskRecordFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcceptMeasuresTaskRecordFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptMeasuresTaskRecordFormal, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = DataScopeHelper.getCompanyCodesByOrgCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptMeasuresTaskRecordFormal> page = new Page<AcceptMeasuresTaskRecordFormal>(pageNo, pageSize);
		IPage<AcceptMeasuresTaskRecordFormal> pageList = acceptMeasuresTaskRecordFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptMeasuresTaskRecordFormal
	 * @return
	 */
	@AutoLog(value = "隐患排查记录-添加")
	@ApiOperation(value="隐患排查记录-添加", notes="隐患排查记录-添加")
	@RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptMeasuresTaskRecordFormal acceptMeasuresTaskRecordFormal) {
		acceptMeasuresTaskRecordFormalService.save(acceptMeasuresTaskRecordFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptMeasuresTaskRecordFormal
	 * @return
	 */
	@AutoLog(value = "隐患排查记录-编辑")
	@ApiOperation(value="隐患排查记录-编辑", notes="隐患排查记录-编辑")
	@RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptMeasuresTaskRecordFormal acceptMeasuresTaskRecordFormal) {
		acceptMeasuresTaskRecordFormalService.updateById(acceptMeasuresTaskRecordFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "隐患排查记录-通过id删除")
	@ApiOperation(value="隐患排查记录-通过id删除", notes="隐患排查记录-通过id删除")
	@RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptMeasuresTaskRecordFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "隐患排查记录-批量删除")
	@ApiOperation(value="隐患排查记录-批量删除", notes="隐患排查记录-批量删除")
	@RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptMeasuresTaskRecordFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "隐患排查记录-通过id查询")
	@ApiOperation(value="隐患排查记录-通过id查询", notes="隐患排查记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptMeasuresTaskRecordFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptMeasuresTaskRecordFormal acceptMeasuresTaskRecordFormal = acceptMeasuresTaskRecordFormalService.getById(id);
		if(acceptMeasuresTaskRecordFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptMeasuresTaskRecordFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptMeasuresTaskRecordFormal
    */
    @RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptMeasuresTaskRecordFormal acceptMeasuresTaskRecordFormal) {
        return super.exportXls(request, acceptMeasuresTaskRecordFormal, AcceptMeasuresTaskRecordFormal.class, "隐患排查记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.scyf.yhpcjl:accept_measures_task_record_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptMeasuresTaskRecordFormal.class);
    }

}
