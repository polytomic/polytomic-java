/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SchemaIdentityFunction {
    EQUALITY("Equality"),

    I_SUBSTRING("ISubstring"),

    ONE_OF("OneOf");

    private final String value;

    SchemaIdentityFunction(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
