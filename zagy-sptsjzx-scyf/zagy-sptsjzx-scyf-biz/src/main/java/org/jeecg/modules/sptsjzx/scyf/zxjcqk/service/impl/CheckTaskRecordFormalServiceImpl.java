package org.jeecg.modules.sptsjzx.scyf.zxjcqk.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.zxjcqk.entity.CheckTaskRecordFormal;
import org.jeecg.modules.sptsjzx.scyf.zxjcqk.mapper.CheckTaskRecordFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.zxjcqk.service.ICheckTaskRecordFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 专项检查情况
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class CheckTaskRecordFormalServiceImpl extends ServiceImpl<CheckTaskRecordFormalMapper, CheckTaskRecordFormal> implements ICheckTaskRecordFormalService {

}
