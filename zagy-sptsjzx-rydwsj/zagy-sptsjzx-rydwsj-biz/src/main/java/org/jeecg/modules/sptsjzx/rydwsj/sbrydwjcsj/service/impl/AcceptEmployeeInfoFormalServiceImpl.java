package org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.entity.AcceptEmployeeInfoFormal;
import org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.mapper.AcceptEmployeeInfoFormalMapper;
import org.jeecg.modules.sptsjzx.rydwsj.sbrydwjcsj.service.IAcceptEmployeeInfoFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上报人员定位基础数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptEmployeeInfoFormalServiceImpl extends ServiceImpl<AcceptEmployeeInfoFormalMapper, AcceptEmployeeInfoFormal> implements IAcceptEmployeeInfoFormalService {

}
