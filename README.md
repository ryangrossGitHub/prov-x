# PROVenance-eXploitation (PROV-X)

A graphql service for capturing provenance data against either semantic or property graphs.

## Environment Variables
These must be set for the application to start up.
- GRAPH_QUERY_LANGUAGE (Options: SPARQL, CYPHER)

## GraphiQL UI
Interactive query and mutation webpage located here: http://localhost:8080/graphiql


## Query Example

```graphql
query Query {
  heartbeat
}
```

## Mutate Example

```graphql
mutation mutation {
  upsertProv(input:  {
     entities: [ {
        id: "Entity 2",
        wasDerivedFrom: [ {
           id: "Entity 1"
        }],
        wasAttributedTo: [ {
           id: "Person Agent",
           actedOnBehalfOf: [ {
              id: "Organization Agent"
           }]
        }]
        wasGeneratedBy: [ {
           id: "Activity 2",
           wasAssociatedWith: [ {
              id: "Software Agent"
           }],
           used: [ {
              id: "Entity 1"
           }]
        }]
     }]
  })
}
```

Examples Scenario:
 - A person (Agent) edits v1 of a document (Entity) to create v2 of the document (Entity).
 - The edit is also attributed to the organization (Agent) the person (Agent) belongs to.
 - The document editing software (Agent) executed the transaction (Activity), applying changes to v1 (Entity).

