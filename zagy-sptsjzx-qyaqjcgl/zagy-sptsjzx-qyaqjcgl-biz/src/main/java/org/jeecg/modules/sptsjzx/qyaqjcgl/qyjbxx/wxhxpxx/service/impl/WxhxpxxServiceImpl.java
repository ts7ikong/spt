package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.entity.Wxhxpxx;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.mapper.WxhxpxxMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.service.IWxhxpxxService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 危险化学品信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class WxhxpxxServiceImpl extends ServiceImpl<WxhxpxxMapper, Wxhxpxx> implements IWxhxpxxService {

}
