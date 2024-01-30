package com.polytomic.api.resources.events;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.events.requests.EventsApiV2GetEventsRequest;
import com.polytomic.api.types.V2EventTypesEnvelope;
import com.polytomic.api.types.V2EventsEnvelope;
import java.io.IOException;
import java.lang.Object;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class EventsClient {
  protected final ClientOptions clientOptions;

  public EventsClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public V2EventsEnvelope apiV2GetEvents() {
    return apiV2GetEvents(EventsApiV2GetEventsRequest.builder().build());
  }

  public V2EventsEnvelope apiV2GetEvents(EventsApiV2GetEventsRequest request,
      RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("api/events");if (request.getOrganizationId().isPresent()) {
        httpUrl.addQueryParameter("organization_id", request.getOrganizationId().get());
      }
      if (request.getType().isPresent()) {
        httpUrl.addQueryParameter("type", request.getType().get());
      }
      if (request.getStartingAfter().isPresent()) {
        httpUrl.addQueryParameter("starting_after", request.getStartingAfter().get().toString());
      }
      if (request.getEndingBefore().isPresent()) {
        httpUrl.addQueryParameter("ending_before", request.getEndingBefore().get().toString());
      }
      if (request.getLimit().isPresent()) {
        httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl.build())
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json");
      Request okhttpRequest = _requestBuilder.build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2EventsEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V2EventsEnvelope apiV2GetEvents(EventsApiV2GetEventsRequest request) {
      return apiV2GetEvents(request,null);
    }

    public V2EventTypesEnvelope apiV2GetEventTypes(RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/events_types")
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
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2EventTypesEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V2EventTypesEnvelope apiV2GetEventTypes() {
      return apiV2GetEventTypes(null);
    }
  }
