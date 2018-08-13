

import java.io.UnsupportedEncodingException;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;

public class ESExample {
  public static void main(String[] args) throws UnsupportedEncodingException {
    new ESExample();
    IndexService indexService = new IndexServiceImpl();
    Object source1 = "{\"a\":\"b\"}";
    indexService.create("Testing", source1);
    String[] posts = {"post9"};
    String[] doc = {"doc9"};
    String[] type = {"8"};
    String source = "{\"test\":\"ac6\"}";
    // BulkResponse response1 = indexService.create(posts, doc, type, source);
    // System.out.println("The response1 " + response1.toString());
    QueryService qService = new QueryServiceImpl();

    SearchResponse resonse = qService.findByIndex("post5");
    System.out.println("The response from search " + resonse);
    source = "{\"test\":\"acUpdated\"}";
    BulkResponse response2 = indexService.update(posts, doc, type, source);
    System.out.println("The response2 " + response2.buildFailureMessage());
  }
}
