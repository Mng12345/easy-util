package com.zhangm.easyutil;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @Author zhangming
 * @Date 2020/6/17 11:58
 */
public interface Streams {

    interface Function<T1, T2, R> {
        R apply(T1 t1, T2 t2);
    }

    interface Consumer<T1, T2> {
        void accept(T1 t1, T2 t2);
    }

    static <T> void forEachIndexed(Stream<T> stream, Consumer<T, Long> consumer) {
        int[] count = new int[] {0};
        stream.forEach( item -> {
            consumer.accept(item, (long) count[0]);
            count[0] += 1;
        });
    }

    static <T> void forEachIndexedWithBreak(Stream<T> stream, Function<T, Long, Boolean> function) {
        Iterator<T> iter = stream.iterator();
        int count = 0;
        while (iter.hasNext()) {
            T item = iter.next();
            boolean stop = function.apply(item, (long) count);
            count++;
            if (stop) {
                break;
            }
        }
    }
}
