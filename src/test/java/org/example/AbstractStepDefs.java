package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public abstract class AbstractStepDefs {
    private static final int WAIT_TIME = 5;
    private static final WebDriver driver;
    protected static HomePage homePage;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Remove headless argument to make the browser visible
        // Use incognito ( Other sites with recaptcha problems )
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
        homePage = new HomePage(driver);
    }
}
