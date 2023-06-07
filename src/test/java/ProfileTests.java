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
        loginPage.login("demo@class.com", "te$t$tudent");
        loginPage.clickLoginBtn();

        // open profile
        profilePage.clickAvatar();

        WebElement avatar = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".avatar")));
        avatar.click();

        // type password
        WebElement currentPasswordInput = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
        // type new name
        String name = generateRandomName();
        System.out.println(name);
        WebElement profileName = driver.findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
        // type email
        WebElement emailInput = driver.findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // click save
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
        // assert profile name is new
        driver.navigate().refresh();
        WebElement profile = driver.findElement(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }




}
