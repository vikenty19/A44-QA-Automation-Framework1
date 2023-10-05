import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");

        // open profile
        WebElement avatar =waitUntilVisible(By.cssSelector(".avatar"));
        avatar.click();
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
        driver.navigate().refresh();//разобраться!
        WebElement profile = waitUntilVisible(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }
}
