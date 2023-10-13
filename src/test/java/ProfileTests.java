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

        // open profile
       
        // type password
        WebElement currentPasswordInput = waitUntilClickable(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
        // type new name
        String name = generateRandomName();
        System.out.println(name);
        WebElement profileName = waitUntilClickable(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
        // type email
        WebElement emailInput = waitUntilClickable(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // click save
        WebElement saveBtn = waitUntilClickable(By.cssSelector(".btn-submit"));
        saveBtn.click();
        // assert profile name is new
        basePage.isSuccessBannerDisplayed();
        driver.navigate().refresh();//разобраться!
        WebElement profile = waitUntilVisible(By.cssSelector("span .name"));//.view-profile>span
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }
}
