package com.wortise.ads.battery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/battery/BatteryStatus;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "CHARGING", "DISCHARGING", "FULL", "NOT_CHARGING", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryStatus.kt */
public enum BatteryStatus {
    CHARGING(2),
    DISCHARGING(3),
    FULL(5),
    NOT_CHARGING(4);
    
    public static final a Companion = null;
    private final int value;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/battery/BatteryStatus$a;", "", "", "value", "Lcom/wortise/ads/battery/BatteryStatus;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BatteryStatus.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BatteryStatus a(int i) {
            for (BatteryStatus batteryStatus : BatteryStatus.values()) {
                if (batteryStatus.getValue() == i) {
                    return batteryStatus;
                }
            }
            return null;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private BatteryStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
