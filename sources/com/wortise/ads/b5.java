package com.wortise.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.wortise.ads.network.models.NetworkType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r8WX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/b5;", "Lcom/wortise/ads/g4;", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "d", "()Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/NetworkInfo;", "network$delegate", "e", "()Landroid/net/NetworkInfo;", "network", "", "b", "()Ljava/lang/Boolean;", "isConnected", "c", "isVpn", "Lcom/wortise/ads/network/models/NetworkType;", "a", "()Lcom/wortise/ads/network/models/NetworkType;", "type", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NetworkImpl.kt */
public final class b5 implements g4 {
    private final Lazy a;
    private final Lazy b = LazyKt.lazy(new b(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/net/ConnectivityManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: NetworkImpl.kt */
    static final class a extends Lambda implements Function0<ConnectivityManager> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/net/NetworkInfo;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: NetworkImpl.kt */
    static final class b extends Lambda implements Function0<NetworkInfo> {
        final /* synthetic */ b5 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(b5 b5Var) {
            super(0);
            this.a = b5Var;
        }

        /* renamed from: a */
        public final NetworkInfo invoke() {
            try {
                ConnectivityManager a2 = this.a.d();
                if (a2 == null) {
                    return null;
                }
                return a2.getActiveNetworkInfo();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public b5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt.lazy(new a(context));
    }

    /* access modifiers changed from: private */
    public final ConnectivityManager d() {
        return (ConnectivityManager) this.a.getValue();
    }

    private final NetworkInfo e() {
        return (NetworkInfo) this.b.getValue();
    }

    public Boolean b() {
        NetworkInfo e = e();
        if (e == null) {
            return null;
        }
        return Boolean.valueOf(e.isConnected());
    }

    public Boolean c() {
        NetworkInfo e = e();
        if (e == null) {
            return null;
        }
        return Boolean.valueOf(e.getType() == 17);
    }

    public NetworkType a() {
        NetworkInfo e = e();
        Integer valueOf = e == null ? null : Integer.valueOf(e.getType());
        if (valueOf != null && valueOf.intValue() == 7) {
            return NetworkType.BLUETOOTH;
        }
        if (valueOf != null && valueOf.intValue() == 9) {
            return NetworkType.ETHERNET;
        }
        boolean z = false;
        if (((((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 4)) || (valueOf != null && valueOf.intValue() == 5)) || (valueOf != null && valueOf.intValue() == 2)) || (valueOf != null && valueOf.intValue() == 3)) {
            z = true;
        }
        if (z) {
            return NetworkType.CELLULAR;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return NetworkType.WIFI;
        }
        return null;
    }
}
