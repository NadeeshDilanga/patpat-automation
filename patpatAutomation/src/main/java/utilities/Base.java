package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public static Property testDataProperty = new Property();
    public static final String testDataFilePath = "src/main/resources/testdata.properties";
    public static String baseUrl;
    public static WebDriverWait wait;
    public static int MAX_WAIT;

    /**
     * Automation Framework Initialization
     * @throws Exception
     */
    @BeforeClass
    public void initializeFramework() throws Exception {
        initializeTestData();
        initializeChromeDriver();
        initializeWait();
    }

    /**
     * Chrome Driver Initialization
     * @throws Exception
     */
    public void initializeChromeDriver() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * initializeTestData method implemented to prepare test data
     * @throws Exception
     */
    public void initializeTestData() throws Exception {
        testDataProperty.initializeProperty(testDataFilePath);
        baseUrl = testDataProperty.propertiesFile.getProperty("baseUrl");
        MAX_WAIT = Integer.parseInt(testDataProperty.propertiesFile.getProperty("max_wait_inSeconds"));
    }

    /**
     * wait Parameter Initialization
     * @throws Exception
     */
    public void initializeWait() throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
    }

    /**
     * waitUntilElementIsPresent method implemented to check if an element is present until the given timeout
     * @param locator
     * @throws Exception
     */
    public void waitUntilElementIsPresent(By locator) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
