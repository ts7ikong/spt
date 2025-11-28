package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jcsbxx.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jcsbxx.entity.Jcsbxx;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jcsbxx.service.IJcsbxxService;

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
 * @Description: 监测设备信息
 * @Author: zagy-cg
 * @Date:   2025-06-04
 * @Version: V1.0
 */
@Api(tags="监测设备信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/yqjcxxgl/jcsbxx/jcsbxx")
@Slf4j
public class JcsbxxController extends JeecgController<Jcsbxx, IJcsbxxService> {
	@Autowired
	private IJcsbxxService jcsbxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jcsbxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "监测设备信息-分页列表查询")
	@ApiOperation(value="监测设备信息-分页列表查询", notes="监测设备信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Jcsbxx>> queryPageList(Jcsbxx jcsbxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("equipType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("equipStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Jcsbxx> queryWrapper = QueryGenerator.initQueryWrapper(jcsbxx, req.getParameterMap(),customeRuleMap);
		Page<Jcsbxx> page = new Page<Jcsbxx>(pageNo, pageSize);
		IPage<Jcsbxx> pageList = jcsbxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jcsbxx
	 * @return
	 */
	@AutoLog(value = "监测设备信息-添加")
	@ApiOperation(value="监测设备信息-添加", notes="监测设备信息-添加")
	@RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Jcsbxx jcsbxx) {
		jcsbxxService.save(jcsbxx);
		return Result.XZ(jcsbxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jcsbxx
	 * @return
	 */
	@AutoLog(value = "监测设备信息-编辑")
	@ApiOperation(value="监测设备信息-编辑", notes="监测设备信息-编辑")
	@RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Jcsbxx jcsbxx) {
		jcsbxxService.updateById(jcsbxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监测设备信息-通过id删除")
	@ApiOperation(value="监测设备信息-通过id删除", notes="监测设备信息-通过id删除")
	@RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jcsbxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "监测设备信息-批量删除")
	@ApiOperation(value="监测设备信息-批量删除", notes="监测设备信息-批量删除")
	@RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jcsbxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "监测设备信息-通过id查询")
	@ApiOperation(value="监测设备信息-通过id查询", notes="监测设备信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Jcsbxx> queryById(@RequestParam(name="id",required=true) String id) {
		Jcsbxx jcsbxx = jcsbxxService.getById(id);
		if(jcsbxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jcsbxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jcsbxx
    */
    @RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Jcsbxx jcsbxx) {
        return super.exportXls(request, jcsbxx, Jcsbxx.class, "监测设备信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.aqjcgl.yqjcxxgl.jcsbxx:jcsbxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Jcsbxx.class);
    }

}
