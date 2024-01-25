
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
@JsonDeserialize(builder = V3ListBulkSchemaEnvelope.Builder.class)
public final class V3ListBulkSchemaEnvelope {
    private final Optional<List<V3BulkSchema>> data;

    private final Map<String, Object> additionalProperties;

    private V3ListBulkSchemaEnvelope(Optional<List<V3BulkSchema>> data, Map<String, Object> additionalProperties) {
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("data")
    public Optional<List<V3BulkSchema>> getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V3ListBulkSchemaEnvelope && equalTo((V3ListBulkSchemaEnvelope) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V3ListBulkSchemaEnvelope other) {
        return data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
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
        private Optional<List<V3BulkSchema>> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V3ListBulkSchemaEnvelope other) {
            data(other.getData());
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<List<V3BulkSchema>> data) {
            this.data = data;
            return this;
        }

        public Builder data(List<V3BulkSchema> data) {
            this.data = Optional.of(data);
            return this;
        }

        public V3ListBulkSchemaEnvelope build() {
            return new V3ListBulkSchemaEnvelope(data, additionalProperties);
        }
    }
}