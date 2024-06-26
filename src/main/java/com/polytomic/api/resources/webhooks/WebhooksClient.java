/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.webhooks;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.MediaTypes;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.webhooks.requests.CreateWebhooksSchema;
import com.polytomic.api.resources.webhooks.requests.UpdateWebhooksSchema;
import com.polytomic.api.types.WebhookEnvelope;
import com.polytomic.api.types.WebhookListEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WebhooksClient {
    protected final ClientOptions clientOptions;

    public WebhooksClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookListEnvelope list() {
        return list(null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookListEnvelope list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), WebhookListEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope create(CreateWebhooksSchema request) {
        return create(request, null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope create(CreateWebhooksSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope get(String id) {
        return get(id, null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope update(String id, UpdateWebhooksSchema request) {
        return update(id, request, null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://apidocs.polytomic.com/getting-started/events">Events documentation</a> for more information.</p>
     */
    public WebhookEnvelope update(String id, UpdateWebhooksSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .addPathSegment(id)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String id) {
        remove(id, null);
    }

    public void remove(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
