package com.bbn.provx;

import java.util.List;

public class EntityInput extends Entity {
    public EntityInput(String id, List<Entity> wasDerivedFrom, Activity wasGeneratedBy, AgentInput wasAttributedTo) {
        super(id, wasDerivedFrom, wasGeneratedBy, wasAttributedTo);
    }
}
