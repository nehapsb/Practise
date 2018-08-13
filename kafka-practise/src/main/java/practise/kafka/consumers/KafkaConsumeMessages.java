package practise.kafka.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import practise.kafka.utils.Constants;

public class KafkaConsumeMessages implements Runnable{
	private KafkaConsumer kafkaConsumer = null;
	private String name;
	public KafkaConsumeMessages(KafkaConsumer consumer1, String name) {
		this.kafkaConsumer = consumer1;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			consumeMessages();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void consumeMessages() throws InterruptedException {
		System.out.println("Starting consuming messages: "+kafkaConsumer);
        ConsumerRecords<String, Object> records = kafkaConsumer.poll(Constants.POLL_INTERVAL);
        String payload;
        for (ConsumerRecord<String, Object> record : records) {
          payload = String.valueOf(record.value());
          processPayload(payload);
          kafkaConsumer.commitSync();
        }
	}
	private void processPayload(String payload) throws InterruptedException {
		System.out.println("----------------------------");
        System.out.println("Starting consuming messages: "+name);
		System.out.println("Got record as: "+payload);
//		System.out.println("Sleeping now.");
		Thread.sleep(2000);
		System.out.println("Processed payload.");
	}
}
