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
@JsonDeserialize(builder = TargetObject.Builder.class)
public final class TargetObject {
    private final Optional<String> id;

    private final Optional<List<SupportedMode>> modes;

    private final Map<String, Object> additionalProperties;

    private TargetObject(
            Optional<String> id, Optional<List<SupportedMode>> modes, Map<String, Object> additionalProperties) {
        this.id = id;
        this.modes = modes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The identifier of the target object.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The supported sync modes and their properties for the target object.
     */
    @JsonProperty("modes")
    public Optional<List<SupportedMode>> getModes() {
        return modes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TargetObject && equalTo((TargetObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TargetObject other) {
        return id.equals(other.id) && modes.equals(other.modes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.modes);
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
        private Optional<String> id = Optional.empty();

        private Optional<List<SupportedMode>> modes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TargetObject other) {
            id(other.getId());
            modes(other.getModes());
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

        @JsonSetter(value = "modes", nulls = Nulls.SKIP)
        public Builder modes(Optional<List<SupportedMode>> modes) {
            this.modes = modes;
            return this;
        }

        public Builder modes(List<SupportedMode> modes) {
            this.modes = Optional.of(modes);
            return this;
        }

        public TargetObject build() {
            return new TargetObject(id, modes, additionalProperties);
        }
    }
}