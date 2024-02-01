package com.polytomic.api.resources.organization.requests;

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
    builder = V2CreateOrganizationRequestSchema.Builder.class
)
public final class V2CreateOrganizationRequestSchema {
  private final Optional<String> clientId;

  private final Optional<String> clientSecret;

  private final Optional<String> issuer;

  private final String name;

  private final Optional<String> ssoDomain;

  private final Optional<String> ssoOrgId;

  private final Map<String, Object> additionalProperties;

  private V2CreateOrganizationRequestSchema(Optional<String> clientId,
      Optional<String> clientSecret, Optional<String> issuer, String name,
      Optional<String> ssoDomain, Optional<String> ssoOrgId,
      Map<String, Object> additionalProperties) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.issuer = issuer;
    this.name = name;
    this.ssoDomain = ssoDomain;
    this.ssoOrgId = ssoOrgId;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("client_id")
  public Optional<String> getClientId() {
    return clientId;
  }

  @JsonProperty("client_secret")
  public Optional<String> getClientSecret() {
    return clientSecret;
  }

  @JsonProperty("issuer")
  public Optional<String> getIssuer() {
    return issuer;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("sso_domain")
  public Optional<String> getSsoDomain() {
    return ssoDomain;
  }

  @JsonProperty("sso_org_id")
  public Optional<String> getSsoOrgId() {
    return ssoOrgId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2CreateOrganizationRequestSchema && equalTo((V2CreateOrganizationRequestSchema) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2CreateOrganizationRequestSchema other) {
    return clientId.equals(other.clientId) && clientSecret.equals(other.clientSecret) && issuer.equals(other.issuer) && name.equals(other.name) && ssoDomain.equals(other.ssoDomain) && ssoOrgId.equals(other.ssoOrgId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.clientId, this.clientSecret, this.issuer, this.name, this.ssoDomain, this.ssoOrgId);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    _FinalStage name(String name);

    Builder from(V2CreateOrganizationRequestSchema other);
  }

  public interface _FinalStage {
    V2CreateOrganizationRequestSchema build();

    _FinalStage clientId(Optional<String> clientId);

    _FinalStage clientId(String clientId);

    _FinalStage clientSecret(Optional<String> clientSecret);

    _FinalStage clientSecret(String clientSecret);

    _FinalStage issuer(Optional<String> issuer);

    _FinalStage issuer(String issuer);

    _FinalStage ssoDomain(Optional<String> ssoDomain);

    _FinalStage ssoDomain(String ssoDomain);

    _FinalStage ssoOrgId(Optional<String> ssoOrgId);

    _FinalStage ssoOrgId(String ssoOrgId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, _FinalStage {
    private String name;

    private Optional<String> ssoOrgId = Optional.empty();

    private Optional<String> ssoDomain = Optional.empty();

    private Optional<String> issuer = Optional.empty();

    private Optional<String> clientSecret = Optional.empty();

    private Optional<String> clientId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2CreateOrganizationRequestSchema other) {
      clientId(other.getClientId());
      clientSecret(other.getClientSecret());
      issuer(other.getIssuer());
      name(other.getName());
      ssoDomain(other.getSsoDomain());
      ssoOrgId(other.getSsoOrgId());
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public _FinalStage ssoOrgId(String ssoOrgId) {
      this.ssoOrgId = Optional.of(ssoOrgId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "sso_org_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage ssoOrgId(Optional<String> ssoOrgId) {
      this.ssoOrgId = ssoOrgId;
      return this;
    }

    @Override
    public _FinalStage ssoDomain(String ssoDomain) {
      this.ssoDomain = Optional.of(ssoDomain);
      return this;
    }

    @Override
    @JsonSetter(
        value = "sso_domain",
        nulls = Nulls.SKIP
    )
    public _FinalStage ssoDomain(Optional<String> ssoDomain) {
      this.ssoDomain = ssoDomain;
      return this;
    }

    @Override
    public _FinalStage issuer(String issuer) {
      this.issuer = Optional.of(issuer);
      return this;
    }

    @Override
    @JsonSetter(
        value = "issuer",
        nulls = Nulls.SKIP
    )
    public _FinalStage issuer(Optional<String> issuer) {
      this.issuer = issuer;
      return this;
    }

    @Override
    public _FinalStage clientSecret(String clientSecret) {
      this.clientSecret = Optional.of(clientSecret);
      return this;
    }

    @Override
    @JsonSetter(
        value = "client_secret",
        nulls = Nulls.SKIP
    )
    public _FinalStage clientSecret(Optional<String> clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    @Override
    public _FinalStage clientId(String clientId) {
      this.clientId = Optional.of(clientId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "client_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage clientId(Optional<String> clientId) {
      this.clientId = clientId;
      return this;
    }

    @Override
    public V2CreateOrganizationRequestSchema build() {
      return new V2CreateOrganizationRequestSchema(clientId, clientSecret, issuer, name, ssoDomain, ssoOrgId, additionalProperties);
    }
  }
}
