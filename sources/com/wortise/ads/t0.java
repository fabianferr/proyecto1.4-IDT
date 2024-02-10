package com.wortise.ads;

import android.content.Context;
import android.os.BatteryManager;
import com.wortise.ads.battery.BatteryStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8WX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/t0;", "Lcom/wortise/ads/s0;", "Landroid/os/BatteryManager;", "batteryManager$delegate", "Lkotlin/Lazy;", "g", "()Landroid/os/BatteryManager;", "batteryManager", "", "a", "()Ljava/lang/Integer;", "capacity", "d", "level", "Lcom/wortise/ads/battery/BatteryStatus;", "e", "()Lcom/wortise/ads/battery/BatteryStatus;", "status", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryImpl21.kt */
public final class t0 extends s0 {
    private final Lazy b;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/os/BatteryManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BatteryImpl21.kt */
    static final class a extends Lambda implements Function0<BatteryManager> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final BatteryManager invoke() {
            try {
                Object systemService = this.a.getSystemService("batterymanager");
                if (systemService instanceof BatteryManager) {
                    return (BatteryManager) systemService;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt.lazy(new a(context));
    }

    private final BatteryManager g() {
        return (BatteryManager) this.b.getValue();
    }

    public Integer a() {
        BatteryManager g = g();
        if (g == null) {
            return null;
        }
        return Integer.valueOf(g.getIntProperty(1));
    }

    public Integer d() {
        BatteryManager g = g();
        if (g == null) {
            return null;
        }
        return Integer.valueOf(g.getIntProperty(4));
    }

    public BatteryStatus e() {
        BatteryManager g = g();
        if (g == null) {
            return null;
        }
        return BatteryStatus.Companion.a(g.getIntProperty(6));
    }
}
