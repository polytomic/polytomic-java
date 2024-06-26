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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RunAfter.Builder.class)
public final class RunAfter {
    private final Optional<List<String>> bulkSyncIds;

    private final Optional<List<String>> syncIds;

    private final Map<String, Object> additionalProperties;

    private RunAfter(
            Optional<List<String>> bulkSyncIds,
            Optional<List<String>> syncIds,
            Map<String, Object> additionalProperties) {
        this.bulkSyncIds = bulkSyncIds;
        this.syncIds = syncIds;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("bulk_sync_ids")
    public Optional<List<String>> getBulkSyncIds() {
        return bulkSyncIds;
    }

    @JsonProperty("sync_ids")
    public Optional<List<String>> getSyncIds() {
        return syncIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RunAfter && equalTo((RunAfter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RunAfter other) {
        return bulkSyncIds.equals(other.bulkSyncIds) && syncIds.equals(other.syncIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.bulkSyncIds, this.syncIds);
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
        private Optional<List<String>> bulkSyncIds = Optional.empty();

        private Optional<List<String>> syncIds = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RunAfter other) {
            bulkSyncIds(other.getBulkSyncIds());
            syncIds(other.getSyncIds());
            return this;
        }

        @JsonSetter(value = "bulk_sync_ids", nulls = Nulls.SKIP)
        public Builder bulkSyncIds(Optional<List<String>> bulkSyncIds) {
            this.bulkSyncIds = bulkSyncIds;
            return this;
        }

        public Builder bulkSyncIds(List<String> bulkSyncIds) {
            this.bulkSyncIds = Optional.of(bulkSyncIds);
            return this;
        }

        @JsonSetter(value = "sync_ids", nulls = Nulls.SKIP)
        public Builder syncIds(Optional<List<String>> syncIds) {
            this.syncIds = syncIds;
            return this;
        }

        public Builder syncIds(List<String> syncIds) {
            this.syncIds = Optional.of(syncIds);
            return this;
        }

        public RunAfter build() {
            return new RunAfter(bulkSyncIds, syncIds, additionalProperties);
        }
    }
}
