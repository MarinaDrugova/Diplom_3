package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By registrationEnterButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");//Кнопка "Зарегистрироваться" на странице Вход
    public By recoveryPasswordButton = By.xpath("Auth_link__1fOlj"); //Кнопка "Восстановить пароль"
    private By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");//Кнопка "Войти" на странице Вход
    private By passwordFieldEnter = By.xpath(".//div/main/div/form/fieldset[2]/div/div/input");
    private By emailFieldEnter = By.xpath(".//div/main/div/form/fieldset[1]/div/div/input");

    public void clickRegistrationEnterButton() {
        driver.findElement(registrationEnterButton).click();
    }
    public void clickRecoveryPasswordButton(){
        driver.findElement(recoveryPasswordButton).click();
    }
    public boolean checkEnterButton(){
        boolean isFindEnterButton = driver.findElement(enterButton).isDisplayed();
        return isFindEnterButton;
    }
    public void writeEmailFieldRegistration(){
        driver.findElement(emailFieldEnter).sendKeys("mardrugowa@yandex.ru");
    }
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
    public void writePasswordFieldRegistration(){
        driver.findElement(passwordFieldEnter).sendKeys("Mar021970");
    }
    public void loginClient(){
        writeEmailFieldRegistration();
        writePasswordFieldRegistration();
        clickEnterButton();
    }
}