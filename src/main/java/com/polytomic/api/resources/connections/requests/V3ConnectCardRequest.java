
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
@JsonDeserialize(builder = V3ConnectCardRequest.Builder.class)
public final class V3ConnectCardRequest {
    private final Optional<String> connection;

    private final String name;

    private final Optional<String> organizationId;

    private final String redirectUrl;

    private final Optional<String> type;

    private final Optional<List<String>> whitelist;

    private final Map<String, Object> additionalProperties;

    private V3ConnectCardRequest(
            Optional<String> connection,
            String name,
            Optional<String> organizationId,
            String redirectUrl,
            Optional<String> type,
            Optional<List<String>> whitelist,
            Map<String, Object> additionalProperties) {
        this.connection = connection;
        this.name = name;
        this.organizationId = organizationId;
        this.redirectUrl = redirectUrl;
        this.type = type;
        this.whitelist = whitelist;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("connection")
    public Optional<String> getConnection() {
        return connection;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("redirect_url")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @JsonProperty("whitelist")
    public Optional<List<String>> getWhitelist() {
        return whitelist;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V3ConnectCardRequest && equalTo((V3ConnectCardRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V3ConnectCardRequest other) {
        return connection.equals(other.connection)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && redirectUrl.equals(other.redirectUrl)
                && type.equals(other.type)
                && whitelist.equals(other.whitelist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.connection, this.name, this.organizationId, this.redirectUrl, this.type, this.whitelist);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        RedirectUrlStage name(String name);

        Builder from(V3ConnectCardRequest other);
    }

    public interface RedirectUrlStage {
        _FinalStage redirectUrl(String redirectUrl);
    }

    public interface _FinalStage {
        V3ConnectCardRequest build();

        _FinalStage connection(Optional<String> connection);

        _FinalStage connection(String connection);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage type(Optional<String> type);

        _FinalStage type(String type);

        _FinalStage whitelist(Optional<List<String>> whitelist);

        _FinalStage whitelist(List<String> whitelist);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, RedirectUrlStage, _FinalStage {
        private String name;

        private String redirectUrl;

        private Optional<List<String>> whitelist = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> connection = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V3ConnectCardRequest other) {
            connection(other.getConnection());
            name(other.getName());
            organizationId(other.getOrganizationId());
            redirectUrl(other.getRedirectUrl());
            type(other.getType());
            whitelist(other.getWhitelist());
            return this;
        }

        @Override
        @JsonSetter("name")
        public RedirectUrlStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("redirect_url")
        public _FinalStage redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        @Override
        public _FinalStage whitelist(List<String> whitelist) {
            this.whitelist = Optional.of(whitelist);
            return this;
        }

        @Override
        @JsonSetter(value = "whitelist", nulls = Nulls.SKIP)
        public _FinalStage whitelist(Optional<List<String>> whitelist) {
            this.whitelist = whitelist;
            return this;
        }

        @Override
        public _FinalStage type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<String> type) {
            this.type = type;
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
        public _FinalStage connection(String connection) {
            this.connection = Optional.of(connection);
            return this;
        }

        @Override
        @JsonSetter(value = "connection", nulls = Nulls.SKIP)
        public _FinalStage connection(Optional<String> connection) {
            this.connection = connection;
            return this;
        }

        @Override
        public V3ConnectCardRequest build() {
            return new V3ConnectCardRequest(
                    connection, name, organizationId, redirectUrl, type, whitelist, additionalProperties);
        }
    }
}
