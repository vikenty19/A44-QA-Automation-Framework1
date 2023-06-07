package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProfilePage extends Basepage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By avatarClick = By.cssSelector(".avatar");
    private By submitLocator = By.cssSelector(".btn-submit");
    private By  namesCompare = By.cssSelector(".view-profile>span");
    private By profName =    By.cssSelector("#inputProfileName");

    public void clickAvatar(){
        WebElement avatar = wait.until(ExpectedConditions
                .elementToBeClickable (avatarClick));
        avatar.click();

    }

    public void clickSbmit(){
        WebElement saveBtn = driver.findElement(submitLocator );
        saveBtn.click();

    }
    public void compareNames(String name) {
        WebElement profile = wait.until(ExpectedConditions
                .elementToBeClickable(namesCompare));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }

    public void NameOfProfile(String name) {
        WebElement profileName = driver.findElement(profName);
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
    }


}
