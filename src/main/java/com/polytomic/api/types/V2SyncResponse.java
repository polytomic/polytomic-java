
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
@JsonDeserialize(builder = V2SyncResponse.Builder.class)
public final class V2SyncResponse {
    private final Optional<Boolean> active;

    private final Optional<List<V2SyncField>> fields;

    private final Optional<String> filterLogic;

    private final Optional<List<V2Filter>> filters;

    private final Optional<String> id;

    private final Optional<V2Identity> identity;

    private final Optional<String> mode;

    private final Optional<String> name;

    private final Optional<String> organizationId;

    private final Optional<List<V2SyncField>> overrideFields;

    private final Optional<List<V2Override>> overrides;

    private final Optional<List<String>> policies;

    private final Optional<V2Schedule> schedule;

    private final Optional<Boolean> syncAllRecords;

    private final Optional<V2Target> target;

    private final Map<String, Object> additionalProperties;

    private V2SyncResponse(
            Optional<Boolean> active,
            Optional<List<V2SyncField>> fields,
            Optional<String> filterLogic,
            Optional<List<V2Filter>> filters,
            Optional<String> id,
            Optional<V2Identity> identity,
            Optional<String> mode,
            Optional<String> name,
            Optional<String> organizationId,
            Optional<List<V2SyncField>> overrideFields,
            Optional<List<V2Override>> overrides,
            Optional<List<String>> policies,
            Optional<V2Schedule> schedule,
            Optional<Boolean> syncAllRecords,
            Optional<V2Target> target,
            Map<String, Object> additionalProperties) {
        this.active = active;
        this.fields = fields;
        this.filterLogic = filterLogic;
        this.filters = filters;
        this.id = id;
        this.identity = identity;
        this.mode = mode;
        this.name = name;
        this.organizationId = organizationId;
        this.overrideFields = overrideFields;
        this.overrides = overrides;
        this.policies = policies;
        this.schedule = schedule;
        this.syncAllRecords = syncAllRecords;
        this.target = target;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    @JsonProperty("fields")
    public Optional<List<V2SyncField>> getFields() {
        return fields;
    }

    @JsonProperty("filter_logic")
    public Optional<String> getFilterLogic() {
        return filterLogic;
    }

    @JsonProperty("filters")
    public Optional<List<V2Filter>> getFilters() {
        return filters;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("identity")
    public Optional<V2Identity> getIdentity() {
        return identity;
    }

    @JsonProperty("mode")
    public Optional<String> getMode() {
        return mode;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("override_fields")
    public Optional<List<V2SyncField>> getOverrideFields() {
        return overrideFields;
    }

    @JsonProperty("overrides")
    public Optional<List<V2Override>> getOverrides() {
        return overrides;
    }

    @JsonProperty("policies")
    public Optional<List<String>> getPolicies() {
        return policies;
    }

    @JsonProperty("schedule")
    public Optional<V2Schedule> getSchedule() {
        return schedule;
    }

    @JsonProperty("sync_all_records")
    public Optional<Boolean> getSyncAllRecords() {
        return syncAllRecords;
    }

    @JsonProperty("target")
    public Optional<V2Target> getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2SyncResponse && equalTo((V2SyncResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2SyncResponse other) {
        return active.equals(other.active)
                && fields.equals(other.fields)
                && filterLogic.equals(other.filterLogic)
                && filters.equals(other.filters)
                && id.equals(other.id)
                && identity.equals(other.identity)
                && mode.equals(other.mode)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && overrideFields.equals(other.overrideFields)
                && overrides.equals(other.overrides)
                && policies.equals(other.policies)
                && schedule.equals(other.schedule)
                && syncAllRecords.equals(other.syncAllRecords)
                && target.equals(other.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.active,
                this.fields,
                this.filterLogic,
                this.filters,
                this.id,
                this.identity,
                this.mode,
                this.name,
                this.organizationId,
                this.overrideFields,
                this.overrides,
                this.policies,
                this.schedule,
                this.syncAllRecords,
                this.target);
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
        private Optional<Boolean> active = Optional.empty();

        private Optional<List<V2SyncField>> fields = Optional.empty();

        private Optional<String> filterLogic = Optional.empty();

        private Optional<List<V2Filter>> filters = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<V2Identity> identity = Optional.empty();

        private Optional<String> mode = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<V2SyncField>> overrideFields = Optional.empty();

        private Optional<List<V2Override>> overrides = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<V2Schedule> schedule = Optional.empty();

        private Optional<Boolean> syncAllRecords = Optional.empty();

        private Optional<V2Target> target = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2SyncResponse other) {
            active(other.getActive());
            fields(other.getFields());
            filterLogic(other.getFilterLogic());
            filters(other.getFilters());
            id(other.getId());
            identity(other.getIdentity());
            mode(other.getMode());
            name(other.getName());
            organizationId(other.getOrganizationId());
            overrideFields(other.getOverrideFields());
            overrides(other.getOverrides());
            policies(other.getPolicies());
            schedule(other.getSchedule());
            syncAllRecords(other.getSyncAllRecords());
            target(other.getTarget());
            return this;
        }

        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public Builder active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<V2SyncField>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<V2SyncField> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @JsonSetter(value = "filter_logic", nulls = Nulls.SKIP)
        public Builder filterLogic(Optional<String> filterLogic) {
            this.filterLogic = filterLogic;
            return this;
        }

        public Builder filterLogic(String filterLogic) {
            this.filterLogic = Optional.of(filterLogic);
            return this;
        }

        @JsonSetter(value = "filters", nulls = Nulls.SKIP)
        public Builder filters(Optional<List<V2Filter>> filters) {
            this.filters = filters;
            return this;
        }

        public Builder filters(List<V2Filter> filters) {
            this.filters = Optional.of(filters);
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

        @JsonSetter(value = "identity", nulls = Nulls.SKIP)
        public Builder identity(Optional<V2Identity> identity) {
            this.identity = identity;
            return this;
        }

        public Builder identity(V2Identity identity) {
            this.identity = Optional.of(identity);
            return this;
        }

        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public Builder mode(Optional<String> mode) {
            this.mode = mode;
            return this;
        }

        public Builder mode(String mode) {
            this.mode = Optional.of(mode);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
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

        @JsonSetter(value = "override_fields", nulls = Nulls.SKIP)
        public Builder overrideFields(Optional<List<V2SyncField>> overrideFields) {
            this.overrideFields = overrideFields;
            return this;
        }

        public Builder overrideFields(List<V2SyncField> overrideFields) {
            this.overrideFields = Optional.of(overrideFields);
            return this;
        }

        @JsonSetter(value = "overrides", nulls = Nulls.SKIP)
        public Builder overrides(Optional<List<V2Override>> overrides) {
            this.overrides = overrides;
            return this;
        }

        public Builder overrides(List<V2Override> overrides) {
            this.overrides = Optional.of(overrides);
            return this;
        }

        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public Builder policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        public Builder policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @JsonSetter(value = "schedule", nulls = Nulls.SKIP)
        public Builder schedule(Optional<V2Schedule> schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder schedule(V2Schedule schedule) {
            this.schedule = Optional.of(schedule);
            return this;
        }

        @JsonSetter(value = "sync_all_records", nulls = Nulls.SKIP)
        public Builder syncAllRecords(Optional<Boolean> syncAllRecords) {
            this.syncAllRecords = syncAllRecords;
            return this;
        }

        public Builder syncAllRecords(Boolean syncAllRecords) {
            this.syncAllRecords = Optional.of(syncAllRecords);
            return this;
        }

        @JsonSetter(value = "target", nulls = Nulls.SKIP)
        public Builder target(Optional<V2Target> target) {
            this.target = target;
            return this;
        }

        public Builder target(V2Target target) {
            this.target = Optional.of(target);
            return this;
        }

        public V2SyncResponse build() {
            return new V2SyncResponse(
                    active,
                    fields,
                    filterLogic,
                    filters,
                    id,
                    identity,
                    mode,
                    name,
                    organizationId,
                    overrideFields,
                    overrides,
                    policies,
                    schedule,
                    syncAllRecords,
                    target,
                    additionalProperties);
        }
    }
}