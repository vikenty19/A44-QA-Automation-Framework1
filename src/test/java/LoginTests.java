import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;


public class LoginTests extends BaseTest {



    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login("demo@class.com","te$t$tudent");

            // find if avatar exists
        Assert.assertTrue(homePage.getAvatar(), " User is NOT Logged in");
        System.out.println("User logged successfully   " + homePage.getAvatar());
    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("demo@class.com", "");
        System.out.println("Is Submit button  displayed?  " + loginpage.isSubmitLoginBtnDisplayed());
        Assert.assertTrue(loginpage.isSubmitLoginBtnDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginpage.login("notexists@class.com","te$t$tudent");
        System.out.println("Is Submit button is displayed?  " + loginpage.isSubmitLoginBtnDisplayed());
        Assert.assertTrue(loginpage.isSubmitLoginBtnDisplayed());
         //       Assert.assertFalse(homePage.getAvatar());
    }


    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test

    public static void loginSucceedTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url = "https://testpro.io";
        driver.get(url);
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        Thread.sleep(5000);
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists"));
        driver.quit();

<<<<<<< HEAD
        public void loginSucceedTest () throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.enterEmail("demo@class.com");
            loginPage.enterPassword("te$t$tudent");
            loginPage.clickLoginBtn();
            Thread.sleep(3000);
            Assert.assertTrue(homePage.getAvatar());

        }
=======
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.getAvatar());

    }
>>>>>>> bc9fef5ba0e9417acd59e3df15d183eb09e3253c


        @Test
        public void loginEmptyPasswordTest () {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("demo@class.com", "");
            Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
        }

        @Test
        public void loginInvalidEmailTest () {
            LoginPage loginPage = new LoginPage(driver);
            loginPage
                    .enterEmail("notexists@class.com")
                    .enterPassword("te$t$tudent")
                    .clickLoginBtn();
            Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
        }


        //        Email("demo@class.com");
//        Password("te$t$tudent");
    }
}