package pages;

import org.openqa.selenium.By;
import utilities.Base;

public class AdvertisementPage extends Base {
    public static By modelYearLabel = By.xpath("//table[contains(@class,'course-info')]//td[text()='Model Year ']");
    public static By manufacturerLabel = By.xpath("//table[contains(@class,'course-info')]//td[text()='Manufacturer ']");
    public static By modelLabel = By.xpath("//table[contains(@class,'course-info')]//td[text()='Model ']");
    public static By TransmissionLabel = By.xpath("//table[contains(@class,'course-info')]//td[text()='Transmission ']");
    public static By conditionLabel = By.xpath("//table[contains(@class,'course-info')]//td[text()='Condition ']");
    public static By modelYearValue = By.xpath("//table[contains(@class,'course-info')]//td[text()='Model Year ']/following-sibling::td");
    public static By manufacturerValue = By.xpath("//table[contains(@class,'course-info')]//td[text()='Manufacturer ']/following-sibling::td");
    public static By modelValue = By.xpath("//table[contains(@class,'course-info')]//td[text()='Model ']/following-sibling::td");
    public static By TransmissionValue = By.xpath("//table[contains(@class,'course-info')]//td[text()='Transmission ']/following-sibling::td");
    public static By conditionValue = By.xpath("//table[contains(@class,'course-info')]//td[text()='Condition ']/following-sibling::td");
}
