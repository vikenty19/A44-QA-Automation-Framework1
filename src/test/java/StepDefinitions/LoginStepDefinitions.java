package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.After;
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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class LoginStepDefinitions {
    public static WebDriver driver = null;
    public static String url ="https://qa.koel.app/";
    public static WebDriverWait wait = null;
    @After
    public void tearDown() {
        driver.quit();
    }
    @Given ("I open browser")
    public void setUpDriver(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

     //   wait = new WebDriverWait(driver, Duration.ofSeconds(5));
   //    wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver = new ChromeDriver(options);

    }
    @When("I open login page")
    public void iOpenLoginPage(){
        driver.get(url);
    }
    @And("i enter valid email")
    public void iEnterEmail(){
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
                emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");

    }
    @And("I enter valid password")
    public void iEnterPassword(){
        LoginPage loginPage = new LoginPage(driver);
       WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
                passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
 /* LoginPage loginPage = new LoginPage(driver);
  loginPage.clickLoginBtn();*/



     /*   WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
                passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");*/

   loginPage.enterPassword("te$t$tudent");
    }
    @And("I click Submit")
    public void iClickSubmit(){
   /*  WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
                submitLogin.click();*/
     LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
           }


    @Then("I am logged in")
    public void iLoggedIn(){

        HomePage homePage = new HomePage(driver);
       Assert.assertTrue(homePage.getAvatar());
    }

}
