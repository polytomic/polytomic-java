/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.SchemaConfiguration;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = V2CreateBulkSyncRequestSchemasItem.Deserializer.class)
public final class V2CreateBulkSyncRequestSchemasItem {
    private final Object value;

    private final int type;

    private V2CreateBulkSyncRequestSchemasItem(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((String) this.value);
        } else if (this.type == 1) {
            return visitor.visit((SchemaConfiguration) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2CreateBulkSyncRequestSchemasItem
                && equalTo((V2CreateBulkSyncRequestSchemasItem) other);
    }

    private boolean equalTo(V2CreateBulkSyncRequestSchemasItem other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static V2CreateBulkSyncRequestSchemasItem of(String value) {
        return new V2CreateBulkSyncRequestSchemasItem(value, 0);
    }

    public static V2CreateBulkSyncRequestSchemasItem of(SchemaConfiguration value) {
        return new V2CreateBulkSyncRequestSchemasItem(value, 1);
    }

    public interface Visitor<T> {
        T visit(String value);

        T visit(SchemaConfiguration value);
    }

    static final class Deserializer extends StdDeserializer<V2CreateBulkSyncRequestSchemasItem> {
        Deserializer() {
            super(V2CreateBulkSyncRequestSchemasItem.class);
        }

        @java.lang.Override
        public V2CreateBulkSyncRequestSchemasItem deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, SchemaConfiguration.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
