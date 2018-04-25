package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleDetailsPage extends PageObject {


    public VehicleDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='content']/div[4]/div/ul/li[1]/span[2]/strong")
    private WebElement make;

    @FindBy(xpath = ".//*[@id='content']/div[4]/div/ul/li[9]/span[2]/strong")
    private WebElement colour;

    public String getMake() {
        return make.getText();
    }

    public String getColour() {
        return colour.getText();
    }

}
