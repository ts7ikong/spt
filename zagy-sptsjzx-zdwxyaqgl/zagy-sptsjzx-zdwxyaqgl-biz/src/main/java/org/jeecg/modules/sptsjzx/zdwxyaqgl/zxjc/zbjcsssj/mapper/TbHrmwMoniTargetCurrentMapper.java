package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.entity.TbHrmwMoniTargetCurrent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 指标监测实时数据
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
public interface TbHrmwMoniTargetCurrentMapper extends BaseMapper<TbHrmwMoniTargetCurrent> {

    @Select("<script>SELECT target_code AS code, target_name AS name FROM v_hrmw_target_with_company WHERE target_code IN <foreach collection='codes' item='code' open='(' separator=',' close=')'>#{code}</foreach></script>")
    List<Map<String, String>> queryTargetNamesByCodes(@Param("codes") List<String> codes);

}
