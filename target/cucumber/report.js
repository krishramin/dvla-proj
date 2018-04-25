$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/dvlaVehicleEnquiry.feature");
formatter.feature({
  "line": 1,
  "name": "Check Dvla Vehicle Journey",
  "description": "\n  Narrative Description: As a dvla user, I should enter vehicle registration number and be able to retrieve vehicle details such as colour , make so that I can decide on the vehicle",
  "id": "check-dvla-vehicle-journey",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3323309770,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Test vehicle details on Dvla match with details from local file",
  "description": "",
  "id": "check-dvla-vehicle-journey;test-vehicle-details-on-dvla-match-with-details-from-local-file",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I retrieve the vehicle information from csv file",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter the vehicle registration details into Dvla website",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the vehicle details displayed should match with the vehicle information in the supplied file",
  "keyword": "Then "
});
formatter.match({
  "location": "TestDvlaJourneySteps.i_retrieve_the_vehicle_information_from_csv_file()"
});
formatter.result({
  "duration": 187963927,
  "status": "passed"
});
formatter.match({
  "location": "TestDvlaJourneySteps.enter_Reg_details()"
});
formatter.result({
  "duration": 5624830183,
  "status": "passed"
});
formatter.match({
  "location": "TestDvlaJourneySteps.the_result_should_match_with_the_vehicle_information_in_the_supplied_csv_file()"
});
formatter.result({
  "duration": 43244,
  "status": "passed"
});
formatter.after({
  "duration": 782846233,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "Test dvla vehicle journey for various vehicle registration numbers",
  "description": "",
  "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "I am on the Dvla View Vehicle Page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I submit vehicle registration details with \"\u003cregNo\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The \"\u003cmake\u003e\" and \"\u003ccolour\u003e\" of the vehicle should be displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I confirm the vehicle on the confirmation page",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "The \"\u003cmake\u003e\" and \"\u003ccolour\u003e\" of the vehicle should be displayed on the vehicle details page",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;",
  "rows": [
    {
      "cells": [
        "regNo",
        "make",
        "colour"
      ],
      "line": 21,
      "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;;1"
    },
    {
      "cells": [
        "AY16 UAJ",
        "DACIA",
        "WHITE"
      ],
      "line": 22,
      "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;;2"
    },
    {
      "cells": [
        "AY14 UAN",
        "MAZDA",
        "BLACK"
      ],
      "line": 23,
      "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2753592221,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Test dvla vehicle journey for various vehicle registration numbers",
  "description": "",
  "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "I am on the Dvla View Vehicle Page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I submit vehicle registration details with \"AY16 UAJ\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The \"DACIA\" and \"WHITE\" of the vehicle should be displayed",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I confirm the vehicle on the confirmation page",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "The \"DACIA\" and \"WHITE\" of the vehicle should be displayed on the vehicle details page",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "TestDvlaJourneySteps.i_am_on_the_Dvla_HomePage()"
});
formatter.result({
  "duration": 1137453283,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AY16 UAJ",
      "offset": 44
    }
  ],
  "location": "TestDvlaJourneySteps.i_submit_vehicle_registration_details_with_AY_UAJ(String)"
});
formatter.result({
  "duration": 2732436772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DACIA",
      "offset": 5
    },
    {
      "val": "WHITE",
      "offset": 17
    }
  ],
  "location": "TestDvlaJourneySteps.the_make_and_colour_of_the_vehicle_should_be_displayed(String,String)"
});
formatter.result({
  "duration": 36419974,
  "status": "passed"
});
formatter.match({
  "location": "TestDvlaJourneySteps.i_confirm_the_vehicle_on_the_confirmation_page()"
});
formatter.result({
  "duration": 419183949,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DACIA",
      "offset": 5
    },
    {
      "val": "WHITE",
      "offset": 17
    }
  ],
  "location": "TestDvlaJourneySteps.the_make_and_colour_of_the_vehicle_should_be_displayed_On_VehicleDetailsPage(String,String)"
});
formatter.result({
  "duration": 71345502,
  "status": "passed"
});
formatter.after({
  "duration": 797174639,
  "status": "passed"
});
formatter.before({
  "duration": 3724314566,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Test dvla vehicle journey for various vehicle registration numbers",
  "description": "",
  "id": "check-dvla-vehicle-journey;test-dvla-vehicle-journey-for-various-vehicle-registration-numbers;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "I am on the Dvla View Vehicle Page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I submit vehicle registration details with \"AY14 UAN\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The \"MAZDA\" and \"BLACK\" of the vehicle should be displayed",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I confirm the vehicle on the confirmation page",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "The \"MAZDA\" and \"BLACK\" of the vehicle should be displayed on the vehicle details page",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "TestDvlaJourneySteps.i_am_on_the_Dvla_HomePage()"
});
formatter.result({
  "duration": 1196747316,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AY14 UAN",
      "offset": 44
    }
  ],
  "location": "TestDvlaJourneySteps.i_submit_vehicle_registration_details_with_AY_UAJ(String)"
});
formatter.result({
  "duration": 1482319912,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MAZDA",
      "offset": 5
    },
    {
      "val": "BLACK",
      "offset": 17
    }
  ],
  "location": "TestDvlaJourneySteps.the_make_and_colour_of_the_vehicle_should_be_displayed(String,String)"
});
formatter.result({
  "duration": 41929411,
  "status": "passed"
});
formatter.match({
  "location": "TestDvlaJourneySteps.i_confirm_the_vehicle_on_the_confirmation_page()"
});
formatter.result({
  "duration": 398194609,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MAZDA",
      "offset": 5
    },
    {
      "val": "BLACK",
      "offset": 17
    }
  ],
  "location": "TestDvlaJourneySteps.the_make_and_colour_of_the_vehicle_should_be_displayed_On_VehicleDetailsPage(String,String)"
});
formatter.result({
  "duration": 68249155,
  "status": "passed"
});
formatter.after({
  "duration": 783211561,
  "status": "passed"
});
});