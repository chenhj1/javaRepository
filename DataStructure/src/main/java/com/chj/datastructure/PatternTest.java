package com.chj.datastructure;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenhaojie on 2017/11/01.
 * 正则表达式
 * <a href="http://www.runoob.com/java/java-regular-expressions.html">链接</a>
 */
public class PatternTest {

    public static void main(String []args){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void testFun1(){
        String jsonArrayStr = "[\n" +
                "\t\"7.8.18\",\n" +
                "\t\"7.9.27\",\n" +
                "\t\"7.7.2\",\n" +
                "\t\"7.6.5\",\n" +
                "\t\"7.9.29\",\n" +
                "\t\"7.9.17\",\n" +
                "\t\"7.6.15\",\n" +
                "\t\"9.9.28\",\n" +
                "\t\"7.9.2\",\n" +
                "\t\"7.9.30\",\n" +
                "\t\"7.9.14\",\n" +
                "\t\"9.9.9\",\n" +
                "\t\"7.7.13\",\n" +
                "\t\"7.9.19\",\n" +
                "\t\"7.9.21\",\n" +
                "\t\"7.9.4\",\n" +
                "\t\"17.9.21\",\n" +
                "\t\"2637.8.31\",\n" +
                "\t\"7.7.3\",\n" +
                "\t\"7.6.12\",\n" +
                "\t\"9.9.7\",\n" +
                "\t\"7.9.99\",\n" +
                "\t\"7.7.18\",\n" +
                "\t\"7.7.1\",\n" +
                "\t\"7.9.24\",\n" +
                "\t\"7.9.26\",\n" +
                "\t\"7.9.20\",\n" +
                "\t\"7.6.20\",\n" +
                "\t\"7.7.4\",\n" +
                "\t\"7.7.26\",\n" +
                "\t\"7.9.15\",\n" +
                "\t\"7.8.25\",\n" +
                "\t\"7.7.6\",\n" +
                "\t\"7.5.4\",\n" +
                "\t\"7.8.4\",\n" +
                "\t\"7.8.26\",\n" +
                "\t\"8.8.16\",\n" +
                "\t\"9.9.14\",\n" +
                "\t\"7.7.11\",\n" +
                "\t\"7.8.2\",\n" +
                "\t\"8.9.21\",\n" +
                "\t\"7.5.30\",\n" +
                "\t\"7.8.3\",\n" +
                "\t\"7.7.21\",\n" +
                "\t\"7.8.10\",\n" +
                "\t\"7.9.10\",\n" +
                "\t\"7.8.16\",\n" +
                "\t\"8.9.1\",\n" +
                "\t\"7.7.20\",\n" +
                "\t\"9.6.10\",\n" +
                "\t\"7.9.3\",\n" +
                "\t\"7.8.27\",\n" +
                "\t\"7.2.35\",\n" +
                "\t\"7.7.29\",\n" +
                "\t\"7.6.24\",\n" +
                "\t\"7.8.1-internal\",\n" +
                "\t\"7.7.28\",\n" +
                "\t\"7.7.15\",\n" +
                "\t\"8.9.2\",\n" +
                "\t\"7.6.6\",\n" +
                "\t\"99.9.99\",\n" +
                "\t\"7.8.29\",\n" +
                "\t\"7.5.22\",\n" +
                "\t\"7.5.19\",\n" +
                "\t\"7.7.25-internal\",\n" +
                "\t\"99.99.99\",\n" +
                "\t\"8.8.24\",\n" +
                "\t\"8.8.8\",\n" +
                "\t\"7.9.9\",\n" +
                "\t\"7.9.28\",\n" +
                "\t\"7.8.11\",\n" +
                "\t\"7.7.27\",\n" +
                "\t\"7.8.1\",\n" +
                "\t\"7.8.17\",\n" +
                "\t\"7.9.22\",\n" +
                "\t\"2017.6.12\",\n" +
                "\t\"7.8.12\",\n" +
                "\t\"7.9.1\",\n" +
                "\t\"10.8.17\",\n" +
                "\t\"7.9.25\",\n" +
                "\t\"7.9.12\",\n" +
                "\t\"7.7.23\",\n" +
                "\t\"7.6.26\",\n" +
                "\t\"8.8.88\",\n" +
                "\t\"7.9.6\",\n" +
                "\t\"7.8.15\",\n" +
                "\t\"8.9.9\",\n" +
                "\t\"4.0.1\",\n" +
                "\t\"7.8.30\",\n" +
                "\t\"8.6.17\",\n" +
                "\t\"8.9.5\",\n" +
                "\t\"7.7.17\",\n" +
                "\t\"7.8.23\",\n" +
                "\t\"7.8.31\",\n" +
                "\t\"7.5.25\",\n" +
                "\t\"7.8.9\",\n" +
                "\t\"99.6.8\",\n" +
                "\t\"7.5.26\",\n" +
                "\t\"7.8.6\",\n" +
                "\t\"7.9.7\",\n" +
                "\t\"8.8.17\",\n" +
                "\t\"10.12.1\",\n" +
                "\t\"7.5.29\",\n" +
                "\t\"7.8.7\",\n" +
                "\t\"7.7.16\",\n" +
                "\t\"7.7.12\",\n" +
                "\t\"7.10.1\",\n" +
                "\t\"9.9.21\",\n" +
                "\t\"7.9.13\",\n" +
                "\t\"7.6.30\",\n" +
                "\t\"7.6.8\",\n" +
                "\t\"7.6.9\",\n" +
                "\t\"7.7.7\",\n" +
                "\t\"7.7.31\",\n" +
                "\t\"7.8.24\",\n" +
                "\t\"7.6.25\",\n" +
                "\t\"7.8.28\",\n" +
                "\t\"7.10.10\",\n" +
                "\t\"8.9.15\",\n" +
                "\t\"7.9.16\",\n" +
                "\t\"7.9.5\",\n" +
                "\t\"7.6.22\",\n" +
                "\t\"8.9.29\",\n" +
                "\t\"7.9.23\",\n" +
                "\t\"7.7.22\",\n" +
                "\t\"7.6.10\",\n" +
                "\t\"7.9.11\",\n" +
                "\t\"20.30.40\",\n" +
                "\t\"7.8.22\",\n" +
                "\t\"7.6.21\",\n" +
                "\t\"7.7.8\",\n" +
                "\t\"7.6.23\",\n" +
                "\t\"7.7.14\",\n" +
                "\t\"8.8.10\",\n" +
                "\t\"7.6.14\",\n" +
                "\t\"7.10.6\",\n" +
                "\t\"7.9.8\",\n" +
                "\t\"9.8.24\",\n" +
                "\t\"8.8.9\",\n" +
                "\t\"7.8.19\",\n" +
                "\t\"17.9.7\",\n" +
                "\t\"8.9.13\",\n" +
                "\t\"7.6.17\",\n" +
                "\t\"7.8.14\",\n" +
                "\t\"7.8.29-internal\",\n" +
                "\t\"7.6.19\",\n" +
                "\t\"7.8.13\",\n" +
                "\t\"7.8.8\",\n" +
                "\t\"9.9.99\",\n" +
                "\t\"7.6.29\",\n" +
                "\t\"7.6.16\",\n" +
                "\t\"7.6.1\",\n" +
                "\t\"7.8.21\",\n" +
                "\t\"7.9.18\",\n" +
                "\t\"8.9.7\",\n" +
                "\t\"8.8.18\",\n" +
                "\t\"77.9.14\",\n" +
                "\t\"7.5.27\",\n" +
                "\t\"7.19.13\",\n" +
                "\t\"7.10.2\",\n" +
                "\t\"8.9.28\",\n" +
                "\t\"7.12.12\",\n" +
                "\t\"7.10.9\",\n" +
                "\t\"7.5.11\",\n" +
                "\t\"8.8.31\",\n" +
                "\t\"7.6.5-internal\",\n" +
                "\t\"7.8.5\",\n" +
                "\t\"7.10.3\",\n" +
                "\t\"7.7.24\",\n" +
                "\t\"8.9.8\",\n" +
                "\t\"0.0.1\",\n" +
                "\t\"9.8.40\",\n" +
                "\t\"88.5.25\",\n" +
                "\t\"9.8.28\",\n" +
                "\t\"7.10.4\",\n" +
                "\t\"8.0.1\",\n" +
                "\t\"6.6.6\",\n" +
                "\t\"8.10.3\",\n" +
                "\t\"7.19.7\",\n" +
                "\t\"7.6.1-internal\",\n" +
                "\t\"7.12.29\",\n" +
                "\t\"9.99.99\",\n" +
                "\t\"7.10.5\",\n" +
                "\t\"6.10.20\",\n" +
                "\t\"7.8.20\",\n" +
                "\t\"7.6.27\",\n" +
                "\t\"7.10.04\",\n" +
                "\t\"828.828.828\",\n" +
                "\t\"9.8.31\",\n" +
                "\t\"8.10.6\",\n" +
                "\t\"7.10.7\",\n" +
                "\t\"7.7.25\",\n" +
                "\t\"8.6.14\",\n" +
                "\t\"6.6.7\",\n" +
                "\t\"4.8\",\n" +
                "\t\"7.99.77\",\n" +
                "\t\"1.1.1\",\n" +
                "\t\"7.6.2555\",\n" +
                "\t\"8.9.14\",\n" +
                "\t\"9.9.10\",\n" +
                "\t\"7.7.19\",\n" +
                "\t\"7.10.8\",\n" +
                "\t\"6.8.43\",\n" +
                "\t\"17.10.10\",\n" +
                "\t\"2017.9.12\",\n" +
                "\t\"97.6.8\",\n" +
                "\t\"7.6.19-internal\",\n" +
                "\t\"7.7.31-internal\",\n" +
                "\t\"7.0.62\",\n" +
                "\t\"7.10.11\",\n" +
                "\t\"7.10.9-internal\",\n" +
                "\t\"7.10.12-internal\",\n" +
                "\t\"7.10.12\",\n" +
                "\t\"9.1.13\",\n" +
                "\t\"8.7.20\",\n" +
                "\t\"2017.8.15\",\n" +
                "\t\"8.6.6\",\n" +
                "\t\"7.9.34\",\n" +
                "\t\"7.6.28\",\n" +
                "\t\"7.9.20-internal\",\n" +
                "\t\"7.10.13\",\n" +
                "\t\"100.9.21\",\n" +
                "\t\"7.10.14\",\n" +
                "\t\"87.10.14\",\n" +
                "\t\"10.9.21\",\n" +
                "\t\"18.9.27\",\n" +
                "\t\"7.10.16\",\n" +
                "\t\"17.10.12\",\n" +
                "\t\"7.6.3\",\n" +
                "\t\"7.10.15\",\n" +
                "\t\"7.10.17\",\n" +
                "\t\"9.5.20\",\n" +
                "\t\"\",\n" +
                "\t\"7.10.13-internal\",\n" +
                "\t\"7.10.18\",\n" +
                "\t\"9.10.12\",\n" +
                "\t\"7.10.18-internal\",\n" +
                "\t\"99.10.12\",\n" +
                "\t\"8.10.12\",\n" +
                "\t\"7.10.19\",\n" +
                "\t\"7.6.7\",\n" +
                "\t\"10.10.19\",\n" +
                "\t\"7.10.20\",\n" +
                "\t\"8.10.19\",\n" +
                "\t\"7.30.12\",\n" +
                "\t\"9.8.1\",\n" +
                "\t\"7.10.121\",\n" +
                "\t\"7.10.21\",\n" +
                "\t\"7.6.13\",\n" +
                "\t\"8.10.14\",\n" +
                "\t\"7.10.22\",\n" +
                "\t\"7.10.23\",\n" +
                "\t\"7.10.24\",\n" +
                "\t\"0.0.0\",\n" +
                "\t\"30.10.19\",\n" +
                "\t\"7.5.24\",\n" +
                "\t\"7.10.26\",\n" +
                "\t\"17.10.19\",\n" +
                "\t\"7.10.25\",\n" +
                "\t\"99.66.77\",\n" +
                "\t\"2017.9.21\",\n" +
                "\t\"7.12.24\",\n" +
                "\t\"2017.7.16\",\n" +
                "\t\"7.5.23\",\n" +
                "\t\"10.25.1\",\n" +
                "\t\"7.12.26\",\n" +
                "\t\"7.10.27\",\n" +
                "\t\"7.10.99\",\n" +
                "\t\"9.8.7\",\n" +
                "\t\"999.99.99\",\n" +
                "\t\"7.18.18\",\n" +
                "\t\"7.68.97\",\n" +
                "\t\"7.10.28\",\n" +
                "\t\"9.10.26\",\n" +
                "\t\"7.10.29\",\n" +
                "\t\"8.1.1\",\n" +
                "\t\"1.1.192284\",\n" +
                "\t\"7.10.30\",\n" +
                "\t\"7.10.30-internal\",\n" +
                "\t\"7.10.31\",\n" +
                "\t\"v7.8.17\"\n" +
                "]";

        JSONArray jsonArray = JSONArray.fromObject(jsonArrayStr);
//        System.out.println(jsonArray);
        System.out.println(jsonArray.size());
        List<String> resultlist = new ArrayList<>();

        String pattern = "7\\.([1-9]|[1,9][0,2])\\.([1-9]|([1,2][0,9]|3[0,1]))";

        for(int i = 0;i<jsonArray.size();i++){
            String versionStr = jsonArray.optString(i);

            System.out.println(Pattern.matches(pattern,versionStr) + " , " + versionStr);

            if(Pattern.matches(pattern,versionStr)){
                resultlist.add(versionStr);
            }

        }

        System.out.println(resultlist.size());
        versionSort(resultlist);
        System.out.println(JSONArray.fromObject(resultlist).toString());

    }

    public void versionSort(List<String>versionList){
        Collections.sort(versionList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[]o1Array = StringUtils.split(o1,".");
                String[]o2Array = StringUtils.split(o2,".");

                //处理脏数据
                if(o1Array.length != 3)
                    return 1;
                if(o2Array.length != 3)
                    return 1;

                if(o1Array[0].compareTo(o2Array[0]) == 0){
                    if(o1Array[1].compareTo(o2Array[1]) == 0){
                        if(o1Array[2].compareTo(o2Array[2]) == 0){
                            return 0;
                        }
                        return compareVersionString(o2Array[2],o1Array[2]);
                    }
                    return o2Array[1].compareTo(o1Array[1]);
                }
                return o2Array[0].compareTo(o1Array[0]);

            }
        });
    }

    public int compareVersionString(String v1,String v2){
        try {
            int v1Int = Integer.parseInt(v1);
            int v2Int = Integer.parseInt(v2);
            if(v2Int > v1Int){
                return -1;
            }else if(v2Int < v1Int){
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
    }

}
