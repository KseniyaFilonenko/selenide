package com.itacademy;

import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public static final By itemInCart= By.xpath("//p[@class='sc-11uohgb-2 elbkhN'][1]");
    public static final By itemsListInCart= By.xpath("//p[@class='sc-11uohgb-2 elbkhN']");
    public static String getCartItemText() {
        return $(CartPage.itemInCart).getText();
    }
    public static List<String> getItemsCartListTexts () {
        List<String> itemsCartListTexts = $$(CartPage.itemsListInCart).texts();
        return itemsCartListTexts.stream().toList();
    }
}
