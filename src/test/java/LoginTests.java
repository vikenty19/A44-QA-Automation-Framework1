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
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();

        // find if avatar exists
        Thread.sleep(3000);
        WebElement avatar = waitUntilVisible(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

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
