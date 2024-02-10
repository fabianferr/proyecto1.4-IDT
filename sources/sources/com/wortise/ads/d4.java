package com.wortise.ads;

import com.wortise.ads.battery.BatteryHealth;
import com.wortise.ads.battery.BatteryPlugged;
import com.wortise.ads.battery.BatteryStatus;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/wortise/ads/d4;", "", "", "a", "()Ljava/lang/Integer;", "capacity", "Lcom/wortise/ads/battery/BatteryHealth;", "b", "()Lcom/wortise/ads/battery/BatteryHealth;", "health", "d", "level", "Lcom/wortise/ads/battery/BatteryPlugged;", "c", "()Lcom/wortise/ads/battery/BatteryPlugged;", "plugged", "Lcom/wortise/ads/battery/BatteryStatus;", "e", "()Lcom/wortise/ads/battery/BatteryStatus;", "status", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: IBattery.kt */
public interface d4 {
    Integer a();

    BatteryHealth b();

    BatteryPlugged c();

    Integer d();

    BatteryStatus e();
}
