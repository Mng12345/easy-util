package com.zhangm.easyutil;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhangming
 * @Date 2020/6/17 11:58
 */
public interface Streams {

    interface Function<T1, T2, R> {
        R apply(T1 t1, T2 t2);
    }

    interface Function2<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }

    interface Function3<T1, T2, T3, T4, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    interface Consumer<T1, T2> {
        void accept(T1 t1, T2 t2);
    }

    interface Consumer2<T1, T2, T3> {
        void accept(T1 t1, T2 t2, T3 t3);
    }

    interface Consumer3<T1, T2, T3, T4> {
        void accept(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    static <T> void forEachIndexed(Stream<T> stream, Consumer<T, Long> consumer) {
        int[] count = new int[] {0};
        stream.forEach( item -> {
            consumer.accept(item, (long) count[0]);
            count[0] += 1;
        });
    }

    /**
     * used just for heavy work, and the stream must be small to avoid OOM
     * @param stream
     * @param consumer
     * @param <T>
     */
    static <T> void forEachIndexedParallel(Stream<T> stream, Consumer<T, Long> consumer) {
        List<Tuple<T, Long>> elementWithIndex = mapWithIndex(stream,
                (item, index) -> new Tuple<T, Long>(item, index)).collect(Collectors.toList());
        elementWithIndex.parallelStream().forEach(item -> consumer.accept(item.getV1(), item.getV2()));
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

    static <T, R> Stream<R> mapWithIndex(Stream<T> stream, Function<T, Long, R> function) {
        int[] count = new int[1];
        count[0] = 0;
        return stream.map(item -> {
            R res = function.apply(item, (long) count[0]);
            count[0] += 1;
            return res;
        });
    }

    /**
     * used just for heavy work, and the stream must be small to avoid OOM
     * @param stream
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    static <T, R> Stream<R> mapWithIndexParallel(Stream<T> stream, Function<T, Long, R> function) {
        List<Tuple<T, Long>> elementWithIndex = mapWithIndex(stream,
                (item, index) -> new Tuple<T, Long>(item, index)).collect(Collectors.toList());
        return elementWithIndex.parallelStream().map(item -> function.apply(item.getV1(), item.getV2()));
    }

    static <T> Optional<T> find(Stream<T> stream, Predicate<T> function) {
        return stream.filter(function).findFirst();
    }
}
