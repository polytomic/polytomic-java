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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ActivateSyncOutput.Builder.class)
public final class ActivateSyncOutput {
    private final Optional<Boolean> active;

    private final Optional<String> id;

    private final Map<String, Object> additionalProperties;

    private ActivateSyncOutput(
            Optional<Boolean> active, Optional<String> id, Map<String, Object> additionalProperties) {
        this.active = active;
        this.id = id;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ActivateSyncOutput && equalTo((ActivateSyncOutput) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ActivateSyncOutput other) {
        return active.equals(other.active) && id.equals(other.id);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.active, this.id);
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
        private Optional<Boolean> active = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ActivateSyncOutput other) {
            active(other.getActive());
            id(other.getId());
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

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        public ActivateSyncOutput build() {
            return new ActivateSyncOutput(active, id, additionalProperties);
        }
    }
}
