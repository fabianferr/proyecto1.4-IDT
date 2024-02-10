package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: AutotestingManager.kt */
public final class d implements KoinComponent {

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
    public static final class b extends Lambda implements Function0<d5> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.d5, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.d5, java.lang.Object] */
        public final d5 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(d5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(d5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<ApiKeyRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository] */
        public final ApiKeyRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(ApiKeyRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(ApiKeyRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* renamed from: com.m2catalyst.m2sdk.d$d  reason: collision with other inner class name */
    /* compiled from: KoinComponent.kt */
    public static final class C0124d extends Lambda implements Function0<DeviceRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0124d(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        public final DeviceRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class e extends Lambda implements Function0<x6> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.x6, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.x6, java.lang.Object] */
        public final x6 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(x6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(x6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public d() {
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new C0124d(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new e(this));
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
