package com.m2catalyst.m2sdk;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyDisplayInfo;
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
public final class q4 extends PhoneStateListener implements v2 {
    public final q3 a;
    public final int b;
    public final Context c;
    public final ArrayList<String> d = new ArrayList<>();

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin30$onCellInfoChanged$1$2", f = "M2PhoneStateListener.kt", i = {}, l = {453}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q4 b;
        public final /* synthetic */ List<CellInfo> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q4 q4Var, List<CellInfo> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = q4Var;
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
                q4 q4Var = this.b;
                q3 q3Var = q4Var.a;
                int i2 = q4Var.b;
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin30$onCellLocationChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q4 b;
        public final /* synthetic */ CellLocation c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q4 q4Var, CellLocation cellLocation, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = q4Var;
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
                q4 q4Var = this.b;
                q3 q3Var = q4Var.a;
                int i2 = q4Var.b;
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin30$onDisplayInfoChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ q4 a;
        public final /* synthetic */ TelephonyDisplayInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(q4 q4Var, TelephonyDisplayInfo telephonyDisplayInfo, Continuation<? super c> continuation) {
            super(2, continuation);
            this.a = q4Var;
            this.b = telephonyDisplayInfo;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.a, this.b, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            q4 q4Var = this.a;
            q4Var.a.a(q4Var.b, this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin30$onServiceStateChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {479}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q4 b;
        public final /* synthetic */ ServiceState c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(q4 q4Var, ServiceState serviceState, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = q4Var;
            this.c = serviceState;
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
                q4 q4Var = this.b;
                q3 q3Var = q4Var.a;
                int i2 = q4Var.b;
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

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.PhoneStateListenerMin30$onSignalStrengthsChanged$1$1", f = "M2PhoneStateListener.kt", i = {}, l = {505}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2PhoneStateListener.kt */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ q4 b;
        public final /* synthetic */ SignalStrength c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(q4 q4Var, SignalStrength signalStrength, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = q4Var;
            this.c = signalStrength;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((e) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                q4 q4Var = this.b;
                q3 q3Var = q4Var.a;
                int i2 = q4Var.b;
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

    public q4(q3 q3Var, int i, Context context) {
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

    public final void onCellInfoChanged(List<CellInfo> list) {
        hashCode();
        super.onCellInfoChanged(list);
        if (list != null) {
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
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new a(this, list, (Continuation<? super a>) null));
        }
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        hashCode();
        a(this.c);
        super.onCellLocationChanged(cellLocation);
        if (cellLocation != null) {
            a(0, "<b>CellLocation=</b>" + cellLocation);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                int i = this.b;
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new b(this, cellLocation, (Continuation<? super b>) null));
        }
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
        hashCode();
        a(this.c);
        super.onDisplayInfoChanged(telephonyDisplayInfo);
        a(5, "<b>TelephonyDisplayInfo=</b>" + telephonyDisplayInfo);
        if (o4.e(this.c)) {
            Object systemService = this.c.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
            int i = this.b;
            a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
        }
        SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
        j3.b(new c(this, telephonyDisplayInfo, (Continuation<? super c>) null));
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        hashCode();
        a(this.c);
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            a(2, "<b>ServiceState=</b>" + serviceState);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                int i = this.b;
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new d(this, serviceState, (Continuation<? super d>) null));
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        hashCode();
        a(this.c);
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            a(3, "<b>CellSignalStrength=</b>" + signalStrength);
            if (o4.e(this.c)) {
                Object systemService = this.c.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                int dataNetworkType = ((TelephonyManager) systemService).createForSubscriptionId(this.b).getDataNetworkType();
                int i = this.b;
                a(4, "<b>TelephonyManager.networkType=</b>" + dataNetworkType + "<br>sub=" + i);
            }
            SDKState.Companion.getInstance().sim$m2sdk_release(this.d, this.c, this.b);
            j3.b(new e(this, signalStrength, (Continuation<? super e>) null));
        }
    }

    public final void a(Context context) {
        List<CellInfo> allCellInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager createForSubscriptionId = ((TelephonyManager) systemService).createForSubscriptionId(this.b);
        if (o4.c(context) && (allCellInfo = createForSubscriptionId.getAllCellInfo()) != null) {
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
                this.a.a(mutableList, this.b);
            }
        }
    }
}
