package com.umlaut.crowd.database.metrics;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.internal.DRI;
import com.umlaut.crowd.internal.DWI;
import com.umlaut.crowd.internal.ee;
import com.umlaut.crowd.internal.l7;
import com.umlaut.crowd.internal.l9;
import com.umlaut.crowd.internal.q4;

public class SignalStrengthLocationShare {
    public int accuracy = -1;
    public int bad = 0;
    public int excellent = 0;
    public int fair = 0;
    public int good = 0;
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public int poor = 0;
    public String technology = "";
    public String technologyId = "";
    public String technologyType = "";
    public long total = 0;
    public int unknown = 0;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.l9[] r0 = com.umlaut.crowd.internal.l9.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Bad     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Excellent     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Fair     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Good     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Poor     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Unknown     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.metrics.SignalStrengthLocationShare.a.<clinit>():void");
        }
    }

    public static SignalStrengthLocationShare a(ConnectionTypes connectionTypes, q4 q4Var, DRI dri, DWI dwi) {
        l9 l9Var;
        String str;
        if (!(q4Var.LocationLatitude == 0.0d || q4Var.LocationLongitude == 0.0d)) {
            SignalStrengthLocationShare signalStrengthLocationShare = new SignalStrengthLocationShare();
            signalStrengthLocationShare.latitude = q4Var.LocationLatitude;
            signalStrengthLocationShare.longitude = q4Var.LocationLongitude;
            signalStrengthLocationShare.accuracy = (int) q4Var.LocationAccuracyHorizontal;
            signalStrengthLocationShare.total++;
            if (connectionTypes == ConnectionTypes.WiFi && dwi != null) {
                signalStrengthLocationShare.technology = NetworkTypes.WiFi.name();
                signalStrengthLocationShare.technologyId = !dwi.DefaultGatewayMacAddress.isEmpty() ? dwi.DefaultGatewayMacAddress : dwi.WifiBSSID;
                signalStrengthLocationShare.technologyType = dwi.WifiSSID;
                l9Var = ee.a(dwi);
            } else if (connectionTypes == ConnectionTypes.Mobile) {
                String name = l7.a(dri.NetworkType, dri.NrState, dri.DisplayNetworkType).name();
                if (name.startsWith("Gen5")) {
                    name = "Gen5";
                }
                signalStrengthLocationShare.technology = name;
                if (dri.NrCellId != -1) {
                    str = dri.NrCellId + "";
                } else {
                    str = dri.GsmCellId;
                }
                signalStrengthLocationShare.technologyId = str;
                signalStrengthLocationShare.technologyType = dri.OperatorName;
                l9Var = l7.b(dri);
            }
            int i = a.a[l9Var.ordinal()];
            if (i == 1) {
                signalStrengthLocationShare.bad++;
            } else if (i == 2) {
                signalStrengthLocationShare.excellent++;
            } else if (i == 3) {
                signalStrengthLocationShare.fair++;
            } else if (i == 4) {
                signalStrengthLocationShare.good++;
            } else if (i != 5) {
                signalStrengthLocationShare.unknown++;
            } else {
                signalStrengthLocationShare.poor++;
            }
            return signalStrengthLocationShare;
        }
        return null;
    }
}
