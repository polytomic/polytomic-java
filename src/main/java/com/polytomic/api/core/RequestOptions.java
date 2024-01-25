
package com.polytomic.api.core;

import java.util.HashMap;
import java.util.Map;

public final class RequestOptions {
    private final String token;

    private final String polytomicVersion;

    private RequestOptions(String token, String polytomicVersion) {
        this.token = token;
        this.polytomicVersion = polytomicVersion;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        if (this.token != null) {
            headers.put("Authorization", "Bearer " + this.token);
        }
        if (this.polytomicVersion != null) {
            headers.put("X-Polytomic-Version", this.polytomicVersion);
        }
        return headers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String token = null;

        private String polytomicVersion = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder polytomicVersion(String polytomicVersion) {
            this.polytomicVersion = polytomicVersion;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(token, polytomicVersion);
        }
    }
}