package org.automationexercise.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.*;

public class LoginPage {
    private WebDriver driver;

    //By locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By logoutButtonLocator = By.xpath("//a[@href='/logout']");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Public Methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton =  driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public boolean checkLogoutLink(){
        return driver.findElement(logoutButtonLocator).isDisplayed();
    }
    /*public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
     */
}
