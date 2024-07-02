/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.bulksync.executions;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.bulksync.executions.requests.ExecutionsListStatusRequest;
import com.polytomic.api.types.BulkSyncExecutionEnvelope;
import com.polytomic.api.types.ListBulkSyncExecutionStatusEnvelope;
import com.polytomic.api.types.ListBulkSyncExecutionsEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ExecutionsClient {
    protected final ClientOptions clientOptions;

    public ExecutionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ListBulkSyncExecutionStatusEnvelope listStatus() {
        return listStatus(ExecutionsListStatusRequest.builder().build());
    }

    public ListBulkSyncExecutionStatusEnvelope listStatus(ExecutionsListStatusRequest request) {
        return listStatus(request, null);
    }

    public ListBulkSyncExecutionStatusEnvelope listStatus(
            ExecutionsListStatusRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs/status");
        if (request.getAll().isPresent()) {
            httpUrl.addQueryParameter("all", request.getAll().get().toString());
        }
        if (request.getActive().isPresent()) {
            httpUrl.addQueryParameter("active", request.getActive().get().toString());
        }
        if (request.getSyncId().isPresent()) {
            httpUrl.addQueryParameter("sync_id", request.getSyncId().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), ListBulkSyncExecutionStatusEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ListBulkSyncExecutionsEnvelope list(String id) {
        return list(id, null);
    }

    public ListBulkSyncExecutionsEnvelope list(String id, RequestOptions requestOptions) {
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
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListBulkSyncExecutionsEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BulkSyncExecutionEnvelope get(String id, String execId) {
        return get(id, execId, null);
    }

    public BulkSyncExecutionEnvelope get(String id, String execId, RequestOptions requestOptions) {
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
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkSyncExecutionEnvelope.class);
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
