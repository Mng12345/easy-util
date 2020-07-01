package com.zhangm.easyutil;

import java.lang.reflect.Array;

/**
 * @Author zhangming
 * @Date 2020/6/30 17:18
 */
public class GenericUtil {

    @SuppressWarnings({"unchecked", "hiding"})
    public static <T> T[] getArray(Class<T> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
}
