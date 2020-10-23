package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

  WebDriver driver;
  public Properties properties = new Properties();

  public WebDriver initializeDriver() throws IOException {

    FileInputStream fileInputStream = new FileInputStream(
        System.getProperty("user.dir") + "/src/main/resources/data.properties"
    );
    properties.load(fileInputStream);
    String browserName = properties.getProperty("browser");

    if (browserName.equalsIgnoreCase("chrome")) {
      System.setProperty("webdriver.chrome.driver", "D://git/Studying/chromedriver.exe");
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setHeadless(true);
      driver = new ChromeDriver(chromeOptions);
    }
    else if (browserName.equalsIgnoreCase("firefox")) {
      //firefox code
      driver = new FirefoxDriver();
    }
    else if (browserName.equalsIgnoreCase("IE")) {
      //IE code
      driver = new EdgeDriver();
    }

    driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

    return driver;
  }

  public String getSrceenshotPath(String testCaseName, WebDriver driver) throws IOException {
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
    String destinationFile = System.getProperty("user.dir") + "//reports/" + testCaseName + ".png";
    FileUtils.copyFile(source, new File(destinationFile));
    return destinationFile;
  }
}
