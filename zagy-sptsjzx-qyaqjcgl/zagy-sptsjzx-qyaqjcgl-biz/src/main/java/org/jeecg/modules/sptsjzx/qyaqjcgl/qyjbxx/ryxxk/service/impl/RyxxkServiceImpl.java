package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.entity.Ryxxk;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.mapper.RyxxkMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.service.IRyxxkService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 人员信息库
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class RyxxkServiceImpl extends ServiceImpl<RyxxkMapper, Ryxxk> implements IRyxxkService {

}
