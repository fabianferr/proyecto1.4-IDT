package io.monedata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import io.monedata.net.NetworkType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lio/monedata/f1;", "Lio/monedata/y0;", "", "transport", "", "a", "Landroid/net/NetworkCapabilities;", "capabilities$delegate", "Lkotlin/Lazy;", "c", "()Landroid/net/NetworkCapabilities;", "capabilities", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "d", "()Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/Network;", "network$delegate", "e", "()Landroid/net/Network;", "network", "()Ljava/lang/Boolean;", "isVpn", "Lio/monedata/net/NetworkType;", "b", "()Lio/monedata/net/NetworkType;", "type", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class f1 implements y0 {
    private final Lazy a = LazyKt.lazy(new a(this));
    private final Lazy b;
    private final Lazy c;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/NetworkCapabilities;", "a", "()Landroid/net/NetworkCapabilities;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<NetworkCapabilities> {
        final /* synthetic */ f1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f1 f1Var) {
            super(0);
            this.a = f1Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
            r0 = io.monedata.f1.a(r0);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.net.NetworkCapabilities invoke() {
            /*
                r3 = this;
                io.monedata.f1 r0 = r3.a
                r1 = 0
                kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x001c }
                android.net.Network r2 = r0.e()     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0016
                android.net.ConnectivityManager r0 = r0.d()     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x0016
                android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r2)     // Catch:{ all -> 0x001c }
                goto L_0x0017
            L_0x0016:
                r0 = r1
            L_0x0017:
                java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x001c }
                goto L_0x0027
            L_0x001c:
                r0 = move-exception
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
            L_0x0027:
                boolean r2 = kotlin.Result.m2350isFailureimpl(r0)
                if (r2 == 0) goto L_0x002e
                goto L_0x002f
            L_0x002e:
                r1 = r0
            L_0x002f:
                android.net.NetworkCapabilities r1 = (android.net.NetworkCapabilities) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.f1.a.invoke():android.net.NetworkCapabilities");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/ConnectivityManager;", "a", "()Landroid/net/ConnectivityManager;"}, k = 3, mv = {1, 7, 1})
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

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/Network;", "a", "()Landroid/net/Network;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<Network> {
        final /* synthetic */ f1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f1 f1Var) {
            super(0);
            this.a = f1Var;
        }

        /* renamed from: a */
        public final Network invoke() {
            Object obj;
            f1 f1Var = this.a;
            Network network = null;
            try {
                Result.Companion companion = Result.Companion;
                ConnectivityManager a2 = f1Var.d();
                obj = Result.m2344constructorimpl(a2 != null ? a2.getActiveNetwork() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m2350isFailureimpl(obj)) {
                network = obj;
            }
            return network;
        }
    }

    public f1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt.lazy(new b(context));
        this.c = LazyKt.lazy(new c(this));
    }

    private final boolean a(int i) {
        NetworkCapabilities c2 = c();
        return c2 != null && c2.hasTransport(i);
    }

    private final NetworkCapabilities c() {
        return (NetworkCapabilities) this.a.getValue();
    }

    /* access modifiers changed from: private */
    public final ConnectivityManager d() {
        return (ConnectivityManager) this.b.getValue();
    }

    /* access modifiers changed from: private */
    public final Network e() {
        return (Network) this.c.getValue();
    }

    public Boolean a() {
        NetworkCapabilities c2 = c();
        if (c2 != null) {
            return Boolean.valueOf(c2.hasTransport(4));
        }
        return null;
    }

    public NetworkType b() {
        if (a(2)) {
            return NetworkType.BLUETOOTH;
        }
        if (a(0)) {
            return NetworkType.CELLULAR;
        }
        if (a(3)) {
            return NetworkType.ETHERNET;
        }
        if (a(1) || a(5)) {
            return NetworkType.WIFI;
        }
        return null;
    }
}
