package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.testing.business.DataQualityValidator;
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

/* compiled from: ReportsCreator.kt */
public final class d5 implements KoinComponent {

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
    public static final class b extends Lambda implements Function0<NoSignalMNSIRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository, java.lang.Object] */
        public final NoSignalMNSIRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(NoSignalMNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(NoSignalMNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<LocationRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
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
    public static final class d extends Lambda implements Function0<WifiRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.WifiRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.WifiRepository, java.lang.Object] */
        public final WifiRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(WifiRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(WifiRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class e extends Lambda implements Function0<BadSignalsRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository, java.lang.Object] */
        public final BadSignalsRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(BadSignalsRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(BadSignalsRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class f extends Lambda implements Function0<NDTRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.NDTRepository] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.NDTRepository] */
        public final NDTRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(NDTRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(NDTRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class g extends Lambda implements Function0<DeviceRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(KoinComponent koinComponent) {
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
    public static final class h extends Lambda implements Function0<DataQualityValidator> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.testing.business.DataQualityValidator, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.testing.business.DataQualityValidator, java.lang.Object] */
        public final DataQualityValidator invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(DataQualityValidator.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(DataQualityValidator.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public d5() {
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new d(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new e(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new f(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new g(this));
        r2.a.a();
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new h(this));
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
