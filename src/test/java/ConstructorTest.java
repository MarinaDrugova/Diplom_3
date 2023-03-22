import io.qameta.allure.junit4.DisplayName;
import org.example.FormLocatorsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest {
    private WebDriver driver;
    private String expectedBunsText = "Булки";
    private String expectedSaucesText = "Соусы";
    private String expectedFillingsText = "Начинки";
    private String expectedConstructorText = "Соберите бургер";

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        driver.manage().window().maximize();
        formLocatorsPage.openSite();
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goArealToConstructor(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.clickPersonalAreaButton();
        formLocatorsPage.clickConstructorButton();
        String actualConstructorText = formLocatorsPage.getTextConstructor();
        assertEquals(expectedConstructorText, actualConstructorText);
    }
    @Test
    @DisplayName("переход к разделу Булки")
    public void goBunsInConstructor(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.clickBunsShowcaseButton();
        String actualResult = driver.findElement(formLocatorsPage.getResultSection()).getText();
        assertEquals(expectedBunsText, actualResult);
    }
    @Test
    @DisplayName("переход к разделу Соусы")
    public void goSaucesInConstructor(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.clickSauceShowcaseButton();
        String actualResult = driver.findElement(formLocatorsPage.getResultSection()).getText();
        assertEquals(expectedSaucesText, "Соусы");
    }
    @Test
    @DisplayName("переход к разделу Начинки")
    public void goFillingInConstructor(){
        FormLocatorsPage formLocatorsPage = new FormLocatorsPage(driver);
        formLocatorsPage.clickFillingsShowcaseButton();
        String actualResult = driver.findElement(formLocatorsPage.getResultSection()).getText();
        assertEquals(expectedFillingsText, actualResult);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}