package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.battery.BatteryHealth;
import com.wortise.ads.battery.BatteryPlugged;
import com.wortise.ads.battery.BatteryStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/wortise/ads/q0;", "", "", "toString", "", "hashCode", "other", "", "equals", "capacity", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "Lcom/wortise/ads/battery/BatteryHealth;", "health", "Lcom/wortise/ads/battery/BatteryHealth;", "b", "()Lcom/wortise/ads/battery/BatteryHealth;", "level", "c", "Lcom/wortise/ads/battery/BatteryPlugged;", "plugged", "Lcom/wortise/ads/battery/BatteryPlugged;", "d", "()Lcom/wortise/ads/battery/BatteryPlugged;", "Lcom/wortise/ads/battery/BatteryStatus;", "status", "Lcom/wortise/ads/battery/BatteryStatus;", "e", "()Lcom/wortise/ads/battery/BatteryStatus;", "<init>", "(Ljava/lang/Integer;Lcom/wortise/ads/battery/BatteryHealth;Ljava/lang/Integer;Lcom/wortise/ads/battery/BatteryPlugged;Lcom/wortise/ads/battery/BatteryStatus;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Battery.kt */
public final class q0 {
    @SerializedName("capacity")
    private final Integer a;
    @SerializedName("health")
    private final BatteryHealth b;
    @SerializedName("level")
    private final Integer c;
    @SerializedName("plugged")
    private final BatteryPlugged d;
    @SerializedName("status")
    private final BatteryStatus e;

    public q0(Integer num, BatteryHealth batteryHealth, Integer num2, BatteryPlugged batteryPlugged, BatteryStatus batteryStatus) {
        this.a = num;
        this.b = batteryHealth;
        this.c = num2;
        this.d = batteryPlugged;
        this.e = batteryStatus;
    }

    public final Integer a() {
        return this.a;
    }

    public final BatteryHealth b() {
        return this.b;
    }

    public final Integer c() {
        return this.c;
    }

    public final BatteryPlugged d() {
        return this.d;
    }

    public final BatteryStatus e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) q0Var.a) && this.b == q0Var.b && Intrinsics.areEqual((Object) this.c, (Object) q0Var.c) && this.d == q0Var.d && this.e == q0Var.e;
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        BatteryHealth batteryHealth = this.b;
        int hashCode2 = (hashCode + (batteryHealth == null ? 0 : batteryHealth.hashCode())) * 31;
        Integer num2 = this.c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        BatteryPlugged batteryPlugged = this.d;
        int hashCode4 = (hashCode3 + (batteryPlugged == null ? 0 : batteryPlugged.hashCode())) * 31;
        BatteryStatus batteryStatus = this.e;
        if (batteryStatus != null) {
            i = batteryStatus.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Battery(capacity=" + this.a + ", health=" + this.b + ", level=" + this.c + ", plugged=" + this.d + ", status=" + this.e + ')';
    }
}
