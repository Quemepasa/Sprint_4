package ru.praktikum.scooter;

import org.junit.Rule;
import org.junit.Test;
import ru.praktikum.scooter.pom.MainPage;
import ru.praktikum.scooter.rules.BrowserRule;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.praktikum.scooter.constants.Urls.MAIN_PAGE_YANDEX_URL;

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

    @Test
    public void tapOnLogoYandexOpensMainPageYandex() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage
                .open()
                .clickLogoYandex();

        ArrayList<String> tabs = new ArrayList(browserRule.getWebDriver().getWindowHandles());
        browserRule.getWebDriver().switchTo().window(tabs.get(1));
        String actualUrl = browserRule.getWebDriver().getCurrentUrl();

        assertEquals("The Yandex home page didn't open", MAIN_PAGE_YANDEX_URL, actualUrl);
    }
}
