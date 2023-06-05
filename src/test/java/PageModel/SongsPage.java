package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends Basepage {
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   // @FindBy(css ="[title='Play or resume']" )
    //      WebElement playPauseBtn;
    By playPauseBtn =By.cssSelector("[title='Play or resume']");

    By playBtnelement = By.cssSelector("[data-testid='pause-btn']");
    By equalizerElement = By.cssSelector("[alt='Sound bars']");
    public void startPlaySong() {
        WebElement buttonPlayOrResume = driver.findElement(playPauseBtn);
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();
    }

    public boolean isPlayBtnDisplayed() {
        return driver.findElement(playBtnelement).isDisplayed();

    }

    public boolean isEqualizerBtnDisplayed() {
        return driver.findElement(equalizerElement).isDisplayed();

    }
}
