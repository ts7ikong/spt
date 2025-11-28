package org.jeecg.modules.sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj.controller;

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
import org.jeecg.modules.sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj.entity.Pjpgbgsj;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj.service.IPjpgbgsjService;

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
 * @Description: 评价/评估报告数据
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="评价/评估报告数据")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/pjpgbggljyhgl/pjpgbgsj/pjpgbgsj")
@Slf4j
public class PjpgbgsjController extends JeecgController<Pjpgbgsj, IPjpgbgsjService> {
	@Autowired
	private IPjpgbgsjService pjpgbgsjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param pjpgbgsj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "评价/评估报告数据-分页列表查询")
	@ApiOperation(value="评价/评估报告数据-分页列表查询", notes="评价/评估报告数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Pjpgbgsj>> queryPageList(Pjpgbgsj pjpgbgsj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("certificateType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Pjpgbgsj> queryWrapper = QueryGenerator.initQueryWrapper(pjpgbgsj, req.getParameterMap(),customeRuleMap);
		Page<Pjpgbgsj> page = new Page<Pjpgbgsj>(pageNo, pageSize);
		IPage<Pjpgbgsj> pageList = pjpgbgsjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param pjpgbgsj
	 * @return
	 */
	@AutoLog(value = "评价/评估报告数据-添加")
	@ApiOperation(value="评价/评估报告数据-添加", notes="评价/评估报告数据-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Pjpgbgsj pjpgbgsj) {
		pjpgbgsjService.save(pjpgbgsj);
		return Result.XZ(pjpgbgsj.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param pjpgbgsj
	 * @return
	 */
	@AutoLog(value = "评价/评估报告数据-编辑")
	@ApiOperation(value="评价/评估报告数据-编辑", notes="评价/评估报告数据-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Pjpgbgsj pjpgbgsj) {
		pjpgbgsjService.updateById(pjpgbgsj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "评价/评估报告数据-通过id删除")
	@ApiOperation(value="评价/评估报告数据-通过id删除", notes="评价/评估报告数据-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		pjpgbgsjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "评价/评估报告数据-批量删除")
	@ApiOperation(value="评价/评估报告数据-批量删除", notes="评价/评估报告数据-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.pjpgbgsjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "评价/评估报告数据-通过id查询")
	@ApiOperation(value="评价/评估报告数据-通过id查询", notes="评价/评估报告数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Pjpgbgsj> queryById(@RequestParam(name="id",required=true) String id) {
		Pjpgbgsj pjpgbgsj = pjpgbgsjService.getById(id);
		if(pjpgbgsj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(pjpgbgsj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param pjpgbgsj
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Pjpgbgsj pjpgbgsj) {
        return super.exportXls(request, pjpgbgsj, Pjpgbgsj.class, "评价/评估报告数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Pjpgbgsj.class);
    }

}
