package org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx.controller;

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
import org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx.entity.Fkxx;
import org.jeecg.modules.sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx.service.IFkxxService;

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
 * @Description: 访客信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Api(tags="访客信息")
@RestController
@RequestMapping("/sptsjzx/fbhgl/mjkkglxxjcxxgl/fkxx/fkxx")
@Slf4j
public class FkxxController extends JeecgController<Fkxx, IFkxxService> {
	
		@Autowired
	private IYqjbxxService yqjbxxService;

	@Autowired
	private IFkxxService fkxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param fkxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "访客信息-分页列表查询")
	@ApiOperation(value="访客信息-分页列表查询", notes="访客信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Fkxx>> queryPageList(Fkxx fkxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("staffType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("staffGender", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Fkxx> queryWrapper = QueryGenerator.initQueryWrapper(fkxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Fkxx> page = new Page<Fkxx>(pageNo, pageSize);
		IPage<Fkxx> pageList = fkxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param fkxx
	 * @return
	 */
	@AutoLog(value = "访客信息-添加")
	@ApiOperation(value="访客信息-添加", notes="访客信息-添加")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Fkxx fkxx) {
		fkxxService.save(fkxx);
		return Result.XZ(fkxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param fkxx
	 * @return
	 */
	@AutoLog(value = "访客信息-编辑")
	@ApiOperation(value="访客信息-编辑", notes="访客信息-编辑")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Fkxx fkxx) {
		fkxxService.updateById(fkxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "访客信息-通过id删除")
	@ApiOperation(value="访客信息-通过id删除", notes="访客信息-通过id删除")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		fkxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "访客信息-批量删除")
	@ApiOperation(value="访客信息-批量删除", notes="访客信息-批量删除")
	//@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.fkxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "访客信息-通过id查询")
	@ApiOperation(value="访客信息-通过id查询", notes="访客信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Fkxx> queryById(@RequestParam(name="id",required=true) String id) {
		Fkxx fkxx = fkxxService.getById(id);
		if(fkxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(fkxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param fkxx
    */
    //@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Fkxx fkxx) {
        return super.exportXls(request, fkxx, Fkxx.class, "访客信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.fbhgl.mjkkglxxjcxxgl.fkxx:fkxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Fkxx.class);
    }

}
