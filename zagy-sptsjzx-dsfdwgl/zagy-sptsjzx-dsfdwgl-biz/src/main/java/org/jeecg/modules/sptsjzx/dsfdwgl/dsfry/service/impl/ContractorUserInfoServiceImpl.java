package org.jeecg.modules.sptsjzx.dsfdwgl.dsfry.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfry.entity.ContractorUserInfo;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfry.mapper.ContractorUserInfoMapper;
import org.jeecg.modules.sptsjzx.dsfdwgl.dsfry.service.IContractorUserInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第三方人员
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ContractorUserInfoServiceImpl extends ServiceImpl<ContractorUserInfoMapper, ContractorUserInfo> implements IContractorUserInfoService {

}
