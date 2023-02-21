package pages;

import org.openqa.selenium.By;
import utilities.Base;

public class HomePage extends Base {
    public static By sectionHeader = By.xpath("//section[contains(@class,'home-section')]//h2[text()='Explore by main categories']");

    /**
     * navigateToHomePage method implemented to home page navigation
     * @throws Exception
     */
    public void navigateToHomePage() throws Exception {
        driver.navigate().to(baseUrl);
        waitUntilElementIsPresent(sectionHeader);
    }
}
