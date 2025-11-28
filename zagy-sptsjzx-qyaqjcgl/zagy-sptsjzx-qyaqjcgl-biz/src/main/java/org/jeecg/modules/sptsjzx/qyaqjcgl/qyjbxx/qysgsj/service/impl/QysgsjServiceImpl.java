package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.entity.Qysgsj;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.mapper.QysgsjMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.service.IQysgsjService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 企业事故事件
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class QysgsjServiceImpl extends ServiceImpl<QysgsjMapper, Qysgsj> implements IQysgsjService {

}
