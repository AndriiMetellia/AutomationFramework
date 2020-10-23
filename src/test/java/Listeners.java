import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

public class Listeners extends Base implements ITestListener {
  ExtentReports extentReports = ExtentReporterNG.getReportObject();
  ExtentTest extentTest;
  ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();


  @Override
  public void onTestStart(ITestResult result) {
    extentTest = extentReports.createTest(result.getMethod().getMethodName());
    threadLocal.set(extentTest);
  }


  @Override
  public void onTestFailure(ITestResult result) {
    threadLocal.get().fail(result.getThrowable());
    WebDriver driver = null;
    String testCaseName = result.getMethod().getMethodName();

//    try {
//      driver = (WebDriver) result.getTestClass()
//          .getRealClass()
//          .getDeclaredField("driver")
//          .get(result.getInstance());
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

    try {
      threadLocal.get().
          addScreenCaptureFromPath(
              getSrceenshotPath(testCaseName, driver),result.getMethod().getMethodName()
          );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    threadLocal.get().log(Status.PASS, "Test successfully passed, Yo!");

  }


  @Override
  public void onFinish(ITestContext context) {
    extentReports.flush();
  }


}
