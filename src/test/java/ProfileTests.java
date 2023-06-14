import PageModel.Basepage;
import PageModel.LoginPage;
import PageModel.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "Profile.xml")
    public void changeProfileName() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        Basepage basepage = new Basepage(getDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        loginPage.clickLoginBtn();
        profilePage.clickAvatar();
        loginPage.enterPassword("te$t$tudent");
        String name = basepage.generateRandomName();
        System.out.println(name);
        profilePage.NameOfProfile(name);
        loginPage.enterEmail("demo@class.com");
        profilePage.clickSbmit();
        basepage.refreshPage();
        profilePage.compareNames(name);
    }


}
