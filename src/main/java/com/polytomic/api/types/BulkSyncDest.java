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
@JsonDeserialize(builder = BulkSyncDest.Builder.class)
public final class BulkSyncDest {
    private final Optional<Map<String, Object>> configuration;

    private final Optional<List<SupportedBulkMode>> modes;

    private final Map<String, Object> additionalProperties;

    private BulkSyncDest(
            Optional<Map<String, Object>> configuration,
            Optional<List<SupportedBulkMode>> modes,
            Map<String, Object> additionalProperties) {
        this.configuration = configuration;
        this.modes = modes;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("modes")
    public Optional<List<SupportedBulkMode>> getModes() {
        return modes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkSyncDest && equalTo((BulkSyncDest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkSyncDest other) {
        return configuration.equals(other.configuration) && modes.equals(other.modes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.configuration, this.modes);
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
        private Optional<Map<String, Object>> configuration = Optional.empty();

        private Optional<List<SupportedBulkMode>> modes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkSyncDest other) {
            configuration(other.getConfiguration());
            modes(other.getModes());
            return this;
        }

        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public Builder configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @JsonSetter(value = "modes", nulls = Nulls.SKIP)
        public Builder modes(Optional<List<SupportedBulkMode>> modes) {
            this.modes = modes;
            return this;
        }

        public Builder modes(List<SupportedBulkMode> modes) {
            this.modes = Optional.of(modes);
            return this;
        }

        public BulkSyncDest build() {
            return new BulkSyncDest(configuration, modes, additionalProperties);
        }
    }
}
