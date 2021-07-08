# language: en
@store
Feature: Store

  @inventory
  Scenario: Returns pet inventories by status
    Given Jhon needs to manage his pet inventory
    When requests to get his inventory
    Then you will be informed of the current status of orders recived

  @e2eInventory
  Scenario Outline: view inventory impact
    Given John needs to manage his pet inventory
    When requests to get his inventory
    When request to create a an order
      |petId|quantity|status|complete|
      |<petId>|<quantity>|<status>|<complete>|
    Then the number of approved must be greater than those who were initially consulted
    Examples:
      |petId|quantity|status|complete|
      |198772|7|approved|true|

  @create
  Scenario Outline: create order
    Given Jhon needs to manage his pet inventory
    When request to create a an order
      |petId|quantity|status|complete|
      |<petId>|<quantity>|<status>|<complete>|
    Then the order is created correctly
  Examples:
    |petId|quantity|status|complete|
    |198772|7|approved|true|

  @find
  Scenario: Find order
    Given Jhon needs to manage his pet inventory
    When request to find the order 2
    Then the system get to order

  @delete
  Scenario Outline: Delete order
    Given Jhon needs to manage his pet inventory
    When request to delete the order <id>
    Then the system delete to order
    Examples:
    |id|
    |1|


