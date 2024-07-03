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
@JsonDeserialize(builder = SyncCompletedEvent.Builder.class)
public final class SyncCompletedEvent {
    private final Optional<List<String>> deletedRecords;

    private final Optional<Integer> errorCount;

    private final Optional<List<String>> erroredRecords;

    private final Optional<String> executionId;

    private final Optional<Integer> insertedCount;

    private final Optional<List<String>> insertedRecords;

    private final Optional<String> name;

    private final Optional<String> organizationId;

    private final Optional<Integer> recordCount;

    private final Optional<ExecutionStatus> status;

    private final Optional<String> syncId;

    private final Optional<String> targetConnectionId;

    private final Optional<List<String>> totalRecords;

    private final Optional<String> trigger;

    private final Optional<Integer> updatedCount;

    private final Optional<List<String>> updatedRecords;

    private final Optional<Integer> upsertedCount;

    private final Optional<Integer> warningCount;

    private final Optional<List<String>> warnings;

    private final Map<String, Object> additionalProperties;

    private SyncCompletedEvent(
            Optional<List<String>> deletedRecords,
            Optional<Integer> errorCount,
            Optional<List<String>> erroredRecords,
            Optional<String> executionId,
            Optional<Integer> insertedCount,
            Optional<List<String>> insertedRecords,
            Optional<String> name,
            Optional<String> organizationId,
            Optional<Integer> recordCount,
            Optional<ExecutionStatus> status,
            Optional<String> syncId,
            Optional<String> targetConnectionId,
            Optional<List<String>> totalRecords,
            Optional<String> trigger,
            Optional<Integer> updatedCount,
            Optional<List<String>> updatedRecords,
            Optional<Integer> upsertedCount,
            Optional<Integer> warningCount,
            Optional<List<String>> warnings,
            Map<String, Object> additionalProperties) {
        this.deletedRecords = deletedRecords;
        this.errorCount = errorCount;
        this.erroredRecords = erroredRecords;
        this.executionId = executionId;
        this.insertedCount = insertedCount;
        this.insertedRecords = insertedRecords;
        this.name = name;
        this.organizationId = organizationId;
        this.recordCount = recordCount;
        this.status = status;
        this.syncId = syncId;
        this.targetConnectionId = targetConnectionId;
        this.totalRecords = totalRecords;
        this.trigger = trigger;
        this.updatedCount = updatedCount;
        this.updatedRecords = updatedRecords;
        this.upsertedCount = upsertedCount;
        this.warningCount = warningCount;
        this.warnings = warnings;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("deleted_records")
    public Optional<List<String>> getDeletedRecords() {
        return deletedRecords;
    }

    @JsonProperty("error_count")
    public Optional<Integer> getErrorCount() {
        return errorCount;
    }

    @JsonProperty("errored_records")
    public Optional<List<String>> getErroredRecords() {
        return erroredRecords;
    }

    @JsonProperty("execution_id")
    public Optional<String> getExecutionId() {
        return executionId;
    }

    @JsonProperty("inserted_count")
    public Optional<Integer> getInsertedCount() {
        return insertedCount;
    }

    @JsonProperty("inserted_records")
    public Optional<List<String>> getInsertedRecords() {
        return insertedRecords;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("record_count")
    public Optional<Integer> getRecordCount() {
        return recordCount;
    }

    @JsonProperty("status")
    public Optional<ExecutionStatus> getStatus() {
        return status;
    }

    @JsonProperty("sync_id")
    public Optional<String> getSyncId() {
        return syncId;
    }

    @JsonProperty("target_connection_id")
    public Optional<String> getTargetConnectionId() {
        return targetConnectionId;
    }

    @JsonProperty("total_records")
    public Optional<List<String>> getTotalRecords() {
        return totalRecords;
    }

    @JsonProperty("trigger")
    public Optional<String> getTrigger() {
        return trigger;
    }

    @JsonProperty("updated_count")
    public Optional<Integer> getUpdatedCount() {
        return updatedCount;
    }

    @JsonProperty("updated_records")
    public Optional<List<String>> getUpdatedRecords() {
        return updatedRecords;
    }

    @JsonProperty("upserted_count")
    public Optional<Integer> getUpsertedCount() {
        return upsertedCount;
    }

    @JsonProperty("warning_count")
    public Optional<Integer> getWarningCount() {
        return warningCount;
    }

    @JsonProperty("warnings")
    public Optional<List<String>> getWarnings() {
        return warnings;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncCompletedEvent && equalTo((SyncCompletedEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SyncCompletedEvent other) {
        return deletedRecords.equals(other.deletedRecords)
                && errorCount.equals(other.errorCount)
                && erroredRecords.equals(other.erroredRecords)
                && executionId.equals(other.executionId)
                && insertedCount.equals(other.insertedCount)
                && insertedRecords.equals(other.insertedRecords)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && recordCount.equals(other.recordCount)
                && status.equals(other.status)
                && syncId.equals(other.syncId)
                && targetConnectionId.equals(other.targetConnectionId)
                && totalRecords.equals(other.totalRecords)
                && trigger.equals(other.trigger)
                && updatedCount.equals(other.updatedCount)
                && updatedRecords.equals(other.updatedRecords)
                && upsertedCount.equals(other.upsertedCount)
                && warningCount.equals(other.warningCount)
                && warnings.equals(other.warnings);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.deletedRecords,
                this.errorCount,
                this.erroredRecords,
                this.executionId,
                this.insertedCount,
                this.insertedRecords,
                this.name,
                this.organizationId,
                this.recordCount,
                this.status,
                this.syncId,
                this.targetConnectionId,
                this.totalRecords,
                this.trigger,
                this.updatedCount,
                this.updatedRecords,
                this.upsertedCount,
                this.warningCount,
                this.warnings);
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
        private Optional<List<String>> deletedRecords = Optional.empty();

        private Optional<Integer> errorCount = Optional.empty();

        private Optional<List<String>> erroredRecords = Optional.empty();

        private Optional<String> executionId = Optional.empty();

        private Optional<Integer> insertedCount = Optional.empty();

        private Optional<List<String>> insertedRecords = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<Integer> recordCount = Optional.empty();

        private Optional<ExecutionStatus> status = Optional.empty();

        private Optional<String> syncId = Optional.empty();

        private Optional<String> targetConnectionId = Optional.empty();

        private Optional<List<String>> totalRecords = Optional.empty();

        private Optional<String> trigger = Optional.empty();

        private Optional<Integer> updatedCount = Optional.empty();

        private Optional<List<String>> updatedRecords = Optional.empty();

        private Optional<Integer> upsertedCount = Optional.empty();

        private Optional<Integer> warningCount = Optional.empty();

        private Optional<List<String>> warnings = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SyncCompletedEvent other) {
            deletedRecords(other.getDeletedRecords());
            errorCount(other.getErrorCount());
            erroredRecords(other.getErroredRecords());
            executionId(other.getExecutionId());
            insertedCount(other.getInsertedCount());
            insertedRecords(other.getInsertedRecords());
            name(other.getName());
            organizationId(other.getOrganizationId());
            recordCount(other.getRecordCount());
            status(other.getStatus());
            syncId(other.getSyncId());
            targetConnectionId(other.getTargetConnectionId());
            totalRecords(other.getTotalRecords());
            trigger(other.getTrigger());
            updatedCount(other.getUpdatedCount());
            updatedRecords(other.getUpdatedRecords());
            upsertedCount(other.getUpsertedCount());
            warningCount(other.getWarningCount());
            warnings(other.getWarnings());
            return this;
        }

        @JsonSetter(value = "deleted_records", nulls = Nulls.SKIP)
        public Builder deletedRecords(Optional<List<String>> deletedRecords) {
            this.deletedRecords = deletedRecords;
            return this;
        }

        public Builder deletedRecords(List<String> deletedRecords) {
            this.deletedRecords = Optional.of(deletedRecords);
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

        @JsonSetter(value = "errored_records", nulls = Nulls.SKIP)
        public Builder erroredRecords(Optional<List<String>> erroredRecords) {
            this.erroredRecords = erroredRecords;
            return this;
        }

        public Builder erroredRecords(List<String> erroredRecords) {
            this.erroredRecords = Optional.of(erroredRecords);
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

        @JsonSetter(value = "inserted_count", nulls = Nulls.SKIP)
        public Builder insertedCount(Optional<Integer> insertedCount) {
            this.insertedCount = insertedCount;
            return this;
        }

        public Builder insertedCount(Integer insertedCount) {
            this.insertedCount = Optional.of(insertedCount);
            return this;
        }

        @JsonSetter(value = "inserted_records", nulls = Nulls.SKIP)
        public Builder insertedRecords(Optional<List<String>> insertedRecords) {
            this.insertedRecords = insertedRecords;
            return this;
        }

        public Builder insertedRecords(List<String> insertedRecords) {
            this.insertedRecords = Optional.of(insertedRecords);
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

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<ExecutionStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(ExecutionStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "sync_id", nulls = Nulls.SKIP)
        public Builder syncId(Optional<String> syncId) {
            this.syncId = syncId;
            return this;
        }

        public Builder syncId(String syncId) {
            this.syncId = Optional.of(syncId);
            return this;
        }

        @JsonSetter(value = "target_connection_id", nulls = Nulls.SKIP)
        public Builder targetConnectionId(Optional<String> targetConnectionId) {
            this.targetConnectionId = targetConnectionId;
            return this;
        }

        public Builder targetConnectionId(String targetConnectionId) {
            this.targetConnectionId = Optional.of(targetConnectionId);
            return this;
        }

        @JsonSetter(value = "total_records", nulls = Nulls.SKIP)
        public Builder totalRecords(Optional<List<String>> totalRecords) {
            this.totalRecords = totalRecords;
            return this;
        }

        public Builder totalRecords(List<String> totalRecords) {
            this.totalRecords = Optional.of(totalRecords);
            return this;
        }

        @JsonSetter(value = "trigger", nulls = Nulls.SKIP)
        public Builder trigger(Optional<String> trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder trigger(String trigger) {
            this.trigger = Optional.of(trigger);
            return this;
        }

        @JsonSetter(value = "updated_count", nulls = Nulls.SKIP)
        public Builder updatedCount(Optional<Integer> updatedCount) {
            this.updatedCount = updatedCount;
            return this;
        }

        public Builder updatedCount(Integer updatedCount) {
            this.updatedCount = Optional.of(updatedCount);
            return this;
        }

        @JsonSetter(value = "updated_records", nulls = Nulls.SKIP)
        public Builder updatedRecords(Optional<List<String>> updatedRecords) {
            this.updatedRecords = updatedRecords;
            return this;
        }

        public Builder updatedRecords(List<String> updatedRecords) {
            this.updatedRecords = Optional.of(updatedRecords);
            return this;
        }

        @JsonSetter(value = "upserted_count", nulls = Nulls.SKIP)
        public Builder upsertedCount(Optional<Integer> upsertedCount) {
            this.upsertedCount = upsertedCount;
            return this;
        }

        public Builder upsertedCount(Integer upsertedCount) {
            this.upsertedCount = Optional.of(upsertedCount);
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

        @JsonSetter(value = "warnings", nulls = Nulls.SKIP)
        public Builder warnings(Optional<List<String>> warnings) {
            this.warnings = warnings;
            return this;
        }

        public Builder warnings(List<String> warnings) {
            this.warnings = Optional.of(warnings);
            return this;
        }

        public SyncCompletedEvent build() {
            return new SyncCompletedEvent(
                    deletedRecords,
                    errorCount,
                    erroredRecords,
                    executionId,
                    insertedCount,
                    insertedRecords,
                    name,
                    organizationId,
                    recordCount,
                    status,
                    syncId,
                    targetConnectionId,
                    totalRecords,
                    trigger,
                    updatedCount,
                    updatedRecords,
                    upsertedCount,
                    warningCount,
                    warnings,
                    additionalProperties);
        }
    }
}