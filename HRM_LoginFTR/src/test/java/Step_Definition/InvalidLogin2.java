package Step_Definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eclipse.jetty.util.security.Password;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin2 {
    public WebDriver driver;
    @Given("^I get to the Home page$")
    public void iGetToTheHomePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("^I enter \"([^\"]*)\" in the username field$")
    public void iEnterInTheUsernameField(String Username) throws Throwable {
        driver.findElement(By.name("username")).sendKeys(Username);
    }

    @And("^I enter \"([^\"]*)\" in the password field$")
    public void iEnterInThePasswordField(String Password) throws Throwable {
        driver.findElement(By.name("password")).sendKeys(Password);
    }

    @When("^I click login button$")
    public void iClickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
    }

    @Then("^I should get the correct \"([^\"]*)\"$")
    public void iShouldGetTheCorrect(String Errormessage) throws Throwable {
        String ExpectedLoggedInUser = Errormessage;
        String ActualLoggedInUser = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(ExpectedLoggedInUser, ActualLoggedInUser);
        System.out.println(ActualLoggedInUser);
    }
}
