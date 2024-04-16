/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
@JsonDeserialize(builder = ConnectCardResponse.Builder.class)
public final class ConnectCardResponse {
    private final Optional<String> redirectUrl;

    private final Optional<String> token;

    private final Map<String, Object> additionalProperties;

    private ConnectCardResponse(
            Optional<String> redirectUrl, Optional<String> token, Map<String, Object> additionalProperties) {
        this.redirectUrl = redirectUrl;
        this.token = token;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("redirect_url")
    public Optional<String> getRedirectUrl() {
        return redirectUrl;
    }

    @JsonProperty("token")
    public Optional<String> getToken() {
        return token;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConnectCardResponse && equalTo((ConnectCardResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConnectCardResponse other) {
        return redirectUrl.equals(other.redirectUrl) && token.equals(other.token);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.redirectUrl, this.token);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> redirectUrl = Optional.empty();

        private Optional<String> token = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConnectCardResponse other) {
            redirectUrl(other.getRedirectUrl());
            token(other.getToken());
            return this;
        }

        @JsonSetter(value = "redirect_url", nulls = Nulls.SKIP)
        public Builder redirectUrl(Optional<String> redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = Optional.of(redirectUrl);
            return this;
        }

        @JsonSetter(value = "token", nulls = Nulls.SKIP)
        public Builder token(Optional<String> token) {
            this.token = token;
            return this;
        }

        public Builder token(String token) {
            this.token = Optional.of(token);
            return this;
        }

        public ConnectCardResponse build() {
            return new ConnectCardResponse(redirectUrl, token, additionalProperties);
        }
    }
}