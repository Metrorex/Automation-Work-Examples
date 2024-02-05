//test the login functionality with valid credentials

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import java.lang.Thread;

public class testLoginFunctionality {

    @Test
    public void Test() {
        WebDriver driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Open Webpage
        driver.get("https://automationexercise.com/");
        //Find login button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //Create variables for email, password and submit button
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        //Populate variables with correct credentials
        emailInput.sendKeys("asdasdasd@a.com");
        passwordInput.sendKeys("asdasdasd");

        //Submit login form
        submitButton.click();

        //Try catch error messages if failed login
        try {
            WebElement errorMessageElement = driver.findElement(By.cssSelector("div[@class='login-form'] > p"));
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error message: " + errorMessage);
        } catch (Exception e) {
            System.out.println("No error message returned / login successful");
        }

        //Log out
        WebElement logOut = driver.findElement(By.xpath("//a[@href='/logout']"));
        logOut.click();

        //Delay before closing the Website
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Close the Website
        driver.quit();

    }
}
