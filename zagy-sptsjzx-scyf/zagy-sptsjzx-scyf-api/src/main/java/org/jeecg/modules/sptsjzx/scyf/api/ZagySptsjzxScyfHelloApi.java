package org.jeecg.modules.sptsjzx.scyf.api;
import org.jeecg.modules.sptsjzx.scyf.api.fallback.ZagySptsjzxScyfHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-scyf", fallbackFactory = ZagySptsjzxScyfHelloFallback.class)
public interface ZagySptsjzxScyfHelloApi {

    /**
     * sptsjzx.scyf hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.scyf/hello")
    String callHello();
}
