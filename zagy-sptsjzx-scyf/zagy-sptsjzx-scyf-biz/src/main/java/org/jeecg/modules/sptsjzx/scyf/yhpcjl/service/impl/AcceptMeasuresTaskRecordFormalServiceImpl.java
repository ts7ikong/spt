package org.jeecg.modules.sptsjzx.scyf.yhpcjl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.yhpcjl.entity.AcceptMeasuresTaskRecordFormal;
import org.jeecg.modules.sptsjzx.scyf.yhpcjl.mapper.AcceptMeasuresTaskRecordFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.yhpcjl.service.IAcceptMeasuresTaskRecordFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 隐患排查记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptMeasuresTaskRecordFormalServiceImpl extends ServiceImpl<AcceptMeasuresTaskRecordFormalMapper, AcceptMeasuresTaskRecordFormal> implements IAcceptMeasuresTaskRecordFormalService {

}
