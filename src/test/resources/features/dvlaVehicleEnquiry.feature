Feature: Check Dvla Vehicle Journey

    Narrative Description: As a dvla user, I should enter vehicle registration number and be able to retrieve vehicle details such as colour , make so that I can decide on the vehicle

    Scenario: Test vehicle details on Dvla match with details from local file

    Given I retrieve the vehicle information from csv file
    When I enter the vehicle registration details into Dvla website
    Then the vehicle details displayed should match with the vehicle information in the supplied file


      Scenario Outline: Test dvla vehicle journey for various vehicle registration numbers

        Given I am on the Dvla View Vehicle Page
        When  I submit vehicle registration details with "<regNo>"
        Then  The "<make>" and "<colour>" of the vehicle should be displayed
        When  I confirm the vehicle on the confirmation page
        Then  The "<make>" and "<colour>" of the vehicle should be displayed on the vehicle details page

        Examples:
        |regNo|make|colour|
        |AY16 UAJ|DACIA|WHITE|
        |AY14 UAN|MAZDA|BLACK|
