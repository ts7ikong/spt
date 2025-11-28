package org.jeecg.modules.sptsjzx.scyf.gwzzqd.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.gwzzqd.entity.AcceptDutyFormal;
import org.jeecg.modules.sptsjzx.scyf.gwzzqd.mapper.AcceptDutyFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.gwzzqd.service.IAcceptDutyFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 岗位职责清单
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptDutyFormalServiceImpl extends ServiceImpl<AcceptDutyFormalMapper, AcceptDutyFormal> implements IAcceptDutyFormalService {

}
