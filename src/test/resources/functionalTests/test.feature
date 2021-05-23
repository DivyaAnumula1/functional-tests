Feature: Functional test sample
  Background: User generates a token for authorisation
    Scenario: Invoke greeting API
      Given greeting API is available
      When invoke the API with a user
      Then response should be valid