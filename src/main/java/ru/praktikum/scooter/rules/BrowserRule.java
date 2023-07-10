package ru.praktikum.scooter.rules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
