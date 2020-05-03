import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.manage().window().maximize();
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
    public void Task() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        By selector;

        driver.get("https://market.yandex.ru/");

        selector = By.xpath("//div[contains(@class,'popup2__content')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(selector)));

        selector = By.xpath("//a[contains(@href,'catalog--elektronika')]");
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();

        selector = By.xpath("//a[contains(@href,'catalog--mobilnye-telefony')]");
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }
}
