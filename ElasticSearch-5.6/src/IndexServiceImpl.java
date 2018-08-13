

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.xcontent.XContentType;

public class IndexServiceImpl implements IndexService {
  @Override
  public IndexResponse findIndexRequestByNameAndType(String indexName, String indexType) {
    IndexRequest indexRequest = new IndexRequest(indexName, indexType);
    Header[] headers = new Header[1];
    headers[0] = new BasicHeader("content-type", "application/json");
    indexRequest = indexRequest.source(XContentType.JSON);
    IndexResponse response = null;
    try {
      response = ElasticSearchConnection.getESRestConnection().index(indexRequest, headers);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public IndexResponse findIndexRequestByName(String indexName) {
    return findIndexRequestByNameAndType(indexName, "md");
  }

  @Override
  public BulkResponse create(String[] index, String[] indexTypes, String[] types,
      Object... source) {
    BulkRequest request = new BulkRequest();
    for (int k = 0; k < index.length; k++) {
      String indexName = index[k];
      String indextype = indexTypes[k];
      String type = types[k];
      request.add(new IndexRequest(indexName, indextype, type).source(source[k], XContentType.JSON)
          .create(true));
    }
    request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
    BulkResponse bulkResponse = null;
    try {
      bulkResponse = ElasticSearchConnection.getESRestConnection().bulk(request);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bulkResponse;
  }

  public void create(String indexName, Object source) {
    IndexRequest request = new IndexRequest("someindex_example", "md");
    request.source(source, XContentType.JSON);
    Header[] headers = new Header[1];
    headers[0] = new BasicHeader("content-type", "application/json");
    try {
      IndexResponse response =
          ElasticSearchConnection.getESRestConnection().index(request, headers);
      System.out.println("The response " + response);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public BulkResponse update(String[] index, String[] indexTypes, String[] ids, Object source) {
    BulkRequest request = new BulkRequest();
    for (int k = 0; k < index.length; k++) {
      String indexName = index[k];
      String indextype = indexTypes[k];
      String type = ids[k];
      String source1 = source.toString();
      request.add(new UpdateRequest(indexName, indextype, type)
          .doc(new IndexRequest().source(source1, XContentType.JSON)).retryOnConflict(3));
    }
    request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
    BulkResponse bulkResponse = null;
    try {
      bulkResponse = ElasticSearchConnection.getESRestConnection().bulk(request);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bulkResponse;
  }


  public void test() {

    ElasticSearchConnection.getESRestConnection();
  }
}
