Feature: Workspace feedback fail feature

  @SubmitFeedback
  Scenario: Submit workspace fail feedback
    Given Launch the workspace app
    When Click on actions tab
    And Click on digitalWorkspace feedback
    And Enter feedback details
    And Click on digitalWorkspace feedback
    Then Click on submit button
