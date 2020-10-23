package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import java.io.IOException;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class StepDefinition extends Base{

  WebDriver driver;

  @Given("^Initialize the browser with chrome$")
  public void initialize_the_browser_with_chrome() throws IOException {
    driver = initializeDriver();
  }

  @Given("^Navigate to the \"([^\"]*)\" Site$")
  public void navigate_to_the_site(String url) {
    driver.get(url);
  }

  @Given("^Click on Login button$")
  public void click_on_login_button() {
    HomePage homePage = new HomePage(driver);
    if(homePage.getPopupSize().size() > 0) {
      homePage.getPopupNo().click();
    }
    homePage.login();
  }

  @When("^User enters (.+) and (.+) and logs in$")
  public void user_enters_something_and_something_and_logs_in(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.emailInput().sendKeys(username);
    loginPage.passwordInput().sendKeys(password);
    loginPage.logInButton().click();
  }

  @Then("^Verify that user is successfully logged in$")
  public void verify_that_user_is_successfully_logged_in() {
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    System.out.println("!@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
  }

  @And("^Close browser$")
  public void close_browser() {
    driver.quit();
  }
}
