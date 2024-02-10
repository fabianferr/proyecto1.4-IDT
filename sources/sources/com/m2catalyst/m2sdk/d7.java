package com.m2catalyst.m2sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: WifiCollectionOrchestrator.kt */
public final class d7 implements KoinComponent {
    public final c7 a;
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
    public final Lazy c = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    public boolean d;

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<Context> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Context, java.lang.Object] */
        public final Context invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<WifiSDKReceiver> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver, java.lang.Object] */
        public final WifiSDKReceiver invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(WifiSDKReceiver.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(WifiSDKReceiver.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public d7(c7 c7Var) {
        Intrinsics.checkNotNullParameter(c7Var, "wifiCollectionManager");
        this.a = c7Var;
    }

    public final void a() {
        this.a.a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction(WifiSDKReceiver.WIFI_CONNECTIVITY_ENTRY_CREATION);
        if (Build.VERSION.SDK_INT >= 33) {
            ((Context) this.b.getValue()).getApplicationContext().registerReceiver((WifiSDKReceiver) this.c.getValue(), intentFilter, 2);
        } else {
            ((Context) this.b.getValue()).getApplicationContext().registerReceiver((WifiSDKReceiver) this.c.getValue(), intentFilter);
        }
        this.d = true;
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
