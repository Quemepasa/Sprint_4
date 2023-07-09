package ru.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.pom.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderingScooter {
    private WebDriver driver;
    private final By orderButtonMainPage;
    private final String name; // = "Оптимус";
    private final String surname;// = "Прайм";
    private final String address;// = "Волоколамское ш., 71, 4";
    private final String phoneNumber;// = "89999999999";
    private final String date;// = "21.08.2023";

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
        return new Object[][]{
                { By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']"),
                        "Оптимус", "Прайм", "Волоколамское ш., 71", "89999999999", "21.08.2023"},
                { By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"),
                        "Хали", "Гали", "Ул. Пушкинва, 59", "89112223344", "15.10.2024"},
        };
    }


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void orderScooterWithCorrectData() {
        MainPage mainPage = new MainPage(driver);
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(driver);
        OrderInfoPage orderInfoPage = new OrderInfoPage(driver);
        СonfirmationModal confirmationModal = new СonfirmationModal(driver);
        SuccessfulOrderModal successfulOrderModal = new SuccessfulOrderModal(driver);

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

    @After
    public void tearDown() {
        driver.quit();
    }
}
