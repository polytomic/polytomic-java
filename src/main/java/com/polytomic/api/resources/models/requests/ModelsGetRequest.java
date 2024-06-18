/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.models.requests;

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
@JsonDeserialize(builder = ModelsGetRequest.Builder.class)
public final class ModelsGetRequest {
    private final Optional<Boolean> async;

    private final Map<String, Object> additionalProperties;

    private ModelsGetRequest(Optional<Boolean> async, Map<String, Object> additionalProperties) {
        this.async = async;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("async")
    public Optional<Boolean> getAsync() {
        return async;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelsGetRequest && equalTo((ModelsGetRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelsGetRequest other) {
        return async.equals(other.async);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.async);
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
        private Optional<Boolean> async = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ModelsGetRequest other) {
            async(other.getAsync());
            return this;
        }

        @JsonSetter(value = "async", nulls = Nulls.SKIP)
        public Builder async(Optional<Boolean> async) {
            this.async = async;
            return this;
        }

        public Builder async(Boolean async) {
            this.async = Optional.of(async);
            return this;
        }

        public ModelsGetRequest build() {
            return new ModelsGetRequest(async, additionalProperties);
        }
    }
}