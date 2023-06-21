package stepDefiniton;

import PageModel.HomePage;
import PageModel.LoginPage;
import PageModel.SongsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class LoginStepDefinitions {
    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static WebDriver driver = null;

    public static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }

    public static String url = "https://qa.koel.app/";
    public static WebDriverWait wait = null;

    @Before
    public void openBrowser() throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After

    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.184:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
     /*       case "cloud":
                return lambdaTest();*/
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }


    @Given("i open login page")
    public void iOpenLoginPage() {
        getDriver().get("https://qa.koel.app/");
    }


    @When("I enter email")
    public void iEnterEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("vicplach123@gmail.com");
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterPassword("MEGAdelta06@");
    }

    @And("I click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginBtn();
    }

    @Then("I logged in")
    public void iLoggedIn() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getAvatar());
    }


    @And("i click play button")
    public void iClickPlayButton() {
        SongsPage songsPage = new SongsPage(getDriver());
        songsPage.startPlaySong();

    }

    @Then("i see equalizer")

    public void iSeeEqualizer() {
        SongsPage songsPage = new SongsPage(getDriver());
        Assert.assertTrue(songsPage.isEqualizerBtnDisplayed());
    }

    @And("I enter wrong password")
    public void iEnterWrongPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterPassword("MEGAdelta");
    }


    @Then("I'm no logged in")
    public void iMNoLoggedIn() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.isSubmitBtnDisplayed();
    }

}
