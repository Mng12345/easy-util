package com.zhangm.easyutil;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author zhangming
 * @Date 2020/6/16 15:07
 */
public interface DateUtil {

    final long dayMils = 24 * 60 * 60 * 1000;

    static Date add(Date date, int unit, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(unit, count);
        return calendar.getTime();
    }

    /**
     * 计算date1和date2之间间隔的天数，如：20200501 20200503 返回2
     * @param date1
     * @param date2
     * @return
     */
    static Integer between(Date date1, Date date2) {
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        long mils1 = dateTime1.getMillis();
        long mils2 = dateTime2.getMillis();
        return (int) ((mils2 - mils1) / dayMils);
    }
}
