import PageModel.LoginPage;
import PageModel.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongsTests extends BaseTest {

    @Test
    public void checkVisibilityTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");

        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        System.out.println("WHERE IS TEXT?" + text);
        System.out.println("Is element invisible? === " + wait
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("title"))));

    }

    @Test
    public void addSongToPlaylist() {
        String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        searchForSong(text);
        clickViewAllBtn();
        clickFirstSearchResultSong();
        clickAddToPlaylistBtn();
        createNewPlaylistWhileAddingSong(playlistName);

        Assert.assertTrue(isBannerDisplayed());
        Assert.assertEquals(text, getSongName());
    }

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songPage = new SongsPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.startPlaySong();
        Assert.assertTrue(songPage.isPlayBtnDisplayed());
        Assert.assertTrue(songPage.isEqualizerBtnDisplayed());
    }


}