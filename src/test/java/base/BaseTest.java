package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, Method method, ITestContext context){

        // LOGGING THE NAME OF THE TEST
        String testName = context.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // CREATING DRIVER
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().window().maximize();

        this.testSuiteName = context.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        log.info("Closing driver");
        try{
            driver.quit();
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}
