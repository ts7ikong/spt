package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.entity.Qysgsj;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.service.IQysgsjService;

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
 * @Description: 企业事故事件
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="企业事故事件")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/qysgsj/qysgsj")
@Slf4j
public class QysgsjController extends JeecgController<Qysgsj, IQysgsjService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IQysgsjService qysgsjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param qysgsj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "企业事故事件-分页列表查询")
	@ApiOperation(value="企业事故事件-分页列表查询", notes="企业事故事件-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Qysgsj>> queryPageList(Qysgsj qysgsj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("typeOfAccident", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("accidentLevel", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("dispositionStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("registrationStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Qysgsj> queryWrapper = QueryGenerator.initQueryWrapper(qysgsj, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表
		// 实体只有companyCode字段，需要先查询企业表获取企业编码列表
		if (DataScopeHelper.needDataScope()) {
			// 区县账号：只能查看本区县的企业数据
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

			// 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
			String requestCompanyCode = qysgsj.getCompanyCode();
			if (requestCompanyCode != null && !requestCompanyCode.isEmpty()) {
				if (companyCodes == null || !companyCodes.contains(requestCompanyCode)) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				// 企业在权限范围内，只查询该企业的数据（QueryGenerator已经添加了companyCode条件）
			} else {
				// 没有指定企业，使用企业编码列表过滤数据
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
			}
		}
		// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
		Page<Qysgsj> page = new Page<Qysgsj>(pageNo, pageSize);
		IPage<Qysgsj> pageList = qysgsjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param qysgsj
	 * @return
	 */
	@AutoLog(value = "企业事故事件-添加")
	@ApiOperation(value="企业事故事件-添加", notes="企业事故事件-添加")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Qysgsj qysgsj) {
		qysgsjService.save(qysgsj);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param qysgsj
	 * @return
	 */
	@AutoLog(value = "企业事故事件-编辑")
	@ApiOperation(value="企业事故事件-编辑", notes="企业事故事件-编辑")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Qysgsj qysgsj) {
		qysgsjService.updateById(qysgsj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业事故事件-通过id删除")
	@ApiOperation(value="企业事故事件-通过id删除", notes="企业事故事件-通过id删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		qysgsjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业事故事件-批量删除")
	@ApiOperation(value="企业事故事件-批量删除", notes="企业事故事件-批量删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.qysgsjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业事故事件-通过id查询")
	@ApiOperation(value="企业事故事件-通过id查询", notes="企业事故事件-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Qysgsj> queryById(@RequestParam(name="id",required=true) String id) {
		Qysgsj qysgsj = qysgsjService.getById(id);
		if(qysgsj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(qysgsj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param qysgsj
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Qysgsj qysgsj) {
        return super.exportXls(request, qysgsj, Qysgsj.class, "企业事故事件");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qysgsj:qysgsj:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Qysgsj.class);
    }

}
