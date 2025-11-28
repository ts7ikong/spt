package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb.controller;

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
import org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb.entity.Xcjlsb;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb.service.IXcjlsbService;

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
 * @Description: 巡查记录上报
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="巡查记录上报")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/xcjlsb")
@Slf4j
public class XcjlsbController extends JeecgController<Xcjlsb, IXcjlsbService> {
	@Autowired
	private IXcjlsbService xcjlsbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param xcjlsb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "巡查记录上报-分页列表查询")
	@ApiOperation(value="巡查记录上报-分页列表查询", notes="巡查记录上报-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Xcjlsb>> queryPageList(Xcjlsb xcjlsb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("inspectStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Xcjlsb> queryWrapper = QueryGenerator.initQueryWrapper(xcjlsb, req.getParameterMap(),customeRuleMap);
		Page<Xcjlsb> page = new Page<Xcjlsb>(pageNo, pageSize);
		IPage<Xcjlsb> pageList = xcjlsbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param xcjlsb
	 * @return
	 */
	@AutoLog(value = "巡查记录上报-添加")
	@ApiOperation(value="巡查记录上报-添加", notes="巡查记录上报-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Xcjlsb xcjlsb) {
		xcjlsbService.save(xcjlsb);
		return Result.XZ(xcjlsb.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param xcjlsb
	 * @return
	 */
	@AutoLog(value = "巡查记录上报-编辑")
	@ApiOperation(value="巡查记录上报-编辑", notes="巡查记录上报-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Xcjlsb xcjlsb) {
		xcjlsbService.updateById(xcjlsb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "巡查记录上报-通过id删除")
	@ApiOperation(value="巡查记录上报-通过id删除", notes="巡查记录上报-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		xcjlsbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "巡查记录上报-批量删除")
	@ApiOperation(value="巡查记录上报-批量删除", notes="巡查记录上报-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.xcjlsbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "巡查记录上报-通过id查询")
	@ApiOperation(value="巡查记录上报-通过id查询", notes="巡查记录上报-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Xcjlsb> queryById(@RequestParam(name="id",required=true) String id) {
		Xcjlsb xcjlsb = xcjlsbService.getById(id);
		if(xcjlsb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(xcjlsb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param xcjlsb
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Xcjlsb xcjlsb) {
        return super.exportXls(request, xcjlsb, Xcjlsb.class, "巡查记录上报");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Xcjlsb.class);
    }

}
