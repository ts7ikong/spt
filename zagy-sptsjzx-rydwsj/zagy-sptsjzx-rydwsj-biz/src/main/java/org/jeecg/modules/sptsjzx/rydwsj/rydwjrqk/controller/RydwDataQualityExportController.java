package org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.common.util.oConvertUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.config.JeecgBaseConfig;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.entity.RydwDataQualityExport;
import org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.service.IRydwDataQualityExportService;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsssj.entity.Rydwqyzxzt;
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
 * @Description: 人员定位接入情况
 * @Author: zagy-cg
 * @Date: 2026-01-29
 * @Version: V1.0
 */
@Api(tags = "人员定位接入情况")
@RestController
@RequestMapping("/sptsjzx/rydwsj/rydwjrqk/rydwDataQualityExport")
@Slf4j
public class RydwDataQualityExportController extends JeecgController<RydwDataQualityExport, IRydwDataQualityExportService> {
    @Autowired
    private IRydwDataQualityExportService rydwDataQualityExportService;
    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    @Resource
    private JeecgBaseConfig jeecgBaseConfig;

    /**
     * 分页列表查询
     *
     * @param rydwDataQualityExport
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "人员定位接入情况-分页列表查询")
    @ApiOperation(value = "人员定位接入情况-分页列表查询", notes = "人员定位接入情况-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<RydwDataQualityExport>> queryPageList(RydwDataQualityExport rydwDataQualityExport,
                                                              @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                              HttpServletRequest req) {
        // 1. 初始化查询条件
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        customeRuleMap.put("companyCode", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<RydwDataQualityExport> queryWrapper = QueryGenerator.initQueryWrapper(rydwDataQualityExport, req.getParameterMap(), customeRuleMap);

        // 2. 定义最终的企业代码集合
        List<String> finalCompanyCodes = null;

        // ==========================================
        // 【第一步：处理数据权限】 (参照 ZoneGeo 接口)
        // ==========================================
        if (!DataScopeHelper.needDataScope()) {
            // --- 场景 A: 区县账号 (需要数据权限过滤) ---
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> permissionCompanyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

            // 如果该区县下没有企业，直接返回空
            if (permissionCompanyCodes == null || permissionCompanyCodes.isEmpty()) {
                return Result.OK(new Page<>(pageNo, pageSize));
            }

            // 初始化最终列表为权限列表
            finalCompanyCodes = permissionCompanyCodes;

            // 如果前端传了 companyCode，需要验证是否在权限范围内
            String requestCompanyCode = rydwDataQualityExport.getCompanyCode();
            if (requestCompanyCode != null && !requestCompanyCode.isEmpty()) {
                if (!finalCompanyCodes.contains(requestCompanyCode)) {
                    // 请求的企业不在当前区县权限范围内，返回空结果
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
                // 注意：这里不重新设置 finalCompanyCodes，因为 QueryGenerator 已经处理了 companyCode 的等于查询
                // 但为了保险，也可以强制过滤：finalCompanyCodes = Arrays.asList(requestCompanyCode);
            }
        } else {
            // --- 场景 B: 市平台账号 (无数据权限限制，但可能有前端传来的区县筛选) ---
            // 如果前端指定了区县，则只查该区县的数据
            if (rydwDataQualityExport.getCountyCode() != null && !rydwDataQualityExport.getCountyCode().isEmpty()) {
                String orgCode = rydwDataQualityExport.getCountyCode();
                List<String> countyCompanyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                if (countyCompanyCodes == null || countyCompanyCodes.isEmpty()) {
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
                finalCompanyCodes = countyCompanyCodes;
            }
            // 如果没传区县，finalCompanyCodes 保持 null，表示查询所有
        }

        // ==========================================
        // 【第二步：处理业务筛选】 (重大危险源)
        // ==========================================
        if (rydwDataQualityExport.getIsZdwxy() != null && !rydwDataQualityExport.getIsZdwxy().isEmpty()) {
            String isZdwxy = rydwDataQualityExport.getIsZdwxy();
            List<String> zdwxyCompanyCodes = acceptCompanyService.getCompanyCodesByIsZdwxy(isZdwxy);

            // 如果没有重大危险源企业，直接返回空
            if (zdwxyCompanyCodes == null || zdwxyCompanyCodes.isEmpty()) {
                return Result.OK(new Page<>(pageNo, pageSize));
            }

            // 取交集：(权限范围 OR 前端选的区县) AND (重大危险源)
            if (finalCompanyCodes == null) {
                // 之前没有限制（市平台且没选区县），直接赋值为重大危险源列表
                finalCompanyCodes = zdwxyCompanyCodes;
            } else {
                // 之前有限制，取交集
                finalCompanyCodes.retainAll(zdwxyCompanyCodes);
                // 如果交集为空，说明该权限/区县下没有符合重大危险源条件的企业
                if (finalCompanyCodes.isEmpty()) {
                    return Result.OK(new Page<>(pageNo, pageSize));
                }
            }
        }

        // ==========================================
        // 【第三步：应用最终过滤】
        // ==========================================
        if (finalCompanyCodes != null) {
            DataScopeHelper.applyCompanyCodeFilter(queryWrapper, finalCompanyCodes, "company_code");
        }

        // 4. 执行分页查询
        Page<RydwDataQualityExport> page = new Page<>(pageNo, pageSize);
        IPage<RydwDataQualityExport> pageList = rydwDataQualityExportService.page(page, queryWrapper);

        // 5. 数据后处理
        if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
            for (RydwDataQualityExport item : pageList.getRecords()) {
                // 手动赋值 transient 字段
                item.setCountyCode(item.getCompanyCode());
                item.setIsZdwxy(item.getCompanyCode());
            }
        }

        return Result.OK(pageList);
    }

    /**
     *   添加
     *
     * @param rydwDataQualityExport
     * @return
     */
    @AutoLog(value = "人员定位接入情况-添加")
    @ApiOperation(value = "人员定位接入情况-添加", notes = "人员定位接入情况-添加")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody RydwDataQualityExport rydwDataQualityExport) {
        rydwDataQualityExportService.save(rydwDataQualityExport);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     *
     * @param rydwDataQualityExport
     * @return
     */
    @AutoLog(value = "人员定位接入情况-编辑")
    @ApiOperation(value = "人员定位接入情况-编辑", notes = "人员定位接入情况-编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody RydwDataQualityExport rydwDataQualityExport) {
        rydwDataQualityExportService.updateById(rydwDataQualityExport);
        return Result.OK("编辑成功!");
    }

    /**
     *   通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "人员定位接入情况-通过id删除")
    @ApiOperation(value = "人员定位接入情况-通过id删除", notes = "人员定位接入情况-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        rydwDataQualityExportService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     *  批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "人员定位接入情况-批量删除")
    @ApiOperation(value = "人员定位接入情况-批量删除", notes = "人员定位接入情况-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.rydwDataQualityExportService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "人员定位接入情况-通过id查询")
    @ApiOperation(value = "人员定位接入情况-通过id查询", notes = "人员定位接入情况-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<RydwDataQualityExport> queryById(@RequestParam(name = "id", required = true) String id) {
        RydwDataQualityExport rydwDataQualityExport = rydwDataQualityExportService.getById(id);
        if (rydwDataQualityExport == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(rydwDataQualityExport);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param rydwDataQualityExport
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, RydwDataQualityExport rydwDataQualityExport) {
        return exportXlsCrjl(request, rydwDataQualityExport, RydwDataQualityExport.class, "人员定位接入情况");
    }

    protected ModelAndView exportXlsCrjl(HttpServletRequest request, RydwDataQualityExport object, Class<RydwDataQualityExport> clazz, String title) {
        // Step.1 组装查询条件
        QueryWrapper<RydwDataQualityExport> queryWrapper = QueryGenerator.initQueryWrapper(object, request.getParameterMap());
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

        // 过滤选中数据
        String selections = request.getParameter("selections");
        if (oConvertUtils.isNotEmpty(selections)) {
            List<String> selectionList = Arrays.asList(selections.split(","));
            queryWrapper.in("id", selectionList);
        }
        // Step.2 获取导出数据
        List<RydwDataQualityExport> exportList = service.list(queryWrapper);
        if (CollectionUtils.isNotEmpty(exportList)) {
            for (RydwDataQualityExport item : exportList) {
                // 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
                item.setCountyCode(item.getCompanyCode());
                item.setIsZdwxy(item.getCompanyCode());
            }
        }

        // Step.3 AutoPoi 导出Excel
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        //此处设置的filename无效 ,前端会重更新设置一下
        mv.addObject(NormalExcelConstants.FILE_NAME, title);
        mv.addObject(NormalExcelConstants.CLASS, clazz);
        //update-begin--Author:liusq  Date:20210126 for：图片导出报错，ImageBasePath未设置--------------------
        ExportParams exportParams = new ExportParams(title + "报表", "导出人:" + sysUser.getRealname(), title);
        exportParams.setImageBasePath(jeecgBaseConfig.getPath().getUpload());
        //update-end--Author:liusq  Date:20210126 for：图片导出报错，ImageBasePath未设置----------------------
        mv.addObject(NormalExcelConstants.PARAMS, exportParams);
        mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
        return mv;
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, RydwDataQualityExport.class);
    }

}
