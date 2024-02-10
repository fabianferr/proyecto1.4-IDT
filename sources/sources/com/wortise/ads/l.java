package com.wortise.ads;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/wortise/ads/l;", "", "", "maxTime", "Ljava/util/concurrent/TimeUnit;", "unit", "", "a", "", "toString", "", "hashCode", "other", "equals", "adUnitId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/wortise/ads/AdResult;", "adResult", "Lcom/wortise/ads/AdResult;", "()Lcom/wortise/ads/AdResult;", "Ljava/util/Date;", "date", "Ljava/util/Date;", "d", "()Ljava/util/Date;", "c", "()J", "age", "<init>", "(Ljava/lang/String;Lcom/wortise/ads/AdResult;Ljava/util/Date;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdResultCache.kt */
public final class l {
    private final String a;
    private final AdResult b;
    private final Date c;

    public l(String str, AdResult adResult, Date date) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(adResult, "adResult");
        Intrinsics.checkNotNullParameter(date, "date");
        this.a = str;
        this.b = adResult;
        this.c = date;
    }

    public final AdResult a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return new Date().getTime() - this.c.getTime();
    }

    public final Date d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) lVar.a) && Intrinsics.areEqual((Object) this.b, (Object) lVar.b) && Intrinsics.areEqual((Object) this.c, (Object) lVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AdResultCache(adUnitId=" + this.a + ", adResult=" + this.b + ", date=" + this.c + ')';
    }

    public final boolean a(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return c() >= timeUnit.toMillis(j);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(String str, AdResult adResult, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, adResult, (i & 4) != 0 ? new Date() : date);
    }
}
