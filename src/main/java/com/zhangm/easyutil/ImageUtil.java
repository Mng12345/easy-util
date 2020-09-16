package com.zhangm.easyutil;

import com.zhangm.easyutil.numeric.Matrix;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangming
 * @Date 2020/9/13 11:11
 */
public interface ImageUtil {

    @SneakyThrows
    static Matrix read(String path) {
        try (InputStream inputStream = new FileInputStream(path)) {
            Image image = new Image(inputStream);
            int row = (int)image.getHeight();
            int col = (int)image.getWidth();
            PixelReader pixelReader = image.getPixelReader();
            int dimSize = row * col;
            double[] redPixels = new double[dimSize];
            double[] greenPixels = new double[dimSize];
            double[] bluePixels = new double[dimSize];
            double[] opacityPixels = new double[dimSize];
            int pixelIndex = 0;
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    Color color = pixelReader.getColor(j, i);
                    redPixels[pixelIndex] = color.getRed();
                    greenPixels[pixelIndex] = color.getGreen();
                    bluePixels[pixelIndex] = color.getBlue();
                    opacityPixels[pixelIndex] = color.getOpacity();
                    pixelIndex++;
                }
            }
            double[] data = RangeUtil.merge(redPixels, greenPixels);
            data = RangeUtil.merge(data, bluePixels);
            data = RangeUtil.merge(data, opacityPixels);
            return new Matrix(row, col, 4, data);
        }
    }

}
