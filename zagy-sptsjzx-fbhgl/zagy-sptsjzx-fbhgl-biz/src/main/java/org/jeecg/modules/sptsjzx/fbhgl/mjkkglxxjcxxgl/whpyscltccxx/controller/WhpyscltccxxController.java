package org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx.controller;

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
import org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx.entity.Whpyscltccxx;
import org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx.service.IWhpyscltccxxService;

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
 * @Description: 危化品运输车辆停车场信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="危化品运输车辆停车场信息")
@RestController
@RequestMapping("/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpyscltccxx/whpyscltccxx")
@Slf4j
public class WhpyscltccxxController extends JeecgController<Whpyscltccxx, IWhpyscltccxxService> {
	
		@Autowired
	private IYqjbxxService yqjbxxService;

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IWhpyscltccxxService whpyscltccxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param whpyscltccxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "危化品运输车辆停车场信息-分页列表查询")
	@ApiOperation(value="危化品运输车辆停车场信息-分页列表查询", notes="危化品运输车辆停车场信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Whpyscltccxx>> queryPageList(Whpyscltccxx whpyscltccxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("openStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Whpyscltccxx> queryWrapper = QueryGenerator.initQueryWrapper(whpyscltccxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Whpyscltccxx> page = new Page<Whpyscltccxx>(pageNo, pageSize);
		IPage<Whpyscltccxx> pageList = whpyscltccxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param whpyscltccxx
	 * @return
	 */
	@AutoLog(value = "危化品运输车辆停车场信息-添加")
	@ApiOperation(value="危化品运输车辆停车场信息-添加", notes="危化品运输车辆停车场信息-添加")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Whpyscltccxx whpyscltccxx) {
		whpyscltccxxService.save(whpyscltccxx);
		return Result.XZ(whpyscltccxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param whpyscltccxx
	 * @return
	 */
	@AutoLog(value = "危化品运输车辆停车场信息-编辑")
	@ApiOperation(value="危化品运输车辆停车场信息-编辑", notes="危化品运输车辆停车场信息-编辑")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Whpyscltccxx whpyscltccxx) {
		whpyscltccxxService.updateById(whpyscltccxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "危化品运输车辆停车场信息-通过id删除")
	@ApiOperation(value="危化品运输车辆停车场信息-通过id删除", notes="危化品运输车辆停车场信息-通过id删除")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		whpyscltccxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "危化品运输车辆停车场信息-批量删除")
	@ApiOperation(value="危化品运输车辆停车场信息-批量删除", notes="危化品运输车辆停车场信息-批量删除")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.whpyscltccxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "危化品运输车辆停车场信息-通过id查询")
	@ApiOperation(value="危化品运输车辆停车场信息-通过id查询", notes="危化品运输车辆停车场信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Whpyscltccxx> queryById(@RequestParam(name="id",required=true) String id) {
		Whpyscltccxx whpyscltccxx = whpyscltccxxService.getById(id);
		if(whpyscltccxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(whpyscltccxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param whpyscltccxx
    */
    //@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Whpyscltccxx whpyscltccxx) {
        return super.exportXls(request, whpyscltccxx, Whpyscltccxx.class, "危化品运输车辆停车场信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Whpyscltccxx.class);
    }

}
