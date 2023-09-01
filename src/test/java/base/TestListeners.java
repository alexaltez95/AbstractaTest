package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    Logger log;
    String testSuiteName;
    String testName;
    String testMethodName;

    // onStart(): invoked after test class is instantiated and before execution of any testNG method.
    public void onStart(ITestContext contextStart) {
        this.testSuiteName = contextStart.getSuite().getName();
        this.testName = contextStart.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST " + testName + " FROM " + testSuiteName + " SUITE STARTED]");
    }

    // onTestStart(): invoked each time before a test will be invoked.
    public void onTestStart(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        log.info("[STARTING " + testMethodName + " TEST]");
    }

    // onTestSuccess(): invoked on the success of a test
    public void onTestSuccess(ITestResult result) {
        log.info("[TEST " + testMethodName + " PASSED]");
    }

    // onTestFailure(): invoked on the failure of a test
    public void onTestFailure(ITestResult result) {
        log.info("[TEST " + testMethodName + " FAILED]");
    }

    // onTestSkipped(): invoked when a test is skipped
    public void onTestSkipped(ITestResult result) {
        log.info("[TEST " + testMethodName + " SKIPPED]");
    }

    // onTestFailedButWithinSuccessPercentage(): invoked whenever a method fails but within the defined success percentage
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage"+ result.getName());

    }

    // onFinish(): invoked after all tests of a class are executed
    public void onFinish(ITestContext contextFinish) {
        log.info("[TEST " + testName + " FROM " + testSuiteName + " SUITE FINISHED]");

    }
}
