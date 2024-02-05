//test order placing functionality with valid data

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class checkPlacingOrder{
        @Test
        public void Test(){

            WebDriver driver = new ChromeDriver();
            //maximize the window
            driver.manage().window().maximize();
            //open the Webpage
            driver.get("https://automationexercise.com/");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //find the products button and click on it
            driver.findElement(By.xpath("//a[@href='/products']")).click();

            //make the dropdown animation to appear for the Blue Top product
            WebElement divElement = driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(divElement).perform();

            //scroll down to fully see the product card
            js.executeScript("window.scrollBy(0, 500)");

            //add to cart the Blue Top product
            WebElement addItem = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)"));
            addItem.click();

            //wait 5s for the modal element to be visible
            WebElement modalElement = driver.findElement(By.id("cartModal"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(modalElement));

            //click on continue shopping
            WebElement continueShoppingButton = modalElement.findElement(By.xpath("(//button[normalize-space()='Continue Shopping'])"));
            continueShoppingButton.click();

            //return to cart
            driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();

            //click on proceed to checkout
            driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

            //click on login/register
            driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

            //populate the login form with provided data and submit form
            WebElement username = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            WebElement password =driver.findElement(By.xpath("//input[@placeholder='Password']"));
            username.sendKeys("asdasdasd@a.com");
            password.sendKeys("asdasdasd");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            //return to cart and proceed to checkout while logged in
            driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

            //scroll down
            js.executeScript("window.scrollBy(0, 500)");
            //place order
            driver.findElement(By.xpath("//a[@href='/payment']")).click();

            //create elements for each variable and populate payment form
            WebElement nameCard = driver.findElement(By.name("name_on_card"));
            WebElement cardNr = driver.findElement(By.name("card_number"));
            WebElement cvc = driver.findElement(By.name("cvc"));
            WebElement expMonth = driver.findElement(By.name("expiry_month"));
            WebElement expYear = driver.findElement(By.name("expiry_year"));
            nameCard.sendKeys("John Smith");
            cardNr.sendKeys("1234-1234-1234-1234"); // adding the "-" is not a good practice, but I did it for better visualisation in this case
            cvc.sendKeys("123");
            expMonth.sendKeys("01");
            expYear.sendKeys("2030");
            driver.findElement(By.id("submit")).click();

            //check if the order was successfully placed

            String actual = driver.findElement(By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p")).getText();
            String expected = "Congratulations! Your order has been confirmed!";
                if(actual.equals(expected)){
                    System.out.println("Strings matched. Order placed successfully");
                } else {
                    System.out.println("Strings mismatched. Check console");
                }
            //close the Website
            driver.quit();
        }
    }