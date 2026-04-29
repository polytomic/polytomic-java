# Reference
## BulkSync
<details><summary><code>client.bulkSync.list() -> BulkSyncListEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists bulk syncs in the caller's organization.

Results are ordered by `updated_at` descending, with `id` as a tiebreaker for
syncs modified at the same instant. Pagination uses an opaque
`pagination.next_page_token` returned in the response; pass it back as the
`page_token` query parameter to fetch the next page. The `limit` parameter is
optional, and the default and maximum page size is 50 syncs.

> 📘 To retrieve a specific sync, use
> [`GET /api/bulk/syncs/{id}`](../../../api-reference/bulk-sync/get)
> instead of filtering the list client-side.
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

**active:** `Optional<Boolean>` — Filter to only active (true) or only paused (false) syncs. Omit to return both.
    
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

Creates a new bulk sync.

Bulk syncs are used for the ELT pattern (Extract, Load, and Transform), where you want to sync un-transformed data to your data warehouses, databases, or cloud storage buckets like S3.

All of the functionality described in [the product
documentation](https://docs.polytomic.com/docs/bulk-syncs) is configurable via
the API.

Sample code examples:

- [Bulk sync (ELT) from Salesforce to S3](../../../guides/code-examples/bulk-sync-elt-from-salesforce-to-s-3)
- [Bulk sync (ELT) from Salesforce to Snowflake](../../../guides/code-examples/bulk-sync-elt-from-salesforce-to-snowflake)
- [Bulk sync (ELT) from HubSpot to PostgreSQL](../../../guides/code-examples/bulk-sync-elt-from-hub-spot-to-postgre-sql)

## Connection specific configuration

The `destination_configuration` is integration-specific configuration for the
selected bulk sync destination. This includes settings such as the output schema
and is required when creating a new sync.

The `source_configuration` is optional. It allows configuration for how
Polytomic reads data from the source connection. This will not be available for
integrations that do not support additional configuration.

Consult the [connection configurations](../../../guides/configuring-your-connections/overview)
to see configurations for particular integrations (for example, [here](../../../guides/configuring-your-connections/connections/postgre-sql#source-1) is the available source configuration for the PostgreSQL bulk sync source).

## Defaults and selection behavior

If `schemas` is omitted, the sync is created with all available source schemas
selected. Pass `schemas` explicitly if you want the initial sync to include
only a subset of tables or objects.

Schedule times are interpreted in UTC.

When omitted, automatic discovery defaults are conservative:

- `automatically_add_new_objects` defaults to not enabling newly discovered
  source objects automatically.
- `automatically_add_new_fields` defaults to enabling newly discovered fields
  on already selected objects.
- `normalize_names` defaults to enabled.
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
        .defaultSchedule(
            BulkSyncDefaultScheduleRequest
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .destinationConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .name("My Bulk Sync")
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

**active:** `Optional<Boolean>` — Whether the sync is active. Inactive syncs do not run on their schedule but can still be triggered manually.
    
</dd>
</dl>

<dl>
<dd>

**additionalSchedules:** `Optional<List<BulkSyncAdditionalScheduleRequest>>` — Additional bulk sync schedules. Schedule times are interpreted in UTC.
    
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

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` — Global cutoff applied across schemas. Source records older than this timestamp are excluded from sync runs.
    
</dd>
</dl>

<dl>
<dd>

**defaultSchedule:** `BulkSyncDefaultScheduleRequest` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConfiguration:** `Map<String, Object>` — Destination-specific bulk sync configuration (e.g. output schema name, file format). The accepted keys depend on the destination connection type.
    
</dd>
</dl>

<dl>
<dd>

**destinationConnectionId:** `String` — Unique identifier of the connection rows are written to.
    
</dd>
</dl>

<dl>
<dd>

**disableRecordTimestamps:** `Optional<Boolean>` — When true, Polytomic will not add its own timestamp columns to destination rows.
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<BulkSyncTargetMode>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Human-readable name for the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**normalizeNames:** `Optional<BulkNormalizeNames>` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` — Organization the sync is created in. Only used by partner callers; normal callers always create syncs in their own organization.
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` — Identifiers of permissions policies applied to the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**resyncConcurrencyLimit:** `Optional<Integer>` — Override the default resync concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<CreateBulkSyncRequestSchemasItem>>` — List of schemas to sync; if omitted, all schemas will be selected for syncing.
    
</dd>
</dl>

<dl>
<dd>

**sourceConfiguration:** `Optional<Map<String, Object>>` — Source-specific bulk sync configuration (e.g. replication slot name, sync lookback). The accepted keys depend on the source connection type.
    
</dd>
</dl>

<dl>
<dd>

**sourceConnectionId:** `String` — Unique identifier of the connection rows are read from.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a bulk sync by ID.

The response includes the sync's top-level configuration — source, destination,
schedules, and discovery settings.

- To check whether the sync is running and see the most-recent execution result,
  use [`GET /api/bulk/syncs/{id}/status`](../../../../api-reference/bulk-sync/get-status).
- To inspect which schemas are selected and how they are configured, use
  [`GET /api/bulk/syncs/{id}/schemas`](../../../../api-reference/bulk-sync/schemas/list).
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

Updates an existing bulk sync's top-level configuration.

Updating a bulk sync is a **full replacement** of the sync's top-level
configuration. Every field in the request body is written to the sync; any
field you omit is cleared or reset to its default value.

To make a partial change — for example, toggling `active` or swapping a
schedule — fetch the current sync with
[`GET /api/bulk/syncs/{id}`](../../../../api-reference/bulk-sync/get),
modify the fields you want to change, and send the complete object back in
the update request.

Updates to `active`, `schedules`, and `policies` take effect immediately.
Changes to source or destination configuration take effect on the sync's
next execution.

Because omitted fields are reset to their defaults, the discovery and
naming options behave the same as on create when left out:

- `automatically_add_new_objects` resets to not enabling newly discovered
  source objects automatically.
- `automatically_add_new_fields` resets to enabling newly discovered
  fields on already selected objects.
- `normalize_names` resets to enabled.

Send the existing values explicitly if you want to preserve a non-default or
non-empty setting, including schema and field selections.

> 📘 Updating schemas
>
> Schema updates are not performed through this endpoint. Use the
> [Update Bulk Sync Schemas](../../../../api-reference/bulk-sync/schemas/patch)
> endpoint to change a subset of schemas, or
> [Update Bulk Sync Schema](../../../../api-reference/bulk-sync/schemas/update)
> to replace a single schema's configuration.
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
        .defaultSchedule(
            BulkSyncDefaultScheduleRequest
                .builder()
                .frequency(ScheduleFrequency.MANUAL)
                .build()
        )
        .destinationConnectionId("248df4b7-aa70-47b8-a036-33ac447e668d")
        .name("My Bulk Sync")
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

**id:** `String` — Unique identifier of the bulk sync to update.
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` — Whether the sync is active. Inactive syncs do not run on their schedule but can still be triggered manually.
    
</dd>
</dl>

<dl>
<dd>

**additionalSchedules:** `Optional<List<BulkSyncAdditionalScheduleRequest>>` — Additional bulk sync schedules. Schedule times are interpreted in UTC.
    
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

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` — Global cutoff applied across schemas. Source records older than this timestamp are excluded from sync runs.
    
</dd>
</dl>

<dl>
<dd>

**defaultSchedule:** `BulkSyncDefaultScheduleRequest` 
    
</dd>
</dl>

<dl>
<dd>

**destinationConfiguration:** `Map<String, Object>` — Destination-specific bulk sync configuration (e.g. output schema name, file format). The accepted keys depend on the destination connection type.
    
</dd>
</dl>

<dl>
<dd>

**destinationConnectionId:** `String` — Unique identifier of the connection rows are written to.
    
</dd>
</dl>

<dl>
<dd>

**disableRecordTimestamps:** `Optional<Boolean>` — When true, Polytomic will not add its own timestamp columns to destination rows.
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<BulkSyncTargetMode>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Human-readable name for the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**normalizeNames:** `Optional<BulkNormalizeNames>` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` — Organization the sync belongs to. Only used by partner callers; normal callers are always scoped to their own organization.
    
</dd>
</dl>

<dl>
<dd>

**policies:** `Optional<List<String>>` — Identifiers of permissions policies applied to the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**resyncConcurrencyLimit:** `Optional<Integer>` — Override the default resync concurrency limit for this sync.
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<UpdateBulkSyncRequestSchemasItem>>` — List of schemas to sync; if omitted, all schemas will be selected for syncing.
    
</dd>
</dl>

<dl>
<dd>

**sourceConfiguration:** `Optional<Map<String, Object>>` — Source-specific bulk sync configuration (e.g. replication slot name, sync lookback). The accepted keys depend on the source connection type.
    
</dd>
</dl>

<dl>
<dd>

**sourceConnectionId:** `String` — Unique identifier of the connection rows are read from.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a bulk sync, cancelling any running executions.

Any execution that is currently running is cancelled before the sync record is
removed.

> 🚧 All associated schedules, schema configurations, and execution history are
> deleted along with the sync.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sets whether a bulk sync is active.

Only active syncs are eligible to execute on their configured schedule.
Deactivating a sync prevents future scheduled runs and requests cancellation of
any execution that is currently in progress.

> 📘 To start or stop a running execution directly, use
> [`POST /api/bulk/syncs/{id}/executions`](../../../../../api-reference/bulk-sync/start)
> or
> [`POST /api/bulk/syncs/{id}/cancel`](../../../../../api-reference/bulk-sync/cancel).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation of any running executions on a bulk sync.

Cancellation is asynchronous. A successful response means the cancellation
signal has been queued; the running execution continues until the signal is
processed. Poll `GET /api/bulk/syncs/{id}/status` until the current execution
reaches a terminal state (`completed`, `canceled`, or `failed`) to confirm
cancellation has taken effect.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Starts a new execution of a bulk sync.

This endpoint returns the execution record immediately after the run is queued
or started. Use the execution ID with the bulk-sync execution endpoints if you
need to monitor progress in detail.

## Execution modes

- Set `test=true` to validate the sync without writing to the destination.
- Use `resync_mode` for destructive or full-refresh style reruns.
- `test` and `resync_mode` are mutually exclusive.

The legacy `resync` boolean is no longer accepted on this v5 endpoint. Send
`resync_mode` instead.

If another execution is already running, the endpoint returns `409 Conflict`.
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**fetchMode:** `Optional<BulkFetchMode>` 
    
</dd>
</dl>

<dl>
<dd>

**resyncMode:** `Optional<BulkResyncMode>` 
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<String>>` — Optional list of schema IDs to include in this execution. If empty, all enabled schemas are included.
    
</dd>
</dl>

<dl>
<dd>

**test:** `Optional<Boolean>` — When true, runs a test execution that validates the configuration without writing to the destination. Mutually exclusive with resync_mode.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the current status of a bulk sync.

The response includes the sync's current active/inactive state together with
information about the most recent execution — its status, start time, and any
errors — making this endpoint well-suited for health checks and monitoring
dashboards.

For the complete execution history, use
[`GET /api/bulk/syncs/{id}/executions`](../../../../../api-reference/bulk-sync/executions/list).
For the full details of a specific run, including per-schema breakdowns, use
[`GET /api/bulk/syncs/{id}/executions/{exec_id}`](../../../../../api-reference/bulk-sync/executions/get).
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

**id:** `String` — Unique identifier of the bulk sync.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists the schemas (tables or objects) available on a connection for use as a bulk sync source, optionally including per-schema field details.

The response reflects what the
connection currently has cached; if the upstream source has changed, trigger
a refresh first with
[`POST /api/connections/{id}/schemas/refresh`](../../../../../api-reference/schemas/refresh).

These are the schemas available for selection, not the schemas already
configured on any particular sync. To inspect schemas on a running sync, use
[`GET /api/bulk/syncs/{id}/schemas`](../../../../../api-reference/bulk-sync/schemas/list).

Pass `include_fields=true` to receive per-schema field details in a single call.
Omit it when you only need the schema list, as field enumeration can be slow for
large sources.
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**includeFields:** `Optional<Boolean>` — When true, include per-schema field lists in the response. Set to false for a smaller payload when field details are not needed.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Describes the destination configuration schema a connection accepts when used as a bulk sync destination.

The response is a JSON Schema object describing the shape of the
`destination_configuration` field you must supply when
[creating](../../../../../api-reference/bulk-sync/create) or
[updating](../../../../../api-reference/bulk-sync/update) a bulk sync that uses this
connection as its destination. Required fields vary by connection type.

> 📘 Fetch this endpoint once per connection type rather than once per sync.
> The configuration schema is the same for all syncs sharing the same
> destination connection.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all connection types supported by this deployment.

Each entry includes per-type metadata:

- The available operations the connection type supports.
- Its category.
- Whether the connection type is enabled for the caller's organization.
- Which modes (source, destination, enrichment) it can act as.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the JSON schema for a connection type.

This schema is intended for building forms or validating configuration payloads
client-side. It describes the structure Polytomic expects when you create or
update a connection of the given type.

The response is metadata about the shape of the configuration, not a live
connection instance and not a set of current credential values.
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

**id:** `String` — Connection type identifier (e.g. postgresql, salesforce, hubspot).
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns completion values for parameter fields on a connection type.

This endpoint is useful during connection setup, before a connection exists or
before you want to persist it. The supplied `parameters` are applied to a
temporary in-memory connection shape and used to resolve dependent options.

When an endpoint requires upstream authorization before it can return values,
Polytomic returns an error instead of guessing. In that case, complete the
authorization flow first and call the endpoint again.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists every connection in the caller's organization, with sensitive fields redacted.

Sensitive configuration values — passwords, API tokens, private keys — are
redacted from all responses. To understand which fields a connection type
exposes, consult the parameter schema returned by
[`GET /api/connection_types`](../../api-reference/connections/get-types).

To inspect the data objects available on a specific connection, use
[`POST /api/connections/{id}/schemas/refresh`](../../api-reference/schemas/refresh)
followed by [`GET /api/connections/{id}/schemas/status`](../../api-reference/schemas/get-status).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new connection of the specified type.

Use [`GET /api/connection_types`](../../api-reference/connections/get-types) to retrieve the
list of available types and their parameter schemas. The `configuration`
object is type-specific; consult the [integration
guides](../../guides/configuring-your-connections/overview)
for the required and optional fields for each type.

> 📘 Polytomic validates the connection against the upstream service
> immediately on creation. The request will fail if the credentials or
> endpoint cannot be reached.
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

Creates a Polytomic Connect session and returns a redirect URL that embeds the Connect modal.

See also:

- [Embedding authentication](../../../guides/embedding-authentication), a guide to using Polytomic Connect.
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

This endpoint is useful for setup flows that want to verify credentials before
persisting them.

If you provide `connection_id`, Polytomic starts from the saved configuration
for that connection and then applies the request's `configuration` values on
top. This lets callers test a partial change without resending every existing
field.

The request does not persist any configuration changes even when validation
succeeds.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single connection by ID, with sensitive fields redacted.

To inspect the schemas available on this connection, trigger a refresh with
[`POST /api/connections/{id}/schemas/refresh`](../../../api-reference/schemas/refresh) and
track progress via
[`GET /api/connections/{id}/schemas/status`](../../../api-reference/schemas/get-status).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a connection's configuration.

Updating a connection is a **full replacement** of its configuration. Any
`configuration` field you omit is cleared. To make a partial change, fetch
the current connection with
[`GET /api/connections/{id}`](../../../api-reference/connections/get), apply your edits, and send the
complete object back.

> 📘 The connection is re-validated against the upstream service after every
> update. The request will fail if the new credentials or endpoint cannot be
> reached.

Syncs that are already running when the update is submitted are not
interrupted; the updated configuration takes effect on their next execution.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a connection.

> 🚧 Deleting a connection that is referenced by fieldsets, syncs, bulk
> syncs, or schedules returns `422 connection in use` unless you pass
> `force=true`. With `force=true`, the API deletes those dependent
> resources before removing the connection.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns completion values for parameter fields on a persisted connection.

Use this endpoint when the available options for one parameter depend on the
connection's saved credentials or previously selected settings. For example,
after a connection is authorized, the upstream service may be able to return
lists of databases, schemas, or similar selectable values.

For new setup flows, prefer
[`POST /api/connection_types/{type}/parameter_values`](../../../../api-reference/connections/get-type-parameter-values),
which lets you resolve completions before the connection has been created.
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

<details><summary><code>client.connections.executeProxy(id, request) -> ExecuteConnectionProxyEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Proxies an HTTP request to a connection's underlying API using the connection's stored credentials, subject to per-connection rate limits and size caps.

This endpoint is intended for controlled passthrough use, not as a general
replacement for Polytomic's modeled endpoints. The request is executed with the
connection's stored credentials and inherited base URL, headers, and query
parameters.

Before building requests dynamically, call
[`GET /api/connections/{id}/proxy/info`](../../../../api-reference/connections/get-proxy-info)
to inspect the inherited base URL, blocked headers, accepted body types, and
size and rate limits.

## Important behavior

- `request.path` must be relative and start with `/`.
- Use either `request.query` or `request.rawQuery`, not both.
- Caller-supplied headers are merged with inherited headers, but inherited auth
  headers cannot be overridden.
- The proxy strips a fixed set of request and response headers for safety.
- Response bodies larger than the configured maximum are truncated, and
  `truncated` is set to `true`.

The response includes `proxyCallId`, which you can use to correlate the call
with audit logs.
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
client.connections().executeProxy(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    ExecuteConnectionProxyRequest
        .builder()
        .request(
            ConnectionProxyCall
                .builder()
                .method("GET")
                .path("/v1/objects")
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

**id:** `String` — Unique identifier of the connection to proxy the request through.
    
</dd>
</dl>

<dl>
<dd>

**request:** `ConnectionProxyCall` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.getProxyInfo(id) -> GetConnectionProxyInfoEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the proxy contract for a connection.

Use this endpoint before calling
[`POST /api/connections/{id}/proxy`](../../../../../api-reference/connections/execute-proxy)
when you need to build requests programmatically. The response shows:

- the inherited base URL that all proxied requests are sent to
- locked headers and query parameters that are attached automatically
- blocked request and response headers
- allowed HTTP methods and body shapes
- timeout, rate-limit, and payload-size limits

Sensitive inherited header and query values are redacted in the response. The
contract is still useful for discovering which keys are fixed by the
connection, even though their raw values are not exposed.
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
client.connections().getProxyInfo("248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — Unique identifier of the connection whose proxy contract should be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.listSharedConnections(id) -> ConnectionListResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists shared copies of a connection that the caller's organization owns.

The returned connections are the child copies, not the parent connection
itself. This is useful when a partner workflow needs to confirm which
downstream organizations have already received a shared copy.

Creating a new shared copy is a separate operation. Use
[`POST /api/organizations/{org_id}/connections/{connection_id}/share`](../../../../api-reference/connections/create-shared-connection)
for the v5 partner-scoped flow.
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

**id:** `String` — Unique identifier of the parent connection whose shared copies should be listed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.listSharedConnectionsForPartner(orgId, connectionId) -> ConnectionListResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists shared copies of a connection owned by a specific organization in the partner account.

The `org_id` must match the organization that owns the parent connection. If it
does not, the endpoint returns `404` rather than exposing information about the
parent connection.

This endpoint is useful in partner workflows where the parent connection is in
the partner owner organization and the caller needs to audit which child
organizations already have a shared copy.
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
client.connections().listSharedConnectionsForPartner("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
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

**orgId:** `String` — Unique identifier of the organization that owns the parent connection.
    
</dd>
</dl>

<dl>
<dd>

**connectionId:** `String` — Unique identifier of the parent connection whose shared copies should be listed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connections.createSharedConnection(orgId, connectionId, request) -> CreateSharedConnectionResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Shares a connection with another organization in the caller's partner account.
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
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    PartnerCreateSharedConnectionRequestSchema
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

**orgId:** `String` — Unique identifier of the organization that owns the parent connection.
    
</dd>
</dl>

<dl>
<dd>

**connectionId:** `String` — Unique identifier of the parent connection to share.
    
</dd>
</dl>

<dl>
<dd>

**childOrganizationId:** `String` — Unique identifier of the child organization that should receive the shared connection.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Optional name for the shared copy. Defaults to the parent connection name.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## QueryRunner
<details><summary><code>client.queryRunner.runQuery(connectionId, request) -> RunQueryEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Submits a query for asynchronous execution against the connection.

This endpoint returns immediately with a query task ID. It does not wait for
the query to finish. Poll [`GET /api/queries/{id}`](../../../../api-reference/query-runner/get-query) until `status`
reaches `done` or `failed`.

Only the user who created the query can fetch its results later. Query results
are stored temporarily and may expire; use the `expires` field from the result
endpoint to understand how long they will remain available.
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
    RunQueryRequest
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

**connectionId:** `String` — Unique identifier of the connection to run the query against.
    
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

<details><summary><code>client.queryRunner.getQuery(id) -> QueryResultsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetches the latest status for a submitted query and, once complete, returns fields and paginated results.

This endpoint is the second step of the query-runner flow. First call
[`POST /api/connections/{connection_id}/query`](../../../api-reference/query-runner/run-query),
then poll this endpoint with the returned ID.

Results may be paginated across multiple blobs. When that happens, use the
opaque `links.next` and `links.previous` URLs exactly as returned. Do not try to
construct the `page` token yourself.

If the query is still running, the response may include only status metadata.
If the task is complete but the caller is not the same user that created it,
the endpoint returns `404`.
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

**id:** `String` — Unique identifier of the query task, as returned by POST /api/connections/{connection_id}/query.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<String>` — Opaque pagination token returned in the links.next or links.previous URL of the previous response.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates or updates user-defined fields on a schema, matched by field_id.

Fields are matched by `field_id`. Reusing an existing `field_id` updates that
field; using a new `field_id` creates a new user-defined field.

This makes the endpoint safe to retry when you are intentionally upserting the
same field definitions. It is not a patch-by-position operation.

If some fields succeed and others fail, the endpoint can return a partial
success response. Validate the response status and message rather than assuming
the whole batch was applied uniformly.
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

**connectionId:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema the fields belong to.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<UserFieldRequest>>` — Fields to create or update on the schema. Existing user-defined fields with the same field_id are replaced.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Removes a user-defined field from a schema.

Only user-defined fields — those created via
[`POST /api/connections/{connection_id}/schemas/{schema_id}/fields`](../../../../../../../api-reference/schemas/upsert-field)
— can be removed through this endpoint. Fields detected automatically from
the source cannot be deleted here; they are managed through schema refresh.

> 🚧 Deleting a field that is referenced in an active sync mapping may cause
> that sync to error on its next execution. Remove or update any dependent
> mappings before deleting the field.
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

**connectionId:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema the field belongs to.
    
</dd>
</dl>

<dl>
<dd>

**fieldId:** `String` — Identifier of the user-defined field to delete.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Overrides the primary key detected on a schema.

This is a full replacement: the keys you supply become the complete override
set, replacing any previously configured overrides. Omitting a key that was
previously set removes it.

Primary key overrides are useful when the source does not expose a primary
key or when the source-detected key is not the correct deduplication
identifier for your use case.

> 📘 To revert to the source-detected primary keys and remove all overrides,
> use [`DELETE /api/connections/{connection_id}/schemas/{schema_id}/primary_keys`](../../../../../../api-reference/schemas/reset-primary-keys).
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

**connectionId:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema whose primary keys are being overridden.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<SchemaPrimaryKeyOverrideInput>>` — Ordered list of source fields that together form the primary key. Replaces any existing override; supply an empty list to clear.
    
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

Deletes all primary key overrides for a schema, reverting to the primary keys detected from the source.

To replace the overrides with a new set rather than clearing them entirely,
use [`PUT /api/connections/{connection_id}/schemas/{schema_id}/primary_keys`](../../../../../../api-reference/schemas/set-primary-keys)
instead.
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

**connectionId:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema whose primary key override should be cleared.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Refreshes a connection's cached schemas.

Call this when the upstream source has added, removed, or changed tables,
objects, or fields and you need Polytomic to re-inspect the connection before
creating or updating sync configuration.

This endpoint does not return the refreshed schemas directly. Follow the
`Location` header or poll [`GET /api/connections/{id}/schemas/status`](../../../../../api-reference/schemas/get-status)
until the refresh completes, then fetch the schemas you need.

> 📘 Schema refresh is asynchronous
>
> This endpoint kicks off a background refresh of the connection's cached
> schemas and returns a `Location` header pointing at
> [`GET /api/connections/{id}/schemas/status`](../../../../../api-reference/schemas/get-status).
> Poll that endpoint until `cache_status` transitions from `refreshing` to
> `fresh` (or until `last_refresh_finished` advances past
> `last_refresh_started`) to observe completion.
>
> Only connections whose current health status is healthy may be refreshed.
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

**id:** `String` — Unique identifier of the connection whose schema cache should be refreshed.
    
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

Returns the current schema inspection status for a connection.

Poll this endpoint after calling
[`POST /api/connections/{id}/schemas/refresh`](../../../../../api-reference/schemas/refresh) to track
progress. When `status` transitions to `completed`, the refreshed schemas
are available for use in sync configuration.

> 📘 Schema refresh is asynchronous
>
> This endpoint kicks off a background refresh of the connection's cached
> schemas and returns a `Location` header pointing at
> [`GET /api/connections/{id}/schemas/status`](../../../../../api-reference/schemas/get-status).
> Poll that endpoint until `cache_status` transitions from `refreshing` to
> `fresh` (or until `last_refresh_finished` advances past
> `last_refresh_started`) to observe completion.
>
> Only connections whose current health status is healthy may be refreshed.
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

**id:** `String` — Unique identifier of the connection whose schema cache status should be returned.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single schema on a connection.

The schema is returned from the connection's cached schema set. If the
upstream source has changed since the last inspection, the result may be
stale.

> 📘 Trigger [`POST /api/connections/{id}/schemas/refresh`](../../../../../api-reference/schemas/refresh)
> and wait for it to complete before fetching this endpoint if you need
> up-to-date field definitions.
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema within the connection. Format depends on the connection type (e.g. schema.table for databases, object name for SaaS backends).
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a sample of records from a schema on a connection.

The sample is intended for previewing the shape and values of data before
committing to a sync configuration, not for full data export.

> 🚧 The sample is not guaranteed to be representative of the full dataset.
> Row selection is implementation-defined and may differ across connection
> types.

> 📘 If the schema's field definitions are stale, refresh them first with
> [`POST /api/connections/{id}/schemas/refresh`](../../../../../../api-reference/schemas/refresh) to ensure
> the sample aligns with the current schema structure.
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Identifier of the schema within the connection.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Models
<details><summary><code>client.models.getEnrichmentSource(id) -> GetSyncSourceMetaEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Describes the enrichment source configuration available on a connection.

Not all connections support enrichment. Call this endpoint to determine
whether a connection can serve as an enrichment source in a model sync and,
if so, what configuration it accepts.

> ⚠️ If the connection does not support enrichment, this endpoint returns
> `404`. Check for that status before attempting to configure an enrichment
> source on a sync.

When a connection does support enrichment, the response describes the
configuration fields required to set it up. Pass those values in the
`enrichment` block when creating or updating a model sync.
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` — Query parameters used to incrementally refine a dependent source configuration. Keys correspond to configuration fields returned by previous calls to this endpoint.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.post(connectionId, request) -> GetEnrichmentInputFieldsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the valid input field sets for an enrichment configuration on a connection.

When configuring an enrichment source in a model sync, use this endpoint to
discover which input fields the enrichment connection requires. Pass the
proposed enrichment configuration in the request body; the response lists the
valid input field sets that map your model's fields to the enrichment service's
expected inputs.
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
    EnrichmentInputFieldsRequest
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Submits a job that previews the fields a model would expose without persisting it.

The response contains a job ID that resolves to the list of fields the model
would expose. Poll the job until it completes to retrieve the field list. The
model is not persisted — this endpoint is useful for validating a query or
configuration before calling [`POST /api/models`](../../api-reference/models/create) to save it.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all models in the caller's organization.

Results are ordered by `updated_at` descending, with `id` used as a tiebreaker.
If more results are available, the response includes `pagination.next_page_token`.
Pass that token back unchanged to continue from the last item you received.

The token is opaque. Do not construct or edit it yourself.

The `limit` is capped at 50. Values above that cap are reduced to 50, and
non-positive values fall back to the same default.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new model.

A model defines a query or view over a connection's data — for example, a SQL
query, a filtered object, or a joined dataset. Models are used as sources when
creating model syncs.

The connection referenced by `connection_id` must have source capabilities. Use
[`GET /api/connection_types/{id}`](../../api-reference/connections/get-connection-type-schema) to check
whether a connection type supports use as a source.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single model by ID, including its source fields, identity, and filters.

The response includes the model's source fields, identity column, and any
configured filters. To preview the data a model would return without saving
changes, use [`GET /api/models/{id}/sample`](../../../api-reference/models/sample).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a model's configuration.

Updating a model is a **full replacement** of its configuration. Every field in
the request body is written to the model; any field you omit is cleared or reset
to its default value.

To make a partial change, fetch the current model with
[`GET /api/models/{id}`](../../../api-reference/models/get), modify the fields you want to change, and send
the complete object back in the update request.

Changes to source fields, filters, or the identity column take effect on the
next sync execution that uses this model.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a model.

> 🚧 Deleting a model used by one or more syncs will break those syncs. Remove
> or reconfigure any syncs that reference this model before deleting it.
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

Returns a sample of records from a model.

Synchronous requests must complete within 10 seconds. If the source query or
enrichment step can exceed that budget, use the asynchronous option so the
work runs as a background job.
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
<details><summary><code>client.modelSync.getSource(id) -> GetSyncSourceMetaEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Describes the source configuration available on a connection for use as a model sync source.

Use this endpoint before creating a model to understand what configuration is
available. Once you have a configuration, resolve the fields available for
sync mapping with
[`GET /api/connections/{id}/modelsync/source/fields`](../../../../../api-reference/model-sync/get-source-fields).
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` — Query parameters used to incrementally refine a dependent source configuration. Keys correspond to configuration fields returned by previous calls to this endpoint.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the source fields available on a connection for a given source configuration.

Pass the model's source configuration as query parameters to resolve the
fields that the connection will expose for that specific configuration. The
returned fields are what can be referenced in sync field mappings.

> 📘 Results depend on the source configuration you supply. A different
> table or query in the configuration may return a completely different field
> list.

The available source configuration parameters are described by
[`GET /api/connections/{id}/modelsync/source`](../../../../../../api-reference/model-sync/get-source).
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**params:** `Optional<Map<String, Optional<List<String>>>>` — Source configuration, matching the params used with GET /api/connections/{id}/modelsync/source, that selects the specific source to return fields for.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.list() -> ListSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists model syncs in the caller's organization.

Results are ordered by `updated_at` descending, with `id` used as a tiebreaker.
If more results are available, the response includes `pagination.next_page_token`.
Pass that token back unchanged to continue from the last item you received.

The token is opaque. Do not construct or edit it yourself.

The `limit` is capped at 50. Values above that cap are reduced to 50, and
non-positive values fall back to the same default.

This endpoint returns syncs visible to the current caller's organization scope.
To inspect a specific sync in more detail, follow up with
[`GET /api/syncs/{id}`](../../api-reference/model-sync/get).
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
client.modelSync().list(
    ModelSyncListRequest
        .builder()
        .active(true)
        .mode(ModelsyncSyncTargetMode.CREATE)
        .targetConnectionId("0b155265-c537-44c9-9359-a3ceb468a4da")
        .pageToken("AmkYh8v0jR5B3kls2Qcc9y8MjrPmvR4CvaK7H0F4rEwqvg76K==")
        .limit(50)
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

**active:** `Optional<Boolean>` — Filter to only active or only paused syncs.
    
</dd>
</dl>

<dl>
<dd>

**mode:** `Optional<ModelsyncSyncTargetMode>` — Filter by sync target mode (e.g. create, updateOrCreate, enrich).
    
</dd>
</dl>

<dl>
<dd>

**targetConnectionId:** `Optional<String>` — Filter to syncs that write to the specified target connection.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Pagination cursor returned in the previous response. Omit on the first request.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum number of syncs to return. Default and maximum is 50.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.create(request) -> SyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new model sync.

Create a new sync from one or more models to a destination.

All of the functionality described in [the product
documentation](https://docs.polytomic.com/docs/sync-destinations) is
configurable via the API.

Guides:

- [Model sync (Reverse ETL) from Snowflake query to Salesforce](../../guides/code-examples/model-sync-reverse-etl-from-snowflake-query-to-salesforce)
- [Joined model sync from Postgres, Airtable, and Stripe to Hubspot](../../guides/code-examples/joined-model-sync-from-postgres-airtable-and-stripe-to-hubspot)

## Targets (Destinations)

Polytomic refers to a model sync's destination as the "target object", or
target. Target objects are identified by a connection ID and an object ID. You
can retrieve a list of all target objects for a connection using the [Get Target
Objects](../../api-reference/model-sync/targets/list) endpoint.

The `target` object in the request specifies information about the sync destination.

```json
"target": {
    "connection_id": "248df4b7-aa70-47b8-a036-33ac447e668d",
    "object": "Users",
},
```

Some connections support additional configuration for targets. For example,
[Salesforce
connections](../../guides/configuring-your-connections/connections/salesforce#target)
support optionally specifying the ingestion API to use. The target specific
options are passed as `configuration`; consult the [integration
guides](../../guides/configuring-your-connections/overview)
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

The [Get Target List](../../api-reference/model-sync/targets/list) endpoint returns information about whether
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
    CreateSyncRequest
        .builder()
        .mode(ModelsyncSyncTargetMode.CREATE)
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
                SyncField
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

**fields:** `List<SyncField>` — Fields to sync from source to destination.
    
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

**mode:** `ModelsyncSyncTargetMode` 
    
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

**overrideFields:** `Optional<List<SyncField>>` — Values to set in the target unconditionally.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the schedule types available when creating or updating a model sync.

Use the `type` identifiers returned by this endpoint in the `schedule` field
when creating or updating a sync via
[`POST /api/syncs`](../../../api-reference/model-sync/create) or [`PUT /api/syncs/{id}`](../../../api-reference/model-sync/update).
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
client.modelSync().getScheduleOptions();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.get(id) -> SyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single model sync by ID.

To check whether a sync is currently running or has recently completed, use
[`GET /api/syncs/{id}/status`](../../../api-reference/model-sync/get-status). For the full history of
executions, use [`GET /api/syncs/{id}/executions`](../../../api-reference/model-sync/executions/list).
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

<details><summary><code>client.modelSync.update(id, request) -> SyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a model sync's configuration.

Updating a model sync is a **full replacement** of the sync's configuration.
Every field in the request body is written to the sync; any field you omit is
cleared or reset to its default value.

To make a partial change — for example, toggling `active` or adjusting a
single field mapping — fetch the current sync with
[`GET /api/syncs/{id}`](../../../api-reference/model-sync/get),
modify the fields you want to change, and send the complete object back in
the update request.

Updates to `active`, `schedule`, and `policies` take effect immediately.
Changes to source fields, target configuration, filters, or field mappings
take effect on the sync's next execution.
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
client.modelSync().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateSyncRequest
        .builder()
        .mode(ModelsyncSyncTargetMode.CREATE)
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
                SyncField
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

**fields:** `List<SyncField>` — Fields to sync from source to destination.
    
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

**mode:** `ModelsyncSyncTargetMode` 
    
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

**overrideFields:** `Optional<List<SyncField>>` — Values to set in the target unconditionally.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a model sync, cancelling any running executions.

Deletion is permanent. Any running execution is cancelled before the sync
record is removed. Deleted syncs cannot be recovered; recreate them using
[`POST /api/syncs`](../../../api-reference/model-sync/create) if needed.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sets whether a model sync is active.

Only active syncs execute on schedule or in response to a manual trigger. Set
`active` to `false` to pause a sync without deleting it.

> 📘 Deactivating a sync does not cancel an execution that is already in
> progress. Use [`POST /api/syncs/{id}/cancel`](../../../../api-reference/model-sync/cancel) to stop a
> running execution.
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

<details><summary><code>client.modelSync.cancel(id) -> CancelSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation of any running executions on a model sync.

Cancellation is asynchronous. A successful response means the cancellation
signal has been queued; the running execution continues until the signal is
processed. Poll `GET /api/syncs/{id}/status` until the current execution
reaches a terminal state (`completed`, `canceled`, or `failed`) to confirm
cancellation has taken effect.
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

<details><summary><code>client.modelSync.start(id, request) -> StartSyncResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Starts a new execution of a model sync.

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
    StartSyncRequest
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the current status of a model sync.

The response includes a summary of the most recent execution, including its
start time, completion time, and record counts. For the complete execution
history, use [`GET /api/syncs/{id}/executions`](../../../../api-reference/model-sync/executions/list).
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

## Entities
<details><summary><code>client.entities.get(id) -> EntityResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a resolved entity by ID.

Looks up a UUID within the caller's current organization and returns the
resource type plus enough context to fetch the canonical resource.

This endpoint is useful when you have an execution, sync, model, connection,
organization, or user UUID and need to determine what it refers to.

The response always includes:

- `id`: the UUID that was resolved.
- `type`: the resolved entity type.
- `canonical_path`: the canonical REST path for the resolved resource.

The response may also include:

- `relationships`: parent resources needed to address nested resources.
- `context`: lightweight additional context, such as bulk sync `schema_ids`.

For the normal user-scoped endpoint, `organization_id` is omitted from the
response.

Supported `type` values currently include:

- `organization`
- `user`
- `connection`
- `model`
- `sync`
- `sync_execution`
- `bulk_sync`
- `bulk_sync_execution`

Examples:

- A model sync execution resolves to a `sync_execution` and includes a `sync`
  relationship.
- A bulk sync execution resolves to a `bulk_sync_execution`, includes a
  `bulk_sync` relationship, and may include `context.schema_ids`.

If the UUID does not exist, or exists outside the caller's scoped
organization, the endpoint returns `404`.
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
client.entities().get("248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — UUID of the entity to resolve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.entities.getForPartner(id) -> EntityResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a resolved entity by ID within a partner organization scope.

Looks up a UUID across organizations using partner authentication and returns
the resource type plus enough context to fetch the canonical resource.

This endpoint is intended for cross-organization partner workflows where the
caller has an arbitrary UUID and needs to discover both the resource type and
the organization it belongs to.

The response always includes:

- `id`: the UUID that was resolved.
- `type`: the resolved entity type.
- `canonical_path`: the canonical REST path for the resolved resource.
- `organization_id`: the organization that owns the resolved resource.

The response may also include:

- `relationships`: parent resources needed to address nested resources.
- `context`: lightweight additional context, such as bulk sync `schema_ids`.

Supported `type` values currently include:

- `organization`
- `user`
- `connection`
- `model`
- `sync`
- `sync_execution`
- `bulk_sync`
- `bulk_sync_execution`

Examples:

- A model sync execution resolves to a `sync_execution` and includes a `sync`
  relationship.
- A bulk sync execution resolves to a `bulk_sync_execution`, includes a
  `bulk_sync` relationship, and may include `context.schema_ids`.

If the UUID does not exist, the endpoint returns `404`.
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
client.entities().getForPartner("248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — UUID of the entity to resolve.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists audit events for the caller's organization.

Results are paginated. If more events are available, the response includes
`pagination.next_page_token`; pass that token back unchanged to continue from
the last item you received.

Filter by event type using the `event_type` query parameter. Pass one of the
identifiers returned by [`GET /api/events_types`](../../api-reference/events/get-types) to
narrow results to a specific category of activity.

> 📘 Events reflect audit activity scoped to the caller's organization.
> The log captures both user-initiated and API-initiated actions.
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

**organizationId:** `Optional<String>` — Organization to list events for. Only used by system callers; normal and partner callers are always scoped to their own organization.
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` — Filter to a single event type. Use GET /api/events_types to list valid values.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<OffsetDateTime>` — Return events created strictly after this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<OffsetDateTime>` — Return events created strictly before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum number of events to return. Default 10, maximum 100.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the set of event type identifiers supported by GET /api/events.

Use the identifiers returned here as the `event_type` filter value when calling
[`GET /api/events`](../../api-reference/events/list).
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
<details><summary><code>client.jobs.get(type, id) -> JobResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the current state of an asynchronous job.

This endpoint is used as a polling target by other asynchronous workflows such
as model preview and log export. The caller must know the job `type` and `id`
that were returned when the job was created.

If the job is still running, the response returns `status: running` and may not
include a `result` yet. Once complete, `status` becomes `done` or `failed`.

Only specific job types are supported by this endpoint. Passing an unknown
`type` returns `400`.
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
client.jobs().get("createmodel", "248df4b7-aa70-47b8-a036-33ac447e668d");
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

**type:** `String` — Job type. One of: createmodel, updatemodel, previewmodel, samplemodel, exportlogs.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — Unique identifier of the job (usually returned by whichever endpoint started the job).
    
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

Returns information about the authenticated caller and, if applicable, the organization they are scoped to.

Use this endpoint to confirm which kind of credential is being used before
calling endpoints with stricter authorization rules.

For user-scoped credentials, the response includes the resolved user and
organization details. For non-user keys, the response identifies the key class
with the corresponding boolean flags instead of impersonating a user.

This endpoint is especially useful when debugging why a request is being
accepted or rejected by endpoints that are limited to particular caller types.
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
<details><summary><code>client.notifications.getGlobalErrorSubscribers() -> GlobalErrorSubscribersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the list of email addresses subscribed to global sync error notifications for the caller's organization.

To update the subscriber list, use
[`PUT /api/notifications/global-error-subscribers`](../../../api-reference/notifications/set-global-error-subscribers).
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
client.notifications().getGlobalErrorSubscribers();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notifications.setGlobalErrorSubscribers(request) -> GlobalErrorSubscribersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Replaces the list of email addresses subscribed to global sync error notifications for the caller's organization.

This is a **full replacement** — the request body becomes the complete
subscriber list. To add or remove a single address without affecting others,
fetch the current list with
[`GET /api/notifications/global-error-subscribers`](../../../api-reference/notifications/get-global-error-subscribers), apply your change,
and send the modified list back.
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
client.notifications().setGlobalErrorSubscribers(
    GlobalErrorSubscribersRequest
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

**emails:** `Optional<List<String>>` — Email addresses to subscribe to global sync error notifications. Replaces the current subscriber list; pass an empty list to unsubscribe everyone.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organization
<details><summary><code>client.organization.getCurrent() -> OrganizationEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the organization the caller is authenticated against.

This endpoint is the safest way to discover the effective organization for a
user-scoped or organization-scoped credential. It does not let callers inspect
arbitrary organizations; it only returns the organization implied by the
credential that authenticated the request.

If you need to enumerate or look up organizations across a partner account, use
[`GET /api/organizations`](../../api-reference/organization/list) or
[`GET /api/organizations/{id}`](../../api-reference/organization/get) instead.
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
client.organization().getCurrent();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organization.list() -> OrganizationsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists every organization accessible to the calling partner, with the partner's owner organization first.

In `2025-09-18`, this endpoint is partner-scoped rather than a general
"current caller visibility" listing. The partner owner organization is returned
first, followed by child organizations.

This ordering matters for partner workflows such as shared connections, where
the parent connection must live in the partner owner organization.

If you need only the organization implied by the current credential, use
[`GET /api/organization`](../../api-reference/organization/get-current) instead.
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

Creates a new organization under the calling partner account, optionally configuring SSO or OIDC at creation time.

> 🚧 Requires partner key
>
> This endpoint is only accessible using [partner keys](../../guides/obtaining-api-keys#partner-keys).

SSO and OIDC settings supplied at creation time can be updated later via
`PUT /api/organizations/{id}`.
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

**clientId:** `Optional<String>` — OIDC client ID issued by the identity provider.
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `Optional<String>` — OIDC client secret issued by the identity provider. Write-only; never returned in responses.
    
</dd>
</dl>

<dl>
<dd>

**issuer:** `Optional<String>` — OIDC issuer URL for organizations using OpenID Connect single sign-on.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Human-readable name of the organization. Must be unique across the partner account.
    
</dd>
</dl>

<dl>
<dd>

**ssoDomain:** `Optional<String>` — Email domain used to match users to this organization during SSO sign-in.
    
</dd>
</dl>

<dl>
<dd>

**ssoOrgId:** `Optional<String>` — WorkOS organization identifier linking this organization to its SAML/SSO configuration.
    
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

Returns a single organization by ID.

> 📘 Credential scope varies by endpoint and API version
>
> Organization endpoints do not all share the same credential requirements.
> Check each endpoint's description for the caller scope that applies in that
> API version.
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

**id:** `String` — Unique identifier of the organization.
    
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

Updates an organization's name and SSO or OIDC configuration.

> 🚧 Requires partner key
>
> This endpoint is only accessible using [partner keys](../../../guides/obtaining-api-keys#partner-keys).

> 📘 SSO and OIDC configuration is replaced in full on each update. Include all
> desired settings in the request body, not just the fields you want to change.
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

**id:** `String` — Unique identifier of the organization to update.
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `Optional<String>` — OIDC client ID issued by the identity provider.
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `Optional<String>` — OIDC client secret issued by the identity provider. Write-only; never returned in responses.
    
</dd>
</dl>

<dl>
<dd>

**issuer:** `Optional<String>` — OIDC issuer URL for organizations using OpenID Connect single sign-on.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Human-readable name of the organization. Must be unique across the partner account.
    
</dd>
</dl>

<dl>
<dd>

**ssoDomain:** `Optional<String>` — Email domain used to match users to this organization during SSO sign-in.
    
</dd>
</dl>

<dl>
<dd>

**ssoOrgId:** `Optional<String>` — WorkOS organization identifier linking this organization to its SAML/SSO configuration.
    
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

Deletes an organization.

Partner callers cannot delete their own owner organization.
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

**id:** `String` — Unique identifier of the organization.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users
<details><summary><code>client.users.listCurrentOrgUsers() -> ListUsersEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists every user in the caller's current organization.

Returns user records including each user's ID, email, and assigned roles.
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
client.users().listCurrentOrgUsers();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.createCurrentOrgUser(request) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new user in the caller's current organization and assigns the requested permissions roles.

The new user receives an invitation email prompting them to set up their
account. Role assignments take effect as soon as the invitation is accepted.
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
client.users().createCurrentOrgUser(
    CurrentOrgCreateUserRequestSchema
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

**email:** `String` — Email address used to sign the user in and receive notifications.
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — Deprecated legacy role name. Use role_ids instead; setting both role and role_ids in the same request is rejected.
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` — Identifiers of the permissions roles to assign to the user. Must contain at least one entry when provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getCurrentOrgUser(id) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single user from the caller's current organization.
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
client.users().getCurrentOrgUser("248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — Unique identifier of the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.updateCurrentOrgUser(id, request) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the permissions roles assigned to a user in the caller's current organization.

Only the user's role assignments are modified. Profile information such as name
and email address is not affected by this endpoint.
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
client.users().updateCurrentOrgUser(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    CurrentOrgUpdateUserRequestSchema
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

**id:** `String` — Unique identifier of the user to update.
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — Deprecated legacy role name. Use role_ids instead.
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` — Identifiers of the permissions roles to assign to the user. Must contain at least one entry when provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.removeCurrentOrgUser(id) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a user from the caller's current organization.

> 🚧 This action is permanent. The user is immediately removed from the
> organization and loses access to all resources within it. This cannot be
> undone.
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
client.users().removeCurrentOrgUser("248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — Unique identifier of the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.list(orgId) -> ListUsersEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all users in the specified organization.

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](../../../../guides/obtaining-api-keys#partner-keys).

Returns user records including each user's ID, email, and assigned roles.
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

**orgId:** `String` — Unique identifier of the organization whose users should be listed.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new user in the specified organization and assigns the requested permissions roles.

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](../../../../guides/obtaining-api-keys#partner-keys).

The new user receives an invitation email prompting them to set up their
account. Role assignments take effect as soon as the invitation is accepted.
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

**orgId:** `String` — Unique identifier of the organization the user belongs to.
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` — Email address used to sign the user in and receive notifications.
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — Deprecated legacy role name. Use role_ids instead; setting both role and role_ids in the same request is rejected.
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` — Identifiers of the permissions roles to assign to the user. Must contain at least one entry when provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.get(orgId, id) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single user in the specified organization.

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](../../../../../guides/obtaining-api-keys#partner-keys).
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

**orgId:** `String` — Unique identifier of the organization the user belongs to.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — Unique identifier of the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.update(orgId, id, request) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a user's assigned permissions roles.

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](../../../../../guides/obtaining-api-keys#partner-keys).

Only the user's role assignments are modified. Profile information such as name
and email address is not affected by this endpoint.
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

**orgId:** `String` — Unique identifier of the organization the user belongs to.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — Unique identifier of the user to update.
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` — Email address used to sign the user in and receive notifications.
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — Deprecated legacy role name. Use role_ids instead; setting both role and role_ids in the same request is rejected.
    
</dd>
</dl>

<dl>
<dd>

**roleIds:** `Optional<List<String>>` — Identifiers of the permissions roles to assign to the user. Must contain at least one entry when provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.remove(orgId, id) -> UserEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a user from the specified organization.

> 🚧 Requires partner key
>
> User endpoints are only accessible using [partner keys](../../../../../guides/obtaining-api-keys#partner-keys).

> 🚧 This action is permanent. The user is immediately removed from the
> organization and loses access to all resources within it. This cannot be
> undone.
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

**orgId:** `String` — Unique identifier of the organization the user belongs to.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — Unique identifier of the user.
    
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

Issues a new API key for the specified user.

> 🚧 The API key value is only included in the response at creation time and
> cannot be retrieved again. Store it securely immediately after creation.
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

**orgId:** `String` — Unique identifier of the organization the user belongs to.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — Unique identifier of the user the key will be issued for.
    
</dd>
</dl>

<dl>
<dd>

**force:** `Optional<Boolean>` — If true, revoke any existing API key for the user before creating a new one.
    
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

Lists the webhooks for the caller's organization.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../guides/events) for the
> list of event types and payload shapes.
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

Creates the organization's webhook.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../guides/events) for the
> list of event types and payload shapes.
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

Returns a single webhook by ID.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../../guides/events) for the
> list of event types and payload shapes.
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

Updates an existing webhook.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../../guides/events) for the
> list of event types and payload shapes.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a webhook.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../../guides/events) for the
> list of event types and payload shapes.

Deletion is permanent. To stop delivery without losing the webhook
configuration, use
[`POST /api/webhooks/{id}/disable`](../../../api-reference/webhooks/disable) instead.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Disables a webhook without deleting it.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../../../guides/events) for the
> list of event types and payload shapes.

Events are not queued while the webhook is disabled — any activity that occurs
during the disabled period is not delivered retroactively. To resume
delivery, re-enable the webhook using
[`POST /api/webhooks/{id}/enable`](../../../../api-reference/webhooks/enable).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Re-enables a previously disabled webhook.

> 📘 One webhook per organization
>
> An organization can register a single webhook, which receives every event
> produced in that organization. See the
> [Events documentation](../../../../guides/events) for the
> list of event types and payload shapes.

Delivery resumes from the next event generated after this call. Events that
occurred while the webhook was disabled are not replayed.
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
<details><summary><code>client.bulkSync.executions.listStatus() -> ListBulkSyncExecutionsStatusEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a concise per-schema status for one or more bulk syncs.

This endpoint is a summary view, not an execution-history view. Each schema is
represented at most once with its most recent execution status, and running
executions are preferred over older terminal ones.

Use this endpoint when you want a dashboard-style answer to "what is each sync
doing now?" If you need the full execution history or a single execution's
details, use [`GET /api/bulk/syncs/{id}/executions`](../../../../api-reference/bulk-sync/executions/list) or
[`GET /api/bulk/syncs/{id}/executions/{exec_id}`](../../../../api-reference/bulk-sync/executions/get) instead.

Setting `all=true` or `active=true` ignores any explicit `sync_id` filters and
expands the request to the caller's organization scope.
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
client.bulkSync().executions().listStatus(
    ExecutionsListStatusRequest
        .builder()
        .syncId(
            Arrays.asList("248df4b7-aa70-47b8-a036-33ac447e668d")
        )
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

**all:** `Optional<Boolean>` — When true, return status for every sync in the caller's organization. Overrides any sync_id values.
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` — When true, return status only for active syncs in the caller's organization. Overrides any sync_id values.
    
</dd>
</dl>

<dl>
<dd>

**syncId:** `Optional<String>` — Return status for the specified bulk sync. Repeat the parameter to target multiple syncs. Ignored if all or active is true.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists executions for a bulk sync.

Results are ordered by start time descending by default. When more results are
available, the response includes an opaque `pagination.next_page_token`; pass it
back as the `page_token` query parameter to retrieve the next page. The `limit`
parameter is optional, and the maximum page size is 100 executions.

Use `only_terminal=true` to return only finished executions. In that mode,
executions are ordered by `updated_at` so recently completed runs appear first.

Use `ascending=true` to walk forward from the oldest execution instead of
starting with the newest execution.

For the full details of a single run — including per-schema execution status —
use [`GET /api/bulk/syncs/{id}/executions/{exec_id}`](../../../../../api-reference/bulk-sync/executions/get).
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Pagination cursor returned in the previous response. Omit on the first request.
    
</dd>
</dl>

<dl>
<dd>

**onlyTerminal:** `Optional<Boolean>` — When true, only return executions that have finished. Terminal executions are ordered by updated_at.
    
</dd>
</dl>

<dl>
<dd>

**ascending:** `Optional<Boolean>` — When true, return executions from oldest to newest. Default is newest first.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum number of executions to return. Capped at 100.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single bulk sync execution, including per-schema execution status.

The response includes a breakdown of each schema (table or object) that
participated in the execution, with its individual status, row counts, and any
error details. This makes it suitable for diagnosing partial failures where
some schemas succeeded while others did not.
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**execId:** `String` — Unique identifier of the execution.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation of a specific bulk sync execution.

Cancellation is asynchronous. A successful response means the cancellation
signal has been queued; the execution continues to run until the signal is
processed. Poll `GET /api/bulk/syncs/{id}/executions/{exec_id}` until the
execution reaches a terminal state (`completed`, `canceled`, or `failed`) to
confirm cancellation has taken effect.
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

<details><summary><code>client.bulkSync.executions.getConsoleLogs(syncId, executionId) -> ExecutionConsoleLogsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch the latest console log entries for a bulk sync execution. Returns at most the most recent 50 entries retained in Redis.
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
client.bulkSync().executions().getConsoleLogs(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "0ecd09c1-b901-4d27-9053-f0367c427254",
    ExecutionsGetConsoleLogsRequest
        .builder()
        .limit(50)
        .after("1744311099250-0")
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

**limit:** `Optional<Integer>` — Maximum number of entries to return. Values above the logger retention limit are capped to 50.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — Return only entries newer than this cursor.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.getLogs(syncId, executionId) -> BulkSyncExecutionLogsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns signed URLs for the log files produced by a single bulk sync execution.

Each URL in the response is pre-signed and grants temporary read access to the
corresponding log file. URLs expire after a short period; if you need to access
a file after the URL has expired, call this endpoint again to obtain a fresh set
of signed URLs.

> 📘 To export logs asynchronously to a destination of your choice, use
> [`POST /api/bulk/syncs/{sync_id}/executions/{execution_id}/logs/export`](../../../../../../../api-reference/bulk-sync/executions/export-logs)
> instead.
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

**syncId:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**executionId:** `String` — Unique identifier of the execution whose log files should be listed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.executions.exportLogs(syncId, executionId) -> ExportSyncLogsEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Starts an asynchronous job that packages the log files for a single bulk sync execution into a downloadable archive.

> 📘 Log export is asynchronous
>
> This endpoint starts a background job that packages an execution's log
> files into a downloadable archive. The first call typically returns a
> `job` descriptor instead of a completed result. Poll
> [`GET /api/jobs/exportlogs/{id}`](../../../../../../../../api-reference/jobs/get)
> with the returned `job_id` until `status` is `done`; the final response
> contains a signed `url` that can be used to download the archive.
>
> Set `notify=true` to also email the requesting user when the archive is
> ready.
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

**syncId:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**executionId:** `String` — Unique identifier of the execution whose logs should be exported.
    
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

<details><summary><code>client.bulkSync.executions.getSchemaConsoleLogs(syncId, executionId, schemaId) -> ExecutionConsoleLogsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch the latest console log entries for a schema within a bulk sync execution. Returns at most the most recent 50 entries retained in Redis.
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
client.bulkSync().executions().getSchemaConsoleLogs(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "0ecd09c1-b901-4d27-9053-f0367c427254",
    "users",
    ExecutionsGetSchemaConsoleLogsRequest
        .builder()
        .limit(50)
        .after("1744311099250-0")
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

**schemaId:** `String` — Schema identifier for schema-scoped console logs.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum number of entries to return. Values above the logger retention limit are capped to 50.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — Return only entries newer than this cursor.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BulkSync Schemas
<details><summary><code>client.bulkSync.schemas.list(id) -> ListBulkSchemaEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists the schemas (tables, objects) configured for a bulk sync.

This endpoint returns the schemas that have been added to and configured on this
specific bulk sync — not the full set of schemas available from the source
connection. To discover what the source connection exposes, use the source
schemas endpoint for the relevant connection type.

Each schema in the response includes its sync mode, field selections, and any
custom configuration applied via
[`PATCH /api/bulk/syncs/{id}/schemas`](../../../../../api-reference/bulk-sync/schemas/patch)
or
[`PUT /api/bulk/syncs/{id}/schemas/{schema_id}`](../../../../../api-reference/bulk-sync/schemas/update).
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<Map<String, Optional<String>>>` — Optional filters applied to the returned schemas. Supports enabled=true to return only enabled schemas and enabled=false to return only disabled schemas.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bulkSync.schemas.patch(id, request) -> UpdateBulkSyncSchemasEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Patches one or more schemas on a bulk sync at once.

Only schemas explicitly included in the request body are modified; schemas
omitted from the request are left unchanged. This makes PATCH the right choice
when you want to update a subset of tables without affecting the rest of the
sync's schema configuration.

Within each provided schema, omitting `fields` enables all available fields on
that schema. To control which fields are enabled, include the `fields` array
with explicit `enabled` values for each field.

> 📘 To replace a single schema's configuration in full (clearing any fields you
> omit), use
> [`PUT /api/bulk/syncs/{id}/schemas/{schema_id}`](../../../../../api-reference/bulk-sync/schemas/update)
> instead.
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
client.bulkSync().schemas().patch(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateBulkSyncSchemasRequest
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**schemas:** `Optional<List<BulkSchema>>` — Schemas to patch. Schemas are matched by id; only schemas present in this list are updated.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the configuration of a single schema on a bulk sync.

Returns the sync mode, field selections, and any other configuration applied to
this schema on the bulk sync.

To modify the configuration, use
[`PATCH /api/bulk/syncs/{id}/schemas`](../../../../../../api-reference/bulk-sync/schemas/patch)
for a partial update across multiple schemas, or
[`PUT /api/bulk/syncs/{id}/schemas/{schema_id}`](../../../../../../api-reference/bulk-sync/schemas/update)
to fully replace this schema's configuration.
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Source-side schema identifier.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Replaces the configuration of a single schema on a bulk sync.

This is a full replacement: every field in the request body is written to the
schema, and any field you omit is cleared or reset to its default. Fetch the
current configuration with
[`GET /api/bulk/syncs/{id}/schemas/{schema_id}`](../../../../../../api-reference/bulk-sync/schemas/get)
first if you want to preserve existing settings while changing only a subset.

Omitting `fields` enables all available fields on the schema. To control which
fields are enabled, include the `fields` array with explicit `enabled` values.

> 📘 To update multiple schemas in a single request without affecting others,
> use the partial-update endpoint
> [`PATCH /api/bulk/syncs/{id}/schemas`](../../../../../../api-reference/bulk-sync/schemas/patch)
> instead.
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

**id:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**schemaId:** `String` — Source-side schema identifier.
    
</dd>
</dl>

<dl>
<dd>

**dataCutoffTimestamp:** `Optional<OffsetDateTime>` — Per-schema cutoff. Records older than this timestamp are excluded from sync runs.
    
</dd>
</dl>

<dl>
<dd>

**disableDataCutoff:** `Optional<Boolean>` — When true, the sync ignores any configured data_cutoff_timestamp for this schema.
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` — Whether this schema is included in sync runs.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<UpdateBulkField>>` — Field-level configuration. Supplying an empty list enables every field discovered on the source.
    
</dd>
</dl>

<dl>
<dd>

**filters:** `Optional<List<BulkFilter>>` — Row-level filters applied when reading from the source.
    
</dd>
</dl>

<dl>
<dd>

**partitionKey:** `Optional<String>` — Source field used to partition rows when writing to the destination.
    
</dd>
</dl>

<dl>
<dd>

**trackingField:** `Optional<String>` — Source field used to detect changes between incremental sync runs.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation of any running executions for a specific schema on a bulk sync.

Cancellation is asynchronous. A successful response means the cancellation
signal for this schema has been queued; the schema's in-flight work continues
until the signal is processed. Poll
`GET /api/bulk/syncs/{id}/schemas/{schema_id}` and the parent execution via
`GET /api/bulk/syncs/{id}/status` to confirm the schema has reached a terminal
state.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all schedules configured for a bulk sync.

A bulk sync can have multiple schedules attached; this endpoint returns all
of them. Schedule times are returned in UTC.
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

**syncId:** `String` — Unique identifier of the bulk sync whose schedules should be returned.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Adds a new schedule to a bulk sync.

A bulk sync can have multiple schedules attached; adding one here does not
replace existing schedules. Schedule times are interpreted in UTC.

Creating a schedule only affects future automatic executions. To run the
sync immediately, call
[`POST /api/bulk/syncs/{id}/executions`](../../../../../api-reference/bulk-sync/start).
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
client.bulkSync().schedules().create(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    CreateScheduleRequest
        .builder()
        .schedule(
            BulkSyncScheduleApi
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

**syncId:** `String` — Unique identifier of the bulk sync to add a schedule to.
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `BulkSyncScheduleApi` 
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single schedule configured on a bulk sync.

Schedule times are returned in UTC.

To see all schedules on this sync, use
[`GET /api/bulk/syncs/{sync_id}/schedules`](../../../../../../api-reference/bulk-sync/schedules/list).
To update the schedule, use
[`PUT /api/bulk/syncs/{sync_id}/schedules/{schedule_id}`](../../../../../../api-reference/bulk-sync/schedules/update).
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

**syncId:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` — Unique identifier of the schedule.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an existing schedule on a bulk sync.

Updates replace the stored schedule. Send the full schedule definition
rather than only the field you want to change. Schedule times are
interpreted in UTC.
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
client.bulkSync().schedules().update(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    UpdateScheduleRequest
        .builder()
        .schedule(
            BulkSyncScheduleApi
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

**syncId:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` — Unique identifier of the schedule to update.
    
</dd>
</dl>

<dl>
<dd>

**schedule:** `BulkSyncScheduleApi` 
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Removes a schedule from a bulk sync.

Deleting a schedule only stops future automatic executions. It does not
cancel an execution that is already running.
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

**syncId:** `String` — Unique identifier of the bulk sync.
    
</dd>
</dl>

<dl>
<dd>

**scheduleId:** `String` — Unique identifier of the schedule to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ModelSync Targets
<details><summary><code>client.modelSync.targets.getTargetFields(id) -> TargetResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the fields of a specific target object on a connection.

Pass the target object identifier to retrieve the fields available for
mapping on that object. These are the destination fields you can reference
when configuring field mappings in a model sync.

> 📘 To list available target objects and their identifiers, use
> [`GET /api/connections/{id}/modelsync/targetobjects`](../../../../../../api-reference/model-sync/targets/list).

Fields returned here reflect the connection's current cached state. If the
upstream object schema has changed, trigger a schema refresh with
[`POST /api/connections/{id}/schemas/refresh`](../../../../../../api-reference/schemas/refresh)
before calling this endpoint.
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

**id:** `String` — Unique identifier of the connection.
    
</dd>
</dl>

<dl>
<dd>

**target:** `String` — Identifier of the target object (e.g. schema.table for a database destination, object name for a SaaS destination).
    
</dd>
</dl>

<dl>
<dd>

**refresh:** `Optional<Boolean>` — When true, force a cache refresh of the target's schema before returning its fields.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.targets.list(id) -> TargetObjectsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists the target objects available on a connection for use as a model sync destination.

If the connection supports creating new destinations, the `target_creation`
object will contain information on what properties are required to create the
target.

Target creation properties are all string values; the `enum` flag indicates if
the property has a fixed set of valid values. When `enum` is `true`, the [Target
Creation Property
Values](../../../../../api-reference/model-sync/targets/get-create-property)
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

<details><summary><code>client.modelSync.targets.getCreateProperty(id, property) -> TargetPropertyValuesEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the valid values for a target-creation property on a connection that supports creating new target objects.

Connections which support creating new sync target objects (destinations) will
return `target_creation` with their [target object list](../../../../../../../api-reference/model-sync/targets/list). This endpoint
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
sync](../../../../../../../api-reference/model-sync/create).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists executions for a model sync.

Results are ordered by start time descending. If more results are available, the
response includes `pagination.next_page_token`; pass that token back unchanged
to continue paging.

The token is opaque. Do not construct or edit it yourself.

For full details about a specific execution — including record counts and error
summaries — use
[`GET /api/syncs/{sync_id}/executions/{id}`](../../../../api-reference/model-sync/executions/get).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single model sync execution.

For the log files produced by this execution, use
[`GET /api/syncs/{sync_id}/executions/{id}/{type}`](../../../../../api-reference/model-sync/executions/get-log-urls) to retrieve
signed URLs grouped by log category.
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

<details><summary><code>client.modelSync.executions.cancel(syncId, id) -> CancelSyncExecutionResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation of a model sync execution.
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
client.modelSync().executions().cancel("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d");
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

**id:** `String` — The ID of the execution to cancel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.modelSync.executions.getConsoleLogs(syncId, id) -> ExecutionConsoleLogsResponseEnvelope</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch the latest console log entries for a sync execution. Returns at most the most recent 50 entries retained in Redis.
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
client.modelSync().executions().getConsoleLogs(
    "248df4b7-aa70-47b8-a036-33ac447e668d",
    "0ecd09c1-b901-4d27-9053-f0367c427254",
    ExecutionsGetConsoleLogsRequest
        .builder()
        .limit(50)
        .after("1744311099250-0")
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

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum number of entries to return. Values above the logger retention limit are capped to 50.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — Return only entries newer than this cursor.
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns signed URLs for every log file of a given type on a model sync execution.

`{type}` identifies the log category, such as `errors` or `warnings`. The
response contains a signed URL for each log file in that category.

> 🚧 Signed URLs expire after a short period. If a URL has expired, re-request
> it from this endpoint. To fetch a single file's URL directly, use
> [`GET /api/syncs/{sync_id}/executions/{id}/{type}/{filename}`](../../../../../../api-reference/model-sync/executions/get-logs).
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
client.modelSync().executions().getLogUrls("248df4b7-aa70-47b8-a036-33ac447e668d", "248df4b7-aa70-47b8-a036-33ac447e668d", ExecutionLogType.RECORDS);
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

**type:** `ExecutionLogType` 
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a signed URL for a specific log file produced by a model sync execution.

The URL is signed and expires after a short period. If it has expired before
you download the file, call this endpoint again to obtain a fresh URL.
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
client.modelSync().executions().getLogs("248df4b7-aa70-47b8-a036-33ac447e668d", "0ecd09c1-b901-4d27-9053-f0367c427254", ExecutionLogType.RECORDS, "file.json");
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

**type:** `ExecutionLogType` 
    
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all policies in the caller's organization.

Each policy binds one or more roles to a set of resources, controlling what
actions members with those roles can perform on those resources.

To inspect a specific policy in detail, use
[`GET /api/permissions/policies/{id}`](../../../api-reference/permissions/policies/get).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new policy.

A policy binds one or more roles to a set of resources, granting members who
hold those roles the actions defined by them. Roles must already exist before
they are referenced in a policy; create roles using
[`POST /api/permissions/roles`](../../../api-reference/permissions/roles/create).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single policy by ID, including all action/role bindings it defines.

Returns the full set of action/role bindings defined by the policy, including
the resources it applies to.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an existing policy.

The update is a **full replacement** of the policy's bindings. Any role or
resource binding not included in the request body is removed. To make a
partial change, fetch the current policy with
[`GET /api/permissions/policies/{id}`](../../../../api-reference/permissions/policies/get), modify the relevant bindings,
and send the complete object back.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a policy.

Deletion is permanent. Any access that was granted solely through this policy
is revoked immediately for all users who depended on it.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all permissions roles available in the caller's organization, including built-in system roles.

System roles such as Admin and Member are always present in every organization
and cannot be modified or deleted. Custom roles appear alongside them and can
be created, updated, or removed as needed.

To inspect or modify a specific role, use
[`GET /api/permissions/roles/{id}`](../../../api-reference/permissions/roles/get).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new permissions role.

Provide a `name` for the new role. The role is immediately available for use
in permission policies.

To attach the role to resources, create or update a policy using
[`POST /api/permissions/policies`](../../../api-reference/permissions/policies/create).
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single permissions role by ID.

Returns the role's name, action set, and whether it is a built-in system role.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an existing permissions role's name and action set.

The update is a **full replacement** of the role definition.

> 🚧 Built-in system roles (such as Admin and Member) cannot be updated.
> Attempting to modify a system role returns an error.
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

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a permissions role.

> 🚧 Built-in system roles (such as Admin and Member) cannot be deleted.
> Attempting to delete a system role returns an error.

Deleting a role does not automatically remove it from any policies that
reference it. Update those policies separately using
[`PUT /api/permissions/policies/{id}`](../../../../api-reference/permissions/policies/update) to avoid
leaving stale role references.
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

