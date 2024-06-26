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
@JsonDeserialize(builder = Override.Builder.class)
public final class Override {
    private final Optional<Source> field;

    private final Optional<String> fieldId;

    private final Optional<FilterFunction> function;

    private final Optional<Object> override;

    private final Optional<Object> value;

    private final Map<String, Object> additionalProperties;

    private Override(
            Optional<Source> field,
            Optional<String> fieldId,
            Optional<FilterFunction> function,
            Optional<Object> override,
            Optional<Object> value,
            Map<String, Object> additionalProperties) {
        this.field = field;
        this.fieldId = fieldId;
        this.function = function;
        this.override = override;
        this.value = value;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("field")
    public Optional<Source> getField() {
        return field;
    }

    /**
     * @return Field ID of the model field to override.
     */
    @JsonProperty("field_id")
    public Optional<String> getFieldId() {
        return fieldId;
    }

    @JsonProperty("function")
    public Optional<FilterFunction> getFunction() {
        return function;
    }

    @JsonProperty("override")
    public Optional<Object> getOverride() {
        return override;
    }

    @JsonProperty("value")
    public Optional<Object> getValue() {
        return value;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Override && equalTo((Override) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Override other) {
        return field.equals(other.field)
                && fieldId.equals(other.fieldId)
                && function.equals(other.function)
                && override.equals(other.override)
                && value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.field, this.fieldId, this.function, this.override, this.value);
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
        private Optional<Source> field = Optional.empty();

        private Optional<String> fieldId = Optional.empty();

        private Optional<FilterFunction> function = Optional.empty();

        private Optional<Object> override = Optional.empty();

        private Optional<Object> value = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Override other) {
            field(other.getField());
            fieldId(other.getFieldId());
            function(other.getFunction());
            override(other.getOverride());
            value(other.getValue());
            return this;
        }

        @JsonSetter(value = "field", nulls = Nulls.SKIP)
        public Builder field(Optional<Source> field) {
            this.field = field;
            return this;
        }

        public Builder field(Source field) {
            this.field = Optional.of(field);
            return this;
        }

        @JsonSetter(value = "field_id", nulls = Nulls.SKIP)
        public Builder fieldId(Optional<String> fieldId) {
            this.fieldId = fieldId;
            return this;
        }

        public Builder fieldId(String fieldId) {
            this.fieldId = Optional.of(fieldId);
            return this;
        }

        @JsonSetter(value = "function", nulls = Nulls.SKIP)
        public Builder function(Optional<FilterFunction> function) {
            this.function = function;
            return this;
        }

        public Builder function(FilterFunction function) {
            this.function = Optional.of(function);
            return this;
        }

        @JsonSetter(value = "override", nulls = Nulls.SKIP)
        public Builder override(Optional<Object> override) {
            this.override = override;
            return this;
        }

        public Builder override(Object override) {
            this.override = Optional.of(override);
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<Object> value) {
            this.value = value;
            return this;
        }

        public Builder value(Object value) {
            this.value = Optional.of(value);
            return this;
        }

        public Override build() {
            return new Override(field, fieldId, function, override, value, additionalProperties);
        }
    }
}
