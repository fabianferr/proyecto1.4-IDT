package com.wortise.ads;

import com.wortise.iabtcf.decoder.DecoderOption;
import com.wortise.iabtcf.decoder.TCString;
import com.wortise.iabtcf.decoder.TCStringFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/l6;", "", "Lcom/wortise/ads/k6;", "feature", "", "a", "", "Lcom/wortise/ads/j6;", "purposes", "([Lcom/wortise/ads/j6;)Z", "Lcom/wortise/iabtcf/decoder/TCString;", "kotlin.jvm.PlatformType", "tcString$delegate", "Lkotlin/Lazy;", "c", "()Lcom/wortise/iabtcf/decoder/TCString;", "tcString", "", "iabString", "Ljava/lang/String;", "()Ljava/lang/String;", "Ljava/util/Date;", "b", "()Ljava/util/Date;", "lastUpdated", "<init>", "(Ljava/lang/String;)V", "Lcom/wortise/ads/consent/models/ConsentData;", "consent", "(Lcom/wortise/ads/consent/models/ConsentData;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: TcfString.kt */
public final class l6 {
    private final String a;
    private final Lazy b;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Lcom/wortise/iabtcf/decoder/TCString;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TcfString.kt */
    static final class a extends Lambda implements Function0<TCString> {
        final /* synthetic */ l6 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l6 l6Var) {
            super(0);
            this.a = l6Var;
        }

        /* renamed from: a */
        public final TCString invoke() {
            return TCStringFactory.decode(this.a.a(), new DecoderOption[0]);
        }
    }

    public l6(String str) {
        Intrinsics.checkNotNullParameter(str, "iabString");
        this.a = str;
        this.b = LazyKt.lazy(new a(this));
    }

    private final TCString c() {
        return (TCString) this.b.getValue();
    }

    public final String a() {
        return this.a;
    }

    public final Date b() {
        Date lastUpdated = c().getLastUpdated();
        Intrinsics.checkNotNullExpressionValue(lastUpdated, "tcString.lastUpdated");
        return lastUpdated;
    }

    public final boolean a(k6 k6Var) {
        Intrinsics.checkNotNullParameter(k6Var, "feature");
        return c().getSpecialFeatureOptIns().contains(k6Var.b());
    }

    public final boolean a(j6... j6VarArr) {
        Intrinsics.checkNotNullParameter(j6VarArr, "purposes");
        ArrayList arrayList = new ArrayList(j6VarArr.length);
        for (j6 b2 : j6VarArr) {
            arrayList.add(Integer.valueOf(b2.b()));
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        return c().getPurposesConsent().containsAll(Arrays.copyOf(intArray, intArray.length));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l6(com.wortise.ads.consent.models.ConsentData r2) {
        /*
            r1 = this;
            java.lang.String r0 = "consent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = r2.getIabString()
            if (r2 == 0) goto L_0x000f
            r1.<init>((java.lang.String) r2)
            return
        L_0x000f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.l6.<init>(com.wortise.ads.consent.models.ConsentData):void");
    }
}
