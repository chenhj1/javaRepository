package com.chj.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by chenhaojie on 2018/02/02.
 */
public class HttpUtil {

    // HTTP设置相关
    public static final int HTTP_TIME_OUT = 60 * 1000; // Http网络链接超时时间

    public static final int SOCKET_TIME_OUT = 60 * 1000; // socket响应超时时间

    public static final int SOCKET_BUFFER_SIZE = 20 * 1024; // socket缓存大小


    public static HttpClient genHttpClient() {
        // HttpClient配置
        HttpParams mHttpParams = new BasicHttpParams();

        //设置网络链接超时
        HttpConnectionParams.setConnectionTimeout(mHttpParams, HTTP_TIME_OUT);

        //设置socket响应超时
        HttpConnectionParams.setSoTimeout(mHttpParams, SOCKET_TIME_OUT);

        //设置socket缓存大小
        HttpConnectionParams.setSocketBufferSize(mHttpParams, SOCKET_BUFFER_SIZE);

        // 按照配置生成HttpClient实例
        HttpClient httpClient = new DefaultHttpClient(mHttpParams);

        return httpClient;
    }

    public static String postFile(MultipartFile file, Map<String,String> paramsMap, String remoteUrl){
        final String remote_url = remoteUrl;// 第三方服务器请求地址
        HttpClient httpClient = genHttpClient();
        String result = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(remote_url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            builder.setCharset(Charset.forName("UTF-8"));

            builder.addBinaryBody("img", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
            ContentType contentType= ContentType.create("text/plain","UTF-8");
            for(Map.Entry<String,String>entry:paramsMap.entrySet()){
                StringBody stringBody=new StringBody(entry.getValue(),contentType);
                builder.addPart(entry.getKey(),stringBody);
//                builder.addTextBody(entry.getKey(),entry.getValue());
            }

            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);// 执行提交
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

}
