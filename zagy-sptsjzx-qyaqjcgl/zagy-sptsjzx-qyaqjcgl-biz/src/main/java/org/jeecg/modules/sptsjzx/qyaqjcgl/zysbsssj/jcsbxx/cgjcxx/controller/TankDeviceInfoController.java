package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.entity.TankDeviceInfo;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.service.ITankDeviceInfoService;

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
 * @Description: 储罐基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="储罐基础信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/cgjcxx/tankDeviceInfo")
@Slf4j
public class TankDeviceInfoController extends JeecgController<TankDeviceInfo, ITankDeviceInfoService> {
	@Autowired
	private ITankDeviceInfoService tankDeviceInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tankDeviceInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "储罐基础信息-分页列表查询")
	@ApiOperation(value="储罐基础信息-分页列表查询", notes="储罐基础信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TankDeviceInfo>> queryPageList(TankDeviceInfo tankDeviceInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("tankType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("pressureType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("temperatureType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("mediumStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<TankDeviceInfo> queryWrapper = QueryGenerator.initQueryWrapper(tankDeviceInfo, req.getParameterMap(),customeRuleMap);
		Page<TankDeviceInfo> page = new Page<TankDeviceInfo>(pageNo, pageSize);
		IPage<TankDeviceInfo> pageList = tankDeviceInfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tankDeviceInfo
	 * @return
	 */
	@AutoLog(value = "储罐基础信息-添加")
	@ApiOperation(value="储罐基础信息-添加", notes="储罐基础信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TankDeviceInfo tankDeviceInfo) {
		tankDeviceInfoService.save(tankDeviceInfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tankDeviceInfo
	 * @return
	 */
	@AutoLog(value = "储罐基础信息-编辑")
	@ApiOperation(value="储罐基础信息-编辑", notes="储罐基础信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TankDeviceInfo tankDeviceInfo) {
		tankDeviceInfoService.updateById(tankDeviceInfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "储罐基础信息-通过id删除")
	@ApiOperation(value="储罐基础信息-通过id删除", notes="储罐基础信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		tankDeviceInfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "储罐基础信息-批量删除")
	@ApiOperation(value="储罐基础信息-批量删除", notes="储罐基础信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tankDeviceInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "储罐基础信息-通过id查询")
	@ApiOperation(value="储罐基础信息-通过id查询", notes="储罐基础信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TankDeviceInfo> queryById(@RequestParam(name="id",required=true) String id) {
		TankDeviceInfo tankDeviceInfo = tankDeviceInfoService.getById(id);
		if(tankDeviceInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(tankDeviceInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tankDeviceInfo
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TankDeviceInfo tankDeviceInfo) {
        return super.exportXls(request, tankDeviceInfo, TankDeviceInfo.class, "储罐基础信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TankDeviceInfo.class);
    }

}
