import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        login("demo@class.com", "te$t$tudent");
        searchForSong(text);
        clickViewAllBtn();
        clickFirstSearchResultSong();
        clickAddToPlaylistBtn();
        createNewPlaylistWhileAddingSong(playlistName);
        // assertions - success banner and song name in playlist
        Assert.assertTrue(isBannerDisplayed());
        Assert.assertEquals(text, getSongName());
    }

    @Test
    public void playSong() {
        login("demo@class.com", "te$t$tudent");
        WebElement buttonPlayOrResume = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();

        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
        WebElement equalizer = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizer.isDisplayed());
    }


}
