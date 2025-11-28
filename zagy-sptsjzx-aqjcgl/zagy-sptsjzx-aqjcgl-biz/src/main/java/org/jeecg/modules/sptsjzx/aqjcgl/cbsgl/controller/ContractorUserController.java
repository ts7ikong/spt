package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity.ContractorUser;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.service.IContractorUserService;

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
 * @Description: 承包商人员
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@Api(tags="承包商人员")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/cbsgl/contractorUser")
@Slf4j
public class ContractorUserController extends JeecgController<ContractorUser, IContractorUserService> {
	@Autowired
	private IContractorUserService contractorUserService;
	
	/**
	 * 分页列表查询
	 *
	 * @param contractorUser
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "承包商人员-分页列表查询")
	@ApiOperation(value="承包商人员-分页列表查询", notes="承包商人员-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ContractorUser>> queryPageList(ContractorUser contractorUser,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("contractorUuid", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("highRiskPosition", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<ContractorUser> queryWrapper = QueryGenerator.initQueryWrapper(contractorUser, req.getParameterMap(),customeRuleMap);
		Page<ContractorUser> page = new Page<ContractorUser>(pageNo, pageSize);
		IPage<ContractorUser> pageList = contractorUserService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param contractorUser
	 * @return
	 */
	@AutoLog(value = "承包商人员-添加")
	@ApiOperation(value="承包商人员-添加", notes="承包商人员-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ContractorUser contractorUser) {
		contractorUserService.save(contractorUser);
		return Result.XZ(contractorUser.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param contractorUser
	 * @return
	 */
	@AutoLog(value = "承包商人员-编辑")
	@ApiOperation(value="承包商人员-编辑", notes="承包商人员-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ContractorUser contractorUser) {
		contractorUserService.updateById(contractorUser);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "承包商人员-通过id删除")
	@ApiOperation(value="承包商人员-通过id删除", notes="承包商人员-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		contractorUserService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "承包商人员-批量删除")
	@ApiOperation(value="承包商人员-批量删除", notes="承包商人员-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.contractorUserService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "承包商人员-通过id查询")
	@ApiOperation(value="承包商人员-通过id查询", notes="承包商人员-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ContractorUser> queryById(@RequestParam(name="id",required=true) String id) {
		ContractorUser contractorUser = contractorUserService.getById(id);
		if(contractorUser==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(contractorUser);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param contractorUser
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ContractorUser contractorUser) {
        return super.exportXls(request, contractorUser, ContractorUser.class, "承包商人员");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_user:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ContractorUser.class);
    }

}
