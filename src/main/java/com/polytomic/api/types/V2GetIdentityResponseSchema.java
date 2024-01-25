
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
@JsonDeserialize(builder = V2GetIdentityResponseSchema.Builder.class)
public final class V2GetIdentityResponseSchema {
    private final Optional<String> email;

    private final Optional<String> id;

    private final Optional<Boolean> isOrganization;

    private final Optional<Boolean> isPartner;

    private final Optional<Boolean> isSystem;

    private final Optional<Boolean> isUser;

    private final Optional<String> organizationId;

    private final Optional<String> organizationName;

    private final Optional<String> role;

    private final Map<String, Object> additionalProperties;

    private V2GetIdentityResponseSchema(
            Optional<String> email,
            Optional<String> id,
            Optional<Boolean> isOrganization,
            Optional<Boolean> isPartner,
            Optional<Boolean> isSystem,
            Optional<Boolean> isUser,
            Optional<String> organizationId,
            Optional<String> organizationName,
            Optional<String> role,
            Map<String, Object> additionalProperties) {
        this.email = email;
        this.id = id;
        this.isOrganization = isOrganization;
        this.isPartner = isPartner;
        this.isSystem = isSystem;
        this.isUser = isUser;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.role = role;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("email")
    public Optional<String> getEmail() {
        return email;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("is_organization")
    public Optional<Boolean> getIsOrganization() {
        return isOrganization;
    }

    @JsonProperty("is_partner")
    public Optional<Boolean> getIsPartner() {
        return isPartner;
    }

    @JsonProperty("is_system")
    public Optional<Boolean> getIsSystem() {
        return isSystem;
    }

    @JsonProperty("is_user")
    public Optional<Boolean> getIsUser() {
        return isUser;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organization_name")
    public Optional<String> getOrganizationName() {
        return organizationName;
    }

    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2GetIdentityResponseSchema && equalTo((V2GetIdentityResponseSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2GetIdentityResponseSchema other) {
        return email.equals(other.email)
                && id.equals(other.id)
                && isOrganization.equals(other.isOrganization)
                && isPartner.equals(other.isPartner)
                && isSystem.equals(other.isSystem)
                && isUser.equals(other.isUser)
                && organizationId.equals(other.organizationId)
                && organizationName.equals(other.organizationName)
                && role.equals(other.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.email,
                this.id,
                this.isOrganization,
                this.isPartner,
                this.isSystem,
                this.isUser,
                this.organizationId,
                this.organizationName,
                this.role);
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
        private Optional<String> email = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<Boolean> isOrganization = Optional.empty();

        private Optional<Boolean> isPartner = Optional.empty();

        private Optional<Boolean> isSystem = Optional.empty();

        private Optional<Boolean> isUser = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> organizationName = Optional.empty();

        private Optional<String> role = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2GetIdentityResponseSchema other) {
            email(other.getEmail());
            id(other.getId());
            isOrganization(other.getIsOrganization());
            isPartner(other.getIsPartner());
            isSystem(other.getIsSystem());
            isUser(other.getIsUser());
            organizationId(other.getOrganizationId());
            organizationName(other.getOrganizationName());
            role(other.getRole());
            return this;
        }

        @JsonSetter(value = "email", nulls = Nulls.SKIP)
        public Builder email(Optional<String> email) {
            this.email = email;
            return this;
        }

        public Builder email(String email) {
            this.email = Optional.of(email);
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

        @JsonSetter(value = "is_organization", nulls = Nulls.SKIP)
        public Builder isOrganization(Optional<Boolean> isOrganization) {
            this.isOrganization = isOrganization;
            return this;
        }

        public Builder isOrganization(Boolean isOrganization) {
            this.isOrganization = Optional.of(isOrganization);
            return this;
        }

        @JsonSetter(value = "is_partner", nulls = Nulls.SKIP)
        public Builder isPartner(Optional<Boolean> isPartner) {
            this.isPartner = isPartner;
            return this;
        }

        public Builder isPartner(Boolean isPartner) {
            this.isPartner = Optional.of(isPartner);
            return this;
        }

        @JsonSetter(value = "is_system", nulls = Nulls.SKIP)
        public Builder isSystem(Optional<Boolean> isSystem) {
            this.isSystem = isSystem;
            return this;
        }

        public Builder isSystem(Boolean isSystem) {
            this.isSystem = Optional.of(isSystem);
            return this;
        }

        @JsonSetter(value = "is_user", nulls = Nulls.SKIP)
        public Builder isUser(Optional<Boolean> isUser) {
            this.isUser = isUser;
            return this;
        }

        public Builder isUser(Boolean isUser) {
            this.isUser = Optional.of(isUser);
            return this;
        }

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "organization_name", nulls = Nulls.SKIP)
        public Builder organizationName(Optional<String> organizationName) {
            this.organizationName = organizationName;
            return this;
        }

        public Builder organizationName(String organizationName) {
            this.organizationName = Optional.of(organizationName);
            return this;
        }

        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public Builder role(Optional<String> role) {
            this.role = role;
            return this;
        }

        public Builder role(String role) {
            this.role = Optional.of(role);
            return this;
        }

        public V2GetIdentityResponseSchema build() {
            return new V2GetIdentityResponseSchema(
                    email,
                    id,
                    isOrganization,
                    isPartner,
                    isSystem,
                    isUser,
                    organizationId,
                    organizationName,
                    role,
                    additionalProperties);
        }
    }
}