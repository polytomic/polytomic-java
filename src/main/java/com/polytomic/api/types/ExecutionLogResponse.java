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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ExecutionLogResponse.Builder.class)
public final class ExecutionLogResponse {
    private final Optional<OffsetDateTime> expires;

    private final Optional<List<String>> urls;

    private final Map<String, Object> additionalProperties;

    private ExecutionLogResponse(
            Optional<OffsetDateTime> expires, Optional<List<String>> urls, Map<String, Object> additionalProperties) {
        this.expires = expires;
        this.urls = urls;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("expires")
    public Optional<OffsetDateTime> getExpires() {
        return expires;
    }

    @JsonProperty("urls")
    public Optional<List<String>> getUrls() {
        return urls;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExecutionLogResponse && equalTo((ExecutionLogResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExecutionLogResponse other) {
        return expires.equals(other.expires) && urls.equals(other.urls);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.expires, this.urls);
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
        private Optional<OffsetDateTime> expires = Optional.empty();

        private Optional<List<String>> urls = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ExecutionLogResponse other) {
            expires(other.getExpires());
            urls(other.getUrls());
            return this;
        }

        @JsonSetter(value = "expires", nulls = Nulls.SKIP)
        public Builder expires(Optional<OffsetDateTime> expires) {
            this.expires = expires;
            return this;
        }

        public Builder expires(OffsetDateTime expires) {
            this.expires = Optional.of(expires);
            return this;
        }

        @JsonSetter(value = "urls", nulls = Nulls.SKIP)
        public Builder urls(Optional<List<String>> urls) {
            this.urls = urls;
            return this;
        }

        public Builder urls(List<String> urls) {
            this.urls = Optional.of(urls);
            return this;
        }

        public ExecutionLogResponse build() {
            return new ExecutionLogResponse(expires, urls, additionalProperties);
        }
    }
}
