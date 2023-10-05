import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url ="https://qa.koel.app/";
    public static WebDriverWait wait = null;

    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        openUrl(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public String generateRandomName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public String generateRandomPlaylistName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }
   public String generateRandomPlaylistBookName() {
       Faker faker=new Faker();
      String newName =  faker.book().title();;
        return newName;
    }

 

    public void openUrl(String url) {

        driver.get(url);
    }




    public void searchForSong(String text) throws InterruptedException {

        WebElement searchInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);


    }

    void enterNameInSearchField(String name) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void clickSearchField() {
        WebElement searchInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        ;
    }

    public WebElement waitUntilVisible(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public WebElement waitUntilClickable(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));

    }
    public void isEqualizerDisplayed() {
        WebElement equalizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".bars")));
        Assert.assertTrue(equalizer.isDisplayed());
        System.out.println("Is equalizer displayed  " + equalizer.isDisplayed());
    }

}