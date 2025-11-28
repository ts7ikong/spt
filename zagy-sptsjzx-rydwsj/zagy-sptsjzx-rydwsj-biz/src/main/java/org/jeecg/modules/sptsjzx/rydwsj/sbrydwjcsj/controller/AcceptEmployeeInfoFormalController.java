package org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.controller;

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
import org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.entity.AcceptEmployeeInfoFormal;
import org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.service.IAcceptEmployeeInfoFormalService;

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
 * @Description: 上报人员定位基础数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="上报人员定位基础数据")
@RestController
@RequestMapping("/sptsjzx/rydwsj/sbrydwjcsj/acceptEmployeeInfoFormal")
@Slf4j
public class AcceptEmployeeInfoFormalController extends JeecgController<AcceptEmployeeInfoFormal, IAcceptEmployeeInfoFormalService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IAcceptEmployeeInfoFormalService acceptEmployeeInfoFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptEmployeeInfoFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "上报人员定位基础数据-分页列表查询")
	@ApiOperation(value="上报人员定位基础数据-分页列表查询", notes="上报人员定位基础数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptEmployeeInfoFormal>> queryPageList(AcceptEmployeeInfoFormal acceptEmployeeInfoFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("personType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcceptEmployeeInfoFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptEmployeeInfoFormal, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptEmployeeInfoFormal> page = new Page<AcceptEmployeeInfoFormal>(pageNo, pageSize);
		IPage<AcceptEmployeeInfoFormal> pageList = acceptEmployeeInfoFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptEmployeeInfoFormal
	 * @return
	 */
	@AutoLog(value = "上报人员定位基础数据-添加")
	@ApiOperation(value="上报人员定位基础数据-添加", notes="上报人员定位基础数据-添加")
	@RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptEmployeeInfoFormal acceptEmployeeInfoFormal) {
		acceptEmployeeInfoFormalService.save(acceptEmployeeInfoFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptEmployeeInfoFormal
	 * @return
	 */
	@AutoLog(value = "上报人员定位基础数据-编辑")
	@ApiOperation(value="上报人员定位基础数据-编辑", notes="上报人员定位基础数据-编辑")
	@RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptEmployeeInfoFormal acceptEmployeeInfoFormal) {
		acceptEmployeeInfoFormalService.updateById(acceptEmployeeInfoFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "上报人员定位基础数据-通过id删除")
	@ApiOperation(value="上报人员定位基础数据-通过id删除", notes="上报人员定位基础数据-通过id删除")
	@RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptEmployeeInfoFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "上报人员定位基础数据-批量删除")
	@ApiOperation(value="上报人员定位基础数据-批量删除", notes="上报人员定位基础数据-批量删除")
	@RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptEmployeeInfoFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "上报人员定位基础数据-通过id查询")
	@ApiOperation(value="上报人员定位基础数据-通过id查询", notes="上报人员定位基础数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptEmployeeInfoFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptEmployeeInfoFormal acceptEmployeeInfoFormal = acceptEmployeeInfoFormalService.getById(id);
		if(acceptEmployeeInfoFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptEmployeeInfoFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptEmployeeInfoFormal
    */
    @RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptEmployeeInfoFormal acceptEmployeeInfoFormal) {
        return super.exportXls(request, acceptEmployeeInfoFormal, AcceptEmployeeInfoFormal.class, "上报人员定位基础数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptEmployeeInfoFormal.class);
    }

}
