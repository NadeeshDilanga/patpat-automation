package pages;

import org.openqa.selenium.By;
import utilities.Base;

public class VehiclePage extends Base {
    public static String vehiclePageUrl = "https://www.patpat.lk/vehicle";
    public static String carFilterUrl = "https://www.patpat.lk/vehicle/filter/car";
    public static By vehicleTab = By.xpath("(//span[@id='vehicle-menu']//small[text()='Vehicle'])[2]");
    public static By carTypeLink = By.xpath("//div[contains(@class,'vehicles')]//h5[text()='Car']/ancestor::a");
    public static By vehicleBreadCrumbLink = By.xpath("//nav[contains(@class,'breadcrumb-wrapper')]//li/a[text()='VEHICLE']");
    public static By manufacturerDropDown = By.xpath("//form[@id='search-filter']//select[@id='manufacturer']");
    public static By modelDropDown = By.xpath("//form[@id='search-filter']//select[@id='model']");
    public static By yearTextBox = By.xpath("//form[@id='search-filter']//input[@name='year']");
    public static By transmissionDropDown = By.xpath("//form[@id='search-filter']//select[@id='transmission']");
    public static By conditionDropDown = By.xpath("//form[@id='search-filter']//select[@id='condition']");
    public static By manufacturerItem_Toyota = By.xpath("//form[@id='search-filter']//select[@id='manufacturer']//option[@value='Toyota']");
    public static By modelItem_Allion = By.xpath("//form[@id='search-filter']//select[@id='model']//option[@value='Allion']");
    public static By transmissionItem_Auto = By.xpath("//form[@id='search-filter']//select[@id='transmission']//option[@value='auto']");
    public static By conditionItem_Used = By.xpath("//form[@id='search-filter']//select[@id='condition']//option[@value='used']");
    public static By filterButton = By.xpath("//form[@id='search-filter']//button[text()='Filter']");
    public static By searchResultItemLink = By.xpath("(//div[@id='result']//div[contains(@class,'result-item')]//a)[2]");
    public static By carsBreadCrumbLink = By.xpath("//nav[contains(@class,'breadcrumb-wrapper')]//li[3]/a[text()='CARS']");

    /**
     * selectDropdownItem method implemented to select a given item from a given dropdown
     * @param dropDown
     * @param listItem
     * @throws Exception
     */
    public void selectDropdownItem(By dropDown, By listItem) throws Exception {
        waitUntilElementIsPresent(dropDown);
        driver.findElement(dropDown).click();
        waitUntilElementIsPresent(listItem);
        driver.findElement(listItem).click();
    }
}
