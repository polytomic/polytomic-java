/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.resources.bulksync.types.V2CreateBulkSyncRequestSchemasItem;
import com.polytomic.api.types.BulkDiscover;
import com.polytomic.api.types.BulkSchedule;
import com.polytomic.api.types.SyncMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateBulkSyncRequest.Builder.class)
public final class CreateBulkSyncRequest {
    private final Optional<Boolean> active;

    private final Optional<BulkDiscover> automaticallyAddNewFields;

    private final Optional<BulkDiscover> automaticallyAddNewObjects;

    private final Optional<Map<String, Object>> destinationConfiguration;

    private final String destinationConnectionId;

    private final Optional<Boolean> disableRecordTimestamps;

    private final Optional<Boolean> discover;

    private final Optional<SyncMode> mode;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final BulkSchedule schedule;

    private final Optional<List<V2CreateBulkSyncRequestSchemasItem>> schemas;

    private final Optional<Map<String, Object>> sourceConfiguration;

    private final String sourceConnectionId;

    private final Map<String, Object> additionalProperties;

    private CreateBulkSyncRequest(
            Optional<Boolean> active,
            Optional<BulkDiscover> automaticallyAddNewFields,
            Optional<BulkDiscover> automaticallyAddNewObjects,
            Optional<Map<String, Object>> destinationConfiguration,
            String destinationConnectionId,
            Optional<Boolean> disableRecordTimestamps,
            Optional<Boolean> discover,
            Optional<SyncMode> mode,
            String name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            BulkSchedule schedule,
            Optional<List<V2CreateBulkSyncRequestSchemasItem>> schemas,
            Optional<Map<String, Object>> sourceConfiguration,
            String sourceConnectionId,
            Map<String, Object> additionalProperties) {
        this.active = active;
        this.automaticallyAddNewFields = automaticallyAddNewFields;
        this.automaticallyAddNewObjects = automaticallyAddNewObjects;
        this.destinationConfiguration = destinationConfiguration;
        this.destinationConnectionId = destinationConnectionId;
        this.disableRecordTimestamps = disableRecordTimestamps;
        this.discover = discover;
        this.mode = mode;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.schedule = schedule;
        this.schemas = schemas;
        this.sourceConfiguration = sourceConfiguration;
        this.sourceConnectionId = sourceConnectionId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    @JsonProperty("automatically_add_new_fields")
    public Optional<BulkDiscover> getAutomaticallyAddNewFields() {
        return automaticallyAddNewFields;
    }

    @JsonProperty("automatically_add_new_objects")
    public Optional<BulkDiscover> getAutomaticallyAddNewObjects() {
        return automaticallyAddNewObjects;
    }

    @JsonProperty("destination_configuration")
    public Optional<Map<String, Object>> getDestinationConfiguration() {
        return destinationConfiguration;
    }

    @JsonProperty("destination_connection_id")
    public String getDestinationConnectionId() {
        return destinationConnectionId;
    }

    @JsonProperty("disable_record_timestamps")
    public Optional<Boolean> getDisableRecordTimestamps() {
        return disableRecordTimestamps;
    }

    /**
     * @return DEPRECATED: Use automatically_add_new_objects/automatically_add_new_fields instead
     */
    @JsonProperty("discover")
    public Optional<Boolean> getDiscover() {
        return discover;
    }

    @JsonProperty("mode")
    public Optional<SyncMode> getMode() {
        return mode;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("policies")
    public Optional<List<String>> getPolicies() {
        return policies;
    }

    @JsonProperty("schedule")
    public BulkSchedule getSchedule() {
        return schedule;
    }

    /**
     * @return List of schemas to sync; if omitted, all schemas will be selected for syncing.
     */
    @JsonProperty("schemas")
    public Optional<List<V2CreateBulkSyncRequestSchemasItem>> getSchemas() {
        return schemas;
    }

    @JsonProperty("source_configuration")
    public Optional<Map<String, Object>> getSourceConfiguration() {
        return sourceConfiguration;
    }

    @JsonProperty("source_connection_id")
    public String getSourceConnectionId() {
        return sourceConnectionId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateBulkSyncRequest && equalTo((CreateBulkSyncRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateBulkSyncRequest other) {
        return active.equals(other.active)
                && automaticallyAddNewFields.equals(other.automaticallyAddNewFields)
                && automaticallyAddNewObjects.equals(other.automaticallyAddNewObjects)
                && destinationConfiguration.equals(other.destinationConfiguration)
                && destinationConnectionId.equals(other.destinationConnectionId)
                && disableRecordTimestamps.equals(other.disableRecordTimestamps)
                && discover.equals(other.discover)
                && mode.equals(other.mode)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && schedule.equals(other.schedule)
                && schemas.equals(other.schemas)
                && sourceConfiguration.equals(other.sourceConfiguration)
                && sourceConnectionId.equals(other.sourceConnectionId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.active,
                this.automaticallyAddNewFields,
                this.automaticallyAddNewObjects,
                this.destinationConfiguration,
                this.destinationConnectionId,
                this.disableRecordTimestamps,
                this.discover,
                this.mode,
                this.name,
                this.organizationId,
                this.policies,
                this.schedule,
                this.schemas,
                this.sourceConfiguration,
                this.sourceConnectionId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DestinationConnectionIdStage builder() {
        return new Builder();
    }

    public interface DestinationConnectionIdStage {
        NameStage destinationConnectionId(String destinationConnectionId);

        Builder from(CreateBulkSyncRequest other);
    }

    public interface NameStage {
        ScheduleStage name(String name);
    }

    public interface ScheduleStage {
        SourceConnectionIdStage schedule(BulkSchedule schedule);
    }

    public interface SourceConnectionIdStage {
        _FinalStage sourceConnectionId(String sourceConnectionId);
    }

    public interface _FinalStage {
        CreateBulkSyncRequest build();

        _FinalStage active(Optional<Boolean> active);

        _FinalStage active(Boolean active);

        _FinalStage automaticallyAddNewFields(Optional<BulkDiscover> automaticallyAddNewFields);

        _FinalStage automaticallyAddNewFields(BulkDiscover automaticallyAddNewFields);

        _FinalStage automaticallyAddNewObjects(Optional<BulkDiscover> automaticallyAddNewObjects);

        _FinalStage automaticallyAddNewObjects(BulkDiscover automaticallyAddNewObjects);

        _FinalStage destinationConfiguration(Optional<Map<String, Object>> destinationConfiguration);

        _FinalStage destinationConfiguration(Map<String, Object> destinationConfiguration);

        _FinalStage disableRecordTimestamps(Optional<Boolean> disableRecordTimestamps);

        _FinalStage disableRecordTimestamps(Boolean disableRecordTimestamps);

        _FinalStage discover(Optional<Boolean> discover);

        _FinalStage discover(Boolean discover);

        _FinalStage mode(Optional<SyncMode> mode);

        _FinalStage mode(SyncMode mode);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage policies(Optional<List<String>> policies);

        _FinalStage policies(List<String> policies);

        _FinalStage schemas(Optional<List<V2CreateBulkSyncRequestSchemasItem>> schemas);

        _FinalStage schemas(List<V2CreateBulkSyncRequestSchemasItem> schemas);

        _FinalStage sourceConfiguration(Optional<Map<String, Object>> sourceConfiguration);

        _FinalStage sourceConfiguration(Map<String, Object> sourceConfiguration);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements DestinationConnectionIdStage, NameStage, ScheduleStage, SourceConnectionIdStage, _FinalStage {
        private String destinationConnectionId;

        private String name;

        private BulkSchedule schedule;

        private String sourceConnectionId;

        private Optional<Map<String, Object>> sourceConfiguration = Optional.empty();

        private Optional<List<V2CreateBulkSyncRequestSchemasItem>> schemas = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<SyncMode> mode = Optional.empty();

        private Optional<Boolean> discover = Optional.empty();

        private Optional<Boolean> disableRecordTimestamps = Optional.empty();

        private Optional<Map<String, Object>> destinationConfiguration = Optional.empty();

        private Optional<BulkDiscover> automaticallyAddNewObjects = Optional.empty();

        private Optional<BulkDiscover> automaticallyAddNewFields = Optional.empty();

        private Optional<Boolean> active = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateBulkSyncRequest other) {
            active(other.getActive());
            automaticallyAddNewFields(other.getAutomaticallyAddNewFields());
            automaticallyAddNewObjects(other.getAutomaticallyAddNewObjects());
            destinationConfiguration(other.getDestinationConfiguration());
            destinationConnectionId(other.getDestinationConnectionId());
            disableRecordTimestamps(other.getDisableRecordTimestamps());
            discover(other.getDiscover());
            mode(other.getMode());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            schedule(other.getSchedule());
            schemas(other.getSchemas());
            sourceConfiguration(other.getSourceConfiguration());
            sourceConnectionId(other.getSourceConnectionId());
            return this;
        }

        @java.lang.Override
        @JsonSetter("destination_connection_id")
        public NameStage destinationConnectionId(String destinationConnectionId) {
            this.destinationConnectionId = destinationConnectionId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public ScheduleStage name(String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        @JsonSetter("schedule")
        public SourceConnectionIdStage schedule(BulkSchedule schedule) {
            this.schedule = schedule;
            return this;
        }

        @java.lang.Override
        @JsonSetter("source_connection_id")
        public _FinalStage sourceConnectionId(String sourceConnectionId) {
            this.sourceConnectionId = sourceConnectionId;
            return this;
        }

        @java.lang.Override
        public _FinalStage sourceConfiguration(Map<String, Object> sourceConfiguration) {
            this.sourceConfiguration = Optional.of(sourceConfiguration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "source_configuration", nulls = Nulls.SKIP)
        public _FinalStage sourceConfiguration(Optional<Map<String, Object>> sourceConfiguration) {
            this.sourceConfiguration = sourceConfiguration;
            return this;
        }

        /**
         * <p>List of schemas to sync; if omitted, all schemas will be selected for syncing.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage schemas(List<V2CreateBulkSyncRequestSchemasItem> schemas) {
            this.schemas = Optional.of(schemas);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "schemas", nulls = Nulls.SKIP)
        public _FinalStage schemas(Optional<List<V2CreateBulkSyncRequestSchemasItem>> schemas) {
            this.schemas = schemas;
            return this;
        }

        @java.lang.Override
        public _FinalStage policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public _FinalStage policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        @java.lang.Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @java.lang.Override
        public _FinalStage mode(SyncMode mode) {
            this.mode = Optional.of(mode);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public _FinalStage mode(Optional<SyncMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * <p>DEPRECATED: Use automatically_add_new_objects/automatically_add_new_fields instead</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage discover(Boolean discover) {
            this.discover = Optional.of(discover);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "discover", nulls = Nulls.SKIP)
        public _FinalStage discover(Optional<Boolean> discover) {
            this.discover = discover;
            return this;
        }

        @java.lang.Override
        public _FinalStage disableRecordTimestamps(Boolean disableRecordTimestamps) {
            this.disableRecordTimestamps = Optional.of(disableRecordTimestamps);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "disable_record_timestamps", nulls = Nulls.SKIP)
        public _FinalStage disableRecordTimestamps(Optional<Boolean> disableRecordTimestamps) {
            this.disableRecordTimestamps = disableRecordTimestamps;
            return this;
        }

        @java.lang.Override
        public _FinalStage destinationConfiguration(Map<String, Object> destinationConfiguration) {
            this.destinationConfiguration = Optional.of(destinationConfiguration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "destination_configuration", nulls = Nulls.SKIP)
        public _FinalStage destinationConfiguration(Optional<Map<String, Object>> destinationConfiguration) {
            this.destinationConfiguration = destinationConfiguration;
            return this;
        }

        @java.lang.Override
        public _FinalStage automaticallyAddNewObjects(BulkDiscover automaticallyAddNewObjects) {
            this.automaticallyAddNewObjects = Optional.of(automaticallyAddNewObjects);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "automatically_add_new_objects", nulls = Nulls.SKIP)
        public _FinalStage automaticallyAddNewObjects(Optional<BulkDiscover> automaticallyAddNewObjects) {
            this.automaticallyAddNewObjects = automaticallyAddNewObjects;
            return this;
        }

        @java.lang.Override
        public _FinalStage automaticallyAddNewFields(BulkDiscover automaticallyAddNewFields) {
            this.automaticallyAddNewFields = Optional.of(automaticallyAddNewFields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "automatically_add_new_fields", nulls = Nulls.SKIP)
        public _FinalStage automaticallyAddNewFields(Optional<BulkDiscover> automaticallyAddNewFields) {
            this.automaticallyAddNewFields = automaticallyAddNewFields;
            return this;
        }

        @java.lang.Override
        public _FinalStage active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public _FinalStage active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        @java.lang.Override
        public CreateBulkSyncRequest build() {
            return new CreateBulkSyncRequest(
                    active,
                    automaticallyAddNewFields,
                    automaticallyAddNewObjects,
                    destinationConfiguration,
                    destinationConnectionId,
                    disableRecordTimestamps,
                    discover,
                    mode,
                    name,
                    organizationId,
                    policies,
                    schedule,
                    schemas,
                    sourceConfiguration,
                    sourceConnectionId,
                    additionalProperties);
        }
    }
}
