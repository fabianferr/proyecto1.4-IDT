package com.m2catalyst.m2sdk.speed_test;

import android.content.Context;
import android.net.Network;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.m4;
import com.m2catalyst.m2sdk.o1;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig;
import com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J%\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/SpeedTestManager;", "", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestConfiguration;", "configuration", "", "setup", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsi", "", "force", "shouldAttemptRunAutomaticSpeedTest", "lastSavedMNSI", "runAutomaticTest", "runManualTestForTestingUse", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;Lcom/m2catalyst/m2sdk/business/models/MNSI;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;", "throughputConfigUtil", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;", "Lcom/m2catalyst/m2sdk/r2;", "Lcom/m2catalyst/m2sdk/r2;", "Landroid/net/Network;", "network", "Landroid/net/Network;", "getNetwork", "()Landroid/net/Network;", "setNetwork", "(Landroid/net/Network;)V", "", "lastSpeedTestCheck", "J", "getLastSpeedTestCheck", "()J", "setLastSpeedTestCheck", "(J)V", "speedTestConfig", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestConfiguration;", "<init>", "(Landroid/content/Context;Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;)V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: SpeedTestManager.kt */
public final class SpeedTestManager {
    private final r2 configuration = r2.a.a();
    /* access modifiers changed from: private */
    public final Context context;
    private long lastSpeedTestCheck;
    private Network network;
    private SpeedTestConfiguration speedTestConfig;
    /* access modifiers changed from: private */
    public final ThroughputConfigUtil throughputConfigUtil;

    public SpeedTestManager(Context context2, ThroughputConfigUtil throughputConfigUtil2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(throughputConfigUtil2, "throughputConfigUtil");
        this.context = context2;
        this.throughputConfigUtil = throughputConfigUtil2;
    }

    public static /* synthetic */ boolean shouldAttemptRunAutomaticSpeedTest$default(SpeedTestManager speedTestManager, MNSI mnsi, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return speedTestManager.shouldAttemptRunAutomaticSpeedTest(mnsi, z);
    }

    public final long getLastSpeedTestCheck() {
        return this.lastSpeedTestCheck;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final void runAutomaticTest(MNSI mnsi, MNSI mnsi2) {
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        this.lastSpeedTestCheck = System.currentTimeMillis();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig = new NetworkDiagnosticTestConfig(ThroughputConfigUtil.DEFAULT_TOTAL_DATA_SIZE, 3, 3);
        String locationProvider = mnsi.getLocationProvider();
        Intrinsics.checkNotNull(locationProvider);
        M2Location m2Location = new M2Location(locationProvider);
        m2Location.setAccuracy(mnsi.getAccuracy());
        Double latitude = mnsi.getLatitude();
        Intrinsics.checkNotNull(latitude);
        m2Location.setLatitude(latitude.doubleValue());
        Double longitude = mnsi.getLongitude();
        Intrinsics.checkNotNull(longitude);
        m2Location.setLongitude(longitude.doubleValue());
        j3.b(new SpeedTestManager$runAutomaticTest$1(this, networkDiagnosticTestConfig, mnsi, m2Location, mnsi2, (Continuation<? super SpeedTestManager$runAutomaticTest$1>) null));
    }

    public final Object runManualTestForTestingUse(MNSI mnsi, MNSI mnsi2, Continuation<? super Unit> continuation) {
        this.lastSpeedTestCheck = System.currentTimeMillis();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig = new NetworkDiagnosticTestConfig(1, 0, ThroughputConfigUtil.DEFAULT_TOTAL_DATA_SIZE, Boxing.boxInt(4), Boxing.boxInt(4));
        String locationProvider = mnsi.getLocationProvider();
        Intrinsics.checkNotNull(locationProvider);
        M2Location m2Location = new M2Location(locationProvider);
        m2Location.setAccuracy(mnsi.getAccuracy());
        Double latitude = mnsi.getLatitude();
        Intrinsics.checkNotNull(latitude);
        m2Location.setLatitude(latitude.doubleValue());
        Double longitude = mnsi.getLongitude();
        Intrinsics.checkNotNull(longitude);
        m2Location.setLongitude(longitude.doubleValue());
        Object initiateTest = this.throughputConfigUtil.initiateTest(networkDiagnosticTestConfig, mnsi, m2Location, m4.a(this.context), mnsi2, continuation);
        return initiateTest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? initiateTest : Unit.INSTANCE;
    }

    public final void setLastSpeedTestCheck(long j) {
        this.lastSpeedTestCheck = j;
    }

    public final void setNetwork(Network network2) {
        this.network = network2;
    }

    public final void setup(SpeedTestConfiguration speedTestConfiguration) {
        Intrinsics.checkNotNullParameter(speedTestConfiguration, "configuration");
        this.speedTestConfig = speedTestConfiguration;
    }

    public final boolean shouldAttemptRunAutomaticSpeedTest(MNSI mnsi, boolean z) {
        Integer isDataDefaultSim;
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        if (NetworkDiagnosticTools.getInstance().isTestRunning() || (isDataDefaultSim = mnsi.isDataDefaultSim()) == null || isDataDefaultSim.intValue() != 1 || mnsi.getVoiceNetworkType() != mnsi.getDataNetworkType()) {
            return false;
        }
        if (System.currentTimeMillis() - this.lastSpeedTestCheck <= o1.b(5)) {
            M2Configuration m2Configuration = this.configuration.g;
            if (!(m2Configuration != null ? m2Configuration.isDebug() : false) && !z) {
                return false;
            }
        }
        if (!this.throughputConfigUtil.getNdt().isTestRunning()) {
            return true;
        }
        return false;
    }
}
