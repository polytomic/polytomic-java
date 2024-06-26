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
@JsonDeserialize(builder = ConnectionParameterValuesResp.Builder.class)
public final class ConnectionParameterValuesResp {
    private final Optional<Boolean> allowsCreation;

    private final Optional<List<ConnectionParameterValue>> values;

    private final Map<String, Object> additionalProperties;

    private ConnectionParameterValuesResp(
            Optional<Boolean> allowsCreation,
            Optional<List<ConnectionParameterValue>> values,
            Map<String, Object> additionalProperties) {
        this.allowsCreation = allowsCreation;
        this.values = values;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("allows_creation")
    public Optional<Boolean> getAllowsCreation() {
        return allowsCreation;
    }

    @JsonProperty("values")
    public Optional<List<ConnectionParameterValue>> getValues() {
        return values;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConnectionParameterValuesResp && equalTo((ConnectionParameterValuesResp) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConnectionParameterValuesResp other) {
        return allowsCreation.equals(other.allowsCreation) && values.equals(other.values);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.allowsCreation, this.values);
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
        private Optional<Boolean> allowsCreation = Optional.empty();

        private Optional<List<ConnectionParameterValue>> values = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConnectionParameterValuesResp other) {
            allowsCreation(other.getAllowsCreation());
            values(other.getValues());
            return this;
        }

        @JsonSetter(value = "allows_creation", nulls = Nulls.SKIP)
        public Builder allowsCreation(Optional<Boolean> allowsCreation) {
            this.allowsCreation = allowsCreation;
            return this;
        }

        public Builder allowsCreation(Boolean allowsCreation) {
            this.allowsCreation = Optional.of(allowsCreation);
            return this;
        }

        @JsonSetter(value = "values", nulls = Nulls.SKIP)
        public Builder values(Optional<List<ConnectionParameterValue>> values) {
            this.values = values;
            return this;
        }

        public Builder values(List<ConnectionParameterValue> values) {
            this.values = Optional.of(values);
            return this;
        }

        public ConnectionParameterValuesResp build() {
            return new ConnectionParameterValuesResp(allowsCreation, values, additionalProperties);
        }
    }
}
