package com.wortise.ads.network.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001a\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/wortise/ads/network/models/CellNetworkType;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ONExRTT", "CDMA", "EDGE", "EHRPD", "EVDO_0", "EVDO_A", "EVDO_B", "GPRS", "HSDPA", "HSPA", "HSPAP", "HSUPA", "IDEN", "LTE", "NR", "TD_SCDMA", "UMTS", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellNetworkType.kt */
public enum CellNetworkType {
    ONExRTT(7),
    CDMA(4),
    EDGE(2),
    EHRPD(14),
    EVDO_0(5),
    EVDO_A(6),
    EVDO_B(12),
    GPRS(1),
    HSDPA(8),
    HSPA(10),
    HSPAP(15),
    HSUPA(9),
    IDEN(11),
    LTE(13),
    NR(20),
    TD_SCDMA(17),
    UMTS(3);
    
    public static final a Companion = null;
    private final int value;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/network/models/CellNetworkType$a;", "", "", "type", "Lcom/wortise/ads/network/models/CellNetworkType;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: CellNetworkType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CellNetworkType a(int i) {
            for (CellNetworkType cellNetworkType : CellNetworkType.values()) {
                if (cellNetworkType.getValue() == i) {
                    return cellNetworkType;
                }
            }
            return null;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private CellNetworkType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
