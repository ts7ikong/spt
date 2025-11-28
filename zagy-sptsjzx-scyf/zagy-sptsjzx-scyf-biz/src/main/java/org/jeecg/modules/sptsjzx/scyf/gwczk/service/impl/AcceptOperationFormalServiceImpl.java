package org.jeecg.modules.sptsjzx.scyf.gwczk.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.gwczk.entity.AcceptOperationFormal;
import org.jeecg.modules.sptsjzx.scyf.gwczk.mapper.AcceptOperationFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.gwczk.service.IAcceptOperationFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 岗位操作卡
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptOperationFormalServiceImpl extends ServiceImpl<AcceptOperationFormalMapper, AcceptOperationFormal> implements IAcceptOperationFormalService {

}
