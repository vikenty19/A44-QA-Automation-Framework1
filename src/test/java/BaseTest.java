import POM.BasePage;
import POM.LoginPage;
import POM.SongPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BaseTest {
      static WebDriver driver;
    WebDriverWait wait;
     String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
//    @Parameters({"BaseURL"})
  //  public void setUpBrowser(String BaseURL){
        public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        openUrl(url);
       ;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }



    public void openUrl(String url) {
        driver.get(url);
    }



    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }
<<<<<<< Updated upstream
=======
    @DataProvider(name = "profileThemeTest")
    public static Object[][] getProfileThemeFromDataProvider(){
        return new Object[][]{
                //    {"li:nth-of-type(1) > .theme > .name", 0},
                {"li:nth-of-type(8) > .theme > .name", 7},
                {"li:nth-of-type(16) > .theme > .name", 15},
        };
    }



    public void searchForSong(String text)  {

        WebElement searchInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);


    }






>>>>>>> Stashed changes

}