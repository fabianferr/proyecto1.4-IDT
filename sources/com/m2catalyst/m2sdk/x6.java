package com.m2catalyst.m2sdk;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.data_transmission.TransmissionSDKReceiver;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.y2;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: TransmissionManager.kt */
public final class x6 implements KoinComponent {
    public final r2 a;
    public final x2 b;
    public final M2SDKLogger c = M2SDKLogger.Companion.getLogger("TRANSMISSION");
    public final Lazy d = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
    public final Lazy e = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    public final Lazy f = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
    public final Mutex g = MutexKt.Mutex$default(false, 1, (Object) null);
    public final Mutex h = MutexKt.Mutex$default(false, 1, (Object) null);
    public final AtomicInteger i = new AtomicInteger(0);

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<MNSIRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.MNSIRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.MNSIRepository, java.lang.Object] */
        public final MNSIRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(MNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(MNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<LocationRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.LocationRepository] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.LocationRepository] */
        public final LocationRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<x1> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.x1] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.x1] */
        public final x1 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(x1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(x1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public x6() {
        r2 a2 = r2.a.a();
        this.a = a2;
        this.b = y2.a.a(a2);
    }

    public static final x1 b(x6 x6Var) {
        return (x1) x6Var.f.getValue();
    }

    public static final LocationRepository c(x6 x6Var) {
        return (LocationRepository) x6Var.e.getValue();
    }

    public static final MNSIRepository d(x6 x6Var) {
        return (MNSIRepository) x6Var.d.getValue();
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final long a(M2Configuration m2Configuration, Context context) {
        int i2;
        Integer num;
        Integer num2;
        Integer num3 = null;
        if (m4.c(context)) {
            q2 ingestionConfig = m2Configuration.getIngestionConfig();
            if (ingestionConfig == null || (num2 = ingestionConfig.b) == null) {
                q2 q2Var = this.b.a;
                if (q2Var != null) {
                    num3 = q2Var.b;
                }
                Intrinsics.checkNotNull(num3);
                i2 = num3.intValue();
            } else {
                i2 = num2.intValue();
            }
        } else {
            q2 ingestionConfig2 = m2Configuration.getIngestionConfig();
            if (ingestionConfig2 == null || (num = ingestionConfig2.a) == null) {
                q2 q2Var2 = this.b.a;
                if (q2Var2 != null) {
                    num3 = q2Var2.a;
                }
                Intrinsics.checkNotNull(num3);
                i2 = num3.intValue();
            } else {
                i2 = num.intValue();
            }
        }
        return o1.b(i2);
    }

    public static void a(Context context, String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        a.a(context, TransmissionSDKReceiver.class, str, j, j2, 0, 0, true);
    }
}
