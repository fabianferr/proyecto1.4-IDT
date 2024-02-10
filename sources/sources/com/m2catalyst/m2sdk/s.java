package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityNr;
import android.telephony.CellSignalStrengthNr;
import android.telephony.ServiceState;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategyNrMin29.kt */
public final class s extends i<CellSignalStrengthNr, CellIdentityNr, Object> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final t a() {
        return t.c;
    }

    public final boolean a(int i) {
        return true;
    }

    public final boolean c(MNSI mnsi) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (!i.a((i) this, mnsi.getNrAsuLevel(), 3) || !i.a((i) this, mnsi.getNrDbm(), 3) || mnsi.getNrDbm() == null) {
            return false;
        }
        Integer nrDbm = mnsi.getNrDbm();
        Intrinsics.checkNotNull(nrDbm);
        if (nrDbm.intValue() >= 0 || !i.a((i) this, mnsi.getNrSsRsrp(), 1) || !i.a((i) this, mnsi.getNrSsRsrq(), 1)) {
            return false;
        }
        Long nrNci = mnsi.getNrNci();
        Set<String> set = s1.a;
        long longValue = nrNci != null ? nrNci.longValue() : 1000;
        if ((longValue == 1000 || longValue == Long.MAX_VALUE || longValue == Long.MIN_VALUE) ? false : true) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, com.m2catalyst.m2sdk.business.models.MNSI> a(com.m2catalyst.m2sdk.c3 r15, com.m2catalyst.m2sdk.business.models.M2Location r16, com.m2catalyst.m2sdk.c3 r17, com.m2catalyst.m2sdk.business.models.MNSI r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            java.lang.String r2 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r15.o()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r4 = "MNSI"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r3.getLogger(r4)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r4 = r15.h()
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x001c
            r4 = 1
            goto L_0x001d
        L_0x001c:
            r4 = 0
        L_0x001d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "CellInfoStrategyNrMin29 newestNetworkInfo null="
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[r6]
            java.lang.String r8 = "MNSI_BUILDER"
            r3.d(r8, r4, r7)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r4 = r15.h()
            r7 = 0
            if (r4 != 0) goto L_0x003a
            return r7
        L_0x003a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r4 < r9) goto L_0x0389
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.c
            java.util.List r11 = r15.f()
            android.telephony.CellInfo r10 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r11, (com.m2catalyst.m2sdk.t) r10)
            android.telephony.ServiceState r11 = r15.i()
            r12 = 30
            if (r11 == 0) goto L_0x008f
            if (r4 < r12) goto L_0x008f
            java.util.List r4 = r11.getNetworkRegistrationInfoList()
            java.lang.String r10 = "serviceState.networkRegistrationInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            java.util.Iterator r4 = r4.iterator()
        L_0x0061:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x0080
            java.lang.Object r10 = r4.next()
            r11 = r10
            android.telephony.NetworkRegistrationInfo r11 = (android.telephony.NetworkRegistrationInfo) r11
            boolean r13 = r11.isRegistered()
            if (r13 == 0) goto L_0x007c
            android.telephony.CellIdentity r11 = r11.getCellIdentity()
            if (r11 == 0) goto L_0x007c
            r11 = 1
            goto L_0x007d
        L_0x007c:
            r11 = 0
        L_0x007d:
            if (r11 == 0) goto L_0x0061
            goto L_0x0081
        L_0x0080:
            r10 = r7
        L_0x0081:
            android.telephony.NetworkRegistrationInfo r10 = (android.telephony.NetworkRegistrationInfo) r10
            if (r10 == 0) goto L_0x008a
            android.telephony.CellIdentity r4 = r10.getCellIdentity()
            goto L_0x008b
        L_0x008a:
            r4 = r7
        L_0x008b:
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00fa
        L_0x008f:
            if (r10 == 0) goto L_0x00e3
            boolean r13 = r10 instanceof android.telephony.CellInfoCdma
            if (r13 == 0) goto L_0x009e
            android.telephony.CellInfoCdma r10 = (android.telephony.CellInfoCdma) r10
            android.telephony.CellIdentityCdma r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x009e:
            boolean r13 = r10 instanceof android.telephony.CellInfoGsm
            if (r13 == 0) goto L_0x00ab
            android.telephony.CellInfoGsm r10 = (android.telephony.CellInfoGsm) r10
            android.telephony.CellIdentityGsm r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x00ab:
            boolean r13 = r10 instanceof android.telephony.CellInfoLte
            if (r13 == 0) goto L_0x00b8
            android.telephony.CellInfoLte r10 = (android.telephony.CellInfoLte) r10
            android.telephony.CellIdentityLte r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x00b8:
            if (r4 < r9) goto L_0x00c7
            boolean r13 = r10 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x00c7
            android.telephony.CellInfoNr r10 = (android.telephony.CellInfoNr) r10
            android.telephony.CellIdentity r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x00c7:
            if (r4 < r9) goto L_0x00d6
            boolean r4 = r10 instanceof android.telephony.CellInfoTdscdma
            if (r4 == 0) goto L_0x00d6
            android.telephony.CellInfoTdscdma r10 = (android.telephony.CellInfoTdscdma) r10
            android.telephony.CellIdentityTdscdma r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x00d6:
            boolean r4 = r10 instanceof android.telephony.CellInfoWcdma
            if (r4 == 0) goto L_0x00e3
            android.telephony.CellInfoWcdma r10 = (android.telephony.CellInfoWcdma) r10
            android.telephony.CellIdentityWcdma r4 = r10.getCellIdentity()
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4
            goto L_0x00e4
        L_0x00e3:
            r4 = r7
        L_0x00e4:
            if (r4 == 0) goto L_0x00fa
            java.lang.Class r10 = r4.getClass()
            java.lang.String r10 = r10.getSimpleName()
            java.lang.String r13 = "cellIdentity::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
            boolean r10 = com.m2catalyst.m2sdk.m4.a((android.telephony.ServiceState) r11, (java.lang.String) r10)
            if (r10 != 0) goto L_0x00fa
            r4 = r7
        L_0x00fa:
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.c
            java.util.List r11 = r15.f()
            if (r11 == 0) goto L_0x010b
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            r11 = 0
            goto L_0x010c
        L_0x010b:
            r11 = 1
        L_0x010c:
            if (r11 != 0) goto L_0x018d
            java.util.List r11 = r15.f()
            android.telephony.CellInfo r10 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r11, (com.m2catalyst.m2sdk.t) r10)
            boolean r11 = r10 instanceof android.telephony.CellInfoCdma
            if (r11 == 0) goto L_0x0124
            r11 = r10
            android.telephony.CellInfoCdma r11 = (android.telephony.CellInfoCdma) r11
            android.telephony.CellSignalStrengthCdma r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0124:
            boolean r11 = r10 instanceof android.telephony.CellInfoGsm
            if (r11 == 0) goto L_0x0132
            r11 = r10
            android.telephony.CellInfoGsm r11 = (android.telephony.CellInfoGsm) r11
            android.telephony.CellSignalStrengthGsm r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0132:
            boolean r11 = r10 instanceof android.telephony.CellInfoLte
            if (r11 == 0) goto L_0x0140
            r11 = r10
            android.telephony.CellInfoLte r11 = (android.telephony.CellInfoLte) r11
            android.telephony.CellSignalStrengthLte r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0140:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r9) goto L_0x0152
            boolean r13 = r10 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x0152
            r11 = r10
            android.telephony.CellInfoNr r11 = (android.telephony.CellInfoNr) r11
            android.telephony.CellSignalStrength r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0152:
            if (r11 < r9) goto L_0x0162
            boolean r11 = r10 instanceof android.telephony.CellInfoTdscdma
            if (r11 == 0) goto L_0x0162
            r11 = r10
            android.telephony.CellInfoTdscdma r11 = (android.telephony.CellInfoTdscdma) r11
            android.telephony.CellSignalStrengthTdscdma r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0162:
            boolean r11 = r10 instanceof android.telephony.CellInfoWcdma
            if (r11 == 0) goto L_0x0170
            r11 = r10
            android.telephony.CellInfoWcdma r11 = (android.telephony.CellInfoWcdma) r11
            android.telephony.CellSignalStrengthWcdma r11 = r11.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r11 = (android.telephony.CellSignalStrengthNr) r11
            goto L_0x0171
        L_0x0170:
            r11 = r7
        L_0x0171:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r12) goto L_0x018e
            if (r11 == 0) goto L_0x018e
            java.lang.String r13 = "null cannot be cast to non-null type android.telephony.CellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r13)
            boolean r10 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellInfo) r10, (android.telephony.CellIdentity) r4)
            if (r10 != 0) goto L_0x018e
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = com.m2catalyst.m2sdk.m4.a()
            java.lang.String[] r11 = new java.lang.String[r6]
            java.lang.String r13 = "NetworkUtils getSignalStrength isCellInfoCiMatch NO MATCH cannot use CellInfo for SignalStrength"
            r10.d(r8, r13, r11)
        L_0x018d:
            r11 = r7
        L_0x018e:
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 < r9) goto L_0x01c1
            android.telephony.SignalStrength r9 = r15.j()
            if (r9 == 0) goto L_0x01bd
            java.util.List r9 = r9.getCellSignalStrengths()
            if (r9 == 0) goto L_0x01bd
            java.lang.String r10 = "cellSignalStrengths"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.util.Iterator r9 = r9.iterator()
        L_0x01a7:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01b9
            java.lang.Object r10 = r9.next()
            r13 = r10
            android.telephony.CellSignalStrength r13 = (android.telephony.CellSignalStrength) r13
            boolean r13 = r13 instanceof android.telephony.CellSignalStrengthNr
            if (r13 == 0) goto L_0x01a7
            goto L_0x01ba
        L_0x01b9:
            r10 = r7
        L_0x01ba:
            android.telephony.CellSignalStrength r10 = (android.telephony.CellSignalStrength) r10
            goto L_0x01be
        L_0x01bd:
            r10 = r7
        L_0x01be:
            android.telephony.CellSignalStrengthNr r10 = (android.telephony.CellSignalStrengthNr) r10
            goto L_0x01c2
        L_0x01c1:
            r10 = r7
        L_0x01c2:
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r11, r10)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r11 = r17
            kotlin.Pair r9 = r14.a(r10, r9, (com.m2catalyst.m2sdk.c3) r15, (com.m2catalyst.m2sdk.c3) r11)
            if (r4 == 0) goto L_0x0389
            java.lang.Object r10 = r9.getSecond()
            if (r10 == 0) goto L_0x0389
            java.lang.Object r10 = r9.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            long r10 = r10.longValue()
            java.lang.Object r13 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            android.telephony.CellSignalStrength r13 = (android.telephony.CellSignalStrength) r13
            com.m2catalyst.m2sdk.business.models.MNSI r10 = r14.a((com.m2catalyst.m2sdk.c3) r15, (long) r10, (android.telephony.CellSignalStrength) r13)
            java.lang.Object r9 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.telephony.CellSignalStrengthNr r9 = (android.telephony.CellSignalStrengthNr) r9
            java.lang.String r11 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            java.lang.String r11 = "signalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            int r2 = r9.getAsuLevel()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrAsuLevel(r2)
            int r2 = r9.getCsiRsrp()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrCsiRsrp(r2)
            int r2 = r9.getCsiRsrq()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrCsiRsrq(r2)
            int r2 = r9.getCsiSinr()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrCsiSinr(r2)
            int r2 = r9.getSsRsrp()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrSsRsrp(r2)
            int r2 = r9.getSsRsrq()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrSsRsrq(r2)
            int r2 = r9.getSsSinr()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrSsSinr(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrDbm(r2)
            java.lang.Integer r2 = r10.getNrDbm()
            r10.setDbm(r2)
            int r2 = r9.getLevel()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrLevel(r2)
            java.lang.Long r2 = com.m2catalyst.m2sdk.m4.a((com.m2catalyst.m2sdk.c3) r15)
            r10.setCelltowerInfoTimestamp(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r12) goto L_0x0286
            int[] r2 = r4.getBands()
            r10.setNrBand(r2)
        L_0x0286:
            long r11 = r4.getNci()
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            r10.setNrNci(r2)
            int r2 = r4.getNrarfcn()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrArfcn(r2)
            int r2 = r4.getPci()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrPci(r2)
            int r2 = r4.getTac()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrTac(r2)
            java.lang.Integer r2 = r10.getNrPci()
            if (r2 != 0) goto L_0x02b9
            goto L_0x02bf
        L_0x02b9:
            int r2 = r2.intValue()
            if (r2 == 0) goto L_0x02cc
        L_0x02bf:
            java.lang.Integer r2 = r10.getNrTac()
            if (r2 != 0) goto L_0x02c6
            goto L_0x0325
        L_0x02c6:
            int r2 = r2.intValue()
            if (r2 != 0) goto L_0x0325
        L_0x02cc:
            java.util.List<? extends android.telephony.CellInfo> r1 = r1.g
            com.m2catalyst.m2sdk.t r2 = com.m2catalyst.m2sdk.t.c
            android.telephony.CellInfo r1 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r1, (com.m2catalyst.m2sdk.t) r2)
            if (r1 == 0) goto L_0x0325
            boolean r2 = r1 instanceof android.telephony.CellInfoNr
            if (r2 == 0) goto L_0x0325
            android.telephony.CellInfoNr r1 = (android.telephony.CellInfoNr) r1
            android.telephony.CellIdentity r1 = r1.getCellIdentity()
            java.lang.String r2 = "null cannot be cast to non-null type android.telephony.CellIdentityNr"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.telephony.CellIdentityNr r1 = (android.telephony.CellIdentityNr) r1
            java.lang.String r2 = r4.getMccString()
            java.lang.String r9 = r1.getMccString()
            boolean r2 = kotlin.text.StringsKt.equals(r2, r9, r5)
            if (r2 == 0) goto L_0x0325
            java.lang.String r2 = r4.getMncString()
            java.lang.String r9 = r1.getMncString()
            boolean r2 = kotlin.text.StringsKt.equals(r2, r9, r5)
            if (r2 == 0) goto L_0x0325
            int r2 = r1.getPci()
            if (r2 <= 0) goto L_0x0314
            int r2 = r1.getPci()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setNrPci(r2)
        L_0x0314:
            int r2 = r1.getTac()
            if (r2 <= 0) goto L_0x0325
            int r1 = r1.getTac()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setNrTac(r1)
        L_0x0325:
            long r1 = r4.getNci()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r10.setCellIdentifier(r1)
            r1 = r16
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r10, (com.m2catalyst.m2sdk.business.models.M2Location) r1)
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r1)
            com.m2catalyst.m2sdk.external.SDKState$Companion r2 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r2 = r2.getInstance()
            r2.setRawMNSI(r1)
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r4 = "CellInfoStrategyNrMin29 has CI and SS"
            r3.d(r8, r4, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "CellInfoStrategyNrMin29 "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r4 = new java.lang.String[r6]
            r3.d(r8, r2, r4)
            boolean r2 = r14.b(r1)
            if (r2 == 0) goto L_0x0389
            r2 = r18
            boolean r2 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.MNSI) r2)
            if (r2 == 0) goto L_0x036c
            goto L_0x036d
        L_0x036c:
            r5 = 2
        L_0x036d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "CellInfoStrategyNrMin29 HAS_MIN_VALUES canBeSaved= "
            r2.<init>(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r4 = new java.lang.String[r6]
            r3.d(r8, r2, r4)
            kotlin.Pair r7 = new kotlin.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r7.<init>(r2, r1)
        L_0x0389:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.s.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.MNSI):kotlin.Pair");
    }

    public final b5 a(b5 b5Var, MNSI mnsi) {
        Intrinsics.checkNotNullParameter(b5Var, "<this>");
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        if (!c(mnsi)) {
            Intrinsics.checkNotNullParameter("RF_NR", IronSourceConstants.EVENTS_ERROR_REASON);
            b5Var.b.add("RF_NR");
            b5Var.c = false;
        }
        return b5Var;
    }

    public final MNSI a(MNSI mnsi, c3 c3Var) {
        int i;
        NetworkInfoSnapshot networkInfoSnapshot;
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        if (c3Var.r() && (networkInfoSnapshot = c3Var.k) != null) {
            mnsi.setRoaming(networkInfoSnapshot.getRoaming());
            mnsi.setNetworkMcc(networkInfoSnapshot.getNetworkMcc());
            mnsi.setNetworkMnc(networkInfoSnapshot.getNetworkMnc());
            mnsi.setNetworkOperatorName(networkInfoSnapshot.getNetworkOperatorName());
            mnsi.setNetworkCountryIso(networkInfoSnapshot.getNetworkCountryIso());
        }
        NetworkInfoSnapshot networkInfoSnapshot2 = c3Var.k;
        if (networkInfoSnapshot2 != null && c3Var.a(networkInfoSnapshot2.getPhoneType())) {
            mnsi.setPhoneType(networkInfoSnapshot2.getPhoneType());
        }
        ServiceState serviceState = c3Var.i;
        if (serviceState != null) {
            mnsi.setRoaming(Boolean.valueOf(serviceState.getRoaming()));
            Context context = this.a;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                i = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
            } catch (RuntimeException unused) {
                i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (i == 0) {
                mnsi.setNetworkOperatorName(serviceState.getOperatorAlphaLong());
            }
        }
        Pair<String, String> b = Build.VERSION.SDK_INT >= 30 ? m4.b(c3Var.i) : null;
        if (m4.a(b)) {
            Intrinsics.checkNotNull(b);
            String first = b.getFirst();
            Intrinsics.checkNotNull(first);
            mnsi.setNetworkMcc(Integer.valueOf(Integer.parseInt(first)));
            String second = b.getSecond();
            Intrinsics.checkNotNull(second);
            mnsi.setNetworkMnc(Integer.valueOf(Integer.parseInt(second)));
            return mnsi;
        }
        Pair<String, String> a = m4.a(m4.a(c3Var.g, t.c));
        if (m4.a(a)) {
            String first2 = a.getFirst();
            Intrinsics.checkNotNull(first2);
            mnsi.setNetworkMcc(Integer.valueOf(Integer.parseInt(first2)));
            String second2 = a.getSecond();
            Intrinsics.checkNotNull(second2);
            mnsi.setNetworkMnc(Integer.valueOf(Integer.parseInt(second2)));
        }
        return mnsi;
    }
}
