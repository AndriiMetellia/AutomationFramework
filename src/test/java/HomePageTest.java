import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
  WebDriver driver;

  public static Logger logger = LogManager.getLogger(Base.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    logger.info("Driver initialized");


  }

  @Test(dataProvider = "getData")
  public void pageNavigation(String username, String password, String text) throws InterruptedException {
    driver.get(properties.getProperty("url"));
    logger.info("Navigated to home page");

    HomePage homePage = new HomePage(driver);
//    homePage.login().click();
//    LoginPage loginPage = new LoginPage(driver);
    LoginPage loginPage = homePage.login();
    loginPage.emailInput().sendKeys(username);
    loginPage.passwordInput().sendKeys(password);
    loginPage.logInButton().click();
    System.out.println(text);


  }

  @DataProvider
  public Object[][] getData() {
    Object[][] data = new Object[2][3];
    data[0][0] = "nonRestricted@some.com";
    data[0][1] = "123456";
    data[0][2] = "Non Restricted User";

    data[1][0] = "restricted@some.com";
    data[1][1] = "654321";
    data[1][2] = "Restricted User";

    return data;
  }

  @AfterTest
  public void closureActivities() {
    driver.close();
  }
}
