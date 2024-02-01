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
    builder = V2BulkSyncDest.Builder.class
)
public final class V2BulkSyncDest {
  private final Optional<Map<String, Object>> configuration;

  private final Optional<List<V2SupportedMode>> modes;

  private final Map<String, Object> additionalProperties;

  private V2BulkSyncDest(Optional<Map<String, Object>> configuration,
      Optional<List<V2SupportedMode>> modes, Map<String, Object> additionalProperties) {
    this.configuration = configuration;
    this.modes = modes;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("configuration")
  public Optional<Map<String, Object>> getConfiguration() {
    return configuration;
  }

  @JsonProperty("modes")
  public Optional<List<V2SupportedMode>> getModes() {
    return modes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2BulkSyncDest && equalTo((V2BulkSyncDest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2BulkSyncDest other) {
    return configuration.equals(other.configuration) && modes.equals(other.modes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.configuration, this.modes);
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
    private Optional<Map<String, Object>> configuration = Optional.empty();

    private Optional<List<V2SupportedMode>> modes = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2BulkSyncDest other) {
      configuration(other.getConfiguration());
      modes(other.getModes());
      return this;
    }

    @JsonSetter(
        value = "configuration",
        nulls = Nulls.SKIP
    )
    public Builder configuration(Optional<Map<String, Object>> configuration) {
      this.configuration = configuration;
      return this;
    }

    public Builder configuration(Map<String, Object> configuration) {
      this.configuration = Optional.of(configuration);
      return this;
    }

    @JsonSetter(
        value = "modes",
        nulls = Nulls.SKIP
    )
    public Builder modes(Optional<List<V2SupportedMode>> modes) {
      this.modes = modes;
      return this;
    }

    public Builder modes(List<V2SupportedMode> modes) {
      this.modes = Optional.of(modes);
      return this;
    }

    public V2BulkSyncDest build() {
      return new V2BulkSyncDest(configuration, modes, additionalProperties);
    }
  }
}
