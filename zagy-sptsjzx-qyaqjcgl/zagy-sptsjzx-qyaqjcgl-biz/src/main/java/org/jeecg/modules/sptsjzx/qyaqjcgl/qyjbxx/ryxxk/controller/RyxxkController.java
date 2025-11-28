package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.controller;

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
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.entity.Ryxxk;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.service.IRyxxkService;

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
 * @Description: 人员信息库
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="人员信息库")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/ryxxk/ryxxk")
@Slf4j
public class RyxxkController extends JeecgController<Ryxxk, IRyxxkService> {
	
	@Autowired
	private IRyxxkService ryxxkService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ryxxk
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "人员信息库-分页列表查询")
	@ApiOperation(value="人员信息库-分页列表查询", notes="人员信息库-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Ryxxk>> queryPageList(Ryxxk ryxxk,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("personType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("chemicalDiploma", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("certifiedSafetyEngineer", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Ryxxk> queryWrapper = QueryGenerator.initQueryWrapper(ryxxk, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = DataScopeHelper.getCompanyCodesByOrgCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<Ryxxk> page = new Page<Ryxxk>(pageNo, pageSize);
		IPage<Ryxxk> pageList = ryxxkService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ryxxk
	 * @return
	 */
	@AutoLog(value = "人员信息库-添加")
	@ApiOperation(value="人员信息库-添加", notes="人员信息库-添加")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Ryxxk ryxxk) {
		ryxxkService.save(ryxxk);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ryxxk
	 * @return
	 */
	@AutoLog(value = "人员信息库-编辑")
	@ApiOperation(value="人员信息库-编辑", notes="人员信息库-编辑")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Ryxxk ryxxk) {
		ryxxkService.updateById(ryxxk);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "人员信息库-通过id删除")
	@ApiOperation(value="人员信息库-通过id删除", notes="人员信息库-通过id删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ryxxkService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "人员信息库-批量删除")
	@ApiOperation(value="人员信息库-批量删除", notes="人员信息库-批量删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ryxxkService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "人员信息库-通过id查询")
	@ApiOperation(value="人员信息库-通过id查询", notes="人员信息库-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Ryxxk> queryById(@RequestParam(name="id",required=true) String id) {
		Ryxxk ryxxk = ryxxkService.getById(id);
		if(ryxxk==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ryxxk);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ryxxk
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Ryxxk ryxxk) {
        return super.exportXls(request, ryxxk, Ryxxk.class, "人员信息库");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Ryxxk.class);
    }

}
