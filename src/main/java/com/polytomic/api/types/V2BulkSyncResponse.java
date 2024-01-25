
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2BulkSyncResponse.Builder.class)
public final class V2BulkSyncResponse {
    private final Optional<Boolean> active;

    private final Optional<Map<String, Object>> destinationConfiguration;

    private final Optional<String> destinationConnectionId;

    private final Optional<Boolean> discover;

    private final Optional<String> id;

    private final Optional<String> mode;

    private final Optional<String> name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<BulkSchedule> schedule;

    private final Optional<Map<String, Object>> sourceConfiguration;

    private final Optional<String> sourceConnectionId;

    private final Map<String, Object> additionalProperties;

    private V2BulkSyncResponse(
            Optional<Boolean> active,
            Optional<Map<String, Object>> destinationConfiguration,
            Optional<String> destinationConnectionId,
            Optional<Boolean> discover,
            Optional<String> id,
            Optional<String> mode,
            Optional<String> name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<BulkSchedule> schedule,
            Optional<Map<String, Object>> sourceConfiguration,
            Optional<String> sourceConnectionId,
            Map<String, Object> additionalProperties) {
        this.active = active;
        this.destinationConfiguration = destinationConfiguration;
        this.destinationConnectionId = destinationConnectionId;
        this.discover = discover;
        this.id = id;
        this.mode = mode;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.schedule = schedule;
        this.sourceConfiguration = sourceConfiguration;
        this.sourceConnectionId = sourceConnectionId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    @JsonProperty("destination_configuration")
    public Optional<Map<String, Object>> getDestinationConfiguration() {
        return destinationConfiguration;
    }

    @JsonProperty("destination_connection_id")
    public Optional<String> getDestinationConnectionId() {
        return destinationConnectionId;
    }

    @JsonProperty("discover")
    public Optional<Boolean> getDiscover() {
        return discover;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("mode")
    public Optional<String> getMode() {
        return mode;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
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
    public Optional<BulkSchedule> getSchedule() {
        return schedule;
    }

    @JsonProperty("source_configuration")
    public Optional<Map<String, Object>> getSourceConfiguration() {
        return sourceConfiguration;
    }

    @JsonProperty("source_connection_id")
    public Optional<String> getSourceConnectionId() {
        return sourceConnectionId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2BulkSyncResponse && equalTo((V2BulkSyncResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2BulkSyncResponse other) {
        return active.equals(other.active)
                && destinationConfiguration.equals(other.destinationConfiguration)
                && destinationConnectionId.equals(other.destinationConnectionId)
                && discover.equals(other.discover)
                && id.equals(other.id)
                && mode.equals(other.mode)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && schedule.equals(other.schedule)
                && sourceConfiguration.equals(other.sourceConfiguration)
                && sourceConnectionId.equals(other.sourceConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.active,
                this.destinationConfiguration,
                this.destinationConnectionId,
                this.discover,
                this.id,
                this.mode,
                this.name,
                this.organizationId,
                this.policies,
                this.schedule,
                this.sourceConfiguration,
                this.sourceConnectionId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> active = Optional.empty();

        private Optional<Map<String, Object>> destinationConfiguration = Optional.empty();

        private Optional<String> destinationConnectionId = Optional.empty();

        private Optional<Boolean> discover = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> mode = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<BulkSchedule> schedule = Optional.empty();

        private Optional<Map<String, Object>> sourceConfiguration = Optional.empty();

        private Optional<String> sourceConnectionId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2BulkSyncResponse other) {
            active(other.getActive());
            destinationConfiguration(other.getDestinationConfiguration());
            destinationConnectionId(other.getDestinationConnectionId());
            discover(other.getDiscover());
            id(other.getId());
            mode(other.getMode());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            schedule(other.getSchedule());
            sourceConfiguration(other.getSourceConfiguration());
            sourceConnectionId(other.getSourceConnectionId());
            return this;
        }

        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public Builder active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        @JsonSetter(value = "destination_configuration", nulls = Nulls.SKIP)
        public Builder destinationConfiguration(Optional<Map<String, Object>> destinationConfiguration) {
            this.destinationConfiguration = destinationConfiguration;
            return this;
        }

        public Builder destinationConfiguration(Map<String, Object> destinationConfiguration) {
            this.destinationConfiguration = Optional.of(destinationConfiguration);
            return this;
        }

        @JsonSetter(value = "destination_connection_id", nulls = Nulls.SKIP)
        public Builder destinationConnectionId(Optional<String> destinationConnectionId) {
            this.destinationConnectionId = destinationConnectionId;
            return this;
        }

        public Builder destinationConnectionId(String destinationConnectionId) {
            this.destinationConnectionId = Optional.of(destinationConnectionId);
            return this;
        }

        @JsonSetter(value = "discover", nulls = Nulls.SKIP)
        public Builder discover(Optional<Boolean> discover) {
            this.discover = discover;
            return this;
        }

        public Builder discover(Boolean discover) {
            this.discover = Optional.of(discover);
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public Builder mode(Optional<String> mode) {
            this.mode = mode;
            return this;
        }

        public Builder mode(String mode) {
            this.mode = Optional.of(mode);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public Builder policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        public Builder policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @JsonSetter(value = "schedule", nulls = Nulls.SKIP)
        public Builder schedule(Optional<BulkSchedule> schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder schedule(BulkSchedule schedule) {
            this.schedule = Optional.of(schedule);
            return this;
        }

        @JsonSetter(value = "source_configuration", nulls = Nulls.SKIP)
        public Builder sourceConfiguration(Optional<Map<String, Object>> sourceConfiguration) {
            this.sourceConfiguration = sourceConfiguration;
            return this;
        }

        public Builder sourceConfiguration(Map<String, Object> sourceConfiguration) {
            this.sourceConfiguration = Optional.of(sourceConfiguration);
            return this;
        }

        @JsonSetter(value = "source_connection_id", nulls = Nulls.SKIP)
        public Builder sourceConnectionId(Optional<String> sourceConnectionId) {
            this.sourceConnectionId = sourceConnectionId;
            return this;
        }

        public Builder sourceConnectionId(String sourceConnectionId) {
            this.sourceConnectionId = Optional.of(sourceConnectionId);
            return this;
        }

        public V2BulkSyncResponse build() {
            return new V2BulkSyncResponse(
                    active,
                    destinationConfiguration,
                    destinationConnectionId,
                    discover,
                    id,
                    mode,
                    name,
                    organizationId,
                    policies,
                    schedule,
                    sourceConfiguration,
                    sourceConnectionId,
                    additionalProperties);
        }
    }
}
