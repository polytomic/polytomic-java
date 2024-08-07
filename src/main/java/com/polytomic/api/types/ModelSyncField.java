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
@JsonDeserialize(builder = ModelSyncField.Builder.class)
public final class ModelSyncField {
    private final Optional<Boolean> new_;

    private final Optional<String> overrideValue;

    private final Optional<Source> source;

    private final Optional<String> syncMode;

    private final String target;

    private final Map<String, Object> additionalProperties;

    private ModelSyncField(
            Optional<Boolean> new_,
            Optional<String> overrideValue,
            Optional<Source> source,
            Optional<String> syncMode,
            String target,
            Map<String, Object> additionalProperties) {
        this.new_ = new_;
        this.overrideValue = overrideValue;
        this.source = source;
        this.syncMode = syncMode;
        this.target = target;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return New is set to true if the target field should be created by Polytomic. This is not supported by all backends.
     */
    @JsonProperty("new")
    public Optional<Boolean> getNew() {
        return new_;
    }

    /**
     * @return Value to set in the target field; if provided, 'source' is ignored.
     */
    @JsonProperty("override_value")
    public Optional<String> getOverrideValue() {
        return overrideValue;
    }

    @JsonProperty("source")
    public Optional<Source> getSource() {
        return source;
    }

    /**
     * @return Sync mode for the field; defaults to 'updateOrCreate'. If set to 'create', the field will not be synced if it already has a value. This is not supported by all backends.
     */
    @JsonProperty("sync_mode")
    public Optional<String> getSyncMode() {
        return syncMode;
    }

    /**
     * @return Target field ID the source field value will be written to.
     */
    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelSyncField && equalTo((ModelSyncField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelSyncField other) {
        return new_.equals(other.new_)
                && overrideValue.equals(other.overrideValue)
                && source.equals(other.source)
                && syncMode.equals(other.syncMode)
                && target.equals(other.target);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.new_, this.overrideValue, this.source, this.syncMode, this.target);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TargetStage builder() {
        return new Builder();
    }

    public interface TargetStage {
        _FinalStage target(String target);

        Builder from(ModelSyncField other);
    }

    public interface _FinalStage {
        ModelSyncField build();

        _FinalStage new_(Optional<Boolean> new_);

        _FinalStage new_(Boolean new_);

        _FinalStage overrideValue(Optional<String> overrideValue);

        _FinalStage overrideValue(String overrideValue);

        _FinalStage source(Optional<Source> source);

        _FinalStage source(Source source);

        _FinalStage syncMode(Optional<String> syncMode);

        _FinalStage syncMode(String syncMode);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TargetStage, _FinalStage {
        private String target;

        private Optional<String> syncMode = Optional.empty();

        private Optional<Source> source = Optional.empty();

        private Optional<String> overrideValue = Optional.empty();

        private Optional<Boolean> new_ = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ModelSyncField other) {
            new_(other.getNew());
            overrideValue(other.getOverrideValue());
            source(other.getSource());
            syncMode(other.getSyncMode());
            target(other.getTarget());
            return this;
        }

        /**
         * <p>Target field ID the source field value will be written to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("target")
        public _FinalStage target(String target) {
            this.target = target;
            return this;
        }

        /**
         * <p>Sync mode for the field; defaults to 'updateOrCreate'. If set to 'create', the field will not be synced if it already has a value. This is not supported by all backends.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage syncMode(String syncMode) {
            this.syncMode = Optional.of(syncMode);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "sync_mode", nulls = Nulls.SKIP)
        public _FinalStage syncMode(Optional<String> syncMode) {
            this.syncMode = syncMode;
            return this;
        }

        @java.lang.Override
        public _FinalStage source(Source source) {
            this.source = Optional.of(source);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public _FinalStage source(Optional<Source> source) {
            this.source = source;
            return this;
        }

        /**
         * <p>Value to set in the target field; if provided, 'source' is ignored.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage overrideValue(String overrideValue) {
            this.overrideValue = Optional.of(overrideValue);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "override_value", nulls = Nulls.SKIP)
        public _FinalStage overrideValue(Optional<String> overrideValue) {
            this.overrideValue = overrideValue;
            return this;
        }

        /**
         * <p>New is set to true if the target field should be created by Polytomic. This is not supported by all backends.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage new_(Boolean new_) {
            this.new_ = Optional.of(new_);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "new", nulls = Nulls.SKIP)
        public _FinalStage new_(Optional<Boolean> new_) {
            this.new_ = new_;
            return this;
        }

        @java.lang.Override
        public ModelSyncField build() {
            return new ModelSyncField(new_, overrideValue, source, syncMode, target, additionalProperties);
        }
    }
}
