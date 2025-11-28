package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.controller;

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
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.entity.Jczbxx;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.service.IJczbxxService;

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
 * @Description: 监测指标信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="监测指标信息")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/zxjc/jczbxx/jczbxx")
@Slf4j
public class JczbxxController extends JeecgController<Jczbxx, IJczbxxService> {
	@Autowired
	private IJczbxxService jczbxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jczbxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "监测指标信息-分页列表查询")
	@ApiOperation(value="监测指标信息-分页列表查询", notes="监测指标信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Jczbxx>> queryPageList(Jczbxx jczbxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("targetType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Jczbxx> queryWrapper = QueryGenerator.initQueryWrapper(jczbxx, req.getParameterMap(),customeRuleMap);
		Page<Jczbxx> page = new Page<Jczbxx>(pageNo, pageSize);
		IPage<Jczbxx> pageList = jczbxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jczbxx
	 * @return
	 */
	@AutoLog(value = "监测指标信息-添加")
	@ApiOperation(value="监测指标信息-添加", notes="监测指标信息-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Jczbxx jczbxx) {
		jczbxxService.save(jczbxx);
		return Result.XZ(jczbxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jczbxx
	 * @return
	 */
	@AutoLog(value = "监测指标信息-编辑")
	@ApiOperation(value="监测指标信息-编辑", notes="监测指标信息-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Jczbxx jczbxx) {
		jczbxxService.updateById(jczbxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监测指标信息-通过id删除")
	@ApiOperation(value="监测指标信息-通过id删除", notes="监测指标信息-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jczbxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "监测指标信息-批量删除")
	@ApiOperation(value="监测指标信息-批量删除", notes="监测指标信息-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jczbxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "监测指标信息-通过id查询")
	@ApiOperation(value="监测指标信息-通过id查询", notes="监测指标信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Jczbxx> queryById(@RequestParam(name="id",required=true) String id) {
		Jczbxx jczbxx = jczbxxService.getById(id);
		if(jczbxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jczbxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jczbxx
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Jczbxx jczbxx) {
        return super.exportXls(request, jczbxx, Jczbxx.class, "监测指标信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Jczbxx.class);
    }

}
