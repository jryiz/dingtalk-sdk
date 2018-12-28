package com.dingtalk.robot.utils;

import com.alibaba.fastjson.JSON;
import com.sun.tools.javac.util.Assert;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
//@Slf4j
public class HttpClientUtils {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final Long DEFAULT_TIME_OUT = 60L;
    public static final String CONTENT_TYPE = "Content-type";
    public static final String USER_AGENT = "User-Agent";
    public static final String ACCEPT = "Accept";
    public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=utf-8";
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36";
    public static final String DEFAULT_ACCEPT = "application/json, text/plain, */*";
    public static Map<String,String> default_headers;
    private static OkHttpClient HTTP_CLIENT;
    static boolean JSON_FORMAT = true;

    static {
        default_headers = new HashMap<>();
        default_headers.put(CONTENT_TYPE,DEFAULT_CONTENT_TYPE);
        default_headers.put(ACCEPT,DEFAULT_ACCEPT);
        default_headers.put(USER_AGENT,DEFAULT_USER_AGENT);
        //初始化http client
        HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .callTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static ResponseBody httpGet(String url, Map<String,String> headers,Object params){
        return sendRequest(buildRequest(url,headers,params,METHOD_GET));
    }

    public static ResponseBody httpGet(String url,Object params){
        return httpGet(url,null,params);
    }

    public static ResponseBody httpGet(String url){
        return httpGet(url,null);
    }

    public static ResponseBody httpPost(String url, Map<String,String> headers,Object params){
        return sendRequest(buildRequest(url,headers,params,METHOD_POST));
    }

    public static ResponseBody httpPost(String url,Object params){
        return httpPost(url,null,params);
    }

    private static Request buildRequest(String url, Map<String,String> headers,Object params,String method){
        Assert.checkNonNull(url,"url can not be null");
        Request.Builder builder = setHeaders(headers);
        System.out.println("params:" + params);
        if (METHOD_POST.equals(method)){
            builder.url(url).post(setRequestBody(params));
        }
        if (METHOD_GET.equals(method)){
            builder.url(getUrlWithParams(url,params));
        }
        return builder.build();
    }

    private static ResponseBody sendRequest(Request request){
        System.out.println(request.toString());
        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            System.out.println("返回状态码:" + response.code());
            if (response.isSuccessful()){
                System.out.println("请求成功:" + response.body());
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("请求失败");
        return null;
    }

    private static RequestBody setRequestBody(Object oParams){
        FormBody.Builder body = new FormBody.Builder();
        if (oParams instanceof Map) {
            Map<String,String> params = (Map<String, String>) oParams;
            if (!params.isEmpty()) {
                params.forEach(body::add);
            }
        }
        if (oParams instanceof String || oParams instanceof JSON){
            return FormBody.create(MediaType.parse(DEFAULT_CONTENT_TYPE),oParams.toString());
        }
        return body.build();
    }


    private static Request.Builder setHeaders(Map<String,String> headers){
        if (headers == null || headers.isEmpty()){
            headers = default_headers;
        }
        Request.Builder builder = new Request.Builder();
        headers.forEach(builder::addHeader);
        return builder;
    }
    public static String getUrlWithParams(String url, Object oParams){
        if (oParams instanceof Map) {
            Map<String,String> params = (Map<String, String>) oParams;
            if (params == null || params.isEmpty()) {
                return url;
            }
            StringBuffer nUrl = new StringBuffer(url);
            nUrl.append("?");
            params.forEach((key, value) -> nUrl.append(key).append("=").append(value).append("&"));
            return nUrl.toString();
        }
        if (oParams instanceof String){
            return url.concat(oParams.toString());
        }
        return url;
    }

    public static void setHttpClient(OkHttpClient client){
        HTTP_CLIENT = client;
    }

    public static void main(String[] args) {
        httpGet("http://www.baidu.com");
    }
}
