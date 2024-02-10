package com.m2catalyst.m2sdk;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategy.kt */
public abstract class i<SS, CI, API> {
    public final Context a;
    public final LocationManager b;

    public i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    public abstract b5 a(b5 b5Var, MNSI mnsi);

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
        r3 = r0.hashCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.m2catalyst.m2sdk.business.models.MNSI a(com.m2catalyst.m2sdk.business.models.MNSI r6) {
        /*
            r5 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "mnsi"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Integer r0 = r6.getNetworkMnc()
            r1 = 3
            boolean r0 = a((com.m2catalyst.m2sdk.i) r5, (java.lang.Integer) r0, (int) r1)
            r2 = 0
            if (r0 == 0) goto L_0x00b4
            java.lang.Integer r0 = r6.getNetworkMcc()
            boolean r0 = a((com.m2catalyst.m2sdk.i) r5, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = r6.getPhoneType()
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = com.m2catalyst.m2sdk.m4.a
            r1 = 1
            if (r0 != 0) goto L_0x002a
            goto L_0x0066
        L_0x002a:
            int r3 = r0.hashCode()
            r4 = 70881(0x114e1, float:9.9325E-41)
            if (r3 == r4) goto L_0x005e
            r4 = 82106(0x140ba, float:1.15055E-40)
            if (r3 == r4) goto L_0x0055
            r4 = 2063797(0x1f7db5, float:2.891996E-39)
            if (r3 == r4) goto L_0x004c
            r4 = 2402104(0x24a738, float:3.366065E-39)
            if (r3 == r4) goto L_0x0043
            goto L_0x0066
        L_0x0043:
            java.lang.String r3 = "NONE"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0068
            goto L_0x0066
        L_0x004c:
            java.lang.String r3 = "CDMA"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0068
            goto L_0x0066
        L_0x0055:
            java.lang.String r3 = "SIP"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0068
            goto L_0x0066
        L_0x005e:
            java.lang.String r3 = "GSM"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0068
        L_0x0066:
            r0 = 0
            goto L_0x0069
        L_0x0068:
            r0 = 1
        L_0x0069:
            if (r0 == 0) goto L_0x00b4
            java.lang.Long r0 = r6.getLocationTimeStamp()
            boolean r0 = a((java.lang.Long) r0)
            if (r0 == 0) goto L_0x00b4
            long r3 = r6.getTimeStamp()
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            boolean r0 = a((java.lang.Long) r0)
            if (r0 == 0) goto L_0x00b4
            java.lang.Double r0 = r6.getLongitude()
            boolean r0 = a((com.m2catalyst.m2sdk.i) r5, (java.lang.Double) r0)
            if (r0 == 0) goto L_0x00b4
            java.lang.Double r0 = r6.getLatitude()
            boolean r0 = a((com.m2catalyst.m2sdk.i) r5, (java.lang.Double) r0)
            if (r0 == 0) goto L_0x00b4
            float r0 = r6.getAccuracy()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            boolean r0 = a((com.m2catalyst.m2sdk.i) r5, (java.lang.Float) r0)
            if (r0 == 0) goto L_0x00b4
            int r0 = r6.getNetworkType()
            if (r0 < r1) goto L_0x00b4
            int r0 = r6.getNetworkType()
            r3 = 20
            if (r0 > r3) goto L_0x00b4
            r2 = 1
        L_0x00b4:
            if (r2 == 0) goto L_0x00c2
            boolean r0 = r5.c(r6)
            if (r0 == 0) goto L_0x00bf
            com.m2catalyst.m2sdk.business.models.DataCompleteness r0 = com.m2catalyst.m2sdk.business.models.DataCompleteness.STANDARD
            goto L_0x00c4
        L_0x00bf:
            com.m2catalyst.m2sdk.business.models.DataCompleteness r0 = com.m2catalyst.m2sdk.business.models.DataCompleteness.BASIC
            goto L_0x00c4
        L_0x00c2:
            com.m2catalyst.m2sdk.business.models.DataCompleteness r0 = com.m2catalyst.m2sdk.business.models.DataCompleteness.USELESS
        L_0x00c4:
            r6.setCompleteness(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.i.a(com.m2catalyst.m2sdk.business.models.MNSI):com.m2catalyst.m2sdk.business.models.MNSI");
    }

    public abstract MNSI a(MNSI mnsi, c3 c3Var);

    public abstract t a();

    public abstract Pair<Integer, MNSI> a(c3 c3Var, M2Location m2Location, c3 c3Var2, MNSI mnsi);

    public abstract boolean a(int i);

    public final boolean b(MNSI mnsi) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        boolean z = mnsi.getTimeStamp() != 0 && mnsi.isAtLeastBasic();
        if (!mnsi.isStandardCompleteness()) {
            return z;
        }
        if (!z || !c(mnsi)) {
            return false;
        }
        return true;
    }

    public abstract boolean c(MNSI mnsi);

    public final <T> Pair<Long, T> a(T t, T t2, c3 c3Var, c3 c3Var2) {
        Triple triple;
        Triple triple2;
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        long j = c3Var.m;
        long j2 = c3Var.n;
        if (t == null && t2 == null) {
            triple = new Triple(e6.NONE, -1L, null);
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                triple2 = new Triple(e6.CELL_INFO, Long.valueOf(j), t);
            } else if (!a(t) || !a(t2)) {
                if (a(t)) {
                    triple2 = new Triple(e6.CELL_INFO, Long.valueOf(j), t);
                } else if (a(t2)) {
                    triple = new Triple(e6.SIGNAL_STRENGTH, Long.valueOf(j2), t2);
                } else {
                    triple = new Triple(e6.NONE, -1L, null);
                }
            } else if (j > j2) {
                triple2 = new Triple(e6.CELL_INFO, Long.valueOf(j), t);
            } else {
                triple = new Triple(e6.SIGNAL_STRENGTH, Long.valueOf(j2), t2);
            }
            triple = triple2;
        }
        if (c3Var2 == null || triple.getFirst() == e6.NONE) {
            return new Pair<>(triple.getSecond(), triple.getThird());
        }
        if (triple.getFirst() == e6.CELL_INFO) {
            if (c3Var.m > c3Var2.m) {
                return new Pair<>(triple.getSecond(), triple.getThird());
            }
            return new Pair<>(-1L, null);
        } else if (triple.getFirst() != e6.SIGNAL_STRENGTH) {
            return new Pair<>(-1L, null);
        } else {
            if (c3Var.n > c3Var2.n) {
                return new Pair<>(triple.getSecond(), triple.getThird());
            }
            return new Pair<>(-1L, null);
        }
    }

    public final <T> boolean a(T t) {
        if (t == null) {
            return false;
        }
        if (t instanceof CellSignalStrengthCdma) {
            CellSignalStrengthCdma cellSignalStrengthCdma = (CellSignalStrengthCdma) t;
            Intrinsics.checkNotNullParameter(cellSignalStrengthCdma, "<this>");
            if ((!a(this, Integer.valueOf(cellSignalStrengthCdma.getEvdoDbm()), 3) || !a(Integer.valueOf(cellSignalStrengthCdma.getEvdoEcio()), true, false) || cellSignalStrengthCdma.getEvdoDbm() >= 0 || !a(Integer.valueOf(cellSignalStrengthCdma.getEvdoSnr()), true, false) || !a(this, Integer.valueOf(cellSignalStrengthCdma.getAsuLevel()), 3)) && (!a(Integer.valueOf(cellSignalStrengthCdma.getCdmaEcio()), true, false) || !a(this, Integer.valueOf(cellSignalStrengthCdma.getCdmaDbm()), 3) || !a(this, Integer.valueOf(cellSignalStrengthCdma.getAsuLevel()), 3))) {
                return false;
            }
        } else if (t instanceof CellSignalStrengthGsm) {
            CellSignalStrengthGsm cellSignalStrengthGsm = (CellSignalStrengthGsm) t;
            if (!a(this, Integer.valueOf(cellSignalStrengthGsm.getDbm()), 3) || cellSignalStrengthGsm.getDbm() >= 0 || !a(this, Integer.valueOf(cellSignalStrengthGsm.getAsuLevel()), 3) || !a(this, Integer.valueOf(cellSignalStrengthGsm.getLevel()), 3)) {
                return false;
            }
        } else if (t instanceof CellSignalStrengthLte) {
            CellSignalStrengthLte cellSignalStrengthLte = (CellSignalStrengthLte) t;
            if (!a(this, Integer.valueOf(cellSignalStrengthLte.getRsrp()), 3) || !a(this, Integer.valueOf(cellSignalStrengthLte.getRsrq()), 3) || !a(this, Integer.valueOf(cellSignalStrengthLte.getRssnr()), 1) || !a(this, Integer.valueOf(cellSignalStrengthLte.getDbm()), 3) || cellSignalStrengthLte.getDbm() >= 0) {
                return false;
            }
        } else if (t instanceof CellSignalStrengthNr) {
            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) t;
            if (!a(this, Integer.valueOf(cellSignalStrengthNr.getAsuLevel()), 3) || !a(this, Integer.valueOf(cellSignalStrengthNr.getDbm()), 3) || cellSignalStrengthNr.getDbm() >= 0 || !a(this, Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), 1) || !a(this, Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), 1)) {
                return false;
            }
        } else if (!(t instanceof CellSignalStrengthWcdma)) {
            return false;
        } else {
            CellSignalStrengthWcdma cellSignalStrengthWcdma = (CellSignalStrengthWcdma) t;
            if (!a(this, Integer.valueOf(cellSignalStrengthWcdma.getDbm()), 3) || !a(this, Integer.valueOf(cellSignalStrengthWcdma.getAsuLevel()), 3) || !a(this, Integer.valueOf(cellSignalStrengthWcdma.getLevel()), 3) || cellSignalStrengthWcdma.getDbm() >= 0) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean a(i iVar, Integer num, int i) {
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        iVar.getClass();
        return a(num, z2, z);
    }

    public static boolean a(Integer num, boolean z, boolean z2) {
        int i = z2 ? 1000 : -1000;
        Set<String> set = s1.a;
        if (num != null) {
            i = num.intValue();
        }
        return !z ? i != 1000 : !(i == 1000 || i == Integer.MAX_VALUE || i == Integer.MIN_VALUE);
    }

    public static boolean a(Long l) {
        Set<String> set = s1.a;
        return (l != null ? l.longValue() : -1000) != 1000;
    }

    public static boolean a(i iVar, Double d) {
        Set<String> set = s1.a;
        return !((d != null ? d.doubleValue() : -1000.0d) == 1000.0d);
    }

    public static boolean a(i iVar, Float f) {
        Set<String> set = s1.a;
        return !((f != null ? f.floatValue() : -1000.0f) == 1000.0f);
    }

    public final MNSI a(c3 c3Var, long j, CellSignalStrength cellSignalStrength) {
        int i;
        int i2;
        Object obj;
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        Intrinsics.checkNotNullParameter(cellSignalStrength, "cellSignalStrength");
        MNSI mnsi = new MNSI();
        mnsi.setId(-1);
        mnsi.setTimeStamp(j);
        mnsi.setTimeZoneOffset(o1.a(Long.valueOf(mnsi.getTimeStamp())));
        mnsi.setTimeZone(o1.b());
        mnsi.setAsu(Integer.valueOf(cellSignalStrength.getAsuLevel()));
        mnsi.setLevel(cellSignalStrength.getLevel());
        mnsi.setDbm(Integer.valueOf(cellSignalStrength.getDbm()));
        mnsi.setSimSlot(c3Var.n());
        mnsi.setSubscriber(Integer.valueOf(c3Var.o()));
        Integer subscriber = mnsi.getSubscriber();
        mnsi.setDataDefaultSim((subscriber != null && subscriber.intValue() == m6.a(this.a).getId()) ? 1 : 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30 && (obj = c3Var.f) != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.telephony.TelephonyDisplayInfo");
            mnsi.setOverrideNetworkType(Integer.valueOf(((TelephonyDisplayInfo) obj).getOverrideNetworkType()));
        }
        Unit unit = Unit.INSTANCE;
        if (i3 >= 30) {
            Object obj2 = c3Var.f;
            if (obj2 != null) {
                TelephonyDisplayInfo telephonyDisplayInfo = (TelephonyDisplayInfo) obj2;
                int networkType = telephonyDisplayInfo.getNetworkType();
                if (networkType == 13 || networkType == 18) {
                    int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                    if (overrideNetworkType == 0) {
                        Boolean bool = Boolean.FALSE;
                        mnsi.setUsingCarrierAggregation(bool);
                        mnsi.set5GConnected(bool);
                    } else if (overrideNetworkType == 1 || overrideNetworkType == 2) {
                        mnsi.setUsingCarrierAggregation(Boolean.TRUE);
                        mnsi.set5GConnected(Boolean.FALSE);
                    } else if (overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5) {
                        Boolean bool2 = Boolean.TRUE;
                        mnsi.setUsingCarrierAggregation(bool2);
                        mnsi.set5GConnected(bool2);
                    } else {
                        Boolean bool3 = Boolean.FALSE;
                        mnsi.setUsingCarrierAggregation(bool3);
                        mnsi.set5GConnected(bool3);
                    }
                } else if (networkType != 20) {
                    Boolean bool4 = Boolean.FALSE;
                    mnsi.setUsingCarrierAggregation(bool4);
                    mnsi.set5GConnected(bool4);
                } else {
                    if (telephonyDisplayInfo.getOverrideNetworkType() == 5) {
                        mnsi.setUsingCarrierAggregation(Boolean.TRUE);
                    } else {
                        mnsi.setUsingCarrierAggregation(Boolean.FALSE);
                    }
                    mnsi.set5GConnected(Boolean.TRUE);
                }
            }
        } else if (i3 == 29 && (m4.a(c3Var.g, t.c) instanceof CellInfoNr)) {
            mnsi.set5GConnected(Boolean.TRUE);
        }
        NetworkInfoSnapshot networkInfoSnapshot = c3Var.k;
        Intrinsics.checkNotNull(networkInfoSnapshot);
        mnsi.setSimOperatorName(networkInfoSnapshot.getSimOperatorName());
        mnsi.setSimCountryIso(networkInfoSnapshot.getSimCountryIso());
        mnsi.setSimMcc(networkInfoSnapshot.getSimMcc());
        mnsi.setSimMnc(networkInfoSnapshot.getSimMnc());
        mnsi.setResourcesMcc(networkInfoSnapshot.getResourcesMcc());
        mnsi.setResourcesMnc(networkInfoSnapshot.getResourcesMnc());
        MNSI a2 = a(mnsi, c3Var);
        ServiceState serviceState = c3Var.i;
        M2SDKLogger m2SDKLogger = m4.a;
        Intrinsics.checkNotNullParameter(a2, "<this>");
        if (serviceState != null) {
            i = m4.a(serviceState);
            i2 = m4.d(serviceState);
        } else {
            i = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
        }
        a2.setDataNetworkType(i);
        a2.setVoiceNetworkType(i2);
        a2.setNetworkGlobalType(a2.getDataNetworkType());
        return a2;
    }

    public final MNSI a(MNSI mnsi, M2Location m2Location) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (m2Location != null) {
            LocationManager locationManager = this.b;
            mnsi.setGpsAvailable(locationManager != null ? Boolean.valueOf(locationManager.isProviderEnabled("gps")) : Boolean.FALSE);
            mnsi.setLocationTimeStamp(Long.valueOf(m2Location.getTime()));
            mnsi.setLatitude(Double.valueOf(m2Location.getLatitude()));
            mnsi.setLongitude(Double.valueOf(m2Location.getLongitude()));
            mnsi.setBarometric(m2Location.getBarometricPressure());
            mnsi.setAccuracy(m2Location.getAccuracy());
            mnsi.setLocationProvider(m2Location.getProvider());
            mnsi.setIndoorOutdoorWeight(m2Location.getIndoorOutdoorWeight());
            mnsi.setPermissions(m2Location.getPermissions());
        }
        return mnsi;
    }

    public static boolean a(MNSI mnsi, MNSI mnsi2) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (!((mnsi.getLatitude() == null || mnsi.getLongitude() == null || mnsi.getLocationTimeStamp() == null) ? false : true) || !o3.a(mnsi, mnsi2)) {
            return false;
        }
        return true;
    }
}
