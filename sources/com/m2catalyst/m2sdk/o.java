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

/* compiled from: CellInfoStrategyLteMin29.kt */
public final class o extends i<CellSignalStrengthLte, CellIdentityLte, Object> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final t a() {
        return t.a;
    }

    public final boolean a(int i) {
        return i == 29;
    }

    public final boolean c(MNSI mnsi) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        if (i.a((i) this, mnsi.getLteRsrp(), 3) && i.a((i) this, mnsi.getLteRsrq(), 3) && i.a((i) this, mnsi.getLteRssnr(), 1) && i.a((i) this, mnsi.getLteDbm(), 3) && mnsi.getLteDbm() != null) {
            Integer lteDbm = mnsi.getLteDbm();
            Intrinsics.checkNotNull(lteDbm);
            if (lteDbm.intValue() >= 0 || !i.a((i) this, mnsi.getLteCi(), 3)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02da, code lost:
        if ((r11.length == 0) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, com.m2catalyst.m2sdk.business.models.MNSI> a(com.m2catalyst.m2sdk.c3 r17, com.m2catalyst.m2sdk.business.models.M2Location r18, com.m2catalyst.m2sdk.c3 r19, com.m2catalyst.m2sdk.business.models.MNSI r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r17.o()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r4 = "MNSI"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r3.getLogger(r4)
            r4 = 0
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = "MNSI_BUILDER"
            java.lang.String r7 = "CellInfoStrategyLteMin29 "
            r3.d(r6, r7, r5)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r5 = r17.h()
            r8 = 0
            if (r5 != 0) goto L_0x0026
            return r8
        L_0x0026:
            com.m2catalyst.m2sdk.t r5 = com.m2catalyst.m2sdk.t.a
            java.util.List r9 = r17.f()
            android.telephony.CellInfo r5 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r9, (com.m2catalyst.m2sdk.t) r5)
            android.telephony.ServiceState r9 = r17.i()
            r10 = 30
            r11 = 29
            r12 = 1
            if (r9 == 0) goto L_0x007a
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r10) goto L_0x007a
            java.util.List r5 = r9.getNetworkRegistrationInfoList()
            java.lang.String r9 = "serviceState.networkRegistrationInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.util.Iterator r5 = r5.iterator()
        L_0x004c:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x006b
            java.lang.Object r9 = r5.next()
            r13 = r9
            android.telephony.NetworkRegistrationInfo r13 = (android.telephony.NetworkRegistrationInfo) r13
            boolean r14 = r13.isRegistered()
            if (r14 == 0) goto L_0x0067
            android.telephony.CellIdentity r13 = r13.getCellIdentity()
            if (r13 == 0) goto L_0x0067
            r13 = 1
            goto L_0x0068
        L_0x0067:
            r13 = 0
        L_0x0068:
            if (r13 == 0) goto L_0x004c
            goto L_0x006c
        L_0x006b:
            r9 = r8
        L_0x006c:
            android.telephony.NetworkRegistrationInfo r9 = (android.telephony.NetworkRegistrationInfo) r9
            if (r9 == 0) goto L_0x0075
            android.telephony.CellIdentity r5 = r9.getCellIdentity()
            goto L_0x0076
        L_0x0075:
            r5 = r8
        L_0x0076:
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00e5
        L_0x007a:
            if (r5 == 0) goto L_0x00ce
            boolean r13 = r5 instanceof android.telephony.CellInfoCdma
            if (r13 == 0) goto L_0x0089
            android.telephony.CellInfoCdma r5 = (android.telephony.CellInfoCdma) r5
            android.telephony.CellIdentityCdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00cf
        L_0x0089:
            boolean r13 = r5 instanceof android.telephony.CellInfoGsm
            if (r13 == 0) goto L_0x0096
            android.telephony.CellInfoGsm r5 = (android.telephony.CellInfoGsm) r5
            android.telephony.CellIdentityGsm r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00cf
        L_0x0096:
            boolean r13 = r5 instanceof android.telephony.CellInfoLte
            if (r13 == 0) goto L_0x00a1
            android.telephony.CellInfoLte r5 = (android.telephony.CellInfoLte) r5
            android.telephony.CellIdentityLte r5 = r5.getCellIdentity()
            goto L_0x00cf
        L_0x00a1:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x00b2
            boolean r14 = r5 instanceof android.telephony.CellInfoNr
            if (r14 == 0) goto L_0x00b2
            android.telephony.CellInfoNr r5 = (android.telephony.CellInfoNr) r5
            android.telephony.CellIdentity r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00cf
        L_0x00b2:
            if (r13 < r11) goto L_0x00c1
            boolean r13 = r5 instanceof android.telephony.CellInfoTdscdma
            if (r13 == 0) goto L_0x00c1
            android.telephony.CellInfoTdscdma r5 = (android.telephony.CellInfoTdscdma) r5
            android.telephony.CellIdentityTdscdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00cf
        L_0x00c1:
            boolean r13 = r5 instanceof android.telephony.CellInfoWcdma
            if (r13 == 0) goto L_0x00ce
            android.telephony.CellInfoWcdma r5 = (android.telephony.CellInfoWcdma) r5
            android.telephony.CellIdentityWcdma r5 = r5.getCellIdentity()
            android.telephony.CellIdentityLte r5 = (android.telephony.CellIdentityLte) r5
            goto L_0x00cf
        L_0x00ce:
            r5 = r8
        L_0x00cf:
            if (r5 == 0) goto L_0x00e5
            java.lang.Class r13 = r5.getClass()
            java.lang.String r13 = r13.getSimpleName()
            java.lang.String r14 = "cellIdentity::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            boolean r9 = com.m2catalyst.m2sdk.m4.a((android.telephony.ServiceState) r9, (java.lang.String) r13)
            if (r9 != 0) goto L_0x00e5
            r5 = r8
        L_0x00e5:
            com.m2catalyst.m2sdk.t r9 = com.m2catalyst.m2sdk.t.a
            java.util.List r13 = r17.f()
            if (r13 == 0) goto L_0x00f6
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r13 = 0
            goto L_0x00f7
        L_0x00f6:
            r13 = 1
        L_0x00f7:
            if (r13 != 0) goto L_0x0176
            java.util.List r13 = r17.f()
            android.telephony.CellInfo r9 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r13, (com.m2catalyst.m2sdk.t) r9)
            boolean r13 = r9 instanceof android.telephony.CellInfoCdma
            if (r13 == 0) goto L_0x010f
            r13 = r9
            android.telephony.CellInfoCdma r13 = (android.telephony.CellInfoCdma) r13
            android.telephony.CellSignalStrengthCdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x015a
        L_0x010f:
            boolean r13 = r9 instanceof android.telephony.CellInfoGsm
            if (r13 == 0) goto L_0x011d
            r13 = r9
            android.telephony.CellInfoGsm r13 = (android.telephony.CellInfoGsm) r13
            android.telephony.CellSignalStrengthGsm r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x015a
        L_0x011d:
            boolean r13 = r9 instanceof android.telephony.CellInfoLte
            if (r13 == 0) goto L_0x0129
            r13 = r9
            android.telephony.CellInfoLte r13 = (android.telephony.CellInfoLte) r13
            android.telephony.CellSignalStrengthLte r13 = r13.getCellSignalStrength()
            goto L_0x015a
        L_0x0129:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x013b
            boolean r14 = r9 instanceof android.telephony.CellInfoNr
            if (r14 == 0) goto L_0x013b
            r13 = r9
            android.telephony.CellInfoNr r13 = (android.telephony.CellInfoNr) r13
            android.telephony.CellSignalStrength r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x015a
        L_0x013b:
            if (r13 < r11) goto L_0x014b
            boolean r13 = r9 instanceof android.telephony.CellInfoTdscdma
            if (r13 == 0) goto L_0x014b
            r13 = r9
            android.telephony.CellInfoTdscdma r13 = (android.telephony.CellInfoTdscdma) r13
            android.telephony.CellSignalStrengthTdscdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x015a
        L_0x014b:
            boolean r13 = r9 instanceof android.telephony.CellInfoWcdma
            if (r13 == 0) goto L_0x0159
            r13 = r9
            android.telephony.CellInfoWcdma r13 = (android.telephony.CellInfoWcdma) r13
            android.telephony.CellSignalStrengthWcdma r13 = r13.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r13 = (android.telephony.CellSignalStrengthLte) r13
            goto L_0x015a
        L_0x0159:
            r13 = r8
        L_0x015a:
            int r14 = android.os.Build.VERSION.SDK_INT
            if (r14 < r10) goto L_0x0177
            if (r13 == 0) goto L_0x0177
            java.lang.String r10 = "null cannot be cast to non-null type android.telephony.CellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r10)
            boolean r9 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellInfo) r9, (android.telephony.CellIdentity) r5)
            if (r9 != 0) goto L_0x0177
            com.m2catalyst.m2sdk.logger.M2SDKLogger r9 = com.m2catalyst.m2sdk.m4.a()
            java.lang.String[] r10 = new java.lang.String[r4]
            java.lang.String r13 = "NetworkUtils getSignalStrength isCellInfoCiMatch NO MATCH cannot use CellInfo for SignalStrength"
            r9.d(r6, r13, r10)
        L_0x0176:
            r13 = r8
        L_0x0177:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r11) goto L_0x01aa
            android.telephony.SignalStrength r9 = r17.j()
            if (r9 == 0) goto L_0x01a6
            java.util.List r9 = r9.getCellSignalStrengths()
            if (r9 == 0) goto L_0x01a6
            java.lang.String r10 = "cellSignalStrengths"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.util.Iterator r9 = r9.iterator()
        L_0x0190:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01a2
            java.lang.Object r10 = r9.next()
            r11 = r10
            android.telephony.CellSignalStrength r11 = (android.telephony.CellSignalStrength) r11
            boolean r11 = r11 instanceof android.telephony.CellSignalStrengthLte
            if (r11 == 0) goto L_0x0190
            goto L_0x01a3
        L_0x01a2:
            r10 = r8
        L_0x01a3:
            android.telephony.CellSignalStrength r10 = (android.telephony.CellSignalStrength) r10
            goto L_0x01a7
        L_0x01a6:
            r10 = r8
        L_0x01a7:
            android.telephony.CellSignalStrengthLte r10 = (android.telephony.CellSignalStrengthLte) r10
            goto L_0x01ab
        L_0x01aa:
            r10 = r8
        L_0x01ab:
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r13, r10)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r11 = r19
            kotlin.Pair r9 = r0.a(r10, r9, (com.m2catalyst.m2sdk.c3) r1, (com.m2catalyst.m2sdk.c3) r11)
            if (r5 == 0) goto L_0x0468
            java.lang.Object r10 = r9.getSecond()
            if (r10 == 0) goto L_0x0468
            java.lang.Object r10 = r9.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            long r10 = r10.longValue()
            java.lang.Object r13 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            android.telephony.CellSignalStrength r13 = (android.telephony.CellSignalStrength) r13
            com.m2catalyst.m2sdk.business.models.MNSI r10 = r0.a((com.m2catalyst.m2sdk.c3) r1, (long) r10, (android.telephony.CellSignalStrength) r13)
            java.lang.Object r9 = r9.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.telephony.CellSignalStrengthLte r9 = (android.telephony.CellSignalStrengthLte) r9
            java.lang.String r11 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            java.lang.String r11 = "signalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r2 = r9.getAsuLevel()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteAsu(r2)
            java.lang.Integer r2 = r10.getLteAsu()
            r10.setAsu(r2)
            java.lang.Integer r2 = r10.getLteRsrp()
            r10.setRsrp(r2)
            java.lang.Integer r2 = r10.getLteRsrq()
            r10.setRsrq(r2)
            int r2 = r9.getLevel()
            r10.setLevel(r2)
            int r2 = r9.getRssnr()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteRssnr(r2)
            int r2 = r9.getCqi()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteCqi(r2)
            int r2 = r9.getRsrp()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteRsrp(r2)
            int r2 = r9.getRsrq()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteRsrq(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteDbm(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setDbm(r2)
            int r2 = r9.getDbm()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteSignalStrength(r2)
            int r2 = r9.getRssi()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.setLteRssi(r2)
            int r2 = r9.getTimingAdvance()
            r11 = 1829(0x725, float:2.563E-42)
            if (r2 < 0) goto L_0x027e
            if (r2 >= r11) goto L_0x027e
            r2 = 1
            goto L_0x027f
        L_0x027e:
            r2 = 0
        L_0x027f:
            if (r2 == 0) goto L_0x028a
            int r2 = r9.getTimingAdvance()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x028b
        L_0x028a:
            r2 = r8
        L_0x028b:
            r10.setLteTimingAdvance(r2)
            java.util.List<? extends android.telephony.CellInfo> r2 = r1.g
            com.m2catalyst.m2sdk.t r13 = com.m2catalyst.m2sdk.t.a
            android.telephony.CellInfo r2 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r2, (com.m2catalyst.m2sdk.t) r13)
            if (r2 == 0) goto L_0x02c6
            boolean r14 = r2 instanceof android.telephony.CellInfoLte
            if (r14 == 0) goto L_0x02c6
            android.telephony.CellInfoLte r2 = (android.telephony.CellInfoLte) r2
            android.telephony.CellSignalStrengthLte r14 = r2.getCellSignalStrength()
            java.lang.String r15 = "cellInfo.cellSignalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            int r15 = r14.getTimingAdvance()
            if (r15 < 0) goto L_0x02b1
            if (r15 >= r11) goto L_0x02b1
            r11 = 1
            goto L_0x02b2
        L_0x02b1:
            r11 = 0
        L_0x02b2:
            if (r11 == 0) goto L_0x02bd
            int r11 = r14.getTimingAdvance()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x02be
        L_0x02bd:
            r11 = r8
        L_0x02be:
            r10.setLteTimingAdvance(r11)
            android.telephony.CellIdentityLte r2 = r2.getCellIdentity()
            goto L_0x02c7
        L_0x02c6:
            r2 = r8
        L_0x02c7:
            java.lang.Long r11 = com.m2catalyst.m2sdk.m4.a((com.m2catalyst.m2sdk.c3) r17)
            r10.setCelltowerInfoTimestamp(r11)
            int[] r11 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellIdentityLte) r5)
            if (r11 == 0) goto L_0x02dc
            int r14 = r11.length
            if (r14 != 0) goto L_0x02d9
            r14 = 1
            goto L_0x02da
        L_0x02d9:
            r14 = 0
        L_0x02da:
            if (r14 == 0) goto L_0x02e2
        L_0x02dc:
            if (r2 == 0) goto L_0x02e2
            int[] r11 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellIdentityLte) r2)
        L_0x02e2:
            r10.setLteBand(r11)
            int r11 = r5.getEarfcn()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setLteEarfcn(r11)
            int r11 = r5.getCi()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setLteCi(r11)
            int r11 = r5.getPci()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setLtePci(r11)
            int r11 = r5.getTac()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setLteTac(r11)
            java.lang.Integer r11 = r10.getLtePci()
            if (r11 != 0) goto L_0x0318
            goto L_0x031e
        L_0x0318:
            int r11 = r11.intValue()
            if (r11 == 0) goto L_0x032b
        L_0x031e:
            java.lang.Integer r11 = r10.getLteTac()
            if (r11 != 0) goto L_0x0325
            goto L_0x0372
        L_0x0325:
            int r11 = r11.intValue()
            if (r11 != 0) goto L_0x0372
        L_0x032b:
            java.util.List<? extends android.telephony.CellInfo> r1 = r1.g
            android.telephony.CellInfo r1 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r1, (com.m2catalyst.m2sdk.t) r13)
            if (r1 == 0) goto L_0x0372
            boolean r11 = r1 instanceof android.telephony.CellInfoLte
            if (r11 == 0) goto L_0x0372
            android.telephony.CellInfoLte r1 = (android.telephony.CellInfoLte) r1
            android.telephony.CellIdentityLte r1 = r1.getCellIdentity()
            java.lang.String r11 = "cellInfo.cellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
            java.lang.String r11 = r5.getMobileNetworkOperator()
            java.lang.String r13 = r1.getMobileNetworkOperator()
            boolean r11 = kotlin.text.StringsKt.equals(r11, r13, r12)
            if (r11 == 0) goto L_0x0372
            int r11 = r1.getPci()
            if (r11 <= 0) goto L_0x0361
            int r11 = r1.getPci()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setLtePci(r11)
        L_0x0361:
            int r11 = r1.getTac()
            if (r11 <= 0) goto L_0x0372
            int r1 = r1.getTac()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteTac(r1)
        L_0x0372:
            int r1 = r5.getCi()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setCid(r1)
            int r1 = r5.getTac()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLac(r1)
            int r1 = r5.getBandwidth()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            if (r1 == 0) goto L_0x0398
            int r5 = r1.intValue()
            if (r5 != 0) goto L_0x03a2
        L_0x0398:
            if (r2 == 0) goto L_0x03a2
            int r1 = r2.getBandwidth()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x03a2:
            r10.setLteBandwidth(r1)
            java.lang.Integer r1 = r10.getLteCi()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r10.setCellIdentifier(r1)
            int r1 = r9.getDbm()
            int r1 = r1 / -10
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r5 = "samsung"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0410
            r2 = -140(0xffffffffffffff74, float:NaN)
            if (r1 < r2) goto L_0x0410
            r2 = -40
            if (r1 > r2) goto L_0x0410
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r10.setLteDbm(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteRsrp(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x03f4
            int r1 = r9.getRsrq()
            int r1 = r1 / -10
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteRsrq(r1)
            int r1 = r9.getRssnr()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.setLteRssnr(r1)
        L_0x03f4:
            java.lang.Integer r1 = r10.getLteDbm()
            r10.setLteSignalStrength(r1)
            java.lang.Integer r1 = r10.getLteRsrp()
            r10.setRsrp(r1)
            java.lang.Integer r1 = r10.getLteRsrq()
            r10.setRsrq(r1)
            java.lang.Integer r1 = r10.getLteDbm()
            r10.setDbm(r1)
        L_0x0410:
            r1 = r18
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r0.a((com.m2catalyst.m2sdk.business.models.MNSI) r10, (com.m2catalyst.m2sdk.business.models.M2Location) r1)
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r0.a((com.m2catalyst.m2sdk.business.models.MNSI) r1)
            com.m2catalyst.m2sdk.external.SDKState$Companion r2 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r2 = r2.getInstance()
            r2.setRawMNSI(r1)
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r5 = "CellInfoStrategyLteMin29 has CI and SS"
            r3.d(r6, r5, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r5 = new java.lang.String[r4]
            r3.d(r6, r2, r5)
            boolean r2 = r0.b(r1)
            if (r2 == 0) goto L_0x0468
            r2 = r20
            boolean r2 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.MNSI) r2)
            if (r2 == 0) goto L_0x044a
            goto L_0x044b
        L_0x044a:
            r12 = 2
        L_0x044b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "CellInfoStrategyLteMin29 HAS_MIN_VALUES canBeSaved= "
            r2.<init>(r5)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r4 = new java.lang.String[r4]
            r3.d(r6, r2, r4)
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.<init>(r3, r1)
            return r2
        L_0x0468:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.o.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.MNSI):kotlin.Pair");
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
