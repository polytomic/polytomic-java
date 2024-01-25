
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
@JsonDeserialize(builder = V2User.Builder.class)
public final class V2User {
    private final Optional<String> email;

    private final Optional<String> id;

    private final Optional<String> organizationId;

    private final Optional<String> role;

    private final Map<String, Object> additionalProperties;

    private V2User(
            Optional<String> email,
            Optional<String> id,
            Optional<String> organizationId,
            Optional<String> role,
            Map<String, Object> additionalProperties) {
        this.email = email;
        this.id = id;
        this.organizationId = organizationId;
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

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2User && equalTo((V2User) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2User other) {
        return email.equals(other.email)
                && id.equals(other.id)
                && organizationId.equals(other.organizationId)
                && role.equals(other.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email, this.id, this.organizationId, this.role);
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

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> role = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2User other) {
            email(other.getEmail());
            id(other.getId());
            organizationId(other.getOrganizationId());
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

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
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

        public V2User build() {
            return new V2User(email, id, organizationId, role, additionalProperties);
        }
    }
}
