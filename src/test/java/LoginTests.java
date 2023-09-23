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
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        // find if avatar exists
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        Thread.sleep(5000);
    }


    @Test
    public void loginEmptyPasswordTest() {
        openUrl();
        enterEmail("demo@class.com");
        clickLoginBtn();
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        openUrl();
        enterEmail("notexists@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }
  @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email,String password){
      String url = "https://qa.koel.app/";
        openUrl();
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);
  }

    //        Email("demo@class.com");
//        Password("te$t$tudent");
}
