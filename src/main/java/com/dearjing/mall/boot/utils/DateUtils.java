package com.dearjing.mall.boot.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    static  public Date getNow(){
        var c= Calendar.getInstance();
        return c.getTime();
    }
}
