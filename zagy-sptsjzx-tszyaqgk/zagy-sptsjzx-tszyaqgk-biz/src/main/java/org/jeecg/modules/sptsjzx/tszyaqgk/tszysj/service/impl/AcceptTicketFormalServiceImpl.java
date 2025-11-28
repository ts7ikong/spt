package org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.entity.AcceptTicketFormal;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.mapper.AcceptTicketFormalMapper;
import org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.service.IAcceptTicketFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 特殊作业数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptTicketFormalServiceImpl extends ServiceImpl<AcceptTicketFormalMapper, AcceptTicketFormal> implements IAcceptTicketFormalService {

}
