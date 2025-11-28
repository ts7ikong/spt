package org.jeecg.modules.sptsjzx.rydwsj.sbqybjsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjsj.entity.Qybjsj;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjsj.mapper.QybjsjMapper;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjsj.service.IQybjsjService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上报区域报警数据
 * @Author: zagy-cg
 * @Date:   2025-06-26
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class QybjsjServiceImpl extends ServiceImpl<QybjsjMapper, Qybjsj> implements IQybjsjService {

}
