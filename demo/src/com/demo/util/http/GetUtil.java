package com.demo.util.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Administrator on 14-3-7.
 */
public class GetUtil {
    private static  AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    /**
     * get不带参数方法
     * @param url
     * @param asyncHttpResponseHandler
     */
    public static void httpGet(String url,AsyncHttpResponseHandler asyncHttpResponseHandler){
        asyncHttpClient.get(url,asyncHttpResponseHandler);
    }

    /**
     * get带参数方法
     * @param url
     * @param requestParams
     * @param asyncHttpResponseHandler
     */
    public static void httpGetWithParams(String url,RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        asyncHttpClient.get(url,requestParams,asyncHttpResponseHandler);
    }

    /**
     * post不带参数方法
     * @param url
     * @param requestParams
     * @param asyncHttpResponseHandler
     */
    public static void httpPost(String url,RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        asyncHttpClient.post(url,requestParams,asyncHttpResponseHandler);
    }

}
