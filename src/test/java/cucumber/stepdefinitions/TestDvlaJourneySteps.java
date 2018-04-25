package cucumber.stepdefinitions;

import com.service.directory.scanner.FileInfo;
import com.service.directory.scanner.impl.DirectoryScannerService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pageobjects.*;
import util.CSVDataReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestDvlaJourneySteps extends BaseTestClass {

    private DirectoryScannerService directoryScannerService;
    private final String configDir = "src/test/resources/";
    CSVDataReader csvDataReader = new CSVDataReader();
    List<String> vehicleData;
    List<String> actualVehicleResults = new ArrayList<String>();
    VehicleViewPage homePage;
    DvlaVehicleEnquiryPage enquiryPage;
    VehicleConfirmPage confirmPage;
    VehicleDetailsPage vehicleDetailsPage;

    @Before
    public static void setUp(){
        //Set the system properties to point to chrome and gecko drivers
        System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/gecko/geckodriver");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        //set Implicit timeouts for the webdriver as default
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @cucumber.api.java.After
    public void cleanUp() {
        // Screenshot of output in vehicle details page

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/screenshot" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Given("^I retrieve the vehicle information from csv file$")
    public void i_retrieve_the_vehicle_information_from_csv_file()  {
        //get Vehicle Details file from the directory
        directoryScannerService = new DirectoryScannerService();
        List<FileInfo> csvFiles  = directoryScannerService.getFilesInfoOfDirectory(configDir,"csv");

        //Read the csv file and get the vehicle details
        String filePath = configDir+csvFiles.get(0).getFileName();
        vehicleData = csvDataReader.getCsvData(filePath);;
    }


    @When("^I enter the vehicle registration details into Dvla website$")
    public void enter_Reg_details(){

        //Check each vehicle in the given CSV File
        vehicleData.forEach(vehicle->{
            String[] vehicleInfoFromFile = vehicle.split(",");

             homePage = new VehicleViewPage(driver);

             //Navigate to DVLA home page and start the process
             enquiryPage = goToDvlaHomePageAndStart(homePage);

            // Enter the Vehicle Details and submit to land on results page
            String[] confirmPageResults = submitVehicleNoAndRetrieveDetails(vehicleInfoFromFile[0]);
            actualVehicleResults.add(confirmPageResults[0]+","+confirmPageResults[1]+","+confirmPageResults[2]);
            vehicleDetailsPage = confirmPage.confirmVehicle();
            assertEquals(vehicleDetailsPage.getMake(),vehicleInfoFromFile[1]);
            assertEquals(vehicleDetailsPage.getColour(),vehicleInfoFromFile[2]);

        });
    }


    @Given("^I am on the Dvla View Vehicle Page$")
    public void i_am_on_the_Dvla_HomePage() {

        homePage = new VehicleViewPage(driver);
        //Navigate to DVLA home page and start the process
        enquiryPage = goToDvlaHomePageAndStart(homePage);
    }

    @When("^I submit vehicle registration details with \"([^\"]*)\"$")
    public void i_submit_vehicle_registration_details_with_AY_UAJ(String regNo)  {
        String[] actualResults = submitVehicleNoAndRetrieveDetails(regNo);
        actualVehicleResults.add(actualResults[0]+","+actualResults[1]+","+actualResults[2]);
    }

    @When("^I confirm the vehicle on the confirmation page$")
    public void i_confirm_the_vehicle_on_the_confirmation_page()  {
        vehicleDetailsPage = confirmPage.confirmVehicle();
    }


    @Then("^the vehicle details displayed should match with the vehicle information in the supplied file$")
    public void the_result_should_match_with_the_vehicle_information_in_the_supplied_csv_file()  {
        assertEquals(vehicleData,actualVehicleResults);

    }



    @Then("^The \"([^\"]*)\" and \"([^\"]*)\" of the vehicle should be displayed$")
    public void the_make_and_colour_of_the_vehicle_should_be_displayed(String make,String colour)  {
       assertEquals(confirmPage.vehicleDetails.get(0).getText(),make);
        assertEquals(confirmPage.vehicleDetails.get(1).getText(),colour);


    }

    @Then("^The \"([^\"]*)\" and \"([^\"]*)\" of the vehicle should be displayed on the vehicle details page$")
    public void the_make_and_colour_of_the_vehicle_should_be_displayed_On_VehicleDetailsPage(String make,String colour)  {
        assertEquals(vehicleDetailsPage.getMake(),make);
        assertEquals(vehicleDetailsPage.getColour(),colour);


    }

    private DvlaVehicleEnquiryPage goToDvlaHomePageAndStart(VehicleViewPage homePage){

        //Navigate to DVLA home page
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
        //Click the Start button in the home page to land on Enquiry page
         homePage.clickStart();
        return new DvlaVehicleEnquiryPage(driver);
    }

    private String[] submitVehicleNoAndRetrieveDetails(String regnNo){
        confirmPage = enquiryPage.enterVehicleNumberAndSubmit(regnNo);
        return confirmPage.getVehicleDetails();
    }

}
