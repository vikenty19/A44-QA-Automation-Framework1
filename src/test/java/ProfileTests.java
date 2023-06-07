import PageModel.Basepage;
import PageModel.LoginPage;
import PageModel.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        Basepage basepage= new Basepage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        loginPage.clickLoginBtn();

        // open profile
        profilePage.clickAvatar();

        loginPage.enterPassword("te$t$tudent");


        // type new name
        String name = basepage.generateRandomName();
        System.out.println(name);
        WebElement profileName = driver.findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
        // type email

        loginPage.enterEmail("demo@class.com");


        // click save
          profilePage.clickSbmit();

        // assert profile name is new
        basepage.refreshPage();



        WebElement profile = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".view-profile>span")));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }




}
