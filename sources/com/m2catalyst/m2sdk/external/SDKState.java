package com.m2catalyst.m2sdk.external;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.SubInfo;
import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.m6;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.q;
import com.m2catalyst.m2sdk.speed_test.legacy.TestBaseEvent;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.m2catalyst.m2sdk.t4;
import com.m2catalyst.m2sdk.testing.business.DataQualityValidator;
import com.m2catalyst.m2sdk.w2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 |2\u00020\u0001:\u0001|B\t\b\u0002¢\u0006\u0004\bz\u0010{J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0012\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0017\u0010\u0015J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0018\u0010\u0015J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0019\u0010\u0015J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017J\u001e\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0002\u0018\u00010\u001b2\u0006\u0010\u0012\u001a\u00020\rH\u0017J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0017R\u0016\u0010\"\u001a\u0004\u0018\u00010!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\"\u00103\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001b\u0010;\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR.\u0010F\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010D8\u0000@@X\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u001b8\u0000X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR:\u0010P\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0000@@X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR&\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u001b8\u0000X\u0004¢\u0006\f\n\u0004\bV\u0010M\u001a\u0004\bW\u0010OR:\u0010X\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0000@@X\u000e¢\u0006\u0012\n\u0004\bX\u0010Q\u001a\u0004\bY\u0010S\"\u0004\bZ\u0010UR&\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u001b8\u0000X\u0004¢\u0006\f\n\u0004\b[\u0010M\u001a\u0004\b\\\u0010OR.\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010E\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001f\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b8\u0006¢\u0006\f\n\u0004\bc\u0010M\u001a\u0004\bd\u0010OR.\u0010e\u001a\u0004\u0018\u00010\u00032\b\u0010E\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\be\u0010^\u001a\u0004\bf\u0010`\"\u0004\bg\u0010bR\u001f\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b8\u0006¢\u0006\f\n\u0004\bh\u0010M\u001a\u0004\bi\u0010OR.\u0010k\u001a\u0004\u0018\u00010j2\b\u0010E\u001a\u0004\u0018\u00010j8\u0000@@X\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0\u001b8\u0000X\u0004¢\u0006\f\n\u0004\bq\u0010M\u001a\u0004\br\u0010OR.\u0010s\u001a\u0004\u0018\u00010\u00132\b\u0010E\u001a\u0004\u0018\u00010\u00138\u0000@@X\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010wR\"\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b8\u0000X\u0004¢\u0006\f\n\u0004\bx\u0010M\u001a\u0004\by\u0010O¨\u0006}"}, d2 = {"Lcom/m2catalyst/m2sdk/external/SDKState;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$SDKStateAvailability;", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsis", "Lcom/m2catalyst/m2sdk/t4;", "getMNSIReport$m2sdk_release", "(Ljava/util/List;)Lcom/m2catalyst/m2sdk/t4;", "getMNSIReport", "", "listener", "Landroid/content/Context;", "context", "", "sub", "", "sim$m2sdk_release", "(Ljava/util/List;Landroid/content/Context;I)V", "sim", "", "getFineLocationPermissionGranted", "()Ljava/lang/Boolean;", "getCoarseLocationPermissionGranted", "getBackgroundLocationPermissionGranted", "getReadPhoneStatePermissionGranted", "getPackageUsageStatsPermissionGranted", "getReportOnMNSIList", "Landroidx/lifecycle/MutableLiveData;", "getCellLogBySimLiveData", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "getCurrentNDTTest", "Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", "getLastNDTEvent", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "fineLocationPermissionGranted", "Z", "getFineLocationPermissionGranted$m2sdk_release", "()Z", "setFineLocationPermissionGranted$m2sdk_release", "(Z)V", "coarseLocationPermissionGranted", "getCoarseLocationPermissionGranted$m2sdk_release", "setCoarseLocationPermissionGranted$m2sdk_release", "backgroundLocationPermissionGranted", "getBackgroundLocationPermissionGranted$m2sdk_release", "setBackgroundLocationPermissionGranted$m2sdk_release", "readPhoneStatePermissionGranted", "getReadPhoneStatePermissionGranted$m2sdk_release", "setReadPhoneStatePermissionGranted$m2sdk_release", "packageUsageStatsPermissionGranted", "getPackageUsageStatsPermissionGranted$m2sdk_release", "setPackageUsageStatsPermissionGranted$m2sdk_release", "Lcom/m2catalyst/m2sdk/q;", "cellInfoStrategyManager$delegate", "Lkotlin/Lazy;", "getCellInfoStrategyManager", "()Lcom/m2catalyst/m2sdk/q;", "cellInfoStrategyManager", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;", "throughPutConfigUtil$delegate", "getThroughPutConfigUtil", "()Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;", "throughPutConfigUtil", "Lcom/m2catalyst/m2sdk/testing/business/DataQualityValidator;", "dataQualityValidator", "Lcom/m2catalyst/m2sdk/testing/business/DataQualityValidator;", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "value", "m2Location", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "getM2Location$m2sdk_release", "()Lcom/m2catalyst/m2sdk/business/models/M2Location;", "setM2Location$m2sdk_release", "(Lcom/m2catalyst/m2sdk/business/models/M2Location;)V", "m2LocationLiveData", "Landroidx/lifecycle/MutableLiveData;", "getM2LocationLiveData$m2sdk_release", "()Landroidx/lifecycle/MutableLiveData;", "sim1", "Ljava/util/List;", "getSim1$m2sdk_release", "()Ljava/util/List;", "setSim1$m2sdk_release", "(Ljava/util/List;)V", "sim1LiveData", "getSim1LiveData$m2sdk_release", "sim2", "getSim2$m2sdk_release", "setSim2$m2sdk_release", "sim2LiveData", "getSim2LiveData$m2sdk_release", "rawMNSI", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "getRawMNSI", "()Lcom/m2catalyst/m2sdk/business/models/MNSI;", "setRawMNSI", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", "rawMNSILiveData", "getRawMNSILiveData", "completeMNSI", "getCompleteMNSI", "setCompleteMNSI", "completeMNSILiveData", "getCompleteMNSILiveData", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "completeWifi", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "getCompleteWifi$m2sdk_release", "()Lcom/m2catalyst/m2sdk/business/models/Wifi;", "setCompleteWifi$m2sdk_release", "(Lcom/m2catalyst/m2sdk/business/models/Wifi;)V", "completeWifiLiveData", "getCompleteWifiLiveData$m2sdk_release", "wifiConnected", "Ljava/lang/Boolean;", "getWifiConnected$m2sdk_release", "setWifiConnected$m2sdk_release", "(Ljava/lang/Boolean;)V", "wifiConnectedLiveData", "getWifiConnectedLiveData$m2sdk_release", "<init>", "()V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: SDKState.kt */
public final class SDKState implements DataAvailability.SDKStateAvailability {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static SDKState _instance;
    private final l2 accessComponent;
    private boolean backgroundLocationPermissionGranted;
    private final Lazy cellInfoStrategyManager$delegate;
    private boolean coarseLocationPermissionGranted;
    private MNSI completeMNSI;
    private final MutableLiveData<MNSI> completeMNSILiveData;
    private Wifi completeWifi;
    private final MutableLiveData<Wifi> completeWifiLiveData;
    private final DataQualityValidator dataQualityValidator;
    private boolean fineLocationPermissionGranted;
    private M2Location m2Location;
    private final MutableLiveData<M2Location> m2LocationLiveData;
    private boolean packageUsageStatsPermissionGranted;
    private MNSI rawMNSI;
    private final MutableLiveData<MNSI> rawMNSILiveData;
    private boolean readPhoneStatePermissionGranted;
    private List<String> sim1;
    private final MutableLiveData<List<String>> sim1LiveData;
    private List<String> sim2;
    private final MutableLiveData<List<String>> sim2LiveData;
    private final Lazy throughPutConfigUtil$delegate;
    private Boolean wifiConnected;
    private final MutableLiveData<Boolean> wifiConnectedLiveData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/m2catalyst/m2sdk/external/SDKState$Companion;", "", "()V", "_instance", "Lcom/m2catalyst/m2sdk/external/SDKState;", "get_instance", "()Lcom/m2catalyst/m2sdk/external/SDKState;", "set_instance", "(Lcom/m2catalyst/m2sdk/external/SDKState;)V", "getInstance", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SDKState.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SDKState getInstance() {
            if (get_instance() == null) {
                set_instance(new SDKState((DefaultConstructorMarker) null));
            }
            SDKState sDKState = get_instance();
            Intrinsics.checkNotNull(sDKState);
            return sDKState;
        }

        public final SDKState get_instance() {
            return SDKState._instance;
        }

        public final void set_instance(SDKState sDKState) {
            SDKState._instance = sDKState;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SDKState() {
        /*
            r3 = this;
            r3.<init>()
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r0 = r0.c()
            r1 = 0
            if (r0 == 0) goto L_0x0019
            com.m2catalyst.m2sdk.n2 r0 = r0.getDataAccess()
            if (r0 == 0) goto L_0x0019
            com.m2catalyst.m2sdk.l2 r0 = r0.e()
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            r3.accessComponent = r0
            java.lang.Class<com.m2catalyst.m2sdk.q> r0 = com.m2catalyst.m2sdk.q.class
            r2 = 6
            kotlin.Lazy r0 = org.koin.java.KoinJavaComponent.inject$default(r0, r1, r1, r2, r1)
            r3.cellInfoStrategyManager$delegate = r0
            java.lang.Class<com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil> r0 = com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.class
            kotlin.Lazy r0 = org.koin.java.KoinJavaComponent.inject$default(r0, r1, r1, r2, r1)
            r3.throughPutConfigUtil$delegate = r0
            com.m2catalyst.m2sdk.testing.business.DataQualityValidator r0 = new com.m2catalyst.m2sdk.testing.business.DataQualityValidator
            com.m2catalyst.m2sdk.q r1 = r3.getCellInfoStrategyManager()
            r0.<init>(r1)
            r3.dataQualityValidator = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.m2LocationLiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.sim1LiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.sim2LiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.rawMNSILiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.completeMNSILiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.completeWifiLiveData = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r3.wifiConnectedLiveData = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.external.SDKState.<init>():void");
    }

    public /* synthetic */ SDKState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final q getCellInfoStrategyManager() {
        return (q) this.cellInfoStrategyManager$delegate.getValue();
    }

    private final ThroughputConfigUtil getThroughPutConfigUtil() {
        return (ThroughputConfigUtil) this.throughPutConfigUtil$delegate.getValue();
    }

    @w2
    public Boolean getBackgroundLocationPermissionGranted() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getBackgroundLocationPermissionGranted$1(this), this.accessComponent)) {
            return Boolean.valueOf(this.backgroundLocationPermissionGranted);
        }
        return null;
    }

    public final boolean getBackgroundLocationPermissionGranted$m2sdk_release() {
        return this.backgroundLocationPermissionGranted;
    }

    @w2
    public MutableLiveData<List<String>> getCellLogBySimLiveData(int i) {
        if (!M2SDK.INSTANCE.isAccessible(new SDKState$getCellLogBySimLiveData$1(this), this.accessComponent)) {
            return null;
        }
        if (i == 1) {
            return this.sim2LiveData;
        }
        return this.sim1LiveData;
    }

    @w2
    public Boolean getCoarseLocationPermissionGranted() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getCoarseLocationPermissionGranted$1(this), this.accessComponent)) {
            return Boolean.valueOf(this.coarseLocationPermissionGranted);
        }
        return null;
    }

    public final boolean getCoarseLocationPermissionGranted$m2sdk_release() {
        return this.coarseLocationPermissionGranted;
    }

    public final MNSI getCompleteMNSI() {
        return this.completeMNSI;
    }

    public final MutableLiveData<MNSI> getCompleteMNSILiveData() {
        return this.completeMNSILiveData;
    }

    public final Wifi getCompleteWifi$m2sdk_release() {
        return this.completeWifi;
    }

    public final MutableLiveData<Wifi> getCompleteWifiLiveData$m2sdk_release() {
        return this.completeWifiLiveData;
    }

    @w2
    public DiagnosticsResults getCurrentNDTTest() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getCurrentNDTTest$1(this), this.accessComponent)) {
            return getThroughPutConfigUtil().getCurrentTestObject();
        }
        return null;
    }

    @w2
    public Boolean getFineLocationPermissionGranted() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getFineLocationPermissionGranted$1(this), this.accessComponent)) {
            return Boolean.valueOf(this.fineLocationPermissionGranted);
        }
        return null;
    }

    public final boolean getFineLocationPermissionGranted$m2sdk_release() {
        return this.fineLocationPermissionGranted;
    }

    @w2
    public TestBaseEvent getLastNDTEvent() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getLastNDTEvent$1(this), this.accessComponent)) {
            return getThroughPutConfigUtil().getLastEvent();
        }
        return null;
    }

    public final M2Location getM2Location$m2sdk_release() {
        return this.m2Location;
    }

    public final MutableLiveData<M2Location> getM2LocationLiveData$m2sdk_release() {
        return this.m2LocationLiveData;
    }

    public final t4 getMNSIReport$m2sdk_release(List<? extends MNSI> list) {
        Intrinsics.checkNotNullParameter(list, "mnsis");
        return this.dataQualityValidator.validateMNSICollectionAndGetReport(list);
    }

    @w2
    public Boolean getPackageUsageStatsPermissionGranted() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getPackageUsageStatsPermissionGranted$1(this), this.accessComponent)) {
            return Boolean.valueOf(this.packageUsageStatsPermissionGranted);
        }
        return null;
    }

    public final boolean getPackageUsageStatsPermissionGranted$m2sdk_release() {
        return this.packageUsageStatsPermissionGranted;
    }

    public final MNSI getRawMNSI() {
        return this.rawMNSI;
    }

    public final MutableLiveData<MNSI> getRawMNSILiveData() {
        return this.rawMNSILiveData;
    }

    @w2
    public Boolean getReadPhoneStatePermissionGranted() {
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getReadPhoneStatePermissionGranted$1(this), this.accessComponent)) {
            return Boolean.valueOf(this.readPhoneStatePermissionGranted);
        }
        return null;
    }

    public final boolean getReadPhoneStatePermissionGranted$m2sdk_release() {
        return this.readPhoneStatePermissionGranted;
    }

    @w2
    public t4 getReportOnMNSIList(List<? extends MNSI> list) {
        Intrinsics.checkNotNullParameter(list, "mnsis");
        if (M2SDK.INSTANCE.isAccessible(new SDKState$getReportOnMNSIList$1(this), this.accessComponent)) {
            return this.dataQualityValidator.validateMNSICollectionAndGetReport(list);
        }
        return null;
    }

    public final List<String> getSim1$m2sdk_release() {
        return this.sim1;
    }

    public final MutableLiveData<List<String>> getSim1LiveData$m2sdk_release() {
        return this.sim1LiveData;
    }

    public final List<String> getSim2$m2sdk_release() {
        return this.sim2;
    }

    public final MutableLiveData<List<String>> getSim2LiveData$m2sdk_release() {
        return this.sim2LiveData;
    }

    public final Boolean getWifiConnected$m2sdk_release() {
        return this.wifiConnected;
    }

    public final MutableLiveData<Boolean> getWifiConnectedLiveData$m2sdk_release() {
        return this.wifiConnectedLiveData;
    }

    public final void setBackgroundLocationPermissionGranted$m2sdk_release(boolean z) {
        this.backgroundLocationPermissionGranted = z;
    }

    public final void setCoarseLocationPermissionGranted$m2sdk_release(boolean z) {
        this.coarseLocationPermissionGranted = z;
    }

    public final void setCompleteMNSI(MNSI mnsi) {
        this.completeMNSI = mnsi;
        this.completeMNSILiveData.postValue(mnsi);
    }

    public final void setCompleteWifi$m2sdk_release(Wifi wifi) {
        this.completeWifi = wifi;
        this.completeWifiLiveData.postValue(wifi);
    }

    public final void setFineLocationPermissionGranted$m2sdk_release(boolean z) {
        this.fineLocationPermissionGranted = z;
    }

    public final void setM2Location$m2sdk_release(M2Location m2Location2) {
        this.m2Location = m2Location2;
        this.m2LocationLiveData.postValue(m2Location2);
    }

    public final void setPackageUsageStatsPermissionGranted$m2sdk_release(boolean z) {
        this.packageUsageStatsPermissionGranted = z;
    }

    public final void setRawMNSI(MNSI mnsi) {
        this.rawMNSI = mnsi;
        this.rawMNSILiveData.postValue(mnsi);
    }

    public final void setReadPhoneStatePermissionGranted$m2sdk_release(boolean z) {
        this.readPhoneStatePermissionGranted = z;
    }

    public final void setSim1$m2sdk_release(List<String> list) {
        this.sim1 = list;
        this.sim1LiveData.postValue(list);
    }

    public final void setSim2$m2sdk_release(List<String> list) {
        this.sim2 = list;
        this.sim2LiveData.postValue(list);
    }

    public final void setWifiConnected$m2sdk_release(Boolean bool) {
        this.wifiConnected = bool;
        this.wifiConnectedLiveData.postValue(bool);
    }

    public final void sim$m2sdk_release(List<String> list, Context context, int i) {
        int i2;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(list, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList b = m6.b(context);
        Intrinsics.checkNotNull(b);
        Iterator it = b.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SubInfo) obj).getId() == i) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        SubInfo subInfo = (SubInfo) obj;
        if (subInfo != null) {
            i2 = subInfo.getSimSlot();
        }
        if (i2 == 0) {
            setSim1$m2sdk_release(list);
        } else {
            setSim2$m2sdk_release(list);
        }
    }
}
