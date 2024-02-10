package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzafj extends zzafn {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzafj() {
        super((zzafm) null);
    }

    /* synthetic */ zzafj(zzafi zzafi) {
        super((zzafm) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.ads.interactivemedia.v3.internal.zzafg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.ads.interactivemedia.v3.internal.zzafg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.ads.interactivemedia.v3.internal.zzafg} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List zzf(java.lang.Object r3, long r4, int r6) {
        /*
            java.lang.Object r0 = com.google.ads.interactivemedia.v3.internal.zzaht.zzf(r3, r4)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzafh
            if (r1 == 0) goto L_0x0016
            com.google.ads.interactivemedia.v3.internal.zzafg r0 = new com.google.ads.interactivemedia.v3.internal.zzafg
            r0.<init>((int) r6)
            goto L_0x002b
        L_0x0016:
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzagg
            if (r1 == 0) goto L_0x0026
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzaez
            if (r1 == 0) goto L_0x0026
            com.google.ads.interactivemedia.v3.internal.zzaez r0 = (com.google.ads.interactivemedia.v3.internal.zzaez) r0
            com.google.ads.interactivemedia.v3.internal.zzaez r6 = r0.zzd(r6)
            r0 = r6
            goto L_0x002b
        L_0x0026:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x002b:
            com.google.ads.interactivemedia.v3.internal.zzaht.zzs(r3, r4, r0)
            goto L_0x0087
        L_0x002f:
            java.lang.Class r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.ads.interactivemedia.v3.internal.zzaht.zzs(r3, r4, r1)
        L_0x004b:
            r0 = r1
            goto L_0x0087
        L_0x004d:
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzaho
            if (r1 == 0) goto L_0x0068
            com.google.ads.interactivemedia.v3.internal.zzafg r1 = new com.google.ads.interactivemedia.v3.internal.zzafg
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.ads.interactivemedia.v3.internal.zzaho r0 = (com.google.ads.interactivemedia.v3.internal.zzaho) r0
            int r6 = r1.size()
            r1.addAll(r6, r0)
            com.google.ads.interactivemedia.v3.internal.zzaht.zzs(r3, r4, r1)
            goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzagg
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzaez
            if (r1 == 0) goto L_0x0087
            r1 = r0
            com.google.ads.interactivemedia.v3.internal.zzaez r1 = (com.google.ads.interactivemedia.v3.internal.zzaez) r1
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.ads.interactivemedia.v3.internal.zzaez r6 = r1.zzd(r0)
            com.google.ads.interactivemedia.v3.internal.zzaht.zzs(r3, r4, r6)
            return r6
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzafj.zzf(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzaht.zzf(obj, j);
        if (list instanceof zzafh) {
            obj2 = ((zzafh) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzagg) || !(list instanceof zzaez)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzaez zzaez = (zzaez) list;
                if (zzaez.zzc()) {
                    zzaez.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzaht.zzs(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzaht.zzf(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzaht.zzs(obj, j, list);
    }
}
