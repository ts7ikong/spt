package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.entity.TankDeviceInfo;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.mapper.TankDeviceInfoMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.service.ITankDeviceInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 储罐基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class TankDeviceInfoServiceImpl extends ServiceImpl<TankDeviceInfoMapper, TankDeviceInfo> implements ITankDeviceInfoService {

}
