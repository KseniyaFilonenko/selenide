package com.itacademy;

import com.codeborne.selenide.Configuration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;
import static org.apache.poi.openxml4j.opc.OPCPackage.open;

public class BaseTest {
    @BeforeTest
    public void setUp() throws InvalidFormatException {
        Configuration.browser = "chrome";
        Configuration.browserSize = String.valueOf(true);
        Configuration.headless = true;
        open("https://react-shopping-cart-67954.firebaseapp.com/");
    }
    @AfterTest
    public void closeSession() {
        closeWindow();
    }
}
