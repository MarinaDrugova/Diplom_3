package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FormLocatorsPage {
   private    WebDriver driver;
    public  FormLocatorsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String site = "https://stellarburgers.nomoreparties.site/";
    public void openSite() {
        driver.get(site);
    }
    public By personalAreaButton = By.xpath(".//div/header/nav/a/p[text()='Личный Кабинет']");
    private final By bunsShowcaseButton = By.xpath(".//span[text()='Булки']");
    public By bunsChoice = By.xpath(".//span[text()='Булки']/parent::div");
    private By resultChoice = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]//span");
    private final By sauceShowcaseButton = By.xpath(".//span[text()='Соусы']");
    public By sauceChoice = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By fillingsShowcaseButton = By.xpath(".//span[text()='Начинки']");
    public By fillingsChoice = By.xpath(".//span[text()='Начинки']/parent::div");
    public By enterAccountButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button"); //Кнопка "Войти в аккаунт" на главной странице
    public By passwordEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");//Ввод пароля в форме Вход
    public By emailEntre = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");//Ввод email в форме Вход
    public By enterButtonEnter = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");//Кнопка "Войти" на странице Вход
    public By textEnterToArea = By.cssSelector(".Auth_login__3hAey > h2"); //текст формы Вход
    public By constructorButton = By.xpath(".//p[text()='Конструктор']");//Кнопка "Конструктор"
    public By logoButton = By.xpath("AppHeader_header__logo__2D0X2"); //Кнопка лого
    public By createOrder = By.xpath("//*[text()='Оформить заказ']");

    public By passwordFieldRegistration = By.xpath(".//div/main/div/form/fieldset[3]/div/div/input");//Ввод пароля в форме Регистрация
    public By nameFieldRegistration = By.xpath(".//div/main/div/form/fieldset[1]/div/div/input");//Ввод имени в форме Регистрация
    public By emailFieldRegistration = By.xpath(".//div/main/div/form/fieldset[2]/div/div/input");//Ввод email в форме Регистрация
    public By enterButtonRegistration = By.className("Auth_link__1fOlj");//Кнопка "Войти" на странице Регистрация
    public By registrationButtonPageRegistration = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");//Кнопка "Зарегистрироваться" на странице Регистрация
    public By registrationButtonPageEnter = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");//Кнопка "Зарегистрироваться" на странице Вход
    public By wrongPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");//ссобщение о неправильном пароле
    public By restorePassword = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a"); //кнопка Восстановить пароль
    public By enterRecallPassword = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");// вспомнили пароль? Войти
    public By exitFromPersonalArea = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");
    public By textConstructor = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1"); // заголовок "Соберите бургер"
    public void standBy(By element) {
        (new WebDriverWait(driver, Duration.ofSeconds(4)))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickPersonalAreaButton(){
        driver.findElement(personalAreaButton).click();
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }
    public void writeEmailEntre(String email){
        driver.findElement(emailEntre).sendKeys(email);
    }
    public void writePasswordEnter(String password){
        driver.findElement(passwordEnter).sendKeys(password);
    }
    public void clickEnterButtonEnter(){
        driver.findElement(enterButtonEnter).click();
        standBy(createOrder);
    }
    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }
    public String getTextCreateOrder(){
        return driver.findElement(createOrder).getText();
    }
    public String getTextEnter(){
        return driver.findElement(textEnterToArea).getText();
    }
    public String getTextErrorWrongPassword(){
        return driver.findElement(wrongPassword).getText();
    }
    public String getTextConstructor() {
        return driver.findElement(textConstructor).getText();
    }

    public void clickBunsShowcaseButton(){
        driver.findElement(bunsShowcaseButton);
        new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void clickSauceShowcaseButton(){
        driver.findElement(sauceShowcaseButton);
        new WebDriverWait(driver, Duration.ofSeconds(1));
    }
    public void clickFillingsShowcaseButton(){
        driver.findElement(fillingsShowcaseButton).click();
    }
    public String getBunsChoice(){
        return driver.findElement(bunsChoice).getAttribute("class");
    }
    public String getSauceChoice(){
        return driver.findElement(sauceChoice).getAttribute("class");
    }
    public String getFillingsChoice(){
        return driver.findElement(fillingsChoice).getAttribute("class");
    }
    public void writeNameFieldRegistration(String name){
        driver.findElement(nameFieldRegistration).sendKeys(name);
    }
    public void writeEmailFieldRegistration(String email){
        driver.findElement(emailFieldRegistration).sendKeys(email);
    }
    public void writePasswordFieldRegistration(String password){
        driver.findElement(passwordFieldRegistration).sendKeys(password);
    }
    public void clickRegistrationButtonPageRegistration(){
        driver.findElement(registrationButtonPageRegistration).click();
    }
    public void clickRegistrationButtonPageEnter(){
        driver.findElement(registrationButtonPageEnter).click();
    }
    public void restorePasswordButton(){
        driver.findElement(restorePassword).click();
    }
    public void enterMemoryPassword(){
        driver.findElement(enterRecallPassword).click();
    }
    public void writeDataFormRegistration(String name,String email, String password){
        writeNameFieldRegistration(name);
        writeEmailFieldRegistration(email);
        writePasswordFieldRegistration(password);
    }
    public void clickEnterButtonRegistration(){
        driver.findElement(enterButtonRegistration).click();
    }
    public void clickExitFromPersonalArea(){
        driver.findElement(exitFromPersonalArea).click();
    }
    public By getResultSection() {
        return resultChoice;
    }
}