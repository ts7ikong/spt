package org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.controller;

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
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.entity.AcceptTicketVideo;
import org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.service.IAcceptTicketVideoService;

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
 * @Description: 作业票与视频关联
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Api(tags="作业票与视频关联")
@RestController
@RequestMapping("/sptsjzx/tszyaqgk/zypyspgl/acceptTicketVideo")
@Slf4j
public class AcceptTicketVideoController extends JeecgController<AcceptTicketVideo, IAcceptTicketVideoService> {
	
		@Autowired
	private IAcceptCompanyService acceptCompanyService;

	@Autowired
	private IAcceptTicketVideoService acceptTicketVideoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param acceptTicketVideo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "作业票与视频关联-分页列表查询")
	@ApiOperation(value="作业票与视频关联-分页列表查询", notes="作业票与视频关联-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AcceptTicketVideo>> queryPageList(AcceptTicketVideo acceptTicketVideo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AcceptTicketVideo> queryWrapper = QueryGenerator.initQueryWrapper(acceptTicketVideo, req.getParameterMap());

		// 【数据权限过滤】根据登录用户的区县编码获取企业列表，然后过滤
		String orgCode = DataScopeHelper.getCurrentUserOrgCode();
		if (orgCode != null && !orgCode.isEmpty()) {
			List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
			DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
		}
		Page<AcceptTicketVideo> page = new Page<AcceptTicketVideo>(pageNo, pageSize);
		IPage<AcceptTicketVideo> pageList = acceptTicketVideoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param acceptTicketVideo
	 * @return
	 */
	@AutoLog(value = "作业票与视频关联-添加")
	@ApiOperation(value="作业票与视频关联-添加", notes="作业票与视频关联-添加")
	//@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AcceptTicketVideo acceptTicketVideo) {
		acceptTicketVideoService.save(acceptTicketVideo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param acceptTicketVideo
	 * @return
	 */
	@AutoLog(value = "作业票与视频关联-编辑")
	@ApiOperation(value="作业票与视频关联-编辑", notes="作业票与视频关联-编辑")
	//@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AcceptTicketVideo acceptTicketVideo) {
		acceptTicketVideoService.updateById(acceptTicketVideo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "作业票与视频关联-通过id删除")
	@ApiOperation(value="作业票与视频关联-通过id删除", notes="作业票与视频关联-通过id删除")
	//@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		acceptTicketVideoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "作业票与视频关联-批量删除")
	@ApiOperation(value="作业票与视频关联-批量删除", notes="作业票与视频关联-批量删除")
	//@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.acceptTicketVideoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "作业票与视频关联-通过id查询")
	@ApiOperation(value="作业票与视频关联-通过id查询", notes="作业票与视频关联-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AcceptTicketVideo> queryById(@RequestParam(name="id",required=true) String id) {
		AcceptTicketVideo acceptTicketVideo = acceptTicketVideoService.getById(id);
		if(acceptTicketVideo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(acceptTicketVideo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param acceptTicketVideo
    */
    //@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AcceptTicketVideo acceptTicketVideo) {
        return super.exportXls(request, acceptTicketVideo, AcceptTicketVideo.class, "作业票与视频关联");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("sptsjzx.tszyaqgk.zypyspgl:accept_ticket_video:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AcceptTicketVideo.class);
    }

}
