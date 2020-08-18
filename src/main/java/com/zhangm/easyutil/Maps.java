package com.zhangm.easyutil;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
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

    public static <K, V> Entry newEntry(K key, V value) {
        return Entry.builder()
                .key(key)
                .value(value)
                .build();
    }

    public static <K, V> Map<K, V> newHashMap(Entry<K, V>... entries) {
        Map<K, V> map = new HashMap<>();
        for (Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
