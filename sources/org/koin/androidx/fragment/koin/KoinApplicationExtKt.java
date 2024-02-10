package org.koin.androidx.fragment.koin;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;
import org.koin.dsl.ModuleDSLKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"fragmentFactoryModule", "Lorg/koin/core/module/Module;", "fragmentFactory", "", "Lorg/koin/core/KoinApplication;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinApplicationExt.kt */
public final class KoinApplicationExtKt {
    private static final Module fragmentFactoryModule = ModuleDSLKt.module$default(false, KoinApplicationExtKt$fragmentFactoryModule$1.INSTANCE, 1, (Object) null);

    public static final void fragmentFactory(KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt.listOf(fragmentFactoryModule), false, 2, (Object) null);
    }
}
