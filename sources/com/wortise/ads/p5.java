package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/p5;", "", "", "interval", "J", "a", "()J", "", "tag$delegate", "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "tag", "<init>", "(J)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PeriodicJobInfo.kt */
public class p5 {
    @SerializedName("interval")
    private final long a;
    private final transient Lazy b = LazyKt.lazy(new a(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: PeriodicJobInfo.kt */
    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ p5 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p5 p5Var) {
            super(0);
            this.a = p5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return q4.a(q4.a, this.a, (Type) null, 2, (Object) null);
        }
    }

    public p5(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return (String) this.b.getValue();
    }
}
