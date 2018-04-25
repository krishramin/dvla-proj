package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleConfirmPage extends PageObject{

    @FindBy(css=".reg-mark")
    public WebElement regNo;

    @FindBy(id="Correct_True")
    private WebElement trueRadioButton;

    @FindBy(css=".button[type='submit']")
    private WebElement continueButton;

    @FindBy(css=".list-summary-item>span>strong")
    public List<WebElement> vehicleDetails;

    public VehicleConfirmPage(WebDriver driver) {
        super(driver);
    }

    public String[] getVehicleDetails(){
        String vehicleRegNo = regNo.getText();
        String vehicleMake = vehicleDetails.get(0).getText();
        String vehicleColor = vehicleDetails.get(1).getText();

//        List<String> vehicleInfo = new ArrayList<String>();
//        vehicleInfo.add(vehicleRegNo);
//        vehicleInfo.add(vehicleMake);
//        vehicleInfo.add(vehicleColor);

        String[] vehicleInfoArr = {vehicleRegNo,vehicleMake,vehicleColor};

        return vehicleInfoArr;
    }

    public VehicleDetailsPage confirmVehicle(){
        trueRadioButton.click();
        continueButton.click();
        return new VehicleDetailsPage(driver);

    }

}
