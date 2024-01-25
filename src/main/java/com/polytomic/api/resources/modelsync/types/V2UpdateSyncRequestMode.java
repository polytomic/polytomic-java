
package com.polytomic.api.resources.modelsync.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum V2UpdateSyncRequestMode {
    UPDATE("update"),

    UPDATE_OR_CREATE("updateOrCreate"),

    CREATE("create"),

    REPLACE("replace"),

    APPEND("append"),

    SNAPSHOT("snapshot");

    private final String value;

    V2UpdateSyncRequestMode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}