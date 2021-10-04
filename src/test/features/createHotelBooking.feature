#Author:   Sudheer Bonam
#Date:     30 Sep 2021
#Project:  Hotel Booking for Equal Experts
#Business Process: To Perform Client can create a booking.

@RegressionTest_NewBooking
Feature: Client to Create a hotel booking.

  @CreateBooking
  Scenario: Create new Hotel Booking.

    Given User on the Hotel Booking Form page
    When User enters the Firstname
    And User enters the Surname
    And User enters the Price
    And User selects the Deposit
    And User selects the Check-in date
    And User selects the Check-out date
    And User clicks on the Save button
    Then User verify the confirmed booking record
    #Assertion included in the code