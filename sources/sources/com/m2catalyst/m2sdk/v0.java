package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.r2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* compiled from: ComponentManager.kt */
public final class v0 implements DataAvailability {
    public final LocationRepository a;
    public final MNSIRepository b;
    public final NoSignalMNSIRepository c;
    public final WifiRepository d;
    public final NDTRepository e;
    public final BadSignalsRepository f;
    public final DeviceRepository g;
    public final n2 h = r2.a.a().a(false).getDataAccess();
    public final SDKState i = SDKState.Companion.getInstance();

    public v0(LocationRepository locationRepository, MNSIRepository mNSIRepository, NoSignalMNSIRepository noSignalMNSIRepository, WifiRepository wifiRepository, NDTRepository nDTRepository, BadSignalsRepository badSignalsRepository, DeviceRepository deviceRepository) {
        Intrinsics.checkNotNullParameter(locationRepository, "locationRepository");
        Intrinsics.checkNotNullParameter(mNSIRepository, "mnsiRepository");
        Intrinsics.checkNotNullParameter(noSignalMNSIRepository, "noSignalMNSIRepository");
        Intrinsics.checkNotNullParameter(wifiRepository, "wifiRepository");
        Intrinsics.checkNotNullParameter(nDTRepository, "ndtRepository");
        Intrinsics.checkNotNullParameter(badSignalsRepository, "badSignalRepository");
        Intrinsics.checkNotNullParameter(deviceRepository, "deviceRepository");
        this.a = locationRepository;
        this.b = mNSIRepository;
        this.c = noSignalMNSIRepository;
        this.d = wifiRepository;
        this.e = nDTRepository;
        this.f = badSignalsRepository;
        this.g = deviceRepository;
    }

    public static boolean a(l2 l2Var) {
        if (l2Var != null) {
            Boolean bool = l2Var.a;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual((Object) bool, (Object) bool2) || Intrinsics.areEqual((Object) l2Var.b, (Object) bool2)) {
                return true;
            }
        }
        return false;
    }

    public final DataAvailability.BadSignalAvailability getBadSignalsData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.d : null)) {
            return this.f;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Bad signals Component", "Bad signals Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.ConfigurationAvailability getConfiguration() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.a : null)) {
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            return r2Var;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Configuration Component", "Configuration Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.DeviceInfoAvailability getDeviceInfoData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.h : null)) {
            return this.g;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Device Info Component", "Device Info Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.LocationDataAvailability getLocationData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.f : null)) {
            return this.a;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Location Component", "Location Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.NetworkDiagnosticsAvailability getNetworkDiagnosticsData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.e : null)) {
            return this.e;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Speed test Component", "Speed test Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.NoSignalAvailability getNoSignalData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.c : null)) {
            return this.c;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "No signal Component", "No signal Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.RFNetworkDataAvailability getRFNetworkData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.g : null)) {
            return this.b;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "RF Component", "RF Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.SDKStateAvailability getSDKState() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.i : null)) {
            return this.i;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "SDK State Component", "SDK State Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final DataAvailability.WifiAvailability getWifiData() {
        n2 n2Var = this.h;
        if (a(n2Var != null ? n2Var.b : null)) {
            return this.d;
        }
        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Wifi Component", "Wifi Component cannot be access, please contact the admin for permission", (Exception) null, false, 12, (Object) null);
        return null;
    }

    public final boolean isAccessible(KFunction<?> kFunction, l2 l2Var) {
        return DataAvailability.DefaultImpls.isAccessible(this, kFunction, l2Var);
    }
}
