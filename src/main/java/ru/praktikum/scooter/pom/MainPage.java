package ru.praktikum.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru";
    private final By costQuestionButton = By.xpath(".//div[contains(text(),'Сколько это стоит')]");
    private final By costAnswerDescription = By.xpath(".//p[contains(text(),'Сутки')]");
    private final By severalScootersQuestionButton = By.xpath(".//div[contains(text(),'Хочу')]");
    private final By severalScootersAnswerDescription = By.xpath(".//p[contains(text(),'Пока что у нас так')]");
    private final By timeСalculationQuestionButton = By.xpath(".//div[contains(text(),'Как рассчитывается время аренды?')]");
    private final By timeСalculationAnswerDescription = By.xpath(".//p[contains(text(),'Допустим')]");
    private final By orderTodayQuestionButton = By.xpath(".//div[contains(text(),'прямо на сегодня')]");
    private final By orderTodayAnswerDescription = By.xpath(".//p[contains(text(),'с завтрашнего дня')]");
    private final By extendOrReturnQuestionButton = By.xpath(".//div[contains(text(),'продлить заказ')]");
    private final By extendOrReturnAnswerDescription = By.xpath(".//p[contains(text(),'Пока что нет')]");
    private final By chargingQuestionButton = By.xpath(".//div[contains(text(),'зарядку вместе')]");
    private final By chargingAnswerDescription = By.xpath(".//p[contains(text(),'с полной зарядкой')]");
    private final By cancelQuestionButton = By.xpath(".//div[contains(text(),'отменить заказ')]");
    private final By cancelAnswerDescription = By.xpath(".//p[contains(text(),'пока самокат не привезли')]");
    private final By mkadQuestionButton = By.xpath(".//div[contains(text(),'за МКАДом')]");
    private final By mkadAnswerDescription = By.xpath(".//p[contains(text(),'Всем самокатов')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCostQuestionButton() {
        return costQuestionButton;
    }

    public By getCostAnswerDescription() {
        return costAnswerDescription;
    }

    public By getSeveralScootersQuestionButton() {
        return severalScootersQuestionButton;
    }

    public By getSeveralScootersAnswerDescription() {
        return severalScootersAnswerDescription;
    }

    public By getTimeСalculationQuestionButton() {
        return timeСalculationQuestionButton;
    }

    public By getTimeСalculationAnswerDescription() {
        return timeСalculationAnswerDescription;
    }

    public By getOrderTodayQuestionButton() {
        return orderTodayQuestionButton;
    }

    public By getOrderTodayAnswerDescription() {
        return orderTodayAnswerDescription;
    }

    public By getExtendOrReturnQuestionButton() {
        return extendOrReturnQuestionButton;
    }

    public By getExtendOrReturnAnswerDescription() {
        return extendOrReturnAnswerDescription;
    }

    public By getChargingQuestionButton() {
        return chargingQuestionButton;
    }

    public By getChargingAnswerDescription() {
        return chargingAnswerDescription;
    }

    public By getCancelOrderQuestionButton() {
        return cancelQuestionButton;
    }

    public By getCancelOrderAnswerDescription() {
        return cancelAnswerDescription;
    }

    public By getMkadQuestionButton() {
        return mkadQuestionButton;
    }

    public By getMkadAnswerDescription() {
        return mkadAnswerDescription;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage scrollToElement(By element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(element));
        return this;
    }

    public MainPage waitElement (By element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public MainPage clickQuestionButton(By questionButton) {
        driver.findElement(questionButton).click();
        return this;
    }

    public String getAnswerText(By answerDescription) {
        return driver.findElement(answerDescription).getText();
    }

    public MainPage clickOrderButton(By positionOfOrderButton) {
        driver.findElement(positionOfOrderButton).click();
        return this;
    }
}
