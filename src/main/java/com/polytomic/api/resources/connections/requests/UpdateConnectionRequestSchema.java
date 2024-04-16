/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateConnectionRequestSchema.Builder.class)
public final class UpdateConnectionRequestSchema {
    private final Optional<Map<String, Object>> configuration;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<Boolean> reconnect;

    private final Optional<String> type;

    private final Optional<Boolean> validate;

    private final Map<String, Object> additionalProperties;

    private UpdateConnectionRequestSchema(
            Optional<Map<String, Object>> configuration,
            String name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<Boolean> reconnect,
            Optional<String> type,
            Optional<Boolean> validate,
            Map<String, Object> additionalProperties) {
        this.configuration = configuration;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.reconnect = reconnect;
        this.type = type;
        this.validate = validate;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("name")
    public String getName() {
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

    @JsonProperty("reconnect")
    public Optional<Boolean> getReconnect() {
        return reconnect;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return Validate connection configuration.
     */
    @JsonProperty("validate")
    public Optional<Boolean> getValidate() {
        return validate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateConnectionRequestSchema && equalTo((UpdateConnectionRequestSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateConnectionRequestSchema other) {
        return configuration.equals(other.configuration)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && reconnect.equals(other.reconnect)
                && type.equals(other.type)
                && validate.equals(other.validate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.configuration,
                this.name,
                this.organizationId,
                this.policies,
                this.reconnect,
                this.type,
                this.validate);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(UpdateConnectionRequestSchema other);
    }

    public interface _FinalStage {
        UpdateConnectionRequestSchema build();

        _FinalStage configuration(Optional<Map<String, Object>> configuration);

        _FinalStage configuration(Map<String, Object> configuration);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage policies(Optional<List<String>> policies);

        _FinalStage policies(List<String> policies);

        _FinalStage reconnect(Optional<Boolean> reconnect);

        _FinalStage reconnect(Boolean reconnect);

        _FinalStage type(Optional<String> type);

        _FinalStage type(String type);

        _FinalStage validate(Optional<Boolean> validate);

        _FinalStage validate(Boolean validate);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<Boolean> validate = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<Boolean> reconnect = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<Map<String, Object>> configuration = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateConnectionRequestSchema other) {
            configuration(other.getConfiguration());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            reconnect(other.getReconnect());
            type(other.getType());
            validate(other.getValidate());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>Validate connection configuration.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage validate(Boolean validate) {
            this.validate = Optional.of(validate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "validate", nulls = Nulls.SKIP)
        public _FinalStage validate(Optional<Boolean> validate) {
            this.validate = validate;
            return this;
        }

        @java.lang.Override
        public _FinalStage type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<String> type) {
            this.type = type;
            return this;
        }

        @java.lang.Override
        public _FinalStage reconnect(Boolean reconnect) {
            this.reconnect = Optional.of(reconnect);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "reconnect", nulls = Nulls.SKIP)
        public _FinalStage reconnect(Optional<Boolean> reconnect) {
            this.reconnect = reconnect;
            return this;
        }

        @java.lang.Override
        public _FinalStage policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public _FinalStage policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        @java.lang.Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @java.lang.Override
        public _FinalStage configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public _FinalStage configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        @java.lang.Override
        public UpdateConnectionRequestSchema build() {
            return new UpdateConnectionRequestSchema(
                    configuration, name, organizationId, policies, reconnect, type, validate, additionalProperties);
        }
    }
}