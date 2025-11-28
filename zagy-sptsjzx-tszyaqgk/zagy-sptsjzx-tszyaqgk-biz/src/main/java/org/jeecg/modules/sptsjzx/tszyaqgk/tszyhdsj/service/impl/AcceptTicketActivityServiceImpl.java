package org.jeecg.modules.sptsjzx.tszyaqgk.tszyhdsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszyhdsj.entity.AcceptTicketActivity;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszyhdsj.mapper.AcceptTicketActivityMapper;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszyhdsj.service.IAcceptTicketActivityService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 特殊作业活动（计划）数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptTicketActivityServiceImpl extends ServiceImpl<AcceptTicketActivityMapper, AcceptTicketActivity> implements IAcceptTicketActivityService {

}
