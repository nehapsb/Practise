package practise.kafka.producers;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import practise.kafka.utils.Constants;

public class KafkaProducers {
	Producer<String, String> producer;

	public KafkaProducers() {
		this.producer = new KafkaProducer<>(getKafkaAvroProducerProps());
	}

	private Properties getKafkaAvroProducerProps() {
		Properties producerProperties = new Properties();
		producerProperties.put(Constants.BROKER_CONF_KEY, Constants.BROKERS);
		producerProperties.put("acks", "all");
		producerProperties.put("retries", "0");
		producerProperties.put("batch.size", "16384");
		producerProperties.put("linger.ms", "1");
		producerProperties.put("max.request.size", 31457280);
		producerProperties.put("buffer.memory", "33554432");
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

//		producerProperties.put("compression.type", "snappy");
		return producerProperties;
	}

	public boolean sendToKafka(String message, String topicName) {
		System.out.println("Producing: "+message);
		final boolean[] success = { false };
		try {
			producer.send(new ProducerRecord<>(topicName, message), (metadata, exception) -> {
				if (metadata != null && exception == null) {
					success[0] = true;
				}
			}).get();
		} catch (InterruptedException ex) {
			return false;
		} catch (ExecutionException ex) {
			return false;
		}
		return success[0];
	}

}
