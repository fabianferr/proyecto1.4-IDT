package com.wortise.ads;

import com.wortise.ads.consent.models.ConsentData;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0014\u0010\f\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0018\u0010\u000e\u001a\u00020\u0002*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/consent/models/ConsentData;", "other", "", "b", "current", "c", "remote", "d", "", "a", "Ljava/util/Date;", "()Ljava/util/Date;", "MAX_DATE", "(Lcom/wortise/ads/consent/models/ConsentData;)Z", "isValid", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ConsentData.kt */
public final class r1 {
    private static final Date a() {
        return g2.a(new Date(), 24, TimeUnit.HOURS);
    }

    public static final boolean b(ConsentData consentData, ConsentData consentData2) {
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        if (consentData2 != null && consentData.getGranted() == consentData2.getGranted() && Intrinsics.areEqual((Object) consentData.getIabString(), (Object) consentData2.getIabString()) && consentData.getSource() == consentData2.getSource()) {
            return true;
        }
        return false;
    }

    public static final boolean c(ConsentData consentData, ConsentData consentData2) {
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        if (!a(consentData) || Intrinsics.areEqual((Object) consentData2, (Object) consentData)) {
            return false;
        }
        if (consentData2 == null || a(consentData2, consentData) <= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015 A[Catch:{ all -> 0x0025 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016 A[Catch:{ all -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean d(com.wortise.ads.consent.models.ConsentData r3, com.wortise.ads.consent.models.ConsentData r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x000a
            goto L_0x0012
        L_0x000a:
            boolean r2 = a(r4)     // Catch:{ all -> 0x0025 }
            if (r2 != r0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            int r2 = a(r4, r3)     // Catch:{ all -> 0x0025 }
            if (r2 > 0) goto L_0x0023
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ all -> 0x0025 }
            if (r3 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            return r0
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.r1.d(com.wortise.ads.consent.models.ConsentData, com.wortise.ads.consent.models.ConsentData):boolean");
    }

    public static final boolean a(ConsentData consentData) {
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        Date date = consentData.getDate();
        return date != null && a().after(date);
    }

    public static final int a(ConsentData consentData, ConsentData consentData2) {
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        Intrinsics.checkNotNullParameter(consentData2, "other");
        Date date = consentData.getDate();
        if (date == null) {
            return Integer.MIN_VALUE;
        }
        Date date2 = consentData2.getDate();
        if (date2 == null) {
            return Integer.MAX_VALUE;
        }
        return date.compareTo(date2);
    }
}
