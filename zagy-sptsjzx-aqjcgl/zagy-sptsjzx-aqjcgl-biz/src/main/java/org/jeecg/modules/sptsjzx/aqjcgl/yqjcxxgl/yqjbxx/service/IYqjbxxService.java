package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service;


import org.jeecg.common.api.vo.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity.Yqjbxx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
