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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemasListRequest.Builder.class)
public final class SchemasListRequest {
    private final Optional<Map<String, Optional<String>>> filters;

    private final Map<String, Object> additionalProperties;

    private SchemasListRequest(
            Optional<Map<String, Optional<String>>> filters, Map<String, Object> additionalProperties) {
        this.filters = filters;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("filters")
    public Optional<Map<String, Optional<String>>> getFilters() {
        return filters;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemasListRequest && equalTo((SchemasListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SchemasListRequest other) {
        return filters.equals(other.filters);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.filters);
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
        private Optional<Map<String, Optional<String>>> filters = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SchemasListRequest other) {
            filters(other.getFilters());
            return this;
        }

        @JsonSetter(value = "filters", nulls = Nulls.SKIP)
        public Builder filters(Optional<Map<String, Optional<String>>> filters) {
            this.filters = filters;
            return this;
        }

        public Builder filters(Map<String, Optional<String>> filters) {
            this.filters = Optional.of(filters);
            return this;
        }

        public SchemasListRequest build() {
            return new SchemasListRequest(filters, additionalProperties);
        }
    }
}
