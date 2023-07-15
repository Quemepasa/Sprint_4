package ru.praktikum.scooter;

import org.junit.Rule;
import org.junit.Test;
import ru.praktikum.scooter.pom.MainPage;
import ru.praktikum.scooter.rules.BrowserRule;

import static org.junit.Assert.assertTrue;

public class LogoYandexScooter {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void tapOnLogoScooterOpensMainPageScooter() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage
                .open()
                .clickOrderButton(mainPage.getOrderButtonInHeader())
                .clickLogoScooter();
        assertTrue("The main page didn't open, the heading 'Самокат' didn't displayed", mainPage.checkTitleScooterIsDisplayed());
    }
}
