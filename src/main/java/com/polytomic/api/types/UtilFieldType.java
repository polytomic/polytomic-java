/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UtilFieldType {
    UNKNOWN("unknown"),

    STRING("string"),

    NUMBER("number"),

    BOOLEAN("boolean"),

    DATETIME("datetime"),

    ARRAY("array"),

    OBJECT("object");

    private final String value;

    UtilFieldType(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}