package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.entity.AcceptHazardCode;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.mapper.AcceptHazardCodeMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.service.IAcceptHazardCodeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 重大危险源信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptHazardCodeServiceImpl extends ServiceImpl<AcceptHazardCodeMapper, AcceptHazardCode> implements IAcceptHazardCodeService {

}
