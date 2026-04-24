Feature: Purchase the order from Ecommerce website

Background:
Given I landed on Ecommerce page
@PlaceOrder
Scenario Outline: Positive test on submitting the order

Given Logged in with username "<username>" and password "<password>"
When  Add "<productname>" to cart
And  Checkout "<productname>" and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

Examples:

| username               | password    |productname|
|rosemerry@gmail.com     |Rose@12345   |ZARA COAT 3|
