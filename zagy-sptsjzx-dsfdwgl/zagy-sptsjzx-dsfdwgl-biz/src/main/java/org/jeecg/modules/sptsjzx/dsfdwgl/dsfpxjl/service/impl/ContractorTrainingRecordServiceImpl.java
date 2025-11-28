package org.jeecg.modules.sptsjzx.dsfdwgl.dsfpxjl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfpxjl.entity.ContractorTrainingRecord;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfpxjl.mapper.ContractorTrainingRecordMapper;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfpxjl.service.IContractorTrainingRecordService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第三方培训记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ContractorTrainingRecordServiceImpl extends ServiceImpl<ContractorTrainingRecordMapper, ContractorTrainingRecord> implements IContractorTrainingRecordService {

}
