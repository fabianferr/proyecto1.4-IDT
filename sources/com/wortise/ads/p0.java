package com.wortise.ads;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkManager;
import com.wortise.ads.n4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B'\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/wortise/ads/p0;", "Lcom/wortise/ads/n4;", "T", "Lcom/wortise/ads/h0;", "Lkotlin/reflect/KClass;", "Landroidx/work/ListenableWorker;", "clazz", "Lkotlin/reflect/KClass;", "c", "()Lkotlin/reflect/KClass;", "Landroidx/work/WorkManager;", "d", "()Landroidx/work/WorkManager;", "workManager", "Landroid/content/Context;", "context", "", "name", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/reflect/KClass;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseWorkerJob.kt */
public abstract class p0<T extends n4> extends h0<T> {
    private final KClass<? extends ListenableWorker> c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p0(Context context, String str, KClass<? extends ListenableWorker> kClass) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        this.c = kClass;
    }

    /* access modifiers changed from: protected */
    public final KClass<? extends ListenableWorker> c() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final WorkManager d() {
        WorkManager b = e7.b(a());
        if (b != null) {
            return b;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
