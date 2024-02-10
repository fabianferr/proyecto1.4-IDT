package com.m2catalyst.m2sdk;

import android.content.Context;
import android.telephony.CellIdentityLte;
import android.telephony.CellSignalStrengthLte;
import android.telephony.ServiceState;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategyLteMin17.kt */
public final class m extends i<CellSignalStrengthLte, CellIdentityLte, Object> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final t a() {
        return t.a;
    }

    public final boolean a(int i) {
        return i < 26;
    }

    public final boolean c(MNSI mnsi) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (i.a((i) this, mnsi.getLteRsrp(), 3) && i.a((i) this, mnsi.getLteRsrq(), 3) && i.a((i) this, mnsi.getLteDbm(), 3) && mnsi.getLteDbm() != null) {
            Integer lteDbm = mnsi.getLteDbm();
            Intrinsics.checkNotNull(lteDbm);
            return lteDbm.intValue() < 0 && i.a((i) this, mnsi.getLteCi(), 3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, com.m2catalyst.m2sdk.business.models.MNSI> a(com.m2catalyst.m2sdk.c3 r16, com.m2catalyst.m2sdk.business.models.M2Location r17, com.m2catalyst.m2sdk.c3 r18, com.m2catalyst.m2sdk.business.models.MNSI r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            java.lang.String r2 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r16.o()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r4 = "MNSI"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r3.getLogger(r4)
            r4 = 0
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = "MNSI_BUILDER"
            java.lang.String r7 = "CellInfoStrategyLteMin17 "
            r3.d(r6, r7, r5)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r5 = r16.h()
            r8 = 0
            if (r5 != 0) goto L_0x0025
            return r8
        L_0x0025:
            com.m2catalyst.m2sdk.t r5 = com.m2catalyst.m2sdk.t.a
            java.util.List r9 = r16.f()
            android.telephony.CellInfo r5 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r9, (com.m2catalyst.m2sdk.t) r5)
            android.telephony.ServiceState r9 = r16.i()
            r10 = 30
            r11 = 1
            r12 = 29
            if (r9 == 0) goto L_0x0079
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r10) goto L_0x0079
            java.util.List r5 = r9.getNetworkRegistrationInfoList()
            java.lang.String r9 = "serviceState.networkRegistrationInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.util.Iterator r5 = r5.iterator()
        L_0x004b:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x006a
            java.lang.Object r9 = r5.next()
            r13 = r9
            android.telephony.NetworkRegistrationInfo r13 = (android.telephony.NetworkRegistrationInfo) r13
            boolean r14 = r13.isRegistered()
            if (r14 == 0) goto L_0x0066
            android.telephony.CellIdentity r13 = r13.getCellIdentity()
            if (r13 == 0) goto L_0x0066
            r13 = 1
            goto L_0x0067
        L_0x0066:
            r13 = 0
        L_0x0067:
            if (r13 == 0) goto L_0x004b
            goto L_0x006b
        L_0x006a:
            r9 = r8
        L_0x006b:
            android.telephony.NetworkRegistrationInfo r9 = (android.telephony.NetworkRegistrationInfo) r9
            if (r9 == 0) goto L_0x0074
            android.telephony.CellIdentity r5 = r9.getCellIdentity()
            goto L_0x0075
        L_0x0074:
            r5 = r8
        L_0x0075:
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00e4
        L_0x0079:
            if (r5 == 0) goto L_0x00cd
            boolean r13 = r5 instanceof android.telephony.CellInfoCdma
            if (r13 == 0) goto L_0x0088
            android.telephony.CellInfoCdma r5 = (android.telephony.CellInfoCdma) r5
            android.telephony.CellIdentityCdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00ce
        L_0x0088:
            boolean r13 = r5 instanceof android.telephony.CellInfoGsm
            if (r13 == 0) goto L_0x0095
            android.telephony.CellInfoGsm r5 = (android.telephony.CellInfoGsm) r5
            android.telephony.CellIdentityGsm r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00ce
        L_0x0095:
            boolean r13 = r5 instanceof android.telephony.CellInfoLte
            if (r13 == 0) goto L_0x00a0
            android.telephony.CellInfoLte r5 = (android.telephony.CellInfoLte) r5
            android.telephony.CellIdentityLte r5 = r5.getCellIdentity()
            goto L_0x00ce
        L_0x00a0:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r12) goto L_0x00b1
            boolean r14 = r5 instanceof android.telephony.CellInfoNr
            if (r14 == 0) goto L_0x00b1
            android.telephony.CellInfoNr r5 = (android.telephony.CellInfoNr) r5
            android.telephony.CellIdentity r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00ce
        L_0x00b1:
            if (r13 < r12) goto L_0x00c0
            boolean r13 = r5 instanceof android.telephony.CellInfoTdscdma
            if (r13 == 0) goto L_0x00c0
            android.telephony.CellInfoTdscdma r5 = (android.telephony.CellInfoTdscdma) r5
            android.telephony.CellIdentityTdscdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00ce
        L_0x00c0:
            boolean r13 = r5 instanceof android.telephony.CellInfoWcdma
            if (r13 == 0) goto L_0x00cd
            android.telephony.CellInfoWcdma r5 = (android.telephony.CellInfoWcdma) r5
            android.telephony.CellIdentityWcdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00ce
        L_0x00cd:
            r5 = r8
        L_0x00ce:
            if (r5 == 0) goto L_0x00e4
            java.lang.Class r13 = r5.getClass()
            java.lang.String r13 = r13.getSimpleName()
            java.lang.String r14 = "cellIdentity::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            boolean r9 = com.m2catalyst.m2sdk.m4.a((android.telephony.ServiceState) r9, (java.lang.String) r13)
            if (r9 != 0) goto L_0x00e4
            r5 = r8
        L_0x00e4:
            com.m2catalyst.m2sdk.t r9 = com.m2catalyst.m2sdk.t.a
            java.util.List r13 = r16.f()
            if (r13 == 0) goto L_0x00f5
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r13 = 0
            goto L_0x00f6
        L_0x00f5:
            r13 = 1
        L_0x00f6:
            if (r13 != 0) goto L_0x0175
            java.util.List r13 = r16.f()
            android.telephony.CellInfo r9 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r13, (com.m2catalyst.m2sdk.t) r9)
            boolean r13 = r9 instanceof android.telephony.CellInfoCdma
            if (r13 == 0) goto L_0x010e
            r13 = r9
            android.telephony.CellInfoCdma r13 = (android.telephony.CellInfoCdma) r13
            android.telephony.CellSignalStrengthCdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x0159
        L_0x010e:
            boolean r13 = r9 instanceof android.telephony.CellInfoGsm
            if (r13 == 0) goto L_0x011c
            r13 = r9
            android.telephony.CellInfoGsm r13 = (android.telephony.CellInfoGsm) r13
            android.telephony.CellSignalStrengthGsm r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x0159
        L_0x011c:
            boolean r13 = r9 instanceof android.telephony.CellInfoLte
            if (r13 == 0) goto L_0x0128
            r13 = r9
            android.telephony.CellInfoLte r13 = (android.telephony.CellInfoLte) r13
            android.telephony.CellSignalStrengthLte r13 = r13.getCellSignalStrength()
            goto L_0x0159
        L_0x0128:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r12) goto L_0x013a
            boolean r14 = r9 instanceof android.telephony.CellInfoNr
            if (r14 == 0) goto L_0x013a
            r13 = r9
            android.telephony.CellInfoNr r13 = (android.telephony.CellInfoNr) r13
            android.telephony.CellSignalStrength r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x0159
        L_0x013a:
            if (r13 < r12) goto L_0x014a
            boolean r13 = r9 instanceof android.telephony.CellInfoTdscdma
            if (r13 == 0) goto L_0x014a
            r13 = r9
            android.telephony.CellInfoTdscdma r13 = (android.telephony.CellInfoTdscdma) r13
            android.telephony.CellSignalStrengthTdscdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x0159
        L_0x014a:
            boolean r13 = r9 instanceof android.telephony.CellInfoWcdma
            if (r13 == 0) goto L_0x0158
            r13 = r9
            android.telephony.CellInfoWcdma r13 = (android.telephony.CellInfoWcdma) r13
            android.telephony.CellSignalStrengthWcdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x0159
        L_0x0158:
            r13 = r8
        L_0x0159:
            int r14 = android.os.Build.VERSION.SDK_INT
            if (r14 < r10) goto L_0x0176
            if (r13 == 0) goto L_0x0176
            java.lang.String r10 = "null cannot be cast to non-null type android.telephony.CellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r10)
            boolean r9 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellInfo) r9, (android.telephony.CellIdentity) r5)
            if (r9 != 0) goto L_0x0176
            com.m2catalyst.m2sdk.logger.M2SDKLogger r9 = com.m2catalyst.m2sdk.m4.a()
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r13 = "NetworkUtils getSignalStrength isCellInfoCiMatch NO MATCH cannot use CellInfo for SignalStrength"
            r9.d(r6, r13, r10)
        L_0x0175:
            r13 = r8
        L_0x0176:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r12) goto L_0x01a9
            android.telephony.SignalStrength r9 = r16.j()
            if (r9 == 0) goto L_0x01a5
            java.util.List r9 = r9.getCellSignalStrengths()
            if (r9 == 0) goto L_0x01a5
            java.lang.String r10 = "cellSignalStrengths"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.util.Iterator r9 = r9.iterator()
        L_0x018f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01a1
            java.lang.Object r10 = r9.next()
            r12 = r10
            android.telephony.CellSignalStrength r12 = (android.telephony.CellSignalStrength) r12
            boolean r12 = r12 instanceof android.telephony.CellSignalStrengthLte
            if (r12 == 0) goto L_0x018f
            goto L_0x01a2
        L_0x01a1:
            r10 = r8
        L_0x01a2:
            android.telephony.CellSignalStrength r10 = (android.telephony.CellSignalStrength) r10
            goto L_0x01a6
        L_0x01a5:
            r10 = r8
        L_0x01a6:
            android.telephony.CellSignalStrengthLte r10 = (android.telephony.CellSignalStrengthLte) r10
            goto L_0x01aa
        L_0x01a9:
            r10 = r8
        L_0x01aa:
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r13, r10)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r12 = r18
            kotlin.Pair r9 = r15.a(r10, r9, (com.m2catalyst.m2sdk.c3) r1, (com.m2catalyst.m2sdk.c3) r12)
            if (r5 == 0) goto L_0x0394
            java.lang.Object r10 = r9.getSecond()
            if (r10 == 0) goto L_0x0394
            java.lang.Object r10 = r9.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            long r12 = r10.longValue()
            java.lang.Object r10 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            android.telephony.CellSignalStrength r10 = (android.telephony.CellSignalStrength) r10
            com.m2catalyst.m2sdk.business.models.MNSI r10 = r15.a((com.m2catalyst.m2sdk.c3) r1, (long) r12, (android.telephony.CellSignalStrength) r10)
            java.lang.Object r9 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.telephony.CellSignalStrengthLte r9 = (android.telephony.CellSignalStrengthLte) r9
            java.lang.String r12 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r12)
            java.lang.String r12 = "signalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r2 = r9.getAsuLevel()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteAsu(r2)
            java.lang.Integer r2 = r10.getLteAsu()
            r10.setAsu(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteRsrp(r2)
            java.lang.String r2 = "mRsrq"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteRsrq(r2)
            java.lang.String r2 = "mRssnr"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteRssnr(r2)
            java.lang.String r2 = "mCqi"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteCqi(r2)
            java.lang.String r2 = "mRssi"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteRssi(r2)
            java.lang.Integer r2 = r10.getLteRssnr()
            if (r2 != 0) goto L_0x0242
            java.lang.String r2 = "getLteRssnr"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteRssnr(r2)
        L_0x0242:
            java.lang.Integer r2 = r10.getLteSignalStrength()
            if (r2 != 0) goto L_0x0251
            java.lang.String r2 = "getLteSignalStrength"
            java.lang.Integer r2 = com.m2catalyst.m2sdk.c5.a(r2, r9)
            r10.setLteSignalStrength(r2)
        L_0x0251:
            java.lang.Integer r2 = r10.getLteRsrp()
            r10.setRsrp(r2)
            java.lang.Integer r2 = r10.getLteRsrq()
            r10.setRsrq(r2)
            int r2 = r9.getLevel()
            r10.setLevel(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteDbm(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteSignalStrength(r2)
            int r2 = r9.getTimingAdvance()
            if (r2 < 0) goto L_0x0288
            r12 = 1829(0x725, float:2.563E-42)
            if (r2 >= r12) goto L_0x0288
            r2 = 1
            goto L_0x0289
        L_0x0288:
            r2 = 0
        L_0x0289:
            if (r2 == 0) goto L_0x0294
            int r2 = r9.getTimingAdvance()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0295
        L_0x0294:
            r2 = r8
        L_0x0295:
            r10.setLteTimingAdvance(r2)
            java.lang.Long r1 = com.m2catalyst.m2sdk.m4.a((com.m2catalyst.m2sdk.c3) r16)
            r10.setCelltowerInfoTimestamp(r1)
            int[] r1 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellIdentityLte) r5)
            r10.setLteBand(r1)
            int r1 = r5.getEarfcn()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteEarfcn(r1)
            int r1 = r5.getCi()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteCi(r1)
            int r1 = r5.getPci()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLtePci(r1)
            int r1 = r5.getTac()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteTac(r1)
            int r1 = r5.getCi()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setCid(r1)
            int r1 = r5.getTac()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLac(r1)
            java.lang.Integer r1 = com.m2catalyst.m2sdk.m4.b((android.telephony.CellIdentityLte) r5)
            r10.setLteBandwidth(r1)
            java.lang.Integer r1 = r10.getLteCi()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r10.setCellIdentifier(r1)
            int r1 = r9.getDbm()
            int r1 = r1 / -10
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r5 = "samsung"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x033c
            r2 = -140(0xffffffffffffff74, float:NaN)
            if (r1 < r2) goto L_0x033c
            r2 = -40
            if (r1 > r2) goto L_0x033c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r10.setLteDbm(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteRsrp(r1)
            java.lang.Integer r1 = r10.getLteDbm()
            r10.setLteSignalStrength(r1)
            java.lang.Integer r1 = r10.getLteRsrp()
            r10.setRsrp(r1)
            java.lang.Integer r1 = r10.getLteRsrq()
            r10.setRsrq(r1)
            java.lang.Integer r1 = r10.getLteDbm()
            r10.setDbm(r1)
        L_0x033c:
            r1 = r17
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r15.a((com.m2catalyst.m2sdk.business.models.MNSI) r10, (com.m2catalyst.m2sdk.business.models.M2Location) r1)
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r15.a((com.m2catalyst.m2sdk.business.models.MNSI) r1)
            com.m2catalyst.m2sdk.external.SDKState$Companion r2 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r2 = r2.getInstance()
            r2.setRawMNSI(r1)
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r5 = "CellInfoStrategyLteMin17 has CI and SS"
            r3.d(r6, r5, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r5 = new java.lang.String[r4]
            r3.d(r6, r2, r5)
            boolean r2 = r15.b(r1)
            if (r2 == 0) goto L_0x0394
            r2 = r19
            boolean r2 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.MNSI) r2)
            if (r2 == 0) goto L_0x0376
            goto L_0x0377
        L_0x0376:
            r11 = 2
        L_0x0377:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "CellInfoStrategyLteMin17 HAS_MIN_VALUES canBeSaved= "
            r2.<init>(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r4 = new java.lang.String[r4]
            r3.d(r6, r2, r4)
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            r2.<init>(r3, r1)
            return r2
        L_0x0394:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.m.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.MNSI):kotlin.Pair");
    }

    public final b5 a(b5 b5Var, MNSI mnsi) {
        Intrinsics.checkNotNullParameter(b5Var, "<this>");
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        if (!c(mnsi)) {
            Intrinsics.checkNotNullParameter("RF_LTE", IronSourceConstants.EVENTS_ERROR_REASON);
            b5Var.b.add("RF_LTE");
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
        Pair<String, String> a = m4.a(m4.a(c3Var.g, t.a));
        if (m4.a(a)) {
            String first = a.getFirst();
            Intrinsics.checkNotNull(first);
            mnsi.setNetworkMcc(Integer.valueOf(Integer.parseInt(first)));
            String second = a.getSecond();
            Intrinsics.checkNotNull(second);
            mnsi.setNetworkMnc(Integer.valueOf(Integer.parseInt(second)));
        }
        return mnsi;
    }
}
