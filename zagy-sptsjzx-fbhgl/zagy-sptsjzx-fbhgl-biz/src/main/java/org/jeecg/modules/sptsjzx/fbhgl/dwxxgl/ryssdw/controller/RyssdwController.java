package org.jeecg.modules.sptsjzx.fbhgl.dwxxgl.ryssdw.controller;

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
import org.jeecg.modules.sptsjzx.fbhgl.dwxxgl.ryssdw.entity.Ryssdw;
import org.jeecg.modules.sptsjzx.fbhgl.dwxxgl.ryssdw.service.IRyssdwService;

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
 * @Description: 人员实时定位
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="人员实时定位")
@RestController
@RequestMapping("/sptsjzx/fbhgl/dwxxgl/ryssdw/ryssdw")
@Slf4j
public class RyssdwController extends JeecgController<Ryssdw, IRyssdwService> {
	@Autowired
	private IRyssdwService ryssdwService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ryssdw
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "人员实时定位-分页列表查询")
	@ApiOperation(value="人员实时定位-分页列表查询", notes="人员实时定位-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Ryssdw>> queryPageList(Ryssdw ryssdw,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Ryssdw> queryWrapper = QueryGenerator.initQueryWrapper(ryssdw, req.getParameterMap(),customeRuleMap);
		Page<Ryssdw> page = new Page<Ryssdw>(pageNo, pageSize);
		IPage<Ryssdw> pageList = ryssdwService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ryssdw
	 * @return
	 */
	@AutoLog(value = "人员实时定位-添加")
	@ApiOperation(value="人员实时定位-添加", notes="人员实时定位-添加")
	//@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Ryssdw ryssdw) {
		ryssdwService.save(ryssdw);
		return Result.XZ(ryssdw.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ryssdw
	 * @return
	 */
	@AutoLog(value = "人员实时定位-编辑")
	@ApiOperation(value="人员实时定位-编辑", notes="人员实时定位-编辑")
	//@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Ryssdw ryssdw) {
		ryssdwService.updateById(ryssdw);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "人员实时定位-通过id删除")
	@ApiOperation(value="人员实时定位-通过id删除", notes="人员实时定位-通过id删除")
	//@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ryssdwService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "人员实时定位-批量删除")
	@ApiOperation(value="人员实时定位-批量删除", notes="人员实时定位-批量删除")
	//@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ryssdwService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "人员实时定位-通过id查询")
	@ApiOperation(value="人员实时定位-通过id查询", notes="人员实时定位-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Ryssdw> queryById(@RequestParam(name="id",required=true) String id) {
		Ryssdw ryssdw = ryssdwService.getById(id);
		if(ryssdw==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ryssdw);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ryssdw
    */
    //@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Ryssdw ryssdw) {
        return super.exportXls(request, ryssdw, Ryssdw.class, "人员实时定位");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Ryssdw.class);
    }

}
