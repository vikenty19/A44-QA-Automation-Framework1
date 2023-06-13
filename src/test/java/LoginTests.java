import PageModel.HomePage;
import PageModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class LoginTests extends BaseTest {

    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(email)
                    .enterPassword(password)
                    .clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login("vicplach123@gmail.com", "MEGAdelta06@");
        Assert.assertTrue(homePage.getAvatar());

    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("MEGAdelta06@")
                  .clickLoginBtn();
        loginPage.isSubmitBtnDisplayed();
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("notexists@class.com", "MEGAdelta06@");
        loginPage.isSubmitBtnDisplayed();
     }


}