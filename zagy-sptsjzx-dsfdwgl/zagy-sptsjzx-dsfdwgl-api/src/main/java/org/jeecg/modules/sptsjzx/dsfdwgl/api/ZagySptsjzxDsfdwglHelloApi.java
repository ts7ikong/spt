package org.jeecg.modules.sptsjzx.dsfdwgl.api;
import org.jeecg.modules.sptsjzx.dsfdwgl.api.fallback.ZagySptsjzxDsfdwglHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "jeecg-sptsjzx.dsfdwgl", fallbackFactory = ZagySptsjzxDsfdwglHelloFallback.class)
public interface ZagySptsjzxDsfdwglHelloApi {

    /**
     * sptsjzx.dsfdwgl hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.dsfdwgl/hello")
    String callHello();
}
