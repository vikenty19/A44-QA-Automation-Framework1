package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void openProfile(){
        WebElement avatar =waitUntilVisible(By.cssSelector(".avatar"));
        avatar.click();
    }
}
