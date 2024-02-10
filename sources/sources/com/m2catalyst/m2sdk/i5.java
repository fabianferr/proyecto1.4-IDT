package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class i5 extends Lambda implements Function2<Scope, ParametersHolder, MNSIRepository> {
    public static final i5 a = new i5();

    public i5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        MNSIRepository mNSIRepository = new MNSIRepository((NDTRepository) scope.get(Reflection.getOrCreateKotlinClass(NDTRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (NoSignalMNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(NoSignalMNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (WifiRepository) scope.get(Reflection.getOrCreateKotlinClass(WifiRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (MNSIDao) scope.get(Reflection.getOrCreateKotlinClass(MNSIDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (v1) scope.get(Reflection.getOrCreateKotlinClass(v1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (BadSignalsRepository) scope.get(Reflection.getOrCreateKotlinClass(BadSignalsRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        mNSIRepository.setTesting$m2sdk_release(true);
        return mNSIRepository;
    }
}
