
package com.polytomic.api.resources.bulksync.executions;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.bulksync.executions.requests.V3StartBulkSyncRequest;
import com.polytomic.api.types.V3BulkSyncExecutionEnvelope;
import com.polytomic.api.types.V3ListBulkSyncExecutionsEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ExecutionsClient {
    protected final ClientOptions clientOptions;

    public ExecutionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public V3ListBulkSyncExecutionsEnvelope list(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("executions")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), V3ListBulkSyncExecutionsEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3ListBulkSyncExecutionsEnvelope list(String id) {
        return list(id, null);
    }

    public V3BulkSyncExecutionEnvelope start(String id) {
        return start(id, V3StartBulkSyncRequest.builder().build());
    }

    public V3BulkSyncExecutionEnvelope start(String id, V3StartBulkSyncRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("executions")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncExecutionEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3BulkSyncExecutionEnvelope start(String id, V3StartBulkSyncRequest request) {
        return start(id, request, null);
    }

    public V3BulkSyncExecutionEnvelope get(String id, String execId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("executions")
                .addPathSegment(execId)
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncExecutionEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3BulkSyncExecutionEnvelope get(String id, String execId) {
        return get(id, execId, null);
    }
}
