package io.monedata;

import io.monedata.consent.models.ConsentSettings;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0001\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/monedata/b0;", "", "", "assetKey", "locale", "Lio/monedata/o1;", "Lio/monedata/consent/models/ConsentSettings;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/monedata/z;", "request", "(Lio/monedata/z;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public interface b0 {
    @POST("consent/update")
    Object a(@Body z zVar, Continuation<? super o1<Object>> continuation);

    @GET("consent/settings")
    Object a(@Query("asset") String str, @Query("locale") String str2, Continuation<? super o1<ConsentSettings>> continuation);
}
