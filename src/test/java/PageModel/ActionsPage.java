package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ActionsPage extends Basepage {
    public ActionsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By equalizer = By.cssSelector("[data-testid='sound-bar-play']");

    @FindBy(css = ".playback")
    WebElement playBtn;

    @FindBy(css = ".song-item")
    WebElement firstSong;
    @FindBy(css = ".playlist:nth-child(4)")
    WebElement playlist;
    private By clickFooter = By.cssSelector("[data-testid='play-btn']");

    private By pauseExist = By.cssSelector("[data-testid='pause-btn']");
    private By allsongsLocator = By.cssSelector(".songs");
    private By doubleClick = By.cssSelector(".playlist:nth-child(3)");
    private By enterName = By.cssSelector("input[name='name']");
    private By getName = By.cssSelector(".playlist:nth-child(3)>a");
    private By getElements = By.cssSelector("#playlistWrapper .song-item");
    private By clickElement = By.cssSelector(".playlist:nth-child(4)");


    public boolean isEqualizerDisplayed() {
        return driver.findElement(equalizer).isDisplayed();
    }


    public void clickPlayBtn() {
        playBtn.click();
    }

    public void rightClickOnFirstSong() {
        //   WebElement firstSong = driver.findElement(rightClick);
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }

    public void clickFooterPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(clickFooter);
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return driver.findElement(pauseExist).isDisplayed();
    }


    public void goToAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allsongsLocator)).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(doubleClick));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(enterName);
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(getName));
        String name = playlistElement.getText();
        return name;
    }

    public List<WebElement> getWebElements() {
        List<WebElement> songs = driver.findElements(getElements);
        return songs;
    }

    public void playListClick() {
        playlist.click();
    }
}
