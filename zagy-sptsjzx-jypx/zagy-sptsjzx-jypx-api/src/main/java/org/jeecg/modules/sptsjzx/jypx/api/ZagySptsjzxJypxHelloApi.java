package org.jeecg.modules.sptsjzx.jypx.api;
import org.jeecg.modules.sptsjzx.jypx.api.fallback.ZagySptsjzxJypxHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-jypx", fallbackFactory = ZagySptsjzxJypxHelloFallback.class)
public interface ZagySptsjzxJypxHelloApi {

    /**
     * sptsjzx.jypx hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.jypx/hello")
    String callHello();
}
