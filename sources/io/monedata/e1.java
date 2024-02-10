package io.monedata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.monedata.net.NetworkType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8WX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lio/monedata/e1;", "Lio/monedata/y0;", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "c", "()Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/NetworkInfo;", "network$delegate", "d", "()Landroid/net/NetworkInfo;", "network", "", "a", "()Ljava/lang/Boolean;", "isVpn", "Lio/monedata/net/NetworkType;", "b", "()Lio/monedata/net/NetworkType;", "type", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class e1 implements y0 {
    private final Lazy a;
    private final Lazy b = LazyKt.lazy(new b(this));

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/ConnectivityManager;", "a", "()Landroid/net/ConnectivityManager;"}, k = 3, mv = {1, 7, 1})
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

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/NetworkInfo;", "a", "()Landroid/net/NetworkInfo;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<NetworkInfo> {
        final /* synthetic */ e1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e1 e1Var) {
            super(0);
            this.a = e1Var;
        }

        /* renamed from: a */
        public final NetworkInfo invoke() {
            Object obj;
            e1 e1Var = this.a;
            NetworkInfo networkInfo = null;
            try {
                Result.Companion companion = Result.Companion;
                ConnectivityManager a2 = e1Var.c();
                obj = Result.m2344constructorimpl(a2 != null ? a2.getActiveNetworkInfo() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m2350isFailureimpl(obj)) {
                networkInfo = obj;
            }
            return networkInfo;
        }
    }

    public e1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt.lazy(new a(context));
    }

    /* access modifiers changed from: private */
    public final ConnectivityManager c() {
        return (ConnectivityManager) this.a.getValue();
    }

    private final NetworkInfo d() {
        return (NetworkInfo) this.b.getValue();
    }

    public Boolean a() {
        NetworkInfo d = d();
        if (d == null) {
            return null;
        }
        return Boolean.valueOf(d.getType() == 17);
    }

    public NetworkType b() {
        NetworkInfo d = d();
        Integer valueOf = d != null ? Integer.valueOf(d.getType()) : null;
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
