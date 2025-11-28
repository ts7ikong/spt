package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity.ContractorTrain;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.service.IContractorTrainService;

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
 * @Description: 承包商培训记录
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@Api(tags="承包商培训记录")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/cbsgl/contractorTrain")
@Slf4j
public class ContractorTrainController extends JeecgController<ContractorTrain, IContractorTrainService> {
	@Autowired
	private IContractorTrainService contractorTrainService;
	
	/**
	 * 分页列表查询
	 *
	 * @param contractorTrain
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "承包商培训记录-分页列表查询")
	@ApiOperation(value="承包商培训记录-分页列表查询", notes="承包商培训记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ContractorTrain>> queryPageList(ContractorTrain contractorTrain,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("contractorUuid", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("trainingType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("qualified", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<ContractorTrain> queryWrapper = QueryGenerator.initQueryWrapper(contractorTrain, req.getParameterMap(),customeRuleMap);
		Page<ContractorTrain> page = new Page<ContractorTrain>(pageNo, pageSize);
		IPage<ContractorTrain> pageList = contractorTrainService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param contractorTrain
	 * @return
	 */
	@AutoLog(value = "承包商培训记录-添加")
	@ApiOperation(value="承包商培训记录-添加", notes="承包商培训记录-添加")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ContractorTrain contractorTrain) {
		contractorTrainService.save(contractorTrain);
		return Result.XZ(contractorTrain.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param contractorTrain
	 * @return
	 */
	@AutoLog(value = "承包商培训记录-编辑")
	@ApiOperation(value="承包商培训记录-编辑", notes="承包商培训记录-编辑")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ContractorTrain contractorTrain) {
		contractorTrainService.updateById(contractorTrain);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "承包商培训记录-通过id删除")
	@ApiOperation(value="承包商培训记录-通过id删除", notes="承包商培训记录-通过id删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		contractorTrainService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "承包商培训记录-批量删除")
	@ApiOperation(value="承包商培训记录-批量删除", notes="承包商培训记录-批量删除")
	//@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.contractorTrainService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "承包商培训记录-通过id查询")
	@ApiOperation(value="承包商培训记录-通过id查询", notes="承包商培训记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ContractorTrain> queryById(@RequestParam(name="id",required=true) String id) {
		ContractorTrain contractorTrain = contractorTrainService.getById(id);
		if(contractorTrain==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(contractorTrain);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param contractorTrain
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ContractorTrain contractorTrain) {
        return super.exportXls(request, contractorTrain, ContractorTrain.class, "承包商培训记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_train:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ContractorTrain.class);
    }

}
