package org.jeecg.modules.sptsjzx.ldyjyhjjc.api;
import org.jeecg.modules.sptsjzx.ldyjyhjjc.api.fallback.ZagySptsjzxLdyjyhjjcHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-ldyjyhjjc", fallbackFactory = ZagySptsjzxLdyjyhjjcHelloFallback.class)
public interface ZagySptsjzxLdyjyhjjcHelloApi {

    /**
     * sptsjzx.ldyjyhjjc hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.ldyjyhjjc/hello")
    String callHello();
}
