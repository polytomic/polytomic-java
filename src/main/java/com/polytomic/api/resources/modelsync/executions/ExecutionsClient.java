package com.polytomic.api.resources.modelsync.executions;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.types.V2GetExecutionResponseEnvelope;
import com.polytomic.api.types.V2ListExecutionResponseEnvelope;
import java.io.IOException;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class ExecutionsClient {
  protected final ClientOptions clientOptions;

  public ExecutionsClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public V2ListExecutionResponseEnvelope list(String syncId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("api/syncs")
      .addPathSegment(syncId)
      .addPathSegments("executions")
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    try {
      Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ListExecutionResponseEnvelope.class);
      }
      throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public V2ListExecutionResponseEnvelope list(String syncId) {
    return list(syncId,null);
  }

  public V2GetExecutionResponseEnvelope get(String syncId, String id,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("api/syncs")
      .addPathSegment(syncId)
      .addPathSegments("executions")
      .addPathSegment(id)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    try {
      Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2GetExecutionResponseEnvelope.class);
      }
      throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public V2GetExecutionResponseEnvelope get(String syncId, String id) {
    return get(syncId,id,null);
  }
}
