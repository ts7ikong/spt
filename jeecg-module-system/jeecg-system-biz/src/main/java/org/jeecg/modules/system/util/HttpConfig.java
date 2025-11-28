package org.jeecg.modules.system.util;

import java.util.HashMap;
import java.util.Map;

public class HttpConfig {
    /*********************************************HttpGet**************************************************/
    /**
     * http Get请求头 文本
     * Content-Type text/xml
     * @return
     */
    public static Map<String, String> httpGetTextHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","text/xml");
        return header;
    }
    /**
     * http post请求头 Json提交
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpGetJsonHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","application/json; charset=utf-8");
        return header;
    }
    /**
     * http Get请求头 form提交
     * Content-Type application/x-www-form-urlencoded
     * @return
     */
    public static Map<String, String> httpGetFormHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","application/x-www-form-urlencoded");
        return header;
    }
    /**
     * http Get请求头 文件提交
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpGetMultipartHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","multipart/form-data");
        return header;
    }

    /*********************************************HttpPost**************************************************/
    /**
     * http post请求头 form提交
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpPostFormHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","application/x-www-form-urlencoded");
        return header;
    }

    /**
     * http post请求头 Json提交
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpPostJsonHeader(){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","application/json; charset=utf-8");
        return header;
    }

    /**
     * http post请求头 Json提交
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpPostJsonHeader(String authorization){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","application/json; charset=utf-8");
        header.put("Authorization",authorization);
        return header;
    }

    /**
     * http post File请求头
     * Content-Type multipart/form-data
     * @return
     */
    public static Map<String, String> httpPostJsonFileHeader(String authorization){
        Map<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9");
        header.put("Content-Type","multipart/form-data");
        header.put("Authorization",authorization);
        return header;
    }
}
