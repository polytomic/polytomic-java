/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.schemas.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.BulkField;
import com.polytomic.api.types.BulkFilter;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateBulkSchema.Builder.class)
public final class UpdateBulkSchema {
    private final Optional<OffsetDateTime> dataCutoffTimestamp;

    private final Optional<Boolean> disableDataCutoff;

    private final Optional<Boolean> enabled;

    private final Optional<List<BulkField>> fields;

    private final Optional<List<BulkFilter>> filters;

    private final Optional<String> partitionKey;

    private final Map<String, Object> additionalProperties;

    private UpdateBulkSchema(
            Optional<OffsetDateTime> dataCutoffTimestamp,
            Optional<Boolean> disableDataCutoff,
            Optional<Boolean> enabled,
            Optional<List<BulkField>> fields,
            Optional<List<BulkFilter>> filters,
            Optional<String> partitionKey,
            Map<String, Object> additionalProperties) {
        this.dataCutoffTimestamp = dataCutoffTimestamp;
        this.disableDataCutoff = disableDataCutoff;
        this.enabled = enabled;
        this.fields = fields;
        this.filters = filters;
        this.partitionKey = partitionKey;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("data_cutoff_timestamp")
    public Optional<OffsetDateTime> getDataCutoffTimestamp() {
        return dataCutoffTimestamp;
    }

    @JsonProperty("disable_data_cutoff")
    public Optional<Boolean> getDisableDataCutoff() {
        return disableDataCutoff;
    }

    @JsonProperty("enabled")
    public Optional<Boolean> getEnabled() {
        return enabled;
    }

    @JsonProperty("fields")
    public Optional<List<BulkField>> getFields() {
        return fields;
    }

    @JsonProperty("filters")
    public Optional<List<BulkFilter>> getFilters() {
        return filters;
    }

    @JsonProperty("partition_key")
    public Optional<String> getPartitionKey() {
        return partitionKey;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateBulkSchema && equalTo((UpdateBulkSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateBulkSchema other) {
        return dataCutoffTimestamp.equals(other.dataCutoffTimestamp)
                && disableDataCutoff.equals(other.disableDataCutoff)
                && enabled.equals(other.enabled)
                && fields.equals(other.fields)
                && filters.equals(other.filters)
                && partitionKey.equals(other.partitionKey);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.dataCutoffTimestamp,
                this.disableDataCutoff,
                this.enabled,
                this.fields,
                this.filters,
                this.partitionKey);
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
        private Optional<OffsetDateTime> dataCutoffTimestamp = Optional.empty();

        private Optional<Boolean> disableDataCutoff = Optional.empty();

        private Optional<Boolean> enabled = Optional.empty();

        private Optional<List<BulkField>> fields = Optional.empty();

        private Optional<List<BulkFilter>> filters = Optional.empty();

        private Optional<String> partitionKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateBulkSchema other) {
            dataCutoffTimestamp(other.getDataCutoffTimestamp());
            disableDataCutoff(other.getDisableDataCutoff());
            enabled(other.getEnabled());
            fields(other.getFields());
            filters(other.getFilters());
            partitionKey(other.getPartitionKey());
            return this;
        }

        @JsonSetter(value = "data_cutoff_timestamp", nulls = Nulls.SKIP)
        public Builder dataCutoffTimestamp(Optional<OffsetDateTime> dataCutoffTimestamp) {
            this.dataCutoffTimestamp = dataCutoffTimestamp;
            return this;
        }

        public Builder dataCutoffTimestamp(OffsetDateTime dataCutoffTimestamp) {
            this.dataCutoffTimestamp = Optional.of(dataCutoffTimestamp);
            return this;
        }

        @JsonSetter(value = "disable_data_cutoff", nulls = Nulls.SKIP)
        public Builder disableDataCutoff(Optional<Boolean> disableDataCutoff) {
            this.disableDataCutoff = disableDataCutoff;
            return this;
        }

        public Builder disableDataCutoff(Boolean disableDataCutoff) {
            this.disableDataCutoff = Optional.of(disableDataCutoff);
            return this;
        }

        @JsonSetter(value = "enabled", nulls = Nulls.SKIP)
        public Builder enabled(Optional<Boolean> enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = Optional.of(enabled);
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<BulkField>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<BulkField> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @JsonSetter(value = "filters", nulls = Nulls.SKIP)
        public Builder filters(Optional<List<BulkFilter>> filters) {
            this.filters = filters;
            return this;
        }

        public Builder filters(List<BulkFilter> filters) {
            this.filters = Optional.of(filters);
            return this;
        }

        @JsonSetter(value = "partition_key", nulls = Nulls.SKIP)
        public Builder partitionKey(Optional<String> partitionKey) {
            this.partitionKey = partitionKey;
            return this;
        }

        public Builder partitionKey(String partitionKey) {
            this.partitionKey = Optional.of(partitionKey);
            return this;
        }

        public UpdateBulkSchema build() {
            return new UpdateBulkSchema(
                    dataCutoffTimestamp,
                    disableDataCutoff,
                    enabled,
                    fields,
                    filters,
                    partitionKey,
                    additionalProperties);
        }
    }
}
