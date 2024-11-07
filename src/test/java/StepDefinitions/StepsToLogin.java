package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsToLogin {
    @Given("User opens application URL")
    public void userOpensApplicationURL() {
    }

    @And("navigates om Login page")
    public void navigatesOmLoginPage() {
    }

    @When("User enters valid email {string}")
    public void userEntersValidEmail(String arg0) {
    }

    @And("Enters valid password {string}")
    public void entersValidPassword(String arg0) {
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
    }

    @Then("User login successfully")
    public void userLoginSuccessfully() {
    }

    @Then("User should get a warning message")
    public void userShouldGetAWarningMessage() {
    }

    @And("Enters invalid password {string}")
    public void entersInvalidPassword(String arg0) {
    }

    @When("User enters invalid email {string}")
    public void userEntersInvalidEmail(String arg0) {
    }

    @When("User doesn't enter any credentials")
    public void userDoesnTEnterAnyCredentials() {
    }
}
