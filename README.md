# easy-util
some easy util class to operate data in java

# APIS 

## BeanConverter

### static \<T> T convert(Map<String, ?> map, Class<T> tClass)

## DateUtil

### static Date add(Date date, int unit, int count)
### static Integer between(Date date1, Date date2)

## Functions

### interface VoidFuncNoArg

## GenericUtil

### static \<T> T[] getArray(Class<T> componentType, int length)

## MathUtil

### static double mean(double[] array)
### static double sum(double[] array)
### static double variance(double[] array)
### static double standardDeviation(double[] array)
### static double round(double v, int num)

## ProxyUtil

### public static  \<T, TAspect> Class<? extends T> proxyClass(Class<T> clazz, Class<TAspect> aspectClass)

## RandomUtil

### static int randomInt(int min, int max)

## RangeUtil

### static int[] index(int from, int to)
### static double[] slice(double[] v, int from, Integer to)
### static \<T> T[] slice(T[] v, int from, T[] res)
### static void set(double[] dest, double[] source, int from)
### static void set(Object[] dest, double[] source, int from)
### static String[] repeat(String str, int num)
### static \<T> T[] merge(T[] v1, T[] v2, T[] out)
### static double[] unwrap(Double[] v)
### static int[] unwrap(Integer[] v)
### static Double[] wrap(double[] v)
### static Integer[] wrap(int[] v)
### static \<T> int[] sortToIndex(T[] v, T[] out)
### static \<T> int[] sortToIndex(T[] v)
### static double[] multiply(double[] v1, Object v2)
### static double[] multiply(int[] v1, Object v2)
### static double[] add(double[] data, Number num)
### static int[] add(int[] data, Number num)
### static int sum(int[] data)
### static double sum(double[] data)
### static double[] toDoubleArray(int[] v)
### static \<T> void shuffle(T[] v, T[] vShuffle)
### static \<T> T[] random(T[] v, T[] res)
### static \<T> T[] randomNotRepeat(T[] v, int num, T[] res, int[] index)
### static int random(int low, int high)
### static \<T> T[] reindex(T[] v, int[] index, T[] out)
### static \<T> List<T> merge(List<T> l1, List<T> l2)
### static \<T> List<T> random(List<T> l, int length)
### static \<T> List<T> randomNotRepeat(List<T> l, int length, int[] indexes)
### static double[] sliceNBefore(double[] data, int i, int n)
### static double[] sliceNAfter(double[] data, int i, int n)
### static int[] sliceNBefore(int[] data, int i, int n)
### static int[] sliceNAfter(int[] data, int i, int n)
### static List\<Integer> toBoxedList(int[] array)
### static List\<Double> toBoxedList(double[] array)

## Retry

### public static boolean run(Supplier\<Boolean> func, Integer times, Consumer\<Exception> errCallback)

## Streams

### interface Function<T1, T2, R>
### interface Consumer<T1, T2>
### static \<T> void forEachIndexed(Stream\<T> stream, Consumer<T, Long> consumer)
### static \<T> void forEachIndexedParallel(Stream\<T> stream, Consumer<T, Long> consumer)
### static \<T> void forEachIndexedWithBreak(Stream\<T> stream, Function<T, Long, Boolean> function)
### static \<T, R> Stream<R> mapWithIndex(Stream\<T> stream, Function<T, Long, R> function)
### static \<T, R> Stream<R> mapWithIndexParallel(Stream\<T> stream, Function<T, Long, R> function)
### static \<T> Optional<T> find(Stream\<T> stream, Predicate<T> function)

## Tuple, Triple
