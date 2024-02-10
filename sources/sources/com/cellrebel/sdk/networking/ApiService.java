package com.cellrebel.sdk.networking;

import com.cellrebel.sdk.networking.beans.request.AuthRequestModel;
import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import com.cellrebel.sdk.networking.beans.request.ConnectionMetric;
import com.cellrebel.sdk.networking.beans.request.CoverageMetric;
import com.cellrebel.sdk.networking.beans.request.DataUsageMetric;
import com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric;
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;
import com.cellrebel.sdk.networking.beans.request.GameMetric;
import com.cellrebel.sdk.networking.beans.request.PageLoadMetric;
import com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric;
import com.cellrebel.sdk.networking.beans.request.TraceRouteMetric;
import com.cellrebel.sdk.networking.beans.request.TrafficProfileMetric;
import com.cellrebel.sdk.networking.beans.request.VideoMetric;
import com.cellrebel.sdk.networking.beans.request.VoiceCallMetric;
import com.cellrebel.sdk.networking.beans.request.WifiInfoMetric;
import com.cellrebel.sdk.networking.beans.response.Game;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.tti.models.ServerConfig;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    @POST("{fullUrl}token")
    Call<ResponseBody> a(@Body AuthRequestModel authRequestModel, @Path(encoded = true, value = "fullUrl") String str);

    @GET
    @Headers({"Cache-Control: no-cache"})
    Call<ResponseBody> a(@Url String str);

    @GET("{fullUrl}mobile/getServerList")
    Call<ServerConfig> a(@Path(encoded = true, value = "fullUrl") String str, @Query("appName") String str2, @Query("appVersion") String str3, @Query("deviceModel") String str4, @Query("deviceId") String str5);

    @Multipart
    @POST
    @Headers({"CustomTimeout:0"})
    Call<ResponseBody> a(@Url String str, @Part MultipartBody.Part part);

    @POST("{fullUrl}mobile/page_load_metric")
    Call<Void> a(@Body List<PageLoadMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}token")
    Call<ResponseBody> b(@Body AuthRequestModel authRequestModel, @Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}mobile/clearUserData")
    Call<Void> b(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/device_info_metrics")
    Call<Void> b(@Body List<DeviceInfoMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}mobile/games")
    Call<List<Game>> c(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/traffic_profile_metric")
    Call<Void> c(@Body List<TrafficProfileMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @GET("{fullUrl}mobile/getMobileClientSettings")
    Call<Settings> d(@Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/video_metric")
    Call<Void> d(@Body List<VideoMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/game_metrics")
    Call<Void> e(@Body List<GameMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/time_to_interaction_metric")
    Call<Void> f(@Body List<TimeToInteractionMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/voice_call_metrics")
    Call<Void> g(@Body List<VoiceCallMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/traceroute_metrics")
    Call<Void> h(@Body List<TraceRouteMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/cell_info_metric")
    Call<Void> i(@Body List<CellInfoMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/data_usage_metric")
    Call<Void> j(@Body List<DataUsageMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/connection_metric")
    Call<Void> k(@Body List<ConnectionMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/wifi_info_metric")
    Call<Void> l(@Body List<WifiInfoMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @PUT("{fullUrl}mobile/coverage_metric")
    Call<Void> m(@Body List<CoverageMetric> list, @Path(encoded = true, value = "fullUrl") String str);

    @POST("{fullUrl}mobile/file_transfer_metric")
    Call<Void> n(@Body List<FileTransferMetric> list, @Path(encoded = true, value = "fullUrl") String str);
}
