

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticSearchConnection {

  public static RestHighLevelClient getESRestConnection() {
    HttpHost[] host = new HttpHost[1];
    host[0] = new HttpHost("localhost", 9200);
    RestClientBuilder client = RestClient.builder(host);
    RestHighLevelClient highLevelClient = new RestHighLevelClient(client.build());
    return highLevelClient;

  }
}
