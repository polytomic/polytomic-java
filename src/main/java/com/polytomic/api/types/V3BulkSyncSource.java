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
    builder = V3BulkSyncSource.Builder.class
)
public final class V3BulkSyncSource {
  private final Optional<Object> configuration;

  private final Optional<List<V3Schema>> schemas;

  private final Map<String, Object> additionalProperties;

  private V3BulkSyncSource(Optional<Object> configuration, Optional<List<V3Schema>> schemas,
      Map<String, Object> additionalProperties) {
    this.configuration = configuration;
    this.schemas = schemas;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("configuration")
  public Optional<Object> getConfiguration() {
    return configuration;
  }

  @JsonProperty("schemas")
  public Optional<List<V3Schema>> getSchemas() {
    return schemas;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V3BulkSyncSource && equalTo((V3BulkSyncSource) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3BulkSyncSource other) {
    return configuration.equals(other.configuration) && schemas.equals(other.schemas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.configuration, this.schemas);
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
    private Optional<Object> configuration = Optional.empty();

    private Optional<List<V3Schema>> schemas = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3BulkSyncSource other) {
      configuration(other.getConfiguration());
      schemas(other.getSchemas());
      return this;
    }

    @JsonSetter(
        value = "configuration",
        nulls = Nulls.SKIP
    )
    public Builder configuration(Optional<Object> configuration) {
      this.configuration = configuration;
      return this;
    }

    public Builder configuration(Object configuration) {
      this.configuration = Optional.of(configuration);
      return this;
    }

    @JsonSetter(
        value = "schemas",
        nulls = Nulls.SKIP
    )
    public Builder schemas(Optional<List<V3Schema>> schemas) {
      this.schemas = schemas;
      return this;
    }

    public Builder schemas(List<V3Schema> schemas) {
      this.schemas = Optional.of(schemas);
      return this;
    }

    public V3BulkSyncSource build() {
      return new V3BulkSyncSource(configuration, schemas, additionalProperties);
    }
  }
}
