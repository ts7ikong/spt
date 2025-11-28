package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb.controller;

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
import org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb.entity.Ccqyjlsb;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb.service.ICcqyjlsbService;

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
 * @Description: 抽查企业记录上报
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="抽查企业记录上报")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjlsb/ccqyjlsb")
@Slf4j
public class CcqyjlsbController extends JeecgController<Ccqyjlsb, ICcqyjlsbService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private ICcqyjlsbService ccqyjlsbService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ccqyjlsb
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "抽查企业记录上报-分页列表查询")
	@ApiOperation(value="抽查企业记录上报-分页列表查询", notes="抽查企业记录上报-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Ccqyjlsb>> queryPageList(Ccqyjlsb ccqyjlsb,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("inspectStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("online", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("needVideoOnline", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("videoOnline", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("needWarnRank", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("needCommitStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("commitStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("needAlarmCount", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("needLastWeekWarnRank", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("lastWeekWarnRank", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Ccqyjlsb> queryWrapper = QueryGenerator.initQueryWrapper(ccqyjlsb, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<Ccqyjlsb> page = new Page<Ccqyjlsb>(pageNo, pageSize);
		IPage<Ccqyjlsb> pageList = ccqyjlsbService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ccqyjlsb
	 * @return
	 */
	@AutoLog(value = "抽查企业记录上报-添加")
	@ApiOperation(value="抽查企业记录上报-添加", notes="抽查企业记录上报-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Ccqyjlsb ccqyjlsb) {
		ccqyjlsbService.save(ccqyjlsb);
		return Result.XZ(ccqyjlsb.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ccqyjlsb
	 * @return
	 */
	@AutoLog(value = "抽查企业记录上报-编辑")
	@ApiOperation(value="抽查企业记录上报-编辑", notes="抽查企业记录上报-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Ccqyjlsb ccqyjlsb) {
		ccqyjlsbService.updateById(ccqyjlsb);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "抽查企业记录上报-通过id删除")
	@ApiOperation(value="抽查企业记录上报-通过id删除", notes="抽查企业记录上报-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ccqyjlsbService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "抽查企业记录上报-批量删除")
	@ApiOperation(value="抽查企业记录上报-批量删除", notes="抽查企业记录上报-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ccqyjlsbService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "抽查企业记录上报-通过id查询")
	@ApiOperation(value="抽查企业记录上报-通过id查询", notes="抽查企业记录上报-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Ccqyjlsb> queryById(@RequestParam(name="id",required=true) String id) {
		Ccqyjlsb ccqyjlsb = ccqyjlsbService.getById(id);
		if(ccqyjlsb==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ccqyjlsb);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ccqyjlsb
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Ccqyjlsb ccqyjlsb) {
        return super.exportXls(request, ccqyjlsb, Ccqyjlsb.class, "抽查企业记录上报");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb:ccqyjlsb:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Ccqyjlsb.class);
    }

}
