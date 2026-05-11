package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.entity.TbHrmwMoniAlarm;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.mapper.TbHrmwMoniAlarmMapper;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.service.ITbHrmwMoniAlarmService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 指标监测报警数据
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Service
@DS("pg")
public class TbHrmwMoniAlarmServiceImpl extends ServiceImpl<TbHrmwMoniAlarmMapper, TbHrmwMoniAlarm> implements ITbHrmwMoniAlarmService {

}
