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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateModelRequest.Builder.class)
public final class CreateModelRequest {
    private final Optional<List<ModelModelFieldRequest>> additionalFields;

    private final Map<String, Object> configuration;

    private final String connectionId;

    private final Optional<Enrichment> enricher;

    private final Optional<List<String>> fields;

    private final Optional<String> identifier;

    private final Optional<List<String>> labels;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<List<ModelRelation>> relations;

    private final Optional<List<String>> trackingColumns;

    private final Map<String, Object> additionalProperties;

    private CreateModelRequest(
            Optional<List<ModelModelFieldRequest>> additionalFields,
            Map<String, Object> configuration,
            String connectionId,
            Optional<Enrichment> enricher,
            Optional<List<String>> fields,
            Optional<String> identifier,
            Optional<List<String>> labels,
            String name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<List<ModelRelation>> relations,
            Optional<List<String>> trackingColumns,
            Map<String, Object> additionalProperties) {
        this.additionalFields = additionalFields;
        this.configuration = configuration;
        this.connectionId = connectionId;
        this.enricher = enricher;
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
    public Optional<List<ModelModelFieldRequest>> getAdditionalFields() {
        return additionalFields;
    }

    @JsonProperty("configuration")
    public Map<String, Object> getConfiguration() {
        return configuration;
    }

    @JsonProperty("connection_id")
    public String getConnectionId() {
        return connectionId;
    }

    @JsonProperty("enricher")
    public Optional<Enrichment> getEnricher() {
        return enricher;
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
    public Optional<List<ModelRelation>> getRelations() {
        return relations;
    }

    @JsonProperty("tracking_columns")
    public Optional<List<String>> getTrackingColumns() {
        return trackingColumns;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateModelRequest && equalTo((CreateModelRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateModelRequest other) {
        return additionalFields.equals(other.additionalFields)
                && configuration.equals(other.configuration)
                && connectionId.equals(other.connectionId)
                && enricher.equals(other.enricher)
                && fields.equals(other.fields)
                && identifier.equals(other.identifier)
                && labels.equals(other.labels)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && relations.equals(other.relations)
                && trackingColumns.equals(other.trackingColumns);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.additionalFields,
                this.configuration,
                this.connectionId,
                this.enricher,
                this.fields,
                this.identifier,
                this.labels,
                this.name,
                this.organizationId,
                this.policies,
                this.relations,
                this.trackingColumns);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConnectionIdStage builder() {
        return new Builder();
    }

    public interface ConnectionIdStage {
        NameStage connectionId(String connectionId);

        Builder from(CreateModelRequest other);
    }

    public interface NameStage {
        _FinalStage name(String name);
    }

    public interface _FinalStage {
        CreateModelRequest build();

        _FinalStage additionalFields(Optional<List<ModelModelFieldRequest>> additionalFields);

        _FinalStage additionalFields(List<ModelModelFieldRequest> additionalFields);

        _FinalStage configuration(Map<String, Object> configuration);

        _FinalStage putAllConfiguration(Map<String, Object> configuration);

        _FinalStage configuration(String key, Object value);

        _FinalStage enricher(Optional<Enrichment> enricher);

        _FinalStage enricher(Enrichment enricher);

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

        _FinalStage relations(Optional<List<ModelRelation>> relations);

        _FinalStage relations(List<ModelRelation> relations);

        _FinalStage trackingColumns(Optional<List<String>> trackingColumns);

        _FinalStage trackingColumns(List<String> trackingColumns);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConnectionIdStage, NameStage, _FinalStage {
        private String connectionId;

        private String name;

        private Optional<List<String>> trackingColumns = Optional.empty();

        private Optional<List<ModelRelation>> relations = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<String>> labels = Optional.empty();

        private Optional<String> identifier = Optional.empty();

        private Optional<List<String>> fields = Optional.empty();

        private Optional<Enrichment> enricher = Optional.empty();

        private Map<String, Object> configuration = new LinkedHashMap<>();

        private Optional<List<ModelModelFieldRequest>> additionalFields = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateModelRequest other) {
            additionalFields(other.getAdditionalFields());
            configuration(other.getConfiguration());
            connectionId(other.getConnectionId());
            enricher(other.getEnricher());
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

        @java.lang.Override
        @JsonSetter("connection_id")
        public NameStage connectionId(String connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        public _FinalStage trackingColumns(List<String> trackingColumns) {
            this.trackingColumns = Optional.of(trackingColumns);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "tracking_columns", nulls = Nulls.SKIP)
        public _FinalStage trackingColumns(Optional<List<String>> trackingColumns) {
            this.trackingColumns = trackingColumns;
            return this;
        }

        @java.lang.Override
        public _FinalStage relations(List<ModelRelation> relations) {
            this.relations = Optional.of(relations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "relations", nulls = Nulls.SKIP)
        public _FinalStage relations(Optional<List<ModelRelation>> relations) {
            this.relations = relations;
            return this;
        }

        @java.lang.Override
        public _FinalStage policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public _FinalStage policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        @java.lang.Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @java.lang.Override
        public _FinalStage labels(List<String> labels) {
            this.labels = Optional.of(labels);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(Optional<List<String>> labels) {
            this.labels = labels;
            return this;
        }

        @java.lang.Override
        public _FinalStage identifier(String identifier) {
            this.identifier = Optional.of(identifier);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "identifier", nulls = Nulls.SKIP)
        public _FinalStage identifier(Optional<String> identifier) {
            this.identifier = identifier;
            return this;
        }

        @java.lang.Override
        public _FinalStage fields(List<String> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public _FinalStage fields(Optional<List<String>> fields) {
            this.fields = fields;
            return this;
        }

        @java.lang.Override
        public _FinalStage enricher(Enrichment enricher) {
            this.enricher = Optional.of(enricher);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "enricher", nulls = Nulls.SKIP)
        public _FinalStage enricher(Optional<Enrichment> enricher) {
            this.enricher = enricher;
            return this;
        }

        @java.lang.Override
        public _FinalStage configuration(String key, Object value) {
            this.configuration.put(key, value);
            return this;
        }

        @java.lang.Override
        public _FinalStage putAllConfiguration(Map<String, Object> configuration) {
            this.configuration.putAll(configuration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public _FinalStage configuration(Map<String, Object> configuration) {
            this.configuration.clear();
            this.configuration.putAll(configuration);
            return this;
        }

        @java.lang.Override
        public _FinalStage additionalFields(List<ModelModelFieldRequest> additionalFields) {
            this.additionalFields = Optional.of(additionalFields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "additional_fields", nulls = Nulls.SKIP)
        public _FinalStage additionalFields(Optional<List<ModelModelFieldRequest>> additionalFields) {
            this.additionalFields = additionalFields;
            return this;
        }

        @java.lang.Override
        public CreateModelRequest build() {
            return new CreateModelRequest(
                    additionalFields,
                    configuration,
                    connectionId,
                    enricher,
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
