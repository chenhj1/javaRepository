package com.chj.xiaomi.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP工具类
 */
public class HttpUtil {

    private static Logger logger = Logger.getLogger(HttpUtil.class);

    public static void main(String[] args) {
        String s = get("https://adv.sec.miui.com/info/inputAdv?channel=01-12&s=bd&m=016b092831e0feaa4b58d1a887e6b8a");
        System.out.println(s);
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().build();
        try {

            HttpGet httpget = new HttpGet(url);

            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            }
            response.close();
        } catch (Exception e) {
            logger.error(url + "time out");
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }

        return result;
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String get(String url, int connectTimeout,int socketTimeout) {
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().build();
        try {

            HttpGet httpget = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
            httpget.setConfig(requestConfig);

            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            }
            response.close();
        } catch (Exception e) {
            logger.error(url + "time out");
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }

        return result;
    }

    /**
     * post请求
     *
     * @param url
     * @return
     */
    public static String post(String url, Map<String,String>paramMap) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> formparams = new ArrayList<>();
            for (String key : paramMap.keySet()) {
                formparams.add(new BasicNameValuePair(key, paramMap.get(key)));
            }
            HttpEntity httpEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(httpEntity);
/*
            httpPost.setHeader("Content-type", "application/json");
*/
            result = httpClient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            logger.error(url + "time out");
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }
        return result;

    }

    /**
     * post请求
     *
     * @param url
     * @param socketTimeout
     * @param connectTimeout
     * @return
     */
    public static String post(String url,  int connectTimeout,int socketTimeout) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
            httpPost.setConfig(requestConfig);
            List<NameValuePair> formparams = new ArrayList<>();
            HttpEntity httpEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(httpEntity);
            httpPost.setHeader("Content-type", "application/json");
            result = httpClient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            logger.error(url + "time out");
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }
        return result;

    }

}
