package ru.praktikum.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderModal {
    WebDriver driver;

    private final By successHeaderModal = By.xpath(".//div[text()='Заказ оформлен']");

    public SuccessfulOrderModal(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSuccessHeaderModalExists() {
        return driver.findElement(successHeaderModal).isDisplayed();
    }
}
