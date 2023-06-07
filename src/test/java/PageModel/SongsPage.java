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
    public void searchForSong(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
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
