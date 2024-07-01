/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.modelsync.requests;

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
@JsonDeserialize(builder = ModelSyncGetSourceRequest.Builder.class)
public final class ModelSyncGetSourceRequest {
    private final Optional<Map<String, Optional<List<String>>>> params;

    private final Map<String, Object> additionalProperties;

    private ModelSyncGetSourceRequest(
            Optional<Map<String, Optional<List<String>>>> params, Map<String, Object> additionalProperties) {
        this.params = params;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("params")
    public Optional<Map<String, Optional<List<String>>>> getParams() {
        return params;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelSyncGetSourceRequest && equalTo((ModelSyncGetSourceRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelSyncGetSourceRequest other) {
        return params.equals(other.params);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.params);
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
        private Optional<Map<String, Optional<List<String>>>> params = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ModelSyncGetSourceRequest other) {
            params(other.getParams());
            return this;
        }

        @JsonSetter(value = "params", nulls = Nulls.SKIP)
        public Builder params(Optional<Map<String, Optional<List<String>>>> params) {
            this.params = params;
            return this;
        }

        public Builder params(Map<String, Optional<List<String>>> params) {
            this.params = Optional.of(params);
            return this;
        }

        public ModelSyncGetSourceRequest build() {
            return new ModelSyncGetSourceRequest(params, additionalProperties);
        }
    }
}
