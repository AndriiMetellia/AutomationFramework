import com.aventstack.extentreports.ExtentReports;
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

public class HomePageTitleTest extends Base {
  WebDriver driver;
  ExtentReports extentReports;
  public static Logger logger = LogManager.getLogger(Base.class.getName());

  @BeforeTest
  public void initialize() throws IOException {


    driver = initializeDriver();
    logger.info("Driver initialized");
    driver.get(properties.getProperty("url"));
    logger.info("Navigated to home page");
  }


  @Test
  public void titleTest() {

    HomePage homePage = new HomePage(driver);
    String actualTitle = homePage.getTitle().getText();
    Assert.assertEquals(actualTitle, "FEATURED465 COURSES");
    logger.info("Successfully validated");
  }

  @AfterTest
  public void closureActivities() {
    driver.close();
  }
}
