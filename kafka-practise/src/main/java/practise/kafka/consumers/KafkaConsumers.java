package practise.kafka.consumers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import practise.kafka.utils.Constants;

public class KafkaConsumers {
	public KafkaConsumers() {
	}

	public KafkaConsumer<String, Object> getKafkaConsumer(String topicName) {
		KafkaConsumer<String, Object> kafkaConsumer = null;
		ConsumerRebalanceListener listener = new ConsumerRebalanceListener() {
			@Override
			public void onPartitionsRevoked(Collection<TopicPartition> arg0) {
				// Not required to override as of now
			}
			@Override
			public void onPartitionsAssigned(Collection<TopicPartition> arg0) {
				// Not required to override as of now
			}
		};
		Properties prop = getKafkaConsumerProps();
		prop.put("group.id", Constants.KAFKA_GROUP_ID);
		kafkaConsumer = new KafkaConsumer<>(prop);
		List<String> subscribedTopics = new ArrayList<>();
		subscribedTopics.add(topicName);
		kafkaConsumer.subscribe(subscribedTopics, listener);
		return kafkaConsumer;
	}

	private Properties getKafkaConsumerProps() {
		Properties kafkaConsumerProps = new Properties();
		kafkaConsumerProps.put(Constants.BROKER_CONF_KEY, Constants.BROKERS);
		kafkaConsumerProps.put("group.id", Constants.KAFKA_GROUP_ID);
		kafkaConsumerProps.put("enable.auto.commit", "false");
		kafkaConsumerProps.put("auto.offset.reset", "earliest");
		kafkaConsumerProps.put("auto.commit.interval.ms", "10000");
		kafkaConsumerProps.put("session.timeout.ms", "30000");
		kafkaConsumerProps.put("metadata.max.age.ms", "60000");
		kafkaConsumerProps.put("max.partition.fetch.bytes", "31457280"); // 30MB.
		kafkaConsumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		kafkaConsumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		return kafkaConsumerProps;
	}

}
