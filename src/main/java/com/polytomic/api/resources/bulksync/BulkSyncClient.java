/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.MediaTypes;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.core.Suppliers;
import com.polytomic.api.resources.bulksync.executions.ExecutionsClient;
import com.polytomic.api.resources.bulksync.requests.BulkSyncGetRequest;
import com.polytomic.api.resources.bulksync.requests.BulkSyncGetSourceRequest;
import com.polytomic.api.resources.bulksync.requests.BulkSyncRemoveRequest;
import com.polytomic.api.resources.bulksync.requests.CreateBulkSyncRequest;
import com.polytomic.api.resources.bulksync.requests.StartBulkSyncRequest;
import com.polytomic.api.resources.bulksync.requests.UpdateBulkSyncRequest;
import com.polytomic.api.resources.bulksync.schemas.SchemasClient;
import com.polytomic.api.types.ActivateSyncEnvelope;
import com.polytomic.api.types.ActivateSyncInput;
import com.polytomic.api.types.BulkSyncDestEnvelope;
import com.polytomic.api.types.BulkSyncExecutionEnvelope;
import com.polytomic.api.types.BulkSyncListEnvelope;
import com.polytomic.api.types.BulkSyncResponseEnvelope;
import com.polytomic.api.types.BulkSyncSourceEnvelope;
import com.polytomic.api.types.BulkSyncStatusEnvelope;
import java.io.IOException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BulkSyncClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<ExecutionsClient> executionsClient;

    protected final Supplier<SchemasClient> schemasClient;

    public BulkSyncClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.executionsClient = Suppliers.memoize(() -> new ExecutionsClient(clientOptions));
        this.schemasClient = Suppliers.memoize(() -> new SchemasClient(clientOptions));
    }

    public BulkSyncListEnvelope list() {
        return list(null);
    }

    public BulkSyncListEnvelope list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncListEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncResponseEnvelope create(CreateBulkSyncRequest request) {
        return create(request, null);
    }

    public BulkSyncResponseEnvelope create(CreateBulkSyncRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncResponseEnvelope get(String id) {
        return get(id, BulkSyncGetRequest.builder().build());
    }

    public BulkSyncResponseEnvelope get(String id, BulkSyncGetRequest request) {
        return get(id, request, null);
    }

    public BulkSyncResponseEnvelope get(String id, BulkSyncGetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id);
        if (request.getRefreshSchemas().isPresent()) {
            httpUrl.addQueryParameter(
                    "refresh_schemas", request.getRefreshSchemas().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <blockquote>
     * 📘 Updating schemas
     * <p>Schema updates can be performed using the <a href="https://apidocs.polytomic.com/api-reference/bulk-sync/schemas/patch">Update Bulk Sync Schemas</a> endpoint.</p>
     * </blockquote>
     */
    public BulkSyncResponseEnvelope update(String id, UpdateBulkSyncRequest request) {
        return update(id, request, null);
    }

    /**
     * <blockquote>
     * 📘 Updating schemas
     * <p>Schema updates can be performed using the <a href="https://apidocs.polytomic.com/api-reference/bulk-sync/schemas/patch">Update Bulk Sync Schemas</a> endpoint.</p>
     * </blockquote>
     */
    public BulkSyncResponseEnvelope update(String id, UpdateBulkSyncRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String id) {
        remove(id, BulkSyncRemoveRequest.builder().build());
    }

    public void remove(String id, BulkSyncRemoveRequest request) {
        remove(id, request, null);
    }

    public void remove(String id, BulkSyncRemoveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id);
        if (request.getRefreshSchemas().isPresent()) {
            httpUrl.addQueryParameter(
                    "refresh_schemas", request.getRefreshSchemas().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ActivateSyncEnvelope activate(String id, ActivateSyncInput request) {
        return activate(id, request, null);
    }

    public ActivateSyncEnvelope activate(String id, ActivateSyncInput request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("activate")
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ActivateSyncEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncExecutionEnvelope start(String id) {
        return start(id, StartBulkSyncRequest.builder().build());
    }

    public BulkSyncExecutionEnvelope start(String id, StartBulkSyncRequest request) {
        return start(id, request, null);
    }

    public BulkSyncExecutionEnvelope start(String id, StartBulkSyncRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("executions")
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncExecutionEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncStatusEnvelope getStatus(String id) {
        return getStatus(id, null);
    }

    public BulkSyncStatusEnvelope getStatus(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("status")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncStatusEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncSourceEnvelope getSource(String id) {
        return getSource(id, BulkSyncGetSourceRequest.builder().build());
    }

    public BulkSyncSourceEnvelope getSource(String id, BulkSyncGetSourceRequest request) {
        return getSource(id, request, null);
    }

    public BulkSyncSourceEnvelope getSource(
            String id, BulkSyncGetSourceRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/connections")
                .addPathSegment(id)
                .addPathSegments("bulksync/source");
        if (request.getIncludeFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_fields", request.getIncludeFields().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncSourceEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncDestEnvelope getDestination(String id) {
        return getDestination(id, null);
    }

    public BulkSyncDestEnvelope getDestination(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/connections")
                .addPathSegment(id)
                .addPathSegments("bulksync/target")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), BulkSyncDestEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ExecutionsClient executions() {
        return this.executionsClient.get();
    }

    public SchemasClient schemas() {
        return this.schemasClient.get();
    }
}
