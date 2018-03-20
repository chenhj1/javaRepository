package com.chj.xiaomi.inputstat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 输入法icon统计
 * 运行 java -jar Work.jar 20180307
 * 或者 java -jar Work.jar 20180307 bd
 *
 */
public class InputStat {

    private static final long ONE_DAY_LONG = 1000 * 60 * 60 * 24;

    public static void main(String []args){

        List<String> sourceList = new ArrayList<String>();

        if(args.length == 1){
            if(!isvalidDate(args[0])){
                System.out.println("只能跑前天以及之前的数据！");
                System.exit(0);
            }
            sourceList.add("bd");
            sourceList.add("sg");
            for (String source:sourceList){
                System.out.println();
                System.out.println(getSql(args[0],source));
                System.out.println();
            }

        }else if(args.length == 2){
            if(!isvalidDate(args[0])){
                System.out.println("只能跑前天以及之前的数据！");
                System.exit(0);
            }
            System.out.println(getSql(args[0],args[1]));
        }else {
            System.out.println("invalid args!");
        }
    }

    public static String getSql(String start,String source){

        String end = getDayyyyyMMdd(start,2);
        String timestart = getDayyyyy_MM_dd(start,0);
        String timeend = getDayyyyy_MM_dd(start,1);

        String sql = "select count(distinct m) from sec.input_ad_stat where date>="+start+" and date<="+end+" and type='click' and source='"+source+"' and time='"+start+"' and m<>'dd4b21e9ef71e1291183a46b913ae6f2'; \n" +
                "select sum(cast (times AS INT)) from sec.input_ad_stat where date>="+start+" and date<="+end+" and type='click' and source='"+source+"' and time='"+start+"' and m<>'dd4b21e9ef71e1291183a46b913ae6f2'; \n" +
                "select count(distinct m) from sec.input_ad_req where date>="+start+" and date<="+end+" and s='"+source+"' and datetime < '"+timeend+" 00:00:00' and datetime > '"+timestart+" 00:00:00' and m<>'dd4b21e9ef71e1291183a46b913ae6f2'; \n" +
                "select count(*) from sec.input_ad_req where date>="+start+" and date<="+end+" and s='"+source+"' and datetime < '"+timeend+" 00:00:00' and datetime > '"+timestart+" 00:00:00' and m<>'dd4b21e9ef71e1291183a46b913ae6f2'; \n" +
                "select count(distinct m) from sec.input_ad_stat where date>="+start+" and date<="+end+" and type='view' and source='"+source+"' and time='"+start+"' and m<>'dd4b21e9ef71e1291183a46b913ae6f2'; \n" +
                "select sum(cast (times AS INT)) from sec.input_ad_stat where date>="+start+" and date<="+end+" and type='view' and source='"+source+"' and time='"+start+"' and m<>'dd4b21e9ef71e1291183a46b913ae6f2';";

        return sql;
    }

    public static String getDayyyyyMMdd(String start,int offset){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = sdf.parse(start);
            long timestamp = date.getTime();
            long afterTimestamp = timestamp + ONE_DAY_LONG * offset;
            String str = sdf.format(afterTimestamp);
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getDayyyyy_MM_dd(String start,int offset){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = sdf.parse(start);
            long timestamp = date.getTime();
            long afterTimestamp = timestamp + ONE_DAY_LONG * offset;

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf2.format(afterTimestamp);
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isvalidDate(String start){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = sdf.parse(start);
            long timestamp = date.getTime();
            if(System.currentTimeMillis() - timestamp < ONE_DAY_LONG * 2){
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
