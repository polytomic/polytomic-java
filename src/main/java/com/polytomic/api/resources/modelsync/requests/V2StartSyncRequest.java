
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
@JsonDeserialize(builder = V2StartSyncRequest.Builder.class)
public final class V2StartSyncRequest {
    private final Optional<List<String>> identities;

    private final Map<String, Object> additionalProperties;

    private V2StartSyncRequest(Optional<List<String>> identities, Map<String, Object> additionalProperties) {
        this.identities = identities;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("identities")
    public Optional<List<String>> getIdentities() {
        return identities;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2StartSyncRequest && equalTo((V2StartSyncRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2StartSyncRequest other) {
        return identities.equals(other.identities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identities);
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
        private Optional<List<String>> identities = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2StartSyncRequest other) {
            identities(other.getIdentities());
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

        public V2StartSyncRequest build() {
            return new V2StartSyncRequest(identities, additionalProperties);
        }
    }
}
