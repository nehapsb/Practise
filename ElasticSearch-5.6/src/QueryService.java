
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;

public interface QueryService {

  public GetResponse findByIndexAndId(String index, String id);

  public SearchResponse findByIndex(String indexname);


}
