package ru.praktikum.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInfoOrderPage {
    WebDriver driver;

    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroStationCherkizovskaya = By.xpath(".//div[text()='Черкизовская']");
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");



    public CustomerInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }



    public CustomerInfoOrderPage inputTextNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public CustomerInfoOrderPage inputTextSurnameField(String surName) {
        driver.findElement(surnameField).sendKeys(surName);
        return this;
    }

    public CustomerInfoOrderPage inputTextAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public CustomerInfoOrderPage clickMetroField() {
        driver.findElement(metroField).click();
        return this;
    }

    public CustomerInfoOrderPage clickMetroStationCherkizovskaya() {
        driver.findElement(metroStationCherkizovskaya).click();
        return this;
    }

    public CustomerInfoOrderPage inputTextPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public CustomerInfoOrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }



}
