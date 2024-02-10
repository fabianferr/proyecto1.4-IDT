package com.wortise.ads;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0001\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/wortise/ads/u1;", "", "", "assetKey", "locale", "Lcom/wortise/ads/w5;", "Lcom/wortise/ads/w1;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/x1;", "request", "Ljava/lang/Void;", "(Lcom/wortise/ads/x1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentService.kt */
public interface u1 {
    @POST("consent")
    Object a(@Body x1 x1Var, Continuation<? super w5<Void>> continuation);

    @GET("consent/settings")
    Object a(@Query("assetKey") String str, @Query("locale") String str2, Continuation<? super w5<w1>> continuation);
}
