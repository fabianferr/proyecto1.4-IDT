package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityLte;
import android.telephony.CellSignalStrengthLte;
import android.telephony.ServiceState;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.DataCompleteness;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategyLteMin30.kt */
public final class p extends i<CellSignalStrengthLte, CellIdentityLte, Object> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final t a() {
        return t.a;
    }

    public final boolean a(int i) {
        return i >= 30;
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

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0220 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0179  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, com.m2catalyst.m2sdk.business.models.MNSI> a(com.m2catalyst.m2sdk.c3 r15, com.m2catalyst.m2sdk.business.models.M2Location r16, com.m2catalyst.m2sdk.c3 r17, com.m2catalyst.m2sdk.business.models.MNSI r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            java.lang.String r2 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r15.o()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "MNSI"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r3)
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r5 = "MNSI_BUILDER"
            java.lang.String r6 = "CellInfoStrategyLteMin30 "
            r2.d(r5, r6, r4)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r4 = r15.h()
            r7 = 0
            if (r4 != 0) goto L_0x0024
            return r7
        L_0x0024:
            com.m2catalyst.m2sdk.t r4 = com.m2catalyst.m2sdk.t.a
            java.util.List r8 = r15.f()
            android.telephony.CellInfo r4 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r8, (com.m2catalyst.m2sdk.t) r4)
            android.telephony.ServiceState r8 = r15.i()
            r9 = 30
            r10 = 29
            r11 = 1
            if (r8 == 0) goto L_0x0078
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r9) goto L_0x0078
            java.util.List r4 = r8.getNetworkRegistrationInfoList()
            java.lang.String r8 = "serviceState.networkRegistrationInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            java.util.Iterator r4 = r4.iterator()
        L_0x004a:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0069
            java.lang.Object r8 = r4.next()
            r12 = r8
            android.telephony.NetworkRegistrationInfo r12 = (android.telephony.NetworkRegistrationInfo) r12
            boolean r13 = r12.isRegistered()
            if (r13 == 0) goto L_0x0065
            android.telephony.CellIdentity r12 = r12.getCellIdentity()
            if (r12 == 0) goto L_0x0065
            r12 = 1
            goto L_0x0066
        L_0x0065:
            r12 = 0
        L_0x0066:
            if (r12 == 0) goto L_0x004a
            goto L_0x006a
        L_0x0069:
            r8 = r7
        L_0x006a:
            android.telephony.NetworkRegistrationInfo r8 = (android.telephony.NetworkRegistrationInfo) r8
            if (r8 == 0) goto L_0x0073
            android.telephony.CellIdentity r4 = r8.getCellIdentity()
            goto L_0x0074
        L_0x0073:
            r4 = r7
        L_0x0074:
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00e3
        L_0x0078:
            if (r4 == 0) goto L_0x00cc
            boolean r12 = r4 instanceof android.telephony.CellInfoCdma
            if (r12 == 0) goto L_0x0087
            android.telephony.CellInfoCdma r4 = (android.telephony.CellInfoCdma) r4
            android.telephony.CellIdentityCdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00cd
        L_0x0087:
            boolean r12 = r4 instanceof android.telephony.CellInfoGsm
            if (r12 == 0) goto L_0x0094
            android.telephony.CellInfoGsm r4 = (android.telephony.CellInfoGsm) r4
            android.telephony.CellIdentityGsm r4 = r4.getCellIdentity()
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00cd
        L_0x0094:
            boolean r12 = r4 instanceof android.telephony.CellInfoLte
            if (r12 == 0) goto L_0x009f
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4
            android.telephony.CellIdentityLte r4 = r4.getCellIdentity()
            goto L_0x00cd
        L_0x009f:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r10) goto L_0x00b0
            boolean r13 = r4 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x00b0
            android.telephony.CellInfoNr r4 = (android.telephony.CellInfoNr) r4
            android.telephony.CellIdentity r4 = r4.getCellIdentity()
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00cd
        L_0x00b0:
            if (r12 < r10) goto L_0x00bf
            boolean r12 = r4 instanceof android.telephony.CellInfoTdscdma
            if (r12 == 0) goto L_0x00bf
            android.telephony.CellInfoTdscdma r4 = (android.telephony.CellInfoTdscdma) r4
            android.telephony.CellIdentityTdscdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00cd
        L_0x00bf:
            boolean r12 = r4 instanceof android.telephony.CellInfoWcdma
            if (r12 == 0) goto L_0x00cc
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4
            android.telephony.CellIdentityWcdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityLte r4 = (android.telephony.CellIdentityLte) r4
            goto L_0x00cd
        L_0x00cc:
            r4 = r7
        L_0x00cd:
            if (r4 == 0) goto L_0x00e3
            java.lang.Class r12 = r4.getClass()
            java.lang.String r12 = r12.getSimpleName()
            java.lang.String r13 = "cellIdentity::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            boolean r8 = com.m2catalyst.m2sdk.m4.a((android.telephony.ServiceState) r8, (java.lang.String) r12)
            if (r8 != 0) goto L_0x00e3
            r4 = r7
        L_0x00e3:
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.a
            java.util.List r12 = r15.f()
            if (r12 == 0) goto L_0x00f4
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r12 = 0
            goto L_0x00f5
        L_0x00f4:
            r12 = 1
        L_0x00f5:
            if (r12 != 0) goto L_0x0174
            java.util.List r12 = r15.f()
            android.telephony.CellInfo r8 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r12, (com.m2catalyst.m2sdk.t) r8)
            boolean r12 = r8 instanceof android.telephony.CellInfoCdma
            if (r12 == 0) goto L_0x010d
            r12 = r8
            android.telephony.CellInfoCdma r12 = (android.telephony.CellInfoCdma) r12
            android.telephony.CellSignalStrengthCdma r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r12 = (android.telephony.CellSignalStrengthLte) r12
            goto L_0x0158
        L_0x010d:
            boolean r12 = r8 instanceof android.telephony.CellInfoGsm
            if (r12 == 0) goto L_0x011b
            r12 = r8
            android.telephony.CellInfoGsm r12 = (android.telephony.CellInfoGsm) r12
            android.telephony.CellSignalStrengthGsm r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r12 = (android.telephony.CellSignalStrengthLte) r12
            goto L_0x0158
        L_0x011b:
            boolean r12 = r8 instanceof android.telephony.CellInfoLte
            if (r12 == 0) goto L_0x0127
            r12 = r8
            android.telephony.CellInfoLte r12 = (android.telephony.CellInfoLte) r12
            android.telephony.CellSignalStrengthLte r12 = r12.getCellSignalStrength()
            goto L_0x0158
        L_0x0127:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r10) goto L_0x0139
            boolean r13 = r8 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x0139
            r12 = r8
            android.telephony.CellInfoNr r12 = (android.telephony.CellInfoNr) r12
            android.telephony.CellSignalStrength r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r12 = (android.telephony.CellSignalStrengthLte) r12
            goto L_0x0158
        L_0x0139:
            if (r12 < r10) goto L_0x0149
            boolean r12 = r8 instanceof android.telephony.CellInfoTdscdma
            if (r12 == 0) goto L_0x0149
            r12 = r8
            android.telephony.CellInfoTdscdma r12 = (android.telephony.CellInfoTdscdma) r12
            android.telephony.CellSignalStrengthTdscdma r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r12 = (android.telephony.CellSignalStrengthLte) r12
            goto L_0x0158
        L_0x0149:
            boolean r12 = r8 instanceof android.telephony.CellInfoWcdma
            if (r12 == 0) goto L_0x0157
            r12 = r8
            android.telephony.CellInfoWcdma r12 = (android.telephony.CellInfoWcdma) r12
            android.telephony.CellSignalStrengthWcdma r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthLte r12 = (android.telephony.CellSignalStrengthLte) r12
            goto L_0x0158
        L_0x0157:
            r12 = r7
        L_0x0158:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r9) goto L_0x0175
            if (r12 == 0) goto L_0x0175
            java.lang.String r9 = "null cannot be cast to non-null type android.telephony.CellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r9)
            boolean r8 = com.m2catalyst.m2sdk.m4.a((android.telephony.CellInfo) r8, (android.telephony.CellIdentity) r4)
            if (r8 != 0) goto L_0x0175
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = com.m2catalyst.m2sdk.m4.a()
            java.lang.String[] r9 = new java.lang.String[r3]
            java.lang.String r12 = "NetworkUtils getSignalStrength isCellInfoCiMatch NO MATCH cannot use CellInfo for SignalStrength"
            r8.d(r5, r12, r9)
        L_0x0174:
            r12 = r7
        L_0x0175:
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r10) goto L_0x01a8
            android.telephony.SignalStrength r8 = r15.j()
            if (r8 == 0) goto L_0x01a4
            java.util.List r8 = r8.getCellSignalStrengths()
            if (r8 == 0) goto L_0x01a4
            java.lang.String r9 = "cellSignalStrengths"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.util.Iterator r8 = r8.iterator()
        L_0x018e:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01a0
            java.lang.Object r9 = r8.next()
            r10 = r9
            android.telephony.CellSignalStrength r10 = (android.telephony.CellSignalStrength) r10
            boolean r10 = r10 instanceof android.telephony.CellSignalStrengthLte
            if (r10 == 0) goto L_0x018e
            goto L_0x01a1
        L_0x01a0:
            r9 = r7
        L_0x01a1:
            android.telephony.CellSignalStrength r9 = (android.telephony.CellSignalStrength) r9
            goto L_0x01a5
        L_0x01a4:
            r9 = r7
        L_0x01a5:
            android.telephony.CellSignalStrengthLte r9 = (android.telephony.CellSignalStrengthLte) r9
            goto L_0x01a9
        L_0x01a8:
            r9 = r7
        L_0x01a9:
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r12, r9)
            java.lang.Object r9 = r8.getFirst()
            java.lang.Object r8 = r8.getSecond()
            r10 = r17
            kotlin.Pair r8 = r14.a(r9, r8, (com.m2catalyst.m2sdk.c3) r15, (com.m2catalyst.m2sdk.c3) r10)
            if (r4 == 0) goto L_0x0293
            java.lang.Object r9 = r8.getSecond()
            if (r9 == 0) goto L_0x0293
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            long r9 = r9.longValue()
            java.lang.Object r12 = r8.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.telephony.CellSignalStrength r12 = (android.telephony.CellSignalStrength) r12
            com.m2catalyst.m2sdk.business.models.MNSI r9 = r14.a((com.m2catalyst.m2sdk.c3) r15, (long) r9, (android.telephony.CellSignalStrength) r12)
            java.lang.Object r8 = r8.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            android.telephony.CellSignalStrengthLte r8 = (android.telephony.CellSignalStrengthLte) r8
            com.m2catalyst.m2sdk.business.models.MNSI r4 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r9, (android.telephony.CellSignalStrengthLte) r8, (android.telephony.CellIdentityLte) r4, (com.m2catalyst.m2sdk.c3) r15)
            java.util.List<? extends android.telephony.CellInfo> r8 = r1.g
            if (r8 == 0) goto L_0x01f5
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x01f3
            goto L_0x01f5
        L_0x01f3:
            r8 = 0
            goto L_0x01f6
        L_0x01f5:
            r8 = 1
        L_0x01f6:
            r9 = 2
            if (r8 != 0) goto L_0x023b
            java.util.List<? extends android.telephony.CellInfo> r1 = r1.g
            if (r1 == 0) goto L_0x023b
            java.util.Iterator r1 = r1.iterator()
        L_0x0201:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0220
            java.lang.Object r8 = r1.next()
            r10 = r8
            android.telephony.CellInfo r10 = (android.telephony.CellInfo) r10
            boolean r12 = r10 instanceof android.telephony.CellInfoNr
            if (r12 == 0) goto L_0x021c
            android.telephony.CellInfoNr r10 = (android.telephony.CellInfoNr) r10
            int r10 = r10.getCellConnectionStatus()
            if (r10 != r9) goto L_0x021c
            r10 = 1
            goto L_0x021d
        L_0x021c:
            r10 = 0
        L_0x021d:
            if (r10 == 0) goto L_0x0201
            goto L_0x0221
        L_0x0220:
            r8 = r7
        L_0x0221:
            android.telephony.CellInfo r8 = (android.telephony.CellInfo) r8
            if (r8 == 0) goto L_0x023b
            android.telephony.CellIdentity r1 = r8.getCellIdentity()
            java.lang.String r8 = "null cannot be cast to non-null type android.telephony.CellIdentityNr"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r8)
            android.telephony.CellIdentityNr r1 = (android.telephony.CellIdentityNr) r1
            long r12 = r1.getNci()
            java.lang.Long r1 = java.lang.Long.valueOf(r12)
            r4.setSecondaryNrNci(r1)
        L_0x023b:
            r1 = r16
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r4, (com.m2catalyst.m2sdk.business.models.M2Location) r1)
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r1)
            com.m2catalyst.m2sdk.external.SDKState$Companion r4 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r4 = r4.getInstance()
            r4.setRawMNSI(r1)
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r8 = "CellInfoStrategyLteMin30 has CI and SS"
            r2.d(r5, r8, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String[] r6 = new java.lang.String[r3]
            r2.d(r5, r4, r6)
            boolean r4 = r14.b(r1)
            if (r4 == 0) goto L_0x0293
            r4 = r18
            boolean r4 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.MNSI) r4)
            if (r4 == 0) goto L_0x0275
            goto L_0x0276
        L_0x0275:
            r11 = 2
        L_0x0276:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "CellInfoStrategyLteMin30 HAS_MIN_VALUES canBeSaved= "
            r4.<init>(r6)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            java.lang.String[] r3 = new java.lang.String[r3]
            r2.d(r5, r4, r3)
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            r2.<init>(r3, r1)
            return r2
        L_0x0293:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.p.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.MNSI):kotlin.Pair");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.telephony.CellIdentityLte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012e, code lost:
        if (r2 != false) goto L_0x0130;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.m2catalyst.m2sdk.business.models.MNSI a(com.m2catalyst.m2sdk.business.models.MNSI r9, android.telephony.CellSignalStrengthLte r10, android.telephony.CellIdentityLte r11, com.m2catalyst.m2sdk.c3 r12) {
        /*
            r8 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "signalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            int r0 = r10.getAsuLevel()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteAsu(r0)
            java.lang.Integer r0 = r9.getLteAsu()
            r9.setAsu(r0)
            int r0 = r10.getLevel()
            r9.setLevel(r0)
            int r0 = r10.getRssnr()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteRssnr(r0)
            int r0 = r10.getCqi()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteCqi(r0)
            int r0 = r10.getRsrp()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteRsrp(r0)
            int r0 = r10.getRsrq()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteRsrq(r0)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r1 = "MNSI"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger(r1)
            java.lang.Integer r1 = r9.getLteRsrp()
            java.lang.Integer r2 = r9.getLteRsrq()
            int r3 = r10.getDbm()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "buildTechnologyGeneral  lteRsrp "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = " lteRsrq "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = " dbm "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.String r4 = "MNSI_BUILDER"
            r0.d(r4, r1, r3)
            java.lang.Integer r0 = r9.getLteRsrp()
            r9.setRsrp(r0)
            java.lang.Integer r0 = r9.getLteRsrq()
            r9.setRsrq(r0)
            int r0 = r10.getDbm()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteDbm(r0)
            int r0 = r10.getDbm()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setDbm(r0)
            int r0 = r10.getDbm()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteSignalStrength(r0)
            int r0 = r10.getRssi()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteRssi(r0)
            int r0 = r10.getTimingAdvance()
            r1 = 1829(0x725, float:2.563E-42)
            r3 = 1
            if (r0 < 0) goto L_0x00d5
            if (r0 >= r1) goto L_0x00d5
            r0 = 1
            goto L_0x00d6
        L_0x00d5:
            r0 = 0
        L_0x00d6:
            r4 = 0
            if (r0 == 0) goto L_0x00e2
            int r0 = r10.getTimingAdvance()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00e3
        L_0x00e2:
            r0 = r4
        L_0x00e3:
            r9.setLteTimingAdvance(r0)
            java.util.List r0 = r12.f()
            com.m2catalyst.m2sdk.t r5 = com.m2catalyst.m2sdk.t.a
            android.telephony.CellInfo r0 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r0, (com.m2catalyst.m2sdk.t) r5)
            if (r0 == 0) goto L_0x011d
            boolean r6 = r0 instanceof android.telephony.CellInfoLte
            if (r6 == 0) goto L_0x011d
            android.telephony.CellInfoLte r0 = (android.telephony.CellInfoLte) r0
            android.telephony.CellSignalStrengthLte r6 = r0.getCellSignalStrength()
            java.lang.String r7 = "cellInfo.cellSignalStrength"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            int r7 = r6.getTimingAdvance()
            if (r7 < 0) goto L_0x010b
            if (r7 >= r1) goto L_0x010b
            r1 = 1
            goto L_0x010c
        L_0x010b:
            r1 = 0
        L_0x010c:
            if (r1 == 0) goto L_0x0116
            int r1 = r6.getTimingAdvance()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
        L_0x0116:
            r9.setLteTimingAdvance(r4)
            android.telephony.CellIdentityLte r4 = r0.getCellIdentity()
        L_0x011d:
            java.lang.Long r0 = com.m2catalyst.m2sdk.m4.a((com.m2catalyst.m2sdk.c3) r12)
            r9.setCelltowerInfoTimestamp(r0)
            int[] r0 = r11.getBands()
            if (r0 == 0) goto L_0x0130
            int r1 = r0.length
            if (r1 != 0) goto L_0x012e
            r2 = 1
        L_0x012e:
            if (r2 == 0) goto L_0x0136
        L_0x0130:
            if (r4 == 0) goto L_0x0136
            int[] r0 = r4.getBands()
        L_0x0136:
            r9.setLteBand(r0)
            int r0 = r11.getEarfcn()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteEarfcn(r0)
            int r0 = r11.getCi()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteCi(r0)
            int r0 = r11.getPci()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLtePci(r0)
            int r0 = r11.getTac()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLteTac(r0)
            java.lang.Integer r0 = r9.getLtePci()
            if (r0 != 0) goto L_0x016c
            goto L_0x0172
        L_0x016c:
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x017f
        L_0x0172:
            java.lang.Integer r0 = r9.getLteTac()
            if (r0 != 0) goto L_0x0179
            goto L_0x01c8
        L_0x0179:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x01c8
        L_0x017f:
            java.util.List r12 = r12.f()
            android.telephony.CellInfo r12 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r12, (com.m2catalyst.m2sdk.t) r5)
            if (r12 == 0) goto L_0x01c8
            boolean r0 = r12 instanceof android.telephony.CellInfoLte
            if (r0 == 0) goto L_0x01c8
            android.telephony.CellInfoLte r12 = (android.telephony.CellInfoLte) r12
            android.telephony.CellIdentityLte r12 = r12.getCellIdentity()
            java.lang.String r0 = "cellInfo.cellIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            java.lang.String r0 = r11.getMobileNetworkOperator()
            java.lang.String r1 = r12.getMobileNetworkOperator()
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r3)
            if (r0 == 0) goto L_0x01c8
            int r0 = r12.getPci()
            if (r0 <= 0) goto L_0x01b7
            int r0 = r12.getPci()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setLtePci(r0)
        L_0x01b7:
            int r0 = r12.getTac()
            if (r0 <= 0) goto L_0x01c8
            int r12 = r12.getTac()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.setLteTac(r12)
        L_0x01c8:
            int r12 = r11.getCi()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.setCid(r12)
            int r12 = r11.getTac()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r9.setLac(r12)
            int r11 = r11.getBandwidth()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            if (r11 == 0) goto L_0x01ee
            int r12 = r11.intValue()
            if (r12 != 0) goto L_0x01f8
        L_0x01ee:
            if (r4 == 0) goto L_0x01f8
            int r11 = r4.getBandwidth()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        L_0x01f8:
            r9.setLteBandwidth(r11)
            java.lang.Integer r11 = r9.getLteCi()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r9.setCellIdentifier(r11)
            int r11 = r10.getDbm()
            int r11 = r11 / -10
            java.lang.String r12 = android.os.Build.MANUFACTURER
            java.lang.String r0 = "samsung"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
            if (r12 == 0) goto L_0x0266
            r12 = -140(0xffffffffffffff74, float:NaN)
            if (r11 < r12) goto L_0x0266
            r12 = -40
            if (r11 > r12) goto L_0x0266
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r9.setLteDbm(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.setLteRsrp(r11)
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 26
            if (r11 < r12) goto L_0x024a
            int r11 = r10.getRsrq()
            int r11 = r11 / -10
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.setLteRsrq(r11)
            int r10 = r10.getRssnr()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.setLteRssnr(r10)
        L_0x024a:
            java.lang.Integer r10 = r9.getLteDbm()
            r9.setLteSignalStrength(r10)
            java.lang.Integer r10 = r9.getLteRsrp()
            r9.setRsrp(r10)
            java.lang.Integer r10 = r9.getLteRsrq()
            r9.setRsrq(r10)
            java.lang.Integer r10 = r9.getLteDbm()
            r9.setDbm(r10)
        L_0x0266:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.p.a(com.m2catalyst.m2sdk.business.models.MNSI, android.telephony.CellSignalStrengthLte, android.telephony.CellIdentityLte, com.m2catalyst.m2sdk.c3):com.m2catalyst.m2sdk.business.models.MNSI");
    }

    public final b5 a(b5 b5Var, MNSI mnsi) {
        Intrinsics.checkNotNullParameter(b5Var, "<this>");
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        if (mnsi.getCompleteness() == DataCompleteness.STANDARD && !c(mnsi)) {
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
        Pair<String, String> a = m4.a(m4.a(c3Var.g, t.a));
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
