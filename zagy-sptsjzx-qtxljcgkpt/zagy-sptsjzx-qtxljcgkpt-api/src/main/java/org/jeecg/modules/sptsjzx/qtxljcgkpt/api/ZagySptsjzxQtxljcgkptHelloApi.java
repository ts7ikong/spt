package org.jeecg.modules.sptsjzx.qtxljcgkpt.api;
import org.jeecg.modules.sptsjzx.qtxljcgkpt.api.fallback.ZagySptsjzxQtxljcgkptHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-qtxljcgkpt", fallbackFactory = ZagySptsjzxQtxljcgkptHelloFallback.class)
public interface ZagySptsjzxQtxljcgkptHelloApi {

    /**
     * sptsjzx.qtxljcgkpt hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.qtxljcgkpt/hello")
    String callHello();
}
