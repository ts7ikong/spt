package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx.entity.DevicePlatform;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx.service.IDevicePlatformService;

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
 * @Description: 装卸站台基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="装卸站台基础信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/zxztjcxx/devicePlatform")
@Slf4j
public class DevicePlatformController extends JeecgController<DevicePlatform, IDevicePlatformService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IDevicePlatformService devicePlatformService;
	
	/**
	 * 分页列表查询
	 *
	 * @param devicePlatform
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装卸站台基础信息-分页列表查询")
	@ApiOperation(value="装卸站台基础信息-分页列表查询", notes="装卸站台基础信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<DevicePlatform>> queryPageList(DevicePlatform devicePlatform,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("platformType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<DevicePlatform> queryWrapper = QueryGenerator.initQueryWrapper(devicePlatform, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<DevicePlatform> page = new Page<DevicePlatform>(pageNo, pageSize);
		IPage<DevicePlatform> pageList = devicePlatformService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param devicePlatform
	 * @return
	 */
	@AutoLog(value = "装卸站台基础信息-添加")
	@ApiOperation(value="装卸站台基础信息-添加", notes="装卸站台基础信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody DevicePlatform devicePlatform) {
		devicePlatformService.save(devicePlatform);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param devicePlatform
	 * @return
	 */
	@AutoLog(value = "装卸站台基础信息-编辑")
	@ApiOperation(value="装卸站台基础信息-编辑", notes="装卸站台基础信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody DevicePlatform devicePlatform) {
		devicePlatformService.updateById(devicePlatform);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装卸站台基础信息-通过id删除")
	@ApiOperation(value="装卸站台基础信息-通过id删除", notes="装卸站台基础信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		devicePlatformService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装卸站台基础信息-批量删除")
	@ApiOperation(value="装卸站台基础信息-批量删除", notes="装卸站台基础信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.devicePlatformService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装卸站台基础信息-通过id查询")
	@ApiOperation(value="装卸站台基础信息-通过id查询", notes="装卸站台基础信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<DevicePlatform> queryById(@RequestParam(name="id",required=true) String id) {
		DevicePlatform devicePlatform = devicePlatformService.getById(id);
		if(devicePlatform==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(devicePlatform);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param devicePlatform
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DevicePlatform devicePlatform) {
        return super.exportXls(request, devicePlatform, DevicePlatform.class, "装卸站台基础信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DevicePlatform.class);
    }

}
