package com.wortise.ads;

import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import com.wortise.ads.network.models.CellNetworkType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\t\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\n\"\u0017\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\n\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n\"\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u0017"}, d2 = {"Landroid/telephony/CellSignalStrength;", "", "name", "", "a", "(Landroid/telephony/CellSignalStrength;Ljava/lang/String;)Ljava/lang/Integer;", "b", "Lcom/wortise/ads/network/models/CellNetworkType;", "networkType", "(Landroid/telephony/CellSignalStrength;Lcom/wortise/ads/network/models/CellNetworkType;)Ljava/lang/Integer;", "(Landroid/telephony/CellSignalStrength;)Ljava/lang/Integer;", "ber", "cqi", "c", "evdoSnr", "d", "rsrp", "e", "rsrq", "f", "rssnr", "g", "timingAdvance", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: CellSignalStrength.kt */
public final class i1 {
    public static final Integer a(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return a(cellSignalStrength, "mBitErrorRate");
    }

    public static final Integer b(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getCqi");
    }

    public static final Integer c(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getEvdoSnr");
    }

    public static final Integer d(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getRsrp");
    }

    public static final Integer e(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getRsrq");
    }

    public static final Integer f(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getRssnr");
    }

    public static final Integer g(CellSignalStrength cellSignalStrength) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        return b(cellSignalStrength, "getTimingAdvance");
    }

    private static final Integer a(CellSignalStrength cellSignalStrength, String str) {
        try {
            Field declaredField = cellSignalStrength.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return Integer.valueOf(declaredField.getInt(cellSignalStrength));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final Integer b(CellSignalStrength cellSignalStrength, String str) {
        try {
            Method method = cellSignalStrength.getClass().getMethod(str, new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(cellSignalStrength, new Object[0]);
            if (invoke instanceof Integer) {
                return (Integer) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Integer a(CellSignalStrength cellSignalStrength, CellNetworkType cellNetworkType) {
        Intrinsics.checkNotNullParameter(cellSignalStrength, "<this>");
        Intrinsics.checkNotNullParameter(cellNetworkType, "networkType");
        if (!(cellSignalStrength instanceof CellSignalStrengthCdma)) {
            return null;
        }
        if (StringsKt.startsWith$default(cellNetworkType.name(), "CDMA", false, 2, (Object) null)) {
            return Integer.valueOf(((CellSignalStrengthCdma) cellSignalStrength).getCdmaEcio());
        }
        if (StringsKt.startsWith$default(cellNetworkType.name(), "EVDO", false, 2, (Object) null)) {
            return Integer.valueOf(((CellSignalStrengthCdma) cellSignalStrength).getEvdoEcio());
        }
        return null;
    }
}
