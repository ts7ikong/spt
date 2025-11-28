package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.entity.DeviceBaseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 设备信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
public interface DeviceBaseInfoMapper extends BaseMapper<DeviceBaseInfo> {
    List<Map<String, Object>> getDeviceTypeStats(@Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("companyCode") String companyCode,
                                                 @Param("isScqy") Integer isScqy);
}
