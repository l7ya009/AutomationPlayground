package listener.testNG;

import Utilities.ScreenShotManager;
import driverfactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class TestNGListener implements ITestListener, IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("************* Welcome To Selenium FrameWork**************");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Printing Reports");
        System.out.println("************** End Of Execution ******************");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("******** Starting Test" + result.getName() + " **********");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("****** Success Of Test " + result.getName() + " *********");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        System.out.println("Taking screen shot.....");

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }

                if (field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
        } catch (IllegalAccessException exception) {
            System.out.println("Unable to get field, Field Should be public");
        }

        assert driver != null;
        ScreenShotManager.captureScreenshot(driver.get(), result.getName());


        System.out.println("******* Failure of Test: " + result.getName() + " ***************");
    }


}
