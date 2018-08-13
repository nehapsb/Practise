package practise.kafka.utils;

import java.util.Properties;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.kafka.common.errors.TopicExistsException;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;

public class KafkaUtil {
	private static ZkUtils zkUtils;


	/**
	 * Creates the topic by topic name.
	 *
	 * @param topicName
	 *            the topic name
	 */
	public static boolean createTopicByTopicName(final String topicName) {

		final Properties topicConfig = new Properties();
		boolean topicStatus = false;
		try {
			// AdminUtils.createTopic(getZkUtils(), topicName,
			// getTopicPartitions(), getTopicReplicas(),
			// topicConfig, RackAwareMode.Disabled$.MODULE$);
			AdminUtils.createTopic(getZkUtils(), topicName, Constants.topic_partitions, Constants.topic_replicas, topicConfig, null);
			topicStatus = true;
		} catch (TopicExistsException ex) {
			topicStatus = true;
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return topicStatus;

	}

	private static ZkUtils getZkUtilsInstance() {
		ZkClient zkClient = null;
		try {
			int connectionTimeoutMs = 8 * 1000;
			zkClient = new ZkClient(Constants.zookeeper_hosts, Constants.SESSION_TIMEOUT_MS, connectionTimeoutMs,
					ZKStringSerializer$.MODULE$);
		} catch (Exception ex) {
		}

		zkUtils = new ZkUtils(zkClient, new ZkConnection(Constants.zookeeper_hosts), false);

		return zkUtils;
	}

	public static ZkUtils getZkUtils() {
		if (null == zkUtils) {
			zkUtils = getZkUtilsInstance();
		}
		return zkUtils;
	}
}
