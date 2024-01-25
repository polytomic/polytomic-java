
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
@JsonDeserialize(builder = V2ModelField.Builder.class)
public final class V2ModelField {
    private final Optional<String> description;

    private final Optional<Object> example;

    private final Optional<String> label;

    private final Optional<String> name;

    private final Optional<String> remoteType;

    private final Optional<String> type;

    private final Optional<Boolean> unique;

    private final Optional<Boolean> userAdded;

    private final Map<String, Object> additionalProperties;

    private V2ModelField(
            Optional<String> description,
            Optional<Object> example,
            Optional<String> label,
            Optional<String> name,
            Optional<String> remoteType,
            Optional<String> type,
            Optional<Boolean> unique,
            Optional<Boolean> userAdded,
            Map<String, Object> additionalProperties) {
        this.description = description;
        this.example = example;
        this.label = label;
        this.name = name;
        this.remoteType = remoteType;
        this.type = type;
        this.unique = unique;
        this.userAdded = userAdded;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("example")
    public Optional<Object> getExample() {
        return example;
    }

    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
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

    @JsonProperty("unique")
    public Optional<Boolean> getUnique() {
        return unique;
    }

    @JsonProperty("user_added")
    public Optional<Boolean> getUserAdded() {
        return userAdded;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ModelField && equalTo((V2ModelField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ModelField other) {
        return description.equals(other.description)
                && example.equals(other.example)
                && label.equals(other.label)
                && name.equals(other.name)
                && remoteType.equals(other.remoteType)
                && type.equals(other.type)
                && unique.equals(other.unique)
                && userAdded.equals(other.userAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.description,
                this.example,
                this.label,
                this.name,
                this.remoteType,
                this.type,
                this.unique,
                this.userAdded);
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
        private Optional<String> description = Optional.empty();

        private Optional<Object> example = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> remoteType = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<Boolean> unique = Optional.empty();

        private Optional<Boolean> userAdded = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ModelField other) {
            description(other.getDescription());
            example(other.getExample());
            label(other.getLabel());
            name(other.getName());
            remoteType(other.getRemoteType());
            type(other.getType());
            unique(other.getUnique());
            userAdded(other.getUserAdded());
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "example", nulls = Nulls.SKIP)
        public Builder example(Optional<Object> example) {
            this.example = example;
            return this;
        }

        public Builder example(Object example) {
            this.example = Optional.of(example);
            return this;
        }

        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }

        public Builder label(String label) {
            this.label = Optional.of(label);
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

        @JsonSetter(value = "unique", nulls = Nulls.SKIP)
        public Builder unique(Optional<Boolean> unique) {
            this.unique = unique;
            return this;
        }

        public Builder unique(Boolean unique) {
            this.unique = Optional.of(unique);
            return this;
        }

        @JsonSetter(value = "user_added", nulls = Nulls.SKIP)
        public Builder userAdded(Optional<Boolean> userAdded) {
            this.userAdded = userAdded;
            return this;
        }

        public Builder userAdded(Boolean userAdded) {
            this.userAdded = Optional.of(userAdded);
            return this;
        }

        public V2ModelField build() {
            return new V2ModelField(
                    description, example, label, name, remoteType, type, unique, userAdded, additionalProperties);
        }
    }
}
