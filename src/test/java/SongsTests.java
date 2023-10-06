import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String text = "Episode 2";
        String playlistName = generateRandomPlaylistName();
        LoginPage loginPage = new LoginPage(driver);
        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        // search for song
        WebElement searchInput = waitUntilClickable(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        Thread.sleep(3000);
        // click results view all button

        clickAllViewButtn();
       

        // click first song
        Thread.sleep(3000);
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));

        songsInResults.get(0).click();
        System.out.println(songsInResults.get(0).getText());


        // click Add To
        clickAddToBtn();


        // create new playlist
        WebElement newPlaylistNameInput = waitUntilVisible(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        // assertions - success banner and song name in playlist
        WebElement successBanner = waitUntilVisible(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(text, songText);

   /*     String playListName = generateRandomPlaylistName();
        String songTitle = "Episode 2";
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        //  choose a song
        clickSearchField();
        searchForSong(songTitle);
// click results view all button
        clickAllViewButtn();

        List<WebElement> songsInResult = driver.findElements(By.cssSelector(".search-results .song-item .title"));



        songsInResult.get(0).click();

        String songName = songsInResult.get(0).getText();
        System.out.println(songName);

        // search picked song in search field



  /*          findSongInResult();


            // "addTo" button

            clickAddtoBtn();

            // new playlist input
            createNewPlaylistByAddingSong(playListName);


            //    WebElement savePlaylistNameBtn = driver.findElement(By
            //           .cssSelector("section#songsWrapper .new-playlist > .form-new-playlist.form-save.form-simple > button[title='Save']"));
            //    savePlaylistNameBtn.click();


            isSuccessBtnDisplayed();


            WebElement songAtPlist = driver.findElement(By.cssSelector("#playlistWrapper td.title"));
            String songNameAtPlaylist = songAtPlist.getText();
            //          System.out.println(songNameAtPlaylist + "  " + songName);
            Assert.assertEquals(songTitle, songNameAtPlaylist);*/

 /*   }


    private void isSuccessBtnDisplayed() {
        WebElement successBtn = driver.findElement(By.cssSelector(".success"));

        Assert.assertTrue(successBtn.isDisplayed());
    }

    private void createNewPlaylistByAddingSong(String playListName) {
        WebElement inputNewPlaylistName = driver
                .findElement(By.cssSelector("#songResultsWrapper  [data-test='new-playlist-name']"));
        inputNewPlaylistName.click();
        inputNewPlaylistName.clear();
        inputNewPlaylistName.sendKeys(playListName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }


    private void findSongInResult() {
        List<WebElement> searchSongResult = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        searchSongResult.get(0).click();
    }




    }*/

    }

    private void clickAddToBtn() {

        WebElement addToButtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButtn.click();
    }

    private void clickAllViewButtn() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@data-test='view-all-songs-btn']")));
        viewAll.click();
    }
}