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
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2ExecutionCounts.Builder.class
)
public final class V2ExecutionCounts {
  private final Optional<Integer> error;

  private final Optional<Integer> insert;

  private final Optional<Integer> total;

  private final Optional<Integer> update;

  private final Map<String, Object> additionalProperties;

  private V2ExecutionCounts(Optional<Integer> error, Optional<Integer> insert,
      Optional<Integer> total, Optional<Integer> update, Map<String, Object> additionalProperties) {
    this.error = error;
    this.insert = insert;
    this.total = total;
    this.update = update;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("error")
  public Optional<Integer> getError() {
    return error;
  }

  @JsonProperty("insert")
  public Optional<Integer> getInsert() {
    return insert;
  }

  @JsonProperty("total")
  public Optional<Integer> getTotal() {
    return total;
  }

  @JsonProperty("update")
  public Optional<Integer> getUpdate() {
    return update;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2ExecutionCounts && equalTo((V2ExecutionCounts) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2ExecutionCounts other) {
    return error.equals(other.error) && insert.equals(other.insert) && total.equals(other.total) && update.equals(other.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.error, this.insert, this.total, this.update);
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
    private Optional<Integer> error = Optional.empty();

    private Optional<Integer> insert = Optional.empty();

    private Optional<Integer> total = Optional.empty();

    private Optional<Integer> update = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2ExecutionCounts other) {
      error(other.getError());
      insert(other.getInsert());
      total(other.getTotal());
      update(other.getUpdate());
      return this;
    }

    @JsonSetter(
        value = "error",
        nulls = Nulls.SKIP
    )
    public Builder error(Optional<Integer> error) {
      this.error = error;
      return this;
    }

    public Builder error(Integer error) {
      this.error = Optional.of(error);
      return this;
    }

    @JsonSetter(
        value = "insert",
        nulls = Nulls.SKIP
    )
    public Builder insert(Optional<Integer> insert) {
      this.insert = insert;
      return this;
    }

    public Builder insert(Integer insert) {
      this.insert = Optional.of(insert);
      return this;
    }

    @JsonSetter(
        value = "total",
        nulls = Nulls.SKIP
    )
    public Builder total(Optional<Integer> total) {
      this.total = total;
      return this;
    }

    public Builder total(Integer total) {
      this.total = Optional.of(total);
      return this;
    }

    @JsonSetter(
        value = "update",
        nulls = Nulls.SKIP
    )
    public Builder update(Optional<Integer> update) {
      this.update = update;
      return this;
    }

    public Builder update(Integer update) {
      this.update = Optional.of(update);
      return this;
    }

    public V2ExecutionCounts build() {
      return new V2ExecutionCounts(error, insert, total, update, additionalProperties);
    }
  }
}
