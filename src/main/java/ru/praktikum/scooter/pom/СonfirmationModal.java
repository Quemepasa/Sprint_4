package ru.praktikum.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class СonfirmationModal {
    WebDriver driver;

    private final By confirmationButton = By.xpath(".//button[text()='Да']");

    public СonfirmationModal(WebDriver driver) {
        this.driver = driver;
    }

    public СonfirmationModal clickConfirmationButton() {
        driver.findElement(confirmationButton).click();
        return this;
    }
}
