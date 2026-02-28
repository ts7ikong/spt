package org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.entity.RydwDataQualityExport;
import org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.mapper.RydwDataQualityExportMapper;
import org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.service.IRydwDataQualityExportService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 人员定位接入情况
 * @Author: zagy-cg
 * @Date:   2026-01-29
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class RydwDataQualityExportServiceImpl extends ServiceImpl<RydwDataQualityExportMapper, RydwDataQualityExport> implements IRydwDataQualityExportService {

}
