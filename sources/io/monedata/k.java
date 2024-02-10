package io.monedata;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/monedata/k;", "", "Lio/monedata/f0;", "request", "Lio/monedata/o1;", "Lio/monedata/s;", "c", "(Lio/monedata/f0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/monedata/o0;", "", "a", "(Lio/monedata/o0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public interface k {
    @POST("record/ping")
    Object a(@Body f0 f0Var, Continuation<? super o1<Boolean>> continuation);

    @POST("record/error")
    Object a(@Body o0 o0Var, Continuation<? super o1<Boolean>> continuation);

    @POST("record/foreground")
    Object b(@Body f0 f0Var, Continuation<? super o1<Boolean>> continuation);

    @POST("config")
    Object c(@Body f0 f0Var, Continuation<? super o1<s>> continuation);
}
