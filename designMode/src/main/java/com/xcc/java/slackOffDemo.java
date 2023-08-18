package com.xcc.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author xcc
 * @Date 2023/8/15
 */
public class slackOffDemo {

    /**
     * 先获取当前的时间 yyyy-MM-dd
     */
    public String getDateString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //设置日期格式
        return df.format(new Date());
    }

    public Date getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //设置日期格式
        Date date = new Date();
        try {
            date = df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 算出今天周几
     * @param date
     * @return String
     */
    public String getWeekOfDate(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 根据当前时间算出当前的年
     */
    public List<String> objective() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, +1);
        Date y = c.getTime();
        String year = format.format(y);
        List<String> list = new ArrayList<>();
        list.add(0,year+"-01-01");      // 元旦
        list.add(1,year+"-05-01");      // 五一
        list.add(2,year+"-10-01");      // 国庆
        return list;
    }

    /**
     * 算周末的日期
     */
    public String weekDay(String week) {
        String r = null;
        switch (week) {
            case "星期一":
                r = "加油！摸鱼人还有4天就到周末了";
                break;
            case "星期二":
                r = "啦啦！摸鱼人来继续摸鱼，你还有3天就解放了";
                break;
            case "星期三":
                r = "继续摸鱼，摸鱼人还有2天就是周末了";
                break;
            case "星期四":
                r = "还有1天就是周末了，挺住摸鱼人";
                break;
            case "星期五":
                r = "好好摸鱼！摸鱼人明天就是周末了";
                break;
        }
        return r;
    }

    /**
     * 计算两个时间之差
     */
    public static int daysBetween(String smdate,String bdate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(smdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = cal.getTimeInMillis();
        try {
            cal.setTime(sdf.parse(bdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 计算还有多长时间放假
     * 元旦，五一，国庆，下一次周末
     */
    public Map<String,Object> countDay() {
        slackOffDemo slackOffDemo = new slackOffDemo();

        String now = slackOffDemo.getDateString();        // 今天日期yyyy-MM-dd
        String week = slackOffDemo.getWeekOfDate(slackOffDemo.getDate());     // 今天周几
        List<String> list = slackOffDemo.objective();       // 需要计算的下次日期

        Map<String,Object> map = new HashMap<>();

        map.put("now",now);
        map.put("week",week);
        map.put("weekDay",slackOffDemo.weekDay(week));
        map.put("newDay",daysBetween(now,list.get(0)));
        map.put("MayDay",daysBetween(now,list.get(1)));
        map.put("NationalDay",daysBetween(now,list.get(2)));
        return map;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        slackOffDemo slackOffDemo = new slackOffDemo();
        Map<String ,Object> map = slackOffDemo.countDay();
        System.out.println(map);
    }


}