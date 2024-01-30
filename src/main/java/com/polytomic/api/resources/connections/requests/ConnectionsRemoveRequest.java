package com.polytomic.api.resources.connections.requests;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = ConnectionsRemoveRequest.Builder.class
)
public final class ConnectionsRemoveRequest {
  private final Optional<Boolean> force;

  private final Map<String, Object> additionalProperties;

  private ConnectionsRemoveRequest(Optional<Boolean> force,
      Map<String, Object> additionalProperties) {
    this.force = force;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("force")
  public Optional<Boolean> getForce() {
    return force;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConnectionsRemoveRequest && equalTo((ConnectionsRemoveRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(ConnectionsRemoveRequest other) {
    return force.equals(other.force);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.force);
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
    private Optional<Boolean> force = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(ConnectionsRemoveRequest other) {
      force(other.getForce());
      return this;
    }

    @JsonSetter(
        value = "force",
        nulls = Nulls.SKIP
    )
    public Builder force(Optional<Boolean> force) {
      this.force = force;
      return this;
    }

    public Builder force(Boolean force) {
      this.force = Optional.of(force);
      return this;
    }

    public ConnectionsRemoveRequest build() {
      return new ConnectionsRemoveRequest(force, additionalProperties);
    }
  }
}
