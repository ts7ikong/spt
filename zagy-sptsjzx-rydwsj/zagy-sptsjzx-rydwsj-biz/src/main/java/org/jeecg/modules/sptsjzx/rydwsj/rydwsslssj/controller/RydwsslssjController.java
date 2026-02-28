package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.controller;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.DataScopeHelper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto.AcceptPersonPosingHitoryBackDto;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto.AcceptPersonPosingRealBackDto;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto.AcceptPersonPosingRealBackInfoDto;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto.AcceptPersonPosingRealTimeInfoBackDto;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.entity.Rydwsslssj;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.service.IRydwsslssjService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
 * @Description: 人员定位接收地址
 * @Author: zagy-cg
 * @Date: 2026-02-03
 * @Version: V1.0
 */
@Api(tags = "人员定位接收地址")
@RestController
@RequestMapping("/sptsjzx/rydwsj/rydwsslssj/rydwsslssj")
@Slf4j
public class RydwsslssjController extends JeecgController<Rydwsslssj, IRydwsslssjService> {
    @Autowired
    private IRydwsslssjService rydwsslssjService;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;


    /**
     * 分页列表查询
     *
     * @param rydwsslssj
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "人员定位接收地址-分页列表查询")
    @ApiOperation(value = "人员定位接收地址-分页列表查询", notes = "人员定位接收地址-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<Rydwsslssj>> queryPageList(Rydwsslssj rydwsslssj,
                                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("companyCode", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Rydwsslssj> queryWrapper = QueryGenerator.initQueryWrapper(rydwsslssj, req.getParameterMap(), customeRuleMap);
        // 市平台账号：不需要额外过滤，可以查看所有数据（QueryGenerator会根据前端参数自动过滤）
        if (rydwsslssj.getCountyCode() != null) {
            String orgCode = rydwsslssj.getCountyCode();
            List<String> companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            if (companyCodes == null) {
                // 请求的企业不在当前区县权限范围内，返回空结果
                return Result.OK(new Page<>(pageNo, pageSize));
            }
            DataScopeHelper.applyCompanyCodeFilter(queryWrapper, companyCodes, "company_code");
        }
        Page<Rydwsslssj> page = new Page<Rydwsslssj>(pageNo, pageSize);
        IPage<Rydwsslssj> pageList = rydwsslssjService.page(page, queryWrapper);
        if (pageList != null && CollectionUtils.isNotEmpty(pageList.getRecords())) {
            for (Rydwsslssj item : pageList.getRecords()) {
                // 因为 countyCode 是 transient 字段（非数据库列），这里手动赋值
                item.setCountyCode(item.getCompanyCode());
            }
        }
        return Result.OK(pageList);
    }

    /**
     *   添加
     *
     * @param rydwsslssj
     * @return
     */
    @AutoLog(value = "人员定位接收地址-添加")
    @ApiOperation(value = "人员定位接收地址-添加", notes = "人员定位接收地址-添加")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Rydwsslssj rydwsslssj) {
        rydwsslssjService.save(rydwsslssj);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     *
     * @param rydwsslssj
     * @return
     */
    @AutoLog(value = "人员定位接收地址-编辑")
    @ApiOperation(value = "人员定位接收地址-编辑", notes = "人员定位接收地址-编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody Rydwsslssj rydwsslssj) {
        rydwsslssjService.updateById(rydwsslssj);
        return Result.OK("编辑成功!");
    }

    /**
     *   通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "人员定位接收地址-通过id删除")
    @ApiOperation(value = "人员定位接收地址-通过id删除", notes = "人员定位接收地址-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        rydwsslssjService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     *  批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "人员定位接收地址-批量删除")
    @ApiOperation(value = "人员定位接收地址-批量删除", notes = "人员定位接收地址-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.rydwsslssjService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "人员定位接收地址-通过id查询")
    @ApiOperation(value = "人员定位接收地址-通过id查询", notes = "人员定位接收地址-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<Rydwsslssj> queryById(@RequestParam(name = "id", required = true) String id) {
        Rydwsslssj rydwsslssj = rydwsslssjService.getById(id);
        if (rydwsslssj == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(rydwsslssj);
    }


    /**
     * 实时数据
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "人员定位接收地址-实时数据")
    @ApiOperation(value = "人员定位接收地址-实时数据", notes = "人员定位接收地址-实时数据")
    @GetMapping(value = "/sssj")
    public Result<AcceptPersonPosingRealBackDto> sssj(@RequestParam(name = "id", required = true) String id) {
        Rydwsslssj byId = rydwsslssjService.getById(id);
        //获取企业密钥
        AcceptCompany acceptCompanySecretBackDto = acceptCompanyService.getByCompanyCode(byId.getCompanyCode());
        // 构建 JSON 请求参数
        JSONObject json = new JSONObject();
        json.put("companyCode", byId.getCompanyCode());
        json.put("online", 1);

        if (null == acceptCompanySecretBackDto || StringUtil.isEmpty(acceptCompanySecretBackDto.getSecretKey())) {
            return Result.error("企业编号不存在");
        }
        try {
            HttpResponse response = HttpRequest.post(byId.getRydwSssj())
                    .body(json.toString()) // 将 JSON 对象转为字符串作为请求体
                    .contentType("application/json;charset=UTF-8")
                    .execute();
            String jsons = response.body();

            // 1. 先解析外层响应结构（不要直接 parse 成 AcceptPersonPosingRealBackDto！）
            JSONObject outerResponse = JSON.parseObject(jsons);

            // 2. 检查是否成功
            if (!outerResponse.getBooleanValue("success")) {
                return Result.error("接口调用失败: " + outerResponse.getString("message"));
            }

            // 3. 获取加密数据（Base64 字符串）
            String encryptedData = outerResponse.getJSONObject("result").getString("data");
            if (StringUtil.isEmpty(encryptedData)) {
                return Result.error("返回数据为空");
            }

            // 4. 解密
            byte[] decryptedBytes = AESUtil.decryptAES(encryptedData, acceptCompanySecretBackDto.getSecretKey());
            String decryptedJson = new String(decryptedBytes, StandardCharsets.UTF_8);

            // 5. 解析为最终对象
            AcceptPersonPosingRealBackDto acceptDangerInvestigationParamDto =
                    JSON.parseObject(decryptedJson, AcceptPersonPosingRealBackDto.class);

            // 补全id
            if (acceptDangerInvestigationParamDto != null) {
                if (Strings.isEmpty(acceptDangerInvestigationParamDto.getId())) {
                    acceptDangerInvestigationParamDto.setId(acceptDangerInvestigationParamDto.getUuid());
                }

                for (AcceptPersonPosingRealBackInfoDto investigationParamDtoChild : acceptDangerInvestigationParamDto.getChildren()) {
                    if (Strings.isEmpty(investigationParamDtoChild.getId())) {
                        investigationParamDtoChild.setId(investigationParamDtoChild.getUuid());
                    }

                    for (AcceptPersonPosingRealTimeInfoBackDto paramDtoChildChild : investigationParamDtoChild.getChildren()) {
                        if (Strings.isEmpty(paramDtoChildChild.getId())) {
                            paramDtoChildChild.setId(paramDtoChildChild.getUuid());
                        }
                    }
                }
            }

            return Result.OK(acceptDangerInvestigationParamDto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据解析或解密失败: " + e.getMessage(), e);
        }
    }


    /**
     * 历史数据
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "人员定位接收地址-历史数据")
    @ApiOperation(value = "人员定位接收地址-历史数据", notes = "人员定位接收地址-历史数据")
    @GetMapping(value = "/lssj")
    public Result<AcceptPersonPosingHitoryBackDto> lssj(@RequestParam(name = "id", required = true) String id, @RequestParam(name = "personId", required = true) String personId, @RequestParam(name = "startTime", required = true) String startTime, @RequestParam(name = "endTime", required = true) String endTime) {
        Rydwsslssj byId = rydwsslssjService.getById(id);
        //获取企业密钥
        AcceptCompany acceptCompanySecretBackDto = acceptCompanyService.getByCompanyCode(byId.getCompanyCode());
        // 构建 JSON 请求参数
        JSONObject json = new JSONObject();
        json.put("companyCode", byId.getCompanyCode());
        json.put("personId", personId);
        json.put("startTime", startTime);
        json.put("endTime", endTime);

        if (null == acceptCompanySecretBackDto || StringUtil.isEmpty(acceptCompanySecretBackDto.getSecretKey())) {
            return Result.error("企业编号不存在");
        }
        try {
            HttpResponse response = HttpRequest.post(byId.getRydwLssj())
                    .body(json.toString()) // 将 JSON 对象转为字符串作为请求体
                    .contentType("application/json;charset=UTF-8")
                    .execute();
            String jsons = response.body();

            // 1. 先解析外层响应结构（不要直接 parse 成 AcceptPersonPosingRealBackDto！）
            JSONObject outerResponse = JSON.parseObject(jsons);

            // 2. 检查是否成功
            if (!outerResponse.getBooleanValue("success")) {
                return Result.error("接口调用失败: " + outerResponse.getString("message"));
            }

            // 3. 获取加密数据（Base64 字符串）
            String encryptedData = outerResponse.getJSONObject("result").getString("data");
            if (StringUtil.isEmpty(encryptedData)) {
                return Result.error("返回数据为空");
            }

            // 4. 解密
            byte[] decryptedBytes = AESUtil.decryptAES(encryptedData, acceptCompanySecretBackDto.getSecretKey());
            String decryptedJson = new String(decryptedBytes, StandardCharsets.UTF_8);

            // 5. 解析为最终对象
            AcceptPersonPosingHitoryBackDto acceptDangerInvestigationParamDto =
                    JSON.parseObject(decryptedJson, AcceptPersonPosingHitoryBackDto.class);

            return Result.OK(acceptDangerInvestigationParamDto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据解析或解密失败: " + e.getMessage(), e);
        }
    }

    /**
     * 导出excel
     *
     * @param request
     * @param rydwsslssj
     */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Rydwsslssj rydwsslssj) {
        return super.exportXls(request, rydwsslssj, Rydwsslssj.class, "人员定位接收地址");
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
        return super.importExcel(request, response, Rydwsslssj.class);
    }

}
