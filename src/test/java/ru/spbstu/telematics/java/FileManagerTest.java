package ru.spbstu.telematics.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileManagerTest {

    private final String testFileName = "testFile.txt";

    @Before
    public void setUp() throws IOException {
        // Убедимся, что тестовый файл отсутствует перед началом теста
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @After
    public void tearDown() {
        // Удаляем тестовый файл после тестов
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testTouchCreatesFile() throws IOException {
        FileManager.touch(testFileName);
        File file = new File(testFileName);
        assertTrue("File should be created", file.exists());
    }

    @Test
    public void testTouchFileAlreadyExists() throws IOException {
        FileManager.touch(testFileName);
        FileManager.touch(testFileName); // Повторный вызов touch
        File file = new File(testFileName);
        assertTrue("File should still exist", file.exists());
    }

    @Test
    public void testRmDeletesFile() throws IOException {
        FileManager.touch(testFileName);
        FileManager.rm(testFileName);
        File file = new File(testFileName);
        assertFalse("File should be deleted", file.exists());
    }

    @Test
    public void testRmNonExistentFile() {
        FileManager.rm(testFileName); // Удаление несуществующего файла
        File file = new File(testFileName);
        assertFalse("File should not exist", file.exists());
    }
}

