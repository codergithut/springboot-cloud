package elasticsearch;

import com.config.ConstantParam;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BulkOperation {

    private static Logger logger =  LoggerFactory.getLogger(BulkOperation.class);

    @Test
    public void testBulk() throws IOException {

        RestClient restClient = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, ConstantParam.ELASTICSEARCH_SCHEME)).build();

        RestHighLevelClient client =
                new RestHighLevelClient(restClient);

        BulkRequest request = new BulkRequest();

        for(int i = 0; i < 10000; i++) {
            request.add(new IndexRequest("posts", "doc", i + "")
                    .source(XContentType.JSON,"field", "foo" + i));
            request.add(new IndexRequest("posts", "doc", "2" + i + "20000")
                    .source(XContentType.JSON,"field", "bar" + i));
            request.add(new IndexRequest("posts", "doc", "3" + i + "30000")
                    .source(XContentType.JSON,"field", "baz" + i));
        }


        BulkResponse bulkResponse = client.bulk(request);

//        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
//            @Override
//            public void beforeBulk(long executionId, BulkRequest request) {
//                int numberOfActions = request.numberOfActions();
//                logger.debug("Executing bulk [{}] with {} requests", executionId, numberOfActions);
//            }
//
//            @Override
//            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
//                if (response.hasFailures()) {
//                    logger.warn("Bulk [{}] executed with failures", executionId);
//                } else {
//                    logger.debug("Bulk [{}] completed in {} milliseconds", executionId, response.getTook().getMillis());
//                }
//            }
//
//            @Override
//            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
//                logger.error("Failed to execute bulk", failure);
//            }
//        };
//        BulkProcessor bulkProcessor = BulkProcessor.builder(client::bulkAsync, listener).build();

        for (BulkItemResponse bulkItemResponse : bulkResponse) {
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();

            if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                    || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                IndexResponse indexResponse = (IndexResponse) itemResponse;

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                UpdateResponse updateResponse = (UpdateResponse) itemResponse;

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
            }

            if (bulkItemResponse.isFailed()) {
                BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
            }
        }

    }



}
