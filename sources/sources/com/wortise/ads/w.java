package com.wortise.ads;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\nJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/w;", "", "Lcom/wortise/ads/p1;", "request", "Lcom/wortise/ads/w5;", "Lcom/wortise/ads/l1;", "a", "(Lcom/wortise/ads/p1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/l0;", "", "(Lcom/wortise/ads/l0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/j;", "Lcom/wortise/ads/AdResult;", "(Lcom/wortise/ads/j;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ApiService.kt */
public interface w {
    @POST("sdk/request/ad")
    Object a(@Body j jVar, Continuation<? super w5<AdResult>> continuation);

    @POST("sdk/activity")
    Object a(@Body l0 l0Var, Continuation<? super w5<Unit>> continuation);

    @POST("sdk/config")
    Object a(@Body p1 p1Var, Continuation<? super w5<l1>> continuation);
}
