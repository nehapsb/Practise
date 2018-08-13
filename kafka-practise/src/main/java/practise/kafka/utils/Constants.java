package practise.kafka.utils;

public class Constants {
	public static final int SESSION_TIMEOUT_MS = 10 * 1000;
	public static final String DEFAULT_TOPIC = "kafka-practise";

	public static final int topic_partitions = 4;

	public static final String zookeeper_hosts = "localhost:2181";

	public static final int topic_replicas = 2;
	public static final String BROKER_CONF_KEY = "bootstrap.servers";
	public static final String BROKERS = "localhost:9092";
	public static final String KAFKA_GROUP_ID = "kafka_id";
	public static final long POLL_INTERVAL = 10000;

}
