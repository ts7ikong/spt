package org.jeecg.modules.sptsjzx.mjyj.api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.jeecg.modules.sptsjzx.mjyj.api.ZagySptsjzxMjyjHelloApi;
import lombok.Setter;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author JeecgBoot
 */
@Slf4j
@Component
public class ZagySptsjzxMjyjHelloFallback implements FallbackFactory<ZagySptsjzxMjyjHelloApi> {
    @Setter
    private Throwable cause;

    @Override
    public ZagySptsjzxMjyjHelloApi create(Throwable throwable) {
        log.error("微服务接口调用失败： {}", cause);
        return null;
    }

}
