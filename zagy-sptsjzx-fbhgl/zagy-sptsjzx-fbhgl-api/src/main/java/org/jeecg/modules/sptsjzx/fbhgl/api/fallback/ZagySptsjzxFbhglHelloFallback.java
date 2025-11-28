package org.jeecg.modules.sptsjzx.fbhgl.api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.jeecg.modules.sptsjzx.fbhgl.api.ZagySptsjzxFbhglHelloApi;
import lombok.Setter;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author JeecgBoot
 */
@Slf4j
@Component
public class ZagySptsjzxFbhglHelloFallback implements FallbackFactory<ZagySptsjzxFbhglHelloApi> {
    @Setter
    private Throwable cause;

    @Override
    public ZagySptsjzxFbhglHelloApi create(Throwable throwable) {
        log.error("微服务接口调用失败： {}", cause);
        return null;
    }

}
