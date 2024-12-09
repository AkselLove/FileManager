package ru.spbstu.telematics.java;

import java.io.File;
import java.io.IOException;

public class FileManager {
    // Метод для создания файла (аналог touch)
    public static void touch(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getAbsolutePath());
        } else {
            System.out.println("File already exists: " + file.getAbsolutePath());
        }
    }

    // Метод для удаления файла (аналог rm)
    public static void rm(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to delete the file or file does not exist: " + file.getAbsolutePath());
        }
    }
}

