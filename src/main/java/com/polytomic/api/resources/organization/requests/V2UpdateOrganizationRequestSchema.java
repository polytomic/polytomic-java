
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2UpdateOrganizationRequestSchema.Builder.class)
public final class V2UpdateOrganizationRequestSchema {
    private final String name;

    private final Optional<String> ssoDomain;

    private final Optional<String> ssoOrgId;

    private final Map<String, Object> additionalProperties;

    private V2UpdateOrganizationRequestSchema(
            String name,
            Optional<String> ssoDomain,
            Optional<String> ssoOrgId,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.ssoDomain = ssoDomain;
        this.ssoOrgId = ssoOrgId;
        this.additionalProperties = additionalProperties;
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
        return other instanceof V2UpdateOrganizationRequestSchema && equalTo((V2UpdateOrganizationRequestSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2UpdateOrganizationRequestSchema other) {
        return name.equals(other.name) && ssoDomain.equals(other.ssoDomain) && ssoOrgId.equals(other.ssoOrgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.ssoDomain, this.ssoOrgId);
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

        Builder from(V2UpdateOrganizationRequestSchema other);
    }

    public interface _FinalStage {
        V2UpdateOrganizationRequestSchema build();

        _FinalStage ssoDomain(Optional<String> ssoDomain);

        _FinalStage ssoDomain(String ssoDomain);

        _FinalStage ssoOrgId(Optional<String> ssoOrgId);

        _FinalStage ssoOrgId(String ssoOrgId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<String> ssoOrgId = Optional.empty();

        private Optional<String> ssoDomain = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2UpdateOrganizationRequestSchema other) {
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
        @JsonSetter(value = "sso_org_id", nulls = Nulls.SKIP)
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
        @JsonSetter(value = "sso_domain", nulls = Nulls.SKIP)
        public _FinalStage ssoDomain(Optional<String> ssoDomain) {
            this.ssoDomain = ssoDomain;
            return this;
        }

        @Override
        public V2UpdateOrganizationRequestSchema build() {
            return new V2UpdateOrganizationRequestSchema(name, ssoDomain, ssoOrgId, additionalProperties);
        }
    }
}
