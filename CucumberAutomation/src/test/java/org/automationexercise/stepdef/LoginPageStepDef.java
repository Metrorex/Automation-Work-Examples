package org.automationexercise.stepdef;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationexercise.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Given("I am on the AutomationExercise login page")
    public void i_am_on_the_automation_exercise_login_page(){
        driver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid email and password")
    public void i_have_entered_a_valid_email_and_password(){
        loginPage.enterEmail("asdasdasd@a.com");
        loginPage.enterPassword("asdasdasd");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String password){
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully(){
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).isDisplayed(), true);
    }
}
