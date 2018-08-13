import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;

public interface IndexService {
  public IndexResponse findIndexRequestByNameAndType(String indexName, String indexType);

  public IndexResponse findIndexRequestByName(String indexName);

  public BulkResponse create(String[] index, String[] indexType, String[] id, Object... source);

  public BulkResponse update(String[] index, String[] indexTypes, String[] id, Object source);

  public void create(String indexName, Object source);
}
