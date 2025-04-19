package Railway;

import Common.Constant.Constant;
import PageObjects.GeneralPage;
import PageObjects.HomePage;
import static Common.Common.Utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public GeneralPage basePage;
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constant.RAILWAY_URL);
        basePage = new GeneralPage();
        basePage.setUpDriver(driver);
        setUpDriverUtilities();
        homePage = new HomePage();
    }


    @AfterClass
    public void closeDriver() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
