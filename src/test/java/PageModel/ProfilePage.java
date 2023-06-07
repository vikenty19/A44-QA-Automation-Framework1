package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends Basepage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickAvatar(){
        WebElement avatar = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".avatar")));
        avatar.click();

    }



}
