package com.wortise.ads.cellular;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/cellular/CellConnection;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NONE", "PRIMARY", "SECONDARY", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellConnection.kt */
public enum CellConnection {
    NONE(0),
    PRIMARY(1),
    SECONDARY(2);
    
    public static final a Companion = null;
    private final int value;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/cellular/CellConnection$a;", "", "", "value", "Lcom/wortise/ads/cellular/CellConnection;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: CellConnection.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CellConnection a(int i) {
            for (CellConnection cellConnection : CellConnection.values()) {
                if (cellConnection.getValue() == i) {
                    return cellConnection;
                }
            }
            return null;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private CellConnection(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
