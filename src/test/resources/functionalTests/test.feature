Feature: Functional test sample
  Background: User generates a token for authorisation

    Scenario: Invoke multiplications API
      Given calculations API is available
      When invoke the API with a user
      Then response should be valid