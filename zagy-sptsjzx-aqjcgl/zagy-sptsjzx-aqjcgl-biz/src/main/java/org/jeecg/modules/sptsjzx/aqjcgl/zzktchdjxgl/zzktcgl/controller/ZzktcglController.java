package org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl.entity.Zzktcgl;
import org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl.service.IZzktcglService;

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
 * @Description: 装置开停车管理
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Api(tags="装置开停车管理")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/zzktchdjxgl/zzktcgl/zzktcgl")
@Slf4j
public class ZzktcglController extends JeecgController<Zzktcgl, IZzktcglService> {
	@Autowired
	private IZzktcglService zzktcglService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zzktcgl
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装置开停车管理-分页列表查询")
	@ApiOperation(value="装置开停车管理-分页列表查询", notes="装置开停车管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Zzktcgl>> queryPageList(Zzktcgl zzktcgl,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("startStopType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("operationStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Zzktcgl> queryWrapper = QueryGenerator.initQueryWrapper(zzktcgl, req.getParameterMap(),customeRuleMap);
		Page<Zzktcgl> page = new Page<Zzktcgl>(pageNo, pageSize);
		IPage<Zzktcgl> pageList = zzktcglService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zzktcgl
	 * @return
	 */
	@AutoLog(value = "装置开停车管理-添加")
	@ApiOperation(value="装置开停车管理-添加", notes="装置开停车管理-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Zzktcgl zzktcgl) {
		zzktcglService.save(zzktcgl);
		return Result.XZ(zzktcgl.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zzktcgl
	 * @return
	 */
	@AutoLog(value = "装置开停车管理-编辑")
	@ApiOperation(value="装置开停车管理-编辑", notes="装置开停车管理-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Zzktcgl zzktcgl) {
		zzktcglService.updateById(zzktcgl);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装置开停车管理-通过id删除")
	@ApiOperation(value="装置开停车管理-通过id删除", notes="装置开停车管理-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zzktcglService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装置开停车管理-批量删除")
	@ApiOperation(value="装置开停车管理-批量删除", notes="装置开停车管理-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zzktcglService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装置开停车管理-通过id查询")
	@ApiOperation(value="装置开停车管理-通过id查询", notes="装置开停车管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Zzktcgl> queryById(@RequestParam(name="id",required=true) String id) {
		Zzktcgl zzktcgl = zzktcglService.getById(id);
		if(zzktcgl==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zzktcgl);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zzktcgl
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Zzktcgl zzktcgl) {
        return super.exportXls(request, zzktcgl, Zzktcgl.class, "装置开停车管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Zzktcgl.class);
    }

}
