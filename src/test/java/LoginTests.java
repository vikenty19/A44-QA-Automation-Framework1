import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class LoginTests extends BaseTest {
    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }


    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        // find if avatar exists
        Assert.assertTrue(homePage.getAvatar()," User is NOT Logged in");
        System.out.println("User logged successfully   " + homePage.getAvatar());
    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail("demo@class.com");
        loginpage.clickLoginBtn();
        WebElement submitLogin =waitUntilVisible(By.cssSelector("button[type='submit']"));
        System.out.println("Is Submit button is displayed?  " + submitLogin.isDisplayed());
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail("notexists@class.com");
        loginpage.enterPassword("te$t$tudent");
        loginpage.clickLoginBtn();
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }
  @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email,String password){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail(email);
        loginpage.enterPassword(password);
        loginpage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);
  }

    //        Email("demo@class.com");
//        Password("te$t$tudent");
}
