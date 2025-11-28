package org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.entity.AcceptTicketVideo;
import org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.mapper.AcceptTicketVideoMapper;
import org.jeecg.modules.sptsjzx.tszyaqgk.zypyspgl.service.IAcceptTicketVideoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 作业票与视频关联
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptTicketVideoServiceImpl extends ServiceImpl<AcceptTicketVideoMapper, AcceptTicketVideo> implements IAcceptTicketVideoService {

}
