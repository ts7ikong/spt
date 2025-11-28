package org.jeecg.modules.sptsjzx.mjyj.api;
import org.jeecg.modules.sptsjzx.mjyj.api.fallback.ZagySptsjzxMjyjHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-mjyj", fallbackFactory = ZagySptsjzxMjyjHelloFallback.class)
public interface ZagySptsjzxMjyjHelloApi {

    /**
     * sptsjzx.mjyj hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.mjyj/hello")
    String callHello();
}
