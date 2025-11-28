package org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjjydwxx.controller;

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
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjjydwxx.entity.Yjjydwxx;
import org.jeecg.modules.sptsjzx.mjyj.yjzysj.yjjydwxx.service.IYjjydwxxService;

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
 * @Description: 应急救援队伍信息
 * @Author: zagy-cg
 * @Date:   2025-06-02
 * @Version: V1.0
 */
@Api(tags="应急救援队伍信息")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjzysj/yjjydwxx/yjjydwxx")
@Slf4j
public class YjjydwxxController extends JeecgController<Yjjydwxx, IYjjydwxxService> {
	
		@Autowired
	private IYqjbxxService yqjbxxService;

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IYjjydwxxService yjjydwxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjjydwxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急救援队伍信息-分页列表查询")
	@ApiOperation(value="应急救援队伍信息-分页列表查询", notes="应急救援队伍信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjjydwxx>> queryPageList(Yjjydwxx yjjydwxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("unitType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjjydwxx> queryWrapper = QueryGenerator.initQueryWrapper(yjjydwxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Yjjydwxx> page = new Page<Yjjydwxx>(pageNo, pageSize);
		IPage<Yjjydwxx> pageList = yjjydwxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjjydwxx
	 * @return
	 */
	@AutoLog(value = "应急救援队伍信息-添加")
	@ApiOperation(value="应急救援队伍信息-添加", notes="应急救援队伍信息-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjjydwxx yjjydwxx) {
		yjjydwxxService.save(yjjydwxx);
		return Result.XZ(yjjydwxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjjydwxx
	 * @return
	 */
	@AutoLog(value = "应急救援队伍信息-编辑")
	@ApiOperation(value="应急救援队伍信息-编辑", notes="应急救援队伍信息-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjjydwxx yjjydwxx) {
		yjjydwxxService.updateById(yjjydwxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急救援队伍信息-通过id删除")
	@ApiOperation(value="应急救援队伍信息-通过id删除", notes="应急救援队伍信息-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjjydwxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急救援队伍信息-批量删除")
	@ApiOperation(value="应急救援队伍信息-批量删除", notes="应急救援队伍信息-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjjydwxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急救援队伍信息-通过id查询")
	@ApiOperation(value="应急救援队伍信息-通过id查询", notes="应急救援队伍信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjjydwxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yjjydwxx yjjydwxx = yjjydwxxService.getById(id);
		if(yjjydwxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjjydwxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjjydwxx
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjjydwxx yjjydwxx) {
        return super.exportXls(request, yjjydwxx, Yjjydwxx.class, "应急救援队伍信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjzysj.yjjydwxx:yjjydwxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjjydwxx.class);
    }

}
