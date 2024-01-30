package com.polytomic.api.resources.bulksync.schemas.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.V3BulkField;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V3UpdateBulkSchema.Builder.class
)
public final class V3UpdateBulkSchema {
  private final Optional<Boolean> enabled;

  private final Optional<List<V3BulkField>> fields;

  private final Optional<String> partitionKey;

  private final Map<String, Object> additionalProperties;

  private V3UpdateBulkSchema(Optional<Boolean> enabled, Optional<List<V3BulkField>> fields,
      Optional<String> partitionKey, Map<String, Object> additionalProperties) {
    this.enabled = enabled;
    this.fields = fields;
    this.partitionKey = partitionKey;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("enabled")
  public Optional<Boolean> getEnabled() {
    return enabled;
  }

  @JsonProperty("fields")
  public Optional<List<V3BulkField>> getFields() {
    return fields;
  }

  @JsonProperty("partition_key")
  public Optional<String> getPartitionKey() {
    return partitionKey;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V3UpdateBulkSchema && equalTo((V3UpdateBulkSchema) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3UpdateBulkSchema other) {
    return enabled.equals(other.enabled) && fields.equals(other.fields) && partitionKey.equals(other.partitionKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.enabled, this.fields, this.partitionKey);
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
    private Optional<Boolean> enabled = Optional.empty();

    private Optional<List<V3BulkField>> fields = Optional.empty();

    private Optional<String> partitionKey = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3UpdateBulkSchema other) {
      enabled(other.getEnabled());
      fields(other.getFields());
      partitionKey(other.getPartitionKey());
      return this;
    }

    @JsonSetter(
        value = "enabled",
        nulls = Nulls.SKIP
    )
    public Builder enabled(Optional<Boolean> enabled) {
      this.enabled = enabled;
      return this;
    }

    public Builder enabled(Boolean enabled) {
      this.enabled = Optional.of(enabled);
      return this;
    }

    @JsonSetter(
        value = "fields",
        nulls = Nulls.SKIP
    )
    public Builder fields(Optional<List<V3BulkField>> fields) {
      this.fields = fields;
      return this;
    }

    public Builder fields(List<V3BulkField> fields) {
      this.fields = Optional.of(fields);
      return this;
    }

    @JsonSetter(
        value = "partition_key",
        nulls = Nulls.SKIP
    )
    public Builder partitionKey(Optional<String> partitionKey) {
      this.partitionKey = partitionKey;
      return this;
    }

    public Builder partitionKey(String partitionKey) {
      this.partitionKey = Optional.of(partitionKey);
      return this;
    }

    public V3UpdateBulkSchema build() {
      return new V3UpdateBulkSchema(enabled, fields, partitionKey, additionalProperties);
    }
  }
}
