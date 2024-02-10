package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzz extends zzbg {
    private final AdErrorEvent adErrorEvent;
    private final zzbe component;
    private final zzbi loggableException;
    private final zzbf method;
    private final long timestamp;

    zzz(long j, zzbe zzbe, zzbf zzbf, AdErrorEvent adErrorEvent2, zzbi zzbi) {
        this.timestamp = j;
        this.component = zzbe;
        this.method = zzbf;
        this.adErrorEvent = adErrorEvent2;
        this.loggableException = zzbi;
    }

    public AdErrorEvent adErrorEvent() {
        return this.adErrorEvent;
    }

    public zzbe component() {
        return this.component;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r1 = r7.method;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r1 = r7.adErrorEvent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r1 = r7.loggableException;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r1 = r7.component;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.ads.interactivemedia.v3.impl.data.zzbg
            r2 = 0
            if (r1 == 0) goto L_0x006b
            com.google.ads.interactivemedia.v3.impl.data.zzbg r8 = (com.google.ads.interactivemedia.v3.impl.data.zzbg) r8
            long r3 = r7.timestamp
            long r5 = r8.timestamp()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x006b
            com.google.ads.interactivemedia.v3.impl.data.zzbe r1 = r7.component
            if (r1 != 0) goto L_0x0020
            com.google.ads.interactivemedia.v3.impl.data.zzbe r1 = r8.component()
            if (r1 != 0) goto L_0x006b
            goto L_0x002a
        L_0x0020:
            com.google.ads.interactivemedia.v3.impl.data.zzbe r3 = r8.component()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006b
        L_0x002a:
            com.google.ads.interactivemedia.v3.impl.data.zzbf r1 = r7.method
            if (r1 != 0) goto L_0x0035
            com.google.ads.interactivemedia.v3.impl.data.zzbf r1 = r8.method()
            if (r1 != 0) goto L_0x006b
            goto L_0x003f
        L_0x0035:
            com.google.ads.interactivemedia.v3.impl.data.zzbf r3 = r8.method()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006b
        L_0x003f:
            com.google.ads.interactivemedia.v3.api.AdErrorEvent r1 = r7.adErrorEvent
            if (r1 != 0) goto L_0x004a
            com.google.ads.interactivemedia.v3.api.AdErrorEvent r1 = r8.adErrorEvent()
            if (r1 != 0) goto L_0x006b
            goto L_0x0054
        L_0x004a:
            com.google.ads.interactivemedia.v3.api.AdErrorEvent r3 = r8.adErrorEvent()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006b
        L_0x0054:
            com.google.ads.interactivemedia.v3.impl.data.zzbi r1 = r7.loggableException
            if (r1 != 0) goto L_0x005f
            com.google.ads.interactivemedia.v3.impl.data.zzbi r8 = r8.loggableException()
            if (r8 != 0) goto L_0x006b
            goto L_0x006a
        L_0x005f:
            com.google.ads.interactivemedia.v3.impl.data.zzbi r8 = r8.loggableException()
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            return r0
        L_0x006b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.data.zzz.equals(java.lang.Object):boolean");
    }

    public zzbi loggableException() {
        return this.loggableException;
    }

    public zzbf method() {
        return this.method;
    }

    public long timestamp() {
        return this.timestamp;
    }

    public String toString() {
        long j = this.timestamp;
        String valueOf = String.valueOf(this.component);
        String valueOf2 = String.valueOf(this.method);
        String valueOf3 = String.valueOf(this.adErrorEvent);
        String valueOf4 = String.valueOf(this.loggableException);
        return "InstrumentationData{timestamp=" + j + ", component=" + valueOf + ", method=" + valueOf2 + ", adErrorEvent=" + valueOf3 + ", loggableException=" + valueOf4 + "}";
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        long j = this.timestamp;
        long j2 = j ^ (j >>> 32);
        zzbe zzbe = this.component;
        int i4 = 0;
        if (zzbe == null) {
            i = 0;
        } else {
            i = zzbe.hashCode();
        }
        int i5 = (int) j2;
        zzbf zzbf = this.method;
        if (zzbf == null) {
            i2 = 0;
        } else {
            i2 = zzbf.hashCode();
        }
        int i6 = ((i5 ^ 1000003) * 1000003) ^ i;
        AdErrorEvent adErrorEvent2 = this.adErrorEvent;
        if (adErrorEvent2 == null) {
            i3 = 0;
        } else {
            i3 = adErrorEvent2.hashCode();
        }
        int i7 = (((i2 ^ (i6 * 1000003)) * 1000003) ^ i3) * 1000003;
        zzbi zzbi = this.loggableException;
        if (zzbi != null) {
            i4 = zzbi.hashCode();
        }
        return i7 ^ i4;
    }
}
