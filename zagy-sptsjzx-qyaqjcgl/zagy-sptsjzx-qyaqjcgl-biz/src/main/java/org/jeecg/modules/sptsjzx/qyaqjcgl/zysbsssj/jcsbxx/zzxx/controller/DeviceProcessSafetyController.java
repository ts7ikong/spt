package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx.entity.DeviceProcessSafety;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx.service.IDeviceProcessSafetyService;

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
 * @Description: 装置信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="装置信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/zzxx/deviceProcessSafety")
@Slf4j
public class DeviceProcessSafetyController extends JeecgController<DeviceProcessSafety, IDeviceProcessSafetyService> {
	@Autowired
	private IDeviceProcessSafetyService deviceProcessSafetyService;
	
	/**
	 * 分页列表查询
	 *
	 * @param deviceProcessSafety
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装置信息-分页列表查询")
	@ApiOperation(value="装置信息-分页列表查询", notes="装置信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<DeviceProcessSafety>> queryPageList(DeviceProcessSafety deviceProcessSafety,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<DeviceProcessSafety> queryWrapper = QueryGenerator.initQueryWrapper(deviceProcessSafety, req.getParameterMap());
		Page<DeviceProcessSafety> page = new Page<DeviceProcessSafety>(pageNo, pageSize);
		IPage<DeviceProcessSafety> pageList = deviceProcessSafetyService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param deviceProcessSafety
	 * @return
	 */
	@AutoLog(value = "装置信息-添加")
	@ApiOperation(value="装置信息-添加", notes="装置信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DeviceProcessSafety deviceProcessSafety) {
		deviceProcessSafetyService.save(deviceProcessSafety);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param deviceProcessSafety
	 * @return
	 */
	@AutoLog(value = "装置信息-编辑")
	@ApiOperation(value="装置信息-编辑", notes="装置信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody DeviceProcessSafety deviceProcessSafety) {
		deviceProcessSafetyService.updateById(deviceProcessSafety);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装置信息-通过id删除")
	@ApiOperation(value="装置信息-通过id删除", notes="装置信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		deviceProcessSafetyService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装置信息-批量删除")
	@ApiOperation(value="装置信息-批量删除", notes="装置信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.deviceProcessSafetyService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装置信息-通过id查询")
	@ApiOperation(value="装置信息-通过id查询", notes="装置信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<DeviceProcessSafety> queryById(@RequestParam(name="id",required=true) String id) {
		DeviceProcessSafety deviceProcessSafety = deviceProcessSafetyService.getById(id);
		if(deviceProcessSafety==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(deviceProcessSafety);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param deviceProcessSafety
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DeviceProcessSafety deviceProcessSafety) {
        return super.exportXls(request, deviceProcessSafety, DeviceProcessSafety.class, "装置信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zzxx:device_process_safety:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DeviceProcessSafety.class);
    }

}
