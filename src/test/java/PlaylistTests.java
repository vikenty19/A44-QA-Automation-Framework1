import PageModel.LoginPage;
import PageModel.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylist() {
        String playlist = generateRandomPlaylistName();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        PlayListPage playListPage = new PlayListPage(driver);
        // CREATE PLAYLIST

        playListPage.clickPlusPlaylistBtn();


        // Add playlist name
        playListPage.createNewPlaylistName(playlist);


        // check playlist name in header
        isPlistNameInHeader(playlist);

        // delete playlist
        clickToDeletePlist();


        // verify banner
        playListPage.verifySuccessBanner();
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        // refresh page
        driver.navigate().refresh();
        // get all playlist elements
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
        // assert playlist was deleted
        Assert.assertFalse(playlistNames.contains(playlist));


    }


    public boolean isPlistNameInHeader(String playlist) {
        WebElement playlistHeader = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        return wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlist));

    }

    public void clickToDeletePlist() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistBtn.click();

    }
//    By successBanner = By.cssSelector(".success");


}