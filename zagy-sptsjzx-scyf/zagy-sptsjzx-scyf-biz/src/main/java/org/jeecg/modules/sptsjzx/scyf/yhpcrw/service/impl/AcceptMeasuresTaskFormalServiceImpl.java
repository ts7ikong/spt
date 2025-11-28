package org.jeecg.modules.sptsjzx.scyf.yhpcrw.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.yhpcrw.entity.AcceptMeasuresTaskFormal;
import org.jeecg.modules.sptsjzx.scyf.yhpcrw.mapper.AcceptMeasuresTaskFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.yhpcrw.service.IAcceptMeasuresTaskFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 隐患排查任务
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptMeasuresTaskFormalServiceImpl extends ServiceImpl<AcceptMeasuresTaskFormalMapper, AcceptMeasuresTaskFormal> implements IAcceptMeasuresTaskFormalService {

}
