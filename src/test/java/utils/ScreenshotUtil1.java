package utils;

import factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil1 {

    public static String takeScreenshot(String scenarioName) {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        byte[] source = ts.getScreenshotAs(OutputType.BYTES);

        String path = "target/screenshots/" + scenarioName + ".png";
        File destination = new File(path);

        try {
            Files.createDirectories(destination.getParentFile().toPath());
            Files.write(destination.toPath(), source);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
