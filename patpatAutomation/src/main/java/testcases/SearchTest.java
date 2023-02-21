package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdvertisementPage;
import pages.HomePage;
import pages.VehiclePage;
import utilities.Base;

public class SearchTest extends Base {
    HomePage homePage;
    VehiclePage vehiclePage;
    SoftAssert softAssert;
    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }
    @BeforeClass
    public void initializeTest() {
        homePage = new HomePage();
        vehiclePage = new VehiclePage();
    }

    @Test(priority = 1)
    public void homePageNavigationTest() {
        try {
            homePage.navigateToHomePage();
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, baseUrl, "Home page navigation test is failed.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Assert.fail("Home page navigation test is failed.\n\n"+ex.getMessage());
        }
    }

    @Test(priority = 2, dependsOnMethods = {"homePageNavigationTest"})
    public void vehiclesSectionNavigationTest() {
        try {
            waitUntilElementIsClickable(HomePage.vehiclesLink);
            driver.findElement(HomePage.vehiclesLink).click();
            waitUntilElementIsPresent(VehiclePage.vehicleTab);
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, VehiclePage.vehiclePageUrl, "Vehicles section navigation test is failed.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Assert.fail("Vehicles section navigation test is failed.\n\n"+ex.getMessage());
        }
    }

    @Test(priority = 3, dependsOnMethods = {"vehiclesSectionNavigationTest"})
    public void selectCarTypeTest() {
        try {
            waitUntilElementIsClickable(VehiclePage.carTypeLink);
            driver.findElement(VehiclePage.carTypeLink).click();
            waitUntilElementIsPresent(VehiclePage.vehicleBreadCrumbLink);
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, VehiclePage.carFilterUrl, "Select car type test is failed.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Assert.fail("Select car type test is failed.\n\n"+ex.getMessage());
        }
    }

    @Test(priority = 4, dependsOnMethods = {"selectCarTypeTest"})
    public void searchByFiltersTest() {
        try {
            softAssert = new SoftAssert();
            String manufacturer = "Toyota1";
            String model = "Allion1";
            String year = "20141";
            String transmission = "Automatic1";
            String condition = "Used1";

            // add manufacturer filter
            scrollToElement(VehiclePage.manufacturerDropDown);
            actions.moveToElement(driver.findElement(VehiclePage.manufacturerItem_Toyota));
            vehiclePage.selectDropdownItem(VehiclePage.manufacturerDropDown, VehiclePage.manufacturerItem_Toyota);

            // add model filter
            scrollToElement(VehiclePage.modelDropDown);
            vehiclePage.selectDropdownItem(VehiclePage.modelDropDown, VehiclePage.modelItem_Allion);

            // add year filter
            waitUntilElementIsPresent(VehiclePage.yearTextBox);
            WebElement yearTextBoxElement = driver.findElement(VehiclePage.yearTextBox);
            yearTextBoxElement.clear();
            yearTextBoxElement.sendKeys(year);

            // add transmission filter
            scrollToElement(VehiclePage.transmissionDropDown);
            vehiclePage.selectDropdownItem(VehiclePage.transmissionDropDown, VehiclePage.transmissionItem_Auto);

            // add condition filter
            scrollToElement(VehiclePage.conditionDropDown);
            vehiclePage.selectDropdownItem(VehiclePage.conditionDropDown, VehiclePage.conditionItem_Used);

            // click filter button
            scrollToElement(VehiclePage.filterButton);
            driver.findElement(VehiclePage.filterButton).click();
            waitUntilElementIsPresent(VehiclePage.searchResultItemLink);
            scrollToElement(VehiclePage.searchResultItemLink);

            // click search result item
            driver.findElement(VehiclePage.searchResultItemLink).click();
            waitUntilElementIsPresent(VehiclePage.carsBreadCrumbLink);

            // check labels and values
            scrollToElement(AdvertisementPage.modelYearLabel);
            softAssert.assertTrue(driver.findElement(AdvertisementPage.modelYearLabel).isDisplayed(), "'Model Year' label is not displayed.");
            softAssert.assertEquals(getElementText(AdvertisementPage.modelYearValue), year, "'Model Year' value is not matched.");

            scrollToElement(AdvertisementPage.manufacturerLabel);
            softAssert.assertTrue(driver.findElement(AdvertisementPage.manufacturerLabel).isDisplayed(), "'Manufacturer' label is not displayed.");
            softAssert.assertEquals(getElementText(AdvertisementPage.manufacturerValue), manufacturer, "'Manufacturer' value is not matched.");

            scrollToElement(AdvertisementPage.modelLabel);
            softAssert.assertTrue(driver.findElement(AdvertisementPage.modelLabel).isDisplayed(), "'Model' label is not displayed.");
            softAssert.assertEquals(getElementText(AdvertisementPage.modelValue), model, "'Model' value is not matched.");

            scrollToElement(AdvertisementPage.TransmissionLabel);
            softAssert.assertTrue(driver.findElement(AdvertisementPage.TransmissionLabel).isDisplayed(), "'Transmission' label is not displayed.");
            softAssert.assertEquals(getElementText(AdvertisementPage.TransmissionValue), transmission, "'Transmission' value is not matched.");

            scrollToElement(AdvertisementPage.conditionLabel);
            softAssert.assertTrue(driver.findElement(AdvertisementPage.conditionLabel).isDisplayed(), "'Condition' label is not displayed.");
            softAssert.assertEquals(getElementText(AdvertisementPage.conditionValue), condition, "'Condition' value is not matched.");

            softAssert.assertAll();
        } catch(Exception ex) {
            ex.printStackTrace();
            Assert.fail("Search by filters test is failed.\n\n"+ex.getMessage());
        }
    }
}
