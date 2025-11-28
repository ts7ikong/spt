package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jxkml.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jxkml.entity.Jxkml;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.jxkml.service.IJxkmlService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 禁限控目录
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Api(tags="禁限控目录")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/aqscxzxkgl/jxkml/jxkml")
@Slf4j
public class JxkmlController extends JeecgController<Jxkml, IJxkmlService> {
	
	@Autowired
	private IJxkmlService jxkmlService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jxkml
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "禁限控目录-分页列表查询")
	@ApiOperation(value="禁限控目录-分页列表查询", notes="禁限控目录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Jxkml>> queryPageList(Jxkml jxkml,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("productType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("catalogType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Jxkml> queryWrapper = QueryGenerator.initQueryWrapper(jxkml, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> parkCodes = DataScopeHelper.getParkCodesByOrgCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Jxkml> page = new Page<Jxkml>(pageNo, pageSize);
		IPage<Jxkml> pageList = jxkmlService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jxkml
	 * @return
	 */
	@AutoLog(value = "禁限控目录-添加")
	@ApiOperation(value="禁限控目录-添加", notes="禁限控目录-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Jxkml jxkml) {
		jxkmlService.save(jxkml);
		return Result.XZ(jxkml.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jxkml
	 * @return
	 */
	@AutoLog(value = "禁限控目录-编辑")
	@ApiOperation(value="禁限控目录-编辑", notes="禁限控目录-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Jxkml jxkml) {
		jxkmlService.updateById(jxkml);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "禁限控目录-通过id删除")
	@ApiOperation(value="禁限控目录-通过id删除", notes="禁限控目录-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jxkmlService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "禁限控目录-批量删除")
	@ApiOperation(value="禁限控目录-批量删除", notes="禁限控目录-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jxkmlService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "禁限控目录-通过id查询")
	@ApiOperation(value="禁限控目录-通过id查询", notes="禁限控目录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Jxkml> queryById(@RequestParam(name="id",required=true) String id) {
		Jxkml jxkml = jxkmlService.getById(id);
		if(jxkml==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jxkml);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jxkml
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Jxkml jxkml) {
        return super.exportXls(request, jxkml, Jxkml.class, "禁限控目录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.jxkml:jxkml:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Jxkml.class);
    }

}
