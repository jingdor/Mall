package com.dearjing.mall.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    static  public Date getNow(){
        var c= Calendar.getInstance();
        return c.getTime();
    }
    public static Long getYearFirst(){
        Calendar c = Calendar.getInstance();
        c.clear(Calendar.MONTH);
        c.add(Calendar.YEAR, 0);
        /*c.add(Calendar.MONTH, 0);*/
        c.set(Calendar.DAY_OF_MONTH, 1);
        //设置为1号,当前日期既为本月第一天
        //c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

}
