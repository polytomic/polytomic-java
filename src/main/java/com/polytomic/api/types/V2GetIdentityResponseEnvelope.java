
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
@JsonDeserialize(builder = V2GetIdentityResponseEnvelope.Builder.class)
public final class V2GetIdentityResponseEnvelope {
    private final Optional<V2GetIdentityResponseSchema> data;

    private final Map<String, Object> additionalProperties;

    private V2GetIdentityResponseEnvelope(
            Optional<V2GetIdentityResponseSchema> data, Map<String, Object> additionalProperties) {
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("data")
    public Optional<V2GetIdentityResponseSchema> getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2GetIdentityResponseEnvelope && equalTo((V2GetIdentityResponseEnvelope) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2GetIdentityResponseEnvelope other) {
        return data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
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
        private Optional<V2GetIdentityResponseSchema> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2GetIdentityResponseEnvelope other) {
            data(other.getData());
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<V2GetIdentityResponseSchema> data) {
            this.data = data;
            return this;
        }

        public Builder data(V2GetIdentityResponseSchema data) {
            this.data = Optional.of(data);
            return this;
        }

        public V2GetIdentityResponseEnvelope build() {
            return new V2GetIdentityResponseEnvelope(data, additionalProperties);
        }
    }
}
