package org.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Service {

    public void modifyFile(String inputFile, String gamma) {
        try (FileInputStream in = new FileInputStream(inputFile)) {
            File outputFile = new File(new File(inputFile).getParent(), "output.txt");
            FileOutputStream out = new FileOutputStream(outputFile);

            byte[] gammaBytes = hexStringToByteArray(gamma);
            int gammaIndex = 0;

            while (in.available() > 0) {
                int data = in.read();
                int modifiedByte = data ^ gammaBytes[gammaIndex];
                out.write(Integer.toHexString(modifiedByte & 0xFF).getBytes());

                gammaIndex = (gammaIndex + 1) % gammaBytes.length;
            }

            System.out.println("\nФайл успешно модифицирован. Новый файл сохранен как 'output.txt' в той же директории.");

        } catch (Exception e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    public byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException("Ошибка в строке шестнадцатеричных данных");
        }

        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
