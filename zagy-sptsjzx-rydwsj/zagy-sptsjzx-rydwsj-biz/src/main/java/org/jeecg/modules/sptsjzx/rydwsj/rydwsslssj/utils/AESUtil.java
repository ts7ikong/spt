package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.utils;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

/**
 * AES加密工具类
 *
 * @author 14059
 * @version V1.0
 * @date 2022/4/26 14:28
 */
public class AESUtil {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final String IV = "EWzAeGSzkNQ2q.##";

    /**
     * 生成AES秘钥，然后Base64编码
     *
     * @return Base64编码
     */
    public static String genKeyAES() {

        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey key = keyGen.generateKey();
            return Base64Util.byte2Base64(key.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new SignException("校验失败");
        }
    }

    /**
     * 将Base64编码后的AES秘钥转换成SecretKey对象
     *
     * @param base64Key
     * @return SecretKey对象
     * @throws Exception
     */
    private static SecretKey loadKeyAES(String base64Key) {
        byte[] bytes = Base64Util.base642Byte(base64Key);
        return new SecretKeySpec(bytes, "AES");
    }

    /**
     * AES加密
     *
     * @param source 加密内容
     * @param key SecretKey对象
     * @return 加密后的Base64字符串
     */
    public static String encryptAES(String source, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(loadKeyAES(key).getEncoded(), "AES");
            // "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            return Base64Util.byte2Base64(cipher.doFinal(source.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new SignException("校验失败");
        }
    }

    /**
     * AES解密
     *
     * @param source 解密内容
     * @param key 密钥
     * @return 解密后的字节数组
     */
    public static byte[] decryptAES(String source, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(loadKeyAES(key).getEncoded(), "AES");
            // "算法/模式/补码方式"
            // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            return cipher.doFinal(Base64Util.base642Byte(source));
        } catch (Exception e) {
//            e.printStackTrace();
            throw new SignException("校验失败");
        }
    }

    public static void main(String[] args) {
        String KEY = "EWzAeGSzkNQ2qd5ziiLrVw==";
        System.out.println(encryptAES("[{\"name\":\"demoData\",\"parentname\":\"demoData\",\"parent\":\"demoData\","
            + "\"provincecode\":\"demoData\",\"provincename\":\"demoData\",\"citycode\":\"demoData\","
            + "\"cityname\":\"demoData\",\"countycode\":\"demoData\",\"countryname\":\"demoData\",\"towncode\":\"demoData\",\"townname\":\"demoData\",\"detail\":\"demoData\",\"longitude\":1,\"latitude\":1,\"industry\":\"demoData\",\"industryid\":1,\"creditcode\":\"demoData\",\"legal\":\"demoData\",\"address\":\"demoData\",\"scope\":\"demoData\",\"linkman\":\"demoData\",\"linkphone\":\"demoData\",\"subjectionname\":\"demoData\",\"mark\":\"demoData\",\"level\":1,\"parkname\":\"demoData\",\"parkcode\":\"demoData\",\"isljxq\":1,\"beenindustryid\":1,\"boundaries\":\"demoData\",\"mapcenter\":\"demoData\",\"mapzoom\":1,\"code\":\"demoData\",\"secretKey\":\"demoData\",\"receiptUrl\":\"demoData\"}]",
            KEY));
        String s = encryptAES(
            "[{\"companyCode\":\"demoData\",\"riskEventId\":\"demoData\",\"dataSrc\":\"demoData\",\"riskMeasureDesc\":\"demoData\",\"troubleshootContent\":\"demoData\",\"classify1\":\"demoData\",\"classify2\":\"demoData\",\"classify3\":\"demoData\",\"uuid\":\"demoData\"}]",
            KEY);
        System.out.println(s);
        System.out.println(new String(decryptAES(s, KEY)));
    }
}
