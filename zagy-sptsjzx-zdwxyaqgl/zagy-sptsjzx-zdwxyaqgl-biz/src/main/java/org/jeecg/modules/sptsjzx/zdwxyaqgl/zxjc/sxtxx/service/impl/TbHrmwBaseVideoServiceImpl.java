package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.sxtxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.sxtxx.entity.TbHrmwBaseVideo;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.sxtxx.mapper.TbHrmwBaseVideoMapper;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.sxtxx.service.ITbHrmwBaseVideoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 摄像头信息
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Service
@DS("pg")
public class TbHrmwBaseVideoServiceImpl extends ServiceImpl<TbHrmwBaseVideoMapper, TbHrmwBaseVideo> implements ITbHrmwBaseVideoService {

}
