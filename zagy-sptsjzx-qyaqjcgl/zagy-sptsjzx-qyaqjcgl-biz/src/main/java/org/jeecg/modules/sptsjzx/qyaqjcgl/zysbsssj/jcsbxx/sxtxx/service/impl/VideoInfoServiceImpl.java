package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sxtxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sxtxx.entity.VideoInfo;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sxtxx.mapper.VideoInfoMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sxtxx.service.IVideoInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 摄像头信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class VideoInfoServiceImpl extends ServiceImpl<VideoInfoMapper, VideoInfo> implements IVideoInfoService {

}
