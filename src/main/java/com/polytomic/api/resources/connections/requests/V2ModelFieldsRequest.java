
package com.polytomic.api.resources.connections.requests;

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
@JsonDeserialize(builder = V2ModelFieldsRequest.Builder.class)
public final class V2ModelFieldsRequest {
    private final Optional<Map<String, Object>> query;

    private final Map<String, Object> additionalProperties;

    private V2ModelFieldsRequest(Optional<Map<String, Object>> query, Map<String, Object> additionalProperties) {
        this.query = query;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("query")
    public Optional<Map<String, Object>> getQuery() {
        return query;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ModelFieldsRequest && equalTo((V2ModelFieldsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ModelFieldsRequest other) {
        return query.equals(other.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query);
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
        private Optional<Map<String, Object>> query = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ModelFieldsRequest other) {
            query(other.getQuery());
            return this;
        }

        @JsonSetter(value = "query", nulls = Nulls.SKIP)
        public Builder query(Optional<Map<String, Object>> query) {
            this.query = query;
            return this;
        }

        public Builder query(Map<String, Object> query) {
            this.query = Optional.of(query);
            return this;
        }

        public V2ModelFieldsRequest build() {
            return new V2ModelFieldsRequest(query, additionalProperties);
        }
    }
}
