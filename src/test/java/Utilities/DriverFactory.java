package Utilities;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public DriverFactory() {
    }

    public static WebDriver Open(String browserType) {
        if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C://Drivers/geckodriver.exe");
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.IE.driver", "C://Drivers/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
