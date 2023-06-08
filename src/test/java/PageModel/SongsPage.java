package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SongsPage extends Basepage {
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[title='Play or resume']")
    WebElement buttonPlayOrResume;
    @FindBy(css = "[type='search']")
    WebElement searchInput;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy(css = "#playlistWrapper .song-item .title")
    WebElement songName;
    private By songResultLocator = By.cssSelector(".search-results .song-item .title");


    private By playBtnelement = By.cssSelector("[data-testid='pause-btn']");
    private By equalizerElement = By.cssSelector("[alt='Sound bars']");

    public void startPlaySong() {
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();
    }

    public boolean isPlayBtnDisplayed() {
        return driver.findElement(playBtnelement).isDisplayed();

    }

    public boolean isEqualizerBtnDisplayed() {
        return driver.findElement(equalizerElement).isDisplayed();

    }

    public void searchForSong(String text) {
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public void clickViewAllBtn() {
        viewAllBtn.click();
    }

    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(songResultLocator);
        songsInResults.get(0).click();
    }

    public String getSongName() {
        String songText = songName.getText();
        return songText;
    }
    public  String getSongText() {
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        return text;
    }
}
