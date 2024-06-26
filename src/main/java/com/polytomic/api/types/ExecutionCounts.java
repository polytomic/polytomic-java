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
@JsonDeserialize(builder = ExecutionCounts.Builder.class)
public final class ExecutionCounts {
    private final Optional<Integer> delete;

    private final Optional<Integer> error;

    private final Optional<Integer> insert;

    private final Optional<Integer> total;

    private final Optional<Integer> update;

    private final Map<String, Object> additionalProperties;

    private ExecutionCounts(
            Optional<Integer> delete,
            Optional<Integer> error,
            Optional<Integer> insert,
            Optional<Integer> total,
            Optional<Integer> update,
            Map<String, Object> additionalProperties) {
        this.delete = delete;
        this.error = error;
        this.insert = insert;
        this.total = total;
        this.update = update;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("delete")
    public Optional<Integer> getDelete() {
        return delete;
    }

    @JsonProperty("error")
    public Optional<Integer> getError() {
        return error;
    }

    @JsonProperty("insert")
    public Optional<Integer> getInsert() {
        return insert;
    }

    @JsonProperty("total")
    public Optional<Integer> getTotal() {
        return total;
    }

    @JsonProperty("update")
    public Optional<Integer> getUpdate() {
        return update;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExecutionCounts && equalTo((ExecutionCounts) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExecutionCounts other) {
        return delete.equals(other.delete)
                && error.equals(other.error)
                && insert.equals(other.insert)
                && total.equals(other.total)
                && update.equals(other.update);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.delete, this.error, this.insert, this.total, this.update);
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
        private Optional<Integer> delete = Optional.empty();

        private Optional<Integer> error = Optional.empty();

        private Optional<Integer> insert = Optional.empty();

        private Optional<Integer> total = Optional.empty();

        private Optional<Integer> update = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ExecutionCounts other) {
            delete(other.getDelete());
            error(other.getError());
            insert(other.getInsert());
            total(other.getTotal());
            update(other.getUpdate());
            return this;
        }

        @JsonSetter(value = "delete", nulls = Nulls.SKIP)
        public Builder delete(Optional<Integer> delete) {
            this.delete = delete;
            return this;
        }

        public Builder delete(Integer delete) {
            this.delete = Optional.of(delete);
            return this;
        }

        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public Builder error(Optional<Integer> error) {
            this.error = error;
            return this;
        }

        public Builder error(Integer error) {
            this.error = Optional.of(error);
            return this;
        }

        @JsonSetter(value = "insert", nulls = Nulls.SKIP)
        public Builder insert(Optional<Integer> insert) {
            this.insert = insert;
            return this;
        }

        public Builder insert(Integer insert) {
            this.insert = Optional.of(insert);
            return this;
        }

        @JsonSetter(value = "total", nulls = Nulls.SKIP)
        public Builder total(Optional<Integer> total) {
            this.total = total;
            return this;
        }

        public Builder total(Integer total) {
            this.total = Optional.of(total);
            return this;
        }

        @JsonSetter(value = "update", nulls = Nulls.SKIP)
        public Builder update(Optional<Integer> update) {
            this.update = update;
            return this;
        }

        public Builder update(Integer update) {
            this.update = Optional.of(update);
            return this;
        }

        public ExecutionCounts build() {
            return new ExecutionCounts(delete, error, insert, total, update, additionalProperties);
        }
    }
}
