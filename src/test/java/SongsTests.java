import POM.BasePage;
import POM.LoginPage;
import POM.SongPage;
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
        loginPage.login("demo@class.com", "te$t$tudent");
        SongPage songPage = new SongPage(driver);
        BasePage basePage = new BasePage(driver);
        songPage.searchSongInSearchField(text)
                 .clickAllViewButtn();
        Thread.sleep(500);
        songPage.clickFirstSongInResult();
        System.out.println(songPage.clickFirstSongInResult());
        songPage.clickAddToBtn();
        songPage.createNewPlaylistWhileAddingSong(playlistName);
        basePage.isSuccessBannerDisplayed();
        Assert.assertEquals(text, songPage.getSongText());
        System.out.println(text + " " + songPage.getSongText());


    }

}