package com.zhangm.easyutil;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author zhangming
 * @Date 2020/8/6 14:51
 */
public class Functions {

    interface VoidFuncNoArg {
        void apply();
    }

    static <T> Consumer<T> wrapConsumer(Consumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2> Streams.Consumer<T1, T2> wrapConsumer(Streams.Consumer<T1, T2> consumer) {
        return (t1, t2) -> {
            try {
                consumer.accept(t1, t2);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2, T3> Streams.Consumer2<T1, T2, T3> wrapConsumer(Streams.Consumer2<T1, T2, T3> consumer) {
        return (t1, t2, t3) -> {
            try {
                consumer.accept(t1, t2, t3);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2, T3, T4> Streams.Consumer3<T1, T2, T3, T4> wrapConsumer(Streams.Consumer3<T1, T2, T3, T4> consumer) {
        return (t1, t2, t3, t4) -> {
            try {
                consumer.accept(t1, t2, t3, t4);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T, R> Function<T, R> wrapFunction(Function<T, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2, R> Streams.Function<T1, T2, R> wrapFunction(Streams.Function<T1, T2, R> function) {
        return (t1, t2) -> {
            try {
                return function.apply(t1, t2);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2, T3, R> Streams.Function2<T1, T2, T3, R> wrapFunction(Streams.Function2<T1, T2, T3, R> function) {
        return (t1, t2, t3) -> {
            try {
                return function.apply(t1, t2, t3);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T1, T2, T3, T4, R> Streams.Function3<T1, T2, T3, T4, R> wrapFunction(Streams.Function3<T1, T2, T3, T4, R> function) {
        return (t1, t2, t3, t4) -> {
            try {
                return function.apply(t1, t2, t3, t4);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static void main(String[] args) {

    }
}
