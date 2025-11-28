package org.jeecg.modules.sptsjzx.zdwxyaqgl.api;
import org.jeecg.modules.sptsjzx.zdwxyaqgl.api.fallback.ZagySptsjzxZdwxyaqglHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-zdwxyaqgl", fallbackFactory = ZagySptsjzxZdwxyaqglHelloFallback.class)
public interface ZagySptsjzxZdwxyaqglHelloApi {

    /**
     * sptsjzx.zdwxyaqgl hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.zdwxyaqgl/hello")
    String callHello();
}
