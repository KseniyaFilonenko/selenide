package com.itacademy;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebsiteTest extends BaseTest{
    @Test
    public void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
        SelenideLogger.addListener("local listener", new LocalListener());
    }
    @Test
    public void addToCart() {
        $(FirstPage.addToCartButton).click();
        assertEquals(FirstPage.getFirstItemText(), CartPage.getCartItemText());

    }
    @Test
    public void listOfItems() throws InterruptedException {
        List<String> itemsListTexts = FirstPage.getItemsListTexts();
        FirstPage.addAllItemsToCart();
        List<String> itemsInCartTexts = CartPage.getItemsCartListTexts();
        assertEquals(itemsListTexts, itemsInCartTexts);
    }
    @Test
    public void filter() {
        int beforeFilter = $$(FirstPage.itemsList).size();
        $(FirstPage.filterButtonS).click();
        $(String.valueOf(Duration.ofSeconds(2)));
        int afterFilter = $$(FirstPage.itemsList).size();
        assertTrue(beforeFilter > afterFilter);
    }
    @Test
    public void filter2() {
        int beforeFilter = FirstPage.getIntInProductsFoundLabel();
        $(FirstPage.filterButtonS).click();
        $(String.valueOf(Duration.ofSeconds(2)));
        int afterFilter = FirstPage.getIntInProductsFoundLabel();
        assertTrue(beforeFilter > afterFilter);
    }
}
