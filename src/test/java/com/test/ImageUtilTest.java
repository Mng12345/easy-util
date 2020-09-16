package com.test;

import com.zhangm.easyutil.ImageUtil;
import com.zhangm.easyutil.Strings;
import com.zhangm.easyutil.numeric.Matrix;

/**
 * @Author zhangming
 * @Date 2020/9/13 22:01
 */
public class ImageUtilTest {

    public static void main(String[] args) {
        String baseDir = "C:\\Users\\Lenovo\\Desktop\\temp";
        String inputPath = Strings.f("{}\\\\{}", baseDir, "quant.jpg");
        String outputPath = Strings.f("{}\\\\{}", baseDir, "quant-out.png");
        Matrix matrix = ImageUtil.read(inputPath);
        matrix.save(outputPath);
    }
}
