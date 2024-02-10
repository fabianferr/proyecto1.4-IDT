package com.m2catalyst.m2sdk;

import androidx.lifecycle.ViewModel;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
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

/* compiled from: MainTestingActivityViewModel.kt */
public final class m3 extends ViewModel implements KoinComponent {

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
    public static final class c extends Lambda implements Function0<DeviceRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
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

    public m3() {
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
        LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
