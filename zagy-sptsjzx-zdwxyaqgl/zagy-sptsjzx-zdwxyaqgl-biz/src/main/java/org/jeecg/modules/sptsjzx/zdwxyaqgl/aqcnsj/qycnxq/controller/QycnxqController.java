package org.jeecg.modules.sptsjzx.zdwxyaqgl.aqcnsj.qycnxq.controller;

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
import org.jeecg.modules.sptsjzx.zdwxyaqgl.aqcnsj.qycnxq.entity.Qycnxq;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.aqcnsj.qycnxq.service.IQycnxqService;

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
 * @Description: 企业承诺详情表
 * @Author: zagy-cg
 * @Date: 2025-05-30
 * @Version: V1.0
 */
@Api(tags = "企业承诺详情表")
@RestController
@RequestMapping("/sptsjzx/zdwxyaqgl/aqcnsj/qycnxq/qycnxq")
@Slf4j
public class QycnxqController extends JeecgController<Qycnxq, IQycnxqService> {

    @Autowired
    private IYqjbxxService yqjbxxService;

    @Autowired
    private IQycnxqService qycnxqService;

    /**
     * 分页列表查询
     *
     * @param qycnxq
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "企业承诺详情表-分页列表查询")
    @ApiOperation(value = "企业承诺详情表-分页列表查询", notes = "企业承诺详情表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Qycnxq>> queryPageList(Qycnxq qycnxq,
                                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                               HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("parkCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("contractor", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("trialProduction", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("openParking", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("test", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("mmHazards", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("riskGrade", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Qycnxq> queryWrapper = QueryGenerator.initQueryWrapper(qycnxq, req.getParameterMap(), customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取园区列表，然后过滤
		if (DataScopeHelper.needDataScope()) {
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> parkCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
			DataScopeHelper.applyParkCodeFilter(queryWrapper, parkCodes, "park_code");
		}
		Page<Qycnxq> page = new Page<Qycnxq>(pageNo, pageSize);
		IPage<Qycnxq> pageList = qycnxqService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param qycnxq
	 * @return
	 */
	@AutoLog(value = "企业承诺详情表-添加")
	@ApiOperation(value="企业承诺详情表-添加", notes="企业承诺详情表-添加")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Qycnxq qycnxq) {
		qycnxqService.save(qycnxq);
		return Result.XZ(qycnxq.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param qycnxq
	 * @return
	 */
	@AutoLog(value = "企业承诺详情表-编辑")
	@ApiOperation(value="企业承诺详情表-编辑", notes="企业承诺详情表-编辑")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Qycnxq qycnxq) {
		qycnxqService.updateById(qycnxq);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业承诺详情表-通过id删除")
	@ApiOperation(value="企业承诺详情表-通过id删除", notes="企业承诺详情表-通过id删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		qycnxqService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业承诺详情表-批量删除")
	@ApiOperation(value="企业承诺详情表-批量删除", notes="企业承诺详情表-批量删除")
	//@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.qycnxqService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "企业承诺详情表-通过id查询")
	@ApiOperation(value="企业承诺详情表-通过id查询", notes="企业承诺详情表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Qycnxq> queryById(@RequestParam(name="id",required=true) String id) {
		Qycnxq qycnxq = qycnxqService.getById(id);
		if(qycnxq==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(qycnxq);
	}


    /**
     * 导出excel
     *
     * @param request
     * @param qycnxq
     */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Qycnxq qycnxq) {
        return super.exportXls(request, qycnxq, Qycnxq.class, "企业承诺详情表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    //@RequiresPermissions("sptsjzx.zdwxyaqgl.aqcnsj.qycnxq:qycnxq:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Qycnxq.class);
    }

}
