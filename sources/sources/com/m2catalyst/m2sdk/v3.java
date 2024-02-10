package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.m2catalyst.m2sdk.business.models.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: NetworkCollectionOrchestrator.kt */
public final class v3 implements KoinComponent {
    public final Lazy a = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    public final Lazy c = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
    public final Lazy d = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new d(this));
    public SparseArray<TelephonyManager> e = new SparseArray<>();
    public SparseArray<v2> f = new SparseArray<>();
    public final int[] g = {-1, -1, -1};
    public Job h;
    public SubscriptionManager.OnSubscriptionsChangedListener i;
    public final SubscriptionManager j;

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<w> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.w, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.w, java.lang.Object] */
        public final w invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(w.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(w.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<z3> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.z3] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.z3] */
        public final z3 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(z3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(z3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<q3> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.q3, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.q3, java.lang.Object] */
        public final q3 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class d extends Lambda implements Function0<Context> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KoinComponent koinComponent) {
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionOrchestrator", f = "NetworkCollectionOrchestrator.kt", i = {0, 1}, l = {254, 255}, m = "start", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* compiled from: NetworkCollectionOrchestrator.kt */
    public static final class e extends ContinuationImpl {
        public v3 a;
        public /* synthetic */ Object b;
        public final /* synthetic */ v3 c;
        public int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(v3 v3Var, Continuation<? super e> continuation) {
            super(continuation);
            this.c = v3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super Boolean>) this);
        }
    }

    public v3() {
        Object systemService = a().getApplicationContext().getSystemService("telephony_subscription_service");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
        this.j = (SubscriptionManager) systemService;
    }

    public final Context a() {
        return (Context) this.d.getValue();
    }

    public final boolean b() {
        int i2;
        if (this.f.size() == 0) {
            return false;
        }
        Context a2 = a();
        Intrinsics.checkNotNullParameter(a2, "context");
        try {
            i2 = a2.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused) {
            i2 = v.a(a2.getPackageManager(), "context.packageManager", a2, "android.permission.READ_PHONE_STATE");
        }
        if (i2 == 0) {
            ArrayList b2 = m6.b(a());
            if (this.f.size() != b2.size()) {
                return true;
            }
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                if (this.f.get(((SubInfo) it.next()).getId()) == null) {
                    return true;
                }
            }
            return false;
        }
        boolean z = (this.g[0] == SubscriptionManager.getDefaultDataSubscriptionId() && this.g[1] == SubscriptionManager.getDefaultSmsSubscriptionId() && this.g[2] == SubscriptionManager.getDefaultVoiceSubscriptionId()) ? false : true;
        this.g[0] = SubscriptionManager.getDefaultDataSubscriptionId();
        this.g[1] = SubscriptionManager.getDefaultSmsSubscriptionId();
        this.g[2] = SubscriptionManager.getDefaultVoiceSubscriptionId();
        return z;
    }

    public final void c() {
        SparseArray<TelephonyManager> sparseArray = this.e;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            TelephonyManager valueAt = sparseArray.valueAt(i2);
            TelephonyCallback telephonyCallback = (v2) this.f.get(keyAt);
            if (telephonyCallback != null) {
                if (Build.VERSION.SDK_INT < 31 || !(telephonyCallback instanceof TelephonyCallback)) {
                    if (telephonyCallback instanceof p4) {
                        p4 p4Var = (p4) telephonyCallback;
                        Runnable runnable = p4Var.f;
                        if (runnable != null) {
                            p4Var.e.removeCallbacks(runnable);
                        }
                        p4Var.f = null;
                    }
                    valueAt.listen((PhoneStateListener) telephonyCallback, 0);
                } else {
                    valueAt.unregisterTelephonyCallback(telephonyCallback);
                }
            }
        }
        this.e.clear();
        this.f.clear();
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r14 = this;
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            android.util.SparseArray<android.telephony.TelephonyManager> r1 = r14.e
            int r2 = r1.size()
            r3 = 0
            r4 = 0
        L_0x000a:
            r5 = 31
            if (r4 >= r2) goto L_0x004b
            int r6 = r1.keyAt(r4)
            java.lang.Object r7 = r1.valueAt(r4)
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7
            android.util.SparseArray<com.m2catalyst.m2sdk.v2> r8 = r14.f
            java.lang.Object r6 = r8.get(r6)
            com.m2catalyst.m2sdk.v2 r6 = (com.m2catalyst.m2sdk.v2) r6
            if (r6 == 0) goto L_0x0048
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r5) goto L_0x0030
            boolean r5 = r6 instanceof android.telephony.TelephonyCallback
            if (r5 == 0) goto L_0x0030
            android.telephony.TelephonyCallback r6 = (android.telephony.TelephonyCallback) r6
            r7.unregisterTelephonyCallback(r6)
            goto L_0x0048
        L_0x0030:
            boolean r5 = r6 instanceof com.m2catalyst.m2sdk.p4
            if (r5 == 0) goto L_0x0043
            r5 = r6
            com.m2catalyst.m2sdk.p4 r5 = (com.m2catalyst.m2sdk.p4) r5
            java.lang.Runnable r8 = r5.f
            if (r8 == 0) goto L_0x0040
            android.os.Handler r9 = r5.e
            r9.removeCallbacks(r8)
        L_0x0040:
            r8 = 0
            r5.f = r8
        L_0x0043:
            android.telephony.PhoneStateListener r6 = (android.telephony.PhoneStateListener) r6
            r7.listen(r6, r3)
        L_0x0048:
            int r4 = r4 + 1
            goto L_0x000a
        L_0x004b:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            java.lang.String r6 = "context.packageManager"
            java.lang.String r7 = "context"
            r8 = 1
            if (r1 != r2) goto L_0x0077
            android.content.Context r1 = r14.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            int r1 = r1.checkCallingOrSelfPermission(r4)     // Catch:{ RuntimeException -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            android.content.pm.PackageManager r2 = r1.getPackageManager()
            int r1 = com.m2catalyst.m2sdk.v.a(r2, r6, r1, r4)
        L_0x006c:
            if (r1 != 0) goto L_0x0070
            r1 = 1
            goto L_0x0071
        L_0x0070:
            r1 = 0
        L_0x0071:
            if (r1 == 0) goto L_0x0077
            r1 = 1048897(0x100141, float:1.469818E-39)
            goto L_0x0079
        L_0x0077:
            r1 = 321(0x141, float:4.5E-43)
        L_0x0079:
            android.content.Context r2 = r14.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            int r2 = r2.checkCallingOrSelfPermission(r0)     // Catch:{ RuntimeException -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            android.content.pm.PackageManager r9 = r2.getPackageManager()
            int r2 = com.m2catalyst.m2sdk.v.a(r9, r6, r2, r0)
        L_0x008d:
            if (r2 != 0) goto L_0x0091
            r2 = 1
            goto L_0x0092
        L_0x0091:
            r2 = 0
        L_0x0092:
            if (r2 == 0) goto L_0x0096
            r1 = r1 | 16
        L_0x0096:
            android.content.Context r2 = r14.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            int r2 = r2.checkCallingOrSelfPermission(r0)     // Catch:{ RuntimeException -> 0x00a2 }
            goto L_0x00aa
        L_0x00a2:
            android.content.pm.PackageManager r9 = r2.getPackageManager()
            int r2 = com.m2catalyst.m2sdk.v.a(r9, r6, r2, r0)
        L_0x00aa:
            if (r2 != 0) goto L_0x00ae
            r2 = 1
            goto L_0x00af
        L_0x00ae:
            r2 = 0
        L_0x00af:
            if (r2 == 0) goto L_0x00ce
            android.content.Context r2 = r14.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            int r2 = r2.checkCallingOrSelfPermission(r4)     // Catch:{ RuntimeException -> 0x00bd }
            goto L_0x00c5
        L_0x00bd:
            android.content.pm.PackageManager r9 = r2.getPackageManager()
            int r2 = com.m2catalyst.m2sdk.v.a(r9, r6, r2, r4)
        L_0x00c5:
            if (r2 != 0) goto L_0x00c9
            r2 = 1
            goto L_0x00ca
        L_0x00c9:
            r2 = 0
        L_0x00ca:
            if (r2 == 0) goto L_0x00ce
            r1 = r1 | 1024(0x400, float:1.435E-42)
        L_0x00ce:
            android.util.SparseArray<com.m2catalyst.m2sdk.v2> r2 = r14.f
            int r4 = r2.size()
            r9 = 0
        L_0x00d5:
            if (r9 >= r4) goto L_0x013e
            int r10 = r2.keyAt(r9)
            java.lang.Object r11 = r2.valueAt(r9)
            com.m2catalyst.m2sdk.v2 r11 = (com.m2catalyst.m2sdk.v2) r11
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r5) goto L_0x011e
            boolean r12 = r11 instanceof android.telephony.TelephonyCallback
            if (r12 == 0) goto L_0x011e
            android.content.Context r12 = r14.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r7)
            int r12 = r12.checkCallingOrSelfPermission(r0)     // Catch:{ RuntimeException -> 0x00f5 }
            goto L_0x00fd
        L_0x00f5:
            android.content.pm.PackageManager r13 = r12.getPackageManager()
            int r12 = com.m2catalyst.m2sdk.v.a(r13, r6, r12, r0)
        L_0x00fd:
            if (r12 != 0) goto L_0x0101
            r12 = 1
            goto L_0x0102
        L_0x0101:
            r12 = 0
        L_0x0102:
            if (r12 == 0) goto L_0x011e
            android.util.SparseArray<android.telephony.TelephonyManager> r12 = r14.e
            java.lang.Object r10 = r12.get(r10)
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10
            if (r10 == 0) goto L_0x013b
            java.lang.String r12 = "get(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            com.m2catalyst.m2sdk.v3$$ExternalSyntheticLambda0 r12 = new com.m2catalyst.m2sdk.v3$$ExternalSyntheticLambda0
            r12.<init>()
            android.telephony.TelephonyCallback r11 = (android.telephony.TelephonyCallback) r11
            r10.registerTelephonyCallback(r12, r11)
            goto L_0x013b
        L_0x011e:
            boolean r12 = r11 instanceof android.telephony.PhoneStateListener
            if (r12 == 0) goto L_0x013b
            boolean r12 = r11 instanceof com.m2catalyst.m2sdk.p4
            if (r12 == 0) goto L_0x012c
            r12 = r11
            com.m2catalyst.m2sdk.p4 r12 = (com.m2catalyst.m2sdk.p4) r12
            r12.a()
        L_0x012c:
            android.util.SparseArray<android.telephony.TelephonyManager> r12 = r14.e
            java.lang.Object r10 = r12.get(r10)
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10
            if (r10 == 0) goto L_0x013b
            android.telephony.PhoneStateListener r11 = (android.telephony.PhoneStateListener) r11
            r10.listen(r11, r1)
        L_0x013b:
            int r9 = r9 + 1
            goto L_0x00d5
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.v3.d():void");
    }

    public final void e() {
        SubscriptionManager.OnSubscriptionsChangedListener onSubscriptionsChangedListener = this.i;
        if (onSubscriptionsChangedListener != null) {
            SubscriptionManager subscriptionManager = this.j;
            if (subscriptionManager != null) {
                subscriptionManager.removeOnSubscriptionsChangedListener(onSubscriptionsChangedListener);
            }
            this.i = null;
        }
        SparseArray<TelephonyManager> sparseArray = this.e;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            TelephonyManager valueAt = sparseArray.valueAt(i2);
            TelephonyCallback telephonyCallback = (v2) this.f.get(keyAt);
            if (telephonyCallback != null) {
                if (Build.VERSION.SDK_INT < 31 || !(telephonyCallback instanceof TelephonyCallback)) {
                    if (telephonyCallback instanceof p4) {
                        p4 p4Var = (p4) telephonyCallback;
                        Runnable runnable = p4Var.f;
                        if (runnable != null) {
                            p4Var.e.removeCallbacks(runnable);
                        }
                        p4Var.f = null;
                    }
                    valueAt.listen((PhoneStateListener) telephonyCallback, 0);
                } else {
                    valueAt.unregisterTelephonyCallback(telephonyCallback);
                }
            }
        }
        this.e.clear();
        this.f.clear();
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
        q3 q3Var = (q3) this.c.getValue();
        q3Var.i.clear();
        q3Var.l.d("MNSI_BUILDER", "MNSI in queue cleared because collection restarted", new String[0]);
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public static final void a(Runnable runnable) {
        runnable.run();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.v3.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.v3$e r0 = (com.m2catalyst.m2sdk.v3.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.v3$e r0 = new com.m2catalyst.m2sdk.v3$e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            com.m2catalyst.m2sdk.v3 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007f
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0037:
            com.m2catalyst.m2sdk.v3 r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.a = r6
            r0.d = r5
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            com.m2catalyst.m2sdk.u3 r2 = new com.m2catalyst.m2sdk.u3
            r2.<init>(r6, r4)
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r2) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x005a:
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r2 = r6
        L_0x005e:
            r0.a = r2
            r0.d = r3
            r2.getClass()
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            com.m2catalyst.m2sdk.t3 r3 = new com.m2catalyst.m2sdk.t3
            r3.<init>(r2, r4)
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r3, r0)
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x007b:
            if (r7 != r1) goto L_0x007e
            return r1
        L_0x007e:
            r0 = r2
        L_0x007f:
            android.content.Context r7 = r0.a()
            java.lang.String r1 = "connectivity"
            java.lang.Object r7 = r7.getSystemService(r1)
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7
            android.util.SparseArray<com.m2catalyst.m2sdk.v2> r1 = r0.f
            int r1 = r1.size()
            r2 = 0
            if (r1 != 0) goto L_0x0096
            r1 = 1
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            if (r1 == 0) goto L_0x009e
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r7
        L_0x009e:
            if (r7 == 0) goto L_0x00db
            android.net.NetworkInfo r7 = r7.getNetworkInfo(r2)
            if (r7 == 0) goto L_0x00db
            kotlin.Lazy r7 = r0.b
            java.lang.Object r7 = r7.getValue()
            com.m2catalyst.m2sdk.z3 r7 = (com.m2catalyst.m2sdk.z3) r7
            com.m2catalyst.m2sdk.v6 r0 = r7.a
            r0.getClass()
            long r0 = com.m2catalyst.m2sdk.v6.b()
            r7.d = r0
            com.m2catalyst.m2sdk.v6 r0 = r7.a
            r0.getClass()
            long r0 = com.m2catalyst.m2sdk.v6.a()
            r7.e = r0
            com.m2catalyst.m2sdk.v6 r0 = r7.a
            r0.getClass()
            long r0 = com.m2catalyst.m2sdk.v6.d()
            r7.f = r0
            com.m2catalyst.m2sdk.v6 r0 = r7.a
            r0.getClass()
            long r0 = com.m2catalyst.m2sdk.v6.c()
            r7.g = r0
            goto L_0x00dc
        L_0x00db:
            r5 = 0
        L_0x00dc:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.v3.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
