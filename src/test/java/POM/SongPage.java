package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SongPage extends BasePage{
    public SongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "#playlistWrapper .song-item .title" )
    WebElement songName;
    @FindBy(css ="[id='songResultsWrapper'] [placeholder='Playlist name']" )
    WebElement newPlaylistNameInput;
    public SongPage searchSongInSearchField(String text) {
       WebElement searchInput = waitUntilClickable(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        return this;
    }

   public String getSongText() {

        String songText = songName.getText();
        return songText;
    }


    public void createNewPlaylistWhileAddingSong(String playlistName) {
 //
        //       //WebElement newPlaylistNameInput = waitUntilVisible(By
      //          .cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

    }

    public String clickFirstSongInResult() {
        List<WebElement> songsInResults = driver
                .findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
        return songsInResults.get(0).getText();
    }

   public void clickAddToBtn() {
        WebElement addToButtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButtn.click();
    }

  public SongPage clickAllViewButtn() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@data-test='view-all-songs-btn']")));
        viewAll.click();
        return this;
    }

}