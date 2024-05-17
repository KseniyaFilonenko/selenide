package com.itacademy;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class FirstPage {
    public static final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    public static final By firstItem = By.xpath("//p[@class='sc-124al1g-4 eeXMBo'][1]");
    public static final By itemsList = By.xpath("//p[@class='sc-124al1g-4 eeXMBo']");
    public static final By addToCartItemsList = By.xpath("//*[text()='Add to cart']");
    public static final By filterButtonS = By.xpath("//span[text()='S']");
    public static final By productsFoundLabel = By.xpath("//main[@class='sc-ebmerl-4 iliWeY']");
    public static String getFirstItemText() {
        return $(FirstPage.firstItem).getText();
    }
    public static List<String> getItemsListTexts () {
        return $$(itemsList).shouldHave(size(16)).texts();
    }
    public static int getIntInProductsFoundLabel() {
        int foundLabel = Integer.parseInt($(FirstPage.productsFoundLabel).text()
                .replaceAll("[^\\d]", ""));
        return foundLabel;
    }
    public static void addAllItemsToCart() throws InterruptedException {
        ElementsCollection list= $$(addToCartItemsList);
        for (SelenideElement items : list){
            ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].click();",
                    items.toWebElement());
        }
        Thread.sleep(5000);
    }
}
