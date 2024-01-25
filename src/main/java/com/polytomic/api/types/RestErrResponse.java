
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
@JsonDeserialize(builder = RestErrResponse.Builder.class)
public final class RestErrResponse {
    private final Optional<Integer> code;

    private final Optional<Map<String, Object>> context;

    private final Optional<String> error;

    private final Optional<String> status;

    private final Map<String, Object> additionalProperties;

    private RestErrResponse(
            Optional<Integer> code,
            Optional<Map<String, Object>> context,
            Optional<String> error,
            Optional<String> status,
            Map<String, Object> additionalProperties) {
        this.code = code;
        this.context = context;
        this.error = error;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Application-specific error code.
     */
    @JsonProperty("code")
    public Optional<Integer> getCode() {
        return code;
    }

    /**
     * @return Application context.
     */
    @JsonProperty("context")
    public Optional<Map<String, Object>> getContext() {
        return context;
    }

    /**
     * @return Error message.
     */
    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    /**
     * @return Status text.
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RestErrResponse && equalTo((RestErrResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RestErrResponse other) {
        return code.equals(other.code)
                && context.equals(other.context)
                && error.equals(other.error)
                && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.context, this.error, this.status);
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
        private Optional<Integer> code = Optional.empty();

        private Optional<Map<String, Object>> context = Optional.empty();

        private Optional<String> error = Optional.empty();

        private Optional<String> status = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RestErrResponse other) {
            code(other.getCode());
            context(other.getContext());
            error(other.getError());
            status(other.getStatus());
            return this;
        }

        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public Builder code(Optional<Integer> code) {
            this.code = code;
            return this;
        }

        public Builder code(Integer code) {
            this.code = Optional.of(code);
            return this;
        }

        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public Builder context(Optional<Map<String, Object>> context) {
            this.context = context;
            return this;
        }

        public Builder context(Map<String, Object> context) {
            this.context = Optional.of(context);
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        public RestErrResponse build() {
            return new RestErrResponse(code, context, error, status, additionalProperties);
        }
    }
}