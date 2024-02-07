<<<<<<< Updated upstream
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
=======
import POM.LoginPage;
import POM.SongPage;
import com.opencsv.CSVReader;
>>>>>>> Stashed changes
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CSVDataProviderTest extends BaseTest {
 public static String count;
    @DataProvider(name = "getSongsData")
    // Method to read the data from .csv file and return it as array
    public Object[][] getData() throws Exception {
        // path to csv file that is located under resources folder
        Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/songs.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
        Object[][] array = null;
        for (int i = 0; i < records.size(); i++) {

            Object[] row = records.get(i);
            if (Objects.isNull(array)) {
                array = new Object[records.size()][row.length];
            }
            array[i][0] = row[0];
<<<<<<< Updated upstream
            // array[i][1] = row[1];
=======
            array[i][1] = row[1];
       //       array[i][2] = row[3];
>>>>>>> Stashed changes
        }
        return array;
    }

<<<<<<< Updated upstream
    @Test(dataProvider = "getSongsData")
    // test that uses data from csv file
    public void searchSongsTests(String song) {
        SongsPage songsPage = new SongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        songsPage.searchForSong(song);
        WebElement header = driver.findElement(By.cssSelector("strong"));
        String searchHeader = header.getText();
        Assert.assertEquals(song, searchHeader);
=======

    @Test(dataProvider = "getSongsData")
    public void searchForSong(String song, String i) {
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");
         songPage.clickSearchField();
        songPage.enterNameInSearchField(song);
        songPage.checkSearchResult();
        System.out.println( songPage.checkSearchResult() + " number " + i);
        Assert.assertEquals(songPage.checkSearchResult(),song);


>>>>>>> Stashed changes
    }
}