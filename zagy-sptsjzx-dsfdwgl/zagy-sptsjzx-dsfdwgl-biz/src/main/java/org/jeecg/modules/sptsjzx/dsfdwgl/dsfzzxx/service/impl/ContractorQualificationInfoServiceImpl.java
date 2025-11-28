package org.jeecg.modules.sptsjzx.dsfdwgl.dsfzzxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfzzxx.entity.ContractorQualificationInfo;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfzzxx.mapper.ContractorQualificationInfoMapper;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfzzxx.service.IContractorQualificationInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第三方资质信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ContractorQualificationInfoServiceImpl extends ServiceImpl<ContractorQualificationInfoMapper, ContractorQualificationInfo> implements IContractorQualificationInfoService {

}
