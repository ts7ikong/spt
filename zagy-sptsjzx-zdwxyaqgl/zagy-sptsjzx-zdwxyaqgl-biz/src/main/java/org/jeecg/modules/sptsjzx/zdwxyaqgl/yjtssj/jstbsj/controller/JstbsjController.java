package org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.jstbsj.controller;

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
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.jstbsj.entity.Jstbsj;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.jstbsj.service.IJstbsjService;

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
 * @Description: 警示通报数据
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="警示通报数据")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/yjtssj/jstbsj/jstbsj")
@Slf4j
public class JstbsjController extends JeecgController<Jstbsj, IJstbsjService> {
	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IJstbsjService jstbsjService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jstbsj
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "警示通报数据-分页列表查询")
	@ApiOperation(value="警示通报数据-分页列表查询", notes="警示通报数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Jstbsj>> queryPageList(Jstbsj jstbsj,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<Jstbsj> queryWrapper = QueryGenerator.initQueryWrapper(jstbsj, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Jstbsj> page = new Page<Jstbsj>(pageNo, pageSize);
		IPage<Jstbsj> pageList = jstbsjService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jstbsj
	 * @return
	 */
	@AutoLog(value = "警示通报数据-添加")
	@ApiOperation(value="警示通报数据-添加", notes="警示通报数据-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Jstbsj jstbsj) {
		jstbsjService.save(jstbsj);
		return Result.XZ(jstbsj.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jstbsj
	 * @return
	 */
	@AutoLog(value = "警示通报数据-编辑")
	@ApiOperation(value="警示通报数据-编辑", notes="警示通报数据-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Jstbsj jstbsj) {
		jstbsjService.updateById(jstbsj);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "警示通报数据-通过id删除")
	@ApiOperation(value="警示通报数据-通过id删除", notes="警示通报数据-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jstbsjService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "警示通报数据-批量删除")
	@ApiOperation(value="警示通报数据-批量删除", notes="警示通报数据-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jstbsjService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "警示通报数据-通过id查询")
	@ApiOperation(value="警示通报数据-通过id查询", notes="警示通报数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Jstbsj> queryById(@RequestParam(name="id",required=true) String id) {
		Jstbsj jstbsj = jstbsjService.getById(id);
		if(jstbsj==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jstbsj);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jstbsj
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Jstbsj jstbsj) {
        return super.exportXls(request, jstbsj, Jstbsj.class, "警示通报数据");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Jstbsj.class);
    }

}
