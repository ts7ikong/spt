package org.jeecg.modules.sptsjzx.fbhgl.txsjgl.rysstxsj.controller;

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
import org.jeecg.modules.sptsjzx.fbhgl.txsjgl.rysstxsj.entity.Rysstxsj;
import org.jeecg.modules.sptsjzx.fbhgl.txsjgl.rysstxsj.service.IRysstxsjService;

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
 * @Description: 人员实时通行数据
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="人员实时通行数据")
@RestController
@RequestMapping("/sptsjzx/fbhgl/txsjgl/rysstxsj/rysstxsj")
@Slf4j
public class RysstxsjController extends JeecgController<Rysstxsj, IRysstxsjService> {
	@Autowired
	private IRysstxsjService rysstxsjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param rysstxsj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "人员实时通行数据-分页列表查询")
	@ApiOperation(value="人员实时通行数据-分页列表查询", notes="人员实时通行数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Rysstxsj>> queryPageList(Rysstxsj rysstxsj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("staffType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("passType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Rysstxsj> queryWrapper = QueryGenerator.initQueryWrapper(rysstxsj, req.getParameterMap(),customeRuleMap);
		Page<Rysstxsj> page = new Page<Rysstxsj>(pageNo, pageSize);
		IPage<Rysstxsj> pageList = rysstxsjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param rysstxsj
	 * @return
	 */
	@AutoLog(value = "人员实时通行数据-添加")
	@ApiOperation(value="人员实时通行数据-添加", notes="人员实时通行数据-添加")
	//@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Rysstxsj rysstxsj) {
		rysstxsjService.save(rysstxsj);
		return Result.XZ(rysstxsj.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param rysstxsj
	 * @return
	 */
	@AutoLog(value = "人员实时通行数据-编辑")
	@ApiOperation(value="人员实时通行数据-编辑", notes="人员实时通行数据-编辑")
	//@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Rysstxsj rysstxsj) {
		rysstxsjService.updateById(rysstxsj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "人员实时通行数据-通过id删除")
	@ApiOperation(value="人员实时通行数据-通过id删除", notes="人员实时通行数据-通过id删除")
	//@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		rysstxsjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "人员实时通行数据-批量删除")
	@ApiOperation(value="人员实时通行数据-批量删除", notes="人员实时通行数据-批量删除")
	//@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.rysstxsjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "人员实时通行数据-通过id查询")
	@ApiOperation(value="人员实时通行数据-通过id查询", notes="人员实时通行数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Rysstxsj> queryById(@RequestParam(name="id",required=true) String id) {
		Rysstxsj rysstxsj = rysstxsjService.getById(id);
		if(rysstxsj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(rysstxsj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param rysstxsj
    */
    //@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Rysstxsj rysstxsj) {
        return super.exportXls(request, rysstxsj, Rysstxsj.class, "人员实时通行数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.fbhgl.txsjgl.rysstxsj:rysstxsj:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Rysstxsj.class);
    }

}
