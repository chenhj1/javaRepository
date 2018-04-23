package com.chj.xiaomi.inputMonitor;

import com.chj.xiaomi.util.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenhaojie on 2018/04/17.
 */
public class InputMonitor {

    public static final String REPORT_URL = "http://sms.n.xiaomi.com/sms/delivery";
    public static final String INPUT_URL = "https://adv.sec.miui.com/info/inputAdv?channel=01-12&s=sg&m=016b092831e0feaa4b58d1a887e6b8a";

    public static void main(String []args){

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JSONObject reportObj = new JSONObject();

        try {
            String inputResultStr = HttpUtil.get(INPUT_URL);
            JSONObject inputResultObj = JSONObject.fromObject(inputResultStr);
            JSONArray dataArr = inputResultObj.optJSONArray("data");
            if(dataArr.size() == 1){
                JSONObject cardObj = dataArr.optJSONObject(0);
                JSONArray cardItems = cardObj.optJSONArray("list");
                JSONObject originDataObj = cardItems.optJSONObject(0).optJSONObject("data");
                String title = originDataObj.optString("title");
                reportObj.put("Result", "\n输入法广告正常，" + title);
            }else {
                reportObj.put("Result", "\n输入法广告未上线！");
            }
        }catch (Exception e){
            reportObj.put("Result", "\n输入法接口请求失败！");
            System.out.println("["+time+"] " + "输入法接口请求失败！");
        }

        reportObj.put("Time", "\n"+time +"\n");
        reportObj.put("Url",INPUT_URL);

        Map<String, String> param = new HashMap<>();
        param.put("version", "1");
        param.put("username", "miuiSysSecurity");
        param.put("password", "miuiSysSecurity170621");
        param.put("phone", "17611573152");
        param.put("phoneLimit", "100");
        param.put("transaction", "1001");
        param.put("templateId", "123");
        param.put("replaceJson",reportObj.toString());

        System.out.println(reportObj);

        String reportResult = HttpUtil.post(REPORT_URL,param);
        System.out.println("["+time+"] " + reportResult);
    }
}
