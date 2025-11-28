package org.jeecg.modules.sptsjzx.dsfdwgl.dsfwgjl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfwgjl.entity.ContractorViolationRecord;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfwgjl.mapper.ContractorViolationRecordMapper;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfwgjl.service.IContractorViolationRecordService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第三方违规记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ContractorViolationRecordServiceImpl extends ServiceImpl<ContractorViolationRecordMapper, ContractorViolationRecord> implements IContractorViolationRecordService {

}
