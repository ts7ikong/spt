package org.jeecg.modules.sptsjzx.fbhgl.api;
import org.jeecg.modules.sptsjzx.fbhgl.api.fallback.ZagySptsjzxFbhglHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-fbhgl", fallbackFactory = ZagySptsjzxFbhglHelloFallback.class)
public interface ZagySptsjzxFbhglHelloApi {

    /**
     * sptsjzx.fbhgl hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.fbhgl/hello")
    String callHello();
}
