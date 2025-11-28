package org.jeecg.modules.sptsjzx.aqjcgl.api;
import org.jeecg.modules.sptsjzx.aqjcgl.api.fallback.ZagySptsjzxAqjcglHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-aqjcgl", fallbackFactory = ZagySptsjzxAqjcglHelloFallback.class)
public interface ZagySptsjzxAqjcglHelloApi {

    /**
     * sptsjzx.aqjcgl hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx/aqjcgl/hello")
    String callHello();
}
