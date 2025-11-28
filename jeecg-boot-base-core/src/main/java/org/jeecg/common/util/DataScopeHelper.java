package org.jeecg.common.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 数据权限过滤工具类
 * 根据登录用户的区县编码（orgCode），自动过滤企业和园区数据
 * @Author: zagy-cg
 * @Date: 2025-11-28
 * @Version: V1.0
 */
@Slf4j
@Component
public class DataScopeHelper {

    /**
     * 获取当前登录用户的区县编码（orgCode）
     * @return 区县编码，如果未登录则返回null
     */
    public static String getCurrentUserOrgCode() {
        try {
            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
            if (loginUser != null) {
                return loginUser.getOrgCode();
            }
        } catch (Exception e) {
            log.warn("获取当前用户orgCode失败: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取当前登录用户
     * @return 登录用户信息
     */
    public static LoginUser getCurrentUser() {
        try {
            return (LoginUser) SecurityUtils.getSubject().getPrincipal();
        } catch (Exception e) {
            log.warn("获取当前用户失败: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 判断是否需要应用数据权限过滤
     * @return true表示需要过滤，false表示不需要（如管理员）
     */
    public static boolean needDataScope() {
        String orgCode = getCurrentUserOrgCode();
        // 如果orgCode为空，不进行过滤
        return orgCode != null && !orgCode.isEmpty();
    }

    /**
     * 根据区县编码获取企业编码列表（通过Spring容器动态获取Service）
     * @param orgCode 区县编码
     * @return 企业编码列表
     */
    @SuppressWarnings("unchecked")
    public static List<String> getCompanyCodesByOrgCode(String orgCode) {
        if (orgCode == null || orgCode.isEmpty()) {
            return new ArrayList<>();
        }

        try {
            // 通过Spring容器获取AcceptCompanyService
            Object acceptCompanyService = SpringContextUtils.getBean("acceptCompanyServiceImpl");
            if (acceptCompanyService != null) {
                Method method = acceptCompanyService.getClass().getMethod("getCompanyCodesByCountyCode", String.class);
                Object result = method.invoke(acceptCompanyService, orgCode);
                if (result instanceof List) {
                    return (List<String>) result;
                }
            }
        } catch (Exception e) {
            log.warn("动态获取企业编码列表失败: {}", e.getMessage());
        }

        return new ArrayList<>();
    }

    /**
     * 根据区县编码获取园区编码列表（通过Spring容器动态获取Service）
     * @param orgCode 区县编码
     * @return 园区编码列表
     */
    @SuppressWarnings("unchecked")
    public static List<String> getParkCodesByOrgCode(String orgCode) {
        if (orgCode == null || orgCode.isEmpty()) {
            return new ArrayList<>();
        }

        try {
            // 通过Spring容器获取YqjbxxService
            Object yqjbxxService = SpringContextUtils.getBean("yqjbxxServiceImpl");
            if (yqjbxxService != null) {
                Method method = yqjbxxService.getClass().getMethod("getParkCodesByAreaCode", String.class);
                Object result = method.invoke(yqjbxxService, orgCode);
                if (result instanceof List) {
                    return (List<String>) result;
                }
            }
        } catch (Exception e) {
            log.warn("动态获取园区编码列表失败: {}", e.getMessage());
        }

        return new ArrayList<>();
    }

    /**
     * 为QueryWrapper添加企业编码的数据权限过滤条件
     *
     * @param queryWrapper 查询条件包装器
     * @param companyCodes 企业编码列表
     * @param fieldName 字段名（如：company_code, companyCode, reportCompanyCode等）
     * @param <T> 实体类型
     */
    public static <T> void applyCompanyCodeFilter(QueryWrapper<T> queryWrapper, List<String> companyCodes, String fieldName) {
        if (companyCodes != null && !companyCodes.isEmpty()) {
            queryWrapper.in(fieldName, companyCodes);
        } else {
            // 如果没有符合条件的企业，则返回空结果
            queryWrapper.apply("1=0");
        }
    }

    /**
     * 为QueryWrapper添加园区编码的数据权限过滤条件
     *
     * @param queryWrapper 查询条件包装器
     * @param parkCodes 园区编码列表
     * @param fieldName 字段名（如：park_code, parkCode等）
     * @param <T> 实体类型
     */
    public static <T> void applyParkCodeFilter(QueryWrapper<T> queryWrapper, List<String> parkCodes, String fieldName) {
        if (parkCodes != null && !parkCodes.isEmpty()) {
            queryWrapper.in(fieldName, parkCodes);
        } else {
            // 如果没有符合条件的园区，则返回空结果
            queryWrapper.apply("1=0");
        }
    }

    /**
     * 为QueryWrapper添加区县编码的数据权限过滤条件
     * 用于直接包含countycode字段的表
     *
     * @param queryWrapper 查询条件包装器
     * @param fieldName 字段名（如：countycode, county_code等）
     * @param <T> 实体类型
     */
    public static <T> void applyOrgCodeFilter(QueryWrapper<T> queryWrapper, String fieldName) {
        String orgCode = getCurrentUserOrgCode();
        if (orgCode != null && !orgCode.isEmpty()) {
            queryWrapper.eq(fieldName, orgCode);
        }
    }
}
