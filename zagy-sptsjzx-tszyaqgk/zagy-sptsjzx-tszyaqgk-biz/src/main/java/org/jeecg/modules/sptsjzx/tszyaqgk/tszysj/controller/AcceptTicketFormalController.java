package org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.controller;

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
import org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.entity.AcceptTicketFormal;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.service.IAcceptTicketFormalService;

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
 * @Description: 特殊作业数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="特殊作业数据")
@RestController
@RequestMapping("/sptsjzx/tszyaqgk/tszysj/acceptTicketFormal")
@Slf4j
public class AcceptTicketFormalController extends JeecgController<AcceptTicketFormal, IAcceptTicketFormalService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptTicketFormalService acceptTicketFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptTicketFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "特殊作业数据-分页列表查询")
	@ApiOperation(value="特殊作业数据-分页列表查询", notes="特殊作业数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptTicketFormal>> queryPageList(AcceptTicketFormal acceptTicketFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("ticketType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("ticketStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("isContractorWork", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcceptTicketFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptTicketFormal, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptTicketFormal> page = new Page<AcceptTicketFormal>(pageNo, pageSize);
		IPage<AcceptTicketFormal> pageList = acceptTicketFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptTicketFormal
	 * @return
	 */
	@AutoLog(value = "特殊作业数据-添加")
	@ApiOperation(value="特殊作业数据-添加", notes="特殊作业数据-添加")
	//@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptTicketFormal acceptTicketFormal) {
		acceptTicketFormalService.save(acceptTicketFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptTicketFormal
	 * @return
	 */
	@AutoLog(value = "特殊作业数据-编辑")
	@ApiOperation(value="特殊作业数据-编辑", notes="特殊作业数据-编辑")
	//@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptTicketFormal acceptTicketFormal) {
		acceptTicketFormalService.updateById(acceptTicketFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "特殊作业数据-通过id删除")
	@ApiOperation(value="特殊作业数据-通过id删除", notes="特殊作业数据-通过id删除")
	//@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptTicketFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "特殊作业数据-批量删除")
	@ApiOperation(value="特殊作业数据-批量删除", notes="特殊作业数据-批量删除")
	//@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptTicketFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "特殊作业数据-通过id查询")
	@ApiOperation(value="特殊作业数据-通过id查询", notes="特殊作业数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptTicketFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptTicketFormal acceptTicketFormal = acceptTicketFormalService.getById(id);
		if(acceptTicketFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptTicketFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptTicketFormal
    */
    //@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptTicketFormal acceptTicketFormal) {
        return super.exportXls(request, acceptTicketFormal, AcceptTicketFormal.class, "特殊作业数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.tszyaqgk.tszysj:accept_ticket_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptTicketFormal.class);
    }

}
