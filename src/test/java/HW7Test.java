import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW7Test {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HW7Test.class);

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        logger.info("ChromeDriver configured");
    }

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        logger.info(driver.toString() + " started");
    }

    @After
    public void afterTest() {
        if (driver != null) {
            logger.info(driver.toString() + " is going to quit");
            driver.quit();
            logger.info(driver.toString() + " quited");
        }
        else {
            logger.warn("Web driver to quit not found");
        }
    }

    @Test
    public void openOtusSite() {
        driver.get("https://otus.ru");
        logger.info("OTUS site is opened");
    }
}
