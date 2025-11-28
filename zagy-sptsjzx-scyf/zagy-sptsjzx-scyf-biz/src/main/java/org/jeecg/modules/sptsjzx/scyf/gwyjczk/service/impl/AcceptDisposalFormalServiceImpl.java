package org.jeecg.modules.sptsjzx.scyf.gwyjczk.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.gwyjczk.entity.AcceptDisposalFormal;
import org.jeecg.modules.sptsjzx.scyf.gwyjczk.mapper.AcceptDisposalFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.gwyjczk.service.IAcceptDisposalFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 应急岗位处置卡
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptDisposalFormalServiceImpl extends ServiceImpl<AcceptDisposalFormalMapper, AcceptDisposalFormal> implements IAcceptDisposalFormalService {

}
