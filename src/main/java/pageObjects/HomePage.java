package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

  public WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  By loginButton = By.cssSelector("a[href*='sign_in']");
  By title = By.cssSelector(".text-center>h2");
  By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a");
  By popupNo = By.xpath("//button[text()='NO THANKS']");


  public LoginPage login() {
    driver.findElement(loginButton).click();
    LoginPage loginPage = new LoginPage(driver);
    return loginPage;
  }

  public WebElement getTitle() {
    return driver.findElement(title);
  }

  public WebElement getNavigationBar() {
    return driver.findElement(navigationBar);
  }

  public List<WebElement> getPopupSize() {
    return driver.findElements(popupNo);
  }

  public WebElement getPopupNo() {
    return driver.findElement(popupNo);
  }
}
