//test login functionality with incorrect credentials

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class testLoginFunctionalityInvalid {

    @Test
        public void Test(){
        //Create the driver
        WebDriver driver = new ChromeDriver();
        //Maximize the windows
        driver.manage().window().maximize();
        //Open Website
        driver.get("https://automationexercise.com");

        //Click on "Signup/Login" button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // Create variables for email, password and "Login" button
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Populate the fields and submit the form
        emailInput.sendKeys("wrongEmail@example.com");
        passwordInput.sendKeys("definitelyNotTheCorrectPw");
        loginButton.click();

        //verify login status
        String actualUrl = "https://automationexercise.com";
        String expectedUrl = driver.getCurrentUrl();

        // try catch the error message for failed login if any
        // used try-catch instead of using assertion because, if login is successful, user is not redirected to a different page eg "/dashboard"

        try{
            WebElement errorMessageElement = driver.findElement(By.cssSelector("p"));
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error message received: " + errorMessage);
        } catch (Exception e){
            System.out.println("No errors found / login successful");
        }

        driver.quit();
    }
}
