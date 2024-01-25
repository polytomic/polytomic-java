
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
@JsonDeserialize(builder = V3SchemaField.Builder.class)
public final class V3SchemaField {
    private final Optional<SchemaAssociation> association;

    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<String> remoteType;

    private final Optional<String> type;

    private final Optional<List<V3PickValue>> values;

    private final Map<String, Object> additionalProperties;

    private V3SchemaField(
            Optional<SchemaAssociation> association,
            Optional<String> id,
            Optional<String> name,
            Optional<String> remoteType,
            Optional<String> type,
            Optional<List<V3PickValue>> values,
            Map<String, Object> additionalProperties) {
        this.association = association;
        this.id = id;
        this.name = name;
        this.remoteType = remoteType;
        this.type = type;
        this.values = values;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("association")
    public Optional<SchemaAssociation> getAssociation() {
        return association;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("remote_type")
    public Optional<String> getRemoteType() {
        return remoteType;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @JsonProperty("values")
    public Optional<List<V3PickValue>> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V3SchemaField && equalTo((V3SchemaField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V3SchemaField other) {
        return association.equals(other.association)
                && id.equals(other.id)
                && name.equals(other.name)
                && remoteType.equals(other.remoteType)
                && type.equals(other.type)
                && values.equals(other.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.association, this.id, this.name, this.remoteType, this.type, this.values);
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
        private Optional<SchemaAssociation> association = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> remoteType = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<List<V3PickValue>> values = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V3SchemaField other) {
            association(other.getAssociation());
            id(other.getId());
            name(other.getName());
            remoteType(other.getRemoteType());
            type(other.getType());
            values(other.getValues());
            return this;
        }

        @JsonSetter(value = "association", nulls = Nulls.SKIP)
        public Builder association(Optional<SchemaAssociation> association) {
            this.association = association;
            return this;
        }

        public Builder association(SchemaAssociation association) {
            this.association = Optional.of(association);
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "remote_type", nulls = Nulls.SKIP)
        public Builder remoteType(Optional<String> remoteType) {
            this.remoteType = remoteType;
            return this;
        }

        public Builder remoteType(String remoteType) {
            this.remoteType = Optional.of(remoteType);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "values", nulls = Nulls.SKIP)
        public Builder values(Optional<List<V3PickValue>> values) {
            this.values = values;
            return this;
        }

        public Builder values(List<V3PickValue> values) {
            this.values = Optional.of(values);
            return this;
        }

        public V3SchemaField build() {
            return new V3SchemaField(association, id, name, remoteType, type, values, additionalProperties);
        }
    }
}