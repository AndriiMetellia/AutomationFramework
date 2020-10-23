import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class NavigationBarTest extends Base{
  WebDriver driver;
  public static Logger logger = LogManager.getLogger(Base.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    logger.info("Driver initialized");
    driver.get(properties.getProperty("url"));
    logger.info("Navigated to home page");
  }

  @Test
  public void homePageNavigationTest() {

    HomePage homePage = new HomePage(driver);
    Assert.assertTrue(homePage.getNavigationBar().isDisplayed());
  }

  @AfterTest
  public void closureActivities() {
    driver.close();
  }

}
