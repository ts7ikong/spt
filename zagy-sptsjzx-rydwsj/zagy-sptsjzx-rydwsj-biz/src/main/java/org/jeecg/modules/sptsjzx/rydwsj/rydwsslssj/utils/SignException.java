package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.utils;

import lombok.EqualsAndHashCode;


/**
 * 数据签名异常
 * 
 * @author 14059
 * @version V1.0
 * @date 2022/6/24 15:59
 */
@EqualsAndHashCode(callSuper = true)
public class SignException extends RuntimeException {
    public SignException(String message) {
        super(message);
    }

    public SignException(Throwable cause) {
        super(cause.getMessage());
    }

}
