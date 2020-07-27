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

}
