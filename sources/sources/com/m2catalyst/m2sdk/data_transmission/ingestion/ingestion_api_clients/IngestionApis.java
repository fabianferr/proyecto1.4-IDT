package com.m2catalyst.m2sdk.data_transmission.ingestion.ingestion_api_clients;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/m2catalyst/m2sdk/data_transmission/ingestion/ingestion_api_clients/IngestionApis;", "", "submitErrorReport", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiResponseMessage;", "data", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitLocationLogs", "submitNetworkLogs", "syncDevice", "verifyApiKey", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IngestionApis.kt */
public interface IngestionApis {
    @POST("process_error_reports")
    @Headers({"Content-Type: application/x-protobuf", "charset: utf-8", "Accept: application/json", "Accept-Version: v10"})
    Object submitErrorReport(@Body RequestBody requestBody, Continuation<? super ApiResponseMessage> continuation);

    @POST("process_location_logs")
    @Headers({"Content-Type: application/x-protobuf", "charset: utf-8", "Accept: application/json", "Accept-Version: v10"})
    Object submitLocationLogs(@Body RequestBody requestBody, Continuation<? super ApiResponseMessage> continuation);

    @POST("process_network_logs")
    @Headers({"Content-Type: application/x-protobuf", "charset: utf-8", "Accept: application/json", "Accept-Version: v10"})
    Object submitNetworkLogs(@Body RequestBody requestBody, Continuation<? super ApiResponseMessage> continuation);

    @POST("sync_device")
    @Headers({"Content-Type: application/x-protobuf", "charset: utf-8", "Accept: application/json", "Accept-Version: v10"})
    Object syncDevice(@Body RequestBody requestBody, Continuation<? super ApiResponseMessage> continuation);

    @POST("verify_api_key")
    @Headers({"Content-Type: application/x-protobuf", "charset: utf-8", "Accept: application/json", "Accept-Version: v10"})
    Object verifyApiKey(@Body RequestBody requestBody, Continuation<? super ApiResponseMessage> continuation);
}
