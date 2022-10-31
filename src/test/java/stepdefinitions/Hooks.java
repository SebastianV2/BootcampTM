package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    public static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-download-notification")
                .addArguments("disable-gpu")
                .addArguments("--ignore-certificate-error")
                .addArguments("--always-authorize-plugins")
                .addArguments("--disable-infobars")
                .addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
