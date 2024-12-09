package ru.spbstu.telematics.java;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Пример работы FileManager
            String fileName = "example.txt";

            // Создание файла
            FileManager.touch(fileName);

            // Удаление файла
            FileManager.rm(fileName);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

