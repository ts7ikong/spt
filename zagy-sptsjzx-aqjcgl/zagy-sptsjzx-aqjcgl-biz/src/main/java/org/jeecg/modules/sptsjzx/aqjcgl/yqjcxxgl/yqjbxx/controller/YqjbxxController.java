package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity.Yqjbxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 园区基本信息
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Api(tags="园区基本信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/aqscxzxkgl/yqjbxx/yqjbxx")
@Slf4j
public class YqjbxxController extends JeecgController<Yqjbxx, IYqjbxxService> {


	@Autowired
	private IYqjbxxService yqjbxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yqjbxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "园区基本信息-分页列表查询")
	@ApiOperation(value="园区基本信息-分页列表查询", notes="园区基本信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yqjbxx>> queryPageList(Yqjbxx yqjbxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yqjbxx> queryWrapper = QueryGenerator.initQueryWrapper(yqjbxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码过滤园区数据
		// yqjbxx表的park_area_code字段对应登录用户的orgCode
		DataScopeHelper.applyOrgCodeFilter(queryWrapper, "park_area_code");

		Page<Yqjbxx> page = new Page<Yqjbxx>(pageNo, pageSize);
		IPage<Yqjbxx> pageList = yqjbxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yqjbxx
	 * @return
	 */
	@AutoLog(value = "园区基本信息-添加")
	@ApiOperation(value="园区基本信息-添加", notes="园区基本信息-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yqjbxx yqjbxx) {
		yqjbxxService.savee(yqjbxx);
		return Result.XZ(yqjbxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yqjbxx
	 * @return
	 */
	@AutoLog(value = "园区基本信息-编辑")
	@ApiOperation(value="园区基本信息-编辑", notes="园区基本信息-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yqjbxx yqjbxx) {
		yqjbxxService.updateById(yqjbxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "园区基本信息-通过id删除")
	@ApiOperation(value="园区基本信息-通过id删除", notes="园区基本信息-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yqjbxxService.removeByIdd(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "园区基本信息-批量删除")
	@ApiOperation(value="园区基本信息-批量删除", notes="园区基本信息-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yqjbxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "园区基本信息-通过id查询")
	@ApiOperation(value="园区基本信息-通过id查询", notes="园区基本信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yqjbxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yqjbxx yqjbxx = yqjbxxService.getById(id);
		if(yqjbxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yqjbxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yqjbxx
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yqjbxx yqjbxx) {
        return super.exportXls(request, yqjbxx, Yqjbxx.class, "园区基本信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.yqjbxx:yqjbxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return yqjbxxService.importExcel(request, response, Yqjbxx.class);
    }

}
