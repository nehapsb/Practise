
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class QueryServiceImpl implements QueryService {
  @Override
  public GetResponse findByIndexAndId(String index, String id) {
    GetRequest request = new GetRequest(index, "md", id);
    GetResponse response = null;
    try {
      Header[] headers = new Header[1];
      headers[0] = new BasicHeader("content-type", "application/json");
      response = ElasticSearchConnection.getESRestConnection().get(request, headers);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return response;
  }

  @Override
  public SearchResponse findByIndex(String indexName) {
    SearchRequest searchRequest = new SearchRequest();
    searchRequest
        .source(new SearchSourceBuilder().query(new MatchQueryBuilder("_index", indexName)));
    Header[] headers = new Header[1];
    headers[0] = new BasicHeader("content-type", "application/json");
    SearchResponse response = null;
    try {
      response = ElasticSearchConnection.getESRestConnection().search(searchRequest, headers);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return response;
  }
}
