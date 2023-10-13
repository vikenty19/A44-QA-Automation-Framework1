import POM.BasePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName()  {
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
    @Test (groups = "ProfileTests")

    public void profileThemeTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfile();
        Thread.sleep(3000);
     //   WebElement colorPane = driver.findElement(By.tagName("li:nth-of-type(1) > .theme > .name"));
        WebElement footer = driver.findElement(By.cssSelector("li:nth-of-type(8) > .theme > .name"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer, 0, -50);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin,0, 200)
                .perform();
        Thread.sleep(5000);
    }
}
//li:nth-of-type(2) > .theme > .name