
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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2TargetResponse.Builder.class)
public final class V2TargetResponse {
    private final Optional<List<V2TargetField>> fields;

    private final Optional<String> id;

    private final Optional<List<V2Mode>> modes;

    private final Optional<String> name;

    private final Optional<SyncDestinationProperties> properties;

    private final Optional<OffsetDateTime> refreshedAt;

    private final Map<String, Object> additionalProperties;

    private V2TargetResponse(
            Optional<List<V2TargetField>> fields,
            Optional<String> id,
            Optional<List<V2Mode>> modes,
            Optional<String> name,
            Optional<SyncDestinationProperties> properties,
            Optional<OffsetDateTime> refreshedAt,
            Map<String, Object> additionalProperties) {
        this.fields = fields;
        this.id = id;
        this.modes = modes;
        this.name = name;
        this.properties = properties;
        this.refreshedAt = refreshedAt;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("fields")
    public Optional<List<V2TargetField>> getFields() {
        return fields;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("modes")
    public Optional<List<V2Mode>> getModes() {
        return modes;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("properties")
    public Optional<SyncDestinationProperties> getProperties() {
        return properties;
    }

    @JsonProperty("refreshed_at")
    public Optional<OffsetDateTime> getRefreshedAt() {
        return refreshedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2TargetResponse && equalTo((V2TargetResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2TargetResponse other) {
        return fields.equals(other.fields)
                && id.equals(other.id)
                && modes.equals(other.modes)
                && name.equals(other.name)
                && properties.equals(other.properties)
                && refreshedAt.equals(other.refreshedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fields, this.id, this.modes, this.name, this.properties, this.refreshedAt);
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
        private Optional<List<V2TargetField>> fields = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<List<V2Mode>> modes = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<SyncDestinationProperties> properties = Optional.empty();

        private Optional<OffsetDateTime> refreshedAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2TargetResponse other) {
            fields(other.getFields());
            id(other.getId());
            modes(other.getModes());
            name(other.getName());
            properties(other.getProperties());
            refreshedAt(other.getRefreshedAt());
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<V2TargetField>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<V2TargetField> fields) {
            this.fields = Optional.of(fields);
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

        @JsonSetter(value = "modes", nulls = Nulls.SKIP)
        public Builder modes(Optional<List<V2Mode>> modes) {
            this.modes = modes;
            return this;
        }

        public Builder modes(List<V2Mode> modes) {
            this.modes = Optional.of(modes);
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

        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public Builder properties(Optional<SyncDestinationProperties> properties) {
            this.properties = properties;
            return this;
        }

        public Builder properties(SyncDestinationProperties properties) {
            this.properties = Optional.of(properties);
            return this;
        }

        @JsonSetter(value = "refreshed_at", nulls = Nulls.SKIP)
        public Builder refreshedAt(Optional<OffsetDateTime> refreshedAt) {
            this.refreshedAt = refreshedAt;
            return this;
        }

        public Builder refreshedAt(OffsetDateTime refreshedAt) {
            this.refreshedAt = Optional.of(refreshedAt);
            return this;
        }

        public V2TargetResponse build() {
            return new V2TargetResponse(fields, id, modes, name, properties, refreshedAt, additionalProperties);
        }
    }
}