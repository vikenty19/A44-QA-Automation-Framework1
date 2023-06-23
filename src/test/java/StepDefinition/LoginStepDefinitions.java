package StepDefinition;

import PageModel.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions {
    public static WebDriver driver = null;


    public static String url = "https:///qa.koel.app/";
    public static WebDriverWait wait = null;
    @Given("I open browser")
    public void openBrowser(){

            WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("I open Login page")
    public void iOpenLoginPage() {
    driver.get(url);
    }

    @And("I enter email")
    public void iEnterEmail() {
        WebElement emailInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='email']")));

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("vicplach123@gmail.com");
    }

    @And("I enter password")
    public void iEnterPassword() {
WebElement passwordInput = wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("MEGAdelta06@");
    }

    @And("i click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage.clickLoginBtn();
    }

    @Then("I logged in")
    public void iLoggedIn() {
    }
}
