package com.zhangm.easyutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @Author zhangming
 * @Date 2020/8/29 17:58
 */
public interface FileUtil {

    static String read(File file) {
        if (!file.isFile()) {
            throw new RuntimeException(Strings.f("{} must be file!", file.getAbsolutePath()));
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            return stringBuilder.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
