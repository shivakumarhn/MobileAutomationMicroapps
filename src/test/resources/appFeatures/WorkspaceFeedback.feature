Feature: Workspace feedback feature

  @SubmitFeedback
  Scenario: Submit workspace feedback
    Given Launch the workspace app
    When Click on actions tab
    And Click on digitalWorkspace feedback
    And Enter feedback details
    Then Click on submit button

  @CreateEvent
  Scenario: Create Sfdc event
    Given Launch the workspace app
    When Click on actions tab
    And Click on create event on account
    And Enter create event details
    Then Click on submit button