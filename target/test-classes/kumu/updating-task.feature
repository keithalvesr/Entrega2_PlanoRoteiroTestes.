Feature: Updating a task

  Scenario: Prioritizes a task
    Given the user is logged in to set a task priority
      And he selected a task
    When he fills the priority level field to 1
    Then he sees a message of prioritizing concluded

  Scenario: Finishes a task
    Given the user is logged in to finish a task
      And he selected a task
    When he sets the completed field to 1
    Then he sees a message of task finished