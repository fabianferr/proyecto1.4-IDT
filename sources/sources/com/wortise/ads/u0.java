package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.battery.BatteryHealth;
import com.wortise.ads.battery.BatteryPlugged;
import com.wortise.ads.battery.BatteryStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/wortise/ads/u0;", "Lcom/wortise/ads/d4;", "Lkotlin/sequences/Sequence;", "f", "()Lkotlin/sequences/Sequence;", "sequence", "", "a", "()Ljava/lang/Integer;", "capacity", "Lcom/wortise/ads/battery/BatteryHealth;", "b", "()Lcom/wortise/ads/battery/BatteryHealth;", "health", "d", "level", "Lcom/wortise/ads/battery/BatteryPlugged;", "c", "()Lcom/wortise/ads/battery/BatteryPlugged;", "plugged", "Lcom/wortise/ads/battery/BatteryStatus;", "e", "()Lcom/wortise/ads/battery/BatteryStatus;", "status", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryInfo.kt */
public final class u0 implements d4 {
    private final List<s0> a;

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class a extends Lambda implements Function1<d4, Integer> {
        public a() {
            super(1);
        }

        public final Integer invoke(d4 d4Var) {
            try {
                return d4Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class b extends Lambda implements Function1<d4, BatteryHealth> {
        public b() {
            super(1);
        }

        public final BatteryHealth invoke(d4 d4Var) {
            try {
                return d4Var.b();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class c extends Lambda implements Function1<d4, Integer> {
        public c() {
            super(1);
        }

        public final Integer invoke(d4 d4Var) {
            try {
                return d4Var.d();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class d extends Lambda implements Function1<d4, BatteryPlugged> {
        public d() {
            super(1);
        }

        public final BatteryPlugged invoke(d4 d4Var) {
            try {
                return d4Var.c();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class e extends Lambda implements Function1<d4, BatteryStatus> {
        public e() {
            super(1);
        }

        public final BatteryStatus invoke(d4 d4Var) {
            try {
                return d4Var.e();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public u0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = CollectionsKt.listOf(new t0(context), new s0(context));
    }

    private final Sequence<d4> f() {
        return CollectionsKt.asSequence(this.a);
    }

    public Integer a() {
        return (Integer) SequencesKt.firstOrNull(SequencesKt.mapNotNull(f(), new a()));
    }

    public BatteryHealth b() {
        return (BatteryHealth) SequencesKt.firstOrNull(SequencesKt.mapNotNull(f(), new b()));
    }

    public BatteryPlugged c() {
        return (BatteryPlugged) SequencesKt.firstOrNull(SequencesKt.mapNotNull(f(), new d()));
    }

    public Integer d() {
        return (Integer) SequencesKt.firstOrNull(SequencesKt.mapNotNull(f(), new c()));
    }

    public BatteryStatus e() {
        return (BatteryStatus) SequencesKt.firstOrNull(SequencesKt.mapNotNull(f(), new e()));
    }
}
