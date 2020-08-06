package com.zhangm.easyutil;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author zhangming
 * @Date 2020/8/6 14:48
 */
public class Retry {

    /**
     * 重试
     * @param func
     * @param times
     * @param errCallback
     * @return
     */
    public static boolean run(Supplier<Boolean> func, Integer times, Consumer<Exception> errCallback) {
        if (times == null) {
            times = 3;
        }
        Exception finalException = null;
        for (int i=0; i<times; i++) {
            try {
                boolean flag = func.get();
                if (flag) {
                    return true;
                }
            } catch (Exception ex) {
                finalException = ex;
            }
        }
        errCallback.accept(finalException);
        return false;
    }
}
