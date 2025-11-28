package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx.entity.ChemicalInfo;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx.mapper.ChemicalInfoMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx.service.IChemicalInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 化学危险品目录信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ChemicalInfoServiceImpl extends ServiceImpl<ChemicalInfoMapper, ChemicalInfo> implements IChemicalInfoService {

}
