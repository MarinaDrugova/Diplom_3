import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.FormLocatorsPage;
import org.example.User;
import org.example.UserClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import static junit.framework.TestCase.assertEquals;

public class CheckEnterTest {
    private WebDriver driver;
    private String expectedTextCreateOrder ="Оформить заказ";
    private String name = "Anna";
    Random random = new Random();
    private String email = random.nextInt(10000) + "@yandex.ru";
    private String password = "Fwe1223";
    private String accessToken;

        @Before
        public void setUp(){
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            driver = new ChromeDriver();
            FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
            driver.manage().window().maximize();
            formLocatorsPage.openSite();

            UserClient userClient = new UserClient();
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName(name);
            ValidatableResponse response = userClient.create(user);
            accessToken = response.extract().path("accessToken").toString();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void enterAccountButton(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.clickEnterAccountButton();
        formLocatorsPage.writeEmailEntre(email);
        formLocatorsPage.writePasswordEnter(password);
        formLocatorsPage.clickEnterButtonEnter();
        String actualEnterAccountButton = formLocatorsPage.getTextCreateOrder();
        assertEquals(expectedTextCreateOrder, actualEnterAccountButton);
    }
    @Test
    @DisplayName("вход через Личный кабинет")
    public void enterForPersonalButtonArea(){
            FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
            formLocatorsPage.clickPersonalAreaButton();
            formLocatorsPage.writeEmailEntre(email);
            formLocatorsPage.writePasswordEnter(password);
            formLocatorsPage.clickEnterButtonEnter();
            String actualEnterAccountButton = formLocatorsPage.getTextCreateOrder();
            assertEquals(expectedTextCreateOrder, actualEnterAccountButton);
        }
        @Test
    @DisplayName("вход через форму Pегистрации")
    public void enterRegistrationForm(){
            FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
            formLocatorsPage.clickEnterAccountButton();
            formLocatorsPage.clickRegistrationButtonPageEnter();
            formLocatorsPage.writeEmailFieldRegistration(email);
            formLocatorsPage.writeNameFieldRegistration(name);
            formLocatorsPage.writePasswordFieldRegistration(password);
            formLocatorsPage.clickEnterButtonRegistration();
            formLocatorsPage.writeEmailEntre(email);
            formLocatorsPage.writePasswordEnter(password);
            formLocatorsPage.clickEnterButtonEnter();
            String actualEnterAccountButton = formLocatorsPage.getTextCreateOrder();
            assertEquals(expectedTextCreateOrder, actualEnterAccountButton);
        }
        @Test
    @DisplayName("вход через кнопку восстановления пароля")
        public void EnterRestorePasswordButton(){
            FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
            formLocatorsPage.clickEnterAccountButton();
            formLocatorsPage.restorePasswordButton();
            formLocatorsPage.enterMemoryPassword();
            formLocatorsPage.writeEmailEntre(email);
            formLocatorsPage.writePasswordEnter(password);
            formLocatorsPage.clickEnterButtonEnter();
            String actualEnterAccountButton = formLocatorsPage.getTextCreateOrder();
            assertEquals(expectedTextCreateOrder, actualEnterAccountButton);
        }
    @After
    public void teardown() {
        UserClient userClient = new UserClient();
        driver.quit();
        if (accessToken != null) {
            userClient.delete(accessToken);
        }
    }
}