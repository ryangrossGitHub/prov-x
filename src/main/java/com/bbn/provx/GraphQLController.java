package com.bbn.provx;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bbn.provx.input.Bundle;

@Controller
public class GraphQLController {

    private final UpsertService upsertService;

    public GraphQLController(UpsertService upsertService) {
        this.upsertService = upsertService;
    }

    @QueryMapping
    public String heartbeat() {
        return "alive";
    }

    @MutationMapping
    public String upsertProv(@Argument("input") Bundle bundle) {
        // Ensure request has content
        if (bundle != null && 
            (bundle.getActivities() != null && !bundle.getActivities().isEmpty() || 
                bundle.getEntities() != null && !bundle.getEntities().isEmpty() || 
                bundle.getAgents() != null && !bundle.getAgents().isEmpty())) {
            
                    return upsertService.upsert(bundle);
        }else {
            return "Provide at least one activity, entity, or agent to upsert.";
        }
    }
}
