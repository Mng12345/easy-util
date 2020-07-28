package com.zhangm.easyutil;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangming
 * @Date 2020/5/29 15:38
 */
public interface BeanConverter {

    static <T> T convert(Map<String, ?> map, Class<T> tClass) {
        try {
            T t = tClass.getDeclaredConstructor().newInstance();
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
            System.out.println(Strings.f("error: {}", ex.getMessage()));
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * 将父类的属性赋值给子类
     * @param father
     * @param fatherClazz
     * @param son
     * @param sonClazz
     * @param <T1>
     * @param <T2>
     */
    static <T1, T2 extends T1> void transfer(T1 father, Class<T1> fatherClazz, T2 son, Class<? extends T2> sonClazz) {
        try {
            Field[] fatherFields = fatherClazz.getDeclaredFields();
            Map<String, Field> sonFieldMap = new HashMap<>();
            Field[] sonFields = sonClazz.getDeclaredFields();
            for (Field field : sonFields) {
                sonFieldMap.put(field.getName(), field);
            }
            for (Field field : fatherFields) {
                field.setAccessible(true);
                Object value = field.get(father);
                Field sonField = sonFieldMap.get(field.getName());
                if (sonField != null) {
                    sonField.setAccessible(true);
                    sonField.set(son, value);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
