package com.zhangm.easyutil;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.helpers.MessageFormatter.arrayFormat;

/**
 * @Author zhangming
 * @Date 2020/7/18 20:05
 */
public interface Strings {

    /**
     * api lick log.info("abc {}", "def") = "abc def"
     * @param pattern
     * @param args
     * @return
     */
    static String f(String pattern, Object... args) {
        return arrayFormat(pattern, args).getMessage();
    }

    static void b() {
        List<Object> l = new ArrayList<>();
    }
}
