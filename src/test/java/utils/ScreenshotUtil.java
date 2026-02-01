package utils;

import factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static byte[] takeScreenshotAsBytes() {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static String takeScreenshotAndSave(String scenarioName) {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);

        String path = "target/screenshots/" + scenarioName.replaceAll(" ", "_") + ".png";
        File file = new File(path);
        try {
            Files.createDirectories(file.getParentFile().toPath());
            Files.write(file.toPath(), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
