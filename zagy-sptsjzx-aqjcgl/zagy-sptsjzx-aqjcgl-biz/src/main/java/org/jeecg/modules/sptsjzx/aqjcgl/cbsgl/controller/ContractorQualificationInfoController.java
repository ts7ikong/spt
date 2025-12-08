package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity.ContractorQualificationInfo;
import org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.service.IContractorQualificationInfoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.service.IAqAcceptCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.jeecg.common.util.DataScopeHelper;

/**
 * @Description: 承包商资质信息
 * @Author: zagy-cg
 * @Date: 2025-03-03
 * @Version: V1.0
 */
@Api(tags = "承包商资质信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/cbsgl/contractorQualificationInfo")
@Slf4j
public class ContractorQualificationInfoController extends JeecgController<ContractorQualificationInfo, IContractorQualificationInfoService> {


    @Autowired
    private IAqAcceptCompanyService acceptCompanyService;
    @Autowired
    private IContractorQualificationInfoService contractorQualificationInfoService;

    /**
     * 分页列表查询
     *
     * @param contractorQualificationInfo
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "承包商资质信息-分页列表查询")
    @ApiOperation(value = "承包商资质信息-分页列表查询", notes = "承包商资质信息-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<ContractorQualificationInfo>> queryPageList(ContractorQualificationInfo contractorQualificationInfo,
                                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("contractorUuid", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<ContractorQualificationInfo> queryWrapper = QueryGenerator.initQueryWrapper(contractorQualificationInfo, req.getParameterMap(), customeRuleMap);
        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        // 实体只有companyCode字段，需要先查询企业表获取企业编码列表
        if (!DataScopeHelper.needDataScope()) {
            // 区县账号：只能查看本区县的企业数据
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            // 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
            String requestCompanyCode = contractorQualificationInfo.getCompanyCode();
            if (requestCompanyCode != null && !requestCompanyCode.isEmpty()) {
                if (companyCodes == null || !companyCodes.contains(requestCompanyCode)) {
                    // 请求的企业不在当前区县权限范围内，返回空结果
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
                // 企业在权限范围内，只查询该企业的数据（QueryGenerator已经添加了companyCode条件）
            } else {
                // 没有指定企业，使用企业编码列表过滤数据
                DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
            }
        } else {
            if (contractorQualificationInfo.getCountyCode() != null) {
                String orgCode = contractorQualificationInfo.getCountyCode();
                List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                if (companyCodes == null) {
                    // 请求的企业不在当前区县权限范围内，返回空结果
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
                DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
            }
        }
        // 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
        Page<ContractorQualificationInfo> page = new Page<ContractorQualificationInfo>(pageNo, pageSize);
        IPage<ContractorQualificationInfo> pageList = contractorQualificationInfoService.page(page, queryWrapper);
        if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
            for (ContractorQualificationInfo item : pageList.getRecords()) {
                // 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
                item.setCountyCode(item.getCompanyCode());
            }
        }
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param contractorQualificationInfo
     * @return
     */
    @AutoLog(value = "承包商资质信息-添加")
    @ApiOperation(value = "承包商资质信息-添加", notes = "承包商资质信息-添加")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody ContractorQualificationInfo contractorQualificationInfo) {
        contractorQualificationInfoService.save(contractorQualificationInfo);
        return Result.XZ(contractorQualificationInfo.getId(), "添加成功！");
    }

    /**
     * 编辑
     *
     * @param contractorQualificationInfo
     * @return
     */
    @AutoLog(value = "承包商资质信息-编辑")
    @ApiOperation(value = "承包商资质信息-编辑", notes = "承包商资质信息-编辑")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody ContractorQualificationInfo contractorQualificationInfo) {
        contractorQualificationInfoService.updateById(contractorQualificationInfo);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "承包商资质信息-通过id删除")
    @ApiOperation(value = "承包商资质信息-通过id删除", notes = "承包商资质信息-通过id删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        contractorQualificationInfoService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "承包商资质信息-批量删除")
    @ApiOperation(value = "承包商资质信息-批量删除", notes = "承包商资质信息-批量删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.contractorQualificationInfoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "承包商资质信息-通过id查询")
    @ApiOperation(value = "承包商资质信息-通过id查询", notes = "承包商资质信息-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<ContractorQualificationInfo> queryById(@RequestParam(name = "id", required = true) String id) {
        ContractorQualificationInfo contractorQualificationInfo = contractorQualificationInfoService.getById(id);
        if (contractorQualificationInfo == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(contractorQualificationInfo);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param contractorQualificationInfo
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ContractorQualificationInfo contractorQualificationInfo) {
        return super.exportXls(request, contractorQualificationInfo, ContractorQualificationInfo.class, "承包商资质信息");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ContractorQualificationInfo.class);
    }

}
