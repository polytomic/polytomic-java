
package com.polytomic.api;

import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.Environment;

public final class PolytomicBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public PolytomicBuilder token(String token) {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
        return this;
    }

    public PolytomicBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public PolytomicBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public Polytomic build() {
        this.clientOptionsBuilder.addHeader("X-Polytomic-Version", "2022-12-12");
        clientOptionsBuilder.environment(this.environment);
        return new Polytomic(clientOptionsBuilder.build());
    }
}
