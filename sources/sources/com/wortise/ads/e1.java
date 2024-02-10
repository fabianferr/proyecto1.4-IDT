package com.wortise.ads;

import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/wortise/ads/e1;", "", "", "a", "()Ljava/lang/Long;", "cid", "identity", "<init>", "(Ljava/lang/Object;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellIdentityCompat.kt */
public final class e1 {
    private final Object a;

    public e1(Object obj) {
        Intrinsics.checkNotNullParameter(obj, HTTP.IDENTITY_CODING);
        this.a = obj;
    }

    public final Long a() {
        Object obj = this.a;
        if (obj instanceof CellIdentityCdma) {
            return Long.valueOf((long) ((CellIdentityCdma) obj).getBasestationId());
        }
        if (obj instanceof CellIdentityGsm) {
            return Long.valueOf((long) ((CellIdentityGsm) obj).getCid());
        }
        if (obj instanceof CellIdentityLte) {
            return Long.valueOf((long) ((CellIdentityLte) obj).getCi());
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && (obj instanceof CellIdentityNr)) {
            return Long.valueOf(((CellIdentityNr) obj).getNci());
        }
        if (i >= 28 && (obj instanceof CellIdentityTdscdma)) {
            return Long.valueOf((long) ((CellIdentityTdscdma) obj).getCid());
        }
        if (obj instanceof CellIdentityWcdma) {
            return Long.valueOf((long) ((CellIdentityWcdma) obj).getCid());
        }
        return null;
    }
}
