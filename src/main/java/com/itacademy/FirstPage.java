package com.itacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FirstPage {
    public static final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    public static final By firstItem = By.xpath("//p[@class='sc-124al1g-4 eeXMBo'][1]");
    public static final By itemsList = By.xpath("//p[@class='sc-124al1g-4 eeXMBo']");
    public static final By addToCartItemsList = By.xpath("//*[text()='Add to cart']");
    public static final By filterButtonS = By.xpath("//span[text()='S']");
    public static final By filterButtonXS = By.xpath("//span[text()='XS']");
    public static final By filterButtonM = By.xpath("//span[text()='M']");
    public static final By filterButtonML = By.xpath("//span[text()='ML']");
    public static final By productsFoundLabel = By.xpath("//main[@class='sc-ebmerl-4 iliWeY']");
    public static void addAllItemsToCart() throws InterruptedException {
        List<WebElement> listOfProductsHomepage = new ArrayList<>((Collection) addToCartItemsList);
        for (WebElement items : listOfProductsHomepage){
            ((JavascriptExecutor)items).executeScript("arguments[0].click();", items);
        }
        Thread.sleep(5000);
    }
}
