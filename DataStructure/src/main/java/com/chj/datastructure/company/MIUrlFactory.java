package com.chj.datastructure.company;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 工作用：
 * 生成miBrowser指定格式的encodeUrl
 * Created by chenhaojie on 2017/12/11.
 */
public class MIUrlFactory {

    private static final String originUrl = "https://click.tanx.com/tfn?e=i0ZU%2bytb3Tms9LjH9ETB%2bdhtMzNTd5bRzN1VIJJUwTdfIdbp78SIFt7svA7zOooAZLEZNekXf9BjGnqqlqP2dAJVDR5mHbAAbOSD2iffDL%2bZLLmMPl7P52SEk1UvLgCd&u=https%3a%2f%2f38.tmall.com%2f%3fwh_weex%3dtrue%26hbfr%3dhbfr%3d29%26bc_fl_src%3dtanx_df_143240096%26resource_id%3d14954&k=128&ext=a%3d__IMEI__%26b%3d__IDFA__%26c%3d__MAC__";
    private static final String name = "0306";

    public static void main(String args []){
        try {
            String encode1 = encode(originUrl);
            String paramsStr = getParamsStr(name,originUrl);
            String encode2 = encode(paramsStr);
            String outputStr = "mibrowser://home/webapp?web_url=" + encode1 + "&appid=com.xiaomi&params=" + encode2;

            System.out.println("originUrl is:");
            System.out.println(originUrl + "\n");
            System.out.println("params is:");
            System.out.println(paramsStr + "\n");
            System.out.println("encode1 is:");
            System.out.println(encode1 + "\n");
            System.out.println("encode2 is:");
            System.out.println(encode2 + "\n");
            System.out.println("result is:");
            System.out.print(outputStr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String getParamsStr(String name,String originUrl){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("url",originUrl);
        return jsonObject.toString();
    }

    public static String encode(String s){
        try {
            return URLEncoder.encode(s,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test(){
        JSONObject jsonObject = new JSONObject();
        List<String> keywordList = new ArrayList<String>();

        keywordList.add("垃圾清理");
        keywordList.add("优化加速");
        keywordList.add("安全扫描");
        keywordList.add("省电优化");
        keywordList.add("应用锁");
        keywordList.add("针对隐私应用加锁，保护用户数据");
        keywordList.add("深度清理");
        keywordList.add("网络助手");
        keywordList.add("应用双开");
        keywordList.add("应用管理");
        keywordList.add("骚扰拦截");
        keywordList.add("手机分身");

        /*keywordList.add("Cleaner");
        keywordList.add("Boost speed");
        keywordList.add("Security scan");
        keywordList.add("Battery");
        keywordList.add("App lock");
        keywordList.add("Protect private items with App lock");
        keywordList.add("Deep clean");
        keywordList.add("Data usage");
        keywordList.add("Dual apps");
        keywordList.add("Manage apps");
        keywordList.add("Blocklist");
        keywordList.add("Second space");*/

        for(int i = 0;i<keywordList.size();i++){
            jsonObject.put("keyword" + i,keywordList.get(i));
        }

        System.out.println(jsonObject.toString());
    }

}
