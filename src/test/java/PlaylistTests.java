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
        Basepage basepage = new Basepage(driver);
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
       basepage.refreshPage();
        // get all playlist elements
        allPlaylistNames();


        // assert playlist was deleted
      // Assert.assertFalse(playlistNames.contains(playlist));


    }
 /*   class MyObject {
        private String theValue;

        public String getValue() {
            return theValue;
        }
        public void setValue(String newValue) {
            this.theValue = newValue;
        }

    }

 //   List<MyObject> listOfMyObjects = new ArrayList<MyObject>();

// populate the list here...

 //   assertThat(listOfMyObjects).extracting("value").containsAnElementWith("some regular expressions here...");*/


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
    public List allPlaylistNames() {
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
         return playlistNames;
    }


}