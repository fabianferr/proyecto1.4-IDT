package com.m2catalyst.m2sdk;

/* compiled from: CellInfoStrategyType.kt */
public enum t {
    a,
    b,
    c,
    d,
    e,
    f;

    /* compiled from: CellInfoStrategyType.kt */
    public static final class a {
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.m2catalyst.m2sdk.t a(android.telephony.ServiceState r4) {
            /*
                r0 = 0
                if (r4 == 0) goto L_0x0036
                java.util.List r4 = r4.getNetworkRegistrationInfoList()
                if (r4 == 0) goto L_0x0036
                java.util.Iterator r4 = r4.iterator()
            L_0x000d:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x002c
                java.lang.Object r1 = r4.next()
                r2 = r1
                android.telephony.NetworkRegistrationInfo r2 = (android.telephony.NetworkRegistrationInfo) r2
                boolean r3 = r2.isRegistered()
                if (r3 == 0) goto L_0x0028
                android.telephony.CellIdentity r2 = r2.getCellIdentity()
                if (r2 == 0) goto L_0x0028
                r2 = 1
                goto L_0x0029
            L_0x0028:
                r2 = 0
            L_0x0029:
                if (r2 == 0) goto L_0x000d
                goto L_0x002d
            L_0x002c:
                r1 = r0
            L_0x002d:
                android.telephony.NetworkRegistrationInfo r1 = (android.telephony.NetworkRegistrationInfo) r1
                if (r1 == 0) goto L_0x0036
                android.telephony.CellIdentity r4 = r1.getCellIdentity()
                goto L_0x0037
            L_0x0036:
                r4 = r0
            L_0x0037:
                boolean r1 = r4 instanceof android.telephony.CellIdentityLte
                if (r1 == 0) goto L_0x003e
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.a
                goto L_0x0060
            L_0x003e:
                boolean r1 = r4 instanceof android.telephony.CellIdentityCdma
                if (r1 == 0) goto L_0x0045
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.d
                goto L_0x0060
            L_0x0045:
                boolean r1 = r4 instanceof android.telephony.CellIdentityGsm
                if (r1 == 0) goto L_0x004c
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.b
                goto L_0x0060
            L_0x004c:
                boolean r1 = r4 instanceof android.telephony.CellIdentityWcdma
                if (r1 == 0) goto L_0x0053
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.e
                goto L_0x0060
            L_0x0053:
                boolean r1 = r4 instanceof android.telephony.CellIdentityTdscdma
                if (r1 == 0) goto L_0x005a
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.f
                goto L_0x0060
            L_0x005a:
                boolean r4 = r4 instanceof android.telephony.CellIdentityNr
                if (r4 == 0) goto L_0x0060
                com.m2catalyst.m2sdk.t r0 = com.m2catalyst.m2sdk.t.c
            L_0x0060:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.t.a.a(android.telephony.ServiceState):com.m2catalyst.m2sdk.t");
        }
    }

    /* access modifiers changed from: public */
    t() {
    }
}
