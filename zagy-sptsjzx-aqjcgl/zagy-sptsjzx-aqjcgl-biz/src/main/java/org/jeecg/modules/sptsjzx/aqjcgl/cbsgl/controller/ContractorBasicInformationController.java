package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity.ContractorBasicInformation;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.service.IContractorBasicInformationService;

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
 * @Description: 承包商基本信息
 * @Author: zagy-cg
 * @Date: 2025-03-03
 * @Version: V1.0
 */
@Api(tags = "承包商基本信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/cbsgl/contractorBasicInformation")
@Slf4j
public class ContractorBasicInformationController extends JeecgController<ContractorBasicInformation, IContractorBasicInformationService> {
    @Autowired
    private IContractorBasicInformationService contractorBasicInformationService;

    /**
     * 分页列表查询
     *
     * @param contractorBasicInformation
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "承包商基本信息-分页列表查询")
    @ApiOperation(value = "承包商基本信息-分页列表查询", notes = "承包商基本信息-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<ContractorBasicInformation>> queryPageList(ContractorBasicInformation contractorBasicInformation,
                                                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("contractorType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<ContractorBasicInformation> queryWrapper = QueryGenerator.initQueryWrapper(contractorBasicInformation, req.getParameterMap(), customeRuleMap);
        Page<ContractorBasicInformation> page = new Page<ContractorBasicInformation>(pageNo, pageSize);
        IPage<ContractorBasicInformation> pageList = contractorBasicInformationService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param contractorBasicInformation
     * @return
     */
    @AutoLog(value = "承包商基本信息-添加")
    @ApiOperation(value = "承包商基本信息-添加", notes = "承包商基本信息-添加")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody ContractorBasicInformation contractorBasicInformation) {
        contractorBasicInformationService.save(contractorBasicInformation);
        return Result.XZ(contractorBasicInformation.getId(), "添加成功！");
    }

    /**
     * 编辑
     *
     * @param contractorBasicInformation
     * @return
     */
    @AutoLog(value = "承包商基本信息-编辑")
    @ApiOperation(value = "承包商基本信息-编辑", notes = "承包商基本信息-编辑")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody ContractorBasicInformation contractorBasicInformation) {
        contractorBasicInformationService.updateById(contractorBasicInformation);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "承包商基本信息-通过id删除")
    @ApiOperation(value = "承包商基本信息-通过id删除", notes = "承包商基本信息-通过id删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        contractorBasicInformationService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "承包商基本信息-批量删除")
    @ApiOperation(value = "承包商基本信息-批量删除", notes = "承包商基本信息-批量删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.contractorBasicInformationService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "承包商基本信息-通过id查询")
    @ApiOperation(value = "承包商基本信息-通过id查询", notes = "承包商基本信息-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<ContractorBasicInformation> queryById(@RequestParam(name = "id", required = true) String id) {
        ContractorBasicInformation contractorBasicInformation = contractorBasicInformationService.getById(id);
        if (contractorBasicInformation == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(contractorBasicInformation);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param contractorBasicInformation
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ContractorBasicInformation contractorBasicInformation) {
        return super.exportXls(request, contractorBasicInformation, ContractorBasicInformation.class, "承包商基本信息");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_basic_information:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ContractorBasicInformation.class);
    }

}
