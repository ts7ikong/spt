package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.jeecg.common.api.dto.aqjcgl.YqjbxxDTO;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity.Yqjbxx;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.mapper.YqjbxxMapper;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.service.IYqjbxxService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 园区基本信息
 * @Author: zagy-cg
 * @Date: 2025-03-03
 * @Version: V1.0
 */
@Service
@Slf4j
public class YqjbxxServiceImpl extends ServiceImpl<YqjbxxMapper, Yqjbxx> implements IYqjbxxService {

    @Autowired
    ISysBaseAPI sysBaseAPI;

    @Override
    public void savee(Yqjbxx yqjbxx) {
        //自动生成36位UUID
        String uuid = UUID.randomUUID().toString();
        //设置为园区的uuid
        yqjbxx.setUuid(uuid);
        //先新增园区信息
        this.save(yqjbxx);
        //Yqjbxx 转成 YqjbxxDTO
        YqjbxxDTO yqjbxxDTO = new YqjbxxDTO();
        //相同字段的复制到Yqjbxx
        BeanUtils.copyProperties(yqjbxx, yqjbxxDTO);
        //给园区创建账号密码
        sysBaseAPI.xzyqyhxxToUser(yqjbxxDTO);
    }

    @Override
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response, Class<Yqjbxx> yqjbxxClass) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            // 获取上传文件对象
            MultipartFile file = entity.getValue();
            ImportParams params = new ImportParams();
            params.setTitleRows(2);
            params.setHeadRows(1);
            params.setNeedSave(true);
            try {
                List<Yqjbxx> list = ExcelImportUtil.importExcel(file.getInputStream(), Yqjbxx.class, params);
                //update-begin-author:taoyan date:20190528 for:批量插入数据
                long start = System.currentTimeMillis();
                list.forEach(n -> {
                    savee(n);
                });
                //400条 saveBatch消耗时间1592毫秒  循环插入消耗时间1947毫秒
                //1200条  saveBatch消耗时间3687毫秒 循环插入消耗时间5212毫秒
                log.info("消耗时间" + (System.currentTimeMillis() - start) + "毫秒");
                //update-end-author:taoyan date:20190528 for:批量插入数据
                return Result.ok("文件导入成功！数据行数：" + list.size());
            } catch (Exception e) {
                //update-begin-author:taoyan date:20211124 for: 导入数据重复增加提示
                String msg = e.getMessage();
                log.error(msg, e);
                if (msg != null && msg.indexOf("Duplicate entry") >= 0) {
                    return Result.error("文件导入失败:有重复数据！");
                } else {
                    return Result.error("文件导入失败:" + e.getMessage());
                }
                //update-end-author:taoyan date:20211124 for: 导入数据重复增加提示
            } finally {
                try {
                    file.getInputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Result.error("文件导入失败！");
    }

    @Override
    public void removeByIdd(String id) {
        //查询园区信息
        Yqjbxx yqjbxx = this.getById(id);
        //删除园区信息
        this.removeById(id);
        //Yqjbxx 转成 YqjbxxDTO
        YqjbxxDTO yqjbxxDTO = new YqjbxxDTO();
        //相同字段的复制到Yqjbxx
        BeanUtils.copyProperties(yqjbxx, yqjbxxDTO);
        //删除用户信息
        sysBaseAPI.scyqyhxxToUser(yqjbxxDTO);
    }

}
