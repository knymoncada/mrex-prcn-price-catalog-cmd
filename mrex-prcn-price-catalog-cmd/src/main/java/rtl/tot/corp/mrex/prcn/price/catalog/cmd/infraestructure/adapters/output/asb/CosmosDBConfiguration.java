package rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.output.asb;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.spring.data.documentdb.config.AbstractDocumentDbConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosmosDBConfiguration extends AbstractDocumentDbConfiguration {

    private final String uri;
    private final String key;
    private final String database;

    public CosmosDBConfiguration(
            @Value("${azure.cosmosdb.uri}") final String uri,
            @Value("${azure.cosmosdb.key}") final String key,
            @Value("${azure.cosmosdb.database}") final String database) {
        this.uri = uri;
        this.key = key;
        this.database = database;
    }

    public DocumentClient documentClient() {
        return new DocumentClient(uri, key, ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);
    }

    public String getDatabase() {
        return database;
    }
}
