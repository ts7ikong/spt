package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.entity.AcceptHazardCode;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.service.IAcceptHazardCodeService;

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
 * @Description: 重大危险源信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Api(tags="重大危险源信息")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode")
@Slf4j
public class AcceptHazardCodeController extends JeecgController<AcceptHazardCode, IAcceptHazardCodeService> {
	@Autowired
	private IAcceptHazardCodeService acceptHazardCodeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptHazardCode
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "重大危险源信息-分页列表查询")
	@ApiOperation(value="重大危险源信息-分页列表查询", notes="重大危险源信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptHazardCode>> queryPageList(AcceptHazardCode acceptHazardCode,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("level", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("hazardFactility", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<AcceptHazardCode> queryWrapper = QueryGenerator.initQueryWrapper(acceptHazardCode, req.getParameterMap(),customeRuleMap);
		Page<AcceptHazardCode> page = new Page<AcceptHazardCode>(pageNo, pageSize);
		IPage<AcceptHazardCode> pageList = acceptHazardCodeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptHazardCode
	 * @return
	 */
	@AutoLog(value = "重大危险源信息-添加")
	@ApiOperation(value="重大危险源信息-添加", notes="重大危险源信息-添加")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptHazardCode acceptHazardCode) {
		acceptHazardCodeService.save(acceptHazardCode);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptHazardCode
	 * @return
	 */
	@AutoLog(value = "重大危险源信息-编辑")
	@ApiOperation(value="重大危险源信息-编辑", notes="重大危险源信息-编辑")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptHazardCode acceptHazardCode) {
		acceptHazardCodeService.updateById(acceptHazardCode);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "重大危险源信息-通过id删除")
	@ApiOperation(value="重大危险源信息-通过id删除", notes="重大危险源信息-通过id删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptHazardCodeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "重大危险源信息-批量删除")
	@ApiOperation(value="重大危险源信息-批量删除", notes="重大危险源信息-批量删除")
	@RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptHazardCodeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "重大危险源信息-通过id查询")
	@ApiOperation(value="重大危险源信息-通过id查询", notes="重大危险源信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptHazardCode> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptHazardCode acceptHazardCode = acceptHazardCodeService.getById(id);
		if(acceptHazardCode==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptHazardCode);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptHazardCode
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptHazardCode acceptHazardCode) {
        return super.exportXls(request, acceptHazardCode, AcceptHazardCode.class, "重大危险源信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx:accept_hazard_code:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptHazardCode.class);
    }

}
