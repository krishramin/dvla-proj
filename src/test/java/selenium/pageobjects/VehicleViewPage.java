package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleViewPage extends PageObject{

    @FindBy(css =".pub-c-button.pub-c-button--start" )
    private WebElement startButton;


    public VehicleViewPage(WebDriver driver) {
        super(driver);

    }

    public DvlaVehicleEnquiryPage clickStart(){
        startButton.click();
        return new DvlaVehicleEnquiryPage(driver);
    }
}
