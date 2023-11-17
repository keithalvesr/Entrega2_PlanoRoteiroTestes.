Feature: Adding a task

  Scenario: Access task form
    Given the user is logged in to add a task
    When he chooses the option to add a new task
    Then he sees the task form

  Scenario: Adds task
    Given the user is in task form
    When he submits the task info
    Then he sees the list of pending tasks