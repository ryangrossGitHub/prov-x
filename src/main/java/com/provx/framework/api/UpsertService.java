package com.provx.framework.api;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.provx.framework.api.input.Bundle;
import com.provx.framework.api.model.CypherModel;
import com.provx.framework.api.model.SPARQLModel;

@Service
public class UpsertService {

    @Value("${GRAPH_QUERY_LANGUAGE}")
    private String graphQueryLanguage;

    private final SPARQLModel sparqlModel;
    private final CypherModel cypherModel;

    public UpsertService(SPARQLModel sparqlModel, CypherModel cypherModel) {
        this.sparqlModel = sparqlModel;
        this.cypherModel = cypherModel;
    }

    public String upsert(Bundle bundle) {
        //Set bundle metadata (not modifiable by client)
        bundle.setId(UUID.randomUUID().toString());
        bundle.setGeneratedAtTime(Instant.now().toEpochMilli());

        // Validate bundle content
        if (!bundleIsValid(bundle)) {
            //TODO: provide detailed validation errors
            return "Invalid bundle content.";
        } else {
            if ("SPARQL".equalsIgnoreCase(graphQueryLanguage)) {
                sparqlModel.insertData(bundle);
            } else if ("CYPHER".equalsIgnoreCase(graphQueryLanguage)) {
                cypherModel.merge(bundle);
            } else {
                return "Unsupported GRAPH_QUERY_LANGUAGE configuration.";
            }
        }

        return "Success";
    }

    private boolean bundleIsValid(Bundle bundle) {
        //TODO: Implement validation logic here
        return true;
    }
}
