/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.executions.requests;

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
@JsonDeserialize(builder = ExecutionsListStatusRequest.Builder.class)
public final class ExecutionsListStatusRequest {
    private final Optional<Boolean> all;

    private final Optional<Boolean> active;

    private final Optional<String> syncId;

    private final Map<String, Object> additionalProperties;

    private ExecutionsListStatusRequest(
            Optional<Boolean> all,
            Optional<Boolean> active,
            Optional<String> syncId,
            Map<String, Object> additionalProperties) {
        this.all = all;
        this.active = active;
        this.syncId = syncId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Return the execution status of all syncs in the organization
     */
    @JsonProperty("all")
    public Optional<Boolean> getAll() {
        return all;
    }

    /**
     * @return Return the execution status of all active syncs in the organization
     */
    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    /**
     * @return Return the execution status of the specified sync; this may be supplied multiple times.
     */
    @JsonProperty("sync_id")
    public Optional<String> getSyncId() {
        return syncId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExecutionsListStatusRequest && equalTo((ExecutionsListStatusRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExecutionsListStatusRequest other) {
        return all.equals(other.all) && active.equals(other.active) && syncId.equals(other.syncId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.all, this.active, this.syncId);
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
        private Optional<Boolean> all = Optional.empty();

        private Optional<Boolean> active = Optional.empty();

        private Optional<String> syncId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ExecutionsListStatusRequest other) {
            all(other.getAll());
            active(other.getActive());
            syncId(other.getSyncId());
            return this;
        }

        @JsonSetter(value = "all", nulls = Nulls.SKIP)
        public Builder all(Optional<Boolean> all) {
            this.all = all;
            return this;
        }

        public Builder all(Boolean all) {
            this.all = Optional.of(all);
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

        @JsonSetter(value = "sync_id", nulls = Nulls.SKIP)
        public Builder syncId(Optional<String> syncId) {
            this.syncId = syncId;
            return this;
        }

        public Builder syncId(String syncId) {
            this.syncId = Optional.of(syncId);
            return this;
        }

        public ExecutionsListStatusRequest build() {
            return new ExecutionsListStatusRequest(all, active, syncId, additionalProperties);
        }
    }
}