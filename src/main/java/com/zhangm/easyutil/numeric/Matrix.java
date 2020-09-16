package com.zhangm.easyutil.numeric;

import com.zhangm.easyutil.Strings;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import lombok.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

/**
 * @Author zhangming
 * @Date 2020/9/13 15:38
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matrix {
    private int row;
    private int col;
    private int dim;
    // 数据按行为单位进行拆分
    private double[] data;

    public static Matrix zeros(int row, int col, int dim) {
        Matrix matrix = new Matrix();
        matrix.row = row;
        matrix.col = col;
        matrix.dim = dim;
        matrix.data = new double[row * col * dim];
        return matrix;
    }

    public static Matrix random(int row, int col, int dim) {
        Matrix matrix = zeros(row, col, dim);
        for (int i=0; i<matrix.data.length; i++) {
            matrix.data[i] = Math.random();
        }
        return matrix;
    }

    public static Matrix ones(int row, int col, int dim) {
        Matrix matrix = zeros(row, col, dim);
        Arrays.fill(matrix.data, 1.0);
        return matrix;
    }

    public double get(int row, int col, int dim) {
        int dimIndex = this.row * this.col * dim;
        int index = this.col * row + col + dimIndex;
        return data[index];
    }

    public Matrix get(int rowStart, int rowEnd, int colStart, int colEnd, int dimStart, int dimEnd) {
        throw new UnsupportedOperationException();
    }

    public Matrix getByDim(int dimStart, int dimEnd) {
        throw new UnsupportedOperationException();
    }

    public Matrix getByRow(int rowStart, int rowEnd) {
        throw new UnsupportedOperationException();
    }

    public Matrix get(int rowStart, int rowEnd, int colStart, int colEnd) {
        throw new UnsupportedOperationException();
    }

    public void set(int rowStart, int rowEnd, int colStart, int colEnd, int dimStart, int dimEnd, Matrix matrix) {
        throw new UnsupportedOperationException();
    }

    public void set(int rowStart, int rowEnd, int colStart, int colEnd, Matrix matrix) {
        throw new UnsupportedOperationException();
    }

    public void setByDim(int dim, Matrix matrix) {
        throw new UnsupportedOperationException();
    }

    public void setByRow(int rowStart, int rowEnd) {
        throw new UnsupportedOperationException();
    }

    @SneakyThrows
    public void save(String path) {
        WritableImage writableImage = new WritableImage(col, row);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                double red = this.get(i, j, 0);
                double green = this.get(i, j, 1);
                double blue = this.get(i, j, 2);
                double opacity = this.get(i, j, 3);
                Color color = Color.color(red, green, blue, opacity);
                pixelWriter.setColor(j, i, color);
            }
        }
        int pointIndex = path.lastIndexOf(".");
        String formatName = path.substring(pointIndex + 1);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
        boolean writeFlag = ImageIO.write(bufferedImage, formatName, new File(path));
        if (!writeFlag) {
            throw new RuntimeException(Strings.f("保存{}失败", path));
        }
    }

}
