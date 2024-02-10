package com.m2catalyst.m2sdk;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.google.firebase.analytics.FirebaseAnalytics;
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
public final class q6 extends TelephonyCallback implements TelephonyCallback.CellLocationListener, TelephonyCallback.ServiceStateListener, TelephonyCallback.SignalStrengthsListener, TelephonyCallback.DisplayInfoListener, v2 {
    public final q3 a;
    public final int b;
    public final Context c;
    public final ArrayList<String> d = new ArrayList<>();

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.TelephonyCallbackMin31NoReadPhone$onCellLocationChanged$1", f = "M2PhoneStateListener.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q6 b;
        public final /* synthetic */ CellLocation c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q6 q6Var, CellLocation cellLocation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = q6Var;
            this.c = cellLocation;
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
                q6 q6Var = this.b;
                q3 q3Var = q6Var.a;
                int i2 = q6Var.b;
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.TelephonyCallbackMin31NoReadPhone$onDisplayInfoChanged$1", f = "M2PhoneStateListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ q6 a;
        public final /* synthetic */ TelephonyDisplayInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q6 q6Var, TelephonyDisplayInfo telephonyDisplayInfo, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = q6Var;
            this.b = telephonyDisplayInfo;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            q6 q6Var = this.a;
            q6Var.a.a(q6Var.b, this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.TelephonyCallbackMin31NoReadPhone$onServiceStateChanged$1", f = "M2PhoneStateListener.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q6 b;
        public final /* synthetic */ ServiceState c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(q6 q6Var, ServiceState serviceState, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = q6Var;
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
                q6 q6Var = this.b;
                q3 q3Var = q6Var.a;
                int i2 = q6Var.b;
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.TelephonyCallbackMin31NoReadPhone$onSignalStrengthsChanged$1", f = "M2PhoneStateListener.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q6 b;
        public final /* synthetic */ SignalStrength c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(q6 q6Var, SignalStrength signalStrength, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = q6Var;
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
                q6 q6Var = this.b;
                q3 q3Var = q6Var.a;
                int i2 = q6Var.b;
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

    public q6(q3 q3Var, int i, Context context) {
        Intrinsics.checkNotNullParameter(q3Var, "networkCollectionManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = q3Var;
        this.b = i;
        this.c = context;
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

    public final void onCellLocationChanged(CellLocation cellLocation) {
        Intrinsics.checkNotNullParameter(cellLocation, FirebaseAnalytics.Param.LOCATION);
        a();
        a(0, "<b>CellLocation=</b>" + cellLocation);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState instance = SDKState.Companion.getInstance();
        ArrayList<String> arrayList = this.d;
        Intrinsics.checkNotNull(arrayList);
        instance.sim$m2sdk_release(arrayList, this.c, this.b);
        j3.b(new a(this, cellLocation, (Continuation<? super a>) null));
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
        a();
        a(5, "<b>TelephonyDisplayInfo=</b>" + telephonyDisplayInfo);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState instance = SDKState.Companion.getInstance();
        ArrayList<String> arrayList = this.d;
        Intrinsics.checkNotNull(arrayList);
        instance.sim$m2sdk_release(arrayList, this.c, this.b);
        j3.b(new b(this, telephonyDisplayInfo, (Continuation<? super b>) null));
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        Intrinsics.checkNotNullParameter(serviceState, "serviceState");
        a();
        a(2, "<b>ServiceState=</b>" + serviceState);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState instance = SDKState.Companion.getInstance();
        ArrayList<String> arrayList = this.d;
        Intrinsics.checkNotNull(arrayList);
        instance.sim$m2sdk_release(arrayList, this.c, this.b);
        j3.b(new c(this, serviceState, (Continuation<? super c>) null));
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        Intrinsics.checkNotNullParameter(signalStrength, "signalStrength");
        a();
        a(3, "<b>CellSignalStrength=</b>" + signalStrength);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState instance = SDKState.Companion.getInstance();
        ArrayList<String> arrayList = this.d;
        Intrinsics.checkNotNull(arrayList);
        instance.sim$m2sdk_release(arrayList, this.c, this.b);
        j3.b(new d(this, signalStrength, (Continuation<? super d>) null));
    }

    public final void a(List<CellInfo> list) {
        Intrinsics.checkNotNullParameter(list, "cellInfo");
        StringBuilder sb = new StringBuilder();
        for (CellInfo cellInfo : list) {
            sb.append(cellInfo.toString());
        }
        a(1, "<b>CellInfo=</b>" + sb);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState instance = SDKState.Companion.getInstance();
        ArrayList<String> arrayList = this.d;
        Intrinsics.checkNotNull(arrayList);
        instance.sim$m2sdk_release(arrayList, this.c, this.b);
        this.a.a((List) list, this.b);
    }

    public final void a() {
        int i;
        List<CellInfo> allCellInfo;
        Object systemService = this.c.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager createForSubscriptionId = ((TelephonyManager) systemService).createForSubscriptionId(this.b);
        Context context = this.c;
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
                a(mutableList);
            }
        }
    }
}
