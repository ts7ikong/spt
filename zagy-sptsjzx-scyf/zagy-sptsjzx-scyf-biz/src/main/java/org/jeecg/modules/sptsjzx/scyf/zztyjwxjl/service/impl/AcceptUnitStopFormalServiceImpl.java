package org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.entity.AcceptUnitStopFormal;
import org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.mapper.AcceptUnitStopFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.zztyjwxjl.service.IAcceptUnitStopFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 装置停用/检维修记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptUnitStopFormalServiceImpl extends ServiceImpl<AcceptUnitStopFormalMapper, AcceptUnitStopFormal> implements IAcceptUnitStopFormalService {

}
