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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V4RunQueryResult.Builder.class)
public final class V4RunQueryResult {
    private final Optional<Integer> count;

    private final Optional<String> error;

    private final Optional<String> expires;

    private final Optional<List<String>> fields;

    private final Optional<String> id;

    private final Optional<List<Map<String, Object>>> results;

    private final Optional<WorkTaskStatus> status;

    private final Map<String, Object> additionalProperties;

    private V4RunQueryResult(
            Optional<Integer> count,
            Optional<String> error,
            Optional<String> expires,
            Optional<List<String>> fields,
            Optional<String> id,
            Optional<List<Map<String, Object>>> results,
            Optional<WorkTaskStatus> status,
            Map<String, Object> additionalProperties) {
        this.count = count;
        this.error = error;
        this.expires = expires;
        this.fields = fields;
        this.id = id;
        this.results = results;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of rows returned by the query. This will not be returned until the query completes.
     */
    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    /**
     * @return The time at which the query will expire and be deleted. This will not be returned until the query completes.
     */
    @JsonProperty("expires")
    public Optional<String> getExpires() {
        return expires;
    }

    /**
     * @return The names of the fields returned by the query. This will not be returned until the query completes.
     */
    @JsonProperty("fields")
    public Optional<List<String>> getFields() {
        return fields;
    }

    /**
     * @return The ID of the query task.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The query results, returned as an array of objects.
     */
    @JsonProperty("results")
    public Optional<List<Map<String, Object>>> getResults() {
        return results;
    }

    @JsonProperty("status")
    public Optional<WorkTaskStatus> getStatus() {
        return status;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V4RunQueryResult && equalTo((V4RunQueryResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V4RunQueryResult other) {
        return count.equals(other.count)
                && error.equals(other.error)
                && expires.equals(other.expires)
                && fields.equals(other.fields)
                && id.equals(other.id)
                && results.equals(other.results)
                && status.equals(other.status);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.count, this.error, this.expires, this.fields, this.id, this.results, this.status);
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
        private Optional<Integer> count = Optional.empty();

        private Optional<String> error = Optional.empty();

        private Optional<String> expires = Optional.empty();

        private Optional<List<String>> fields = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<List<Map<String, Object>>> results = Optional.empty();

        private Optional<WorkTaskStatus> status = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V4RunQueryResult other) {
            count(other.getCount());
            error(other.getError());
            expires(other.getExpires());
            fields(other.getFields());
            id(other.getId());
            results(other.getResults());
            status(other.getStatus());
            return this;
        }

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        public Builder count(Integer count) {
            this.count = Optional.of(count);
            return this;
        }

        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public Builder error(Optional<String> error) {
            this.error = error;
            return this;
        }

        public Builder error(String error) {
            this.error = Optional.of(error);
            return this;
        }

        @JsonSetter(value = "expires", nulls = Nulls.SKIP)
        public Builder expires(Optional<String> expires) {
            this.expires = expires;
            return this;
        }

        public Builder expires(String expires) {
            this.expires = Optional.of(expires);
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<String>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<String> fields) {
            this.fields = Optional.of(fields);
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

        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Optional<List<Map<String, Object>>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<Map<String, Object>> results) {
            this.results = Optional.of(results);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<WorkTaskStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(WorkTaskStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        public V4RunQueryResult build() {
            return new V4RunQueryResult(count, error, expires, fields, id, results, status, additionalProperties);
        }
    }
}