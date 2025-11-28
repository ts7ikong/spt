package org.jeecg.modules.sptsjzx.aqjcgl.qyjcxx.zbzsxx.controller;

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
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjcxx.zbzsxx.entity.Zbzsxx;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjcxx.zbzsxx.service.IZbzsxxService;

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
 * @Description: 值班值守信息
 * @Author: zagy-cg
 * @Date: 2025-06-04
 * @Version: V1.0
 */
@Api(tags = "值班值守信息")
@RestController
@RequestMapping("/sptsjzx/aqjcgl/qyjcxx/zbzsxx/zbzsxx")
@Slf4j
public class ZbzsxxController extends JeecgController<Zbzsxx, IZbzsxxService> {

	@Autowired
	private IYqjbxxService yqjbxxService;

    @Autowired
    private IZbzsxxService zbzsxxService;

    /**
     * 分页列表查询
     *
     * @param zbzsxx
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "值班值守信息-分页列表查询")
    @ApiOperation(value = "值班值守信息-分页列表查询", notes = "值班值守信息-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Zbzsxx>> queryPageList(Zbzsxx zbzsxx,
                                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                               HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("companyType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("workerType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("parkWorkerStatus", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Zbzsxx> queryWrapper = QueryGenerator.initQueryWrapper(zbzsxx, req.getParameterMap(), customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
        Page<Zbzsxx> page = new Page<Zbzsxx>(pageNo, pageSize);
        IPage<Zbzsxx> pageList = zbzsxxService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param zbzsxx
     * @return
     */
    @AutoLog(value = "值班值守信息-添加")
    @ApiOperation(value = "值班值守信息-添加", notes = "值班值守信息-添加")
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Zbzsxx zbzsxx) {
        zbzsxxService.save(zbzsxx);
        return Result.XZ(zbzsxx.getId(), "添加成功！");
    }

    /**
     * 编辑
     *
     * @param zbzsxx
     * @return
     */
    @AutoLog(value = "值班值守信息-编辑")
    @ApiOperation(value = "值班值守信息-编辑", notes = "值班值守信息-编辑")
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody Zbzsxx zbzsxx) {
        zbzsxxService.updateById(zbzsxx);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "值班值守信息-通过id删除")
    @ApiOperation(value = "值班值守信息-通过id删除", notes = "值班值守信息-通过id删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        zbzsxxService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "值班值守信息-批量删除")
    @ApiOperation(value = "值班值守信息-批量删除", notes = "值班值守信息-批量删除")
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.zbzsxxService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "值班值守信息-通过id查询")
    @ApiOperation(value = "值班值守信息-通过id查询", notes = "值班值守信息-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<Zbzsxx> queryById(@RequestParam(name = "id", required = true) String id) {
        Zbzsxx zbzsxx = zbzsxxService.getById(id);
        if (zbzsxx == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(zbzsxx);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param zbzsxx
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Zbzsxx zbzsxx) {
        return super.exportXls(request, zbzsxx, Zbzsxx.class, "值班值守信息");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.aqjcgl.qyjcxx.zbzsxx:zbzsxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Zbzsxx.class);
    }

}
