package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenShotManager {

    static String screenShotDirectoryPath= "./ScreenShots";

//    File screenShotDirectory = new File(screenShotDirectoryPath);

    public static void  captureScreenshot(WebDriver driver, String screenShotName) {
        Path destination = Paths.get(screenShotDirectoryPath, screenShotName + ".jpg" );
        byte[] byteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(destination, byteArray, StandardOpenOption.CREATE);
        }
        catch (IOException e) {
            System.out.println("Unable to save screen shot");
        }
    }

}
