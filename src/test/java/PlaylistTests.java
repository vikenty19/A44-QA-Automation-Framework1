import PageModel.Basepage;
import PageModel.LoginPage;
import PageModel.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylist() {
        String playlist = generateRandomPlaylistName();
        Basepage basepage = new Basepage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        PlayListPage playListPage = new PlayListPage(getDriver());
        playListPage.clickPlusPlaylistBtn();
        playListPage.createNewPlaylistName(playlist);
        playListPage.isPlistNameInHeader(playlist);
        playListPage.clickToDeletePlist();
        playListPage.verifySuccessBanner();
        basepage.refreshPage();
        List<String> playlistNames = playListPage.getPlaylistNames();
        Assert.assertFalse(playlistNames.contains(playlist));


    }

}