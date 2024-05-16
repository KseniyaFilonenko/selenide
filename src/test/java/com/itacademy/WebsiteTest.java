package com.itacademy;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebsiteTest extends BaseTest{
    @Test
    public void addToCart() {
        $(FirstPage.addToCartButton).click();
        File screenshot = takeScreenShotAsFile();
        screenshot.renameTo(new File("D:/idea/SelenideProject"));
        $(FirstPage.firstItem).shouldHave(text(String.valueOf(CartPage.itemInCart)));
    }
    @Test
    public void listOfItems() throws InterruptedException {
        List<String> itemsListTexts = $$(FirstPage.itemsList).texts();
        FirstPage.addAllItemsToCart();
        List<String> itemsInCartTexts = $$(CartPage.itemsListInCart).texts();
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
        int beforeFilter = Integer.parseInt($(FirstPage.productsFoundLabel).text()
                .replaceAll("[^\\d]", ""));
        $(FirstPage.filterButtonS).click();
        $(String.valueOf(Duration.ofSeconds(2)));
        int afterFilter = Integer.parseInt($(FirstPage.productsFoundLabel).text()
                .replaceAll("[^\\d]", ""));
        assertTrue(beforeFilter > afterFilter);
    }
}
