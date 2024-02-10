package io.monedata;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.monedata.extensions.PackageManagerKt;
import io.monedata.partners.PartnerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0013\u0010\u0007\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0005H\u0002J#\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/monedata/j1;", "", "Landroid/content/Context;", "context", "", "", "kotlin.jvm.PlatformType", "a", "id", "", "value", "", "Lio/monedata/partners/PartnerAdapter;", "Lio/monedata/s;", "config", "(Landroid/content/Context;Lio/monedata/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "c", "<set-?>", "all", "Ljava/util/List;", "()Ljava/util/List;", "initialized", "nonInitialized", "d", "ready", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class j1 {
    public static final j1 a = new j1();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static List<? extends PartnerAdapter> c = CollectionsKt.emptyList();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.PartnerFactory", f = "PartnerFactory.kt", i = {0, 0}, l = {71}, m = "initialize", n = {"this", "context"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ j1 d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j1 j1Var, Continuation<? super a> continuation) {
            super(continuation);
            this.d = j1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Context) null, (s) null, (Continuation<? super Unit>) this);
        }
    }

    private j1() {
    }

    private final List<String> a(Context context) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            Bundle bundle = PackageManagerKt.getCompatApplicationInfo(packageManager, packageName, 128).metaData;
            Set keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "metaData.keySet()");
            ArrayList arrayList = new ArrayList();
            for (Object next : keySet) {
                String str = (String) next;
                Intrinsics.checkNotNullExpressionValue(bundle, "metaData");
                Intrinsics.checkNotNullExpressionValue(str, "it");
                if (Intrinsics.areEqual((Object) n.a(bundle, str), (Object) "monedata-adapter")) {
                    arrayList.add(next);
                }
            }
            obj = Result.m2344constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        List<String> list = (List) obj;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final PartnerAdapter a(String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) str, (Object) ((PartnerAdapter) t).getId())) {
                break;
            }
        }
        return (PartnerAdapter) t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[LOOP:1: B:26:0x0087->B:28:0x008d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r7, io.monedata.s r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.monedata.j1.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.monedata.j1$a r0 = (io.monedata.j1.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.j1$a r0 = new io.monedata.j1$a
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r7 = r0.b
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r8 = r0.a
            io.monedata.j1 r8 = (io.monedata.j1) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007f
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.List r8 = r8.b()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0049:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0071
            java.lang.Object r2 = r8.next()
            io.monedata.h1 r2 = (io.monedata.h1) r2
            io.monedata.j1 r4 = a
            java.lang.String r5 = r2.b()
            io.monedata.partners.PartnerAdapter r4 = r4.a((java.lang.String) r5)
            if (r4 == 0) goto L_0x006a
            io.monedata.models.Extras r2 = r2.a()
            kotlinx.coroutines.Job r2 = r4.initialize(r7, r2)
            goto L_0x006b
        L_0x006a:
            r2 = 0
        L_0x006b:
            if (r2 == 0) goto L_0x0049
            r9.add(r2)
            goto L_0x0049
        L_0x0071:
            r0.a = r6
            r0.b = r7
            r0.e = r3
            java.lang.Object r8 = kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x007e
            return r1
        L_0x007e:
            r8 = r6
        L_0x007f:
            java.util.List r8 = r8.c()
            java.util.Iterator r8 = r8.iterator()
        L_0x0087:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0097
            java.lang.Object r9 = r8.next()
            io.monedata.partners.PartnerAdapter r9 = (io.monedata.partners.PartnerAdapter) r9
            r9.stop(r7)
            goto L_0x0087
        L_0x0097:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.j1.a(android.content.Context, io.monedata.s, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<PartnerAdapter> a() {
        return c;
    }

    public final void a(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        PartnerAdapter a2 = a(str);
        if (a2 != null) {
            a2.disable(context, z);
        }
    }

    public final List<PartnerAdapter> b() {
        List<? extends PartnerAdapter> list = c;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((PartnerAdapter) next).isInitialized()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void b(Context context) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (b.compareAndSet(false, true)) {
            List<T> distinct = CollectionsKt.distinct(a(context));
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = distinct.iterator();
            while (true) {
                Object obj3 = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.m2344constructorimpl(Class.forName((String) next));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
                }
                if (!Result.m2350isFailureimpl(obj2)) {
                    obj3 = obj2;
                }
                if (obj3 != null) {
                    arrayList.add(obj3);
                }
            }
            ArrayList<PartnerAdapter> arrayList2 = new ArrayList<>();
            for (Object next2 : arrayList) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    Object newInstance = ((Class) next2).newInstance();
                    if (newInstance != null) {
                        obj = Result.m2344constructorimpl((PartnerAdapter) newInstance);
                        if (Result.m2350isFailureimpl(obj)) {
                            obj = null;
                        }
                        if (obj != null) {
                            arrayList2.add(obj);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type io.monedata.partners.PartnerAdapter");
                    }
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.m2344constructorimpl(ResultKt.createFailure(th2));
                }
            }
            for (PartnerAdapter partnerAdapter : arrayList2) {
                MonedataLog.v$default(MonedataLog.INSTANCE, partnerAdapter.getName() + " adapter found (version " + partnerAdapter.getVersion() + ')', (Throwable) null, 2, (Object) null);
            }
            c = arrayList2;
        }
    }

    public final List<PartnerAdapter> c() {
        List<? extends PartnerAdapter> list = c;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (!((PartnerAdapter) next).isInitialized()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (PartnerAdapter warmUp : c) {
            warmUp.warmUp(context);
        }
    }

    public final List<PartnerAdapter> d() {
        List<? extends PartnerAdapter> list = c;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((PartnerAdapter) next).isReady()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
