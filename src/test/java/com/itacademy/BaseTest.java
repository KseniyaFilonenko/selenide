package com.itacademy;

import com.codeborne.selenide.Configuration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeTest
    public void setUp() throws InvalidFormatException {
        Configuration.browser = "chrome";
        Configuration.browserSize = String.valueOf(true);
        Configuration.headless = true;
        open("https://react-shopping-cart-67954.firebaseapp.com/");
        $$(FirstPage.firstItem).first().shouldBe(visible);
    }
    @AfterTest
    public void closeSession() {
        closeWindow();
    }
}
