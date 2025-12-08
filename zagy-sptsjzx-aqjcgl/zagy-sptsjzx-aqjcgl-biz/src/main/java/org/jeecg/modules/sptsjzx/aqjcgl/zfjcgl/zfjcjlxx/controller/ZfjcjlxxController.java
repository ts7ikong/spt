package org.jeecg.modules.sptsjzx.aqjcgl.zfjcgl.zfjcjlxx.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jxkml.entity.Jxkml;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.aqjcgl.zfjcgl.zfjcjlxx.entity.Zfjcjlxx;
import org.jeecg.modules.sptsjzx.aqjcgl.zfjcgl.zfjcjlxx.service.IZfjcjlxxService;

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
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

 /**
 * @Description: 执法检查记录信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="执法检查记录信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/zfjcgl/zfjcjlxx/zfjcjlxx")
@Slf4j
public class ZfjcjlxxController extends JeecgController<Zfjcjlxx, IZfjcjlxxService> {


	

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IZfjcjlxxService zfjcjlxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zfjcjlxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "执法检查记录信息-分页列表查询")
	@ApiOperation(value="执法检查记录信息-分页列表查询", notes="执法检查记录信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Zfjcjlxx>> queryPageList(Zfjcjlxx zfjcjlxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isLawEnforcement", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isSuspendReorganization", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isRequestClose", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isEconomicPenalty", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("register", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Zfjcjlxx> queryWrapper = QueryGenerator.initQueryWrapper(zfjcjlxx, req.getParameterMap(),customeRuleMap);
		// 【数据权限过滤】根据登录用户的区县编码获取企业列表
		// 实体只有companyCode字段，需要先查询企业表获取企业编码列表
		if (!DataScopeHelper.needDataScope()) {
			// 区县账号：只能查看本区县的企业数据
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> yqCodes = yqjbxxService.getYqCodesByCountyCode(orgCode);
			// 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
			String requestParkCode = zfjcjlxx.getParkCode();
			if (requestParkCode != null && !requestParkCode.isEmpty()) {
				if (yqCodes == null || !yqCodes.contains(requestParkCode)) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				// 企业在权限范围内，只查询该企业的数据（QueryGenerator已经添加了companyCode条件）
			} else {
				// 没有指定企业，使用企业编码列表过滤数据
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, yqCodes, "park_code");
			}
		} else {
			if (zfjcjlxx.getCountyCode() != null) {
				String orgCode = zfjcjlxx.getCountyCode();
				List<String> yqCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
				if (yqCodes == null) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, yqCodes, "park_code");
			}
		}
		// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
		Page<Zfjcjlxx> page = new Page<Zfjcjlxx>(pageNo, pageSize);
		IPage<Zfjcjlxx> pageList = zfjcjlxxService.page(page, queryWrapper);
		if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
			for (Zfjcjlxx item : pageList.getRecords()) {
				// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
				item.setCountyCode(item.getParkCode());
			}
		}
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zfjcjlxx
	 * @return
	 */
	@AutoLog(value = "执法检查记录信息-添加")
	@ApiOperation(value="执法检查记录信息-添加", notes="执法检查记录信息-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Zfjcjlxx zfjcjlxx) {
		zfjcjlxxService.save(zfjcjlxx);
		return Result.XZ(zfjcjlxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zfjcjlxx
	 * @return
	 */
	@AutoLog(value = "执法检查记录信息-编辑")
	@ApiOperation(value="执法检查记录信息-编辑", notes="执法检查记录信息-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Zfjcjlxx zfjcjlxx) {
		zfjcjlxxService.updateById(zfjcjlxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "执法检查记录信息-通过id删除")
	@ApiOperation(value="执法检查记录信息-通过id删除", notes="执法检查记录信息-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zfjcjlxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "执法检查记录信息-批量删除")
	@ApiOperation(value="执法检查记录信息-批量删除", notes="执法检查记录信息-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zfjcjlxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "执法检查记录信息-通过id查询")
	@ApiOperation(value="执法检查记录信息-通过id查询", notes="执法检查记录信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Zfjcjlxx> queryById(@RequestParam(name="id",required=true) String id) {
		Zfjcjlxx zfjcjlxx = zfjcjlxxService.getById(id);
		if(zfjcjlxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zfjcjlxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zfjcjlxx
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Zfjcjlxx zfjcjlxx) {
        return super.exportXls(request, zfjcjlxx, Zfjcjlxx.class, "执法检查记录信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Zfjcjlxx.class);
    }

}
