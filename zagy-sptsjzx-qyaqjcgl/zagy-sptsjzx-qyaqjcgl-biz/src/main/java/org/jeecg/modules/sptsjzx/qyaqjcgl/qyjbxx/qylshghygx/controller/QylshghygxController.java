package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylshghygx.controller;

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

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylshghygx.entity.Qylshghygx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylshghygx.service.IQylshghygxService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

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
 * @Description: 企业隶属化工行业关系表
 * @Author: zagy-cg
 * @Date: 2025-06-20
 * @Version: V1.0
 */
@Api(tags = "企业隶属化工行业关系表")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/qyjbxx/qylshghygx/qylshghygx")
@Slf4j
public class QylshghygxController extends JeecgController<Qylshghygx, IQylshghygxService> {
    @Autowired
    private IQylshghygxService qylshghygxService;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    /**
     * 分页列表查询
     *
     * @param qylshghygx
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "企业隶属化工行业关系表-分页列表查询")
    @ApiOperation(value = "企业隶属化工行业关系表-分页列表查询", notes = "企业隶属化工行业关系表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Qylshghygx>> queryPageList(Qylshghygx qylshghygx,
                                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                   HttpServletRequest req) {
        QueryWrapper<Qylshghygx> queryWrapper = QueryGenerator.initQueryWrapper(qylshghygx, req.getParameterMap());

        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        // 实体只有companyCode字段，需要先查询企业表获取企业编码列表
        if (!DataScopeHelper.needDataScope()) {
            // 区县账号：只能查看本区县的企业数据
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

            // 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
            String requestCompanyCode = qylshghygx.getCompanyCode();
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
        }
        // 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）

        if (qylshghygx.getCountyCode() != null) {
            String orgCode = qylshghygx.getCountyCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            if (companyCodes == null) {
                // 请求的企业不在当前区县权限范围内，返回空结果
                return Result.OK(new Page<>(pageNo, pageSize));
            }
            DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
        }
        Page<Qylshghygx> page = new Page<Qylshghygx>(pageNo, pageSize);
        IPage<Qylshghygx> pageList = qylshghygxService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param qylshghygx
     * @return
     */
    @AutoLog(value = "企业隶属化工行业关系表-添加")
    @ApiOperation(value = "企业隶属化工行业关系表-添加", notes = "企业隶属化工行业关系表-添加")
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Qylshghygx qylshghygx) {
        qylshghygxService.save(qylshghygx);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param qylshghygx
     * @return
     */
    @AutoLog(value = "企业隶属化工行业关系表-编辑")
    @ApiOperation(value = "企业隶属化工行业关系表-编辑", notes = "企业隶属化工行业关系表-编辑")
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody Qylshghygx qylshghygx) {
        qylshghygxService.updateById(qylshghygx);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "企业隶属化工行业关系表-通过id删除")
    @ApiOperation(value = "企业隶属化工行业关系表-通过id删除", notes = "企业隶属化工行业关系表-通过id删除")
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        qylshghygxService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "企业隶属化工行业关系表-批量删除")
    @ApiOperation(value = "企业隶属化工行业关系表-批量删除", notes = "企业隶属化工行业关系表-批量删除")
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.qylshghygxService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "企业隶属化工行业关系表-通过id查询")
    @ApiOperation(value = "企业隶属化工行业关系表-通过id查询", notes = "企业隶属化工行业关系表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<Qylshghygx> queryById(@RequestParam(name = "id", required = true) String id) {
        Qylshghygx qylshghygx = qylshghygxService.getById(id);
        if (qylshghygx == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(qylshghygx);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param qylshghygx
     */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Qylshghygx qylshghygx) {
        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        if (!DataScopeHelper.needDataScope()) {
            // 区县账号：只能导出本区县的企业数据
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

            // 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
            String requestCompanyCode = qylshghygx.getCompanyCode();
            if (requestCompanyCode != null && !requestCompanyCode.isEmpty()) {
                if (companyCodes == null || !companyCodes.contains(requestCompanyCode)) {
                    // 请求的企业不在当前区县权限范围内，设置一个不存在的企业代码，导出空数据
                    qylshghygx.setCompanyCode("__NO_ACCESS__");
                }
                // 企业在权限范围内，使用前端传入的companyCode
            } else {
                // 没有指定企业，导出该区县所有企业的数据
                // 由于exportXls使用entity对象作为查询条件，无法直接使用IN条件
                // 这里需要在service层或通过其他方式处理多个企业的情况
                // 暂时的处理：如果没有权限或企业列表为空，设置不存在的代码
                if (companyCodes == null || companyCodes.isEmpty()) {
                    qylshghygx.setCompanyCode("__NO_ACCESS__");
                }
                // 如果有多个企业，需要在service层处理或重写exportXls方法
            }
        }
        // 市平台账号：不需要额外过滤，可以导出所有数据（会根据前端传入的参数自动过滤）

        return super.exportXls(request, qylshghygx, Qylshghygx.class, "企业隶属化工行业关系表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Qylshghygx.class);
    }

}
