package com.wortise.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.wortise.ads.network.models.NetworkType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/wortise/ads/c5;", "Lcom/wortise/ads/g4;", "Landroid/net/NetworkCapabilities;", "capabilities$delegate", "Lkotlin/Lazy;", "d", "()Landroid/net/NetworkCapabilities;", "capabilities", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "e", "()Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/Network;", "network$delegate", "f", "()Landroid/net/Network;", "network", "", "b", "()Ljava/lang/Boolean;", "isConnected", "c", "isVpn", "Lcom/wortise/ads/network/models/NetworkType;", "a", "()Lcom/wortise/ads/network/models/NetworkType;", "type", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NetworkImpl23.kt */
public final class c5 implements g4 {
    private final Lazy a = LazyKt.lazy(new a(this));
    private final Lazy b;
    private final Lazy c;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/net/NetworkCapabilities;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: NetworkImpl23.kt */
    static final class a extends Lambda implements Function0<NetworkCapabilities> {
        final /* synthetic */ c5 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c5 c5Var) {
            super(0);
            this.a = c5Var;
        }

        /* renamed from: a */
        public final NetworkCapabilities invoke() {
            c5 c5Var = this.a;
            try {
                Network b = c5Var.f();
                if (b == null) {
                    return null;
                }
                ConnectivityManager a2 = c5Var.e();
                if (a2 == null) {
                    return null;
                }
                return a2.getNetworkCapabilities(b);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/net/ConnectivityManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: NetworkImpl23.kt */
    static final class b extends Lambda implements Function0<ConnectivityManager> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final ConnectivityManager invoke() {
            Object systemService = this.a.getSystemService("connectivity");
            if (!(systemService instanceof ConnectivityManager)) {
                systemService = null;
            }
            return (ConnectivityManager) systemService;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/net/Network;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: NetworkImpl23.kt */
    static final class c extends Lambda implements Function0<Network> {
        final /* synthetic */ c5 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(c5 c5Var) {
            super(0);
            this.a = c5Var;
        }

        /* renamed from: a */
        public final Network invoke() {
            try {
                ConnectivityManager a2 = this.a.e();
                if (a2 == null) {
                    return null;
                }
                return a2.getActiveNetwork();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public c5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt.lazy(new b(context));
        this.c = LazyKt.lazy(new c(this));
    }

    private final NetworkCapabilities d() {
        return (NetworkCapabilities) this.a.getValue();
    }

    /* access modifiers changed from: private */
    public final ConnectivityManager e() {
        return (ConnectivityManager) this.b.getValue();
    }

    /* access modifiers changed from: private */
    public final Network f() {
        return (Network) this.c.getValue();
    }

    public Boolean c() {
        NetworkCapabilities d = d();
        if (d == null) {
            return null;
        }
        return Boolean.valueOf(d.hasTransport(4));
    }

    public NetworkType a() {
        NetworkCapabilities d = d();
        if (d == null) {
            return null;
        }
        if (d.hasTransport(2)) {
            return NetworkType.BLUETOOTH;
        }
        if (d.hasTransport(0)) {
            return NetworkType.CELLULAR;
        }
        if (d.hasTransport(3)) {
            return NetworkType.ETHERNET;
        }
        if (d.hasTransport(1) || d.hasTransport(5)) {
            return NetworkType.WIFI;
        }
        return null;
    }

    public Boolean b() {
        return Boolean.valueOf(f() != null);
    }
}
