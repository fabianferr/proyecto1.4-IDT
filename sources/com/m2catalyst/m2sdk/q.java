package com.m2catalyst.m2sdk;

import android.location.Location;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.DataCompleteness;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NoSignalData;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellInfoStrategyManager.kt */
public final class q {
    public final List<i<?, ?, ?>> a;
    public final M2SDKLogger b = M2SDKLogger.Companion.getLogger("MNSI");

    public q(List<? extends i<?, ?, ?>> list) {
        Intrinsics.checkNotNullParameter(list, "cellInfoStrategies");
        this.a = list;
    }

    public final Pair<Integer, MNSI> a(c3 c3Var, M2Location m2Location, c3 c3Var2, MNSI mnsi) {
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        c3Var.o();
        c3Var.k();
        c3Var.f();
        c3Var.j();
        c3Var.i();
        c3Var.g();
        i<?, ?, ?> a2 = a(c3Var);
        if (a2 != null) {
            M2SDKLogger m2SDKLogger = this.b;
            t a3 = a2.a();
            m2SDKLogger.d("MNSI_BUILDER", "getStrategy " + a3, new String[0]);
        } else {
            this.b.d("MNSI_BUILDER", "getStrategy ", new String[0]);
        }
        if (a2 != null) {
            return a2.a(c3Var, m2Location, c3Var2, mnsi);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01b6, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01d1, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x020a, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0248, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0262, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0189, code lost:
        if (r10.getLevel() == 0) goto L_0x0267;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0153 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.m2catalyst.m2sdk.i<?, ?, ?> a(com.m2catalyst.m2sdk.c3 r13) {
        /*
            r12 = this;
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r12.b
            boolean r1 = r13.q()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "getStrategy start "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.String r4 = "MNSI_BUILDER"
            r0.d(r4, r1, r3)
            boolean r0 = r13.q()
            r1 = 0
            if (r0 != 0) goto L_0x0024
            return r1
        L_0x0024:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 1
            r4 = 29
            if (r0 >= r4) goto L_0x008b
            java.util.List<com.m2catalyst.m2sdk.i<?, ?, ?>> r0 = r12.a
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r0.next()
            r6 = r5
            com.m2catalyst.m2sdk.i r6 = (com.m2catalyst.m2sdk.i) r6
            com.m2catalyst.m2sdk.t r7 = r6.a()
            java.util.List<? extends android.telephony.CellInfo> r8 = r13.g
            android.telephony.CellInfo r8 = com.m2catalyst.m2sdk.m4.a((java.util.List<? extends android.telephony.CellInfo>) r8)
            boolean r9 = r8 instanceof android.telephony.CellInfoLte
            if (r9 == 0) goto L_0x004f
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.a
            goto L_0x0077
        L_0x004f:
            boolean r9 = r8 instanceof android.telephony.CellInfoCdma
            if (r9 == 0) goto L_0x0056
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.d
            goto L_0x0077
        L_0x0056:
            boolean r9 = r8 instanceof android.telephony.CellInfoGsm
            if (r9 == 0) goto L_0x005d
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.b
            goto L_0x0077
        L_0x005d:
            boolean r9 = r8 instanceof android.telephony.CellInfoWcdma
            if (r9 == 0) goto L_0x0064
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.e
            goto L_0x0077
        L_0x0064:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r4) goto L_0x0076
            boolean r9 = r8 instanceof android.telephony.CellInfoTdscdma
            if (r9 == 0) goto L_0x006f
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.f
            goto L_0x0077
        L_0x006f:
            boolean r8 = r8 instanceof android.telephony.CellInfoNr
            if (r8 == 0) goto L_0x0076
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.c
            goto L_0x0077
        L_0x0076:
            r8 = r1
        L_0x0077:
            if (r7 != r8) goto L_0x0083
            int r7 = android.os.Build.VERSION.SDK_INT
            boolean r6 = r6.a((int) r7)
            if (r6 == 0) goto L_0x0083
            r6 = 1
            goto L_0x0084
        L_0x0083:
            r6 = 0
        L_0x0084:
            if (r6 == 0) goto L_0x0031
            r1 = r5
        L_0x0087:
            com.m2catalyst.m2sdk.i r1 = (com.m2catalyst.m2sdk.i) r1
            goto L_0x0386
        L_0x008b:
            if (r0 != r4) goto L_0x02ca
            java.util.List<? extends android.telephony.CellInfo> r0 = r13.g
            com.m2catalyst.m2sdk.logger.M2SDKLogger r5 = com.m2catalyst.m2sdk.m4.a
            if (r0 == 0) goto L_0x00b3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x009c:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r0.next()
            r7 = r6
            android.telephony.CellInfo r7 = (android.telephony.CellInfo) r7
            boolean r7 = r7.isRegistered()
            if (r7 == 0) goto L_0x009c
            r5.add(r6)
            goto L_0x009c
        L_0x00b3:
            r5 = r1
        L_0x00b4:
            if (r5 != 0) goto L_0x00ba
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00ba:
            if (r5 == 0) goto L_0x0386
            java.util.ArrayList r0 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r6)
            r0.<init>(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x00cb:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x010a
            java.lang.Object r6 = r5.next()
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6
            boolean r7 = r6 instanceof android.telephony.CellInfoLte
            if (r7 == 0) goto L_0x00de
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.a
            goto L_0x0106
        L_0x00de:
            boolean r7 = r6 instanceof android.telephony.CellInfoCdma
            if (r7 == 0) goto L_0x00e5
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.d
            goto L_0x0106
        L_0x00e5:
            boolean r7 = r6 instanceof android.telephony.CellInfoGsm
            if (r7 == 0) goto L_0x00ec
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.b
            goto L_0x0106
        L_0x00ec:
            boolean r7 = r6 instanceof android.telephony.CellInfoWcdma
            if (r7 == 0) goto L_0x00f3
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.e
            goto L_0x0106
        L_0x00f3:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L_0x0105
            boolean r7 = r6 instanceof android.telephony.CellInfoTdscdma
            if (r7 == 0) goto L_0x00fe
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.f
            goto L_0x0106
        L_0x00fe:
            boolean r6 = r6 instanceof android.telephony.CellInfoNr
            if (r6 == 0) goto L_0x0105
            com.m2catalyst.m2sdk.t r6 = com.m2catalyst.m2sdk.t.c
            goto L_0x0106
        L_0x0105:
            r6 = r1
        L_0x0106:
            r0.add(r6)
            goto L_0x00cb
        L_0x010a:
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Iterator r6 = r0.iterator()
        L_0x0113:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0126
            java.lang.Object r7 = r6.next()
            com.m2catalyst.m2sdk.t r7 = (com.m2catalyst.m2sdk.t) r7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.add(r7)
            goto L_0x0113
        L_0x0126:
            int r6 = r0.size()
            int r5 = r5.size()
            if (r6 == r5) goto L_0x0132
            goto L_0x0386
        L_0x0132:
            android.telephony.SignalStrength r13 = r13.h
            if (r13 == 0) goto L_0x0386
            java.util.Iterator r0 = r0.iterator()
        L_0x013a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0386
            java.lang.Object r5 = r0.next()
            com.m2catalyst.m2sdk.t r5 = (com.m2catalyst.m2sdk.t) r5
            java.util.List r6 = r13.getCellSignalStrengths()
            java.lang.String r7 = "signalStengths.cellSignalStrengths"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.util.Iterator r6 = r6.iterator()
        L_0x0153:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x013a
            java.lang.Object r7 = r6.next()
            android.telephony.CellSignalStrength r7 = (android.telephony.CellSignalStrength) r7
            java.lang.String r8 = "signal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            boolean r8 = r7 instanceof android.telephony.CellSignalStrengthGsm
            r9 = 2147483647(0x7fffffff, float:NaN)
            if (r8 == 0) goto L_0x018d
            r10 = r7
            android.telephony.CellSignalStrengthGsm r10 = (android.telephony.CellSignalStrengthGsm) r10
            int r11 = r10.getDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getAsuLevel()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getBitErrorRate()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x018d:
            boolean r10 = r7 instanceof android.telephony.CellSignalStrengthCdma
            if (r10 == 0) goto L_0x01ba
            r10 = r7
            android.telephony.CellSignalStrengthCdma r10 = (android.telephony.CellSignalStrengthCdma) r10
            int r11 = r10.getCdmaDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getCdmaEcio()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getEvdoDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getEvdoEcio()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getEvdoSnr()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x01ba:
            boolean r10 = r7 instanceof android.telephony.CellSignalStrengthWcdma
            if (r10 == 0) goto L_0x01d5
            r10 = r7
            android.telephony.CellSignalStrengthWcdma r10 = (android.telephony.CellSignalStrengthWcdma) r10
            int r11 = r10.getDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getAsuLevel()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x01d5:
            boolean r10 = r7 instanceof android.telephony.CellSignalStrengthLte
            if (r10 == 0) goto L_0x020d
            r10 = r7
            android.telephony.CellSignalStrengthLte r10 = (android.telephony.CellSignalStrengthLte) r10
            int r11 = r10.getDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getAsuLevel()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getRsrp()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getRsrq()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getRssi()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getRssnr()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getCqi()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x020d:
            boolean r10 = r7 instanceof android.telephony.CellSignalStrengthNr
            if (r10 == 0) goto L_0x024b
            r10 = r7
            android.telephony.CellSignalStrengthNr r10 = (android.telephony.CellSignalStrengthNr) r10
            int r11 = r10.getDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getAsuLevel()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getCsiRsrp()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getCsiRsrq()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getCsiSinr()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getSsRsrp()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getSsRsrq()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getSsSinr()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x024b:
            boolean r10 = r7 instanceof android.telephony.CellSignalStrengthTdscdma
            if (r10 == 0) goto L_0x0267
            r10 = r7
            android.telephony.CellSignalStrengthTdscdma r10 = (android.telephony.CellSignalStrengthTdscdma) r10
            int r11 = r10.getDbm()
            if (r11 != r9) goto L_0x0265
            int r11 = r10.getAsuLevel()
            if (r11 != r9) goto L_0x0265
            int r9 = r10.getLevel()
            if (r9 != 0) goto L_0x0265
            goto L_0x0267
        L_0x0265:
            r9 = 0
            goto L_0x0268
        L_0x0267:
            r9 = 1
        L_0x0268:
            if (r9 != 0) goto L_0x0153
            boolean r9 = r7 instanceof android.telephony.CellSignalStrengthLte
            if (r9 == 0) goto L_0x0271
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.a
            goto L_0x0299
        L_0x0271:
            boolean r9 = r7 instanceof android.telephony.CellSignalStrengthCdma
            if (r9 == 0) goto L_0x0278
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.d
            goto L_0x0299
        L_0x0278:
            if (r8 == 0) goto L_0x027d
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.b
            goto L_0x0299
        L_0x027d:
            boolean r8 = r7 instanceof android.telephony.CellSignalStrengthWcdma
            if (r8 == 0) goto L_0x0284
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.e
            goto L_0x0299
        L_0x0284:
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r4) goto L_0x028f
            boolean r9 = r7 instanceof android.telephony.CellSignalStrengthTdscdma
            if (r9 == 0) goto L_0x028f
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.f
            goto L_0x0299
        L_0x028f:
            if (r8 < r4) goto L_0x0298
            boolean r7 = r7 instanceof android.telephony.CellSignalStrengthNr
            if (r7 == 0) goto L_0x0298
            com.m2catalyst.m2sdk.t r7 = com.m2catalyst.m2sdk.t.c
            goto L_0x0299
        L_0x0298:
            r7 = r1
        L_0x0299:
            if (r5 != r7) goto L_0x0153
            java.util.List<com.m2catalyst.m2sdk.i<?, ?, ?>> r7 = r12.a
            java.util.Iterator r7 = r7.iterator()
        L_0x02a1:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x02c2
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.m2catalyst.m2sdk.i r9 = (com.m2catalyst.m2sdk.i) r9
            com.m2catalyst.m2sdk.t r10 = r9.a()
            if (r10 != r5) goto L_0x02be
            int r10 = android.os.Build.VERSION.SDK_INT
            boolean r9 = r9.a((int) r10)
            if (r9 == 0) goto L_0x02be
            r9 = 1
            goto L_0x02bf
        L_0x02be:
            r9 = 0
        L_0x02bf:
            if (r9 == 0) goto L_0x02a1
            goto L_0x02c3
        L_0x02c2:
            r8 = r1
        L_0x02c3:
            com.m2catalyst.m2sdk.i r8 = (com.m2catalyst.m2sdk.i) r8
            if (r8 == 0) goto L_0x0153
            r1 = r8
            goto L_0x0386
        L_0x02ca:
            java.util.List<com.m2catalyst.m2sdk.i<?, ?, ?>> r0 = r12.a
            java.util.Iterator r0 = r0.iterator()
        L_0x02d0:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x02f7
            java.lang.Object r5 = r0.next()
            r6 = r5
            com.m2catalyst.m2sdk.i r6 = (com.m2catalyst.m2sdk.i) r6
            com.m2catalyst.m2sdk.t r7 = r6.a()
            android.telephony.ServiceState r8 = r13.i
            com.m2catalyst.m2sdk.t r8 = com.m2catalyst.m2sdk.t.a.a(r8)
            if (r7 != r8) goto L_0x02f3
            int r7 = android.os.Build.VERSION.SDK_INT
            boolean r6 = r6.a((int) r7)
            if (r6 == 0) goto L_0x02f3
            r6 = 1
            goto L_0x02f4
        L_0x02f3:
            r6 = 0
        L_0x02f4:
            if (r6 == 0) goto L_0x02d0
            goto L_0x02f8
        L_0x02f7:
            r5 = r1
        L_0x02f8:
            com.m2catalyst.m2sdk.i r5 = (com.m2catalyst.m2sdk.i) r5
            if (r5 == 0) goto L_0x0382
            android.telephony.SignalStrength r13 = r13.h
            if (r13 == 0) goto L_0x0382
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.util.List r13 = r13.getCellSignalStrengths()
            java.util.Iterator r13 = r13.iterator()
        L_0x030b:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0382
            java.lang.Object r0 = r13.next()
            android.telephony.CellSignalStrength r0 = (android.telephony.CellSignalStrength) r0
            java.util.List<com.m2catalyst.m2sdk.i<?, ?, ?>> r6 = r12.a
            java.util.Iterator r6 = r6.iterator()
        L_0x031d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0372
            java.lang.Object r7 = r6.next()
            r8 = r7
            com.m2catalyst.m2sdk.i r8 = (com.m2catalyst.m2sdk.i) r8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.m2catalyst.m2sdk.t r9 = r8.a()
            boolean r10 = r0 instanceof android.telephony.CellSignalStrengthLte
            if (r10 == 0) goto L_0x0338
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.a
            goto L_0x0362
        L_0x0338:
            boolean r10 = r0 instanceof android.telephony.CellSignalStrengthCdma
            if (r10 == 0) goto L_0x033f
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.d
            goto L_0x0362
        L_0x033f:
            boolean r10 = r0 instanceof android.telephony.CellSignalStrengthGsm
            if (r10 == 0) goto L_0x0346
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.b
            goto L_0x0362
        L_0x0346:
            boolean r10 = r0 instanceof android.telephony.CellSignalStrengthWcdma
            if (r10 == 0) goto L_0x034d
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.e
            goto L_0x0362
        L_0x034d:
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 < r4) goto L_0x0358
            boolean r11 = r0 instanceof android.telephony.CellSignalStrengthTdscdma
            if (r11 == 0) goto L_0x0358
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.f
            goto L_0x0362
        L_0x0358:
            if (r10 < r4) goto L_0x0361
            boolean r10 = r0 instanceof android.telephony.CellSignalStrengthNr
            if (r10 == 0) goto L_0x0361
            com.m2catalyst.m2sdk.t r10 = com.m2catalyst.m2sdk.t.c
            goto L_0x0362
        L_0x0361:
            r10 = r1
        L_0x0362:
            if (r9 != r10) goto L_0x036e
            int r9 = android.os.Build.VERSION.SDK_INT
            boolean r8 = r8.a((int) r9)
            if (r8 == 0) goto L_0x036e
            r8 = 1
            goto L_0x036f
        L_0x036e:
            r8 = 0
        L_0x036f:
            if (r8 == 0) goto L_0x031d
            goto L_0x0373
        L_0x0372:
            r7 = r1
        L_0x0373:
            com.m2catalyst.m2sdk.i r7 = (com.m2catalyst.m2sdk.i) r7
            if (r7 == 0) goto L_0x030b
            com.m2catalyst.m2sdk.t r0 = r5.a()
            com.m2catalyst.m2sdk.t r6 = r7.a()
            if (r0 != r6) goto L_0x030b
            goto L_0x0383
        L_0x0382:
            r7 = r1
        L_0x0383:
            if (r7 == 0) goto L_0x0386
            r1 = r5
        L_0x0386:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q.a(com.m2catalyst.m2sdk.c3):com.m2catalyst.m2sdk.i");
    }

    public final NoSignalData a(c3 c3Var, M2Location m2Location) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        i iVar = (i) CollectionsKt.firstOrNull(this.a);
        if (iVar == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(c3Var, "builder");
        NoSignalData noSignalData = new NoSignalData();
        noSignalData.setPermissions(o4.a(SDKState.Companion.getInstance(), iVar.a, "no_signal"));
        noSignalData.setTimeZone(o1.b());
        noSignalData.setSimSlot(c3Var.n());
        noSignalData.setTimeZoneId(o1.b());
        Integer a2 = o1.a(Long.valueOf(noSignalData.getTimeStamp()));
        noSignalData.setTimeZoneOffset(a2 != null ? Long.valueOf((long) a2.intValue()) : null);
        Unit unit = Unit.INSTANCE;
        TelephonyManager a3 = m4.a(iVar.a, c3Var.o());
        if (a3 != null) {
            noSignalData.setPhoneType(m4.a(a3.getPhoneType()));
            e eVar = new e(a3);
            Intrinsics.checkNotNullParameter(eVar, "block");
            try {
                obj = eVar.invoke();
            } catch (Exception unused) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null) {
                f fVar = new f(str);
                Intrinsics.checkNotNullParameter(fVar, "block");
                try {
                    obj3 = fVar.invoke();
                } catch (Exception unused2) {
                    obj3 = null;
                }
                noSignalData.setSimMcc((Integer) obj3);
                g gVar = new g(str);
                Intrinsics.checkNotNullParameter(gVar, "block");
                try {
                    obj4 = gVar.invoke();
                } catch (Exception unused3) {
                    obj4 = null;
                }
                noSignalData.setSimMnc((Integer) obj4);
            }
            h hVar = new h(a3);
            Intrinsics.checkNotNullParameter(hVar, "block");
            try {
                obj2 = hVar.invoke();
            } catch (Exception unused4) {
                obj2 = null;
            }
            noSignalData.setSimOperatorName((String) obj2);
        }
        if (m2Location != null) {
            noSignalData.setLocationTimeStamp(Long.valueOf(m2Location.getTime()));
            noSignalData.setLatitude(Double.valueOf(m2Location.getLatitude()));
            noSignalData.setLongitude(Double.valueOf(m2Location.getLongitude()));
            noSignalData.setAccuracy(m2Location.getAccuracy());
            noSignalData.setLocationProvider(m2Location.getProvider());
        }
        Intrinsics.checkNotNullParameter(noSignalData, "noSiganlData");
        if (i.a(iVar, noSignalData.getSimMnc(), 3) && i.a(iVar, noSignalData.getSimMcc(), 3) && i.a(noSignalData.getLocationTimeStamp()) && i.a(Long.valueOf(noSignalData.getTimeStamp())) && i.a(iVar, noSignalData.getLongitude()) && i.a(iVar, noSignalData.getLatitude()) && i.a(iVar, Float.valueOf(noSignalData.getAccuracy()))) {
            return noSignalData;
        }
        return null;
    }

    public final b5 a(MNSI mnsi, MNSI mnsi2) {
        b5 b5Var;
        T t;
        float f;
        f3 mnsiConfiguration;
        Integer num;
        f3 mnsiConfiguration2;
        Integer num2;
        f3 mnsiConfiguration3;
        Integer num3;
        f3 mnsiConfiguration4;
        Integer num4;
        t tVar;
        boolean z;
        MNSI mnsi3 = mnsi;
        MNSI mnsi4 = mnsi2;
        Intrinsics.checkNotNullParameter(mnsi4, "mnsi");
        Iterator<T> it = this.a.iterator();
        while (true) {
            b5Var = null;
            if (it.hasNext()) {
                t = it.next();
                i iVar = (i) t;
                t a2 = iVar.a();
                int networkType = mnsi2.getNetworkType();
                if (networkType != 20) {
                    switch (networkType) {
                        case 1:
                            tVar = t.b;
                            break;
                        case 2:
                            tVar = t.b;
                            break;
                        case 3:
                            tVar = t.b;
                            break;
                        case 4:
                            tVar = t.d;
                            break;
                        case 5:
                            tVar = t.d;
                            break;
                        case 6:
                            tVar = t.d;
                            break;
                        case 7:
                            tVar = t.d;
                            break;
                        case 8:
                            tVar = t.b;
                            break;
                        case 9:
                            tVar = t.b;
                            break;
                        case 10:
                            tVar = t.b;
                            break;
                        case 11:
                            tVar = t.b;
                            break;
                        case 12:
                            tVar = t.d;
                            break;
                        case 13:
                            tVar = t.a;
                            break;
                        case 14:
                            tVar = t.d;
                            break;
                        case 15:
                            tVar = t.b;
                            break;
                        case 16:
                            tVar = t.b;
                            break;
                        case 17:
                            tVar = t.f;
                            break;
                        default:
                            tVar = null;
                            break;
                    }
                } else {
                    tVar = t.c;
                }
                if (a2 != tVar || !iVar.a(Build.VERSION.SDK_INT)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                }
            } else {
                t = null;
            }
        }
        i iVar2 = (i) t;
        double d = 0.0d;
        if (iVar2 != null) {
            Intrinsics.checkNotNullParameter(mnsi4, "mnsi");
            b5Var = new b5(mnsi2.getId());
            DataCompleteness completeness = mnsi2.getCompleteness();
            DataCompleteness dataCompleteness = DataCompleteness.STANDARD;
            if (completeness == dataCompleteness) {
                String phoneType = mnsi2.getPhoneType();
                if (phoneType == null || phoneType.length() == 0) {
                    Intrinsics.checkNotNullParameter("PHONE_TYPE", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("PHONE_TYPE");
                    b5Var.c = false;
                }
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                Integer asu = mnsi2.getAsu();
                Set<String> set = s1.a;
                if ((asu != null ? asu.intValue() : 0) <= 0) {
                    Intrinsics.checkNotNullParameter("ASU", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("ASU");
                    b5Var.c = false;
                }
            }
            String[] strArr = {"gps", "network", "fused", "generated"};
            String locationProvider = mnsi2.getLocationProvider();
            if (locationProvider == null) {
                locationProvider = "";
            }
            if (!ArraysKt.contains((T[]) strArr, locationProvider)) {
                Intrinsics.checkNotNullParameter("LOCATION_PROVIDER", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LOCATION_PROVIDER");
                b5Var.c = false;
            }
            if (mnsi2.getLatitude() == null || Intrinsics.areEqual(mnsi2.getLatitude(), 0.0d)) {
                Intrinsics.checkNotNullParameter("LATITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LATITUDE");
                b5Var.c = false;
            }
            if (mnsi2.getLongitude() == null || Intrinsics.areEqual(mnsi2.getLongitude(), 0.0d)) {
                Intrinsics.checkNotNullParameter("LONGITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LONGITUDE");
                b5Var.c = false;
            }
            Long locationTimeStamp = mnsi2.getLocationTimeStamp();
            Set<String> set2 = s1.a;
            if ((locationTimeStamp != null ? locationTimeStamp.longValue() : 0) <= 0) {
                Intrinsics.checkNotNullParameter("LOCATION_TIMESTAMP", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LOCATION_TIMESTAMP");
                b5Var.c = false;
            }
            String networkOperatorName = mnsi2.getNetworkOperatorName();
            if (networkOperatorName == null || networkOperatorName.length() == 0) {
                Intrinsics.checkNotNullParameter("NETWORK_OPERATOR_NAME", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("NETWORK_OPERATOR_NAME");
                b5Var.c = false;
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                String networkCountryIso = mnsi2.getNetworkCountryIso();
                if (networkCountryIso == null || networkCountryIso.length() == 0) {
                    Intrinsics.checkNotNullParameter("NETWORK_COUNTRY_ISO", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NETWORK_COUNTRY_ISO");
                    b5Var.c = false;
                }
            }
            Integer networkMnc = mnsi2.getNetworkMnc();
            if ((networkMnc != null ? networkMnc.intValue() : 0) <= 0) {
                Intrinsics.checkNotNullParameter("NETWORK_MNC", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("NETWORK_MNC");
                b5Var.c = false;
            }
            Integer networkMcc = mnsi2.getNetworkMcc();
            if ((networkMcc != null ? networkMcc.intValue() : 0) <= 0) {
                Intrinsics.checkNotNullParameter("NETWORK_MCC", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("NETWORK_MCC");
                b5Var.c = false;
            }
            String simOperatorName = mnsi2.getSimOperatorName();
            if (simOperatorName == null || simOperatorName.length() == 0) {
                Intrinsics.checkNotNullParameter("SIM_OPERATOR_NAME", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("SIM_OPERATOR_NAME");
                b5Var.c = false;
            }
            String simCountryIso = mnsi2.getSimCountryIso();
            if (simCountryIso == null || simCountryIso.length() == 0) {
                Intrinsics.checkNotNullParameter("SIM_COUNTRY_ISO", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("SIM_COUNTRY_ISO");
                b5Var.c = false;
            }
            Integer simMnc = mnsi2.getSimMnc();
            if ((simMnc != null ? simMnc.intValue() : 0) <= 0) {
                Intrinsics.checkNotNullParameter("SIM_MNC", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("SIM_MNC");
                b5Var.c = false;
            }
            Integer simMcc = mnsi2.getSimMcc();
            if ((simMcc != null ? simMcc.intValue() : 0) <= 0) {
                Intrinsics.checkNotNullParameter("SIM_MCC", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("SIM_MCC");
                b5Var.c = false;
            }
            Integer valueOf = Integer.valueOf(mnsi2.getSimSlot());
            int i = -1;
            if ((valueOf != null ? valueOf.intValue() : -1) < 0) {
                Intrinsics.checkNotNullParameter("SIM_SLOT", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("SIM_SLOT");
                b5Var.c = false;
            }
            Integer isDataDefaultSim = mnsi2.isDataDefaultSim();
            if ((isDataDefaultSim != null ? isDataDefaultSim.intValue() : -1) < 0) {
                Intrinsics.checkNotNullParameter("DATA_DEFAULT_SIM", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("DATA_DEFAULT_SIM");
                b5Var.c = false;
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                Integer cid = mnsi2.getCid();
                if ((cid != null ? cid.intValue() : 0) <= 0) {
                    Intrinsics.checkNotNullParameter("CID", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("CID");
                    b5Var.c = false;
                }
            }
            Integer valueOf2 = Integer.valueOf(mnsi2.getVoiceNetworkType());
            if (valueOf2 != null) {
                i = valueOf2.intValue();
            }
            if (i < 0) {
                Intrinsics.checkNotNullParameter("VOICE_NETWORK_TYPE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("VOICE_NETWORK_TYPE");
                b5Var.c = false;
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                Long celltowerInfoTimestamp = mnsi2.getCelltowerInfoTimestamp();
                if ((celltowerInfoTimestamp != null ? celltowerInfoTimestamp.longValue() : 0) <= 0) {
                    Intrinsics.checkNotNullParameter("CELLTOWER_TIMESTAMP", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("CELLTOWER_TIMESTAMP");
                    b5Var.c = false;
                }
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                Float indoorOutdoorWeight = mnsi2.getIndoorOutdoorWeight();
                if ((indoorOutdoorWeight != null ? indoorOutdoorWeight.floatValue() : -100.0f) <= -100.0f) {
                    Intrinsics.checkNotNullParameter("INDOOR_OUTDOOR", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("INDOOR_OUTDOOR");
                    b5Var.c = false;
                }
            }
            String networkTypeString = mnsi2.getNetworkTypeString();
            if (networkTypeString == null || networkTypeString.length() == 0) {
                Intrinsics.checkNotNullParameter("NETWORK_TYPE_STRING", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("NETWORK_TYPE_STRING");
                b5Var.c = false;
            }
            if (mnsi2.getCompleteness() == dataCompleteness) {
                Integer dbm = mnsi2.getDbm();
                if ((dbm != null ? dbm.intValue() : 0) >= 0) {
                    Intrinsics.checkNotNullParameter("DBM", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("DBM");
                    b5Var.c = false;
                }
            }
            iVar2.a(b5Var, mnsi4);
        }
        if (!(mnsi3 == null || b5Var == null)) {
            Intrinsics.checkNotNullParameter(b5Var, "<this>");
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            M2Configuration m2Configuration = r2Var.g;
            int i2 = 3;
            int intValue = (m2Configuration == null || (mnsiConfiguration4 = m2Configuration.getMnsiConfiguration()) == null || (num4 = mnsiConfiguration4.c) == null) ? 3 : num4.intValue();
            float intValue2 = (m2Configuration == null || (mnsiConfiguration3 = m2Configuration.getMnsiConfiguration()) == null || (num3 = mnsiConfiguration3.b) == null) ? 5.0f : (float) num3.intValue();
            int intValue3 = (m2Configuration == null || (mnsiConfiguration2 = m2Configuration.getMnsiConfiguration()) == null || (num2 = mnsiConfiguration2.a) == null) ? 6 : num2.intValue();
            if (!(m2Configuration == null || (mnsiConfiguration = m2Configuration.getMnsiConfiguration()) == null || (num = mnsiConfiguration.d) == null)) {
                i2 = num.intValue();
            }
            if (mnsi4 != null && !o3.a(mnsi4, mnsi3)) {
                long timeStamp = mnsi2.getTimeStamp();
                Long locationTimeStamp2 = mnsi2.getLocationTimeStamp();
                Intrinsics.checkNotNull(locationTimeStamp2);
                if (Math.abs(timeStamp - locationTimeStamp2.longValue()) >= o1.c(intValue3)) {
                    Intrinsics.checkNotNullParameter("LOC_TIME_DIFF", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("LOC_TIME_DIFF");
                    b5Var.c = false;
                }
                if (!(mnsi.getNetworkType() != mnsi2.getNetworkType() || mnsi2.getNetworkType() == 0 || mnsi.getNetworkType() == 0) || Intrinsics.areEqual((Object) mnsi.getPhoneType(), (Object) mnsi2.getPhoneType())) {
                    Intrinsics.checkNotNullParameter("NOT_CHANGED_NETWORK_OR_PHONE_TYPE", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NOT_CHANGED_NETWORK_OR_PHONE_TYPE");
                    b5Var.c = false;
                }
                if (Intrinsics.areEqual((Object) mnsi.is5GConnected(), (Object) mnsi2.is5GConnected()) || Intrinsics.areEqual((Object) mnsi.isUsingCarrierAggregation(), (Object) mnsi2.isUsingCarrierAggregation()) || Intrinsics.areEqual((Object) mnsi.getOverrideNetworkType(), (Object) mnsi2.getOverrideNetworkType())) {
                    Intrinsics.checkNotNullParameter("NOT_CHANGED_OVERRIDE_AGG_OR_5G", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NOT_CHANGED_OVERRIDE_AGG_OR_5G");
                    b5Var.c = false;
                }
                if ((o3.a(mnsi) || o3.a(mnsi2)) && mnsi.isSameAntenna(mnsi2)) {
                    Intrinsics.checkNotNullParameter("NOT_CHANGED_ANTENNA", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NOT_CHANGED_ANTENNA");
                    b5Var.c = false;
                }
                float[] fArr = {0.0f};
                try {
                    Double latitude = mnsi.getLatitude();
                    Set<String> set3 = s1.a;
                    double doubleValue = latitude != null ? latitude.doubleValue() : 0.0d;
                    Double longitude = mnsi.getLongitude();
                    double doubleValue2 = longitude != null ? longitude.doubleValue() : 0.0d;
                    Double latitude2 = mnsi2.getLatitude();
                    double doubleValue3 = latitude2 != null ? latitude2.doubleValue() : 0.0d;
                    Double longitude2 = mnsi2.getLongitude();
                    if (longitude2 != null) {
                        d = longitude2.doubleValue();
                    }
                    Location.distanceBetween(doubleValue, doubleValue2, doubleValue3, d, fArr);
                    f = fArr[0];
                } catch (Exception unused) {
                    f = 0.0f;
                }
                if (f <= intValue2) {
                    Intrinsics.checkNotNullParameter("NOT_CHANGED_LOC_DISTANCE", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NOT_CHANGED_LOC_DISTANCE");
                    b5Var.c = false;
                }
                Intrinsics.checkNotNullParameter(b5Var, "<this>");
                Integer cdmaDbm = mnsi2.getCdmaDbm();
                Set<String> set4 = s1.a;
                if ((cdmaDbm != null ? cdmaDbm.intValue() : 0) != 0) {
                    Integer cdmaDbm2 = mnsi2.getCdmaDbm();
                    int intValue4 = cdmaDbm2 != null ? cdmaDbm2.intValue() : 0;
                    Integer cdmaDbm3 = mnsi.getCdmaDbm();
                    if (Math.abs(intValue4 - (cdmaDbm3 != null ? cdmaDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_CDMA", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_CDMA");
                        b5Var.c = false;
                    }
                }
                Integer evdoDbm = mnsi2.getEvdoDbm();
                if ((evdoDbm != null ? evdoDbm.intValue() : 0) != 0) {
                    Integer evdoDbm2 = mnsi2.getEvdoDbm();
                    int intValue5 = evdoDbm2 != null ? evdoDbm2.intValue() : 0;
                    Integer evdoDbm3 = mnsi.getEvdoDbm();
                    if (Math.abs(intValue5 - (evdoDbm3 != null ? evdoDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_CDMA", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_CDMA");
                        b5Var.c = false;
                    }
                }
                Integer gsmDbm = mnsi2.getGsmDbm();
                if ((gsmDbm != null ? gsmDbm.intValue() : 0) != 0) {
                    Integer gsmDbm2 = mnsi2.getGsmDbm();
                    int intValue6 = gsmDbm2 != null ? gsmDbm2.intValue() : 0;
                    Integer gsmDbm3 = mnsi.getGsmDbm();
                    if (Math.abs(intValue6 - (gsmDbm3 != null ? gsmDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_GSM", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_GSM");
                        b5Var.c = false;
                    }
                }
                Integer lteDbm = mnsi2.getLteDbm();
                if ((lteDbm != null ? lteDbm.intValue() : 0) != 0) {
                    Integer lteDbm2 = mnsi2.getLteDbm();
                    int intValue7 = lteDbm2 != null ? lteDbm2.intValue() : 0;
                    Integer lteDbm3 = mnsi.getLteDbm();
                    if (Math.abs(intValue7 - (lteDbm3 != null ? lteDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_LTE", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_LTE");
                        b5Var.c = false;
                    }
                }
                Integer nrDbm = mnsi2.getNrDbm();
                if ((nrDbm != null ? nrDbm.intValue() : 0) != 0) {
                    Integer nrDbm2 = mnsi2.getNrDbm();
                    int intValue8 = nrDbm2 != null ? nrDbm2.intValue() : 0;
                    Integer nrDbm3 = mnsi.getNrDbm();
                    if (Math.abs(intValue8 - (nrDbm3 != null ? nrDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_NR", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_NR");
                        b5Var.c = false;
                    }
                }
                Integer tdscdmaDbm = mnsi2.getTdscdmaDbm();
                if ((tdscdmaDbm != null ? tdscdmaDbm.intValue() : 0) != 0) {
                    Integer tdscdmaDbm2 = mnsi2.getTdscdmaDbm();
                    int intValue9 = tdscdmaDbm2 != null ? tdscdmaDbm2.intValue() : 0;
                    Integer tdscdmaDbm3 = mnsi.getTdscdmaDbm();
                    if (Math.abs(intValue9 - (tdscdmaDbm3 != null ? tdscdmaDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_TDSCDMA", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_TDSCDMA");
                        b5Var.c = false;
                    }
                }
                Integer wcdmaDbm = mnsi2.getWcdmaDbm();
                if ((wcdmaDbm != null ? wcdmaDbm.intValue() : 0) != 0) {
                    Integer wcdmaDbm2 = mnsi2.getWcdmaDbm();
                    int intValue10 = wcdmaDbm2 != null ? wcdmaDbm2.intValue() : 0;
                    Integer wcdmaDbm3 = mnsi.getWcdmaDbm();
                    if (Math.abs(intValue10 - (wcdmaDbm3 != null ? wcdmaDbm3.intValue() : 0)) <= intValue) {
                        Intrinsics.checkNotNullParameter("NOT_CHANGED_DBM_WCDMA", IronSourceConstants.EVENTS_ERROR_REASON);
                        b5Var.b.add("NOT_CHANGED_DBM_WCDMA");
                        b5Var.c = false;
                    }
                }
                if (Math.abs(mnsi2.getTimeStamp() - mnsi.getTimeStamp()) <= o1.b(i2)) {
                    Intrinsics.checkNotNullParameter("NOT_CHANGED_MNSI_TIME_DIFF", IronSourceConstants.EVENTS_ERROR_REASON);
                    b5Var.b.add("NOT_CHANGED_MNSI_TIME_DIFF");
                    b5Var.c = false;
                }
            }
        }
        return b5Var;
    }
}
