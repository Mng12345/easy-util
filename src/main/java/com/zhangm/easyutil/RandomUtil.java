package com.zhangm.easyutil;

/**
 * @Author zhangming
 * @Date 2020/7/27 10:51
 */
public interface RandomUtil {

    /**
     * [min,max]
     * @param min
     * @param max
     * @return
     */
    static int randomInt(int min, int max) {
        return (int) Math.round((Math.random() * (max - min)) + min);
    }


}
