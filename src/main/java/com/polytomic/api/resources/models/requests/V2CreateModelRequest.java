
package com.polytomic.api.resources.models.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.V2ModelFieldRequest;
import com.polytomic.api.types.V2Relation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2CreateModelRequest.Builder.class)
public final class V2CreateModelRequest {
    private final Optional<List<V2ModelFieldRequest>> additionalFields;

    private final Optional<Map<String, Object>> configuration;

    private final String connectionId;

    private final Optional<List<String>> fields;

    private final Optional<String> identifier;

    private final Optional<List<String>> labels;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<List<V2Relation>> relations;

    private final Optional<List<String>> trackingColumns;

    private final Map<String, Object> additionalProperties;

    private V2CreateModelRequest(
            Optional<List<V2ModelFieldRequest>> additionalFields,
            Optional<Map<String, Object>> configuration,
            String connectionId,
            Optional<List<String>> fields,
            Optional<String> identifier,
            Optional<List<String>> labels,
            String name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<List<V2Relation>> relations,
            Optional<List<String>> trackingColumns,
            Map<String, Object> additionalProperties) {
        this.additionalFields = additionalFields;
        this.configuration = configuration;
        this.connectionId = connectionId;
        this.fields = fields;
        this.identifier = identifier;
        this.labels = labels;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.relations = relations;
        this.trackingColumns = trackingColumns;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("additional_fields")
    public Optional<List<V2ModelFieldRequest>> getAdditionalFields() {
        return additionalFields;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("connection_id")
    public String getConnectionId() {
        return connectionId;
    }

    @JsonProperty("fields")
    public Optional<List<String>> getFields() {
        return fields;
    }

    @JsonProperty("identifier")
    public Optional<String> getIdentifier() {
        return identifier;
    }

    @JsonProperty("labels")
    public Optional<List<String>> getLabels() {
        return labels;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("policies")
    public Optional<List<String>> getPolicies() {
        return policies;
    }

    @JsonProperty("relations")
    public Optional<List<V2Relation>> getRelations() {
        return relations;
    }

    @JsonProperty("tracking_columns")
    public Optional<List<String>> getTrackingColumns() {
        return trackingColumns;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2CreateModelRequest && equalTo((V2CreateModelRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2CreateModelRequest other) {
        return additionalFields.equals(other.additionalFields)
                && configuration.equals(other.configuration)
                && connectionId.equals(other.connectionId)
                && fields.equals(other.fields)
                && identifier.equals(other.identifier)
                && labels.equals(other.labels)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && relations.equals(other.relations)
                && trackingColumns.equals(other.trackingColumns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.additionalFields,
                this.configuration,
                this.connectionId,
                this.fields,
                this.identifier,
                this.labels,
                this.name,
                this.organizationId,
                this.policies,
                this.relations,
                this.trackingColumns);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConnectionIdStage builder() {
        return new Builder();
    }

    public interface ConnectionIdStage {
        NameStage connectionId(String connectionId);

        Builder from(V2CreateModelRequest other);
    }

    public interface NameStage {
        _FinalStage name(String name);
    }

    public interface _FinalStage {
        V2CreateModelRequest build();

        _FinalStage additionalFields(Optional<List<V2ModelFieldRequest>> additionalFields);

        _FinalStage additionalFields(List<V2ModelFieldRequest> additionalFields);

        _FinalStage configuration(Optional<Map<String, Object>> configuration);

        _FinalStage configuration(Map<String, Object> configuration);

        _FinalStage fields(Optional<List<String>> fields);

        _FinalStage fields(List<String> fields);

        _FinalStage identifier(Optional<String> identifier);

        _FinalStage identifier(String identifier);

        _FinalStage labels(Optional<List<String>> labels);

        _FinalStage labels(List<String> labels);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage policies(Optional<List<String>> policies);

        _FinalStage policies(List<String> policies);

        _FinalStage relations(Optional<List<V2Relation>> relations);

        _FinalStage relations(List<V2Relation> relations);

        _FinalStage trackingColumns(Optional<List<String>> trackingColumns);

        _FinalStage trackingColumns(List<String> trackingColumns);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConnectionIdStage, NameStage, _FinalStage {
        private String connectionId;

        private String name;

        private Optional<List<String>> trackingColumns = Optional.empty();

        private Optional<List<V2Relation>> relations = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<String>> labels = Optional.empty();

        private Optional<String> identifier = Optional.empty();

        private Optional<List<String>> fields = Optional.empty();

        private Optional<Map<String, Object>> configuration = Optional.empty();

        private Optional<List<V2ModelFieldRequest>> additionalFields = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2CreateModelRequest other) {
            additionalFields(other.getAdditionalFields());
            configuration(other.getConfiguration());
            connectionId(other.getConnectionId());
            fields(other.getFields());
            identifier(other.getIdentifier());
            labels(other.getLabels());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            relations(other.getRelations());
            trackingColumns(other.getTrackingColumns());
            return this;
        }

        @Override
        @JsonSetter("connection_id")
        public NameStage connectionId(String connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public _FinalStage trackingColumns(List<String> trackingColumns) {
            this.trackingColumns = Optional.of(trackingColumns);
            return this;
        }

        @Override
        @JsonSetter(value = "tracking_columns", nulls = Nulls.SKIP)
        public _FinalStage trackingColumns(Optional<List<String>> trackingColumns) {
            this.trackingColumns = trackingColumns;
            return this;
        }

        @Override
        public _FinalStage relations(List<V2Relation> relations) {
            this.relations = Optional.of(relations);
            return this;
        }

        @Override
        @JsonSetter(value = "relations", nulls = Nulls.SKIP)
        public _FinalStage relations(Optional<List<V2Relation>> relations) {
            this.relations = relations;
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
        public _FinalStage labels(List<String> labels) {
            this.labels = Optional.of(labels);
            return this;
        }

        @Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(Optional<List<String>> labels) {
            this.labels = labels;
            return this;
        }

        @Override
        public _FinalStage identifier(String identifier) {
            this.identifier = Optional.of(identifier);
            return this;
        }

        @Override
        @JsonSetter(value = "identifier", nulls = Nulls.SKIP)
        public _FinalStage identifier(Optional<String> identifier) {
            this.identifier = identifier;
            return this;
        }

        @Override
        public _FinalStage fields(List<String> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @Override
        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public _FinalStage fields(Optional<List<String>> fields) {
            this.fields = fields;
            return this;
        }

        @Override
        public _FinalStage configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @Override
        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public _FinalStage configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        @Override
        public _FinalStage additionalFields(List<V2ModelFieldRequest> additionalFields) {
            this.additionalFields = Optional.of(additionalFields);
            return this;
        }

        @Override
        @JsonSetter(value = "additional_fields", nulls = Nulls.SKIP)
        public _FinalStage additionalFields(Optional<List<V2ModelFieldRequest>> additionalFields) {
            this.additionalFields = additionalFields;
            return this;
        }

        @Override
        public V2CreateModelRequest build() {
            return new V2CreateModelRequest(
                    additionalFields,
                    configuration,
                    connectionId,
                    fields,
                    identifier,
                    labels,
                    name,
                    organizationId,
                    policies,
                    relations,
                    trackingColumns,
                    additionalProperties);
        }
    }
}