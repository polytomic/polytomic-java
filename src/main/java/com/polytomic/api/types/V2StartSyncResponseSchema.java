
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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2StartSyncResponseSchema.Builder.class)
public final class V2StartSyncResponseSchema {
    private final Optional<OffsetDateTime> createdAt;

    private final Optional<String> id;

    private final Optional<String> status;

    private final Map<String, Object> additionalProperties;

    private V2StartSyncResponseSchema(
            Optional<OffsetDateTime> createdAt,
            Optional<String> id,
            Optional<String> status,
            Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.id = id;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2StartSyncResponseSchema && equalTo((V2StartSyncResponseSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2StartSyncResponseSchema other) {
        return createdAt.equals(other.createdAt) && id.equals(other.id) && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.createdAt, this.id, this.status);
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
        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> status = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2StartSyncResponseSchema other) {
            createdAt(other.getCreatedAt());
            id(other.getId());
            status(other.getStatus());
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        public V2StartSyncResponseSchema build() {
            return new V2StartSyncResponseSchema(createdAt, id, status, additionalProperties);
        }
    }
}
