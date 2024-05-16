package com.itacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    public static final By itemInCart= By.xpath("//p[@class='sc-11uohgb-2 elbkhN'][1]");
    public static final By itemsListInCart= By.xpath("//p[@class='sc-11uohgb-2 elbkhN']");
}
