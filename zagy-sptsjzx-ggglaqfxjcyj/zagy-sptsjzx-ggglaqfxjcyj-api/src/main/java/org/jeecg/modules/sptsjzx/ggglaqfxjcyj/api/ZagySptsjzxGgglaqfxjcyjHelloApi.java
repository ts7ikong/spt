package org.jeecg.modules.sptsjzx.ggglaqfxjcyj.api;
import org.jeecg.modules.sptsjzx.ggglaqfxjcyj.api.fallback.ZagySptsjzxGgglaqfxjcyjHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-ggglaqfxjcyj", fallbackFactory = ZagySptsjzxGgglaqfxjcyjHelloFallback.class)
public interface ZagySptsjzxGgglaqfxjcyjHelloApi {

    /**
     * sptsjzx.ggglaqfxjcyj hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.ggglaqfxjcyj/hello")
    String callHello();
}
