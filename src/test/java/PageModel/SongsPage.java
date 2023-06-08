package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SongsPage extends Basepage {
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

@FindBy(css ="[title='Play or resume']")
        WebElement buttonPlayOrResume;
@FindBy(css ="[type='search']" )
WebElement searchInput;
@FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
WebElement viewAllBtn;

    private By playBtnelement = By.cssSelector("[data-testid='pause-btn']");
    private By equalizerElement = By.cssSelector("[alt='Sound bars']");
    public void startPlaySong() {
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
    public void searchForSong(String text) {
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
    public void clickViewAllBtn() {
        viewAllBtn.click();
    }
    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }
    public String getSongName(){
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }
}
