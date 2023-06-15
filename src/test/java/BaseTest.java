import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BaseTest {
    public static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static String url = "https://qa.koel.app/";
    public static WebDriverWait wait = null;
    public By successLocator = By.cssSelector(".success");

    @BeforeSuite
 /*  static void setupDriver() {
       WebDriverManager.chromedriver().setup();
    }*/
    public static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }
    @BeforeMethod
//    @Parameters({"BaseURL"})
    //  public void setUpBrowser(String BaseURL){
    public void setUpBrowser() throws MalformedURLException {
 /*       ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);*/
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get(url);



    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
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
            case "cloud":
                return lambdaTest();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName","chrome");
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "vicplach";
        String authkey = "rWyJp95DsCIJC6QTdW4yzUxSno3xnEEBcjkK3vWmfwco8uPAt9";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Edge");
        caps.setCapability("version", "112.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public String generateRandomPlaylistName() {

        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }


    public void openUrl(String url) {
        driver.get(url);
    }


    public boolean isBannerDisplayed() {
        WebElement successBanner = driver.findElement(successLocator);
        return successBanner.isDisplayed();
    }


}