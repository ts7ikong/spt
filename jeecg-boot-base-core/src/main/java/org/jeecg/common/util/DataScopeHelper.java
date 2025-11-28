package org.jeecg.common.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.springframework.stereotype.Component;

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
     * 判断当前用户是否是市级平台账号
     * 市级平台账号可以看到所有区县的数据，不受数据权限限制
     *
     * 判断规则：
     * 1. orgCode为null或空字符串 → 市级平台
     * 2. orgCode为"500000"或以"0000"结尾 → 市级平台
     * 3. 其他情况 → 区县平台
     *
     * @return true表示是市级平台，false表示是区县平台
     */
    public static boolean isCityLevelPlatform() {
        String orgCode = getCurrentUserOrgCode();

        // 1. orgCode为空，认为是市级平台
        if (orgCode == null || orgCode.trim().isEmpty()) {
            return true;
        }

        // 2. orgCode为"500000"或以"0000"结尾，认为是市级平台
        if (orgCode.equals("500000") || orgCode.endsWith("0000")) {
            return true;
        }

        // 3. 其他情况为区县平台
        return false;
    }

    /**
     * 判断是否需要应用数据权限过滤
     *
     * @return true表示需要过滤（区县账号），false表示不需要（市平台账号）
     */
    public static boolean needDataScope() {
        // 市级平台账号不需要数据权限过滤
        return !isCityLevelPlatform();
    }

    /**
     * 根据区县编码获取企业编码列表
     * 注意：这个方法需要在Spring容器中使用，通过注入的Service来调用
     *
     * @param orgCode 区县编码
     * @return 企业编码列表
     */
    public static List<String> getCompanyCodesByOrgCode(String orgCode) {
        // 这个方法将由具体的Service实现类提供
        // 这里只是一个占位符，实际使用时需要通过注入的方式调用
        return new ArrayList<>();
    }

    /**
     * 根据区县编码获取园区编码列表
     * 注意：这个方法需要在Spring容器中使用，通过注入的Service来调用
     *
     * @param orgCode 区县编码
     * @return 园区编码列表
     */
    public static List<String> getParkCodesByOrgCode(String orgCode) {
        // 这个方法将由具体的Service实现类提供
        // 这里只是一个占位符，实际使用时需要通过注入的方式调用
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
