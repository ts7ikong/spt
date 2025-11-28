package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.entity.DeviceGasSensor;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.service.IDeviceGasSensorService;

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
 * @Description: 气体泄漏点监测信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="气体泄漏点监测信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/qtxldjcxx/deviceGasSensor")
@Slf4j
public class DeviceGasSensorController extends JeecgController<DeviceGasSensor, IDeviceGasSensorService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IDeviceGasSensorService deviceGasSensorService;
	
	/**
	 * 分页列表查询
	 *
	 * @param deviceGasSensor
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "气体泄漏点监测信息-分页列表查询")
	@ApiOperation(value="气体泄漏点监测信息-分页列表查询", notes="气体泄漏点监测信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<DeviceGasSensor>> queryPageList(DeviceGasSensor deviceGasSensor,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("monitorType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<DeviceGasSensor> queryWrapper = QueryGenerator.initQueryWrapper(deviceGasSensor, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<DeviceGasSensor> page = new Page<DeviceGasSensor>(pageNo, pageSize);
		IPage<DeviceGasSensor> pageList = deviceGasSensorService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param deviceGasSensor
	 * @return
	 */
	@AutoLog(value = "气体泄漏点监测信息-添加")
	@ApiOperation(value="气体泄漏点监测信息-添加", notes="气体泄漏点监测信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DeviceGasSensor deviceGasSensor) {
		deviceGasSensorService.save(deviceGasSensor);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param deviceGasSensor
	 * @return
	 */
	@AutoLog(value = "气体泄漏点监测信息-编辑")
	@ApiOperation(value="气体泄漏点监测信息-编辑", notes="气体泄漏点监测信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody DeviceGasSensor deviceGasSensor) {
		deviceGasSensorService.updateById(deviceGasSensor);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "气体泄漏点监测信息-通过id删除")
	@ApiOperation(value="气体泄漏点监测信息-通过id删除", notes="气体泄漏点监测信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		deviceGasSensorService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "气体泄漏点监测信息-批量删除")
	@ApiOperation(value="气体泄漏点监测信息-批量删除", notes="气体泄漏点监测信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.deviceGasSensorService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "气体泄漏点监测信息-通过id查询")
	@ApiOperation(value="气体泄漏点监测信息-通过id查询", notes="气体泄漏点监测信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<DeviceGasSensor> queryById(@RequestParam(name="id",required=true) String id) {
		DeviceGasSensor deviceGasSensor = deviceGasSensorService.getById(id);
		if(deviceGasSensor==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(deviceGasSensor);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param deviceGasSensor
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DeviceGasSensor deviceGasSensor) {
        return super.exportXls(request, deviceGasSensor, DeviceGasSensor.class, "气体泄漏点监测信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DeviceGasSensor.class);
    }

}
