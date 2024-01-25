
package com.polytomic.api.resources.users;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.users.requests.UsersCreateApiKeyRequest;
import com.polytomic.api.resources.users.requests.V2CreateUserRequestSchema;
import com.polytomic.api.resources.users.requests.V2UpdateUserRequestSchema;
import com.polytomic.api.types.V2ApiKeyResponseEnvelope;
import com.polytomic.api.types.V2ListUsersEnvelope;
import com.polytomic.api.types.V2UserEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UsersClient {
    protected final ClientOptions clientOptions;

    public UsersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2ListUsersEnvelope list(String orgId, RequestOptions requestOptions) {
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ListUsersEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2ListUsersEnvelope list(String orgId) {
        return list(orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope create(String orgId, V2CreateUserRequestSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(orgId)
                .addPathSegments("users")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2UserEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope create(String orgId, V2CreateUserRequestSchema request) {
        return create(orgId, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope get(String id, String orgId, RequestOptions requestOptions) {
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2UserEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope get(String id, String orgId) {
        return get(id, orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope remove(String id, String orgId, RequestOptions requestOptions) {
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2UserEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope remove(String id, String orgId) {
        return remove(id, orgId, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope update(
            String id, String orgId, V2UpdateUserRequestSchema request, RequestOptions requestOptions) {
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
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2UserEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2UserEnvelope update(String id, String orgId, V2UpdateUserRequestSchema request) {
        return update(id, orgId, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2ApiKeyResponseEnvelope createApiKey(String orgId, String id) {
        return createApiKey(orgId, id, UsersCreateApiKeyRequest.builder().build());
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2ApiKeyResponseEnvelope createApiKey(
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ApiKeyResponseEnvelope.class);
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
     * 🚧 Requires partner key
     * <p>User endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2ApiKeyResponseEnvelope createApiKey(String orgId, String id, UsersCreateApiKeyRequest request) {
        return createApiKey(orgId, id, request, null);
    }
}
