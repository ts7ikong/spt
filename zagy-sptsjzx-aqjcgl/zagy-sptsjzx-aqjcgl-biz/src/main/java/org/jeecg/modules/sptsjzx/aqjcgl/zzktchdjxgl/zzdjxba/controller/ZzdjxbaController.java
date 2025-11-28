package org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba.entity.Zzdjxba;
import org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba.service.IZzdjxbaService;

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
 * @Description: 装置大检修备案
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Api(tags="装置大检修备案")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/zzktchdjxgl/zzdjxba/zzdjxba")
@Slf4j
public class ZzdjxbaController extends JeecgController<Zzdjxba, IZzdjxbaService> {
	@Autowired
	private IZzdjxbaService zzdjxbaService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zzdjxba
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装置大检修备案-分页列表查询")
	@ApiOperation(value="装置大检修备案-分页列表查询", notes="装置大检修备案-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Zzdjxba>> queryPageList(Zzdjxba zzdjxba,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Zzdjxba> queryWrapper = QueryGenerator.initQueryWrapper(zzdjxba, req.getParameterMap(),customeRuleMap);
		Page<Zzdjxba> page = new Page<Zzdjxba>(pageNo, pageSize);
		IPage<Zzdjxba> pageList = zzdjxbaService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zzdjxba
	 * @return
	 */
	@AutoLog(value = "装置大检修备案-添加")
	@ApiOperation(value="装置大检修备案-添加", notes="装置大检修备案-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Zzdjxba zzdjxba) {
		zzdjxbaService.save(zzdjxba);
		return Result.XZ(zzdjxba.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zzdjxba
	 * @return
	 */
	@AutoLog(value = "装置大检修备案-编辑")
	@ApiOperation(value="装置大检修备案-编辑", notes="装置大检修备案-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Zzdjxba zzdjxba) {
		zzdjxbaService.updateById(zzdjxba);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装置大检修备案-通过id删除")
	@ApiOperation(value="装置大检修备案-通过id删除", notes="装置大检修备案-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zzdjxbaService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装置大检修备案-批量删除")
	@ApiOperation(value="装置大检修备案-批量删除", notes="装置大检修备案-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zzdjxbaService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装置大检修备案-通过id查询")
	@ApiOperation(value="装置大检修备案-通过id查询", notes="装置大检修备案-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Zzdjxba> queryById(@RequestParam(name="id",required=true) String id) {
		Zzdjxba zzdjxba = zzdjxbaService.getById(id);
		if(zzdjxba==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zzdjxba);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zzdjxba
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Zzdjxba zzdjxba) {
        return super.exportXls(request, zzdjxba, Zzdjxba.class, "装置大检修备案");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba:zzdjxba:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Zzdjxba.class);
    }

}
