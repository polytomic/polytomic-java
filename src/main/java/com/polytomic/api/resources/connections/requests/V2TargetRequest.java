
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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2TargetRequest.Builder.class)
public final class V2TargetRequest {
    private final Optional<Boolean> refresh;

    private final String target;

    private final Map<String, Object> additionalProperties;

    private V2TargetRequest(Optional<Boolean> refresh, String target, Map<String, Object> additionalProperties) {
        this.refresh = refresh;
        this.target = target;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("refresh")
    public Optional<Boolean> getRefresh() {
        return refresh;
    }

    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2TargetRequest && equalTo((V2TargetRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2TargetRequest other) {
        return refresh.equals(other.refresh) && target.equals(other.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.refresh, this.target);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TargetStage builder() {
        return new Builder();
    }

    public interface TargetStage {
        _FinalStage target(String target);

        Builder from(V2TargetRequest other);
    }

    public interface _FinalStage {
        V2TargetRequest build();

        _FinalStage refresh(Optional<Boolean> refresh);

        _FinalStage refresh(Boolean refresh);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TargetStage, _FinalStage {
        private String target;

        private Optional<Boolean> refresh = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2TargetRequest other) {
            refresh(other.getRefresh());
            target(other.getTarget());
            return this;
        }

        @Override
        @JsonSetter("target")
        public _FinalStage target(String target) {
            this.target = target;
            return this;
        }

        @Override
        public _FinalStage refresh(Boolean refresh) {
            this.refresh = Optional.of(refresh);
            return this;
        }

        @Override
        @JsonSetter(value = "refresh", nulls = Nulls.SKIP)
        public _FinalStage refresh(Optional<Boolean> refresh) {
            this.refresh = refresh;
            return this;
        }

        @Override
        public V2TargetRequest build() {
            return new V2TargetRequest(refresh, target, additionalProperties);
        }
    }
}
