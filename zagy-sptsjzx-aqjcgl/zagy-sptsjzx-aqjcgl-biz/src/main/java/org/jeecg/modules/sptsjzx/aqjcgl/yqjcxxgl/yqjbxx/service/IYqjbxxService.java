package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service;


import org.jeecg.common.api.vo.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity.Yqjbxx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: 园区基本信息
 * @Author: zagy-cg
 * @Date: 2025-03-03
 * @Version: V1.0
 */
public interface IYqjbxxService extends IService<Yqjbxx> {

    void savee(Yqjbxx yqjbxx);

    Result<?> importExcel(HttpServletRequest request, HttpServletResponse response, Class<Yqjbxx> yqjbxxClass);

    void removeByIdd(String id);

    /**
     * 根据园区行政区划编码获取园区编码列表
     * @param parkAreaCode 园区行政区划编码（对应登录用户的orgCode）
     * @return 园区编码列表
     */
    List<String> getParkCodesByAreaCode(String parkAreaCode);
}
