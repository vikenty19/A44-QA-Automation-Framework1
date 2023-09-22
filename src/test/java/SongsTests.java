import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
/*    String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        // login
        openUrl();
        login("demo@class.com", "te$t$tudent");
        // search for song
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        // click results view all button
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        // click first song
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
        // click Add To
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
        // create new playlist
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        // assertions - success banner and song name in playlist
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(text, songText); */


        String playListName = generateRandomPlaylistName();
        String songName = "Episode 2";

        openUrl();
        login("demo@class.com", "te$t$tudent");

        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        List<WebElement> searchSongResult = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        searchSongResult.get(0).click();

// "addTo" button
        WebElement addToButtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButtn.click();

        // new playlist input
        WebElement inputNewPlaylistName = driver
                .findElement(By.cssSelector("#songResultsWrapper  [data-test='new-playlist-name']"));
        inputNewPlaylistName.click();
        inputNewPlaylistName.clear();
        inputNewPlaylistName.sendKeys(playListName);
        WebElement savePlaylistNameBtn = driver.findElement(By
                .cssSelector("section#songsWrapper .new-playlist > .form-new-playlist.form-save.form-simple > button[title='Save']"));
    //    savePlaylistNameBtn.click();
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

        WebElement successBtn = driver.findElement(By.cssSelector(".success"));
        Thread.sleep(5000);
        Assert.assertTrue(successBtn.isDisplayed());

        WebElement songAtPlist = driver.findElement(By.cssSelector("#playlistWrapper td.title"));
        String songNameAtPlaylist = songAtPlist.getText();
        System.out.println(songNameAtPlaylist +"  "+ songName);
        Assert.assertEquals(songName,songNameAtPlaylist);
    }
}
