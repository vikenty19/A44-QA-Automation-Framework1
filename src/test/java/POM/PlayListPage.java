package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayListPage extends BasePage{
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clearPlayLIstNameField() {
        WebElement pListNameToDelete = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        System.out.println(pListNameToDelete.getText());
        new Actions(driver)
                .doubleClick(pListNameToDelete)
                .perform();

    }
    public void enterPlaylistName(String name) {
        WebElement playlistInputField = waitUntilClickable(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void plusBtnClick() {
        WebElement plusBtn = waitUntilVisible(By.cssSelector(".fa-plus-circle"));
        plusBtn.click();
    }

    public void goToPlayListField() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();

    }
}

