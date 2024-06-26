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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Source.Builder.class)
public final class Source {
    private final String field;

    private final String modelId;

    private final Map<String, Object> additionalProperties;

    private Source(String field, String modelId, Map<String, Object> additionalProperties) {
        this.field = field;
        this.modelId = modelId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("model_id")
    public String getModelId() {
        return modelId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Source && equalTo((Source) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Source other) {
        return field.equals(other.field) && modelId.equals(other.modelId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.field, this.modelId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FieldStage builder() {
        return new Builder();
    }

    public interface FieldStage {
        ModelIdStage field(String field);

        Builder from(Source other);
    }

    public interface ModelIdStage {
        _FinalStage modelId(String modelId);
    }

    public interface _FinalStage {
        Source build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FieldStage, ModelIdStage, _FinalStage {
        private String field;

        private String modelId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Source other) {
            field(other.getField());
            modelId(other.getModelId());
            return this;
        }

        @java.lang.Override
        @JsonSetter("field")
        public ModelIdStage field(String field) {
            this.field = field;
            return this;
        }

        @java.lang.Override
        @JsonSetter("model_id")
        public _FinalStage modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        @java.lang.Override
        public Source build() {
            return new Source(field, modelId, additionalProperties);
        }
    }
}
