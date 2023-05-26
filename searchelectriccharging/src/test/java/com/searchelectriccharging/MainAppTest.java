package com.searchelectriccharging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainAppTest {

    @Test
    public void testMainApp() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOutputStream = System.out;
        System.setOut(new PrintStream(outputStream));

        // Act
        MainApp.main(new String[0]);

        // Assert
        String consoleOutput = outputStream.toString();

        // Assert nearest station
        Assertions.assertTrue(consoleOutput.contains("Найближча станція: Station 1"),
                "Невірний результат для найближчої станції.");

        // Assert available stations
        Assertions.assertTrue(consoleOutput.contains("Вільні станції:"),
                "Невірний результат для вільних станцій.");

        Assertions.assertTrue(consoleOutput.contains("Station 1"),
                "Невірний результат для першої вільної станції.");

        Assertions.assertTrue(consoleOutput.contains("Station 2"),
                "Невірний результат для другої вільної станції.");

        // Assert current language
        Assertions.assertTrue(consoleOutput.contains("Поточна мова: en"),
                "Невірний результат для поточної мови.");

        // Reset output stream
        System.setOut(originalOutputStream);
    }

}

