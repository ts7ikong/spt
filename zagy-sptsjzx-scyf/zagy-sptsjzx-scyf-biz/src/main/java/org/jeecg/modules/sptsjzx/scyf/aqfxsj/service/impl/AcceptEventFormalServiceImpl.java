package org.jeecg.modules.sptsjzx.scyf.aqfxsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.aqfxsj.entity.AcceptEventFormal;
import org.jeecg.modules.sptsjzx.scyf.aqfxsj.mapper.AcceptEventFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.aqfxsj.service.IAcceptEventFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 安全风险事件
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptEventFormalServiceImpl extends ServiceImpl<AcceptEventFormalMapper, AcceptEventFormal> implements IAcceptEventFormalService {

}
