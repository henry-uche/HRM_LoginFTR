package Step_Definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin {
    public WebDriver driver;
    @Given("^I navigates to the home Page$")
    public void iNavigatesToTheHomePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("^I enter an invalid  username$")
    public void iEnterAnInvalidUsername() {
        driver.findElement(By.name("username")).sendKeys("garry");
    }

    @And("^I enter an invalid password$")
    public void iEnterAnInvalidPassword() {
        driver.findElement(By.name("password")).sendKeys("Garry33");
    }

    @When("^I hit on the login button$")
    public void iHitOnTheLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
    }

    @Then("^I should not be logged in successfully$")
    public void iShouldNotBeLoggedInSuccessfully() {
        String ExpectedLogInErrorMessage = "Invalid credentials";
        String ActualLogInErrorMessage = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(ExpectedLogInErrorMessage, ActualLogInErrorMessage);
        System.out.println(ActualLogInErrorMessage);

    }
}
