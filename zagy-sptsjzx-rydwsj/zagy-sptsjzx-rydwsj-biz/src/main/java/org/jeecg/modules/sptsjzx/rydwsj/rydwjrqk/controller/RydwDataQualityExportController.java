package org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.controller;

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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

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
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("companyCode", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<RydwDataQualityExport> queryWrapper = QueryGenerator.initQueryWrapper(rydwDataQualityExport, req.getParameterMap(), customeRuleMap);
        // 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
        if (rydwDataQualityExport.getCountyCode() != null) {
            String orgCode = rydwDataQualityExport.getCountyCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            if (companyCodes == null) {
                // 请求的企业不在当前区县权限范围内，返回空结果
                return Result.OK(new Page<>(pageNo, pageSize));
            }
            DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
        }
        Page<RydwDataQualityExport> page = new Page<RydwDataQualityExport>(pageNo, pageSize);
        IPage<RydwDataQualityExport> pageList = rydwDataQualityExportService.page(page, queryWrapper);
        if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
            for (RydwDataQualityExport item : pageList.getRecords()) {
                // 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
                item.setCountyCode(item.getCompanyCode());
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
        return super.exportXls(request, rydwDataQualityExport, RydwDataQualityExport.class, "人员定位接入情况");
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
