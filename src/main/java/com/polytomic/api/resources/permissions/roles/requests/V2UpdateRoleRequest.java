
package com.polytomic.api.resources.permissions.roles.requests;

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
@JsonDeserialize(builder = V2UpdateRoleRequest.Builder.class)
public final class V2UpdateRoleRequest {
    private final String name;

    private final Optional<String> organizationId;

    private final Map<String, Object> additionalProperties;

    private V2UpdateRoleRequest(
            String name, Optional<String> organizationId, Map<String, Object> additionalProperties) {
        this.name = name;
        this.organizationId = organizationId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2UpdateRoleRequest && equalTo((V2UpdateRoleRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2UpdateRoleRequest other) {
        return name.equals(other.name) && organizationId.equals(other.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.organizationId);
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

        Builder from(V2UpdateRoleRequest other);
    }

    public interface _FinalStage {
        V2UpdateRoleRequest build();

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<String> organizationId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2UpdateRoleRequest other) {
            name(other.getName());
            organizationId(other.getOrganizationId());
            return this;
        }

        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @Override
        public V2UpdateRoleRequest build() {
            return new V2UpdateRoleRequest(name, organizationId, additionalProperties);
        }
    }
}