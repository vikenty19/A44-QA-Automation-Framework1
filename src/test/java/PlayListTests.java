import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() {
        String playlistName = "Marazm";

        openUrl();
        login("demo@class.com", "te$t$tudent");
        WebElement plusBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".fa-plus-circle")));
        plusBtn.click();

        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));

        newPlaylist.click();

        //playlist name Enter

        WebElement enterField = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@name = 'name]")));
        enterField.sendKeys(playlistName);
        new Actions(driver).keyDown(Keys.ENTER).perform();


    }
}
