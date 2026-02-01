package utils;

public class ConfigReader {

    public static String getBrowser() {
        return System.getProperty("browser", "chrome"); // default chrome
    }
}
