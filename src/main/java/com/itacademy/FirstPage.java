package com.itacademy;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class FirstPage {
    public static final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    public static final By firstItem = By.xpath("//p[@class='sc-124al1g-4 eeXMBo'][1]");
    public static final By itemsList = By.xpath("//p[@class='sc-124al1g-4 eeXMBo']");
    public static final By addToCartItemsList = By.xpath("//*[text()='Add to cart']");
    public static final By filterButtonS = By.xpath("//span[text()='S']");
    public static final By productsFoundLabel = By.xpath("//main[@class='sc-ebmerl-4 iliWeY']");
    public static void addAllItemsToCart() throws InterruptedException {
        ElementsCollection list= $$(addToCartItemsList);
        for (WebElement items : list){
            ((JavascriptExecutor)items).executeScript("arguments[0].click();", items);
        }
        Thread.sleep(5000);
    }
}
