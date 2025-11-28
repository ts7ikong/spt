package org.jeecg.modules.sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb.entity.Yrybydyhqtxljcgksb;
import org.jeecg.modules.sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb.service.IYrybydyhqtxljcgksbService;

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
 * @Description: 易燃易爆有毒有害气体泄漏监测管控设备
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Api(tags="易燃易爆有毒有害气体泄漏监测管控设备")
@RestController
@RequestMapping("/sptsjzx/qtxljcgkpt/yrybydyhqtxljcgksb/yrybydyhqtxljcgksb")
@Slf4j
public class YrybydyhqtxljcgksbController extends JeecgController<Yrybydyhqtxljcgksb, IYrybydyhqtxljcgksbService> {
	
		@Autowired
	private IYqjbxxService yqjbxxService;

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IYrybydyhqtxljcgksbService yrybydyhqtxljcgksbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yrybydyhqtxljcgksb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-分页列表查询")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-分页列表查询", notes="易燃易爆有毒有害气体泄漏监测管控设备-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yrybydyhqtxljcgksb>> queryPageList(Yrybydyhqtxljcgksb yrybydyhqtxljcgksb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("equipType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("equipStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yrybydyhqtxljcgksb> queryWrapper = QueryGenerator.initQueryWrapper(yrybydyhqtxljcgksb, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Yrybydyhqtxljcgksb> page = new Page<Yrybydyhqtxljcgksb>(pageNo, pageSize);
		IPage<Yrybydyhqtxljcgksb> pageList = yrybydyhqtxljcgksbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yrybydyhqtxljcgksb
	 * @return
	 */
	@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-添加")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-添加", notes="易燃易爆有毒有害气体泄漏监测管控设备-添加")
	//@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yrybydyhqtxljcgksb yrybydyhqtxljcgksb) {
		yrybydyhqtxljcgksbService.save(yrybydyhqtxljcgksb);
		return Result.XZ(yrybydyhqtxljcgksb.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yrybydyhqtxljcgksb
	 * @return
	 */
	@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-编辑")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-编辑", notes="易燃易爆有毒有害气体泄漏监测管控设备-编辑")
	//@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yrybydyhqtxljcgksb yrybydyhqtxljcgksb) {
		yrybydyhqtxljcgksbService.updateById(yrybydyhqtxljcgksb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-通过id删除")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-通过id删除", notes="易燃易爆有毒有害气体泄漏监测管控设备-通过id删除")
	//@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yrybydyhqtxljcgksbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-批量删除")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-批量删除", notes="易燃易爆有毒有害气体泄漏监测管控设备-批量删除")
	//@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yrybydyhqtxljcgksbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "易燃易爆有毒有害气体泄漏监测管控设备-通过id查询")
	@ApiOperation(value="易燃易爆有毒有害气体泄漏监测管控设备-通过id查询", notes="易燃易爆有毒有害气体泄漏监测管控设备-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yrybydyhqtxljcgksb> queryById(@RequestParam(name="id",required=true) String id) {
		Yrybydyhqtxljcgksb yrybydyhqtxljcgksb = yrybydyhqtxljcgksbService.getById(id);
		if(yrybydyhqtxljcgksb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yrybydyhqtxljcgksb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yrybydyhqtxljcgksb
    */
    //@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yrybydyhqtxljcgksb yrybydyhqtxljcgksb) {
        return super.exportXls(request, yrybydyhqtxljcgksb, Yrybydyhqtxljcgksb.class, "易燃易爆有毒有害气体泄漏监测管控设备");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yrybydyhqtxljcgksb.class);
    }

}
