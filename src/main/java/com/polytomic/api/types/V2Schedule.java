
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
@JsonDeserialize(builder = V2Schedule.Builder.class)
public final class V2Schedule {
    private final Optional<String> dayOfMonth;

    private final Optional<String> dayOfWeek;

    private final Optional<String> frequency;

    private final Optional<String> hour;

    private final Optional<String> minute;

    private final Optional<String> month;

    private final Optional<V2RunAfter> runAfter;

    private final Map<String, Object> additionalProperties;

    private V2Schedule(
            Optional<String> dayOfMonth,
            Optional<String> dayOfWeek,
            Optional<String> frequency,
            Optional<String> hour,
            Optional<String> minute,
            Optional<String> month,
            Optional<V2RunAfter> runAfter,
            Map<String, Object> additionalProperties) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.frequency = frequency;
        this.hour = hour;
        this.minute = minute;
        this.month = month;
        this.runAfter = runAfter;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("day_of_month")
    public Optional<String> getDayOfMonth() {
        return dayOfMonth;
    }

    @JsonProperty("day_of_week")
    public Optional<String> getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonProperty("frequency")
    public Optional<String> getFrequency() {
        return frequency;
    }

    @JsonProperty("hour")
    public Optional<String> getHour() {
        return hour;
    }

    @JsonProperty("minute")
    public Optional<String> getMinute() {
        return minute;
    }

    @JsonProperty("month")
    public Optional<String> getMonth() {
        return month;
    }

    @JsonProperty("run_after")
    public Optional<V2RunAfter> getRunAfter() {
        return runAfter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Schedule && equalTo((V2Schedule) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Schedule other) {
        return dayOfMonth.equals(other.dayOfMonth)
                && dayOfWeek.equals(other.dayOfWeek)
                && frequency.equals(other.frequency)
                && hour.equals(other.hour)
                && minute.equals(other.minute)
                && month.equals(other.month)
                && runAfter.equals(other.runAfter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.dayOfMonth, this.dayOfWeek, this.frequency, this.hour, this.minute, this.month, this.runAfter);
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
        private Optional<String> dayOfMonth = Optional.empty();

        private Optional<String> dayOfWeek = Optional.empty();

        private Optional<String> frequency = Optional.empty();

        private Optional<String> hour = Optional.empty();

        private Optional<String> minute = Optional.empty();

        private Optional<String> month = Optional.empty();

        private Optional<V2RunAfter> runAfter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2Schedule other) {
            dayOfMonth(other.getDayOfMonth());
            dayOfWeek(other.getDayOfWeek());
            frequency(other.getFrequency());
            hour(other.getHour());
            minute(other.getMinute());
            month(other.getMonth());
            runAfter(other.getRunAfter());
            return this;
        }

        @JsonSetter(value = "day_of_month", nulls = Nulls.SKIP)
        public Builder dayOfMonth(Optional<String> dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
            return this;
        }

        public Builder dayOfMonth(String dayOfMonth) {
            this.dayOfMonth = Optional.of(dayOfMonth);
            return this;
        }

        @JsonSetter(value = "day_of_week", nulls = Nulls.SKIP)
        public Builder dayOfWeek(Optional<String> dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder dayOfWeek(String dayOfWeek) {
            this.dayOfWeek = Optional.of(dayOfWeek);
            return this;
        }

        @JsonSetter(value = "frequency", nulls = Nulls.SKIP)
        public Builder frequency(Optional<String> frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder frequency(String frequency) {
            this.frequency = Optional.of(frequency);
            return this;
        }

        @JsonSetter(value = "hour", nulls = Nulls.SKIP)
        public Builder hour(Optional<String> hour) {
            this.hour = hour;
            return this;
        }

        public Builder hour(String hour) {
            this.hour = Optional.of(hour);
            return this;
        }

        @JsonSetter(value = "minute", nulls = Nulls.SKIP)
        public Builder minute(Optional<String> minute) {
            this.minute = minute;
            return this;
        }

        public Builder minute(String minute) {
            this.minute = Optional.of(minute);
            return this;
        }

        @JsonSetter(value = "month", nulls = Nulls.SKIP)
        public Builder month(Optional<String> month) {
            this.month = month;
            return this;
        }

        public Builder month(String month) {
            this.month = Optional.of(month);
            return this;
        }

        @JsonSetter(value = "run_after", nulls = Nulls.SKIP)
        public Builder runAfter(Optional<V2RunAfter> runAfter) {
            this.runAfter = runAfter;
            return this;
        }

        public Builder runAfter(V2RunAfter runAfter) {
            this.runAfter = Optional.of(runAfter);
            return this;
        }

        public V2Schedule build() {
            return new V2Schedule(
                    dayOfMonth, dayOfWeek, frequency, hour, minute, month, runAfter, additionalProperties);
        }
    }
}
