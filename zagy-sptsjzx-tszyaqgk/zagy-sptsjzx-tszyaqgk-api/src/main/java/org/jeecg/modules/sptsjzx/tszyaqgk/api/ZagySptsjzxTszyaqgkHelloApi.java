package org.jeecg.modules.sptsjzx.tszyaqgk.api;
import org.jeecg.modules.sptsjzx.tszyaqgk.api.fallback.ZagySptsjzxTszyaqgkHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-tszyaqgk", fallbackFactory = ZagySptsjzxTszyaqgkHelloFallback.class)
public interface ZagySptsjzxTszyaqgkHelloApi {

    /**
     * sptsjzx.tszyaqgk hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.tszyaqgk/hello")
    String callHello();
}
