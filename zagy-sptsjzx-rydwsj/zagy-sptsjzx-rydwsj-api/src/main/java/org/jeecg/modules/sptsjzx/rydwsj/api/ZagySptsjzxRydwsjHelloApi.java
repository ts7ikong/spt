package org.jeecg.modules.sptsjzx.rydwsj.api;
import org.jeecg.modules.sptsjzx.rydwsj.api.fallback.ZagySptsjzxRydwsjHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-rydwsj", fallbackFactory = ZagySptsjzxRydwsjHelloFallback.class)
public interface ZagySptsjzxRydwsjHelloApi {

    /**
     * sptsjzx.rydwsj hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.rydwsj/hello")
    String callHello();
}
