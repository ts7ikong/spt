package org.jeecg.modules.sptsjzx.scyf.gwfxqd.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.gwfxqd.entity.AcceptRisklistFormal;
import org.jeecg.modules.sptsjzx.scyf.gwfxqd.mapper.AcceptRisklistFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.gwfxqd.service.IAcceptRisklistFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 岗位风险清单
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptRisklistFormalServiceImpl extends ServiceImpl<AcceptRisklistFormalMapper, AcceptRisklistFormal> implements IAcceptRisklistFormalService {

}
