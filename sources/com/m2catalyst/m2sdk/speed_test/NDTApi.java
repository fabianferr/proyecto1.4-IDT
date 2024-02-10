package com.m2catalyst.m2sdk.speed_test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/NDTApi;", "", "getNDTConfig", "Lcom/m2catalyst/m2sdk/speed_test/NDTConfig;", "latitude", "", "longitude", "mcc", "", "mnc", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNDTServers", "Lcom/m2catalyst/m2sdk/speed_test/NDTServers;", "lteCi", "cid", "lac", "systemId", "networkId", "baseStationId", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTApi.kt */
public interface NDTApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NDTApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getNDTConfig$default(NDTApi nDTApi, Double d, Double d2, Integer num, Integer num2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return nDTApi.getNDTConfig(d, d2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNDTConfig");
        }

        public static /* synthetic */ Object getNDTServers$default(NDTApi nDTApi, Double d, Double d2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Continuation continuation, int i, Object obj) {
            int i2 = i;
            if (obj == null) {
                return nDTApi.getNDTServers(d, d2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : num4, (i2 & 64) != 0 ? null : num5, (i2 & 128) != 0 ? null : num6, (i2 & 256) != 0 ? null : num7, (i2 & 512) != 0 ? null : num8, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNDTServers");
        }
    }

    @GET("config")
    Object getNDTConfig(@Query("latitude") Double d, @Query("longitude") Double d2, @Query("mcc") Integer num, @Query("mnc") Integer num2, Continuation<? super NDTConfig> continuation);

    @GET("servers")
    Object getNDTServers(@Query("latitude") Double d, @Query("longitude") Double d2, @Query("mcc") Integer num, @Query("mnc") Integer num2, @Query("lteci") Integer num3, @Query("cid") Integer num4, @Query("lac") Integer num5, @Query("systemid") Integer num6, @Query("networkid") Integer num7, @Query("basestationid") Integer num8, Continuation<? super NDTServers> continuation);
}
