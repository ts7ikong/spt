package org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl.entity.Dsfdwwgjl;
import org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl.service.IDsfdwwgjlService;

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
 * @Description: 第三方单位违规记录
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="第三方单位违规记录")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/dsfdwgl/dsfdwwgjl/dsfdwwgjl")
@Slf4j
public class DsfdwwgjlController extends JeecgController<Dsfdwwgjl, IDsfdwwgjlService> {
	@Autowired
	private IDsfdwwgjlService dsfdwwgjlService;
	
	/**
	 * 分页列表查询
	 *
	 * @param dsfdwwgjl
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "第三方单位违规记录-分页列表查询")
	@ApiOperation(value="第三方单位违规记录-分页列表查询", notes="第三方单位违规记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Dsfdwwgjl>> queryPageList(Dsfdwwgjl dsfdwwgjl,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Dsfdwwgjl> queryWrapper = QueryGenerator.initQueryWrapper(dsfdwwgjl, req.getParameterMap(),customeRuleMap);
		Page<Dsfdwwgjl> page = new Page<Dsfdwwgjl>(pageNo, pageSize);
		IPage<Dsfdwwgjl> pageList = dsfdwwgjlService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param dsfdwwgjl
	 * @return
	 */
	@AutoLog(value = "第三方单位违规记录-添加")
	@ApiOperation(value="第三方单位违规记录-添加", notes="第三方单位违规记录-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Dsfdwwgjl dsfdwwgjl) {
		dsfdwwgjlService.save(dsfdwwgjl);
		return Result.XZ(dsfdwwgjl.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param dsfdwwgjl
	 * @return
	 */
	@AutoLog(value = "第三方单位违规记录-编辑")
	@ApiOperation(value="第三方单位违规记录-编辑", notes="第三方单位违规记录-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Dsfdwwgjl dsfdwwgjl) {
		dsfdwwgjlService.updateById(dsfdwwgjl);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "第三方单位违规记录-通过id删除")
	@ApiOperation(value="第三方单位违规记录-通过id删除", notes="第三方单位违规记录-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		dsfdwwgjlService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "第三方单位违规记录-批量删除")
	@ApiOperation(value="第三方单位违规记录-批量删除", notes="第三方单位违规记录-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.dsfdwwgjlService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "第三方单位违规记录-通过id查询")
	@ApiOperation(value="第三方单位违规记录-通过id查询", notes="第三方单位违规记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Dsfdwwgjl> queryById(@RequestParam(name="id",required=true) String id) {
		Dsfdwwgjl dsfdwwgjl = dsfdwwgjlService.getById(id);
		if(dsfdwwgjl==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(dsfdwwgjl);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param dsfdwwgjl
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Dsfdwwgjl dsfdwwgjl) {
        return super.exportXls(request, dsfdwwgjl, Dsfdwwgjl.class, "第三方单位违规记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwwgjl:dsfdwwgjl:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Dsfdwwgjl.class);
    }

}
