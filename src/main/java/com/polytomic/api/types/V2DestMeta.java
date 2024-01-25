
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
@JsonDeserialize(builder = V2DestMeta.Builder.class)
public final class V2DestMeta {
    private final Optional<String> default_;

    private final Optional<List<String>> items;

    private final Optional<Boolean> required;

    private final Map<String, Object> additionalProperties;

    private V2DestMeta(
            Optional<String> default_,
            Optional<List<String>> items,
            Optional<Boolean> required,
            Map<String, Object> additionalProperties) {
        this.default_ = default_;
        this.items = items;
        this.required = required;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("default")
    public Optional<String> getDefault() {
        return default_;
    }

    @JsonProperty("items")
    public Optional<List<String>> getItems() {
        return items;
    }

    @JsonProperty("required")
    public Optional<Boolean> getRequired() {
        return required;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2DestMeta && equalTo((V2DestMeta) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2DestMeta other) {
        return default_.equals(other.default_) && items.equals(other.items) && required.equals(other.required);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.default_, this.items, this.required);
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
        private Optional<String> default_ = Optional.empty();

        private Optional<List<String>> items = Optional.empty();

        private Optional<Boolean> required = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2DestMeta other) {
            default_(other.getDefault());
            items(other.getItems());
            required(other.getRequired());
            return this;
        }

        @JsonSetter(value = "default", nulls = Nulls.SKIP)
        public Builder default_(Optional<String> default_) {
            this.default_ = default_;
            return this;
        }

        public Builder default_(String default_) {
            this.default_ = Optional.of(default_);
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(Optional<List<String>> items) {
            this.items = items;
            return this;
        }

        public Builder items(List<String> items) {
            this.items = Optional.of(items);
            return this;
        }

        @JsonSetter(value = "required", nulls = Nulls.SKIP)
        public Builder required(Optional<Boolean> required) {
            this.required = required;
            return this;
        }

        public Builder required(Boolean required) {
            this.required = Optional.of(required);
            return this;
        }

        public V2DestMeta build() {
            return new V2DestMeta(default_, items, required, additionalProperties);
        }
    }
}
