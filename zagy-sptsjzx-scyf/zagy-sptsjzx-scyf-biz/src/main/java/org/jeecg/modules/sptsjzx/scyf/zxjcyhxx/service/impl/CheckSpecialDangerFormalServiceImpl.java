package org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.entity.CheckSpecialDangerFormal;
import org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.mapper.CheckSpecialDangerFormalMapper;
import org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.service.ICheckSpecialDangerFormalService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 专项检查隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-25
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class CheckSpecialDangerFormalServiceImpl extends ServiceImpl<CheckSpecialDangerFormalMapper, CheckSpecialDangerFormal> implements ICheckSpecialDangerFormalService {

}
