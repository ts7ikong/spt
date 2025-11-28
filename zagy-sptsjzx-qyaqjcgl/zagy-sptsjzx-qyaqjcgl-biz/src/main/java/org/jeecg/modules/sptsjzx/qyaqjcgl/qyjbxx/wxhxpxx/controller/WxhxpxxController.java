package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.entity.Wxhxpxx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.service.IWxhxpxxService;

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
 * @Description: 危险化学品信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="危险化学品信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/wxhxpxx/wxhxpxx")
@Slf4j
public class WxhxpxxController extends JeecgController<Wxhxpxx, IWxhxpxxService> {
	@Autowired
	private IWxhxpxxService wxhxpxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param wxhxpxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "危险化学品信息-分页列表查询")
	@ApiOperation(value="危险化学品信息-分页列表查询", notes="危险化学品信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Wxhxpxx>> queryPageList(Wxhxpxx wxhxpxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("chemicalType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Wxhxpxx> queryWrapper = QueryGenerator.initQueryWrapper(wxhxpxx, req.getParameterMap(),customeRuleMap);
		Page<Wxhxpxx> page = new Page<Wxhxpxx>(pageNo, pageSize);
		IPage<Wxhxpxx> pageList = wxhxpxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param wxhxpxx
	 * @return
	 */
	@AutoLog(value = "危险化学品信息-添加")
	@ApiOperation(value="危险化学品信息-添加", notes="危险化学品信息-添加")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Wxhxpxx wxhxpxx) {
		wxhxpxxService.save(wxhxpxx);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param wxhxpxx
	 * @return
	 */
	@AutoLog(value = "危险化学品信息-编辑")
	@ApiOperation(value="危险化学品信息-编辑", notes="危险化学品信息-编辑")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Wxhxpxx wxhxpxx) {
		wxhxpxxService.updateById(wxhxpxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "危险化学品信息-通过id删除")
	@ApiOperation(value="危险化学品信息-通过id删除", notes="危险化学品信息-通过id删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		wxhxpxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "危险化学品信息-批量删除")
	@ApiOperation(value="危险化学品信息-批量删除", notes="危险化学品信息-批量删除")
	//@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.wxhxpxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "危险化学品信息-通过id查询")
	@ApiOperation(value="危险化学品信息-通过id查询", notes="危险化学品信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Wxhxpxx> queryById(@RequestParam(name="id",required=true) String id) {
		Wxhxpxx wxhxpxx = wxhxpxxService.getById(id);
		if(wxhxpxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(wxhxpxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param wxhxpxx
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Wxhxpxx wxhxpxx) {
        return super.exportXls(request, wxhxpxx, Wxhxpxx.class, "危险化学品信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx:wxhxpxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Wxhxpxx.class);
    }

}
