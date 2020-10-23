package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  private By email = By.id("user_email");
  private By password = By.id("user_password");
  private By logIn = By.xpath("//input[@value='Log In']");

  public WebElement emailInput() {
    return driver.findElement(email);
  }

  public WebElement passwordInput() {
    return driver.findElement(password);
  }

  public WebElement logInButton() {
    return driver.findElement(logIn);
  }
}
