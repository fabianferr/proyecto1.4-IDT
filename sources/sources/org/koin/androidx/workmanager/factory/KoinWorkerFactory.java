package org.koin.androidx.workmanager.factory;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.qualifier.QualifierKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lorg/koin/androidx/workmanager/factory/KoinWorkerFactory;", "Landroidx/work/WorkerFactory;", "Lorg/koin/core/component/KoinComponent;", "()V", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "koin-androidx-workmanager_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinWorkerFactory.kt */
public final class KoinWorkerFactory extends WorkerFactory implements KoinComponent {
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(str, "workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        return (ListenableWorker) getKoin().getScopeRegistry().getRootScope().getOrNull(Reflection.getOrCreateKotlinClass(ListenableWorker.class), QualifierKt.named(str), new KoinWorkerFactory$createWorker$1(workerParameters));
    }
}
