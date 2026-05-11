package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.entity.TbHrmwBaseTarget;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.mapper.TbHrmwBaseTargetMapper;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.service.ITbHrmwBaseTargetService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 监测指标信息
 * @Author: zagy-cg
 * @Date:   2026-04-21
 * @Version: V1.0
 */
@Service
@DS("pg")
public class TbHrmwBaseTargetServiceImpl extends ServiceImpl<TbHrmwBaseTargetMapper, TbHrmwBaseTarget> implements ITbHrmwBaseTargetService {

}
