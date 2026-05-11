package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.entity.TbHrmwMoniTargetCurrent;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.mapper.TbHrmwMoniTargetCurrentMapper;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.service.ITbHrmwMoniTargetCurrentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 指标监测实时数据
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Service
@DS("pg")
public class TbHrmwMoniTargetCurrentServiceImpl extends ServiceImpl<TbHrmwMoniTargetCurrentMapper, TbHrmwMoniTargetCurrent> implements ITbHrmwMoniTargetCurrentService {

    @Override
    public Map<String, String> getTargetNameMap(List<String> targetCodes) {
        if (targetCodes == null || targetCodes.isEmpty()) {
            return Collections.emptyMap();
        }
        List<Map<String, String>> list = baseMapper.queryTargetNamesByCodes(targetCodes);
        return list.stream().collect(Collectors.toMap(m -> m.get("code"), m -> m.get("name"), (a, b) -> a));
    }

}
