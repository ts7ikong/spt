package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx.entity.Qylszdhygx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx.service.IQylszdhygxService;

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
 * @Description: 企业隶属重点行业关系
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="企业隶属重点行业关系")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/qylszdhygx/qylszdhygx")
@Slf4j
public class QylszdhygxController extends JeecgController<Qylszdhygx, IQylszdhygxService> {
	

	@Autowired
	private IAcceptCompanyService acceptCompanyService;
	
	@Autowired
	private IQylszdhygxService qylszdhygxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param qylszdhygx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "企业隶属重点行业关系-分页列表查询")
	@ApiOperation(value="企业隶属重点行业关系-分页列表查询", notes="企业隶属重点行业关系-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Qylszdhygx>> queryPageList(Qylszdhygx qylszdhygx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<Qylszdhygx> queryWrapper = QueryGenerator.initQueryWrapper(qylszdhygx, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<Qylszdhygx> page = new Page<Qylszdhygx>(pageNo, pageSize);
		IPage<Qylszdhygx> pageList = qylszdhygxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param qylszdhygx
	 * @return
	 */
	@AutoLog(value = "企业隶属重点行业关系-添加")
	@ApiOperation(value="企业隶属重点行业关系-添加", notes="企业隶属重点行业关系-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Qylszdhygx qylszdhygx) {
		qylszdhygxService.save(qylszdhygx);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param qylszdhygx
	 * @return
	 */
	@AutoLog(value = "企业隶属重点行业关系-编辑")
	@ApiOperation(value="企业隶属重点行业关系-编辑", notes="企业隶属重点行业关系-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Qylszdhygx qylszdhygx) {
		qylszdhygxService.updateById(qylszdhygx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业隶属重点行业关系-通过id删除")
	@ApiOperation(value="企业隶属重点行业关系-通过id删除", notes="企业隶属重点行业关系-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		qylszdhygxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业隶属重点行业关系-批量删除")
	@ApiOperation(value="企业隶属重点行业关系-批量删除", notes="企业隶属重点行业关系-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.qylszdhygxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业隶属重点行业关系-通过id查询")
	@ApiOperation(value="企业隶属重点行业关系-通过id查询", notes="企业隶属重点行业关系-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Qylszdhygx> queryById(@RequestParam(name="id",required=true) String id) {
		Qylszdhygx qylszdhygx = qylszdhygxService.getById(id);
		if(qylszdhygx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(qylszdhygx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param qylszdhygx
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Qylszdhygx qylszdhygx) {
        return super.exportXls(request, qylszdhygx, Qylszdhygx.class, "企业隶属重点行业关系");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Qylszdhygx.class);
    }

}
