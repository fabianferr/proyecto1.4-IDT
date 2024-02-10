package com.wortise.ads.battery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/battery/BatteryHealth;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "COLD", "DEAD", "GOOD", "OVERHEAT", "OVER_VOLTAGE", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryHealth.kt */
public enum BatteryHealth {
    COLD(7),
    DEAD(4),
    GOOD(2),
    OVERHEAT(3),
    OVER_VOLTAGE(5);
    
    public static final a Companion = null;
    private final int value;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/battery/BatteryHealth$a;", "", "", "value", "Lcom/wortise/ads/battery/BatteryHealth;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BatteryHealth.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BatteryHealth a(int i) {
            for (BatteryHealth batteryHealth : BatteryHealth.values()) {
                if (batteryHealth.getValue() == i) {
                    return batteryHealth;
                }
            }
            return null;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private BatteryHealth(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
