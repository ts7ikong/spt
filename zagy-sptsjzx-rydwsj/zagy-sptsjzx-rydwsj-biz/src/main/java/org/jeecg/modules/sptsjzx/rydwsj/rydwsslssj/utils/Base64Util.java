package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64Util
 *
 * @author 14059
 * @version V1.0
 * @date 2022/4/26 14:28
 */
public class Base64Util {

    /**
     * 字节数组转Base64编码
     *
     * @param bytes 字节数组
     * @return 字节数组
     */
    public static String byte2Base64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Base64编码转字节数组
     *
     * @param base64Key Base64编码
     * @return Base64编码
     */
    public static byte[] base642Byte(String base64Key) {
        return Base64.getDecoder().decode(base64Key.getBytes(StandardCharsets.UTF_8));
    }

}
