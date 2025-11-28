package org.jeecg.modules.sptsjzx.scyf.aqfxdy.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.aqfxdy.entity.AcceptUnitFormal;
import org.jeecg.modules.sptsjzx.scyf.aqfxdy.mapper.AcceptUnitFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.aqfxdy.service.IAcceptUnitFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 安全风险单元
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptUnitFormalServiceImpl extends ServiceImpl<AcceptUnitFormalMapper, AcceptUnitFormal> implements IAcceptUnitFormalService {

}
