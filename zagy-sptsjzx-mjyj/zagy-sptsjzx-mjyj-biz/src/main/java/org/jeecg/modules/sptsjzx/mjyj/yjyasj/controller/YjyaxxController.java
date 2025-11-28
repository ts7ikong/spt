package org.jeecg.modules.sptsjzx.mjyj.yjyasj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.mjyj.yjyasj.entity.Yjyaxx;
import org.jeecg.modules.sptsjzx.mjyj.yjyasj.service.IYjyaxxService;

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
 * @Description: 应急预案信息
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@Api(tags="应急预案信息")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjyasj/yjyaxx")
@Slf4j
public class YjyaxxController extends JeecgController<Yjyaxx, IYjyaxxService> {
	@Autowired
	private IYjyaxxService yjyaxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjyaxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急预案信息-分页列表查询")
	@ApiOperation(value="应急预案信息-分页列表查询", notes="应急预案信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjyaxx>> queryPageList(Yjyaxx yjyaxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("emergencePlanType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("emergencePlanLevel", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("riskHasToldYesOrNo", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("recordDepartNature", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("planReviewedState", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("planReviewedComments", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("reviseState", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjyaxx> queryWrapper = QueryGenerator.initQueryWrapper(yjyaxx, req.getParameterMap(),customeRuleMap);
		Page<Yjyaxx> page = new Page<Yjyaxx>(pageNo, pageSize);
		IPage<Yjyaxx> pageList = yjyaxxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjyaxx
	 * @return
	 */
	@AutoLog(value = "应急预案信息-添加")
	@ApiOperation(value="应急预案信息-添加", notes="应急预案信息-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjyaxx yjyaxx) {
		yjyaxxService.save(yjyaxx);
		return Result.XZ(yjyaxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjyaxx
	 * @return
	 */
	@AutoLog(value = "应急预案信息-编辑")
	@ApiOperation(value="应急预案信息-编辑", notes="应急预案信息-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjyaxx yjyaxx) {
		yjyaxxService.updateById(yjyaxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急预案信息-通过id删除")
	@ApiOperation(value="应急预案信息-通过id删除", notes="应急预案信息-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjyaxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急预案信息-批量删除")
	@ApiOperation(value="应急预案信息-批量删除", notes="应急预案信息-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjyaxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急预案信息-通过id查询")
	@ApiOperation(value="应急预案信息-通过id查询", notes="应急预案信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjyaxx> queryById(@RequestParam(name="id",required=true) String id) {
		Yjyaxx yjyaxx = yjyaxxService.getById(id);
		if(yjyaxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjyaxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjyaxx
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjyaxx yjyaxx) {
        return super.exportXls(request, yjyaxx, Yjyaxx.class, "应急预案信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjyasj:yjyaxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjyaxx.class);
    }

}
