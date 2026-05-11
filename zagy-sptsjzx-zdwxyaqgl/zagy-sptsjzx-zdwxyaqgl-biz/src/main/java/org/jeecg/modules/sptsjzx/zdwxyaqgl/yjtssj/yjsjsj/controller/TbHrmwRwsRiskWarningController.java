package org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.yjsjsj.controller;

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

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.yjsjsj.entity.TbHrmwRwsRiskWarning;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.yjsjsj.service.ITbHrmwRwsRiskWarningService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.entity.TbHrmwMoniAlarm;
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
 * @Description: 预警事件数据
 * @Author: zagy-cg
 * @Date: 2026-04-22
 * @Version: V1.0
 */
@Api(tags = "预警事件数据")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/tbHrmwRwsRiskWarning")
@Slf4j
public class TbHrmwRwsRiskWarningController extends JeecgController<TbHrmwRwsRiskWarning, ITbHrmwRwsRiskWarningService> {
    @Autowired
    private ITbHrmwRwsRiskWarningService tbHrmwRwsRiskWarningService;
    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    /**
     * 分页列表查询
     *
     * @param tbHrmwRwsRiskWarning
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "预警事件数据-分页列表查询")
    @ApiOperation(value = "预警事件数据-分页列表查询", notes = "预警事件数据-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<TbHrmwRwsRiskWarning>> queryPageList(TbHrmwRwsRiskWarning tbHrmwRwsRiskWarning,
                                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                             HttpServletRequest req) {
        QueryWrapper<TbHrmwRwsRiskWarning> queryWrapper = QueryGenerator.initQueryWrapper(tbHrmwRwsRiskWarning, req.getParameterMap());
        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        // 实体只有companyCode字段，需要先查询企业表获取企业编码列表
        if (!DataScopeHelper.needDataScope()) {
            // 区县账号：只能查看本区县的企业数据
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            // 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
            String requestCompanyCode = tbHrmwRwsRiskWarning.getCompanyCode();
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
            if (tbHrmwRwsRiskWarning.getCountyCode() != null) {
                String orgCode = tbHrmwRwsRiskWarning.getCountyCode();
                List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                if (companyCodes == null) {
                    // 请求的企业不在当前区县权限范围内，返回空结果
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
                DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
            }
        }
        // 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
        Page<TbHrmwRwsRiskWarning> page = new Page<TbHrmwRwsRiskWarning>(pageNo, pageSize);
        IPage<TbHrmwRwsRiskWarning> pageList = tbHrmwRwsRiskWarningService.page(page, queryWrapper);
        if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
            for (TbHrmwRwsRiskWarning item : pageList.getRecords()) {
                // 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
                item.setCountyCode(item.getCompanyCode());
            }
        }
        return Result.OK(pageList);
    }

    /**
     *   添加
     *
     * @param tbHrmwRwsRiskWarning
     * @return
     */
    @AutoLog(value = "预警事件数据-添加")
    @ApiOperation(value = "预警事件数据-添加", notes = "预警事件数据-添加")
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody TbHrmwRwsRiskWarning tbHrmwRwsRiskWarning) {
        tbHrmwRwsRiskWarningService.save(tbHrmwRwsRiskWarning);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     *
     * @param tbHrmwRwsRiskWarning
     * @return
     */
    @AutoLog(value = "预警事件数据-编辑")
    @ApiOperation(value = "预警事件数据-编辑", notes = "预警事件数据-编辑")
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody TbHrmwRwsRiskWarning tbHrmwRwsRiskWarning) {
        tbHrmwRwsRiskWarningService.updateById(tbHrmwRwsRiskWarning);
        return Result.OK("编辑成功!");
    }

    /**
     *   通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "预警事件数据-通过id删除")
    @ApiOperation(value = "预警事件数据-通过id删除", notes = "预警事件数据-通过id删除")
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        tbHrmwRwsRiskWarningService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     *  批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "预警事件数据-批量删除")
    @ApiOperation(value = "预警事件数据-批量删除", notes = "预警事件数据-批量删除")
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.tbHrmwRwsRiskWarningService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "预警事件数据-通过id查询")
    @ApiOperation(value = "预警事件数据-通过id查询", notes = "预警事件数据-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<TbHrmwRwsRiskWarning> queryById(@RequestParam(name = "id", required = true) String id) {
        TbHrmwRwsRiskWarning tbHrmwRwsRiskWarning = tbHrmwRwsRiskWarningService.getById(id);
        if (tbHrmwRwsRiskWarning == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(tbHrmwRwsRiskWarning);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param tbHrmwRwsRiskWarning
     */
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TbHrmwRwsRiskWarning tbHrmwRwsRiskWarning) {
        return super.exportXls(request, tbHrmwRwsRiskWarning, TbHrmwRwsRiskWarning.class, "预警事件数据");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:tb_hrmw_rws_risk_warning:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TbHrmwRwsRiskWarning.class);
    }

}
