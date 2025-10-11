package com.bbn.provx;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bbn.provx.inputs.Activity;
import com.bbn.provx.inputs.Entity;

@Controller
public class ProvXController {
    @QueryMapping
    public String heartbeat() {
        return "alive";
    }

    @MutationMapping
    public String upsertProv(@Argument Entity input) {
        Activity activity;

        if (input.getWasGeneratedBy() != null) {
            activity = input.getWasGeneratedBy();
        } else {
            activity = new Activity();
        }
        
        activity.setId(UUID.randomUUID().toString());

        if (activity.getStartedAtTime() == null) {
            activity.setStartedAtTime(Calendar.getInstance().getTime().toString());
        }
        if (activity.getEndedAtTime() == null) {
            activity.setEndedAtTime(activity.getStartedAtTime());
        }

        return "Success";
    }
}
