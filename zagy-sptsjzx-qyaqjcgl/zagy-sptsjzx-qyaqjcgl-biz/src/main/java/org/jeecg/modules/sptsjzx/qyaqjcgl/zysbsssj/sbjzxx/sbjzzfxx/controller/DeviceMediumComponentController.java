package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx.entity.DeviceMediumComponent;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx.service.IDeviceMediumComponentService;

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
 * @Description: 设备介质组分信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="设备介质组分信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/zysbsssj/sbjzxx/sbjzzfxx/deviceMediumComponent")
@Slf4j
public class DeviceMediumComponentController extends JeecgController<DeviceMediumComponent, IDeviceMediumComponentService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IDeviceMediumComponentService deviceMediumComponentService;
	
	/**
	 * 分页列表查询
	 *
	 * @param deviceMediumComponent
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "设备介质组分信息-分页列表查询")
	@ApiOperation(value="设备介质组分信息-分页列表查询", notes="设备介质组分信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<DeviceMediumComponent>> queryPageList(DeviceMediumComponent deviceMediumComponent,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<DeviceMediumComponent> queryWrapper = QueryGenerator.initQueryWrapper(deviceMediumComponent, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<DeviceMediumComponent> page = new Page<DeviceMediumComponent>(pageNo, pageSize);
		IPage<DeviceMediumComponent> pageList = deviceMediumComponentService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param deviceMediumComponent
	 * @return
	 */
	@AutoLog(value = "设备介质组分信息-添加")
	@ApiOperation(value="设备介质组分信息-添加", notes="设备介质组分信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DeviceMediumComponent deviceMediumComponent) {
		deviceMediumComponentService.save(deviceMediumComponent);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param deviceMediumComponent
	 * @return
	 */
	@AutoLog(value = "设备介质组分信息-编辑")
	@ApiOperation(value="设备介质组分信息-编辑", notes="设备介质组分信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody DeviceMediumComponent deviceMediumComponent) {
		deviceMediumComponentService.updateById(deviceMediumComponent);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "设备介质组分信息-通过id删除")
	@ApiOperation(value="设备介质组分信息-通过id删除", notes="设备介质组分信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		deviceMediumComponentService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "设备介质组分信息-批量删除")
	@ApiOperation(value="设备介质组分信息-批量删除", notes="设备介质组分信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.deviceMediumComponentService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "设备介质组分信息-通过id查询")
	@ApiOperation(value="设备介质组分信息-通过id查询", notes="设备介质组分信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<DeviceMediumComponent> queryById(@RequestParam(name="id",required=true) String id) {
		DeviceMediumComponent deviceMediumComponent = deviceMediumComponentService.getById(id);
		if(deviceMediumComponent==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(deviceMediumComponent);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param deviceMediumComponent
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DeviceMediumComponent deviceMediumComponent) {
        return super.exportXls(request, deviceMediumComponent, DeviceMediumComponent.class, "设备介质组分信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.sbjzzfxx:device_medium_component:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DeviceMediumComponent.class);
    }

}
