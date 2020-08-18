package com.zhangm.easyutil;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangming
 * @Date 2020/8/18 10:23
 */
public class Maps {

    @Getter
    @Setter
    @Builder
    public static class Entry<K, V> {
        private K key;
        private V value;
    }

    public static <K, V> Entry<K, V> newEntry(K key, V value) {
        return Entry.<K, V>builder()
                .key(key)
                .value(value)
                .build();
    }

    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Entry<K, V>... entries) {
        HashMap<K, V> map = new HashMap<>();
        for (Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

}
