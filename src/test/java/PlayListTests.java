import POM.LoginPage;
import POM.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        String playlistName = generateRandomPlaylistBookName();
        System.out.println(playlistName);
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");

        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.enterNewPlaylistName(playlistName);
//
        //Assertions of playlist name
        playListPage.checkPlayListName(playlistName);
        playListPage.isSuccessBunnerDisplayed();


        //delete playlist
        playListPage.deleteCreatedPlaylist();

      //  Thread.sleep(1000);
        driver.navigate().refresh();
        List<WebElement> playlistTable = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        List<String> playListNames = new ArrayList<>();
        for (int i = 2; i < playlistTable.size(); i++) {  // i=2 to not include favorites,recently tabs
            String playlName = playlistTable.get(i).getText();
            playListNames.add(playlName);

            Assert.assertNotEquals(playListNames.get(i - 2), playlistName);//

        }
        System.out.println(playListNames);
        Assert.assertFalse(playListNames.contains(playlistName));
    }


    @Test
    public void renamePlayList() {
        String newPlayLIstName = "Mermaid";
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");

        playListPage.clearPlayLIstNameField();
        playListPage.enterPlaylistName(newPlayLIstName);
        System.out.println(newPlayLIstName);
        System.out.println(getPlaylistName());
        Assert.assertEquals(newPlayLIstName, getPlaylistName());
    }


    public String getPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistInputField.getText();
        return name;
    }
}
