package org.jeecg.modules.sptsjzx.scyf.aqfxgkcs.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.aqfxgkcs.entity.AcceptControlMeasuresFormal;
import org.jeecg.modules.sptsjzx.scyf.aqfxgkcs.mapper.AcceptControlMeasuresFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.aqfxgkcs.service.IAcceptControlMeasuresFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 安全风险管控措施
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptControlMeasuresFormalServiceImpl extends ServiceImpl<AcceptControlMeasuresFormalMapper, AcceptControlMeasuresFormal> implements IAcceptControlMeasuresFormalService {

}
