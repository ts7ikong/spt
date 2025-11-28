package org.jeecg.modules.system.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;

@Slf4j
@Component
//@Desc("http公用")
public class HttpsaUtil {

    public String ip;//IP地址
    public Integer port;//端口号
    private Boolean whetherProxy = false;//是否开启代理
    public Proxy proxy;
    private int timeout = 30000;//延迟时间

    //@Desc("设置代理地址ip,端口号port,请求地址postUrl")
    public void setProxy(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
        this.whetherProxy = true;
        this.init();
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));//创建代理
    }

    //@Desc("设置代理对象")
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
        this.whetherProxy = true;
    }

    //@Desc("初始化SSL协议")
    public void init() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            log.info("错误信息:" + e.getMessage());
        }
    }

    //@Desc("http Get请求")
    public String httpGet(Map<String, String> headers, String url, Map<String, Object> params) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.get(url);
        if (null != headers) {
            request.addHeaders(headers);
        }
        if (null != params) {
            request.form(params);//传参数
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }

    //@Desc("http Get请求")
    public String httpGet(Map<String, String> headers, String url, Object bean) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.get(url);
        if (null != headers) {
            request.addHeaders(headers);
        }
        if (null != bean) {
            Map<String, Object> params = MaptoBean.bean2map(bean);
            request.form(params);//传参数
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }


    //@Desc("http Post请求")
    public String httpPost(Map<String, String> headers, String url, Object bean) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.post(url);
        if (null != headers) {
            request.addHeaders(headers);
        }
        if (null != bean) {
            Map<String, Object> params = MaptoBean.bean2map(bean);
            request.form(params);//传参数
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }

    //@Desc("http Post File请求")
    public String httpPostFile(Map<String, String> headers, String url, File file, Object bean) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.post(url);
        if (null != headers) {
            request.addHeaders(headers);
        }
        if (null != bean) {
            Map<String, Object> params = MaptoBean.bean2map(bean);
            request.form(params);//传参数
        }
        request.form("file", file);


        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }


    //@Desc("http Post请求 body")
    public String httpPostBody(Map<String, String> headers, String url, Object json) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.post(url);
        if (null != headers) {
            request.addHeaders(headers);
        }

        if (null != json) {
            String jsons = JSON.toJSONString(MaptoBean.bean2map(json));
            request.body(jsons);//传参数
            //System.out.println(jsons);
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }

    //@Desc("http Post请求 body")
    public String tnHttpPostBody(Map<String, String> headers, String url, Object json) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.post(url);
        if (null != headers) {
            request.addHeaders(headers);
        }

        if (null != json) {
            System.out.println(JSON.toJSONString(json));

            request.body(JSON.toJSONString(json));//传参数
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }

    //@Desc("http Post请求 body")
    public String ySHttpPost(Map<String, String> headers, String url, Object json) throws Exception {
        if (null == url || "".equals(url)) {
            throw new Exception("请求地址不能为空");
        }
        HttpRequest request = HttpRequest.post(url);
        if (null != headers) {
            request.addHeaders(headers);
        }

        if (null != json) {
            /*JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", json);
            request.body(jsonObject.toJSONString());//传参数
            System.out.println(jsonObject);*/
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(json);
            request.body(s);//传参数
            //System.out.println(s);
        }
        request.timeout(timeout);
        //如果有代理设置，则走代理
        if (whetherProxy) {
            request.setProxy(proxy);
        }
        return request.execute().body();
    }


}
