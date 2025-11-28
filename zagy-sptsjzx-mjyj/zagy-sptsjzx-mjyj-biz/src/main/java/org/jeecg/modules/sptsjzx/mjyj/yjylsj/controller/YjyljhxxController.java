package org.jeecg.modules.sptsjzx.mjyj.yjylsj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.mjyj.yjylsj.entity.Yjyljhxx;
import org.jeecg.modules.sptsjzx.mjyj.yjylsj.service.IYjyljhxxService;

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
 * @Description: 应急演练计划信息
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@Api(tags="应急演练计划信息")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjylsj/yjyljhxx")
@Slf4j
public class YjyljhxxController extends JeecgController<Yjyljhxx, IYjyljhxxService> {
	@Autowired
	private IYjyljhxxService yjyljhxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjyljhxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急演练计划信息-分页列表查询")
	@ApiOperation(value="应急演练计划信息-分页列表查询", notes="应急演练计划信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjyljhxx>> queryPageList(Yjyljhxx yjyljhxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("drillType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("drillLevel", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("planState", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjyljhxx> queryWrapper = QueryGenerator.initQueryWrapper(yjyljhxx, req.getParameterMap(),customeRuleMap);
		Page<Yjyljhxx> page = new Page<Yjyljhxx>(pageNo, pageSize);
		IPage<Yjyljhxx> pageList = yjyljhxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjyljhxx
	 * @return
	 */
	@AutoLog(value = "应急演练计划信息-添加")
	@ApiOperation(value="应急演练计划信息-添加", notes="应急演练计划信息-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjyljhxx yjyljhxx) {
		yjyljhxxService.save(yjyljhxx);
		return Result.XZ(yjyljhxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjyljhxx
	 * @return
	 */
	@AutoLog(value = "应急演练计划信息-编辑")
	@ApiOperation(value="应急演练计划信息-编辑", notes="应急演练计划信息-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjyljhxx yjyljhxx) {
		yjyljhxxService.updateById(yjyljhxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急演练计划信息-通过id删除")
	@ApiOperation(value="应急演练计划信息-通过id删除", notes="应急演练计划信息-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjyljhxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急演练计划信息-批量删除")
	@ApiOperation(value="应急演练计划信息-批量删除", notes="应急演练计划信息-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjyljhxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急演练计划信息-通过id查询")
	@ApiOperation(value="应急演练计划信息-通过id查询", notes="应急演练计划信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjyljhxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yjyljhxx yjyljhxx = yjyljhxxService.getById(id);
		if(yjyljhxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjyljhxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjyljhxx
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjyljhxx yjyljhxx) {
        return super.exportXls(request, yjyljhxx, Yjyljhxx.class, "应急演练计划信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjyljhxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjyljhxx.class);
    }

}
