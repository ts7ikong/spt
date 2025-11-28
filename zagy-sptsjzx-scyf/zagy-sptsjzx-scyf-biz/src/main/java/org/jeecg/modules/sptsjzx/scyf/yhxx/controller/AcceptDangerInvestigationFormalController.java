package org.jeecg.modules.sptsjzx.scyf.yhxx.controller;

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
import org.jeecg.modules.sptsjzx.scyf.yhxx.entity.AcceptDangerInvestigationFormal;
import org.jeecg.modules.sptsjzx.scyf.yhxx.service.IAcceptDangerInvestigationFormalService;

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
 * @Description: 隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="隐患信息")
@RestController
@RequestMapping("/sptsjzx/scyf/yhxx/acceptDangerInvestigationFormal")
@Slf4j
public class AcceptDangerInvestigationFormalController extends JeecgController<AcceptDangerInvestigationFormal, IAcceptDangerInvestigationFormalService> {
	@Autowired
	private IAcceptDangerInvestigationFormalService acceptDangerInvestigationFormalService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptDangerInvestigationFormal
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "隐患信息-分页列表查询")
	@ApiOperation(value="隐患信息-分页列表查询", notes="隐患信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptDangerInvestigationFormal>> queryPageList(AcceptDangerInvestigationFormal acceptDangerInvestigationFormal,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("dangerLevel", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("dangerSrc", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("dangerState", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("hazardDangerType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("hazardCategory", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcceptDangerInvestigationFormal> queryWrapper = QueryGenerator.initQueryWrapper(acceptDangerInvestigationFormal, req.getParameterMap(),customeRuleMap);
		Page<AcceptDangerInvestigationFormal> page = new Page<AcceptDangerInvestigationFormal>(pageNo, pageSize);
		IPage<AcceptDangerInvestigationFormal> pageList = acceptDangerInvestigationFormalService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptDangerInvestigationFormal
	 * @return
	 */
	@AutoLog(value = "隐患信息-添加")
	@ApiOperation(value="隐患信息-添加", notes="隐患信息-添加")
	//@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptDangerInvestigationFormal acceptDangerInvestigationFormal) {
		acceptDangerInvestigationFormalService.save(acceptDangerInvestigationFormal);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptDangerInvestigationFormal
	 * @return
	 */
	@AutoLog(value = "隐患信息-编辑")
	@ApiOperation(value="隐患信息-编辑", notes="隐患信息-编辑")
	//@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptDangerInvestigationFormal acceptDangerInvestigationFormal) {
		acceptDangerInvestigationFormalService.updateById(acceptDangerInvestigationFormal);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "隐患信息-通过id删除")
	@ApiOperation(value="隐患信息-通过id删除", notes="隐患信息-通过id删除")
	//@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptDangerInvestigationFormalService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "隐患信息-批量删除")
	@ApiOperation(value="隐患信息-批量删除", notes="隐患信息-批量删除")
	//@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptDangerInvestigationFormalService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "隐患信息-通过id查询")
	@ApiOperation(value="隐患信息-通过id查询", notes="隐患信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptDangerInvestigationFormal> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptDangerInvestigationFormal acceptDangerInvestigationFormal = acceptDangerInvestigationFormalService.getById(id);
		if(acceptDangerInvestigationFormal==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptDangerInvestigationFormal);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptDangerInvestigationFormal
    */
    //@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptDangerInvestigationFormal acceptDangerInvestigationFormal) {
        return super.exportXls(request, acceptDangerInvestigationFormal, AcceptDangerInvestigationFormal.class, "隐患信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.scyf.yhxx:accept_danger_investigation_formal:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptDangerInvestigationFormal.class);
    }

}
