package org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx.controller;

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
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx.entity.Dsfdwzzxx;
import org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx.service.IDsfdwzzxxService;

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
 * @Description: 第三方单位资质信息
 * @Author: zagy-cg
 * @Date: 2025-05-30
 * @Version: V1.0
 */
@Api(tags = "第三方单位资质信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/dsfdwgl/dsfdwzzxx/dsfdwzzxx")
@Slf4j
public class DsfdwzzxxController extends JeecgController<Dsfdwzzxx, IDsfdwzzxxService> {
    @Autowired
    private IDsfdwzzxxService dsfdwzzxxService;

    /**
     * 分页列表查询
     *
     * @param dsfdwzzxx
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "第三方单位资质信息-分页列表查询")
    @ApiOperation(value = "第三方单位资质信息-分页列表查询", notes = "第三方单位资质信息-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Dsfdwzzxx>> queryPageList(Dsfdwzzxx dsfdwzzxx,
                                                  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                  HttpServletRequest req) {
        QueryWrapper<Dsfdwzzxx> queryWrapper = QueryGenerator.initQueryWrapper(dsfdwzzxx, req.getParameterMap());
        Page<Dsfdwzzxx> page = new Page<Dsfdwzzxx>(pageNo, pageSize);
        IPage<Dsfdwzzxx> pageList = dsfdwzzxxService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param dsfdwzzxx
     * @return
     */
    @AutoLog(value = "第三方单位资质信息-添加")
    @ApiOperation(value = "第三方单位资质信息-添加", notes = "第三方单位资质信息-添加")
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Dsfdwzzxx dsfdwzzxx) {
        dsfdwzzxxService.save(dsfdwzzxx);
        return Result.XZ(dsfdwzzxx.getId(), "添加成功！");
    }

    /**
     * 编辑
     *
     * @param dsfdwzzxx
     * @return
     */
    @AutoLog(value = "第三方单位资质信息-编辑")
    @ApiOperation(value = "第三方单位资质信息-编辑", notes = "第三方单位资质信息-编辑")
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody Dsfdwzzxx dsfdwzzxx) {
        dsfdwzzxxService.updateById(dsfdwzzxx);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "第三方单位资质信息-通过id删除")
    @ApiOperation(value = "第三方单位资质信息-通过id删除", notes = "第三方单位资质信息-通过id删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        dsfdwzzxxService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "第三方单位资质信息-批量删除")
    @ApiOperation(value = "第三方单位资质信息-批量删除", notes = "第三方单位资质信息-批量删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.dsfdwzzxxService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "第三方单位资质信息-通过id查询")
    @ApiOperation(value = "第三方单位资质信息-通过id查询", notes = "第三方单位资质信息-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<Dsfdwzzxx> queryById(@RequestParam(name = "id", required = true) String id) {
        Dsfdwzzxx dsfdwzzxx = dsfdwzzxxService.getById(id);
        if (dsfdwzzxx == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(dsfdwzzxx);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param dsfdwzzxx
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Dsfdwzzxx dsfdwzzxx) {
        return super.exportXls(request, dsfdwzzxx, Dsfdwzzxx.class, "第三方单位资质信息");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Dsfdwzzxx.class);
    }

}
