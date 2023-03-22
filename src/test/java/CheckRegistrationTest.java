import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.FormLocatorsPage;
import org.example.Login;
import org.example.UserClient;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class CheckRegistrationTest {
    private WebDriver driver;
    private String expectedTextEnter ="Вход";
    private String expectedWrongPassword = "Некорректный пароль";
    private String name = "Anna";
    Random random = new Random();
    private String email = random.nextInt(100000) + "@yandex.ru";
    private String password = "Fwe1223";
    private String accessToken;

    @Before
    public void setUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        driver.manage().window().maximize();
        formLocatorsPage.openSite();
        formLocatorsPage.clickPersonalAreaButton();
        formLocatorsPage.clickRegistrationButtonPageEnter();
        formLocatorsPage.writeNameFieldRegistration(name);
        formLocatorsPage.writeEmailFieldRegistration(email);

    }
    @Test
    @DisplayName("успешная регистрация")
    public void successRegistrationTest(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.writePasswordFieldRegistration(password);
        formLocatorsPage.clickRegistrationButtonPageEnter();
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        UserClient userClient =new UserClient();
        ValidatableResponse responseLogin = userClient.login(login);
        if (responseLogin.extract().statusCode() == 200){
            accessToken = responseLogin.extract().path("accessToken").toString();
        }
        String actualTextEnter = formLocatorsPage.getTextEnter();
        assertEquals(expectedTextEnter, actualTextEnter);
    }
    @Test
    @DisplayName("ошибка при некорректном пароле")
    public void errorWrongPassword(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.writePasswordEnter("Qwert112");
        formLocatorsPage.clickRegistrationButtonPageEnter();
        formLocatorsPage.writeEmailEntre(email);
        formLocatorsPage.writePasswordEnter(password);
        String actualError = formLocatorsPage.getTextEnter();
        assertEquals(expectedWrongPassword, "Некорректный пароль");
    }
}