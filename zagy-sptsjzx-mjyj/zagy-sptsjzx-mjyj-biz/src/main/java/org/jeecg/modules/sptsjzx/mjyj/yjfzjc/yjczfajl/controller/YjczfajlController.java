package org.jeecg.modules.sptsjzx.mjyj.yjfzjc.yjczfajl.controller;

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
import org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jyczgcjl.entity.Jyczgcjl;
import org.jeecg.modules.sptsjzx.mjyj.yjfzjc.yjczfajl.entity.Yjczfajl;
import org.jeecg.modules.sptsjzx.mjyj.yjfzjc.yjczfajl.service.IYjczfajlService;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;

 /**
 * @Description: 应急处置方案记录
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Api(tags="应急处置方案记录")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjfzjc/yjczfajl/yjczfajl")
@Slf4j
public class YjczfajlController extends JeecgController<Yjczfajl, IYjczfajlService> {

	@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IYjczfajlService yjczfajlService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjczfajl
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急处置方案记录-分页列表查询")
	@ApiOperation(value="应急处置方案记录-分页列表查询", notes="应急处置方案记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjczfajl>> queryPageList(Yjczfajl yjczfajl,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("materialId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("unitId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("shelterId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("institutionId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("serialCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("expertId", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjczfajl> queryWrapper = QueryGenerator.initQueryWrapper(yjczfajl, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表
		// 实体只有companyCode字段，需要先查询企业表获取企业编码列表
		if (!DataScopeHelper.needDataScope()) {
			// 区县账号：只能查看本区县的企业数据
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> yqCodes = yqjbxxService.getYqCodesByCountyCode(orgCode);
			// 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
			String requestParkCode = yjczfajl.getParkCode();
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
			if (yjczfajl.getCountyCode() != null) {
				String orgCode = yjczfajl.getCountyCode();
				List<String> yqCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
				if (yqCodes == null) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, yqCodes, "park_code");
			}
		}
		// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
		Page<Yjczfajl> page = new Page<Yjczfajl>(pageNo, pageSize);
		IPage<Yjczfajl> pageList = yjczfajlService.page(page, queryWrapper);
		if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
			for (Yjczfajl item : pageList.getRecords()) {
				// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
				item.setCountyCode(item.getParkCode());
			}
		}
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjczfajl
	 * @return
	 */
	@AutoLog(value = "应急处置方案记录-添加")
	@ApiOperation(value="应急处置方案记录-添加", notes="应急处置方案记录-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjczfajl yjczfajl) {
		yjczfajlService.save(yjczfajl);
		return Result.XZ(yjczfajl.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjczfajl
	 * @return
	 */
	@AutoLog(value = "应急处置方案记录-编辑")
	@ApiOperation(value="应急处置方案记录-编辑", notes="应急处置方案记录-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjczfajl yjczfajl) {
		yjczfajlService.updateById(yjczfajl);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急处置方案记录-通过id删除")
	@ApiOperation(value="应急处置方案记录-通过id删除", notes="应急处置方案记录-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjczfajlService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急处置方案记录-批量删除")
	@ApiOperation(value="应急处置方案记录-批量删除", notes="应急处置方案记录-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjczfajlService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急处置方案记录-通过id查询")
	@ApiOperation(value="应急处置方案记录-通过id查询", notes="应急处置方案记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjczfajl> queryById(@RequestParam(name="id",required=true) String id) {
		Yjczfajl yjczfajl = yjczfajlService.getById(id);
		if(yjczfajl==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjczfajl);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjczfajl
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjczfajl yjczfajl) {
        return super.exportXls(request, yjczfajl, Yjczfajl.class, "应急处置方案记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjczfajl.class);
    }

}
