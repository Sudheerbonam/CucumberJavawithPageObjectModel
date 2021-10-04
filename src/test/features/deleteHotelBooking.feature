#Author:   Sudheer Bonam
#Date:     30 Sep 2021
#Project:  Hotel Booking for Equal Experts
#Business Process: To Perform Client can delete an existing booking.

@RegressionTest_DeleteBooking
Feature: Client to Delete the existing hotel booking.

  @DeleteBooking
  Scenario: Delete existing Hotel Booking.
    Given User on the Hotel Booking Form pages
    And User clicks on the Delete button
    Then Existing record got deleted successfully
    #Assertion included in the code