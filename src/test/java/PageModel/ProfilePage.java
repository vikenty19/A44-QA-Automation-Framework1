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
    public void clickAvatar(){
        WebElement avatar = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".avatar")));
        avatar.click();

    }

    public void clickSbmit(){
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();

    }
    public void compareNames(String name) {
        WebElement profile = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".view-profile>span")));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }



}
