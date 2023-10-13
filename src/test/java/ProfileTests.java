import POM.BasePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");
        BasePage basePage = new BasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfile();

        // type password
        profilePage.enterPasswordInProfile();

        String name = generateRandomName();
        System.out.println(name);
        // type new name
        profilePage.enterNewNameInProfile(name);

        // type email
        profilePage.enterEmailInProfilePage();

        // click save
        profilePage.clickSaveInProfile();

        // assert profile name is new
        basePage.isSuccessBannerDisplayed();
        driver.navigate().refresh();//разобраться!
         Assert.assertEquals( basePage.getNewProfileName(),name);
    }
}
