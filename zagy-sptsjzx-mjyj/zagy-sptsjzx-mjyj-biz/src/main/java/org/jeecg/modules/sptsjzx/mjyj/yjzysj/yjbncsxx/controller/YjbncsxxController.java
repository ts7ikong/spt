package org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjbncsxx.controller;

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
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjbncsxx.entity.Yjbncsxx;
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjbncsxx.service.IYjbncsxxService;

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
 * @Description: 应急避难场所信息
 * @Author: zagy-cg
 * @Date:   2025-06-02
 * @Version: V1.0
 */
@Api(tags="应急避难场所信息")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjzysj/yjbncsxx/yjbncsxx")
@Slf4j
public class YjbncsxxController extends JeecgController<Yjbncsxx, IYjbncsxxService> {
	@Autowired
	private IYjbncsxxService yjbncsxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjbncsxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急避难场所信息-分页列表查询")
	@ApiOperation(value="应急避难场所信息-分页列表查询", notes="应急避难场所信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjbncsxx>> queryPageList(Yjbncsxx yjbncsxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjbncsxx> queryWrapper = QueryGenerator.initQueryWrapper(yjbncsxx, req.getParameterMap(),customeRuleMap);
		Page<Yjbncsxx> page = new Page<Yjbncsxx>(pageNo, pageSize);
		IPage<Yjbncsxx> pageList = yjbncsxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjbncsxx
	 * @return
	 */
	@AutoLog(value = "应急避难场所信息-添加")
	@ApiOperation(value="应急避难场所信息-添加", notes="应急避难场所信息-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjbncsxx yjbncsxx) {
		yjbncsxxService.save(yjbncsxx);
		return Result.XZ(yjbncsxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjbncsxx
	 * @return
	 */
	@AutoLog(value = "应急避难场所信息-编辑")
	@ApiOperation(value="应急避难场所信息-编辑", notes="应急避难场所信息-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjbncsxx yjbncsxx) {
		yjbncsxxService.updateById(yjbncsxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急避难场所信息-通过id删除")
	@ApiOperation(value="应急避难场所信息-通过id删除", notes="应急避难场所信息-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjbncsxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急避难场所信息-批量删除")
	@ApiOperation(value="应急避难场所信息-批量删除", notes="应急避难场所信息-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjbncsxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急避难场所信息-通过id查询")
	@ApiOperation(value="应急避难场所信息-通过id查询", notes="应急避难场所信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjbncsxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yjbncsxx yjbncsxx = yjbncsxxService.getById(id);
		if(yjbncsxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjbncsxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjbncsxx
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjbncsxx yjbncsxx) {
        return super.exportXls(request, yjbncsxx, Yjbncsxx.class, "应急避难场所信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjbncsxx.class);
    }

}
