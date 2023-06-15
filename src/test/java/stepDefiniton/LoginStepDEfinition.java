package stepDefiniton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDEfinition {
    public static WebDriver driver = null;

    public static String url = "https://qa.koel.app/";
    public static WebDriverWait wait = null;

    @Given("I open Login Page")
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


    @When("I enter email")
    public void iEnterEmail() {
    }

    @And("I enter password")
    public void iEnterPassword() {
    }

    @And("I click submit")
    public void iClickSubmit() {
    }

    @Then("I logged in")
    public void iLoggedIn() {
    }
}
