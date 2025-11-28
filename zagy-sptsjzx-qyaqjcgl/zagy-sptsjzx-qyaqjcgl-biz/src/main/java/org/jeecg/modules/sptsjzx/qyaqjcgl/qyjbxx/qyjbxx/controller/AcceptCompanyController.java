package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;

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
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="企业基本信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/qyjbxx/acceptCompany")
@Slf4j
public class AcceptCompanyController extends JeecgController<AcceptCompany, IAcceptCompanyService> {
	@Autowired
	private IAcceptCompanyService acceptCompanyService;

	 /**
	  * 查询企业接入统计
	  * @param countycode 区县编码
	  * @param yqType 园区类型
	  * @param isScqy 是否生产企业
	  * @return
	  */
	 @GetMapping("/accessStats")
	 public Result<?> getAccessStats(@RequestParam(required = false) String countycode,
									 @RequestParam(required = false) Integer yqType,
									 @RequestParam(required = false) Integer isScqy) {
		 Map<String, Object> stats = acceptCompanyService.getAccessStats(countycode, yqType, isScqy);
		 return Result.OK(stats);
	 }
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptCompany
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "企业基本信息-分页列表查询")
	@ApiOperation(value="企业基本信息-分页列表查询", notes="企业基本信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptCompany>> queryPageList(AcceptCompany acceptCompany,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
		customeRuleMap.put("name", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("countryname", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("yqType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isScqy", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isZdwxy", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isTjsk", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isTjzyp", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isCompanyTicket", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isCompanyAlarm", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcceptCompany> queryWrapper = QueryGenerator.initQueryWrapper(acceptCompany, req.getParameterMap(),customeRuleMap);
		Page<AcceptCompany> page = new Page<AcceptCompany>(pageNo, pageSize);
		IPage<AcceptCompany> pageList = acceptCompanyService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptCompany
	 * @return
	 */
	@AutoLog(value = "企业基本信息-添加")
	@ApiOperation(value="企业基本信息-添加", notes="企业基本信息-添加")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptCompany acceptCompany) {
		acceptCompanyService.save(acceptCompany);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptCompany
	 * @return
	 */
	@AutoLog(value = "企业基本信息-编辑")
	@ApiOperation(value="企业基本信息-编辑", notes="企业基本信息-编辑")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptCompany acceptCompany) {
		acceptCompanyService.updateById(acceptCompany);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业基本信息-通过id删除")
	@ApiOperation(value="企业基本信息-通过id删除", notes="企业基本信息-通过id删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptCompanyService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业基本信息-批量删除")
	@ApiOperation(value="企业基本信息-批量删除", notes="企业基本信息-批量删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptCompanyService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业基本信息-通过id查询")
	@ApiOperation(value="企业基本信息-通过id查询", notes="企业基本信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptCompany> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptCompany acceptCompany = acceptCompanyService.getById(id);
		if(acceptCompany==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptCompany);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptCompany
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptCompany acceptCompany) {
        return super.exportXls(request, acceptCompany, AcceptCompany.class, "企业基本信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qyjbxx:accept_company:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptCompany.class);
    }

}
