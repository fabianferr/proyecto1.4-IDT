package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Handler;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.m2catalyst.m2sdk.external.SDKState;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: M2PhoneStateListener.kt */
public final class p4 extends PhoneStateListener implements v2 {
    public final q3 a;
    public final int b;
    public final Context c;
    public final ArrayList<String> d = new ArrayList<>();
    public final Handler e = new Handler();
    public Runnable f;

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin24$cellInfoChanged$1$2", f = "M2PhoneStateListener.kt", i = {}, l = {635}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ p4 b;
        public final /* synthetic */ List<CellInfo> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p4 p4Var, List<CellInfo> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = p4Var;
            this.c = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                p4 p4Var = this.b;
                q3 q3Var = p4Var.a;
                int i2 = p4Var.b;
                List<CellInfo> list = this.c;
                this.a = 1;
                if (q3Var.a((List) list, i2, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin24$onCellLocationChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {610}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ p4 b;
        public final /* synthetic */ CellLocation c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p4 p4Var, CellLocation cellLocation, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = p4Var;
            this.c = cellLocation;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                p4 p4Var = this.b;
                q3 q3Var = p4Var.a;
                int i2 = p4Var.b;
                CellLocation cellLocation = this.c;
                this.a = 1;
                if (q3Var.a(i2, cellLocation, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin24$onServiceStateChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {660}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ p4 b;
        public final /* synthetic */ ServiceState c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p4 p4Var, ServiceState serviceState, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = p4Var;
            this.c = serviceState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                p4 p4Var = this.b;
                q3 q3Var = p4Var.a;
                int i2 = p4Var.b;
                ServiceState serviceState = this.c;
                this.a = 1;
                if (q3Var.a(i2, serviceState, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin24$onSignalStrengthsChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {685}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ p4 b;
        public final /* synthetic */ SignalStrength c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(p4 p4Var, SignalStrength signalStrength, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = p4Var;
            this.c = signalStrength;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                p4 p4Var = this.b;
                q3 q3Var = p4Var.a;
                int i2 = p4Var.b;
                SignalStrength signalStrength = this.c;
                this.a = 1;
                if (q3Var.a(i2, signalStrength, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public p4(q3 q3Var, int i, Context context) {
        Intrinsics.checkNotNullParameter(q3Var, "networkCollectionManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = q3Var;
        this.b = i;
        this.c = context;
    }

    public final void a() {
        if (this.f == null) {
            p4$$ExternalSyntheticLambda0 p4__externalsyntheticlambda0 = new p4$$ExternalSyntheticLambda0(this);
            this.f = p4__externalsyntheticlambda0;
            this.e.post(p4__externalsyntheticlambda0);
        }
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (cellLocation != null) {
            a(0, "<b>CellLocation=</b>" + cellLocation);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new b(this, cellLocation, (Continuation<? super b>) null));
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            a(2, "<b>ServiceState=</b>" + serviceState);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new c(this, serviceState, (Continuation<? super c>) null));
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            a(3, "<b>CellSignalStrength=</b>" + signalStrength);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new d(this, signalStrength, (Continuation<? super d>) null));
        }
    }

    public final void a(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        ArrayList<String> arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            for (int i2 = 0; i2 < 7; i2++) {
                ArrayList<String> arrayList2 = this.d;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add("");
            }
        }
        ArrayList<String> arrayList3 = this.d;
        Intrinsics.checkNotNull(arrayList3);
        arrayList3.set(i, str);
    }

    public final void a(List<CellInfo> list) {
        StringBuilder sb = new StringBuilder();
        for (CellInfo cellInfo : list) {
            sb.append(cellInfo.toString());
        }
        a(1, "<b>CellInfo=</b>" + sb);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType);
        }
        SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
        j3.b(new a(this, list, (Continuation<? super a>) null));
    }

    public static final void a(p4 p4Var) {
        int i;
        Handler handler;
        List<CellInfo> allCellInfo;
        Intrinsics.checkNotNullParameter(p4Var, "this$0");
        Object systemService = p4Var.c.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager createForSubscriptionId = ((TelephonyManager) systemService).createForSubscriptionId(p4Var.b);
        Context context = p4Var.c;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_FINE_LOCATION");
        }
        if ((i == 0) && (allCellInfo = createForSubscriptionId.getAllCellInfo()) != null) {
            ArrayList arrayList = new ArrayList();
            for (T next : allCellInfo) {
                CellInfo cellInfo = (CellInfo) next;
                Intrinsics.checkNotNullExpressionValue(cellInfo, "it");
                Intrinsics.checkNotNullExpressionValue(createForSubscriptionId, "telephonyManager");
                if (m4.a(cellInfo, createForSubscriptionId)) {
                    arrayList.add(next);
                }
            }
            List mutableList = CollectionsKt.toMutableList(arrayList);
            if (mutableList != null) {
                p4Var.a((List<CellInfo>) mutableList);
            }
        }
        Runnable runnable = p4Var.f;
        if (runnable != null && (handler = p4Var.e) != null) {
            handler.postDelayed(runnable, 2000);
        }
    }
}
