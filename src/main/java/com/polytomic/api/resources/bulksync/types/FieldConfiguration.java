/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.types;

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
@JsonDeserialize(builder = FieldConfiguration.Builder.class)
public final class FieldConfiguration {
    private final Optional<Boolean> enabled;

    private final Optional<String> id;

    private final Optional<Boolean> obfuscate;

    private final Map<String, Object> additionalProperties;

    private FieldConfiguration(
            Optional<Boolean> enabled,
            Optional<String> id,
            Optional<Boolean> obfuscate,
            Map<String, Object> additionalProperties) {
        this.enabled = enabled;
        this.id = id;
        this.obfuscate = obfuscate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Whether the field is enabled for syncing.
     */
    @JsonProperty("enabled")
    public Optional<Boolean> getEnabled() {
        return enabled;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return Whether the field should be obfuscated.
     */
    @JsonProperty("obfuscate")
    public Optional<Boolean> getObfuscate() {
        return obfuscate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldConfiguration && equalTo((FieldConfiguration) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldConfiguration other) {
        return enabled.equals(other.enabled) && id.equals(other.id) && obfuscate.equals(other.obfuscate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.enabled, this.id, this.obfuscate);
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
        private Optional<Boolean> enabled = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<Boolean> obfuscate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FieldConfiguration other) {
            enabled(other.getEnabled());
            id(other.getId());
            obfuscate(other.getObfuscate());
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

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "obfuscate", nulls = Nulls.SKIP)
        public Builder obfuscate(Optional<Boolean> obfuscate) {
            this.obfuscate = obfuscate;
            return this;
        }

        public Builder obfuscate(Boolean obfuscate) {
            this.obfuscate = Optional.of(obfuscate);
            return this;
        }

        public FieldConfiguration build() {
            return new FieldConfiguration(enabled, id, obfuscate, additionalProperties);
        }
    }
}
