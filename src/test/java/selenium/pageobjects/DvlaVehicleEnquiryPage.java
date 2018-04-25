package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Dvla vehicle enquiry page where the vehicle number to be enquired is entered
 */

public class DvlaVehicleEnquiryPage extends PageObject{

    @FindBy(id="Vrm")
    public WebElement vehicleNumberTextBox;

    public WebElement enter;

    public DvlaVehicleEnquiryPage(WebDriver driver){
        super(driver);


    }

    public VehicleConfirmPage enterVehicleNumberAndSubmit(String vehicleNo){
        vehicleNumberTextBox.sendKeys(vehicleNo);
        vehicleNumberTextBox.submit();
        return new VehicleConfirmPage(driver);
    }
}
