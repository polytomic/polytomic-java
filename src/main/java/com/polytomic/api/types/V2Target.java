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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2Target.Builder.class
)
public final class V2Target {
  private final Optional<Map<String, Object>> configuration;

  private final String connectionId;

  private final Optional<String> filterLogic;

  private final Optional<String> newName;

  private final String _object;

  private final Optional<Map<String, Object>> searchValues;

  private final Map<String, Object> additionalProperties;

  private V2Target(Optional<Map<String, Object>> configuration, String connectionId,
      Optional<String> filterLogic, Optional<String> newName, String _object,
      Optional<Map<String, Object>> searchValues, Map<String, Object> additionalProperties) {
    this.configuration = configuration;
    this.connectionId = connectionId;
    this.filterLogic = filterLogic;
    this.newName = newName;
    this._object = _object;
    this.searchValues = searchValues;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("configuration")
  public Optional<Map<String, Object>> getConfiguration() {
    return configuration;
  }

  @JsonProperty("connection_id")
  public String getConnectionId() {
    return connectionId;
  }

  @JsonProperty("filter_logic")
  public Optional<String> getFilterLogic() {
    return filterLogic;
  }

  @JsonProperty("new_name")
  public Optional<String> getNewName() {
    return newName;
  }

  @JsonProperty("object")
  public String getObject() {
    return _object;
  }

  @JsonProperty("search_values")
  public Optional<Map<String, Object>> getSearchValues() {
    return searchValues;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2Target && equalTo((V2Target) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2Target other) {
    return configuration.equals(other.configuration) && connectionId.equals(other.connectionId) && filterLogic.equals(other.filterLogic) && newName.equals(other.newName) && _object.equals(other._object) && searchValues.equals(other.searchValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.configuration, this.connectionId, this.filterLogic, this.newName, this._object, this.searchValues);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ConnectionIdStage builder() {
    return new Builder();
  }

  public interface ConnectionIdStage {
    ObjectStage connectionId(String connectionId);

    Builder from(V2Target other);
  }

  public interface ObjectStage {
    _FinalStage _object(String _object);
  }

  public interface _FinalStage {
    V2Target build();

    _FinalStage configuration(Optional<Map<String, Object>> configuration);

    _FinalStage configuration(Map<String, Object> configuration);

    _FinalStage filterLogic(Optional<String> filterLogic);

    _FinalStage filterLogic(String filterLogic);

    _FinalStage newName(Optional<String> newName);

    _FinalStage newName(String newName);

    _FinalStage searchValues(Optional<Map<String, Object>> searchValues);

    _FinalStage searchValues(Map<String, Object> searchValues);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ConnectionIdStage, ObjectStage, _FinalStage {
    private String connectionId;

    private String _object;

    private Optional<Map<String, Object>> searchValues = Optional.empty();

    private Optional<String> newName = Optional.empty();

    private Optional<String> filterLogic = Optional.empty();

    private Optional<Map<String, Object>> configuration = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2Target other) {
      configuration(other.getConfiguration());
      connectionId(other.getConnectionId());
      filterLogic(other.getFilterLogic());
      newName(other.getNewName());
      _object(other.getObject());
      searchValues(other.getSearchValues());
      return this;
    }

    @Override
    @JsonSetter("connection_id")
    public ObjectStage connectionId(String connectionId) {
      this.connectionId = connectionId;
      return this;
    }

    @Override
    @JsonSetter("object")
    public _FinalStage _object(String _object) {
      this._object = _object;
      return this;
    }

    @Override
    public _FinalStage searchValues(Map<String, Object> searchValues) {
      this.searchValues = Optional.of(searchValues);
      return this;
    }

    @Override
    @JsonSetter(
        value = "search_values",
        nulls = Nulls.SKIP
    )
    public _FinalStage searchValues(Optional<Map<String, Object>> searchValues) {
      this.searchValues = searchValues;
      return this;
    }

    @Override
    public _FinalStage newName(String newName) {
      this.newName = Optional.of(newName);
      return this;
    }

    @Override
    @JsonSetter(
        value = "new_name",
        nulls = Nulls.SKIP
    )
    public _FinalStage newName(Optional<String> newName) {
      this.newName = newName;
      return this;
    }

    @Override
    public _FinalStage filterLogic(String filterLogic) {
      this.filterLogic = Optional.of(filterLogic);
      return this;
    }

    @Override
    @JsonSetter(
        value = "filter_logic",
        nulls = Nulls.SKIP
    )
    public _FinalStage filterLogic(Optional<String> filterLogic) {
      this.filterLogic = filterLogic;
      return this;
    }

    @Override
    public _FinalStage configuration(Map<String, Object> configuration) {
      this.configuration = Optional.of(configuration);
      return this;
    }

    @Override
    @JsonSetter(
        value = "configuration",
        nulls = Nulls.SKIP
    )
    public _FinalStage configuration(Optional<Map<String, Object>> configuration) {
      this.configuration = configuration;
      return this;
    }

    @Override
    public V2Target build() {
      return new V2Target(configuration, connectionId, filterLogic, newName, _object, searchValues, additionalProperties);
    }
  }
}
