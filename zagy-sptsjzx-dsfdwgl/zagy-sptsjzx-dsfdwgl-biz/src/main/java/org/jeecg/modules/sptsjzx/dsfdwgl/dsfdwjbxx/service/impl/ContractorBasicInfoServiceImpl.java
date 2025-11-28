package org.jeecg.modules.sptsjzx.dsfdwgl.dsfdwjbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfdwjbxx.entity.ContractorBasicInfo;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfdwjbxx.mapper.ContractorBasicInfoMapper;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfdwjbxx.service.IContractorBasicInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第三方单位基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ContractorBasicInfoServiceImpl extends ServiceImpl<ContractorBasicInfoMapper, ContractorBasicInfo> implements IContractorBasicInfoService {

}
