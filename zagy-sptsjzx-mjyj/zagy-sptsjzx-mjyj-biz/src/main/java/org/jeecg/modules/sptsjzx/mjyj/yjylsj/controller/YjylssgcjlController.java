package org.jeecg.modules.sptsjzx.mjyj.yjylsj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.mjyj.yjylsj.entity.Yjylssgcjl;
import org.jeecg.modules.sptsjzx.mjyj.yjylsj.service.IYjylssgcjlService;

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
 * @Description: 应急演练实施过程记录
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@Api(tags="应急演练实施过程记录")
@RestController
@RequestMapping("/sptsjzx/mjyj/yjylsj/yjylssgcjl")
@Slf4j
public class YjylssgcjlController extends JeecgController<Yjylssgcjl, IYjylssgcjlService> {
	@Autowired
	private IYjylssgcjlService yjylssgcjlService;
	
	/**
	 * 分页列表查询
	 *
	 * @param yjylssgcjl
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "应急演练实施过程记录-分页列表查询")
	@ApiOperation(value="应急演练实施过程记录-分页列表查询", notes="应急演练实施过程记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Yjylssgcjl>> queryPageList(Yjylssgcjl yjylssgcjl,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("drillType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Yjylssgcjl> queryWrapper = QueryGenerator.initQueryWrapper(yjylssgcjl, req.getParameterMap(),customeRuleMap);
		Page<Yjylssgcjl> page = new Page<Yjylssgcjl>(pageNo, pageSize);
		IPage<Yjylssgcjl> pageList = yjylssgcjlService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param yjylssgcjl
	 * @return
	 */
	@AutoLog(value = "应急演练实施过程记录-添加")
	@ApiOperation(value="应急演练实施过程记录-添加", notes="应急演练实施过程记录-添加")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Yjylssgcjl yjylssgcjl) {
		yjylssgcjlService.save(yjylssgcjl);
		return Result.XZ(yjylssgcjl.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param yjylssgcjl
	 * @return
	 */
	@AutoLog(value = "应急演练实施过程记录-编辑")
	@ApiOperation(value="应急演练实施过程记录-编辑", notes="应急演练实施过程记录-编辑")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Yjylssgcjl yjylssgcjl) {
		yjylssgcjlService.updateById(yjylssgcjl);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "应急演练实施过程记录-通过id删除")
	@ApiOperation(value="应急演练实施过程记录-通过id删除", notes="应急演练实施过程记录-通过id删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		yjylssgcjlService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "应急演练实施过程记录-批量删除")
	@ApiOperation(value="应急演练实施过程记录-批量删除", notes="应急演练实施过程记录-批量删除")
	//@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yjylssgcjlService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "应急演练实施过程记录-通过id查询")
	@ApiOperation(value="应急演练实施过程记录-通过id查询", notes="应急演练实施过程记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Yjylssgcjl> queryById(@RequestParam(name="id",required=true) String id) {
		Yjylssgcjl yjylssgcjl = yjylssgcjlService.getById(id);
		if(yjylssgcjl==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(yjylssgcjl);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param yjylssgcjl
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Yjylssgcjl yjylssgcjl) {
        return super.exportXls(request, yjylssgcjl, Yjylssgcjl.class, "应急演练实施过程记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.mjyj.yjylsj:yjylssgcjl:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Yjylssgcjl.class);
    }

}
