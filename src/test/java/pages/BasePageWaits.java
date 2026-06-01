package pages;

import org.openqa.selenium.WebDriver;

import utils.WaitUtil;

public class BasePageWaits {

    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePageWaits(WebDriver driver) {

        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }
}