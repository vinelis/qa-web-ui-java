package seleniumtestng.base;

import org.openqa.selenium.WebDriver;

public final class DriverHolder {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void set(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver get() {
        return driver.get();
    }

    public static void remove() {
        driver.remove();
    }

    private DriverHolder() {}
}
