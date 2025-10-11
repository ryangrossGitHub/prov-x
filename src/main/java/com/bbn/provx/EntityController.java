package com.bbn.provx;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EntityController {
    @QueryMapping
    public Entity entityById(@Argument String id) {
        Agent a1 = new Agent("Jane", null);
        Agent a2 = new Agent("John", null);

        Entity e1 = new Entity("1", null, null, a1);
        Entity e2 = new Entity("2", null, null, a2);

        Activity act1 = new Activity("1", "2023-10-01T10:00:00Z", "2023-10-01T11:00:00Z");
        Activity act2 = new Activity("2", "2023-10-02T10:00:00Z", "2023-10-02T11:00:00Z");

        e1.setWasGeneratedBy(act1);
        e2.setWasGeneratedBy(act2);

        List<Entity> entities = Arrays.asList(e1, e2);

        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @MutationMapping
    public Entity createEntity(@Argument EntityInput input) {
        // In a real application, you would save the entity to a database here.
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

        return new Entity(input.getId(), input.getWasDerivedFrom(), activity, input.getWasAttributedTo());
    }
}
