
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2CreateConnectionResponseSchema.Builder.class)
public final class V2CreateConnectionResponseSchema {
    private final Optional<String> authCode;

    private final Optional<String> authUrl;

    private final Optional<Map<String, Object>> configuration;

    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<String> status;

    private final Optional<String> statusError;

    private final Optional<V2ConnectionTypeSchema> type;

    private final Map<String, Object> additionalProperties;

    private V2CreateConnectionResponseSchema(
            Optional<String> authCode,
            Optional<String> authUrl,
            Optional<Map<String, Object>> configuration,
            Optional<String> id,
            Optional<String> name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<String> status,
            Optional<String> statusError,
            Optional<V2ConnectionTypeSchema> type,
            Map<String, Object> additionalProperties) {
        this.authCode = authCode;
        this.authUrl = authUrl;
        this.configuration = configuration;
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.status = status;
        this.statusError = statusError;
        this.type = type;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Code to enter in order to complete connection authentication.
     */
    @JsonProperty("auth_code")
    public Optional<String> getAuthCode() {
        return authCode;
    }

    /**
     * @return URL to visit to complete connection authentication.
     */
    @JsonProperty("auth_url")
    public Optional<String> getAuthUrl() {
        return authUrl;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("policies")
    public Optional<List<String>> getPolicies() {
        return policies;
    }

    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @JsonProperty("status_error")
    public Optional<String> getStatusError() {
        return statusError;
    }

    @JsonProperty("type")
    public Optional<V2ConnectionTypeSchema> getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2CreateConnectionResponseSchema && equalTo((V2CreateConnectionResponseSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2CreateConnectionResponseSchema other) {
        return authCode.equals(other.authCode)
                && authUrl.equals(other.authUrl)
                && configuration.equals(other.configuration)
                && id.equals(other.id)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && status.equals(other.status)
                && statusError.equals(other.statusError)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.authCode,
                this.authUrl,
                this.configuration,
                this.id,
                this.name,
                this.organizationId,
                this.policies,
                this.status,
                this.statusError,
                this.type);
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
        private Optional<String> authCode = Optional.empty();

        private Optional<String> authUrl = Optional.empty();

        private Optional<Map<String, Object>> configuration = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<String> statusError = Optional.empty();

        private Optional<V2ConnectionTypeSchema> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2CreateConnectionResponseSchema other) {
            authCode(other.getAuthCode());
            authUrl(other.getAuthUrl());
            configuration(other.getConfiguration());
            id(other.getId());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            status(other.getStatus());
            statusError(other.getStatusError());
            type(other.getType());
            return this;
        }

        @JsonSetter(value = "auth_code", nulls = Nulls.SKIP)
        public Builder authCode(Optional<String> authCode) {
            this.authCode = authCode;
            return this;
        }

        public Builder authCode(String authCode) {
            this.authCode = Optional.of(authCode);
            return this;
        }

        @JsonSetter(value = "auth_url", nulls = Nulls.SKIP)
        public Builder authUrl(Optional<String> authUrl) {
            this.authUrl = authUrl;
            return this;
        }

        public Builder authUrl(String authUrl) {
            this.authUrl = Optional.of(authUrl);
            return this;
        }

        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public Builder configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
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

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public Builder policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        public Builder policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "status_error", nulls = Nulls.SKIP)
        public Builder statusError(Optional<String> statusError) {
            this.statusError = statusError;
            return this;
        }

        public Builder statusError(String statusError) {
            this.statusError = Optional.of(statusError);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<V2ConnectionTypeSchema> type) {
            this.type = type;
            return this;
        }

        public Builder type(V2ConnectionTypeSchema type) {
            this.type = Optional.of(type);
            return this;
        }

        public V2CreateConnectionResponseSchema build() {
            return new V2CreateConnectionResponseSchema(
                    authCode,
                    authUrl,
                    configuration,
                    id,
                    name,
                    organizationId,
                    policies,
                    status,
                    statusError,
                    type,
                    additionalProperties);
        }
    }
}