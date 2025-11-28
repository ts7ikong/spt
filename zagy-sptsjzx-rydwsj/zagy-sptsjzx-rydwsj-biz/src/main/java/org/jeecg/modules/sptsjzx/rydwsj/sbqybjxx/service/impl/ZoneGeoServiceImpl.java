package org.jeecg.modules.sptsjzx.rydwsj.sbqybjxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjxx.entity.ZoneGeo;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjxx.mapper.ZoneGeoMapper;
import org.jeecg.modules.sptsjzx.rydwsj.sbqybjxx.service.IZoneGeoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上报区域边界信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class ZoneGeoServiceImpl extends ServiceImpl<ZoneGeoMapper, ZoneGeo> implements IZoneGeoService {

}
