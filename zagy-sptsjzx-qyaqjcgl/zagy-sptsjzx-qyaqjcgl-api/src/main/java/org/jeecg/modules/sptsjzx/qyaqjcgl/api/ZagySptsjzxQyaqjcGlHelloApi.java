package org.jeecg.modules.sptsjzx.qyaqjcgl.api;
import org.jeecg.modules.sptsjzx.qyaqjcgl.api.fallback.ZagySptsjzxQyaqjcGlHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-qyaqjcgl", fallbackFactory = ZagySptsjzxQyaqjcGlHelloFallback.class)
public interface ZagySptsjzxQyaqjcGlHelloApi {

    /**
     * sptsjzx.qyaqjcgl hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.qyaqjcgl/hello")
    String callHello();
}
