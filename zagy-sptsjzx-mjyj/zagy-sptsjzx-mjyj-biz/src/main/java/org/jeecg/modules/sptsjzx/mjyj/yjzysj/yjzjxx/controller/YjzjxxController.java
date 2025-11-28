package org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjzjxx.controller;

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
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjzjxx.entity.Yjzjxx;
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjzjxx.service.IYjzjxxService;

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
 * @Description: 应急专家信息
 * @Author: zagy-cg
 * @Date:   2025-06-02
 * @Version: V1.0
 */
@Api(tags="应急专家信息")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjzysj/yjzjxx/yjzjxx")
@Slf4j
public class YjzjxxController extends JeecgController<Yjzjxx, IYjzjxxService> {
	@Autowired
	private IYjzjxxService yjzjxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjzjxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急专家信息-分页列表查询")
	@ApiOperation(value="应急专家信息-分页列表查询", notes="应急专家信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjzjxx>> queryPageList(Yjzjxx yjzjxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("gender", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjzjxx> queryWrapper = QueryGenerator.initQueryWrapper(yjzjxx, req.getParameterMap(),customeRuleMap);
		Page<Yjzjxx> page = new Page<Yjzjxx>(pageNo, pageSize);
		IPage<Yjzjxx> pageList = yjzjxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjzjxx
	 * @return
	 */
	@AutoLog(value = "应急专家信息-添加")
	@ApiOperation(value="应急专家信息-添加", notes="应急专家信息-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjzjxx yjzjxx) {
		yjzjxxService.save(yjzjxx);
		return Result.XZ(yjzjxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjzjxx
	 * @return
	 */
	@AutoLog(value = "应急专家信息-编辑")
	@ApiOperation(value="应急专家信息-编辑", notes="应急专家信息-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjzjxx yjzjxx) {
		yjzjxxService.updateById(yjzjxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急专家信息-通过id删除")
	@ApiOperation(value="应急专家信息-通过id删除", notes="应急专家信息-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjzjxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急专家信息-批量删除")
	@ApiOperation(value="应急专家信息-批量删除", notes="应急专家信息-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjzjxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急专家信息-通过id查询")
	@ApiOperation(value="应急专家信息-通过id查询", notes="应急专家信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjzjxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yjzjxx yjzjxx = yjzjxxService.getById(id);
		if(yjzjxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjzjxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjzjxx
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjzjxx yjzjxx) {
        return super.exportXls(request, yjzjxx, Yjzjxx.class, "应急专家信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjzjxx:yjzjxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjzjxx.class);
    }

}
