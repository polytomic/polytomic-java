
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2Organization.Builder.class)
public final class V2Organization {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<String> ssoDomain;

    private final Optional<String> ssoOrgId;

    private final Map<String, Object> additionalProperties;

    private V2Organization(
            Optional<String> id,
            Optional<String> name,
            Optional<String> ssoDomain,
            Optional<String> ssoOrgId,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.ssoDomain = ssoDomain;
        this.ssoOrgId = ssoOrgId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
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
        return other instanceof V2Organization && equalTo((V2Organization) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Organization other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && ssoDomain.equals(other.ssoDomain)
                && ssoOrgId.equals(other.ssoOrgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.ssoDomain, this.ssoOrgId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> ssoDomain = Optional.empty();

        private Optional<String> ssoOrgId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2Organization other) {
            id(other.getId());
            name(other.getName());
            ssoDomain(other.getSsoDomain());
            ssoOrgId(other.getSsoOrgId());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "sso_domain", nulls = Nulls.SKIP)
        public Builder ssoDomain(Optional<String> ssoDomain) {
            this.ssoDomain = ssoDomain;
            return this;
        }

        public Builder ssoDomain(String ssoDomain) {
            this.ssoDomain = Optional.of(ssoDomain);
            return this;
        }

        @JsonSetter(value = "sso_org_id", nulls = Nulls.SKIP)
        public Builder ssoOrgId(Optional<String> ssoOrgId) {
            this.ssoOrgId = ssoOrgId;
            return this;
        }

        public Builder ssoOrgId(String ssoOrgId) {
            this.ssoOrgId = Optional.of(ssoOrgId);
            return this;
        }

        public V2Organization build() {
            return new V2Organization(id, name, ssoDomain, ssoOrgId, additionalProperties);
        }
    }
}
