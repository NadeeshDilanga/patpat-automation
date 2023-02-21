package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Base;

public class SearchTest extends Base {
    HomePage homePage;
    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }
    @BeforeClass
    public void initializeTest() {
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void homePageNavigationTest() {
        try {
            homePage.navigateToHomePage();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
