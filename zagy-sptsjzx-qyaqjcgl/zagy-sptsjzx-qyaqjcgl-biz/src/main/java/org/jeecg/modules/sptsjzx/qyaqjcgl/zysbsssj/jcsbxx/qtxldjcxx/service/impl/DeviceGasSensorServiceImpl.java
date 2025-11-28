package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.entity.DeviceGasSensor;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.mapper.DeviceGasSensorMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx.service.IDeviceGasSensorService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 气体泄漏点监测信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class DeviceGasSensorServiceImpl extends ServiceImpl<DeviceGasSensorMapper, DeviceGasSensor> implements IDeviceGasSensorService {

}
