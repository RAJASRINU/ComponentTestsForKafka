Feature: Kafka Listener

  Scenario: Listener processes a Kafka message
    Given a Kafka listener is available
    When I send a message to the topic "my-topic"
    Then the listener should process the message
