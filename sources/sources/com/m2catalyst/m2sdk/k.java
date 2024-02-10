package com.m2catalyst.m2sdk;

import android.content.Context;
import android.telephony.CellIdentityGsm;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.ServiceState;
import android.telephony.gsm.GsmCellLocation;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategyGsmMin17.kt */
public final class k extends i<CellSignalStrengthGsm, CellIdentityGsm, Object> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final t a() {
        return t.b;
    }

    public final boolean a(int i) {
        return i < 29;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r0.intValue() < 0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, r3.getAsu(), 3) != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, r3.getGsmAsu(), 3) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, java.lang.Integer.valueOf(r3.getLevel()), 3) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, r3.getCid(), 3) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (r3.getCid() == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r3 = r3.getCid();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r3 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        if (r3.intValue() == -1) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r0.intValue() >= 0) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(com.m2catalyst.m2sdk.business.models.MNSI r3) {
        /*
            r2 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Integer r0 = r3.getDbm()
            r1 = 3
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x0023
            java.lang.Integer r0 = r3.getDbm()
            if (r0 == 0) goto L_0x0023
            java.lang.Integer r0 = r3.getDbm()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            if (r0 < 0) goto L_0x0040
        L_0x0023:
            java.lang.Integer r0 = r3.getGsmDbm()
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x0082
            java.lang.Integer r0 = r3.getGsmDbm()
            if (r0 == 0) goto L_0x0082
            java.lang.Integer r0 = r3.getGsmDbm()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            if (r0 >= 0) goto L_0x0082
        L_0x0040:
            java.lang.Integer r0 = r3.getAsu()
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 != 0) goto L_0x0054
            java.lang.Integer r0 = r3.getGsmAsu()
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x0082
        L_0x0054:
            int r0 = r3.getLevel()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x0082
            java.lang.Integer r0 = r3.getCid()
            boolean r0 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.i) r2, (java.lang.Integer) r0, (int) r1)
            if (r0 == 0) goto L_0x0082
            java.lang.Integer r0 = r3.getCid()
            if (r0 == 0) goto L_0x0082
            java.lang.Integer r3 = r3.getCid()
            if (r3 != 0) goto L_0x0079
            goto L_0x0080
        L_0x0079:
            int r3 = r3.intValue()
            r0 = -1
            if (r3 == r0) goto L_0x0082
        L_0x0080:
            r3 = 1
            goto L_0x0083
        L_0x0082:
            r3 = 0
        L_0x0083:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.k.c(com.m2catalyst.m2sdk.business.models.MNSI):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
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
            java.lang.String r6 = "CellInfoStrategyGsmMin17 "
            r2.d(r5, r6, r4)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r4 = r15.h()
            r7 = 0
            if (r4 != 0) goto L_0x0024
            return r7
        L_0x0024:
            com.m2catalyst.m2sdk.t r4 = com.m2catalyst.m2sdk.t.b
            java.util.List r8 = r15.f()
            android.telephony.CellInfo r4 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r8, (com.m2catalyst.m2sdk.t) r4)
            android.telephony.ServiceState r8 = r15.i()
            r9 = 30
            r10 = 1
            r11 = 29
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
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
            goto L_0x00e3
        L_0x0078:
            if (r4 == 0) goto L_0x00cc
            boolean r12 = r4 instanceof android.telephony.CellInfoCdma
            if (r12 == 0) goto L_0x0087
            android.telephony.CellInfoCdma r4 = (android.telephony.CellInfoCdma) r4
            android.telephony.CellIdentityCdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
            goto L_0x00cd
        L_0x0087:
            boolean r12 = r4 instanceof android.telephony.CellInfoGsm
            if (r12 == 0) goto L_0x0092
            android.telephony.CellInfoGsm r4 = (android.telephony.CellInfoGsm) r4
            android.telephony.CellIdentityGsm r4 = r4.getCellIdentity()
            goto L_0x00cd
        L_0x0092:
            boolean r12 = r4 instanceof android.telephony.CellInfoLte
            if (r12 == 0) goto L_0x009f
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4
            android.telephony.CellIdentityLte r4 = r4.getCellIdentity()
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
            goto L_0x00cd
        L_0x009f:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r11) goto L_0x00b0
            boolean r13 = r4 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x00b0
            android.telephony.CellInfoNr r4 = (android.telephony.CellInfoNr) r4
            android.telephony.CellIdentity r4 = r4.getCellIdentity()
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
            goto L_0x00cd
        L_0x00b0:
            if (r12 < r11) goto L_0x00bf
            boolean r12 = r4 instanceof android.telephony.CellInfoTdscdma
            if (r12 == 0) goto L_0x00bf
            android.telephony.CellInfoTdscdma r4 = (android.telephony.CellInfoTdscdma) r4
            android.telephony.CellIdentityTdscdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
            goto L_0x00cd
        L_0x00bf:
            boolean r12 = r4 instanceof android.telephony.CellInfoWcdma
            if (r12 == 0) goto L_0x00cc
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4
            android.telephony.CellIdentityWcdma r4 = r4.getCellIdentity()
            android.telephony.CellIdentityGsm r4 = (android.telephony.CellIdentityGsm) r4
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
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.b
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
            android.telephony.CellSignalStrengthGsm r12 = (android.telephony.CellSignalStrengthGsm) r12
            goto L_0x0158
        L_0x010d:
            boolean r12 = r8 instanceof android.telephony.CellInfoGsm
            if (r12 == 0) goto L_0x0119
            r12 = r8
            android.telephony.CellInfoGsm r12 = (android.telephony.CellInfoGsm) r12
            android.telephony.CellSignalStrengthGsm r12 = r12.getCellSignalStrength()
            goto L_0x0158
        L_0x0119:
            boolean r12 = r8 instanceof android.telephony.CellInfoLte
            if (r12 == 0) goto L_0x0127
            r12 = r8
            android.telephony.CellInfoLte r12 = (android.telephony.CellInfoLte) r12
            android.telephony.CellSignalStrengthLte r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthGsm r12 = (android.telephony.CellSignalStrengthGsm) r12
            goto L_0x0158
        L_0x0127:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r11) goto L_0x0139
            boolean r13 = r8 instanceof android.telephony.CellInfoNr
            if (r13 == 0) goto L_0x0139
            r12 = r8
            android.telephony.CellInfoNr r12 = (android.telephony.CellInfoNr) r12
            android.telephony.CellSignalStrength r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthGsm r12 = (android.telephony.CellSignalStrengthGsm) r12
            goto L_0x0158
        L_0x0139:
            if (r12 < r11) goto L_0x0149
            boolean r12 = r8 instanceof android.telephony.CellInfoTdscdma
            if (r12 == 0) goto L_0x0149
            r12 = r8
            android.telephony.CellInfoTdscdma r12 = (android.telephony.CellInfoTdscdma) r12
            android.telephony.CellSignalStrengthTdscdma r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthGsm r12 = (android.telephony.CellSignalStrengthGsm) r12
            goto L_0x0158
        L_0x0149:
            boolean r12 = r8 instanceof android.telephony.CellInfoWcdma
            if (r12 == 0) goto L_0x0157
            r12 = r8
            android.telephony.CellInfoWcdma r12 = (android.telephony.CellInfoWcdma) r12
            android.telephony.CellSignalStrengthWcdma r12 = r12.getCellSignalStrength()
            android.telephony.CellSignalStrengthGsm r12 = (android.telephony.CellSignalStrengthGsm) r12
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
            if (r8 < r11) goto L_0x01a8
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
            r11 = r9
            android.telephony.CellSignalStrength r11 = (android.telephony.CellSignalStrength) r11
            boolean r11 = r11 instanceof android.telephony.CellSignalStrengthGsm
            if (r11 == 0) goto L_0x018e
            goto L_0x01a1
        L_0x01a0:
            r9 = r7
        L_0x01a1:
            android.telephony.CellSignalStrength r9 = (android.telephony.CellSignalStrength) r9
            goto L_0x01a5
        L_0x01a4:
            r9 = r7
        L_0x01a5:
            android.telephony.CellSignalStrengthGsm r9 = (android.telephony.CellSignalStrengthGsm) r9
            goto L_0x01a9
        L_0x01a8:
            r9 = r7
        L_0x01a9:
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r12, r9)
            java.lang.Object r9 = r8.getFirst()
            java.lang.Object r8 = r8.getSecond()
            r11 = r17
            kotlin.Pair r8 = r14.a(r9, r8, (com.m2catalyst.m2sdk.c3) r15, (com.m2catalyst.m2sdk.c3) r11)
            if (r4 == 0) goto L_0x023f
            java.lang.Object r9 = r8.getSecond()
            if (r9 == 0) goto L_0x023f
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            long r11 = r9.longValue()
            java.lang.Object r9 = r8.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.telephony.CellSignalStrength r9 = (android.telephony.CellSignalStrength) r9
            com.m2catalyst.m2sdk.business.models.MNSI r9 = r14.a((com.m2catalyst.m2sdk.c3) r15, (long) r11, (android.telephony.CellSignalStrength) r9)
            java.lang.Object r8 = r8.getSecond()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            android.telephony.CellSignalStrengthGsm r8 = (android.telephony.CellSignalStrengthGsm) r8
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r9, (android.telephony.CellSignalStrengthGsm) r8, (android.telephony.CellIdentityGsm) r4, (com.m2catalyst.m2sdk.c3) r15)
            r4 = r16
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.M2Location) r4)
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r14.a((com.m2catalyst.m2sdk.business.models.MNSI) r1)
            com.m2catalyst.m2sdk.external.SDKState$Companion r4 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r4 = r4.getInstance()
            r4.setRawMNSI(r1)
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r8 = "CellInfoStrategyGsmMin17 has CI and SS"
            r2.d(r5, r8, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String[] r6 = new java.lang.String[r3]
            r2.d(r5, r4, r6)
            boolean r4 = r14.b(r1)
            if (r4 == 0) goto L_0x023f
            r4 = r18
            boolean r4 = com.m2catalyst.m2sdk.i.a((com.m2catalyst.m2sdk.business.models.MNSI) r1, (com.m2catalyst.m2sdk.business.models.MNSI) r4)
            if (r4 == 0) goto L_0x0222
            goto L_0x0223
        L_0x0222:
            r10 = 2
        L_0x0223:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "CellInfoStrategyGsmMin17 HAS_MIN_VALUES canBeSaved= "
            r4.<init>(r6)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String[] r3 = new java.lang.String[r3]
            r2.d(r5, r4, r3)
            kotlin.Pair r7 = new kotlin.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r7.<init>(r2, r1)
        L_0x023f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.k.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.MNSI):kotlin.Pair");
    }

    public final MNSI a(MNSI mnsi, CellSignalStrengthGsm cellSignalStrengthGsm, CellIdentityGsm cellIdentityGsm, c3 c3Var) {
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        Intrinsics.checkNotNullParameter(cellSignalStrengthGsm, "signalStrength");
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        mnsi.setDbm(Integer.valueOf(cellSignalStrengthGsm.getDbm()));
        mnsi.setGsmDbm(mnsi.getDbm());
        mnsi.setAsu(Integer.valueOf(cellSignalStrengthGsm.getAsuLevel()));
        mnsi.setGsmAsu(mnsi.getAsu());
        mnsi.setLevel(cellSignalStrengthGsm.getLevel());
        mnsi.setGsmBitError(c5.a("mBitErrorRate", cellSignalStrengthGsm));
        mnsi.setCelltowerInfoTimestamp(m4.a(c3Var));
        mnsi.setCid(Integer.valueOf(cellIdentityGsm.getCid()));
        mnsi.setLac(Integer.valueOf(cellIdentityGsm.getLac()));
        mnsi.setGsmArfcn(Integer.valueOf(cellIdentityGsm.getArfcn()));
        mnsi.setGsmBsic(Integer.valueOf(cellIdentityGsm.getBsic()));
        int cid = cellIdentityGsm.getCid();
        int lac = cellIdentityGsm.getLac();
        StringBuilder sb = new StringBuilder();
        sb.append(cid);
        sb.append(lac);
        mnsi.setCellIdentifier(sb.toString());
        if (Unit.INSTANCE == null && c3Var.g() != null && (c3Var.g() instanceof GsmCellLocation)) {
            CellLocation g = c3Var.g();
            Intrinsics.checkNotNull(g, "null cannot be cast to non-null type android.telephony.gsm.GsmCellLocation");
            GsmCellLocation gsmCellLocation = (GsmCellLocation) g;
            mnsi.setCelltowerInfoTimestamp(Long.valueOf(c3Var.c()));
            mnsi.setCid(Integer.valueOf(gsmCellLocation.getCid()));
            mnsi.setLac(Integer.valueOf(gsmCellLocation.getLac()));
            int cid2 = gsmCellLocation.getCid();
            int lac2 = gsmCellLocation.getLac();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cid2);
            sb2.append(lac2);
            mnsi.setCellIdentifier(sb2.toString());
        }
        return mnsi;
    }

    public final b5 a(b5 b5Var, MNSI mnsi) {
        Intrinsics.checkNotNullParameter(b5Var, "<this>");
        Intrinsics.checkNotNullParameter(mnsi, "mnsi");
        if (!c(mnsi)) {
            Intrinsics.checkNotNullParameter("RF_GSM", IronSourceConstants.EVENTS_ERROR_REASON);
            b5Var.b.add("RF_GSM");
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
        Pair<String, String> a = m4.a(m4.a(c3Var.g, t.b));
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
