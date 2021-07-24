Feature: To validate new user Sign up functionality for Elearning application


  Scenario Outline: New user Sign in validation
    Given User is on Registration Page
    And User Enters firstname "<FirstName>"
    And User Enters lastname "<LastName>"
    And User Enters email "<Email>"
    And User Enters username "<Username>"
    And User Enters password "<Password>"
    And Usre Enters confirmpwd "<ConfirmPassword>"
    When User clicks on Register button
    Then User should see his name "<Name>"
    And User clicks on Compose
    And User enters recipient "<Recipient>"
    And User enters subject "<Subject>"
    And User enters message 
    When User Clicks Send button
    Then User should see success "<SuccessMessage>"
    When Uer Clicks on Logout
    Then User should be logged out

    Examples: 
      | FirstName  | LastName | Email        | Username   |Password | ConfirmPassword | Name       | Recipient | Subject      | SuccessMessage               |           
      | Som        | Koris    | sk@gmail.com | Som_Koris  |Welcome% | Welcome%				| Som Koris  | abc       | Test email 1 | The message has been sent to | 
      | Tars       | Fossil   | tf@yahoo.com | Tars_Fossil|Welcome@ | Welcome@        | Tars Fossil| def       | Test email 2 | The message has been sent to |
      | Mepen      | Raul     | mr@redif.com | Mepen_Raul |Welcome$ | Welcome$        | Mepen Raul | ghi       | Test email 3 | The message has been sent to |
      



		