package com.m2catalyst.m2sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetworkUtils.kt */
public final class m4 {
    public static final M2SDKLogger a = M2SDKLogger.Companion.getLogger("MNSI");

    public static final String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "failed to find phoneType" : "SIP" : "CDMA" : "GSM" : "NONE";
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0119 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int b(java.lang.String r1) {
        /*
            if (r1 != 0) goto L_0x0004
            java.lang.String r1 = ""
        L_0x0004:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toUpperCase(r0)
            java.lang.String r0 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -908593671: goto L_0x010d;
                case 2500: goto L_0x0101;
                case 70881: goto L_0x00f5;
                case 75709: goto L_0x00e9;
                case 2063797: goto L_0x00de;
                case 2123197: goto L_0x00d3;
                case 2194666: goto L_0x00c8;
                case 2227260: goto L_0x00bc;
                case 2242308: goto L_0x00ae;
                case 2608919: goto L_0x00a1;
                case 47955627: goto L_0x0094;
                case 65949251: goto L_0x0086;
                case 69034058: goto L_0x0078;
                case 69045140: goto L_0x006a;
                case 69050395: goto L_0x005c;
                case 70083979: goto L_0x004e;
                case 433141802: goto L_0x0041;
                case 2056938925: goto L_0x0034;
                case 2056938942: goto L_0x0027;
                case 2056938943: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0119
        L_0x0019:
            java.lang.String r0 = "EVDO_B"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0023
            goto L_0x0119
        L_0x0023:
            r1 = 12
            goto L_0x011a
        L_0x0027:
            java.lang.String r0 = "EVDO_A"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0031
            goto L_0x0119
        L_0x0031:
            r1 = 6
            goto L_0x011a
        L_0x0034:
            java.lang.String r0 = "EVDO_0"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x003e
            goto L_0x0119
        L_0x003e:
            r1 = 5
            goto L_0x011a
        L_0x0041:
            java.lang.String r0 = "UNKNOWN"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x004b
            goto L_0x0119
        L_0x004b:
            r1 = 0
            goto L_0x011a
        L_0x004e:
            java.lang.String r0 = "IWLAN"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            goto L_0x0119
        L_0x0058:
            r1 = 18
            goto L_0x011a
        L_0x005c:
            java.lang.String r0 = "HSUPA"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0066
            goto L_0x0119
        L_0x0066:
            r1 = 9
            goto L_0x011a
        L_0x006a:
            java.lang.String r0 = "HSPAP"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0074
            goto L_0x0119
        L_0x0074:
            r1 = 15
            goto L_0x011a
        L_0x0078:
            java.lang.String r0 = "HSDPA"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0082
            goto L_0x0119
        L_0x0082:
            r1 = 8
            goto L_0x011a
        L_0x0086:
            java.lang.String r0 = "EHRPD"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0090
            goto L_0x0119
        L_0x0090:
            r1 = 14
            goto L_0x011a
        L_0x0094:
            java.lang.String r0 = "1XRTT"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x009e
            goto L_0x0119
        L_0x009e:
            r1 = 7
            goto L_0x011a
        L_0x00a1:
            java.lang.String r0 = "UMTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00ab
            goto L_0x0119
        L_0x00ab:
            r1 = 3
            goto L_0x011a
        L_0x00ae:
            java.lang.String r0 = "IDEN"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00b8
            goto L_0x0119
        L_0x00b8:
            r1 = 11
            goto L_0x011a
        L_0x00bc:
            java.lang.String r0 = "HSPA"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00c5
            goto L_0x0119
        L_0x00c5:
            r1 = 10
            goto L_0x011a
        L_0x00c8:
            java.lang.String r0 = "GPRS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00d1
            goto L_0x0119
        L_0x00d1:
            r1 = 1
            goto L_0x011a
        L_0x00d3:
            java.lang.String r0 = "EDGE"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00dc
            goto L_0x0119
        L_0x00dc:
            r1 = 2
            goto L_0x011a
        L_0x00de:
            java.lang.String r0 = "CDMA"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00e7
            goto L_0x0119
        L_0x00e7:
            r1 = 4
            goto L_0x011a
        L_0x00e9:
            java.lang.String r0 = "LTE"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00f2
            goto L_0x0119
        L_0x00f2:
            r1 = 13
            goto L_0x011a
        L_0x00f5:
            java.lang.String r0 = "GSM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00fe
            goto L_0x0119
        L_0x00fe:
            r1 = 16
            goto L_0x011a
        L_0x0101:
            java.lang.String r0 = "NR"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x010a
            goto L_0x0119
        L_0x010a:
            r1 = 20
            goto L_0x011a
        L_0x010d:
            java.lang.String r0 = "TD_SCDMA"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0116
            goto L_0x0119
        L_0x0116:
            r1 = 17
            goto L_0x011a
        L_0x0119:
            r1 = -1
        L_0x011a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.m4.b(java.lang.String):int");
    }

    public static final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Intrinsics.checkNotNullParameter(context, "<this>");
        n4 n4Var = new n4(context);
        Object obj = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(n4Var, "block");
        try {
            obj = n4Var.invoke();
        } catch (Exception unused) {
        }
        Boolean bool = (Boolean) obj;
        NetworkInfo networkInfo = bool != null ? bool.booleanValue() : false ? connectivityManager.getNetworkInfo(1) : null;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static final int d(ServiceState serviceState) {
        int i;
        int a2;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(serviceState, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            List networkRegistrationInfoList = serviceState.getNetworkRegistrationInfoList();
            Intrinsics.checkNotNullExpressionValue(networkRegistrationInfoList, "this.networkRegistrationInfoList");
            Iterator it = networkRegistrationInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                NetworkRegistrationInfo networkRegistrationInfo = (NetworkRegistrationInfo) obj;
                if (!networkRegistrationInfo.isRegistered() || !networkRegistrationInfo.getAvailableServices().contains(1)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            NetworkRegistrationInfo networkRegistrationInfo2 = (NetworkRegistrationInfo) obj;
            if (networkRegistrationInfo2 != null) {
                return networkRegistrationInfo2.getAccessNetworkTechnology();
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Intrinsics.checkNotNullParameter(serviceState, "<this>");
            String serviceState2 = serviceState.toString();
            Intrinsics.checkNotNullExpressionValue(serviceState2, "it.toString()");
            int indexOf = StringsKt.indexOf((CharSequence) serviceState2, "RilVoiceRadioTechnology=", 0, false);
            int indexOf2 = StringsKt.indexOf((CharSequence) serviceState2, "(", indexOf, false);
            int indexOf3 = StringsKt.indexOf((CharSequence) serviceState2, ")", indexOf, false);
            if (indexOf2 > 0 && indexOf3 > 0 && (a2 = a(serviceState2.subSequence(indexOf2 + 1, indexOf3).toString())) != Integer.MIN_VALUE) {
                return a2;
            }
            if (indexOf < 0) {
                return Integer.MIN_VALUE;
            }
            CharSequence subSequence = serviceState2.subSequence(indexOf + 24, indexOf + 26);
            Intrinsics.checkNotNullParameter(subSequence, "<this>");
            Integer intOrNull = StringsKt.toIntOrNull(subSequence.toString());
            if (intOrNull != null) {
                i = intOrNull.intValue();
            } else {
                Integer intOrNull2 = StringsKt.toIntOrNull(String.valueOf(subSequence.charAt(0)));
                i = intOrNull2 != null ? intOrNull2.intValue() : Integer.MIN_VALUE;
            }
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            return Integer.MIN_VALUE;
        }
        Intrinsics.checkNotNullParameter(serviceState, "<this>");
        Pair<String, String> c = c(serviceState);
        if (c == null) {
            return Integer.MIN_VALUE;
        }
        return b(c.getSecond());
    }

    public static final boolean e(ServiceState serviceState) {
        int i;
        List networkRegistrationInfoList;
        Object obj;
        boolean z;
        CellIdentity cellIdentity = null;
        if (!(serviceState == null || (networkRegistrationInfoList = serviceState.getNetworkRegistrationInfoList()) == null)) {
            Iterator it = networkRegistrationInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                NetworkRegistrationInfo networkRegistrationInfo = (NetworkRegistrationInfo) obj;
                if (!networkRegistrationInfo.isRegistered() || networkRegistrationInfo.getCellIdentity() == null) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            NetworkRegistrationInfo networkRegistrationInfo2 = (NetworkRegistrationInfo) obj;
            if (networkRegistrationInfo2 != null) {
                cellIdentity = networkRegistrationInfo2.getCellIdentity();
            }
        }
        if (cellIdentity == null) {
            return false;
        }
        if (cellIdentity instanceof CellIdentityCdma) {
            return true;
        }
        if (!(cellIdentity instanceof CellIdentityGsm) && !(cellIdentity instanceof CellIdentityLte) && (((i = Build.VERSION.SDK_INT) < 29 || !(cellIdentity instanceof CellIdentityNr)) && (i < 29 || !(cellIdentity instanceof CellIdentityTdscdma)))) {
            boolean z2 = cellIdentity instanceof CellIdentityWcdma;
        }
        return false;
    }

    public static final NetworkInfo b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return ((ConnectivityManager) systemService).getNetworkInfo(0);
    }

    public static final Integer b(CellIdentityLte cellIdentityLte) {
        Intrinsics.checkNotNullParameter(cellIdentityLte, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            return Integer.valueOf(cellIdentityLte.getBandwidth());
        }
        String cellIdentityLte2 = cellIdentityLte.toString();
        Intrinsics.checkNotNullExpressionValue(cellIdentityLte2, "it.toString()");
        int indexOf = StringsKt.indexOf((CharSequence) cellIdentityLte2, "mBandwidth", 0, false);
        int indexOf2 = StringsKt.indexOf((CharSequence) cellIdentityLte2, "=", indexOf, false);
        int indexOf3 = StringsKt.indexOf((CharSequence) cellIdentityLte2, " ", indexOf, false);
        if (indexOf2 <= 0 || indexOf3 <= 0) {
            return null;
        }
        try {
            return StringsKt.toIntOrNull(cellIdentityLte2.subSequence(indexOf2 + 1, indexOf3).toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Long a(c3 c3Var) {
        Intrinsics.checkNotNullParameter(c3Var, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            return Long.valueOf(c3Var.o);
        }
        return Long.valueOf(c3Var.m);
    }

    public static final M2SDKLogger a() {
        return a;
    }

    public static final boolean a(CellInfo cellInfo, CellIdentity cellIdentity) {
        if (cellInfo == null || cellIdentity == null) {
            return false;
        }
        CellIdentity cellIdentity2 = cellInfo.getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(cellIdentity2, "cellInfo.cellIdentity");
        if ((cellIdentity2 instanceof CellIdentityCdma) && (cellIdentity instanceof CellIdentityCdma)) {
            CellIdentityCdma cellIdentityCdma = (CellIdentityCdma) cellIdentity2;
            CellIdentityCdma cellIdentityCdma2 = (CellIdentityCdma) cellIdentity;
            if (!(cellIdentityCdma.getBasestationId() == cellIdentityCdma2.getBasestationId() && cellIdentityCdma.getNetworkId() == cellIdentityCdma2.getNetworkId() && cellIdentityCdma.getSystemId() == cellIdentityCdma2.getSystemId())) {
                return false;
            }
        } else if ((cellIdentity2 instanceof CellIdentityGsm) && (cellIdentity instanceof CellIdentityGsm)) {
            CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) cellIdentity2;
            CellIdentityGsm cellIdentityGsm2 = (CellIdentityGsm) cellIdentity;
            if (!(cellIdentityGsm.getCid() == cellIdentityGsm2.getCid() && cellIdentityGsm.getMcc() == cellIdentityGsm2.getMcc() && cellIdentityGsm.getMnc() == cellIdentityGsm2.getMnc())) {
                return false;
            }
        } else if ((cellIdentity2 instanceof CellIdentityLte) && (cellIdentity instanceof CellIdentityLte)) {
            CellIdentityLte cellIdentityLte = (CellIdentityLte) cellIdentity2;
            CellIdentityLte cellIdentityLte2 = (CellIdentityLte) cellIdentity;
            if (!(cellIdentityLte.getCi() == cellIdentityLte2.getCi() && cellIdentityLte.getMcc() == cellIdentityLte2.getMcc() && cellIdentityLte.getMnc() == cellIdentityLte2.getMnc())) {
                return false;
            }
        } else if ((cellIdentity2 instanceof CellIdentityNr) && (cellIdentity instanceof CellIdentityNr)) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity2;
            CellIdentityNr cellIdentityNr2 = (CellIdentityNr) cellIdentity;
            if (cellIdentityNr.getNci() != cellIdentityNr2.getNci() || !StringsKt.equals$default(cellIdentityNr.getMccString(), cellIdentityNr2.getMccString(), false, 2, (Object) null) || !StringsKt.equals$default(cellIdentityNr.getMncString(), cellIdentityNr2.getMncString(), false, 2, (Object) null)) {
                return false;
            }
        } else if (!(cellIdentity2 instanceof CellIdentityWcdma) || !(cellIdentity instanceof CellIdentityWcdma)) {
            return false;
        } else {
            CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) cellIdentity2;
            CellIdentityWcdma cellIdentityWcdma2 = (CellIdentityWcdma) cellIdentity;
            if (!(cellIdentityWcdma.getCid() == cellIdentityWcdma2.getCid() && cellIdentityWcdma.getMcc() == cellIdentityWcdma2.getMcc() && cellIdentityWcdma.getMnc() == cellIdentityWcdma2.getMnc())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.lang.String, java.lang.String> b(android.telephony.ServiceState r8) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0046
            java.util.List r3 = r8.getNetworkRegistrationInfoList()
            if (r3 == 0) goto L_0x0046
            java.util.Iterator r3 = r3.iterator()
        L_0x000f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r3.next()
            r5 = r4
            android.telephony.NetworkRegistrationInfo r5 = (android.telephony.NetworkRegistrationInfo) r5
            boolean r6 = r5.isRegistered()
            if (r6 == 0) goto L_0x0038
            android.telephony.CellIdentity r6 = r5.getCellIdentity()
            if (r6 == 0) goto L_0x0038
            java.util.List r5 = r5.getAvailableServices()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x0038
            r5 = 1
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            if (r5 == 0) goto L_0x000f
            goto L_0x003d
        L_0x003c:
            r4 = r2
        L_0x003d:
            android.telephony.NetworkRegistrationInfo r4 = (android.telephony.NetworkRegistrationInfo) r4
            if (r4 == 0) goto L_0x0046
            android.telephony.CellIdentity r3 = r4.getCellIdentity()
            goto L_0x0047
        L_0x0046:
            r3 = r2
        L_0x0047:
            if (r3 == 0) goto L_0x004e
            kotlin.Pair r3 = a((android.telephony.CellIdentity) r3)
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x006c
            java.lang.Object r5 = r3.getFirst()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x006c
            java.lang.Object r5 = r3.getSecond()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x006c
            return r3
        L_0x006c:
            if (r8 == 0) goto L_0x00b0
            java.util.List r8 = r8.getNetworkRegistrationInfoList()
            if (r8 == 0) goto L_0x00b0
            java.util.Iterator r8 = r8.iterator()
        L_0x0078:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x00a6
            java.lang.Object r5 = r8.next()
            r6 = r5
            android.telephony.NetworkRegistrationInfo r6 = (android.telephony.NetworkRegistrationInfo) r6
            boolean r7 = r6.isRegistered()
            if (r7 == 0) goto L_0x00a2
            android.telephony.CellIdentity r7 = r6.getCellIdentity()
            if (r7 == 0) goto L_0x00a2
            java.util.List r6 = r6.getAvailableServices()
            r7 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x00a2
            r6 = 1
            goto L_0x00a3
        L_0x00a2:
            r6 = 0
        L_0x00a3:
            if (r6 == 0) goto L_0x0078
            goto L_0x00a7
        L_0x00a6:
            r5 = r2
        L_0x00a7:
            android.telephony.NetworkRegistrationInfo r5 = (android.telephony.NetworkRegistrationInfo) r5
            if (r5 == 0) goto L_0x00b0
            android.telephony.CellIdentity r8 = r5.getCellIdentity()
            goto L_0x00b1
        L_0x00b0:
            r8 = r2
        L_0x00b1:
            if (r8 == 0) goto L_0x00b7
            kotlin.Pair r3 = a((android.telephony.CellIdentity) r8)
        L_0x00b7:
            if (r3 == 0) goto L_0x00d2
            java.lang.Object r8 = r3.getFirst()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00d2
            java.lang.Object r8 = r3.getSecond()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00d2
            return r3
        L_0x00d2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.m4.b(android.telephony.ServiceState):kotlin.Pair");
    }

    public static final Network a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT > 22) {
                return connectivityManager.getActiveNetwork();
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(allNetworks, "cm.allNetworks");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                for (Network network : allNetworks) {
                    if (Intrinsics.areEqual((Object) activeNetworkInfo.toString(), (Object) String.valueOf(connectivityManager.getNetworkInfo(network)))) {
                        return network;
                    }
                }
            }
        }
        return null;
    }

    public static final TelephonyManager a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).createForSubscriptionId(i);
    }

    public static final int a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        switch (str.hashCode()) {
            case -908593671:
                return !str.equals("TD_SCDMA") ? Integer.MIN_VALUE : 17;
            case 2500:
                return !str.equals("NR") ? Integer.MIN_VALUE : 20;
            case 70881:
                return !str.equals("GSM") ? Integer.MIN_VALUE : 16;
            case 75709:
                return !str.equals("LTE") ? Integer.MIN_VALUE : 13;
            case 2063797:
                return !str.equals("CDMA") ? Integer.MIN_VALUE : 4;
            case 2123197:
                return !str.equals("EDGE") ? Integer.MIN_VALUE : 2;
            case 2194666:
                return !str.equals("GPRS") ? Integer.MIN_VALUE : 1;
            case 2227260:
                return !str.equals("HSPA") ? Integer.MIN_VALUE : 10;
            case 2242308:
                return !str.equals("IDEN") ? Integer.MIN_VALUE : 11;
            case 2608919:
                return !str.equals("UMTS") ? Integer.MIN_VALUE : 3;
            case 65949251:
                return !str.equals("EHRPD") ? Integer.MIN_VALUE : 14;
            case 69034058:
                return !str.equals("HSDPA") ? Integer.MIN_VALUE : 8;
            case 69045140:
                return !str.equals("HSPAP") ? Integer.MIN_VALUE : 15;
            case 69050395:
                return !str.equals("HSUPA") ? Integer.MIN_VALUE : 9;
            case 70083979:
                return !str.equals("IWLAN") ? Integer.MIN_VALUE : 18;
            case 433141802:
                return !str.equals("UNKNOWN") ? Integer.MIN_VALUE : 0;
            case 2056938925:
                return !str.equals("EVDO_0") ? Integer.MIN_VALUE : 5;
            case 2056938942:
                return !str.equals("EVDO_A") ? Integer.MIN_VALUE : 6;
            case 2056938943:
                return !str.equals("EVDO_B") ? Integer.MIN_VALUE : 12;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public static final int[] a(CellIdentityLte cellIdentityLte) {
        Intrinsics.checkNotNullParameter(cellIdentityLte, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            return cellIdentityLte.getBands();
        }
        String cellIdentityLte2 = cellIdentityLte.toString();
        Intrinsics.checkNotNullExpressionValue(cellIdentityLte2, "it.toString()");
        int indexOf = StringsKt.indexOf((CharSequence) cellIdentityLte2, "mBands=", 0, false);
        int indexOf2 = StringsKt.indexOf((CharSequence) cellIdentityLte2, "[", indexOf, false);
        int indexOf3 = StringsKt.indexOf((CharSequence) cellIdentityLte2, "]", indexOf, false);
        if (indexOf2 <= 0 || indexOf3 <= 0) {
            return null;
        }
        try {
            List<String> split$default = StringsKt.split$default((CharSequence) cellIdentityLte2.subSequence(indexOf2 + 1, indexOf3).toString(), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String parseInt : split$default) {
                arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return ArraysKt.toIntArray((Integer[]) array);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Pair<String, String> c(ServiceState serviceState) {
        int i;
        Intrinsics.checkNotNullParameter(serviceState, "<this>");
        String[] strArr = {"UNKNOWN", "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP", "GSM", "TD_SCDMA", "IWLAN", "NR"};
        String serviceState2 = serviceState.toString();
        Intrinsics.checkNotNullExpressionValue(serviceState2, "this.toString()");
        Pair pair = null;
        for (int i2 = 0; i2 < 20; i2++) {
            String str = strArr[i2];
            int indexOf = StringsKt.indexOf((CharSequence) serviceState2, str, 0, true);
            if (indexOf >= 0) {
                pair = new Pair(str, Integer.valueOf(indexOf));
            }
        }
        if (pair == null) {
            return null;
        }
        Pair pair2 = null;
        for (int i3 = 0; i3 < 20; i3++) {
            String str2 = strArr[i3];
            if (StringsKt.equals(str2, (String) pair.getFirst(), true)) {
                i = StringsKt.indexOf((CharSequence) serviceState2, str2, ((Number) pair.getSecond()).intValue() + 1, true);
            } else {
                i = StringsKt.indexOf((CharSequence) serviceState2, str2, 0, true);
            }
            if (i >= 0) {
                pair2 = new Pair(str2, Integer.valueOf(i));
            }
        }
        if (pair2 == null) {
            return null;
        }
        if (((Number) pair.getSecond()).intValue() < ((Number) pair2.getSecond()).intValue()) {
            return new Pair<>(pair.getFirst(), pair2.getFirst());
        }
        return new Pair<>(pair.getFirst(), pair2.getFirst());
    }

    public static final boolean a(ServiceState serviceState, String str) {
        Intrinsics.checkNotNullParameter(str, "cellIdentity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Intrinsics.checkNotNullParameter(str, "cellIdentity");
            if (serviceState == null) {
                return false;
            }
            String serviceState2 = serviceState.toString();
            Intrinsics.checkNotNullExpressionValue(serviceState2, "it.toString()");
            int i2 = 0;
            while (i2 != -1) {
                try {
                    int indexOf = StringsKt.indexOf((CharSequence) serviceState2, "NetworkRegistrationInfo{", i2, true);
                    if (indexOf == -1) {
                        return false;
                    }
                    i2 = StringsKt.indexOf((CharSequence) serviceState2, "registrationState=", indexOf, true);
                    CharSequence subSequence = serviceState2.subSequence(i2 + 18, i2 + 22);
                    if (i2 > 0 && StringsKt.equals(subSequence.toString(), "HOME", true)) {
                        int indexOf2 = StringsKt.indexOf((CharSequence) serviceState2, str, i2, true);
                        if (StringsKt.equals(serviceState2.subSequence(indexOf2, str.length() + indexOf2).toString(), str, true)) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        } else if (i == 28) {
            Intrinsics.checkNotNullParameter(str, "cellIdentity");
            if (serviceState == null) {
                return false;
            }
            String serviceState3 = serviceState.toString();
            Intrinsics.checkNotNullExpressionValue(serviceState3, "it.toString()");
            int i3 = 0;
            while (i3 != -1) {
                try {
                    int indexOf3 = StringsKt.indexOf((CharSequence) serviceState3, "NetworkRegistrationState{", i3, true);
                    if (indexOf3 == -1) {
                        return false;
                    }
                    i3 = StringsKt.indexOf((CharSequence) serviceState3, "regState=", indexOf3, true);
                    CharSequence subSequence2 = serviceState3.subSequence(i3 + 9, i3 + 13);
                    if (i3 > 0 && StringsKt.equals(subSequence2.toString(), "HOME", true)) {
                        int indexOf4 = StringsKt.indexOf((CharSequence) serviceState3, str, i3, true);
                        if (StringsKt.equals(serviceState3.subSequence(indexOf4, str.length() + indexOf4).toString(), str, true)) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static final int a(ServiceState serviceState) {
        int i;
        int a2;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(serviceState, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            List networkRegistrationInfoList = serviceState.getNetworkRegistrationInfoList();
            Intrinsics.checkNotNullExpressionValue(networkRegistrationInfoList, "this.networkRegistrationInfoList");
            Iterator it = networkRegistrationInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                NetworkRegistrationInfo networkRegistrationInfo = (NetworkRegistrationInfo) obj;
                if (!networkRegistrationInfo.isRegistered() || !networkRegistrationInfo.getAvailableServices().contains(2)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            NetworkRegistrationInfo networkRegistrationInfo2 = (NetworkRegistrationInfo) obj;
            if (networkRegistrationInfo2 != null) {
                return networkRegistrationInfo2.getAccessNetworkTechnology();
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Intrinsics.checkNotNullParameter(serviceState, "<this>");
            String serviceState2 = serviceState.toString();
            Intrinsics.checkNotNullExpressionValue(serviceState2, "it.toString()");
            int indexOf = StringsKt.indexOf((CharSequence) serviceState2, "RilDataRadioTechnology=", 0, false);
            int indexOf2 = StringsKt.indexOf((CharSequence) serviceState2, "(", indexOf, false);
            int indexOf3 = StringsKt.indexOf((CharSequence) serviceState2, ")", indexOf, false);
            if (indexOf2 > 0 && indexOf3 > 0 && (a2 = a(serviceState2.subSequence(indexOf2 + 1, indexOf3).toString())) != Integer.MIN_VALUE) {
                return a2;
            }
            if (indexOf < 0) {
                return Integer.MIN_VALUE;
            }
            CharSequence subSequence = serviceState2.subSequence(indexOf + 23, indexOf + 25);
            Intrinsics.checkNotNullParameter(subSequence, "<this>");
            Integer intOrNull = StringsKt.toIntOrNull(subSequence.toString());
            if (intOrNull != null) {
                i = intOrNull.intValue();
            } else {
                Integer intOrNull2 = StringsKt.toIntOrNull(String.valueOf(subSequence.charAt(0)));
                i = intOrNull2 != null ? intOrNull2.intValue() : Integer.MIN_VALUE;
            }
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            return Integer.MIN_VALUE;
        }
        Intrinsics.checkNotNullParameter(serviceState, "<this>");
        Pair<String, String> c = c(serviceState);
        if (c == null) {
            return Integer.MIN_VALUE;
        }
        return b(c.getFirst());
    }

    public static final boolean a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(cellInfo, "<this>");
        Intrinsics.checkNotNullParameter(telephonyManager, "tm");
        if (cellInfo instanceof CellInfoCdma) {
            return StringsKt.equals(a(telephonyManager.getPhoneType()), "CDMA", true);
        }
        Pair<String, String> a2 = a(cellInfo);
        Intrinsics.checkNotNullParameter(telephonyManager, "telephonyManager");
        j4 j4Var = new j4(telephonyManager);
        Intrinsics.checkNotNullParameter(j4Var, "block");
        try {
            obj = j4Var.invoke();
        } catch (Exception unused) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null) {
            k4 k4Var = new k4(str);
            Intrinsics.checkNotNullParameter(k4Var, "block");
            try {
                obj3 = k4Var.invoke();
            } catch (Exception unused2) {
                obj3 = null;
            }
            l4 l4Var = new l4(str);
            Intrinsics.checkNotNullParameter(l4Var, "block");
            try {
                obj2 = l4Var.invoke();
            } catch (Exception unused3) {
                obj2 = null;
            }
        } else {
            obj2 = null;
            obj3 = null;
        }
        Pair pair = new Pair(obj3, obj2);
        Intrinsics.checkNotNullParameter(a2, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair2");
        CharSequence first = a2.getFirst();
        if (!(first == null || first.length() == 0)) {
            CharSequence second = a2.getSecond();
            if (!(second == null || second.length() == 0)) {
                CharSequence charSequence = (CharSequence) pair.getFirst();
                if (!(charSequence == null || charSequence.length() == 0)) {
                    CharSequence charSequence2 = (CharSequence) pair.getSecond();
                    if (!(charSequence2 == null || charSequence2.length() == 0) && StringsKt.equals$default(a2.getFirst(), (String) pair.getFirst(), false, 2, (Object) null) && StringsKt.equals$default(a2.getSecond(), (String) pair.getSecond(), false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final Pair<String, String> a(CellInfo cellInfo) {
        String str;
        String str2;
        int i = Build.VERSION.SDK_INT;
        String str3 = null;
        if (i >= 28) {
            if (cellInfo != null) {
                if (cellInfo instanceof CellInfoCdma) {
                    ((CellInfoCdma) cellInfo).getCellIdentity();
                } else {
                    if (cellInfo instanceof CellInfoGsm) {
                        CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                        str3 = cellIdentity.getMccString();
                        str2 = cellIdentity.getMncString();
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellIdentityLte cellIdentity2 = ((CellInfoLte) cellInfo).getCellIdentity();
                        str3 = cellIdentity2.getMccString();
                        str2 = cellIdentity2.getMncString();
                    } else if (i >= 29 && (cellInfo instanceof CellInfoNr)) {
                        CellIdentity cellIdentity3 = ((CellInfoNr) cellInfo).getCellIdentity();
                        Intrinsics.checkNotNull(cellIdentity3, "null cannot be cast to non-null type android.telephony.CellIdentityNr");
                        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity3;
                        str3 = cellIdentityNr.getMccString();
                        str2 = cellIdentityNr.getMncString();
                    } else if (i >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                        CellIdentityTdscdma cellIdentity4 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        str3 = cellIdentity4.getMccString();
                        str2 = cellIdentity4.getMncString();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity5 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        str3 = cellIdentity5.getMccString();
                        str2 = cellIdentity5.getMncString();
                    }
                    return new Pair<>(str3, str2);
                }
            }
            str2 = null;
            return new Pair<>(str3, str2);
        }
        if (cellInfo != null) {
            if (cellInfo instanceof CellInfoCdma) {
                ((CellInfoCdma) cellInfo).getCellIdentity();
            } else {
                if (cellInfo instanceof CellInfoGsm) {
                    CellIdentityGsm cellIdentity6 = ((CellInfoGsm) cellInfo).getCellIdentity();
                    str3 = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity6.getMcc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(this, *args)");
                    str = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity6.getMnc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                } else if (cellInfo instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity7 = ((CellInfoLte) cellInfo).getCellIdentity();
                    str3 = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity7.getMcc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(this, *args)");
                    str = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity7.getMnc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity8 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    str3 = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity8.getMcc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(this, *args)");
                    str = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(cellIdentity8.getMnc())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                }
                return new Pair<>(str3, str);
            }
        }
        str = null;
        return new Pair<>(str3, str);
    }

    public static final Pair<String, String> a(CellIdentity cellIdentity) {
        String str;
        String str2;
        if (cellIdentity instanceof CellIdentityCdma) {
            CellIdentityCdma cellIdentityCdma = (CellIdentityCdma) cellIdentity;
        } else {
            if (cellIdentity instanceof CellIdentityGsm) {
                CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) cellIdentity;
                str2 = cellIdentityGsm.getMccString();
                str = cellIdentityGsm.getMncString();
            } else if (cellIdentity instanceof CellIdentityLte) {
                CellIdentityLte cellIdentityLte = (CellIdentityLte) cellIdentity;
                str2 = cellIdentityLte.getMccString();
                str = cellIdentityLte.getMncString();
            } else {
                int i = Build.VERSION.SDK_INT;
                if (i >= 29 && (cellIdentity instanceof CellIdentityNr)) {
                    CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                    str2 = cellIdentityNr.getMccString();
                    str = cellIdentityNr.getMncString();
                } else if (i >= 29 && (cellIdentity instanceof CellIdentityTdscdma)) {
                    CellIdentityTdscdma cellIdentityTdscdma = (CellIdentityTdscdma) cellIdentity;
                    str2 = cellIdentityTdscdma.getMccString();
                    str = cellIdentityTdscdma.getMncString();
                } else if (cellIdentity instanceof CellIdentityWcdma) {
                    CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) cellIdentity;
                    str2 = cellIdentityWcdma.getMccString();
                    str = cellIdentityWcdma.getMncString();
                }
            }
            if (str2 == null && str != null) {
                return new Pair<>(str2, str);
            }
        }
        str = null;
        str2 = null;
        return str2 == null ? null : null;
    }

    public static final boolean a(Pair<String, String> pair) {
        if (pair == null) {
            return false;
        }
        CharSequence first = pair.getFirst();
        if (first == null || first.length() == 0) {
            return false;
        }
        CharSequence second = pair.getSecond();
        return !(second == null || second.length() == 0);
    }

    public static final CellInfo a(List<? extends CellInfo> list) {
        List list2;
        if (list != null) {
            list2 = new ArrayList();
            for (T next : list) {
                if (((CellInfo) next).isRegistered()) {
                    list2.add(next);
                }
            }
        } else {
            list2 = null;
        }
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return (CellInfo) CollectionsKt.firstOrNull(list2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0012 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.telephony.CellInfo a(java.util.List<? extends android.telephony.CellInfo> r6, com.m2catalyst.m2sdk.t r7) {
        /*
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            if (r6 == 0) goto L_0x0062
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0012:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r6.next()
            r3 = r2
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3
            boolean r4 = r3.isRegistered()
            if (r4 == 0) goto L_0x005a
            boolean r4 = r3 instanceof android.telephony.CellInfoLte
            if (r4 == 0) goto L_0x002c
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.a
            goto L_0x0056
        L_0x002c:
            boolean r4 = r3 instanceof android.telephony.CellInfoCdma
            if (r4 == 0) goto L_0x0033
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.d
            goto L_0x0056
        L_0x0033:
            boolean r4 = r3 instanceof android.telephony.CellInfoGsm
            if (r4 == 0) goto L_0x003a
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.b
            goto L_0x0056
        L_0x003a:
            boolean r4 = r3 instanceof android.telephony.CellInfoWcdma
            if (r4 == 0) goto L_0x0041
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.e
            goto L_0x0056
        L_0x0041:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r4 < r5) goto L_0x0055
            boolean r4 = r3 instanceof android.telephony.CellInfoTdscdma
            if (r4 == 0) goto L_0x004e
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.f
            goto L_0x0056
        L_0x004e:
            boolean r3 = r3 instanceof android.telephony.CellInfoNr
            if (r3 == 0) goto L_0x0055
            com.m2catalyst.m2sdk.t r3 = com.m2catalyst.m2sdk.t.c
            goto L_0x0056
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 != r7) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 == 0) goto L_0x0012
            r1.add(r2)
            goto L_0x0012
        L_0x0061:
            r0 = r1
        L_0x0062:
            if (r0 != 0) goto L_0x0068
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0068:
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.m4.a(java.util.List, com.m2catalyst.m2sdk.t):android.telephony.CellInfo");
    }
}
