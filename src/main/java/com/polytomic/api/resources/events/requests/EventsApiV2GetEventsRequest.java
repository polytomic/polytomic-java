
package com.polytomic.api.resources.events.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EventsApiV2GetEventsRequest.Builder.class)
public final class EventsApiV2GetEventsRequest {
    private final Optional<String> organizationId;

    private final Optional<String> type;

    private final Optional<OffsetDateTime> startingAfter;

    private final Optional<OffsetDateTime> endingBefore;

    private final Optional<Integer> limit;

    private final Map<String, Object> additionalProperties;

    private EventsApiV2GetEventsRequest(
            Optional<String> organizationId,
            Optional<String> type,
            Optional<OffsetDateTime> startingAfter,
            Optional<OffsetDateTime> endingBefore,
            Optional<Integer> limit,
            Map<String, Object> additionalProperties) {
        this.organizationId = organizationId;
        this.type = type;
        this.startingAfter = startingAfter;
        this.endingBefore = endingBefore;
        this.limit = limit;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @JsonProperty("starting_after")
    public Optional<OffsetDateTime> getStartingAfter() {
        return startingAfter;
    }

    @JsonProperty("ending_before")
    public Optional<OffsetDateTime> getEndingBefore() {
        return endingBefore;
    }

    @JsonProperty("limit")
    public Optional<Integer> getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EventsApiV2GetEventsRequest && equalTo((EventsApiV2GetEventsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EventsApiV2GetEventsRequest other) {
        return organizationId.equals(other.organizationId)
                && type.equals(other.type)
                && startingAfter.equals(other.startingAfter)
                && endingBefore.equals(other.endingBefore)
                && limit.equals(other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.organizationId, this.type, this.startingAfter, this.endingBefore, this.limit);
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
        private Optional<String> organizationId = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<OffsetDateTime> startingAfter = Optional.empty();

        private Optional<OffsetDateTime> endingBefore = Optional.empty();

        private Optional<Integer> limit = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EventsApiV2GetEventsRequest other) {
            organizationId(other.getOrganizationId());
            type(other.getType());
            startingAfter(other.getStartingAfter());
            endingBefore(other.getEndingBefore());
            limit(other.getLimit());
            return this;
        }

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "starting_after", nulls = Nulls.SKIP)
        public Builder startingAfter(Optional<OffsetDateTime> startingAfter) {
            this.startingAfter = startingAfter;
            return this;
        }

        public Builder startingAfter(OffsetDateTime startingAfter) {
            this.startingAfter = Optional.of(startingAfter);
            return this;
        }

        @JsonSetter(value = "ending_before", nulls = Nulls.SKIP)
        public Builder endingBefore(Optional<OffsetDateTime> endingBefore) {
            this.endingBefore = endingBefore;
            return this;
        }

        public Builder endingBefore(OffsetDateTime endingBefore) {
            this.endingBefore = Optional.of(endingBefore);
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        public EventsApiV2GetEventsRequest build() {
            return new EventsApiV2GetEventsRequest(
                    organizationId, type, startingAfter, endingBefore, limit, additionalProperties);
        }
    }
}