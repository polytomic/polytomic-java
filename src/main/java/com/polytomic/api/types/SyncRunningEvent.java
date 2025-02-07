/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SyncRunningEvent.Builder.class)
public final class SyncRunningEvent {
    private final Optional<String> executionId;

    private final Optional<String> organizationId;

    private final Optional<String> syncId;

    private final Optional<String> syncName;

    private final Optional<String> targetConnectionId;

    private final Map<String, Object> additionalProperties;

    private SyncRunningEvent(
            Optional<String> executionId,
            Optional<String> organizationId,
            Optional<String> syncId,
            Optional<String> syncName,
            Optional<String> targetConnectionId,
            Map<String, Object> additionalProperties) {
        this.executionId = executionId;
        this.organizationId = organizationId;
        this.syncId = syncId;
        this.syncName = syncName;
        this.targetConnectionId = targetConnectionId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("execution_id")
    public Optional<String> getExecutionId() {
        return executionId;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("sync_id")
    public Optional<String> getSyncId() {
        return syncId;
    }

    @JsonProperty("sync_name")
    public Optional<String> getSyncName() {
        return syncName;
    }

    @JsonProperty("target_connection_id")
    public Optional<String> getTargetConnectionId() {
        return targetConnectionId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncRunningEvent && equalTo((SyncRunningEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SyncRunningEvent other) {
        return executionId.equals(other.executionId)
                && organizationId.equals(other.organizationId)
                && syncId.equals(other.syncId)
                && syncName.equals(other.syncName)
                && targetConnectionId.equals(other.targetConnectionId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.executionId, this.organizationId, this.syncId, this.syncName, this.targetConnectionId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> executionId = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> syncId = Optional.empty();

        private Optional<String> syncName = Optional.empty();

        private Optional<String> targetConnectionId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SyncRunningEvent other) {
            executionId(other.getExecutionId());
            organizationId(other.getOrganizationId());
            syncId(other.getSyncId());
            syncName(other.getSyncName());
            targetConnectionId(other.getTargetConnectionId());
            return this;
        }

        @JsonSetter(value = "execution_id", nulls = Nulls.SKIP)
        public Builder executionId(Optional<String> executionId) {
            this.executionId = executionId;
            return this;
        }

        public Builder executionId(String executionId) {
            this.executionId = Optional.of(executionId);
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

        @JsonSetter(value = "sync_id", nulls = Nulls.SKIP)
        public Builder syncId(Optional<String> syncId) {
            this.syncId = syncId;
            return this;
        }

        public Builder syncId(String syncId) {
            this.syncId = Optional.of(syncId);
            return this;
        }

        @JsonSetter(value = "sync_name", nulls = Nulls.SKIP)
        public Builder syncName(Optional<String> syncName) {
            this.syncName = syncName;
            return this;
        }

        public Builder syncName(String syncName) {
            this.syncName = Optional.of(syncName);
            return this;
        }

        @JsonSetter(value = "target_connection_id", nulls = Nulls.SKIP)
        public Builder targetConnectionId(Optional<String> targetConnectionId) {
            this.targetConnectionId = targetConnectionId;
            return this;
        }

        public Builder targetConnectionId(String targetConnectionId) {
            this.targetConnectionId = Optional.of(targetConnectionId);
            return this;
        }

        public SyncRunningEvent build() {
            return new SyncRunningEvent(
                    executionId, organizationId, syncId, syncName, targetConnectionId, additionalProperties);
        }
    }
}
