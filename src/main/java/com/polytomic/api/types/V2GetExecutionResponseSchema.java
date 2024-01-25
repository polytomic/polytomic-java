
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
@JsonDeserialize(builder = V2GetExecutionResponseSchema.Builder.class)
public final class V2GetExecutionResponseSchema {
    private final Optional<OffsetDateTime> completedAt;

    private final Optional<V2ExecutionCounts> counts;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<List<String>> errors;

    private final Optional<String> id;

    private final Optional<OffsetDateTime> startedAt;

    private final Optional<String> status;

    private final Optional<String> type;

    private final Map<String, Object> additionalProperties;

    private V2GetExecutionResponseSchema(
            Optional<OffsetDateTime> completedAt,
            Optional<V2ExecutionCounts> counts,
            Optional<OffsetDateTime> createdAt,
            Optional<List<String>> errors,
            Optional<String> id,
            Optional<OffsetDateTime> startedAt,
            Optional<String> status,
            Optional<String> type,
            Map<String, Object> additionalProperties) {
        this.completedAt = completedAt;
        this.counts = counts;
        this.createdAt = createdAt;
        this.errors = errors;
        this.id = id;
        this.startedAt = startedAt;
        this.status = status;
        this.type = type;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("completed_at")
    public Optional<OffsetDateTime> getCompletedAt() {
        return completedAt;
    }

    @JsonProperty("counts")
    public Optional<V2ExecutionCounts> getCounts() {
        return counts;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("errors")
    public Optional<List<String>> getErrors() {
        return errors;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("started_at")
    public Optional<OffsetDateTime> getStartedAt() {
        return startedAt;
    }

    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2GetExecutionResponseSchema && equalTo((V2GetExecutionResponseSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2GetExecutionResponseSchema other) {
        return completedAt.equals(other.completedAt)
                && counts.equals(other.counts)
                && createdAt.equals(other.createdAt)
                && errors.equals(other.errors)
                && id.equals(other.id)
                && startedAt.equals(other.startedAt)
                && status.equals(other.status)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.completedAt,
                this.counts,
                this.createdAt,
                this.errors,
                this.id,
                this.startedAt,
                this.status,
                this.type);
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
        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<V2ExecutionCounts> counts = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<List<String>> errors = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<OffsetDateTime> startedAt = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<String> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2GetExecutionResponseSchema other) {
            completedAt(other.getCompletedAt());
            counts(other.getCounts());
            createdAt(other.getCreatedAt());
            errors(other.getErrors());
            id(other.getId());
            startedAt(other.getStartedAt());
            status(other.getStatus());
            type(other.getType());
            return this;
        }

        @JsonSetter(value = "completed_at", nulls = Nulls.SKIP)
        public Builder completedAt(Optional<OffsetDateTime> completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        public Builder completedAt(OffsetDateTime completedAt) {
            this.completedAt = Optional.of(completedAt);
            return this;
        }

        @JsonSetter(value = "counts", nulls = Nulls.SKIP)
        public Builder counts(Optional<V2ExecutionCounts> counts) {
            this.counts = counts;
            return this;
        }

        public Builder counts(V2ExecutionCounts counts) {
            this.counts = Optional.of(counts);
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

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<String>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<String> errors) {
            this.errors = Optional.of(errors);
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

        @JsonSetter(value = "started_at", nulls = Nulls.SKIP)
        public Builder startedAt(Optional<OffsetDateTime> startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder startedAt(OffsetDateTime startedAt) {
            this.startedAt = Optional.of(startedAt);
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

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        public V2GetExecutionResponseSchema build() {
            return new V2GetExecutionResponseSchema(
                    completedAt, counts, createdAt, errors, id, startedAt, status, type, additionalProperties);
        }
    }
}
