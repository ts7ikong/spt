package org.jeecg.modules.sptsjzx.qtxljcgkpt.api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.jeecg.modules.sptsjzx.qtxljcgkpt.api.ZagySptsjzxQtxljcgkptHelloApi;
import lombok.Setter;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author JeecgBoot
 */
@Slf4j
@Component
public class ZagySptsjzxQtxljcgkptHelloFallback implements FallbackFactory<ZagySptsjzxQtxljcgkptHelloApi> {
    @Setter
    private Throwable cause;

    @Override
    public ZagySptsjzxQtxljcgkptHelloApi create(Throwable throwable) {
        log.error("微服务接口调用失败： {}", cause);
        return null;
    }

}
