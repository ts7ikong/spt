package org.jeecg.modules.sptsjzx.scyf.yhxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.yhxx.entity.AcceptDangerInvestigationFormal;
import org.jeecg.modules.sptsjzx.scyf.yhxx.mapper.AcceptDangerInvestigationFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.yhxx.service.IAcceptDangerInvestigationFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptDangerInvestigationFormalServiceImpl extends ServiceImpl<AcceptDangerInvestigationFormalMapper, AcceptDangerInvestigationFormal> implements IAcceptDangerInvestigationFormalService {

}
