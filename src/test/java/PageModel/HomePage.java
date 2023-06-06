package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Basepage {
    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }

    By avatarLogo = By.cssSelector(".avatar");
    public boolean getAvatar(){
      return driver.findElement(avatarLogo).isDisplayed();

    }


}
