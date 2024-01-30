package com.polytomic.api.resources.webhooks.requests;

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
    builder = V2CreateWebhooksSchema.Builder.class
)
public final class V2CreateWebhooksSchema {
  private final String endpoint;

  private final Optional<String> organizationId;

  private final String secret;

  private final Map<String, Object> additionalProperties;

  private V2CreateWebhooksSchema(String endpoint, Optional<String> organizationId, String secret,
      Map<String, Object> additionalProperties) {
    this.endpoint = endpoint;
    this.organizationId = organizationId;
    this.secret = secret;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("endpoint")
  public String getEndpoint() {
    return endpoint;
  }

  @JsonProperty("organization_id")
  public Optional<String> getOrganizationId() {
    return organizationId;
  }

  @JsonProperty("secret")
  public String getSecret() {
    return secret;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2CreateWebhooksSchema && equalTo((V2CreateWebhooksSchema) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2CreateWebhooksSchema other) {
    return endpoint.equals(other.endpoint) && organizationId.equals(other.organizationId) && secret.equals(other.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.endpoint, this.organizationId, this.secret);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static EndpointStage builder() {
    return new Builder();
  }

  public interface EndpointStage {
    SecretStage endpoint(String endpoint);

    Builder from(V2CreateWebhooksSchema other);
  }

  public interface SecretStage {
    _FinalStage secret(String secret);
  }

  public interface _FinalStage {
    V2CreateWebhooksSchema build();

    _FinalStage organizationId(Optional<String> organizationId);

    _FinalStage organizationId(String organizationId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EndpointStage, SecretStage, _FinalStage {
    private String endpoint;

    private String secret;

    private Optional<String> organizationId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2CreateWebhooksSchema other) {
      endpoint(other.getEndpoint());
      organizationId(other.getOrganizationId());
      secret(other.getSecret());
      return this;
    }

    @Override
    @JsonSetter("endpoint")
    public SecretStage endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    @Override
    @JsonSetter("secret")
    public _FinalStage secret(String secret) {
      this.secret = secret;
      return this;
    }

    @Override
    public _FinalStage organizationId(String organizationId) {
      this.organizationId = Optional.of(organizationId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "organization_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage organizationId(Optional<String> organizationId) {
      this.organizationId = organizationId;
      return this;
    }

    @Override
    public V2CreateWebhooksSchema build() {
      return new V2CreateWebhooksSchema(endpoint, organizationId, secret, additionalProperties);
    }
  }
}
