package org.jeecg.modules.sptsjzx.rydwsj.sbrybjsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.rydwsj.sbrybjsj.entity.Rybjsj;
import org.jeecg.modules.sptsjzx.rydwsj.sbrybjsj.mapper.RybjsjMapper;
import org.jeecg.modules.sptsjzx.rydwsj.sbrybjsj.service.IRybjsjService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上报人员报警数据
 * @Author: zagy-cg
 * @Date:   2025-06-26
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class RybjsjServiceImpl extends ServiceImpl<RybjsjMapper, Rybjsj> implements IRybjsjService {

}
