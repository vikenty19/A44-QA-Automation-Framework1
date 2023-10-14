import POM.BasePage;
import POM.LoginPage;
import POM.ProfilePage;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName()  {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");
        BasePage basePage = new BasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfile();

        // type password
        profilePage.enterPasswordInProfile();

        String name = generateRandomName();
        System.out.println(name);
        // type new name
        profilePage.enterNewNameInProfile(name);

        // type email
        profilePage.enterEmailInProfilePage();

        // click save
        profilePage.clickSaveInProfile();

        // assert profile name is new
        basePage.isSuccessBannerDisplayed();
        driver.navigate().refresh();//разобраться!
         Assert.assertEquals( basePage.getNewProfileName(),name);
    }
    @Test (dataProvider = "getBackGroundLocator")

    public void profileThemeTest(String colorLocator) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com","te$t$tudent");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfile();
        Thread.sleep(3000);
     //   WebElement colorPane = driver.findElement(By.tagName("li:nth-of-type(1) > .theme > .name"));


        List<WebElement> backgrounds =driver.findElements(By.cssSelector(".theme .name"));
        List<String> backColors = new ArrayList<>();
        for (int i = 0; i < backgrounds.size(); i++) {


            new Actions(driver)
                    .moveToElement(backgrounds.get(i))
                    .perform();
            String color = backgrounds.get(i).getText();

            backColors.add(color);
        }

            System.out.println(backColors+" "+ backColors.size());


        WebElement colorPane = driver.findElement(By.cssSelector(colorLocator));
        new Actions(driver)
                .click(colorPane)
                .perform();
        String colour = colorPane.getText();
           System.out.println(colour +"  "+ backColors.get(1));
          Assert.assertEquals(backColors.get(1),colorPane.getText());




    /*    WebElement footer = driver.findElement(By.cssSelector("li:nth-of-type(1) > .theme > .name"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer, 0, -50);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin,0, 200)
                .perform();
        System.out.println(footer.getText());
        Thread.sleep(5000);*/
    }
    @DataProvider(name = "getBackGroundLocator")
    // Method to read the data from .csv file and return it as array
    public Object[][] getData() throws Exception {
        // path to csv file that is located under resources folder
        Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/ColourLocators.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
        Object[][] array = null;
        for (int i = 0; i < records.size(); i++) {

            Object[] row = records.get(i);
            if (Objects.isNull(array)) {
                array = new Object[records.size()][row.length];
            }
            array[i][0] = row[0];
           //       array[i][1] = row[1];
            //       array[i][2] = row[3];
        }
        return array;


    }
}
//li:nth-of-type(2) > .theme > .name