package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.entity.DeviceBaseInfo;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.mapper.DeviceBaseInfoMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.service.IDeviceBaseInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 设备信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class DeviceBaseInfoServiceImpl extends ServiceImpl<DeviceBaseInfoMapper, DeviceBaseInfo> implements IDeviceBaseInfoService {

}
