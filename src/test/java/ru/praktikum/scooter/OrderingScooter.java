package ru.praktikum.scooter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.scooter.pom.*;
import ru.praktikum.scooter.rules.BrowserRule;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderingScooter {
    private final By orderButtonMainPage;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String date;

    public OrderingScooter(By orderButtonMainPage,
                           String name,
                           String surname,
                           String address,
                           String phoneNumber,
                           String date) {
        this.orderButtonMainPage = orderButtonMainPage;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Object[][] getPositionOfOrderButton() {
        BrowserRule browserRule = new BrowserRule();
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        return new Object[][]{
                { mainPage.getOrderButtonInHeader(), "Оптимус", "Прайм", "Волоколамское ш., 71", "89999999999", "21.08.2023"},
                { mainPage.getOrderButtonAtBottom(), "Хали", "Гали", "Ул. Пушкинва, 59", "89112223344", "15.10.2024"},
        };
    }
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void orderScooterWithCorrectData() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(browserRule.getWebDriver());
        OrderInfoPage orderInfoPage = new OrderInfoPage(browserRule.getWebDriver());
        СonfirmationModal confirmationModal = new СonfirmationModal(browserRule.getWebDriver());
        SuccessfulOrderModal successfulOrderModal = new SuccessfulOrderModal(browserRule.getWebDriver());

        mainPage
                .open()
                .scrollToElement(orderButtonMainPage)
                .clickOrderButton(orderButtonMainPage);

        customerInfoOrderPage
                .inputTextNameField(name)
                .inputTextSurnameField(surname)
                .inputTextAddressField(address)
                .clickMetroField()
                .clickMetroStationCherkizovskaya()
                .inputTextPhoneNumberField(phoneNumber)
                .clickNextButton();

        orderInfoPage
                .inputTextDateField(date)
                .clickDropdownArrowRentalPeriod()
                .clickFreeDaysRentalPeriod()
                .clickOrderButtonInMiddle();

        confirmationModal
                .clickConfirmationButton();

        assertTrue("Нет сообщения 'Заказ оформлен'", successfulOrderModal.checkSuccessHeaderModalExists());
    }
}
