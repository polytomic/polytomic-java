/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.users;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.MediaTypes;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.users.requests.CreateUserRequestSchema;
import com.polytomic.api.resources.users.requests.UpdateUserRequestSchema;
import com.polytomic.api.resources.users.requests.UsersCreateApiKeyRequest;
import com.polytomic.api.types.ApiKeyResponseEnvelope;
import com.polytomic.api.types.ListUsersEnvelope;
import com.polytomic.api.types.UserEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UsersClient {
    protected final ClientOptions clientOptions;

    public UsersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public ListUsersEnvelope list(String orgId) {
        return list(orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public ListUsersEnvelope list(String orgId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListUsersEnvelope.class);
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
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope create(String orgId, CreateUserRequestSchema request) {
        return create(orgId, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope create(String orgId, CreateUserRequestSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserEnvelope.class);
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
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope get(String id, String orgId) {
        return get(id, orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope get(String id, String orgId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserEnvelope.class);
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
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope update(String id, String orgId, UpdateUserRequestSchema request) {
        return update(id, orgId, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope update(
            String id, String orgId, UpdateUserRequestSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserEnvelope.class);
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
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope remove(String id, String orgId) {
        return remove(id, orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public UserEnvelope remove(String id, String orgId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserEnvelope.class);
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
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public ApiKeyResponseEnvelope createApiKey(String orgId, String id) {
        return createApiKey(orgId, id, UsersCreateApiKeyRequest.builder().build());
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public ApiKeyResponseEnvelope createApiKey(String orgId, String id, UsersCreateApiKeyRequest request) {
        return createApiKey(orgId, id, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://apidocs.polytomic.com/guides/obtaining-api-keys#partner-keys">partner keys</a>.</p>
     * </blockquote>
     */
    public ApiKeyResponseEnvelope createApiKey(
            String orgId, String id, UsersCreateApiKeyRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
                .addPathSegment(id)
                .addPathSegments("keys");
        if (request.getForce().isPresent()) {
            httpUrl.addQueryParameter("force", request.getForce().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", RequestBody.create("", null))
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ApiKeyResponseEnvelope.class);
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
