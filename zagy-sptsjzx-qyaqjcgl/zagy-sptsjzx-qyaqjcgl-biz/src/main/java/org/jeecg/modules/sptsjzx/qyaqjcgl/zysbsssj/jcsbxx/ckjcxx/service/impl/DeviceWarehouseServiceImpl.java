package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.ckjcxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.ckjcxx.entity.DeviceWarehouse;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.ckjcxx.mapper.DeviceWarehouseMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.ckjcxx.service.IDeviceWarehouseService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 仓库基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class DeviceWarehouseServiceImpl extends ServiceImpl<DeviceWarehouseMapper, DeviceWarehouse> implements IDeviceWarehouseService {

}
