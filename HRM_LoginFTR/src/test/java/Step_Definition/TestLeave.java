package Step_Definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLeave {
    public WebDriver driver;
    @Given("^I am logged in successfully$")
    public void iAmLoggedInSuccessfully() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @When("^I click on the Leave menu$")
    public void iClickOnTheLeaveMenu() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
        Thread.sleep(2000);
    }

    @Then("^I should be navigated to the Leave list page$")
    public void iShouldBeNavigatedToTheLeaveListPage() {
        driver.findElement(By.linkText("Leave List")).isDisplayed();
        String ExpectedMenuSubFeature = "Leave List";
        String ActualMenuSubFeature = driver.findElement(By.linkText("Leave List")).getText();
        Assert.assertEquals(ExpectedMenuSubFeature, ActualMenuSubFeature);
        System.out.println(ActualMenuSubFeature);
    }
}
