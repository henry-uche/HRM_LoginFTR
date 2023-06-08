package Step_Definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validlogin {
    public WebDriver driver;
    @Given("^I am on the landing page$")
    public void iAmOnTheLandingPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("^I enter a valid username in the username field$")
    public void iEnterAValidUsernameInTheUsernameField() {
        driver.findElement(By.name("username")).sendKeys("Admin");
    }

    @And("^I enter a valid password in the password field$")
    public void iEnterAValidPasswordInThePasswordField() {
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @When("^I click on the login button$")
    public void iClickOnTheLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
    }

    @Then("^I should be successfully logged in$")
    public void iShouldBeSuccessfullyLoggedIn() {
        String ExpectedLoggedInUser = "Paul Collings";
        String ActualLoggedInUser = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).getText();
        Assert.assertEquals(ExpectedLoggedInUser, ActualLoggedInUser);
        System.out.println(ActualLoggedInUser);

    }

    @Then("^I can logout$")
    public void iCanLogout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("username")).isDisplayed();

    }
}
