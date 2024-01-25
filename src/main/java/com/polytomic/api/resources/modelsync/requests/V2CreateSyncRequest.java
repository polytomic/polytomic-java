
package com.polytomic.api.resources.modelsync.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.resources.modelsync.types.V2CreateSyncRequestMode;
import com.polytomic.api.types.V2Filter;
import com.polytomic.api.types.V2Identity;
import com.polytomic.api.types.V2Override;
import com.polytomic.api.types.V2Schedule;
import com.polytomic.api.types.V2SyncField;
import com.polytomic.api.types.V2Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2CreateSyncRequest.Builder.class)
public final class V2CreateSyncRequest {
    private final Optional<Boolean> active;

    private final Optional<List<V2SyncField>> fields;

    private final Optional<String> filterLogic;

    private final Optional<List<V2Filter>> filters;

    private final Optional<V2Identity> identity;

    private final V2CreateSyncRequestMode mode;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<V2SyncField>> overrideFields;

    private final Optional<List<V2Override>> overrides;

    private final Optional<List<String>> policies;

    private final V2Schedule schedule;

    private final Optional<Boolean> syncAllRecords;

    private final V2Target target;

    private final Map<String, Object> additionalProperties;

    private V2CreateSyncRequest(
            Optional<Boolean> active,
            Optional<List<V2SyncField>> fields,
            Optional<String> filterLogic,
            Optional<List<V2Filter>> filters,
            Optional<V2Identity> identity,
            V2CreateSyncRequestMode mode,
            String name,
            Optional<String> organizationId,
            Optional<List<V2SyncField>> overrideFields,
            Optional<List<V2Override>> overrides,
            Optional<List<String>> policies,
            V2Schedule schedule,
            Optional<Boolean> syncAllRecords,
            V2Target target,
            Map<String, Object> additionalProperties) {
        this.active = active;
        this.fields = fields;
        this.filterLogic = filterLogic;
        this.filters = filters;
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

    @JsonProperty("identity")
    public Optional<V2Identity> getIdentity() {
        return identity;
    }

    @JsonProperty("mode")
    public V2CreateSyncRequestMode getMode() {
        return mode;
    }

    @JsonProperty("name")
    public String getName() {
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
    public V2Schedule getSchedule() {
        return schedule;
    }

    @JsonProperty("sync_all_records")
    public Optional<Boolean> getSyncAllRecords() {
        return syncAllRecords;
    }

    @JsonProperty("target")
    public V2Target getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2CreateSyncRequest && equalTo((V2CreateSyncRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2CreateSyncRequest other) {
        return active.equals(other.active)
                && fields.equals(other.fields)
                && filterLogic.equals(other.filterLogic)
                && filters.equals(other.filters)
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

    public static ModeStage builder() {
        return new Builder();
    }

    public interface ModeStage {
        NameStage mode(V2CreateSyncRequestMode mode);

        Builder from(V2CreateSyncRequest other);
    }

    public interface NameStage {
        ScheduleStage name(String name);
    }

    public interface ScheduleStage {
        TargetStage schedule(V2Schedule schedule);
    }

    public interface TargetStage {
        _FinalStage target(V2Target target);
    }

    public interface _FinalStage {
        V2CreateSyncRequest build();

        _FinalStage active(Optional<Boolean> active);

        _FinalStage active(Boolean active);

        _FinalStage fields(Optional<List<V2SyncField>> fields);

        _FinalStage fields(List<V2SyncField> fields);

        _FinalStage filterLogic(Optional<String> filterLogic);

        _FinalStage filterLogic(String filterLogic);

        _FinalStage filters(Optional<List<V2Filter>> filters);

        _FinalStage filters(List<V2Filter> filters);

        _FinalStage identity(Optional<V2Identity> identity);

        _FinalStage identity(V2Identity identity);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage overrideFields(Optional<List<V2SyncField>> overrideFields);

        _FinalStage overrideFields(List<V2SyncField> overrideFields);

        _FinalStage overrides(Optional<List<V2Override>> overrides);

        _FinalStage overrides(List<V2Override> overrides);

        _FinalStage policies(Optional<List<String>> policies);

        _FinalStage policies(List<String> policies);

        _FinalStage syncAllRecords(Optional<Boolean> syncAllRecords);

        _FinalStage syncAllRecords(Boolean syncAllRecords);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModeStage, NameStage, ScheduleStage, TargetStage, _FinalStage {
        private V2CreateSyncRequestMode mode;

        private String name;

        private V2Schedule schedule;

        private V2Target target;

        private Optional<Boolean> syncAllRecords = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<List<V2Override>> overrides = Optional.empty();

        private Optional<List<V2SyncField>> overrideFields = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<V2Identity> identity = Optional.empty();

        private Optional<List<V2Filter>> filters = Optional.empty();

        private Optional<String> filterLogic = Optional.empty();

        private Optional<List<V2SyncField>> fields = Optional.empty();

        private Optional<Boolean> active = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2CreateSyncRequest other) {
            active(other.getActive());
            fields(other.getFields());
            filterLogic(other.getFilterLogic());
            filters(other.getFilters());
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

        @Override
        @JsonSetter("mode")
        public NameStage mode(V2CreateSyncRequestMode mode) {
            this.mode = mode;
            return this;
        }

        @Override
        @JsonSetter("name")
        public ScheduleStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("schedule")
        public TargetStage schedule(V2Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        @Override
        @JsonSetter("target")
        public _FinalStage target(V2Target target) {
            this.target = target;
            return this;
        }

        @Override
        public _FinalStage syncAllRecords(Boolean syncAllRecords) {
            this.syncAllRecords = Optional.of(syncAllRecords);
            return this;
        }

        @Override
        @JsonSetter(value = "sync_all_records", nulls = Nulls.SKIP)
        public _FinalStage syncAllRecords(Optional<Boolean> syncAllRecords) {
            this.syncAllRecords = syncAllRecords;
            return this;
        }

        @Override
        public _FinalStage policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @Override
        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public _FinalStage policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        @Override
        public _FinalStage overrides(List<V2Override> overrides) {
            this.overrides = Optional.of(overrides);
            return this;
        }

        @Override
        @JsonSetter(value = "overrides", nulls = Nulls.SKIP)
        public _FinalStage overrides(Optional<List<V2Override>> overrides) {
            this.overrides = overrides;
            return this;
        }

        @Override
        public _FinalStage overrideFields(List<V2SyncField> overrideFields) {
            this.overrideFields = Optional.of(overrideFields);
            return this;
        }

        @Override
        @JsonSetter(value = "override_fields", nulls = Nulls.SKIP)
        public _FinalStage overrideFields(Optional<List<V2SyncField>> overrideFields) {
            this.overrideFields = overrideFields;
            return this;
        }

        @Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @Override
        public _FinalStage identity(V2Identity identity) {
            this.identity = Optional.of(identity);
            return this;
        }

        @Override
        @JsonSetter(value = "identity", nulls = Nulls.SKIP)
        public _FinalStage identity(Optional<V2Identity> identity) {
            this.identity = identity;
            return this;
        }

        @Override
        public _FinalStage filters(List<V2Filter> filters) {
            this.filters = Optional.of(filters);
            return this;
        }

        @Override
        @JsonSetter(value = "filters", nulls = Nulls.SKIP)
        public _FinalStage filters(Optional<List<V2Filter>> filters) {
            this.filters = filters;
            return this;
        }

        @Override
        public _FinalStage filterLogic(String filterLogic) {
            this.filterLogic = Optional.of(filterLogic);
            return this;
        }

        @Override
        @JsonSetter(value = "filter_logic", nulls = Nulls.SKIP)
        public _FinalStage filterLogic(Optional<String> filterLogic) {
            this.filterLogic = filterLogic;
            return this;
        }

        @Override
        public _FinalStage fields(List<V2SyncField> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @Override
        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public _FinalStage fields(Optional<List<V2SyncField>> fields) {
            this.fields = fields;
            return this;
        }

        @Override
        public _FinalStage active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        @Override
        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public _FinalStage active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        @Override
        public V2CreateSyncRequest build() {
            return new V2CreateSyncRequest(
                    active,
                    fields,
                    filterLogic,
                    filters,
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
