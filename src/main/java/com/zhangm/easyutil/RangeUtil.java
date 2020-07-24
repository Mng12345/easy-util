package com.zhangm.easyutil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhangming
 * @Date 2020/6/5 16:42
 */
public interface RangeUtil {

    /**
     *
     * @param from include
     * @param to exclude
     * @return
     */
    static int[] index(int from, int to) {
        int len = to - from;
        int[] res = new int[len];
        for (int i=from; i<to; i++) {
            res[i - from] = i;
        }
        return res;
    }

    /**
     *
     * @param v
     * @param from include
     * @param to exclude
     * @return
     */
    static double[] slice(double[] v, int from, Integer to) {
        to = to == null ? v.length : to;
        double[] res = new double[to - from];
        try {
            if (to - from >= 0) {
                System.arraycopy(v, from, res, 0, to - from);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return res;
    }

    static <T> T[] slice(T[] v, int from, T[] res) {
        System.arraycopy(v, from, res, 0, res.length);
        return res;
    }

    static void set(double[] dest, double[] source, int from) {
        for (int i=from, count=0; count < source.length ; i++, count++) {
            dest[i] = source[i - from];
        }
    }

    static void set(Object[] dest, double[] source, int from) {
        for (int i=from, count=0; count < source.length ; i++, count++) {
            dest[i] = source[i - from];
        }
    }

    static String[] repeat(String str, int num) {
        String[] res = new String[num];
        for (int i=0; i<num; i++) {
            res[i] = str;
        }
        return res;
    }

    static <T> T[] merge(T[] v1, T[] v2, T[] out) {
        int len = v1.length + v2.length;
        int count = 0;
        for (T t : v1) {
            out[count++] = t;
        }
        for (T t : v2) {
            out[count++] = t;
        }
        return out;
    }

    static double[] unwrap(Double[] v) {
        double[] res = new double[v.length];
        for (int i=0; i<v.length; i++) {
            res[i] = v[i];
        }
        return res;
    }

    static int[] unwrap(Integer[] v) {
        int[] res = new int[v.length];
        for (int i=0; i<v.length; i++) {
            res[i] = v[i];
        }
        return res;
    }

    static Double[] wrap(double[] v) {
        Double[] res = new Double[v.length];
        for (int i=0; i<v.length; i++) {
            res[i] = v[i];
        }
        return res;
    }

    static Integer[] wrap(int[] v) {
        Integer[] res = new Integer[v.length];
        for (int i=0; i<v.length; i++) {
            res[i] = v[i];
        }
        return res;
    }

    /**
     * 排序后返回索引
     * @param v
     * @param <T>
     * @return
     */
    static <T> int[] sortToIndex(T[] v, T[] out) {
        Map<T, Queue<Integer>> indexMap = new HashMap<>();
        for (int i=0; i<v.length; i++) {
            Queue<Integer> indexes = indexMap.get(v[i]);
            if (indexes == null) {
                indexes = new ArrayDeque<>();
            }
            indexes.add(i);
            indexMap.put(v[i], indexes);
        }
        List<T> vSorted = Arrays.stream(v).sorted().collect(Collectors.toList());
        int[] indexes = new int[vSorted.size()];
        for (int i=0; i<vSorted.size(); i++) {
            out[i] = vSorted.get(i);
            Queue<Integer> itemIndexes = indexMap.get(vSorted.get(i));
            Integer index = itemIndexes.poll();
            if (index == null) {
                throw new RuntimeException("itemIndexes为空");
            }
            indexes[i] = index;
        }
        return indexes;
    }

    /**
     * 排序后返回索引
     * @param v
     * @param <T>
     * @return
     */
    static <T> int[] sortToIndex(T[] v) {
        Map<T, Queue<Integer>> indexMap = new HashMap<>();
        for (int i=0; i<v.length; i++) {
            Queue<Integer> indexes = indexMap.get(v[i]);
            if (indexes == null) {
                indexes = new ArrayDeque<>();
            }
            indexes.add(i);
            indexMap.put(v[i], indexes);
        }
        List<T> vSorted = Arrays.stream(v).sorted().collect(Collectors.toList());
        int[] indexes = new int[vSorted.size()];
        for (int i=0; i<vSorted.size(); i++) {
            Queue<Integer> itemIndexes = indexMap.get(vSorted.get(i));
            Integer index = itemIndexes.poll();
            if (index == null) {
                throw new RuntimeException("itemIndexes为空");
            }
            indexes[i] = index;
        }
        return indexes;
    }

    static double[] multiply(double[] v1, Object v2) {
        double[] res = new double[v1.length];
        if (v2 instanceof Integer) {
            for (int i = 0; i < v1.length; i++) {
                res[i] = v1[i] * (int) v2;
            }
            return res;
        } else if (v2 instanceof Double) {
            for (int i = 0; i < v1.length; i++) {
                res[i] = v1[i] * (double) v2;
            }
            return res;
        } else if (v2 instanceof double[] && v1.length == ((double[]) v2).length) {
            for (int i = 0; i < v1.length; i++) {
                res[i] = v1[i] * ((double[]) v2)[i];
            }
            return res;
        } else if (v2 instanceof int[] && v1.length == ((int[]) v2).length) {
            for (int i=0; i<v1.length; i++) {
                res[i] = v1[i] * ((int[]) v2)[i];
            }
            return res;
        } else {
            throw new RuntimeException("不支持该类计算");
        }
    }

    static double[] multiply(int[] v1, Object v2) {
        double[] res = new double[v1.length];
        if (v2 instanceof Integer) {
            for (int i=0; i<v1.length; i++) {
                res[i] = v1[i] * (int) v2;
            }
            return res;
        } else if (v2 instanceof Double) {
            for (int i=0; i<v1.length; i++) {
                res[i] = v1[i] * (double) v2;
            }
            return res;
        } else if (v2 instanceof double[] && v1.length == ((double[]) v2).length) {
            for (int i=0; i<v1.length; i++) {
                res[i] = v1[i] * ((double[]) v2)[i];
            }
            return res;
        } else if (v2 instanceof int[] && v1.length == ((int[]) v2).length) {
            for (int i=0; i<v1.length; i++) {
                res[i] = v1[i] * ((int[]) v2)[i];
            }
            return res;
        } else {
            throw new RuntimeException("不支持该类计算");
        }
    }

    static double[] add(double[] data, Number num) {
        double[] newData = new double[data.length];
        for (int i=0; i<newData.length; i++) {
            newData[i] += (double)num;
        }
        return newData;
    }

    static int[] add(int[] data, Number num) {
        int[] newData = new int[data.length];
        for (int i=0; i<newData.length; i++) {
            newData[i] += (int)num;
        }
        return newData;
    }

    static double[] toDoubleArray(int[] v) {
        double[] res = new double[v.length];
        for (int i=0; i<v.length; i++) {
            res[i] = v[i];
        }
        return res;
    }

    static <T> void shuffle(T[] v, T[] vShuffle) {
        Double[] randomValues = new Double[v.length];
        for (int i=0; i<v.length; i++) {
            randomValues[i] = Math.random();
        }
        // 对randomValues进行排序，并返回索引
        int[] indexes = RangeUtil.sortToIndex(randomValues);
        for (int i=0; i<v.length; i++) {
            vShuffle[i] = v[indexes[i]];
        }
    }

    /**
     * 可能重复
     * @param v
     * @param res
     * @param <T>
     */
    static <T> T[] random(T[] v, T[] res) {
        for (int i=0; i<res.length; i++) {
            res[i] = v[(int) Math.floor(Math.random() * v.length)];
        }
        return res;
    }

    /**
     * 不重复
     * @param v
     * @param num
     * @param res
     * @param <T>
     * @param index
     */
    static <T> T[] randomNotRepeat(T[] v, int num, T[] res, int[] index) {
        Set<T> uniqueValues = Arrays.stream(v).collect(Collectors.toSet());
        if (num > uniqueValues.size()) {
            throw new RuntimeException(String.format("num: %d > v unique length: %d", num, uniqueValues.size()));
        }
        Set<T> sets = new HashSet<>();
        for (int i=0; i<num; i++) {
            for (;;) {
                int ind = (int) Math.floor(Math.random() * v.length);
                T randomValue = v[ind];
                if (!sets.contains(randomValue)) {
                    sets.add(randomValue);
                    res[i] = randomValue;
                    index[i] = ind;
                    break;
                }
            }
        }
        return res;
    }

    static int random(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1)) + low;
    }

    /**
     * 将v按照index重新索引
     * @param v
     * @param index
     * @param out
     * @param <T>
     * @return
     */
    static <T> T[] reindex(T[] v, int[] index, T[] out) {
        for (int i=0; i<index.length; i++) {
            out[i] = v[index[i]];
        }
        return out;
    }

    static <T> List<T> merge(List<T> l1, List<T> l2) {
        List<T> l = new ArrayList<>(l1);
        l.addAll(l2);
        return l;
    }

    static <T> List<T> random(List<T> l, int length) {
        List<T> l1 = new ArrayList<>();
        int lSize = l.size();
        for (int i=0; i<length; i++) {
            int index = (int) Math.floor(Math.random() * lSize);
            l1.add(l.get(index));
        }
        return l1;
    }

    static <T> List<T> randomNotRepeat(List<T> l, int length, int[] indexes) {
        int lSize = l.size();
        Set<T> uniqueValues = new HashSet<>(l);
        if (length > uniqueValues.size()) {
            throw new RuntimeException(String.format("length: %d > v unique length: %d", length, uniqueValues.size()));
        }
        Set<T> sets = new HashSet<>();
        int count = 0;
        for (;;) {
            int index = (int) (Math.floor(Math.random() * lSize));
            T item = l.get(index);
            if (!sets.contains(item)) {
                indexes[count++] = index;
                sets.add(item);
            }
            if (sets.size() == length) {
                break;
            }
        }
        return new ArrayList<>(sets);
    }
}
