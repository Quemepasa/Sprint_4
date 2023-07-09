package ru.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.pom.MainPage;

import static org.junit.Assert.assertEquals;

public class QuestionAndAnswerDropDownList {
    private WebDriver driver;

    private final String CORRECT_COST_DESCRIPTION = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String CORRECT_SEVERAL_SCOOTERS_DESCRIPTION = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String CORRECT_TIME_CALCULATION_DESCRIPTION = "Допустим, вы оформляете заказ на 8 мая. " +
            "Мы привозим самокат 8 мая в течение дня. " +
            "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String CORRECT_ORDER_TODAY_DESCRIPTION = "Только начиная с завтрашнего дня. " +
            "Но скоро станем расторопнее.";
    private final String CORRECT_EXTEND_OR_RETURN_DESCRIPTION = "Пока что нет! " +
            "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String CORRECT_CHARGING_DESCRIPTION = "Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String CORRECT_CANCEL_ORDER_DESCRIPTION = "Да, пока самокат не привезли. " +
            "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String CORRECT_MKAD_DESCRIPTION = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkCostAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getCostQuestionButton())
                .clickQuestionButton(mainPage.getCostQuestionButton())
                .waitElement(mainPage.getCostAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getCostAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_COST_DESCRIPTION);
    }

    @Test
    public void checkSeveralScootersAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getSeveralScootersQuestionButton())
                .clickQuestionButton(mainPage.getSeveralScootersQuestionButton())
                .waitElement(mainPage.getSeveralScootersAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getSeveralScootersAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_SEVERAL_SCOOTERS_DESCRIPTION);
    }

    @Test
    public void checkTimeСalculationAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getTimeСalculationQuestionButton())
                .clickQuestionButton(mainPage.getTimeСalculationQuestionButton())
                .waitElement(mainPage.getTimeСalculationAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getTimeСalculationAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_TIME_CALCULATION_DESCRIPTION);
    }

    @Test
    public void checkOrderTodayAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getOrderTodayQuestionButton())
                .clickQuestionButton(mainPage.getOrderTodayQuestionButton())
                .waitElement(mainPage.getOrderTodayAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getOrderTodayAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_ORDER_TODAY_DESCRIPTION);
    }

    @Test
    public void checkExtendOrReturnAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getExtendOrReturnQuestionButton())
                .clickQuestionButton(mainPage.getExtendOrReturnQuestionButton())
                .waitElement(mainPage.getExtendOrReturnAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getExtendOrReturnAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_EXTEND_OR_RETURN_DESCRIPTION);
    }

    @Test
    public void checkChargingAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getChargingQuestionButton())
                .clickQuestionButton(mainPage.getChargingQuestionButton())
                .waitElement(mainPage.getChargingAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getChargingAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_CHARGING_DESCRIPTION);
    }

    @Test
    public void checkCancelOrderAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getCancelOrderQuestionButton())
                .clickQuestionButton(mainPage.getCancelOrderQuestionButton())
                .waitElement(mainPage.getCancelOrderAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getCancelOrderAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_CANCEL_ORDER_DESCRIPTION);
    }

    @Test
    public void checkMkadAnswerCorrectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .scrollToElement(mainPage.getMkadQuestionButton())
                .clickQuestionButton(mainPage.getMkadQuestionButton())
                .waitElement(mainPage.getMkadAnswerDescription());
        String actualResult = mainPage.getAnswerText(mainPage.getMkadAnswerDescription());
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, CORRECT_MKAD_DESCRIPTION);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
