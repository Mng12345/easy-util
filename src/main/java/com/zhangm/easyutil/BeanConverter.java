package com.zhangm.easyutil;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author zhangming
 * @Date 2020/5/29 15:38
 */
@Log4j2
public class BeanConverter {

    public static <T> T convert(Map<String, ?> map, Class<T> tClass) {
        try {
            T t = tClass.newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = map.get(field.getName());
                if (value instanceof BigDecimal) {
                    field.set(t, Double.parseDouble(value.toString()));
                } else {
                    field.set(t, value);
                }
            }
            return t;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
