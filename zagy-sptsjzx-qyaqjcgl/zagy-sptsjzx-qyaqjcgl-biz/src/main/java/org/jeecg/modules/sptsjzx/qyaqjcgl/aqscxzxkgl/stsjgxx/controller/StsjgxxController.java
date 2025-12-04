package org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.stsjgxx.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.stsjgxx.entity.Stsjgxx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.stsjgxx.service.IStsjgxxService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
 * @Description: “三同时”监管信息表
 * @Author: zagy-cg
 * @Date: 2025-05-29
 * @Version: V1.0
 */
@Api(tags = "“三同时”监管信息表")
@RestController
@RequestMapping("/sptsjzx/qyaqjcgl/aqscxzxkgl/qystsjgxx/stsjgxx")
@Slf4j
public class StsjgxxController extends JeecgController<Stsjgxx, IStsjgxxService> {
    @Autowired
    private IStsjgxxService stsjgxxService;
    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    /**
     * 分页列表查询
     *
     * @param stsjgxx
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "“三同时”监管信息表-分页列表查询")
    @ApiOperation(value = "“三同时”监管信息表-分页列表查询", notes = "“三同时”监管信息表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Stsjgxx>> queryPageList(Stsjgxx stsjgxx,
                                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("plantCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("projectType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("approvalStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("designStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("buildStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("testProductionStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("acceptanceStatus", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("currentGeneration", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Stsjgxx> queryWrapper = QueryGenerator.initQueryWrapper(stsjgxx, req.getParameterMap(), customeRuleMap);

        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        // 实体只有companyCode字段，需要先查询企业表获取企业编码列表
        if (DataScopeHelper.needDataScope()) {
            // 区县账号：只能查看本区县的企业数据
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

            // 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
            String requestCompanyCode = stsjgxx.getCompanyCode();
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


        Page<Stsjgxx> page = new Page<Stsjgxx>(pageNo, pageSize);
        IPage<Stsjgxx> pageList = stsjgxxService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param stsjgxx
     * @return
     */
    @AutoLog(value = "“三同时”监管信息表-添加")
    @ApiOperation(value = "“三同时”监管信息表-添加", notes = "“三同时”监管信息表-添加")
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Stsjgxx stsjgxx) {
        stsjgxxService.save(stsjgxx);
        return Result.XZ(stsjgxx.getId(), "添加成功！");
    }

    /**
     * 编辑
     *
     * @param stsjgxx
     * @return
     */
    @AutoLog(value = "“三同时”监管信息表-编辑")
    @ApiOperation(value = "“三同时”监管信息表-编辑", notes = "“三同时”监管信息表-编辑")
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody Stsjgxx stsjgxx) {
        stsjgxxService.updateById(stsjgxx);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "“三同时”监管信息表-通过id删除")
    @ApiOperation(value = "“三同时”监管信息表-通过id删除", notes = "“三同时”监管信息表-通过id删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        stsjgxxService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "“三同时”监管信息表-批量删除")
    @ApiOperation(value = "“三同时”监管信息表-批量删除", notes = "“三同时”监管信息表-批量删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.stsjgxxService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "“三同时”监管信息表-通过id查询")
    @ApiOperation(value = "“三同时”监管信息表-通过id查询", notes = "“三同时”监管信息表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<Stsjgxx> queryById(@RequestParam(name = "id", required = true) String id) {
        Stsjgxx stsjgxx = stsjgxxService.getById(id);
        if (stsjgxx == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(stsjgxx);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param stsjgxx
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Stsjgxx stsjgxx) {
        return super.exportXls(request, stsjgxx, Stsjgxx.class, "“三同时”监管信息表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Stsjgxx.class);
    }

}
