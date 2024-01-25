
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
@JsonDeserialize(builder = V2ConnectionMetaResponse.Builder.class)
public final class V2ConnectionMetaResponse {
    private final Optional<Map<String, V2ConfigurationValue>> configuration;

    private final Optional<Map<String, Optional<V2ConnectionMeta>>> items;

    private final Optional<List<String>> requiresOneOf;

    private final Map<String, Object> additionalProperties;

    private V2ConnectionMetaResponse(
            Optional<Map<String, V2ConfigurationValue>> configuration,
            Optional<Map<String, Optional<V2ConnectionMeta>>> items,
            Optional<List<String>> requiresOneOf,
            Map<String, Object> additionalProperties) {
        this.configuration = configuration;
        this.items = items;
        this.requiresOneOf = requiresOneOf;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, V2ConfigurationValue>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("items")
    public Optional<Map<String, Optional<V2ConnectionMeta>>> getItems() {
        return items;
    }

    @JsonProperty("requires_one_of")
    public Optional<List<String>> getRequiresOneOf() {
        return requiresOneOf;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ConnectionMetaResponse && equalTo((V2ConnectionMetaResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ConnectionMetaResponse other) {
        return configuration.equals(other.configuration)
                && items.equals(other.items)
                && requiresOneOf.equals(other.requiresOneOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.configuration, this.items, this.requiresOneOf);
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
        private Optional<Map<String, V2ConfigurationValue>> configuration = Optional.empty();

        private Optional<Map<String, Optional<V2ConnectionMeta>>> items = Optional.empty();

        private Optional<List<String>> requiresOneOf = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ConnectionMetaResponse other) {
            configuration(other.getConfiguration());
            items(other.getItems());
            requiresOneOf(other.getRequiresOneOf());
            return this;
        }

        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public Builder configuration(Optional<Map<String, V2ConfigurationValue>> configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder configuration(Map<String, V2ConfigurationValue> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(Optional<Map<String, Optional<V2ConnectionMeta>>> items) {
            this.items = items;
            return this;
        }

        public Builder items(Map<String, Optional<V2ConnectionMeta>> items) {
            this.items = Optional.of(items);
            return this;
        }

        @JsonSetter(value = "requires_one_of", nulls = Nulls.SKIP)
        public Builder requiresOneOf(Optional<List<String>> requiresOneOf) {
            this.requiresOneOf = requiresOneOf;
            return this;
        }

        public Builder requiresOneOf(List<String> requiresOneOf) {
            this.requiresOneOf = Optional.of(requiresOneOf);
            return this;
        }

        public V2ConnectionMetaResponse build() {
            return new V2ConnectionMetaResponse(configuration, items, requiresOneOf, additionalProperties);
        }
    }
}