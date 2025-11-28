package org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jyczgcjl.controller;

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
import org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jyczgcjl.entity.Jyczgcjl;
import org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jyczgcjl.service.IJyczgcjlService;

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
 * @Description: 救援处置过程记录
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Api(tags="救援处置过程记录")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjfzjc/jyczgcjl/jyczgcjl")
@Slf4j
public class JyczgcjlController extends JeecgController<Jyczgcjl, IJyczgcjlService> {
	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IJyczgcjlService jyczgcjlService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jyczgcjl
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "救援处置过程记录-分页列表查询")
	@ApiOperation(value="救援处置过程记录-分页列表查询", notes="救援处置过程记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Jyczgcjl>> queryPageList(Jyczgcjl jyczgcjl,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Jyczgcjl> queryWrapper = QueryGenerator.initQueryWrapper(jyczgcjl, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Jyczgcjl> page = new Page<Jyczgcjl>(pageNo, pageSize);
		IPage<Jyczgcjl> pageList = jyczgcjlService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jyczgcjl
	 * @return
	 */
	@AutoLog(value = "救援处置过程记录-添加")
	@ApiOperation(value="救援处置过程记录-添加", notes="救援处置过程记录-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Jyczgcjl jyczgcjl) {
		jyczgcjlService.save(jyczgcjl);
		return Result.XZ(jyczgcjl.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jyczgcjl
	 * @return
	 */
	@AutoLog(value = "救援处置过程记录-编辑")
	@ApiOperation(value="救援处置过程记录-编辑", notes="救援处置过程记录-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Jyczgcjl jyczgcjl) {
		jyczgcjlService.updateById(jyczgcjl);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "救援处置过程记录-通过id删除")
	@ApiOperation(value="救援处置过程记录-通过id删除", notes="救援处置过程记录-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jyczgcjlService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "救援处置过程记录-批量删除")
	@ApiOperation(value="救援处置过程记录-批量删除", notes="救援处置过程记录-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jyczgcjlService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "救援处置过程记录-通过id查询")
	@ApiOperation(value="救援处置过程记录-通过id查询", notes="救援处置过程记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Jyczgcjl> queryById(@RequestParam(name="id",required=true) String id) {
		Jyczgcjl jyczgcjl = jyczgcjlService.getById(id);
		if(jyczgcjl==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jyczgcjl);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jyczgcjl
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Jyczgcjl jyczgcjl) {
        return super.exportXls(request, jyczgcjl, Jyczgcjl.class, "救援处置过程记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjfzjc.jyczgcjl:jyczgcjl:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Jyczgcjl.class);
    }

}
