package io.monedata;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/r;", "", "Landroid/content/Context;", "context", "Lio/monedata/q;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
/* renamed from: io.monedata.r  reason: case insensitive filesystem */
public final class C0242r {
    public static final C0242r a = new C0242r();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.models.factories.ClientInfoFactory", f = "ClientInfoFactory.kt", i = {0, 0, 0}, l = {25}, m = "create", n = {"context", "metadata", "packageInfo"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: io.monedata.r$a */
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        final /* synthetic */ C0242r f;
        int g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C0242r rVar, Continuation<? super a> continuation) {
            super(continuation);
            this.f = rVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return this.f.a((Context) null, this);
        }
    }

    private C0242r() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r12, kotlin.coroutines.Continuation<? super io.monedata.q> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof io.monedata.C0242r.a
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.monedata.r$a r0 = (io.monedata.C0242r.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.r$a r0 = new io.monedata.r$a
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r12 = r0.d
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r0.c
            android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1
            java.lang.Object r2 = r0.b
            io.monedata.a1 r2 = (io.monedata.a1) r2
            java.lang.Object r0 = r0.a
            android.content.Context r0 = (android.content.Context) r0
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r1
            r1 = r12
            r12 = r0
            r0 = r10
            goto L_0x006e
        L_0x003d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r13)
            io.monedata.a1$a r13 = io.monedata.a1.e
            io.monedata.a1 r2 = r13.a(r12)
            r13 = 0
            android.content.pm.PackageInfo r13 = io.monedata.extensions.ContextKt.getPackageInfo(r12, r13)
            java.lang.String r4 = r12.getPackageName()
            io.monedata.p r5 = io.monedata.p.a
            r0.a = r12
            r0.b = r2
            r0.c = r13
            r0.d = r4
            r0.g = r3
            java.lang.Object r0 = r5.a(r12, r0)
            if (r0 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r1 = r4
            r10 = r0
            r0 = r13
            r13 = r10
        L_0x006e:
            io.monedata.o r13 = (io.monedata.o) r13
            io.monedata.a r3 = io.monedata.a.a
            boolean r3 = r3.b()
            java.lang.String r4 = r2.c()
            java.lang.String r7 = r2.e()
            r2 = 0
            if (r0 == 0) goto L_0x008b
            long r5 = io.monedata.extensions.PackageInfoKt.getCompatVersionCode(r0)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r8 = r5
            goto L_0x008c
        L_0x008b:
            r8 = r2
        L_0x008c:
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r0.versionName
            r9 = r0
            goto L_0x0093
        L_0x0092:
            r9 = r2
        L_0x0093:
            io.monedata.managers.PermissionManager r0 = io.monedata.managers.PermissionManager.INSTANCE
            java.util.List r5 = r0.granted(r12)
            r6 = 2
            java.util.List r6 = io.monedata.managers.PermissionManager.get$default(r0, r12, r2, r6, r2)
            io.monedata.q r12 = new io.monedata.q
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = r12
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.C0242r.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
