package org.jeecg.modules.sptsjzx.scyf.rzyqd.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.rzyqd.entity.AcceptQrcodeListFormal;
import org.jeecg.modules.sptsjzx.scyf.rzyqd.mapper.AcceptQrcodeListFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.rzyqd.service.IAcceptQrcodeListFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 日周月清单
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptQrcodeListFormalServiceImpl extends ServiceImpl<AcceptQrcodeListFormalMapper, AcceptQrcodeListFormal> implements IAcceptQrcodeListFormalService {

}
