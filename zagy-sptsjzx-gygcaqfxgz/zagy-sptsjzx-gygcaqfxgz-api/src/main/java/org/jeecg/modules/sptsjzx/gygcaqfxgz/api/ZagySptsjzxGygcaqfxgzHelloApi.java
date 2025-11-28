package org.jeecg.modules.sptsjzx.gygcaqfxgz.api;
import org.jeecg.modules.sptsjzx.gygcaqfxgz.api.fallback.ZagySptsjzxGygcaqfxgzHelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zagy-sptsjzx-gygcaqfxgz", fallbackFactory = ZagySptsjzxGygcaqfxgzHelloFallback.class)
public interface ZagySptsjzxGygcaqfxgzHelloApi {

    /**
     * sptsjzx.gygcaqfxgz hello 微服务接口
     * @param
     * @return
     */
    @GetMapping(value = "/sptsjzx.gygcaqfxgz/hello")
    String callHello();
}
