package ru.praktikum.scooter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.scooter.pom.MainPage;
import ru.praktikum.scooter.rules.BrowserRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionAndAnswerDropDownList {
    private final By question;
    private final By answer;
    private final String expectedResult;

    private static final String CORRECT_COST_DESCRIPTION = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String CORRECT_SEVERAL_SCOOTERS_DESCRIPTION = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String CORRECT_TIME_CALCULATION_DESCRIPTION = "Допустим, вы оформляете заказ на 8 мая. " +
            "Мы привозим самокат 8 мая в течение дня. " +
            "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String CORRECT_ORDER_TODAY_DESCRIPTION = "Только начиная с завтрашнего дня. " +
            "Но скоро станем расторопнее.";
    private static final String CORRECT_EXTEND_OR_RETURN_DESCRIPTION = "Пока что нет! " +
            "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String CORRECT_CHARGING_DESCRIPTION = "Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String CORRECT_CANCEL_ORDER_DESCRIPTION = "Да, пока самокат не привезли. " +
            "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String CORRECT_MKAD_DESCRIPTION = "Да, обязательно. " +
            "Всем самокатов! И Москве, и Московской области.";

    public QuestionAndAnswerDropDownList(By question,
                                         By answer,
                                         String expectedResult) {
        this.question = question;
        this.answer = answer;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        BrowserRule browserRule = new BrowserRule();
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        return new Object[][]{
                { mainPage.getCostQuestionButton(), mainPage.getCostAnswerDescription(), CORRECT_COST_DESCRIPTION },
                { mainPage.getSeveralScootersQuestionButton(), mainPage.getSeveralScootersAnswerDescription(), CORRECT_SEVERAL_SCOOTERS_DESCRIPTION },
                { mainPage.getTimeСalculationQuestionButton(), mainPage.getTimeСalculationAnswerDescription(), CORRECT_TIME_CALCULATION_DESCRIPTION },
                { mainPage.getOrderTodayQuestionButton(), mainPage.getOrderTodayAnswerDescription(), CORRECT_ORDER_TODAY_DESCRIPTION },
                { mainPage.getExtendOrReturnQuestionButton(), mainPage.getExtendOrReturnAnswerDescription(), CORRECT_EXTEND_OR_RETURN_DESCRIPTION },
                { mainPage.getChargingQuestionButton(), mainPage.getChargingAnswerDescription(), CORRECT_CHARGING_DESCRIPTION },
                { mainPage.getCancelOrderQuestionButton(), mainPage.getCancelOrderAnswerDescription(), CORRECT_CANCEL_ORDER_DESCRIPTION },
                { mainPage.getMkadQuestionButton(), mainPage.getMkadAnswerDescription(), CORRECT_MKAD_DESCRIPTION },
        };
    }
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkAnswerCorrectText() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage
                .open()
                .scrollToElement(question)
                .clickQuestionButton(question)
                .waitElement(answer);
        String actualResult = mainPage.getAnswerText(answer);
        assertEquals("Текст описания не соответствует ожидаемому результату",
                actualResult, expectedResult);
    }
}
