package org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjhjsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjhjsj.entity.AcceptEnvironmentDataReceivingFormal;
import org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjhjsj.mapper.AcceptEnvironmentDataReceivingFormalMapper;
import org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjhjsj.service.IAcceptEnvironmentDataReceivingFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上报雷电预警环境数据
 * @Author: zagy-cg
 * @Date:   2025-06-25
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptEnvironmentDataReceivingFormalServiceImpl extends ServiceImpl<AcceptEnvironmentDataReceivingFormalMapper, AcceptEnvironmentDataReceivingFormal> implements IAcceptEnvironmentDataReceivingFormalService {

}
