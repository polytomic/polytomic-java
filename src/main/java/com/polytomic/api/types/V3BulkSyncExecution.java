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
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V3BulkSyncExecution.Builder.class
)
public final class V3BulkSyncExecution {
  private final Optional<OffsetDateTime> completedAt;

  private final Optional<OffsetDateTime> createdAt;

  private final Optional<String> id;

  private final Optional<Boolean> isResync;

  private final Optional<Boolean> isTest;

  private final Optional<List<V3BulkSyncSchemaExecution>> schemas;

  private final Optional<OffsetDateTime> startedAt;

  private final Optional<String> status;

  private final Optional<String> type;

  private final Map<String, Object> additionalProperties;

  private V3BulkSyncExecution(Optional<OffsetDateTime> completedAt,
      Optional<OffsetDateTime> createdAt, Optional<String> id, Optional<Boolean> isResync,
      Optional<Boolean> isTest, Optional<List<V3BulkSyncSchemaExecution>> schemas,
      Optional<OffsetDateTime> startedAt, Optional<String> status, Optional<String> type,
      Map<String, Object> additionalProperties) {
    this.completedAt = completedAt;
    this.createdAt = createdAt;
    this.id = id;
    this.isResync = isResync;
    this.isTest = isTest;
    this.schemas = schemas;
    this.startedAt = startedAt;
    this.status = status;
    this.type = type;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("completed_at")
  public Optional<OffsetDateTime> getCompletedAt() {
    return completedAt;
  }

  @JsonProperty("created_at")
  public Optional<OffsetDateTime> getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("is_resync")
  public Optional<Boolean> getIsResync() {
    return isResync;
  }

  @JsonProperty("is_test")
  public Optional<Boolean> getIsTest() {
    return isTest;
  }

  @JsonProperty("schemas")
  public Optional<List<V3BulkSyncSchemaExecution>> getSchemas() {
    return schemas;
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
    return other instanceof V3BulkSyncExecution && equalTo((V3BulkSyncExecution) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3BulkSyncExecution other) {
    return completedAt.equals(other.completedAt) && createdAt.equals(other.createdAt) && id.equals(other.id) && isResync.equals(other.isResync) && isTest.equals(other.isTest) && schemas.equals(other.schemas) && startedAt.equals(other.startedAt) && status.equals(other.status) && type.equals(other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.completedAt, this.createdAt, this.id, this.isResync, this.isTest, this.schemas, this.startedAt, this.status, this.type);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<OffsetDateTime> completedAt = Optional.empty();

    private Optional<OffsetDateTime> createdAt = Optional.empty();

    private Optional<String> id = Optional.empty();

    private Optional<Boolean> isResync = Optional.empty();

    private Optional<Boolean> isTest = Optional.empty();

    private Optional<List<V3BulkSyncSchemaExecution>> schemas = Optional.empty();

    private Optional<OffsetDateTime> startedAt = Optional.empty();

    private Optional<String> status = Optional.empty();

    private Optional<String> type = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3BulkSyncExecution other) {
      completedAt(other.getCompletedAt());
      createdAt(other.getCreatedAt());
      id(other.getId());
      isResync(other.getIsResync());
      isTest(other.getIsTest());
      schemas(other.getSchemas());
      startedAt(other.getStartedAt());
      status(other.getStatus());
      type(other.getType());
      return this;
    }

    @JsonSetter(
        value = "completed_at",
        nulls = Nulls.SKIP
    )
    public Builder completedAt(Optional<OffsetDateTime> completedAt) {
      this.completedAt = completedAt;
      return this;
    }

    public Builder completedAt(OffsetDateTime completedAt) {
      this.completedAt = Optional.of(completedAt);
      return this;
    }

    @JsonSetter(
        value = "created_at",
        nulls = Nulls.SKIP
    )
    public Builder createdAt(Optional<OffsetDateTime> createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder createdAt(OffsetDateTime createdAt) {
      this.createdAt = Optional.of(createdAt);
      return this;
    }

    @JsonSetter(
        value = "id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @JsonSetter(
        value = "is_resync",
        nulls = Nulls.SKIP
    )
    public Builder isResync(Optional<Boolean> isResync) {
      this.isResync = isResync;
      return this;
    }

    public Builder isResync(Boolean isResync) {
      this.isResync = Optional.of(isResync);
      return this;
    }

    @JsonSetter(
        value = "is_test",
        nulls = Nulls.SKIP
    )
    public Builder isTest(Optional<Boolean> isTest) {
      this.isTest = isTest;
      return this;
    }

    public Builder isTest(Boolean isTest) {
      this.isTest = Optional.of(isTest);
      return this;
    }

    @JsonSetter(
        value = "schemas",
        nulls = Nulls.SKIP
    )
    public Builder schemas(Optional<List<V3BulkSyncSchemaExecution>> schemas) {
      this.schemas = schemas;
      return this;
    }

    public Builder schemas(List<V3BulkSyncSchemaExecution> schemas) {
      this.schemas = Optional.of(schemas);
      return this;
    }

    @JsonSetter(
        value = "started_at",
        nulls = Nulls.SKIP
    )
    public Builder startedAt(Optional<OffsetDateTime> startedAt) {
      this.startedAt = startedAt;
      return this;
    }

    public Builder startedAt(OffsetDateTime startedAt) {
      this.startedAt = Optional.of(startedAt);
      return this;
    }

    @JsonSetter(
        value = "status",
        nulls = Nulls.SKIP
    )
    public Builder status(Optional<String> status) {
      this.status = status;
      return this;
    }

    public Builder status(String status) {
      this.status = Optional.of(status);
      return this;
    }

    @JsonSetter(
        value = "type",
        nulls = Nulls.SKIP
    )
    public Builder type(Optional<String> type) {
      this.type = type;
      return this;
    }

    public Builder type(String type) {
      this.type = Optional.of(type);
      return this;
    }

    public V3BulkSyncExecution build() {
      return new V3BulkSyncExecution(completedAt, createdAt, id, isResync, isTest, schemas, startedAt, status, type, additionalProperties);
    }
  }
}
