package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbtyjl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbtyjl.entity.DeviceStopRecord;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbtyjl.mapper.DeviceStopRecordMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbtyjl.service.IDeviceStopRecordService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 设备停用记录
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class DeviceStopRecordServiceImpl extends ServiceImpl<DeviceStopRecordMapper, DeviceStopRecord> implements IDeviceStopRecordService {

}
