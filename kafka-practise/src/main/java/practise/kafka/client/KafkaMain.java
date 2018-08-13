package practise.kafka.client;

import practise.kafka.consumers.KafkaConsumeMessages;
import practise.kafka.consumers.KafkaConsumers;
import practise.kafka.producers.KafkaProducers;
import practise.kafka.utils.Constants;

public class KafkaMain {

	public static void main(String[] args) {
		KafkaProducers producer = new KafkaProducers();
		String[] messages = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };
		for (String message : messages) {
			producer.sendToKafka(message, Constants.DEFAULT_TOPIC);
		}
		KafkaConsumers consumer1 = new KafkaConsumers();
		KafkaConsumers consumer2 = new KafkaConsumers();
		System.out.println("Starting Kafka Consumers");

		Thread messages1 = new Thread(new KafkaConsumeMessages(consumer1.getKafkaConsumer(Constants.DEFAULT_TOPIC), "consumer1"));
		Thread messages2 = new Thread(new KafkaConsumeMessages(consumer2.getKafkaConsumer(Constants.DEFAULT_TOPIC), "consumer2"));
		messages1.start();
		messages2.start();
	}
}