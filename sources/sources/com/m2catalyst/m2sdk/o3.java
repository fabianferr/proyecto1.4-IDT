package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.models.MNSI;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModelsUtils.kt */
public final class o3 {
    public static final boolean a(MNSI mnsi, MNSI mnsi2, int i) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (mnsi2 == null) {
            return true;
        }
        Integer dbm = mnsi.getDbm();
        Set<String> set = s1.a;
        int intValue = dbm != null ? dbm.intValue() : 0;
        Integer dbm2 = mnsi2.getDbm();
        int intValue2 = dbm2 != null ? dbm2.intValue() : 0;
        Integer cdmaDbm = mnsi.getCdmaDbm();
        if ((cdmaDbm != null ? cdmaDbm.intValue() : 0) != 0) {
            Integer cdmaDbm2 = mnsi.getCdmaDbm();
            intValue = cdmaDbm2 != null ? cdmaDbm2.intValue() : 0;
            Integer cdmaDbm3 = mnsi2.getCdmaDbm();
            intValue2 = cdmaDbm3 != null ? cdmaDbm3.intValue() : 0;
        }
        Integer evdoDbm = mnsi.getEvdoDbm();
        if ((evdoDbm != null ? evdoDbm.intValue() : 0) != 0) {
            Integer evdoDbm2 = mnsi.getEvdoDbm();
            intValue = evdoDbm2 != null ? evdoDbm2.intValue() : 0;
            Integer evdoDbm3 = mnsi2.getEvdoDbm();
            intValue2 = evdoDbm3 != null ? evdoDbm3.intValue() : 0;
        }
        Integer gsmDbm = mnsi.getGsmDbm();
        if ((gsmDbm != null ? gsmDbm.intValue() : 0) != 0) {
            Integer gsmDbm2 = mnsi.getGsmDbm();
            intValue = gsmDbm2 != null ? gsmDbm2.intValue() : 0;
            Integer gsmDbm3 = mnsi2.getGsmDbm();
            intValue2 = gsmDbm3 != null ? gsmDbm3.intValue() : 0;
        }
        Integer lteDbm = mnsi.getLteDbm();
        if ((lteDbm != null ? lteDbm.intValue() : 0) != 0) {
            Integer lteDbm2 = mnsi.getLteDbm();
            intValue = lteDbm2 != null ? lteDbm2.intValue() : 0;
            Integer lteDbm3 = mnsi2.getLteDbm();
            intValue2 = lteDbm3 != null ? lteDbm3.intValue() : 0;
        }
        Integer nrDbm = mnsi.getNrDbm();
        if ((nrDbm != null ? nrDbm.intValue() : 0) != 0) {
            Integer nrDbm2 = mnsi.getNrDbm();
            intValue = nrDbm2 != null ? nrDbm2.intValue() : 0;
            Integer nrDbm3 = mnsi2.getNrDbm();
            intValue2 = nrDbm3 != null ? nrDbm3.intValue() : 0;
        }
        Integer tdscdmaDbm = mnsi.getTdscdmaDbm();
        if ((tdscdmaDbm != null ? tdscdmaDbm.intValue() : 0) != 0) {
            Integer tdscdmaDbm2 = mnsi.getTdscdmaDbm();
            intValue = tdscdmaDbm2 != null ? tdscdmaDbm2.intValue() : 0;
            Integer tdscdmaDbm3 = mnsi2.getTdscdmaDbm();
            intValue2 = tdscdmaDbm3 != null ? tdscdmaDbm3.intValue() : 0;
        }
        Integer wcdmaDbm = mnsi.getWcdmaDbm();
        if ((wcdmaDbm != null ? wcdmaDbm.intValue() : 0) != 0) {
            Integer wcdmaDbm2 = mnsi.getWcdmaDbm();
            intValue = wcdmaDbm2 != null ? wcdmaDbm2.intValue() : 0;
            Integer wcdmaDbm3 = mnsi2.getWcdmaDbm();
            intValue2 = wcdmaDbm3 != null ? wcdmaDbm3.intValue() : 0;
        }
        Integer valueOf = Integer.valueOf(intValue);
        int intValue3 = valueOf != null ? valueOf.intValue() : 0;
        Integer valueOf2 = Integer.valueOf(intValue2);
        if (Math.abs(intValue3 - (valueOf2 != null ? valueOf2.intValue() : 0)) >= i) {
            return true;
        }
        return false;
    }

    public static final boolean a(MNSI mnsi) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        return (mnsi.getCelltowerInfoTimestamp() == null && mnsi.getBaseStationId() == null && mnsi.getNetworkId() == null && mnsi.getSystemId() == null && mnsi.getCid() == null && mnsi.getLteCi() == null && mnsi.getLtePci() == null && mnsi.getPsc() == null && mnsi.getWcdmaUarfcn() == null && mnsi.getNrNci() == null && mnsi.getNrPci() == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r4 = (r4 = r2.getMnsiConfiguration()).a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(com.m2catalyst.m2sdk.business.models.MNSI r21, com.m2catalyst.m2sdk.business.models.MNSI r22) {
        /*
            r0 = r21
            r1 = r22
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            r3 = 1
            if (r2 == 0) goto L_0x0025
            com.m2catalyst.m2sdk.f3 r4 = r2.getMnsiConfiguration()
            if (r4 == 0) goto L_0x0025
            java.lang.Integer r4 = r4.a()
            if (r4 == 0) goto L_0x0025
            int r4 = r4.intValue()
            goto L_0x0026
        L_0x0025:
            r4 = 1
        L_0x0026:
            if (r2 == 0) goto L_0x003a
            com.m2catalyst.m2sdk.f3 r5 = r2.getMnsiConfiguration()
            if (r5 == 0) goto L_0x003a
            java.lang.Integer r5 = r5.b()
            if (r5 == 0) goto L_0x003a
            int r5 = r5.intValue()
            float r5 = (float) r5
            goto L_0x003c
        L_0x003a:
            r5 = 1084227584(0x40a00000, float:5.0)
        L_0x003c:
            if (r2 == 0) goto L_0x004f
            com.m2catalyst.m2sdk.f3 r6 = r2.getMnsiConfiguration()
            if (r6 == 0) goto L_0x004f
            java.lang.Integer r6 = r6.c()
            if (r6 == 0) goto L_0x004f
            int r6 = r6.intValue()
            goto L_0x0050
        L_0x004f:
            r6 = 6
        L_0x0050:
            if (r2 == 0) goto L_0x0063
            com.m2catalyst.m2sdk.f3 r2 = r2.getMnsiConfiguration()
            if (r2 == 0) goto L_0x0063
            java.lang.Integer r2 = r2.d()
            if (r2 == 0) goto L_0x0063
            int r2 = r2.intValue()
            goto L_0x0064
        L_0x0063:
            r2 = 3
        L_0x0064:
            if (r1 != 0) goto L_0x0067
            return r3
        L_0x0067:
            int r7 = r21.getNetworkType()
            int r8 = r22.getNetworkType()
            r9 = 0
            if (r7 == r8) goto L_0x007e
            int r7 = r22.getNetworkType()
            if (r7 == 0) goto L_0x007e
            int r7 = r21.getNetworkType()
            if (r7 != 0) goto L_0x008c
        L_0x007e:
            java.lang.String r7 = r21.getPhoneType()
            java.lang.String r8 = r22.getPhoneType()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x008e
        L_0x008c:
            r7 = 1
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            java.lang.Boolean r8 = r21.is5GConnected()
            java.lang.Boolean r10 = r22.is5GConnected()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00bc
            java.lang.Boolean r8 = r21.isUsingCarrierAggregation()
            java.lang.Boolean r10 = r22.isUsingCarrierAggregation()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00bc
            java.lang.Integer r8 = r21.getOverrideNetworkType()
            java.lang.Integer r10 = r22.getOverrideNetworkType()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 != 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r8 = 0
            goto L_0x00bd
        L_0x00bc:
            r8 = 1
        L_0x00bd:
            boolean r10 = a(r21)
            if (r10 != 0) goto L_0x00c9
            boolean r10 = a(r22)
            if (r10 == 0) goto L_0x00d1
        L_0x00c9:
            boolean r10 = r21.isSameAntenna(r22)
            if (r10 != 0) goto L_0x00d1
            r10 = 1
            goto L_0x00d2
        L_0x00d1:
            r10 = 0
        L_0x00d2:
            java.lang.String r11 = "MNSI"
            if (r7 != 0) goto L_0x01ac
            if (r8 != 0) goto L_0x01ac
            if (r10 == 0) goto L_0x00dc
            goto L_0x01ac
        L_0x00dc:
            long r7 = r21.getTimeStamp()
            java.lang.Long r10 = r21.getLocationTimeStamp()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            long r12 = r10.longValue()
            long r7 = r7 - r12
            long r7 = java.lang.Math.abs(r7)
            long r12 = com.m2catalyst.m2sdk.o1.c(r6)
            int r6 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x010e
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "recordChanged REJECT: locTimeDiff: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String[] r2 = new java.lang.String[r9]
            r0.d(r11, r1, r2)
            return r9
        L_0x010e:
            float[] r6 = new float[r3]
            r7 = 0
            r6[r9] = r7
            java.lang.Double r8 = r21.getLatitude()     // Catch:{ Exception -> 0x013b }
            double r12 = com.m2catalyst.m2sdk.s1.a((java.lang.Double) r8)     // Catch:{ Exception -> 0x013b }
            java.lang.Double r8 = r21.getLongitude()     // Catch:{ Exception -> 0x013b }
            double r14 = com.m2catalyst.m2sdk.s1.a((java.lang.Double) r8)     // Catch:{ Exception -> 0x013b }
            java.lang.Double r8 = r22.getLatitude()     // Catch:{ Exception -> 0x013b }
            double r16 = com.m2catalyst.m2sdk.s1.a((java.lang.Double) r8)     // Catch:{ Exception -> 0x013b }
            java.lang.Double r8 = r22.getLongitude()     // Catch:{ Exception -> 0x013b }
            double r18 = com.m2catalyst.m2sdk.s1.a((java.lang.Double) r8)     // Catch:{ Exception -> 0x013b }
            r20 = r6
            android.location.Location.distanceBetween(r12, r14, r16, r18, r20)     // Catch:{ Exception -> 0x013b }
            r7 = r6[r9]     // Catch:{ Exception -> 0x013b }
            goto L_0x013c
        L_0x013b:
        L_0x013c:
            long r12 = r22.getTimeStamp()
            long r14 = r21.getTimeStamp()
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)
            java.lang.String r6 = ", timeDiff: "
            java.lang.String r8 = ", dbmChangedIn: "
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0186
            boolean r5 = a(r0, r1, r4)
            if (r5 != 0) goto L_0x0186
            long r14 = com.m2catalyst.m2sdk.o1.b(r2)
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 < 0) goto L_0x0160
            goto L_0x0186
        L_0x0160:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            boolean r0 = a(r0, r1, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "recordChanged REJECT: distanceDiff: "
            r1.<init>(r3)
            r1.append(r7)
            r1.append(r8)
            r1.append(r0)
            r1.append(r6)
            r1.append(r12)
            java.lang.String r0 = r1.toString()
            java.lang.String[] r1 = new java.lang.String[r9]
            r2.d(r11, r0, r1)
            return r9
        L_0x0186:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            boolean r0 = a(r0, r1, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "recordChanged ACCEPT: distanceDiff: "
            r1.<init>(r4)
            r1.append(r7)
            r1.append(r8)
            r1.append(r0)
            r1.append(r6)
            r1.append(r12)
            java.lang.String r0 = r1.toString()
            java.lang.String[] r1 = new java.lang.String[r9]
            r2.d(r11, r0, r1)
            return r3
        L_0x01ac:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "recordChanged ACCEPT: networkOrPhoneTypeChanged: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r2 = ", overrideAggregOr5GChanged: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ", antennaChanged: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String[] r2 = new java.lang.String[r9]
            r0.d(r11, r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.o3.a(com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.business.models.MNSI):boolean");
    }
}
