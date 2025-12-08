package org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggxjcxx.controller;

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
import org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggxjcxx.entity.Gggxjcxx;
import org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggxjcxx.service.IGggxjcxxService;

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
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;

 /**
 * @Description: 公共管线基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Api(tags="公共管线基础信息")
@RestController
@RequestMapping("/sptsjzx/ggglaqfxjcyj/gggxjcxx/gggxjcxx")
@Slf4j
public class GggxjcxxController extends JeecgController<Gggxjcxx, IGggxjcxxService> {

	@Autowired
	private IAcceptCompanyService acceptCompanyService;

	

	@Autowired
	private IYqjbxxService yqjbxxService;
	
	@Autowired
	private IGggxjcxxService gggxjcxxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param gggxjcxx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "公共管线基础信息-分页列表查询")
	@ApiOperation(value="公共管线基础信息-分页列表查询", notes="公共管线基础信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Gggxjcxx>> queryPageList(Gggxjcxx gggxjcxx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("pipeCode", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("pipelineState", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("deleted", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Gggxjcxx> queryWrapper = QueryGenerator.initQueryWrapper(gggxjcxx, req.getParameterMap(),customeRuleMap);

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表
		// 实体只有companyCode字段，需要先查询企业表获取企业编码列表
		if (!DataScopeHelper.needDataScope()) {
			// 区县账号：只能查看本区县的企业数据
			String orgCode = DataScopeHelper.getCurrentUserOrgCode();
			List<String> yqCodes = yqjbxxService.getYqCodesByCountyCode(orgCode);
			// 如果前端传了companyCode参数，需要验证该企业是否属于当前区县
			String requestParkCode = gggxjcxx.getParkCode();
			if (requestParkCode != null && !requestParkCode.isEmpty()) {
				if (yqCodes == null || !yqCodes.contains(requestParkCode)) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				// 企业在权限范围内，只查询该企业的数据（QueryGenerator已经添加了companyCode条件）
			} else {
				// 没有指定企业，使用企业编码列表过滤数据
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, yqCodes, "park_code");
			}
		} else {
			if (gggxjcxx.getCountyCode() != null) {
				String orgCode = gggxjcxx.getCountyCode();
				List<String> yqCodes = yqjbxxService.getParkCodesByAreaCode(orgCode);
				if (yqCodes == null) {
					// 请求的企业不在当前区县权限范围内，返回空结果
					return Result.OK(new Page<>(pageNo, pageSize));
				}
				DataScopeHelper.applyCompanyCodeFilter(queryWrapper, yqCodes, "park_code");
			}
		}
		// 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
		Page<Gggxjcxx> page = new Page<Gggxjcxx>(pageNo, pageSize);
		IPage<Gggxjcxx> pageList = gggxjcxxService.page(page, queryWrapper);
		if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
			for (Gggxjcxx item : pageList.getRecords()) {
				// 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
				item.setCountyCode(item.getParkCode());
			}
		}
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param gggxjcxx
	 * @return
	 */
	@AutoLog(value = "公共管线基础信息-添加")
	@ApiOperation(value="公共管线基础信息-添加", notes="公共管线基础信息-添加")
	//@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Gggxjcxx gggxjcxx) {
		gggxjcxxService.save(gggxjcxx);
		return Result.XZ(gggxjcxx.getId(),"添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param gggxjcxx
	 * @return
	 */
	@AutoLog(value = "公共管线基础信息-编辑")
	@ApiOperation(value="公共管线基础信息-编辑", notes="公共管线基础信息-编辑")
	//@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Gggxjcxx gggxjcxx) {
		gggxjcxxService.updateById(gggxjcxx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "公共管线基础信息-通过id删除")
	@ApiOperation(value="公共管线基础信息-通过id删除", notes="公共管线基础信息-通过id删除")
	//@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		gggxjcxxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "公共管线基础信息-批量删除")
	@ApiOperation(value="公共管线基础信息-批量删除", notes="公共管线基础信息-批量删除")
	//@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.gggxjcxxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "公共管线基础信息-通过id查询")
	@ApiOperation(value="公共管线基础信息-通过id查询", notes="公共管线基础信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Gggxjcxx> queryById(@RequestParam(name="id",required=true) String id) {
		Gggxjcxx gggxjcxx = gggxjcxxService.getById(id);
		if(gggxjcxx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(gggxjcxx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param gggxjcxx
    */
    //@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Gggxjcxx gggxjcxx) {
        return super.exportXls(request, gggxjcxx, Gggxjcxx.class, "公共管线基础信息");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.ggglaqfxjcyj.gggxjcxx:gggxjcxx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Gggxjcxx.class);
    }

}
