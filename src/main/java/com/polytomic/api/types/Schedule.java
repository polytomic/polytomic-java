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
@JsonDeserialize(builder = Schedule.Builder.class)
public final class Schedule {
    private final Optional<String> connectionId;

    private final Optional<String> dayOfMonth;

    private final Optional<String> dayOfWeek;

    private final Optional<ScheduleFrequency> frequency;

    private final Optional<String> hour;

    private final Optional<Integer> jobId;

    private final Optional<String> minute;

    private final Optional<String> month;

    private final Optional<RunAfter> runAfter;

    private final Optional<Boolean> runAfterSuccessOnly;

    private final Map<String, Object> additionalProperties;

    private Schedule(
            Optional<String> connectionId,
            Optional<String> dayOfMonth,
            Optional<String> dayOfWeek,
            Optional<ScheduleFrequency> frequency,
            Optional<String> hour,
            Optional<Integer> jobId,
            Optional<String> minute,
            Optional<String> month,
            Optional<RunAfter> runAfter,
            Optional<Boolean> runAfterSuccessOnly,
            Map<String, Object> additionalProperties) {
        this.connectionId = connectionId;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.frequency = frequency;
        this.hour = hour;
        this.jobId = jobId;
        this.minute = minute;
        this.month = month;
        this.runAfter = runAfter;
        this.runAfterSuccessOnly = runAfterSuccessOnly;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("connection_id")
    public Optional<String> getConnectionId() {
        return connectionId;
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
    public Optional<ScheduleFrequency> getFrequency() {
        return frequency;
    }

    @JsonProperty("hour")
    public Optional<String> getHour() {
        return hour;
    }

    @JsonProperty("job_id")
    public Optional<Integer> getJobId() {
        return jobId;
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
    public Optional<RunAfter> getRunAfter() {
        return runAfter;
    }

    /**
     * @return If true, the sync will only run if the dependent syncs completed successfully.
     */
    @JsonProperty("run_after_success_only")
    public Optional<Boolean> getRunAfterSuccessOnly() {
        return runAfterSuccessOnly;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Schedule && equalTo((Schedule) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Schedule other) {
        return connectionId.equals(other.connectionId)
                && dayOfMonth.equals(other.dayOfMonth)
                && dayOfWeek.equals(other.dayOfWeek)
                && frequency.equals(other.frequency)
                && hour.equals(other.hour)
                && jobId.equals(other.jobId)
                && minute.equals(other.minute)
                && month.equals(other.month)
                && runAfter.equals(other.runAfter)
                && runAfterSuccessOnly.equals(other.runAfterSuccessOnly);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.connectionId,
                this.dayOfMonth,
                this.dayOfWeek,
                this.frequency,
                this.hour,
                this.jobId,
                this.minute,
                this.month,
                this.runAfter,
                this.runAfterSuccessOnly);
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
        private Optional<String> connectionId = Optional.empty();

        private Optional<String> dayOfMonth = Optional.empty();

        private Optional<String> dayOfWeek = Optional.empty();

        private Optional<ScheduleFrequency> frequency = Optional.empty();

        private Optional<String> hour = Optional.empty();

        private Optional<Integer> jobId = Optional.empty();

        private Optional<String> minute = Optional.empty();

        private Optional<String> month = Optional.empty();

        private Optional<RunAfter> runAfter = Optional.empty();

        private Optional<Boolean> runAfterSuccessOnly = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Schedule other) {
            connectionId(other.getConnectionId());
            dayOfMonth(other.getDayOfMonth());
            dayOfWeek(other.getDayOfWeek());
            frequency(other.getFrequency());
            hour(other.getHour());
            jobId(other.getJobId());
            minute(other.getMinute());
            month(other.getMonth());
            runAfter(other.getRunAfter());
            runAfterSuccessOnly(other.getRunAfterSuccessOnly());
            return this;
        }

        @JsonSetter(value = "connection_id", nulls = Nulls.SKIP)
        public Builder connectionId(Optional<String> connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        public Builder connectionId(String connectionId) {
            this.connectionId = Optional.of(connectionId);
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
        public Builder frequency(Optional<ScheduleFrequency> frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder frequency(ScheduleFrequency frequency) {
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

        @JsonSetter(value = "job_id", nulls = Nulls.SKIP)
        public Builder jobId(Optional<Integer> jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder jobId(Integer jobId) {
            this.jobId = Optional.of(jobId);
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
        public Builder runAfter(Optional<RunAfter> runAfter) {
            this.runAfter = runAfter;
            return this;
        }

        public Builder runAfter(RunAfter runAfter) {
            this.runAfter = Optional.of(runAfter);
            return this;
        }

        @JsonSetter(value = "run_after_success_only", nulls = Nulls.SKIP)
        public Builder runAfterSuccessOnly(Optional<Boolean> runAfterSuccessOnly) {
            this.runAfterSuccessOnly = runAfterSuccessOnly;
            return this;
        }

        public Builder runAfterSuccessOnly(Boolean runAfterSuccessOnly) {
            this.runAfterSuccessOnly = Optional.of(runAfterSuccessOnly);
            return this;
        }

        public Schedule build() {
            return new Schedule(
                    connectionId,
                    dayOfMonth,
                    dayOfWeek,
                    frequency,
                    hour,
                    jobId,
                    minute,
                    month,
                    runAfter,
                    runAfterSuccessOnly,
                    additionalProperties);
        }
    }
}
