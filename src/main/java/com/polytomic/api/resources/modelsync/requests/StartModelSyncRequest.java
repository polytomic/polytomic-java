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
@JsonDeserialize(builder = StartModelSyncRequest.Builder.class)
public final class StartModelSyncRequest {
    private final Optional<List<String>> identities;

    private final Optional<Boolean> resync;

    private final Map<String, Object> additionalProperties;

    private StartModelSyncRequest(
            Optional<List<String>> identities, Optional<Boolean> resync, Map<String, Object> additionalProperties) {
        this.identities = identities;
        this.resync = resync;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("identities")
    public Optional<List<String>> getIdentities() {
        return identities;
    }

    @JsonProperty("resync")
    public Optional<Boolean> getResync() {
        return resync;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StartModelSyncRequest && equalTo((StartModelSyncRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(StartModelSyncRequest other) {
        return identities.equals(other.identities) && resync.equals(other.resync);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.identities, this.resync);
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
        private Optional<List<String>> identities = Optional.empty();

        private Optional<Boolean> resync = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(StartModelSyncRequest other) {
            identities(other.getIdentities());
            resync(other.getResync());
            return this;
        }

        @JsonSetter(value = "identities", nulls = Nulls.SKIP)
        public Builder identities(Optional<List<String>> identities) {
            this.identities = identities;
            return this;
        }

        public Builder identities(List<String> identities) {
            this.identities = Optional.of(identities);
            return this;
        }

        @JsonSetter(value = "resync", nulls = Nulls.SKIP)
        public Builder resync(Optional<Boolean> resync) {
            this.resync = resync;
            return this;
        }

        public Builder resync(Boolean resync) {
            this.resync = Optional.of(resync);
            return this;
        }

        public StartModelSyncRequest build() {
            return new StartModelSyncRequest(identities, resync, additionalProperties);
        }
    }
}
