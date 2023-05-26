package com.searchelectriccharging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LanguageManagerTest {
    @Test
    void testChangeLanguage() {
        LanguageManager languageManager = new LanguageManager();
        languageManager.changeLanguage("en");

        String currentLanguage = languageManager.getCurrentLanguage();

        Assertions.assertEquals("en", currentLanguage);
    }
}

