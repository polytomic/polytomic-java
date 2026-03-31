# Reference
## BulkSync
<details><summary><code>client.bulkSync.list() -> BulkSyncListEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().list(
    BulkSyncListRequest
        .builder()
        .active(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**active:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.create(request) -> BulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new Bulk Sync from a source to a destination (data warehouse, database, or cloud storage bucket like S3).

Bulk Syncs are used for the ELT pattern (Extract, Load, and Transform), where you want to sync un-transformed data to your data warehouses, databases, or cloud storage buckets like S3.

All of the functionality described in [the product
documentation](https://docs.polytomic.com/docs/bulk-syncs) is configurable via
the API.

Sample code examples:

- [Bulk sync (ELT) from Salesforce to S3](https://apidocs.polytomic.com/guides/code-examples/bulk-sync-elt-from-salesforce-to-s-3)
- [Bulk sync (ELT) from Salesforce to Snowflake](https://apidocs.polytomic.com/guides/code-examples/bulk-sync-elt-from-salesforce-to-snowflake)
- [Bulk sync (ELT) from HubSpot to PostgreSQL](https://apidocs.polytomic.com/guides/code-examples/bulk-sync-elt-from-hub-spot-to-postgre-sql)

## Connection specific configuration

The `destination_configuration` is integration-specific configuration for the
selected bulk sync destination. This includes settings such as the output schema
and is required when creating a new sync.

The `source_configuration` is optional. It allows configuration for how
Polytomic reads data from the source connection. This will not be available for
integrations that do not support additional configuration.

Consult the [connection configurations](https://apidocs.polytomic.com/2024-02-08/guides/configuring-your-connections/overview)
to see configurations for particular integrations (for example, [here](https://apidocs.polytomic.com/2024-02-08/guides/configuring-your-connections/connections/postgre-sql#source-1) is the available source configuration for the PostgreSQL bulk sync source).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().create(
    CreateBulkSyncRequest
        .builder()
        .destinationConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .name("My Bulk Sync")
        .schedule(
            BulkSchedule
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .sourceConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .destinationConfiguration(
            new HashMap<String, Object>() {{
                put("schema", "my_schema");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**active:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**automaticallyAddNewFields:** `Optional<BulkDiscover>` 
    
</dd>
</dl>

<dl>
<dd>

**automaticallyAddNewObjects:** `Optional<BulkDiscover>` 
    
</dd>
</dl>

<dl>
<dd>

**concurrencyLimit:** `Optional<Integer>` — Override the default concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConfiguration:** `Map<String, Object>` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConnectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**disableRecordTimestamps:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**discover:** `Optional<Boolean>` — DEPRECATED: Use automatically_add_new_objects/automatically_add_new_fields instead
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<BulkSyncMode>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**normalizeNames:** `Optional<BulkNormalizeNames>` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**resyncConcurrencyLimit:** `Optional<Integer>` — Override the default resync concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `BulkSchedule` 
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<V2CreateBulkSyncRequestSchemasItem>>` — List of schemas to sync; if omitted, all schemas will be selected for syncing.
    
</dd>
</dl>

<dl>
<dd>

**sourceConfiguration:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**sourceConnectionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.get(id) -> BulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().get(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    BulkSyncGetRequest
        .builder()
        .refreshSchemas(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**refreshSchemas:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.update(id, request) -> BulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 📘 Updating schemas
>
> Schema updates can be performed using the [Update Bulk Sync Schemas](https://apidocs.polytomic.com/api-reference/bulk-sync/schemas/patch) endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateBulkSyncRequest
        .builder()
        .destinationConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .name("My Bulk Sync")
        .schedule(
            BulkSchedule
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .sourceConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .destinationConfiguration(
            new HashMap<String, Object>() {{
                put("schema", "my_schema");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**automaticallyAddNewFields:** `Optional<BulkDiscover>` 
    
</dd>
</dl>

<dl>
<dd>

**automaticallyAddNewObjects:** `Optional<BulkDiscover>` 
    
</dd>
</dl>

<dl>
<dd>

**concurrencyLimit:** `Optional<Integer>` — Override the default concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConfiguration:** `Map<String, Object>` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConnectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**disableRecordTimestamps:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**discover:** `Optional<Boolean>` — DEPRECATED: Use automatically_add_new_objects/automatically_add_new_fields instead
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<BulkSyncMode>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**normalizeNames:** `Optional<BulkNormalizeNames>` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**resyncConcurrencyLimit:** `Optional<Integer>` — Override the default resync concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `BulkSchedule` 
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<V2UpdateBulkSyncRequestSchemasItem>>` — List of schemas to sync; if omitted, all schemas will be selected for syncing.
    
</dd>
</dl>

<dl>
<dd>

**sourceConfiguration:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**sourceConnectionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().remove(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    BulkSyncRemoveRequest
        .builder()
        .refreshSchemas(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**refreshSchemas:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.activate(id, request) -> ActivateSyncEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().activate(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ActivateSyncInput
        .builder()
        .active(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `ActivateSyncInput` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.cancel(id) -> CancelBulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().cancel("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The active execution of this bulk sync ID will be cancelled.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.start(id, request) -> BulkSyncExecutionEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().start(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    StartBulkSyncRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fetchMode:** `Optional<BulkFetchMode>` 
    
</dd>
</dl>

<dl>
<dd>

**resync:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**test:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.getStatus(id) -> BulkSyncStatusEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().getStatus("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.getSource(id) -> BulkSyncSourceEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().getSource(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    BulkSyncGetSourceRequest
        .builder()
        .includeFields(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**includeFields:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.getDestination(id) -> BulkSyncDestEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().getDestination("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Connections
<details><summary><code>client.connections.getTypes() -> ConnectionTypeResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().getTypes();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.getConnectionTypeSchema(id) -> JsonschemaSchema</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().getConnectionTypeSchema("postgresql");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.getTypeParameterValues(type, request) -> ConnectionParameterValuesResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().getTypeParameterValues(
    "type",
    GetConnectionTypeParameterValuesRequestSchema
        .builder()
        .field("field")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**type:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**connectionId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**field:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**parameters:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.list() -> ConnectionListResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.create(request) -> CreateConnectionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().create(
    CreateConnectionRequestSchema
        .builder()
        .name("My Postgres Connection")
        .type("postgresql")
        .configuration(
            new HashMap<String, Object>() {{
                put("database", "example");
                put("hostname", "postgres.example.com");
                put("password", "********");
                put("port", 5432);
                put("username", "user");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**configuration:** `Map<String, Object>` 
    
</dd>
</dl>

<dl>
<dd>

**healthcheckInterval:** `Optional<String>` — Override interval for connection health checking.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `Optional<String>` — URL to redirect to after completing OAuth flow.
    
</dd>
</dl>

<dl>
<dd>

**type:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**validate:** `Optional<Boolean>` — Validate connection configuration.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.connect(request) -> ConnectCardResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new request for [Polytomic Connect](https://www.polytomic.com/connect).

This endpoint configures a Polytomic Connect request and returns the URL to
redirect users to. This allows embedding Polytomic connection authorization in
other applications.

See also:

- [Embedding authentication](https://apidocs.polytomic.com/2024-02-08/guides/embedding-authentication), a guide to using Polytomic Connect.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().connect(
    ConnectCardRequest
        .builder()
        .name("Salesforce Connection")
        .redirectUrl("redirect_url")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connection:** `Optional<String>` — The id of an existing connection to update.
    
</dd>
</dl>

<dl>
<dd>

**dark:** `Optional<Boolean>` — Whether to use the dark theme for the Connect modal.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name of the new connection. Must be unique per organization.
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `String` — URL to redirect to after connection is created.
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` — Connection type to create.
    
</dd>
</dl>

<dl>
<dd>

**whitelist:** `Optional<List<String>>` — List of connection types which are allowed to be created. Ignored if type is set.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.testConnection(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Tests a connection configuration.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().testConnection(
    TestConnectionRequest
        .builder()
        .type("postgresql")
        .configuration(
            new HashMap<String, Object>() {{
                put("database", "example");
                put("hostname", "postgres.example.com");
                put("password", "password");
                put("port", 5432);
                put("username", "user");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**configuration:** `Map<String, Object>` — Connection configuration to test.
    
</dd>
</dl>

<dl>
<dd>

**connectionId:** `Optional<String>` — Optional existing connection ID to use as a base for testing. The provided configuration will be merged over the stored configuration for this connection before testing.
    
</dd>
</dl>

<dl>
<dd>

**type:** `String` — The type of connection to test.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.get(id) -> ConnectionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.update(id, request) -> CreateConnectionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateConnectionRequestSchema
        .builder()
        .name("My Postgres Connection")
        .configuration(
            new HashMap<String, Object>() {{
                put("database", "example");
                put("hostname", "postgres.example.com");
                put("password", "********");
                put("port", 5432);
                put("username", "user");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**configuration:** `Map<String, Object>` 
    
</dd>
</dl>

<dl>
<dd>

**healthcheckInterval:** `Optional<String>` — Override interval for connection health checking.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**reconnect:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**validate:** `Optional<Boolean>` — Validate connection configuration.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().remove(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ConnectionsRemoveRequest
        .builder()
        .force(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**force:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.getParameterValues(id) -> ConnectionParameterValuesResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().getParameterValues("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.createSharedConnection(parentConnectionId, request) -> V2CreateSharedConnectionResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Shared connections can only be created by using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().createSharedConnection(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ApiRequest
        .builder()
        .childOrganizationId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**parentConnectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**childOrganizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.listSharedConnections(parentConnectionId) -> ConnectionListResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connections().listSharedConnections("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**parentConnectionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## QueryRunner
<details><summary><code>client.queryRunner.runQuery(connectionId, request) -> V4RunQueryEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Submit a query for asynchronous execution against the connection. The initial response may only contain the query task id and status. Poll GET /api/queries/{id} with the returned id to retrieve completion status, fields, and results.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.queryRunner().runQuery(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    V4RunQueryRequest
        .builder()
        .query("SELECT * FROM table")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` — The query to execute against the connection.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.queryRunner.getQuery(id) -> V4QueryResultsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch the latest status for a submitted query and, once complete, return fields and paginated results. Use the query id returned by POST /api/connections/{connection_id}/query.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.queryRunner().getQuery(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    QueryRunnerGetQueryRequest
        .builder()
        .page("page")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Schemas
<details><summary><code>client.schemas.upsertField(connectionId, schemaId, request)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().upsertField(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "public.users",
    UpsertSchemaFieldRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<V4UserFieldRequest>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.deleteField(connectionId, schemaId, fieldId)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().deleteField("248df4b7-aa70-47b8-a036-33ac447e668d", "public.users", "first_name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fieldId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.setPrimaryKeys(connectionId, schemaId, request)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().setPrimaryKeys(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "public.users",
    SetPrimaryKeysRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<SchemaPrimaryKeyOverrideInput>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.resetPrimaryKeys(connectionId, schemaId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete all primary key overrides for a schema. After this call the schema will use the primary keys detected from the source connection, if any.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().resetPrimaryKeys("248df4b7-aa70-47b8-a036-33ac447e668d", "public.users");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.refresh(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().refresh("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.getStatus(id) -> BulkSyncSourceStatusEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Polytomic periodically inspects the schemas for connections to discover new fields and update metadata. This endpoint returns the current inspection status.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().getStatus("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.get(id, schemaId) -> BulkSyncSourceSchemaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().get("248df4b7-aa70-47b8-a036-33ac447e668d", "public.users");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.schemas.getRecords(id, schemaId) -> SchemaRecordsResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.schemas().getRecords("248df4b7-aa70-47b8-a036-33ac447e668d", "public.users");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Models
<details><summary><code>client.models.getEnrichmentSource(id) -> GetModelSyncSourceMetaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().getEnrichmentSource(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelsGetEnrichmentSourceRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.post(connectionId, request) -> V2GetEnrichmentInputFieldsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

For a given connection and enrichment configuration, provides the valid sets of input fields.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().post(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    GetEnrichmentInputFieldsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**configuration:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.preview(request) -> ModelResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().preview(
    ModelsPreviewRequest
        .builder()
        .body(
            CreateModelRequest
                .builder()
                .connectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
                .name("Users")
                .configuration(
                    new HashMap<String, Object>() {{
                        put("table", "public.users");
                    }}
                )
                .build()
        )
        .async(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateModelRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.list() -> ModelListResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.create(request) -> ModelResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().create(
    ModelsCreateRequest
        .builder()
        .body(
            CreateModelRequest
                .builder()
                .connectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
                .name("Users")
                .configuration(
                    new HashMap<String, Object>() {{
                        put("table", "public.users");
                    }}
                )
                .build()
        )
        .async(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateModelRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.get(id) -> ModelResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().get(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelsGetRequest
        .builder()
        .async(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.update(id, request) -> ModelResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateModelRequest
        .builder()
        .connectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .name("Users")
        .async(false)
        .configuration(
            new HashMap<String, Object>() {{
                put("table", "public.users");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**additionalFields:** `Optional<List<ModelModelFieldRequest>>` 
    
</dd>
</dl>

<dl>
<dd>

**configuration:** `Map<String, Object>` 
    
</dd>
</dl>

<dl>
<dd>

**connectionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**enricher:** `Optional<Enrichment>` 
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**identifier:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**labels:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**refresh:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**relations:** `Optional<List<ModelRelation>>` 
    
</dd>
</dl>

<dl>
<dd>

**trackingColumns:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().remove(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelsRemoveRequest
        .builder()
        .async(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.sample(id) -> ModelSampleResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns sample records from the model. The first ten records that the source provides will be returned after being enriched (if applicable). Synchronous requests must complete within 10s. If either querying or enrichment exceeds 10s, please use the async option.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().sample(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelsSampleRequest
        .builder()
        .async(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**async:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ModelSync
<details><summary><code>client.modelSync.getSource(id) -> GetModelSyncSourceMetaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().getSource(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelSyncGetSourceRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.getSourceFields(id) -> ModelFieldResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().getSourceFields(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ModelSyncGetSourceFieldsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.list() -> ListModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().list(
    ModelSyncListRequest
        .builder()
        .active(true)
        .mode(ModelSyncMode.CREATE)
        .targetConnectionId("0b155265-c537-44c9-9359-a3ceb468a4da")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**active:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<ModelSyncMode>` 
    
</dd>
</dl>

<dl>
<dd>

**targetConnectionId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.create(request) -> ModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new sync from one or more models to a destination.

All of the functionality described in [the product
documentation](https://docs.polytomic.com/docs/sync-destinations) is
configurable via the API.

Guides:

- [Model sync (Reverse ETL) from Snowflake query to Salesforce](https://apidocs.polytomic.com/2024-02-08/guides/code-examples/model-sync-reverse-etl-from-snowflake-query-to-salesforce)
- [Joined model sync from Postgres, Airtable, and Stripe to Hubspot](https://apidocs.polytomic.com/2024-02-08/guides/code-examples/joined-model-sync-from-postgres-airtable-and-stripe-to-hubspot)

## Targets (Destinations)

Polytomic refers to a model sync's destination as the "target object", or
target. Target objects are identified by a connection ID and an object ID. You
can retrieve a list of all target objects for a connection using the [Get Target
Objects](./targets/list) endpoint.

The `target` object in the request specifies information about the sync destination.

```json
"target": {
    "connection_id": "248df4b7-aa70-47b8-a036-33ac447e668d",
    "object": "Users",
},
```

Some connections support additional configuration for targets. For example,
[Salesforce
connections](https://apidocs.polytomic.com/2024-02-08/guides/configuring-your-connections/connections/salesforce#target)
support optionally specifying the ingestion API to use. The target specific
options are passed as `configuration`; consult the [integration
guides](https://apidocs.polytomic.com/2024-02-08/guides/configuring-your-connections/overview)
for details about specific connection configurations.

### Creating a new target

Some integrations support creating a new target when creating a model sync. For
example, an ad audience or database table.

When creating a new target, `object` is omitted and `create` is specified
instead. The `create` property is an object containing integration specific
configuration for the new target.

```json
"target": {
    "connection_id": "248df4b7-aa70-47b8-a036-33ac447e668d",
    "create": {
        "name": "New audience",
        "type": "user_audience"
    }
},
```

The [Get Target List](./targets/list) endpoint returns information about whether
a connection supports target creation.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().create(
    CreateModelSyncRequest
        .builder()
        .mode(ModelSyncMode.CREATE)
        .name("Users Sync")
        .schedule(
            Schedule
                .builder()
                .build()
        )
        .target(
            Target
                .builder()
                .connectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
                .build()
        )
        .fields(
            Arrays.asList(
                ModelSyncField
                    .builder()
                    .target("name")
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**active:** `Optional<Boolean>` — Whether the sync is enabled and scheduled.
    
</dd>
</dl>

<dl>
<dd>

**encryptionPassphrase:** `Optional<String>` — Passphrase for encrypting the sync data.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `List<ModelSyncField>` — Fields to sync from source to destination.
    
</dd>
</dl>

<dl>
<dd>

**filterLogic:** `Optional<String>` — Logical expression to combine filters.
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<List<Filter>>` — Filters to apply to the source data.
    
</dd>
</dl>

<dl>
<dd>

**identity:** `Optional<Identity>` 
    
</dd>
</dl>

<dl>
<dd>

**mode:** `ModelSyncMode` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**onlyEnrichUpdates:** `Optional<Boolean>` — Whether to use enrichment models as a source of possible changes to sync. If true, only changes to the base models will cause a record to sync.
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` — Organization ID for the sync; read-only with a partner key.
    
</dd>
</dl>

<dl>
<dd>

**overrideFields:** `Optional<List<ModelSyncField>>` — Values to set in the target unconditionally.
    
</dd>
</dl>

<dl>
<dd>

**overrides:** `Optional<List<Override>>` — Conditional value replacement for fields.
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `Schedule` 
    
</dd>
</dl>

<dl>
<dd>

**skipInitialBackfill:** `Optional<Boolean>` — Whether to skip the initial backfill of records; if true only records seen after the sync is enabled will be synced.
    
</dd>
</dl>

<dl>
<dd>

**syncAllRecords:** `Optional<Boolean>` — Whether to sync all records from the source, regardless of whether they've changed since the previous execution.
    
</dd>
</dl>

<dl>
<dd>

**target:** `Target` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.getScheduleOptions() -> ScheduleOptionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().getScheduleOptions();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.get(id) -> ModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.update(id, request) -> ModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateModelSyncRequest
        .builder()
        .mode(ModelSyncMode.CREATE)
        .name("Users Sync")
        .schedule(
            Schedule
                .builder()
                .build()
        )
        .target(
            Target
                .builder()
                .connectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
                .build()
        )
        .fields(
            Arrays.asList(
                ModelSyncField
                    .builder()
                    .target("name")
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` — Whether the sync is enabled and scheduled.
    
</dd>
</dl>

<dl>
<dd>

**encryptionPassphrase:** `Optional<String>` — Passphrase for encrypting the sync data.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `List<ModelSyncField>` — Fields to sync from source to destination.
    
</dd>
</dl>

<dl>
<dd>

**filterLogic:** `Optional<String>` — Logical expression to combine filters.
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<List<Filter>>` — Filters to apply to the source data.
    
</dd>
</dl>

<dl>
<dd>

**identity:** `Optional<Identity>` 
    
</dd>
</dl>

<dl>
<dd>

**mode:** `ModelSyncMode` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**onlyEnrichUpdates:** `Optional<Boolean>` — Whether to use enrichment models as a source of possible changes to sync. If true, only changes to the base models will cause a record to sync.
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` — Organization ID for the sync; read-only with a partner key.
    
</dd>
</dl>

<dl>
<dd>

**overrideFields:** `Optional<List<ModelSyncField>>` — Values to set in the target unconditionally.
    
</dd>
</dl>

<dl>
<dd>

**overrides:** `Optional<List<Override>>` — Conditional value replacement for fields.
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `Schedule` 
    
</dd>
</dl>

<dl>
<dd>

**skipInitialBackfill:** `Optional<Boolean>` — Whether to skip the initial backfill of records; if true only records seen after the sync is enabled will be synced.
    
</dd>
</dl>

<dl>
<dd>

**syncAllRecords:** `Optional<Boolean>` — Whether to sync all records from the source, regardless of whether they've changed since the previous execution.
    
</dd>
</dl>

<dl>
<dd>

**target:** `Target` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().remove("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.activate(id, request) -> ActivateSyncEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().activate(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ActivateSyncInput
        .builder()
        .active(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `ActivateSyncInput` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.cancel(id) -> CancelModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().cancel("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The active execution of this sync ID will be cancelled.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.start(id, request) -> StartModelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Force full resync
>
> Use caution when setting the `resync` parameter to `true`. This will force a full resync of the data from the source system. This can be a time-consuming operation and may impact the performance of the source system. It is recommended to only use this option when necessary.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().start(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    StartModelSyncRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**identities:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**resync:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**test:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.getStatus(id) -> SyncStatusEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().getStatus("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Events
<details><summary><code>client.events.list() -> EventsEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().list(
    EventsListRequest
        .builder()
        .organizationId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .type("type")
        .startingAfter(OffsetDateTime.parse("2020-01-01T00:00:00Z"))
        .endingBefore(OffsetDateTime.parse("2020-01-01T00:00:00Z"))
        .limit(1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<OffsetDateTime>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<OffsetDateTime>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.getTypes() -> EventTypesEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().getTypes();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Jobs
<details><summary><code>client.jobs.get(id, type) -> JobResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.jobs().get("248df4b7-aa70-47b8-a036-33ac447e668d", "createmodel");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Identity
<details><summary><code>client.identity.get() -> GetIdentityResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns information about the caller's identity.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.identity().get();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Notifications
<details><summary><code>client.notifications.getGlobalErrorSubscribers() -> V4GlobalErrorSubscribersResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.notifications().getGlobalErrorSubscribers();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notifications.setGlobalErrorSubscribers(request) -> V4GlobalErrorSubscribersResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.notifications().setGlobalErrorSubscribers(
    V4GlobalErrorSubscribersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**emails:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organization
<details><summary><code>client.organization.list() -> OrganizationsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Organization endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organization().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organization.create(request) -> OrganizationEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Organization endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organization().create(
    CreateOrganizationRequestSchema
        .builder()
        .name("My Organization")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**clientId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**issuer:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**ssoDomain:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**ssoOrgId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organization.get(id) -> OrganizationEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Organization endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organization().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organization.update(id, request) -> OrganizationEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Organization endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organization().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateOrganizationRequestSchema
        .builder()
        .name("My Organization")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**issuer:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**ssoDomain:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**ssoOrgId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organization.remove(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> Organization endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organization().remove("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users
<details><summary><code>client.users.list(orgId) -> ListUsersEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().list("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.create(orgId, request) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().create(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    CreateUserRequestSchema
        .builder()
        .email("mail@example.com")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.get(id, orgId) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().get("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.update(id, orgId, request) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateUserRequestSchema
        .builder()
        .email("mail@example.com")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.remove(id, orgId) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().remove("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.createApiKey(orgId, id) -> ApiKeyResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().createApiKey(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UsersCreateApiKeyRequest
        .builder()
        .force(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orgId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**force:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Webhooks
<details><summary><code>client.webhooks.list() -> WebhookListEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Webooks can be set up using the webhook API endpoints. Currently, only one
webhook may be created per organization. The webhook will be called for events
in that organization.

Consult the [Events documentation](https://apidocs.polytomic.com/guides/events) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.create(request) -> WebhookEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Webooks can be set up using the webhook API endpoints. Currently, only one
webhook may be created per organization. The webhook will be called for events
in that organization.

Consult the [Events documentation](https://apidocs.polytomic.com/guides/events) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().create(
    CreateWebhooksSchema
        .builder()
        .endpoint("https://example.com/webhook")
        .secret("secret")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endpoint:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**secret:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.get(id) -> WebhookEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Webooks can be set up using the webhook API endpoints. Currently, only one
webhook may be created per organization. The webhook will be called for events
in that organization.

Consult the [Events documentation](https://apidocs.polytomic.com/guides/events) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.update(id, request) -> WebhookEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Webooks can be set up using the webhook API endpoints. Currently, only one
webhook may be created per organization. The webhook will be called for events
in that organization.

Consult the [Events documentation](https://apidocs.polytomic.com/guides/events) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateWebhooksSchema
        .builder()
        .endpoint("https://example.com/webhook")
        .secret("secret")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**endpoint:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**secret:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().remove("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.disable(id) -> WebhookEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().disable("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.enable(id) -> WebhookEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().enable("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BulkSync Executions
<details><summary><code>client.bulkSync.executions.listStatus() -> ListBulkSyncExecutionStatusEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().listStatus(
    ExecutionsListStatusRequest
        .builder()
        .all(true)
        .active(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**all:** `Optional<Boolean>` — Return the execution status of all syncs in the organization
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` — Return the execution status of all active syncs in the organization
    
</dd>
</dl>

<dl>
<dd>

**syncId:** `Optional<String>` — Return the execution status of the specified sync; this may be supplied multiple times.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.list(id) -> ListBulkSyncExecutionsEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().list(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ExecutionsListRequest
        .builder()
        .pageToken("AmkYh8v0jR5B3kls2Qcc9y8MjrPmvR4CvaK7H0F4rEwqvg76K==")
        .onlyTerminal(true)
        .ascending(true)
        .limit(100)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**onlyTerminal:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**ascending:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.get(id, execId) -> BulkSyncExecutionEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().get("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**execId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.cancel(id, execId) -> CancelBulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().cancel("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The bulk sync ID.
    
</dd>
</dl>

<dl>
<dd>

**execId:** `String` — The execution ID to cancel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.getLogs(syncId, executionId) -> V4BulkSyncExecutionLogsEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().getLogs("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**executionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.exportLogs(syncId, executionId) -> V4ExportSyncLogsEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().executions().exportLogs(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ExecutionsExportLogsRequest
        .builder()
        .notify_(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**executionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**notify:** `Optional<Boolean>` — Send a notification to the user when the logs are ready for download.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BulkSync Schemas
<details><summary><code>client.bulkSync.schemas.list(id) -> ListBulkSchema</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schemas().list(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    SchemasListRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<Map<String, Optional<String>>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schemas.patch(id, request) -> ListBulkSchema</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schemas().patch(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    BulkSyncSchemasRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<BulkSchema>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schemas.get(id, schemaId) -> BulkSchemaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schemas().get("248df4b7-aa70-47b8-a036-33ac447e668d", "Contact");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schemas.update(id, schemaId, request) -> BulkSchemaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schemas().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "contact",
    UpdateBulkSchema
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` 
    
</dd>
</dl>

<dl>
<dd>

**disableDataCutoff:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<UpdateBulkField>>` 
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<List<BulkFilter>>` 
    
</dd>
</dl>

<dl>
<dd>

**partitionKey:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**trackingField:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**userOutputName:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schemas.cancel(id, schemaId) -> CancelBulkSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schemas().cancel("248df4b7-aa70-47b8-a036-33ac447e668d", "schema_id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The bulk sync ID.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — The schema ID to cancel for the bulk sync.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BulkSync Schedules
<details><summary><code>client.bulkSync.schedules.list(syncId) -> SchedulesEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schedules().list("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schedules.create(syncId, request) -> ScheduleEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schedules().create(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    CreateScheduleRequest
        .builder()
        .schedule(
            V4BulkSyncScheduleApi
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `V4BulkSyncScheduleApi` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schedules.get(syncId, scheduleId) -> ScheduleEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schedules().get("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schedules.update(syncId, scheduleId, request) -> ScheduleEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schedules().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateScheduleRequest
        .builder()
        .schedule(
            V4BulkSyncScheduleApi
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `V4BulkSyncScheduleApi` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schedules.delete(syncId, scheduleId)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bulkSync().schedules().delete("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ModelSync Targets
<details><summary><code>client.modelSync.targets.getTarget(id) -> GetConnectionMetaEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().targets().getTarget(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    TargetsGetTargetRequest
        .builder()
        .type("type")
        .search("search")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.targets.getTargetFields(id) -> TargetResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().targets().getTargetFields(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    TargetsGetTargetFieldsRequest
        .builder()
        .target("database.table")
        .refresh(false)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**target:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**refresh:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.targets.list(id) -> V4TargetObjectsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns available model sync destinations for a connection.

If the connection supports creating new destinations, the `target_creation`
object will contain information on what properties are required to create the
target.

Target creation properties are all string values; the `enum` flag indicates if
the property has a fixed set of valid values. When `enum` is `true`, the [Target
Creation Property
Values](https://apidocs.polytomic.com/2024-02-08/api-reference/model-sync/targets/get-create-property)
endpoint can be used to retrieve the valid values.

## Sync modes

The sync mode determines which records are written to the destination for a
model sync. The `modes` array for a target object defines the `id` along with
what operations the mode supports.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().targets().list("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.targets.getCreateProperty(id, property) -> V4TargetPropertyValuesEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Connections which support creating new sync target objects (destinations) will
return `target_creation` with their [target object list](./list). This endpoint
will return possible values for properties where `enum` is `true`.

If the connection does not support creating new target objects, an HTTP 404 will
be returned.

The `values` array lists the valid options (and labels) for the property. Each
member of the `values` array has a `label` and `value`. For exaample,

```json
{
  "data": [
    {
      "id": "account",
      "title": "Account ID",
      "enum": true,
      "values": [
        {
          "value": "1234567::urn:li:organization:987654",
          "label": "Polytomic Inc. (1234567)"
        }
      ]
    }
  ]
}
```

The `value` for the selected option should be passed when [creating a
sync](https://apidocs.polytomic.com/2024-02-08/api-reference/model-sync/create).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().targets().getCreateProperty("248df4b7-aa70-47b8-a036-33ac447e668d", "property");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**property:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ModelSync Executions
<details><summary><code>client.modelSync.executions.list(syncId) -> ListExecutionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().executions().list(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ExecutionsListRequest
        .builder()
        .pageToken("AmkYh8v0jR5B3kls2Qcc9y8MjrPmvR4CvaK7H0F4rEwqvg76K==")
        .onlyCompleted(true)
        .ascending(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**onlyCompleted:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**ascending:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.executions.get(syncId, id) -> GetExecutionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().executions().get("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.executions.update(syncId, id, request) -> GetExecutionResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().executions().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateExecutionRequest
        .builder()
        .status(ExecutionStatus.CREATED)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The ID of the execution to update.
    
</dd>
</dl>

<dl>
<dd>

**status:** `ExecutionStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.executions.getLogUrls(syncId, id, type) -> ExecutionLogsResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().executions().getLogUrls("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d", V2ExecutionLogType.RECORDS);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `V2ExecutionLogType` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.executions.getLogs(syncId, id, type, filename)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.modelSync().executions().getLogs("248df4b7-aa70-47b8-a036-33ac447e668d", "0ecd09c1-b901-4d27-9053-f0367c427254", V2ExecutionLogType.RECORDS, "path/to/file.json");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**syncId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `V2ExecutionLogType` 
    
</dd>
</dl>

<dl>
<dd>

**filename:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Permissions Policies
<details><summary><code>client.permissions.policies.list() -> ListPoliciesResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().policies().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.policies.create(request) -> PolicyResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().policies().create(
    CreatePolicyRequest
        .builder()
        .name("Custom")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policyActions:** `Optional<List<PolicyAction>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.policies.get(id) -> PolicyResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().policies().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.policies.update(id, request) -> PolicyResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().policies().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdatePolicyRequest
        .builder()
        .name("Custom")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**policyActions:** `Optional<List<PolicyAction>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.policies.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().policies().remove("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Permissions Roles
<details><summary><code>client.permissions.roles.list() -> RoleListResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().roles().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.roles.create(request) -> RoleResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().roles().create(
    CreateRoleRequest
        .builder()
        .name("Custom")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.roles.get(id) -> RoleResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().roles().get("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.roles.update(id, request) -> RoleResponseEnvelope</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().roles().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateRoleRequest
        .builder()
        .name("Custom")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.permissions.roles.remove(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.permissions().roles().remove("248df4b7-aa70-47b8-a036-33ac447e668d");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

