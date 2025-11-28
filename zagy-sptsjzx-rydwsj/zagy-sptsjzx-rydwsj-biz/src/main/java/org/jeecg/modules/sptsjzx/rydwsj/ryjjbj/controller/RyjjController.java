package org.jeecg.modules.sptsjzx.rydwsj.ryjjbj.controller;

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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.sptsjzx.rydwsj.ryjjbj.entity.Ryjj;
import org.jeecg.modules.sptsjzx.rydwsj.ryjjbj.service.IRyjjService;
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
 * @Description: 人员聚集报警
 * @Author: zagy-cg
 * @Date:   2025-11-28
 * @Version: V1.0
 */
@Api(tags="人员聚集报警")
@RestController
@RequestMapping("/sptsjzx/rydwsj/ryjjbj/ryjj")
@Slf4j
public class RyjjController extends JeecgController<Ryjj, IRyjjService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IRyjjService ryjjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ryjj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "人员聚集报警-分页列表查询")
	@ApiOperation(value="人员聚集报警-分页列表查询", notes="人员聚集报警-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Ryjj>> queryPageList(Ryjj ryjj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<Ryjj> queryWrapper = QueryGenerator.initQueryWrapper(ryjj, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<Ryjj> page = new Page<Ryjj>(pageNo, pageSize);
		IPage<Ryjj> pageList = ryjjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	 /**
	  * 根据聚集报警id查询聚集报警详情
	  *
	  * @param ryjj
	  * @param pageNo
	  * @param pageSize
	  * @param req
	  * @return
	  */
	 @ApiOperation(value="根据聚集报警id查询聚集报警详情", notes="根据聚集报警id查询聚集报警详情")
	 @GetMapping(value = "/getDById")
	 public Result<IPage<Ryjj>> getDById(Ryjj ryjj,
											  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
											  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
											  HttpServletRequest req) {
		 QueryWrapper<Ryjj> queryWrapper = QueryGenerator.initQueryWrapper(ryjj, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		 Page<Ryjj> page = new Page<Ryjj>(pageNo, pageSize);
		 IPage<Ryjj> pageList = ryjjService.page(page, queryWrapper);
		 return Result.OK(pageList);
	 }


	
	/**
	 *   添加
	 *
	 * @param ryjj
	 * @return
	 */
	@AutoLog(value = "人员聚集报警-添加")
	@ApiOperation(value="人员聚集报警-添加", notes="人员聚集报警-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Ryjj ryjj) {
		ryjjService.save(ryjj);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ryjj
	 * @return
	 */
	@AutoLog(value = "人员聚集报警-编辑")
	@ApiOperation(value="人员聚集报警-编辑", notes="人员聚集报警-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Ryjj ryjj) {
		ryjjService.updateById(ryjj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "人员聚集报警-通过id删除")
	@ApiOperation(value="人员聚集报警-通过id删除", notes="人员聚集报警-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ryjjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "人员聚集报警-批量删除")
	@ApiOperation(value="人员聚集报警-批量删除", notes="人员聚集报警-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ryjjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "人员聚集报警-通过id查询")
	@ApiOperation(value="人员聚集报警-通过id查询", notes="人员聚集报警-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Ryjj> queryById(@RequestParam(name="id",required=true) String id) {
		Ryjj ryjj = ryjjService.getById(id);
		if(ryjj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ryjj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ryjj
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Ryjj ryjj) {
        return super.exportXls(request, ryjj, Ryjj.class, "人员聚集报警");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Ryjj.class);
    }

}
