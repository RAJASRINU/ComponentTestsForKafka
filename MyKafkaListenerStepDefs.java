import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.junit.Assert.*;

@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class MyKafkaListenerStepDefs {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MyKafkaListener myKafkaListener;

    @Given("a Kafka listener is available")
    public void aKafkaListenerIsAvailable() {
        assertNotNull(myKafkaListener);
    }

    @When("I send a message to the topic {string}")
    public void iSendAMessageToTheTopic(String topic) {
        kafkaTemplate.send(topic, "test message");
    }

    @Then("the listener should process the message")
    public void theListenerShouldProcessTheMessage() {
        // Your verification logic here
    }
}
