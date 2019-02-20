Feature: withdraw
    As a bank staff
    I want have 2 kinds of accounts the normal account that cannot overdrawn and the OD account that can be overdrawn.

Background:
    Given a customer with id 1 and pin 111 with balance 500 exists
    And I login to ATM with id 1 and pin 111

Scenario: Withdraw amount more than balance from normal account
    When a customer overdraws 5000 from ATM
    Then account balance is 500

Scenario: Withdraw amount more than balance from OD account
    When a customer overdraws 5000 from ATM
    Then account balance is -4500
