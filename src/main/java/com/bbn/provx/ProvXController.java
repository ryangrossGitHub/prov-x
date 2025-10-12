package com.bbn.provx;

import java.time.Instant;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bbn.provx.inputs.Bundle;

@Controller
public class ProvXController {
    @QueryMapping
    public String heartbeat() {
        return "alive";
    }

    @MutationMapping
    public String upsertProv(@Argument("input") Bundle bundle) {
        System.out.println(bundle);
        if (bundle != null && 
            (bundle.getActivities() != null && !bundle.getActivities().isEmpty() || 
                bundle.getEntities() != null && !bundle.getEntities().isEmpty() || 
                bundle.getAgents() != null && !bundle.getAgents().isEmpty())) {
            
                    bundle.setId(UUID.randomUUID().toString());
                    bundle.setGeneratedAtTime(Instant.now().toEpochMilli());

                    return "Success";
        }else {
            return "Provide at least one activity, entity, or agent to upsert.";
        }
    }
}
