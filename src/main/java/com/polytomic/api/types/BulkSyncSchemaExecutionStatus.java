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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkSyncSchemaExecutionStatus.Builder.class)
public final class BulkSyncSchemaExecutionStatus {
    private final Optional<OffsetDateTime> completedAt;

    private final Optional<Integer> errorCount;

    private final Optional<String> executionId;

    private final Optional<Integer> recordCount;

    private final Optional<String> schema;

    private final Optional<OffsetDateTime> startedAt;

    private final Optional<BulkSchemaExecutionStatus> status;

    private final Optional<String> statusMessage;

    private final Optional<Integer> warningCount;

    private final Map<String, Object> additionalProperties;

    private BulkSyncSchemaExecutionStatus(
            Optional<OffsetDateTime> completedAt,
            Optional<Integer> errorCount,
            Optional<String> executionId,
            Optional<Integer> recordCount,
            Optional<String> schema,
            Optional<OffsetDateTime> startedAt,
            Optional<BulkSchemaExecutionStatus> status,
            Optional<String> statusMessage,
            Optional<Integer> warningCount,
            Map<String, Object> additionalProperties) {
        this.completedAt = completedAt;
        this.errorCount = errorCount;
        this.executionId = executionId;
        this.recordCount = recordCount;
        this.schema = schema;
        this.startedAt = startedAt;
        this.status = status;
        this.statusMessage = statusMessage;
        this.warningCount = warningCount;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("completed_at")
    public Optional<OffsetDateTime> getCompletedAt() {
        return completedAt;
    }

    @JsonProperty("error_count")
    public Optional<Integer> getErrorCount() {
        return errorCount;
    }

    /**
     * @return ID of the most recent execution for the schema.
     */
    @JsonProperty("execution_id")
    public Optional<String> getExecutionId() {
        return executionId;
    }

    @JsonProperty("record_count")
    public Optional<Integer> getRecordCount() {
        return recordCount;
    }

    @JsonProperty("schema")
    public Optional<String> getSchema() {
        return schema;
    }

    @JsonProperty("started_at")
    public Optional<OffsetDateTime> getStartedAt() {
        return startedAt;
    }

    @JsonProperty("status")
    public Optional<BulkSchemaExecutionStatus> getStatus() {
        return status;
    }

    @JsonProperty("status_message")
    public Optional<String> getStatusMessage() {
        return statusMessage;
    }

    @JsonProperty("warning_count")
    public Optional<Integer> getWarningCount() {
        return warningCount;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkSyncSchemaExecutionStatus && equalTo((BulkSyncSchemaExecutionStatus) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkSyncSchemaExecutionStatus other) {
        return completedAt.equals(other.completedAt)
                && errorCount.equals(other.errorCount)
                && executionId.equals(other.executionId)
                && recordCount.equals(other.recordCount)
                && schema.equals(other.schema)
                && startedAt.equals(other.startedAt)
                && status.equals(other.status)
                && statusMessage.equals(other.statusMessage)
                && warningCount.equals(other.warningCount);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.completedAt,
                this.errorCount,
                this.executionId,
                this.recordCount,
                this.schema,
                this.startedAt,
                this.status,
                this.statusMessage,
                this.warningCount);
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
        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<Integer> errorCount = Optional.empty();

        private Optional<String> executionId = Optional.empty();

        private Optional<Integer> recordCount = Optional.empty();

        private Optional<String> schema = Optional.empty();

        private Optional<OffsetDateTime> startedAt = Optional.empty();

        private Optional<BulkSchemaExecutionStatus> status = Optional.empty();

        private Optional<String> statusMessage = Optional.empty();

        private Optional<Integer> warningCount = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkSyncSchemaExecutionStatus other) {
            completedAt(other.getCompletedAt());
            errorCount(other.getErrorCount());
            executionId(other.getExecutionId());
            recordCount(other.getRecordCount());
            schema(other.getSchema());
            startedAt(other.getStartedAt());
            status(other.getStatus());
            statusMessage(other.getStatusMessage());
            warningCount(other.getWarningCount());
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

        @JsonSetter(value = "error_count", nulls = Nulls.SKIP)
        public Builder errorCount(Optional<Integer> errorCount) {
            this.errorCount = errorCount;
            return this;
        }

        public Builder errorCount(Integer errorCount) {
            this.errorCount = Optional.of(errorCount);
            return this;
        }

        @JsonSetter(value = "execution_id", nulls = Nulls.SKIP)
        public Builder executionId(Optional<String> executionId) {
            this.executionId = executionId;
            return this;
        }

        public Builder executionId(String executionId) {
            this.executionId = Optional.of(executionId);
            return this;
        }

        @JsonSetter(value = "record_count", nulls = Nulls.SKIP)
        public Builder recordCount(Optional<Integer> recordCount) {
            this.recordCount = recordCount;
            return this;
        }

        public Builder recordCount(Integer recordCount) {
            this.recordCount = Optional.of(recordCount);
            return this;
        }

        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public Builder schema(Optional<String> schema) {
            this.schema = schema;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = Optional.of(schema);
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
        public Builder status(Optional<BulkSchemaExecutionStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(BulkSchemaExecutionStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "status_message", nulls = Nulls.SKIP)
        public Builder statusMessage(Optional<String> statusMessage) {
            this.statusMessage = statusMessage;
            return this;
        }

        public Builder statusMessage(String statusMessage) {
            this.statusMessage = Optional.of(statusMessage);
            return this;
        }

        @JsonSetter(value = "warning_count", nulls = Nulls.SKIP)
        public Builder warningCount(Optional<Integer> warningCount) {
            this.warningCount = warningCount;
            return this;
        }

        public Builder warningCount(Integer warningCount) {
            this.warningCount = Optional.of(warningCount);
            return this;
        }

        public BulkSyncSchemaExecutionStatus build() {
            return new BulkSyncSchemaExecutionStatus(
                    completedAt,
                    errorCount,
                    executionId,
                    recordCount,
                    schema,
                    startedAt,
                    status,
                    statusMessage,
                    warningCount,
                    additionalProperties);
        }
    }
}
