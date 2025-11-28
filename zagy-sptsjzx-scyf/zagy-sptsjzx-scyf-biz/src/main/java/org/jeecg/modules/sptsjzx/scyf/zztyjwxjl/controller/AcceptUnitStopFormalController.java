package org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.controller;

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
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.entity.AcceptUnitStopFormal;
import org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.service.IAcceptUnitStopFormalService;

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
 * @Description: 装置停用/检维修记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="装置停用/检维修记录")
@RestController
@RequestMapping("/sptsjzx/scyf/zztyjwxjl/acceptUnitStopFormal")
@Slf4j
public class AcceptUnitStopFormalController extends JeecgController<AcceptUnitStopFormal, IAcceptUnitStopFormalService> {
	@Autowired
	private IAcceptUnitStopFormalService acceptUnitStopFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptUnitStopFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装置停用/检维修记录-分页列表查询")
	@ApiOperation(value="装置停用/检维修记录-分页列表查询", notes="装置停用/检维修记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptUnitStopFormal>> queryPageList(AcceptUnitStopFormal acceptUnitStopFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcceptUnitStopFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptUnitStopFormal, req.getParameterMap());
		Page<AcceptUnitStopFormal> page = new Page<AcceptUnitStopFormal>(pageNo, pageSize);
		IPage<AcceptUnitStopFormal> pageList = acceptUnitStopFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptUnitStopFormal
	 * @return
	 */
	@AutoLog(value = "装置停用/检维修记录-添加")
	@ApiOperation(value="装置停用/检维修记录-添加", notes="装置停用/检维修记录-添加")
	@RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptUnitStopFormal acceptUnitStopFormal) {
		acceptUnitStopFormalService.save(acceptUnitStopFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptUnitStopFormal
	 * @return
	 */
	@AutoLog(value = "装置停用/检维修记录-编辑")
	@ApiOperation(value="装置停用/检维修记录-编辑", notes="装置停用/检维修记录-编辑")
	@RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptUnitStopFormal acceptUnitStopFormal) {
		acceptUnitStopFormalService.updateById(acceptUnitStopFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装置停用/检维修记录-通过id删除")
	@ApiOperation(value="装置停用/检维修记录-通过id删除", notes="装置停用/检维修记录-通过id删除")
	@RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptUnitStopFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装置停用/检维修记录-批量删除")
	@ApiOperation(value="装置停用/检维修记录-批量删除", notes="装置停用/检维修记录-批量删除")
	@RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptUnitStopFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装置停用/检维修记录-通过id查询")
	@ApiOperation(value="装置停用/检维修记录-通过id查询", notes="装置停用/检维修记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptUnitStopFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptUnitStopFormal acceptUnitStopFormal = acceptUnitStopFormalService.getById(id);
		if(acceptUnitStopFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptUnitStopFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptUnitStopFormal
    */
    @RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptUnitStopFormal acceptUnitStopFormal) {
        return super.exportXls(request, acceptUnitStopFormal, AcceptUnitStopFormal.class, "装置停用/检维修记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptUnitStopFormal.class);
    }

}
