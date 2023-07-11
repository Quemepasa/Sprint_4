package ru.praktikum.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInfoPage {
    WebDriver driver;

    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dropdownArrowRentalPeriod= By.className("Dropdown-arrow");
    private final By freeDaysRentalPeriod = By.xpath(".//div[text()='трое суток']");
    private final By orderButtonInMiddle = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderInfoPage inputTextDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
        return this;
    }

    public OrderInfoPage clickDropdownArrowRentalPeriod() {
        driver.findElement(dropdownArrowRentalPeriod).click();
        return this;
    }

    public OrderInfoPage clickFreeDaysRentalPeriod() {
        driver.findElement(freeDaysRentalPeriod).click();
        return this;
    }

    public OrderInfoPage clickOrderButtonInMiddle() {
        driver.findElement(orderButtonInMiddle).click();
        return this;
    }
}
