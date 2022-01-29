@LoginPage @TestNG
@severity=blocker
Feature: WheelsUP UI and API validations


  @Smoke
  Scenario: Validate navigation page by page in LoginPage

    Given User invokes the browser and navigates to home page
    When User finds and validates the title "Flying, Personalized"
    Then User scrolls down to the text "Discover The Possibilities" and validates it
    And  User scrolls to the button of the page and validates phone "855-FLY-8760" email "INFO@WHEELSUP.COM" and address "601 West 26th Street\r\nNew York, NY 10001"
    Then User scrolls to the top of the page
    And  Clicks Fly dropdown menu
    Then Clicks CORE MEMBERSHIP option from dropdown menu
    And  In CORE MEMBERSHIP page user scrolls down to "Private aviation meets Social Aviation" section and validates the value
    Then User validates "SHARED FLIGHTS" "SHUTTLE FLIGHTS" and "HOT FLIGHTS" sections
    When User scrolls down to the "Learn more today" section and clicks continue button
    And  Validates the link endpoint "request-info"
    Then User chooses "Personal Travel" option from TYPE OF TRAVEL dropdown menu on REQUEST INFO page
    And  User fills out all required fields with the data in given below table
      | First Name     | Akbar                 |
      | Last Name      | Yuldoshev             |
      | Email          | myemailinfo@gmail.com |
      | Phone Number   | 929 246 1111          |
      | Street Address | 70 White street       |
      | Company Name   | Lucid Motors          |
      | City           | New York              |
      | Zip Code       | 10001                 |
      | State          | NJ                    |
      | Country        | United States         |
      | Flights a year | 1-5                   |
      | Pets           | No                    |
      | Second Home    | No                    |
      | Currently Fly  | Commercial            |
    And User clicks on close button in the corner of the page
    Then User closes the browser


  @Smoke
  @Api
  Scenario: Verify social accounts of WheelsUp
    Given User sends get request to "https://wheelsup.com/_mock_/initial-data.json"
    And  User parses the response
    Then User verifies that response has following values "http://instagram.com/wheelsup" and "https://twitter.com/WheelsUp"

  @Smoke
  @Api
  Scenario: Display edited keys
    Given User sends get request to "https://wheelsup.com/_mock_/initial-data.json"
    And  Displays total number of keys field in the console
    Then User removes fields "google_tag_manager" "mapbox_accesstoken" and "footer_disclaimer"  and update email "email"

