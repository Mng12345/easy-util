package com.zhangm.easyutil;

/**
 * @Author zhangming
 * @Date 2020/7/27 15:36
 */
public interface MathUtil {

    static double mean(double[] array) {
        return sum(array) / array.length;
    }

    static double sum(double[] array) {
        double s = 0.;
        for (double item : array) {
            s += item;
        }
        return s;
    }

    static double variance(double[] array) {
        double m = mean(array);
        double v = 0.;
        for (double item : array) {
            v += Math.pow(item - m, 2);
        }
        return v / (array.length - 1);
    }

    static double standardDeviation(double[] array) {
        return Math.sqrt(variance(array));
    }

    /**
     * 化简
     * @param v
     * @param num 精度
     * @return
     */
    static double round(double v, int num) {
        if (num == 0) {
            return Math.round(v);
        }
        double multiple = Math.pow(10, num);
        return Math.round(v * Math.pow(10, num)) / multiple;
    }

    /**
     * 计算ma值
     * @param data
     * @param day
     * @return
     */
    static double[] maLine(double[] data, int day) {
        if (day > data.length) {
            throw new RuntimeException(Strings.f("day: {} > data.length: {}", day, data.length));
        }
        double[] ma = new double[data.length - day + 1];
        double sumVal = sum(RangeUtil.sliceNBefore(data, day-1, day));;
        int index = 0;
        ma[index] = sumVal / day;
        for (int i=day; i<data.length; i++) {
            sumVal += data[i] - data[i - day];
            ma[index++] = sumVal / day;
        }
        return ma;
    }

    /**
     * 计算ema
     * @param data
     * @param n
     * @return
     */
    static double[] emaLine(double[] data, int n) {
        double[] ema = new double[data.length];
        ema[0] = data[0];
        double k = 2 / (1.0 + n);
        for (int i=1; i<data.length; i++) {
            ema[i] = data[i] * k + ema[i-1] * (1-k);
        }
        return ema;
    }

    /**
     * 计算两条ema的差值
     * @param data
     * @param shortN
     * @param longN
     * @return
     */
    static double[] emaGapLine(double[] data, int shortN, int longN) {
        double[] shortEmaLine = emaLine(data, shortN);
        double[] longEmaLine = emaLine(data, longN);
        return RangeUtil.sub(shortEmaLine, longEmaLine);
    }

    /**
     * 计算macd值
     * @param data
     * @param shortN
     * @param longN
     * @param n
     * @return
     */
    static double[] macdLine(double[] data, int shortN, int longN, int n) {
        double[] emaGap = emaGapLine(data, shortN, longN);
        return emaLine(emaGap, n);
    }

    /**
     * 计算斜率
     * @param data
     * @param n
     * @return
     */
    static double[] gradientLine(double[] data, int n) {
        double[] res = new double[data.length - n + 1];
        int index = -1;
        for (int i=n-1; i<data.length; i++) {
            int start = i - n + 1;
            res[++index] = (data[i] - data[start]) * 1.0 / n;
        }
        return res;
    }
}
