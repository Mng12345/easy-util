package com.test;

import com.zhangm.easyutil.DateUtil;
import com.zhangm.easyutil.Strings;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

/**
 * @Author zhangming
 * @Date 2020/7/29 15:41
 */
public class DateUtilTest {

    @SneakyThrows
    public void testBetween() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String startDate = "20200815";
        String endDate = "20200817";
        System.out.println(Strings.f("day between {} and {} is: {}",
                startDate, endDate, DateUtil.between(dateFormat.parse(startDate), dateFormat.parse(endDate))));
    }

    public static void main(String[] args) {
        new DateUtilTest().testBetween();
    }
}
