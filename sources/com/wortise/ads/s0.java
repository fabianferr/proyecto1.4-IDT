package com.wortise.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.wortise.ads.battery.BatteryHealth;
import com.wortise.ads.battery.BatteryPlugged;
import com.wortise.ads.battery.BatteryStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/s0;", "Lcom/wortise/ads/d4;", "Landroid/content/Intent;", "intent$delegate", "Lkotlin/Lazy;", "f", "()Landroid/content/Intent;", "intent", "", "a", "()Ljava/lang/Integer;", "capacity", "Lcom/wortise/ads/battery/BatteryHealth;", "b", "()Lcom/wortise/ads/battery/BatteryHealth;", "health", "d", "level", "Lcom/wortise/ads/battery/BatteryPlugged;", "c", "()Lcom/wortise/ads/battery/BatteryPlugged;", "plugged", "Lcom/wortise/ads/battery/BatteryStatus;", "e", "()Lcom/wortise/ads/battery/BatteryStatus;", "status", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryImpl.kt */
public class s0 implements d4 {
    private final Lazy a;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/content/Intent;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BatteryImpl.kt */
    static final class a extends Lambda implements Function0<Intent> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final Intent invoke() {
            return this.a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public s0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt.lazy(new a(context));
    }

    private final Intent f() {
        return (Intent) this.a.getValue();
    }

    public Integer a() {
        return null;
    }

    public BatteryHealth b() {
        Intent f = f();
        if (f == null) {
            return null;
        }
        return BatteryHealth.Companion.a(f.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, -1));
    }

    public BatteryPlugged c() {
        Intent f = f();
        if (f == null) {
            return null;
        }
        return BatteryPlugged.Companion.a(f.getIntExtra("plugged", -1));
    }

    public Integer d() {
        try {
            Intent f = f();
            if (f != null) {
                Intrinsics.checkNotNullExpressionValue(f, "requireNotNull(intent)");
                int intExtra = f.getIntExtra("level", -1);
                int intExtra2 = f.getIntExtra("scale", -1);
                if (intExtra >= 0 && intExtra2 > 0) {
                    double d = (double) (intExtra * 100);
                    double d2 = (double) intExtra2;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    return Integer.valueOf((int) (d / d2));
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public BatteryStatus e() {
        Intent f = f();
        if (f == null) {
            return null;
        }
        return BatteryStatus.Companion.a(f.getIntExtra("status", -1));
    }
}
