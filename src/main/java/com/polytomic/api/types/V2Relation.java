
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
@JsonDeserialize(builder = V2Relation.Builder.class)
public final class V2Relation {
    private final Optional<String> from;

    private final Optional<V2RelationTo> to;

    private final Map<String, Object> additionalProperties;

    private V2Relation(Optional<String> from, Optional<V2RelationTo> to, Map<String, Object> additionalProperties) {
        this.from = from;
        this.to = to;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("from")
    public Optional<String> getFrom() {
        return from;
    }

    @JsonProperty("to")
    public Optional<V2RelationTo> getTo() {
        return to;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Relation && equalTo((V2Relation) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Relation other) {
        return from.equals(other.from) && to.equals(other.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.from, this.to);
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
        private Optional<String> from = Optional.empty();

        private Optional<V2RelationTo> to = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2Relation other) {
            from(other.getFrom());
            to(other.getTo());
            return this;
        }

        @JsonSetter(value = "from", nulls = Nulls.SKIP)
        public Builder from(Optional<String> from) {
            this.from = from;
            return this;
        }

        public Builder from(String from) {
            this.from = Optional.of(from);
            return this;
        }

        @JsonSetter(value = "to", nulls = Nulls.SKIP)
        public Builder to(Optional<V2RelationTo> to) {
            this.to = to;
            return this;
        }

        public Builder to(V2RelationTo to) {
            this.to = Optional.of(to);
            return this;
        }

        public V2Relation build() {
            return new V2Relation(from, to, additionalProperties);
        }
    }
}