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


        //   String songName = "Episode 2";

        openUrl();
        login("demo@class.com", "te$t$tudent");
        //  choose a song
        clickSearchField();

        List<WebElement> allSongs = driver.findElements(By.cssSelector(" td.title"));
        for (int i = 0; i < 6; i++) {
            String playListName = generateRandomPlaylistName();
            System.out.println(allSongs.get(i).getText());
            String songName = allSongs.get(i).getText();
            System.out.println(songName);
            // search picked song in search field
            enterNameInSearchField(songName);
            clickAllViewButtn();
            List< WebElement> searchSongResult = driver.findElements(By.cssSelector(".search-results .song-item .title"));
            searchSongResult.get(i).click();
          //  findSongInResult();


// "addTo" button

            clickAddtoBtn();

            // new playlist input
            WebElement inputNewPlaylistName = driver
                    .findElement(By.cssSelector("#songResultsWrapper  [data-test='new-playlist-name']"));
            inputNewPlaylistName.click();
            inputNewPlaylistName.clear();
            inputNewPlaylistName.sendKeys(playListName);


            //    WebElement savePlaylistNameBtn = driver.findElement(By
            //           .cssSelector("section#songsWrapper .new-playlist > .form-new-playlist.form-save.form-simple > button[title='Save']"));
            //    savePlaylistNameBtn.click();


            new Actions(driver)
                    .keyDown(Keys.ENTER)
                    .perform();

            WebElement successBtn = driver.findElement(By.cssSelector(".success"));

            Assert.assertTrue(successBtn.isDisplayed());

            WebElement songAtPlist = driver.findElement(By.cssSelector("#playlistWrapper td.title"));
            String songNameAtPlaylist = songAtPlist.getText();
            //          System.out.println(songNameAtPlaylist + "  " + songName);
            Assert.assertEquals(songName, songNameAtPlaylist);
        }
    }

  

    private void findSongInResult() {
        List< WebElement> searchSongResult = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        searchSongResult.get(0).click();
    }

    private void clickAddtoBtn() {

        WebElement addToButtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButtn.click();
    }

    private void clickAllViewButtn() {
        WebElement viewAll = driver.findElement(By
                .xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }


}
