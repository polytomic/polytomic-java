
package com.polytomic.api.resources.schemas;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.types.V3SchemaRecordsResponseEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class SchemasClient {
    protected final ClientOptions clientOptions;

    public SchemasClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public V3SchemaRecordsResponseEnvelope getRecords(
            String connectionId, String schemaId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/connections")
                .addPathSegment(connectionId)
                .addPathSegment(schemaId)
                .addPathSegments("records")
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
                        response.body().string(), V3SchemaRecordsResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3SchemaRecordsResponseEnvelope getRecords(String connectionId, String schemaId) {
        return getRecords(connectionId, schemaId, null);
    }
}
