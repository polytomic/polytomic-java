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
@JsonDeserialize(builder = V4ExportSyncLogsResponse.Builder.class)
public final class V4ExportSyncLogsResponse {
    private final Optional<String> url;

    private final Map<String, Object> additionalProperties;

    private V4ExportSyncLogsResponse(Optional<String> url, Map<String, Object> additionalProperties) {
        this.url = url;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V4ExportSyncLogsResponse && equalTo((V4ExportSyncLogsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V4ExportSyncLogsResponse other) {
        return url.equals(other.url);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.url);
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
        private Optional<String> url = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V4ExportSyncLogsResponse other) {
            url(other.getUrl());
            return this;
        }

        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public Builder url(Optional<String> url) {
            this.url = url;
            return this;
        }

        public Builder url(String url) {
            this.url = Optional.of(url);
            return this;
        }

        public V4ExportSyncLogsResponse build() {
            return new V4ExportSyncLogsResponse(url, additionalProperties);
        }
    }
}