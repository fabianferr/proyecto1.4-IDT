package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public abstract class zzia {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzhy zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzic zzh = new zzic(zzhs.zza, (byte[]) null);
    private static final AtomicInteger zzi = new AtomicInteger();
    final zzhx zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;

    /* synthetic */ zzia(zzhx zzhx, String str, Object obj, boolean z, zzhz zzhz) {
        if (zzhx.zzb != null) {
            this.zza = zzhx;
            this.zzb = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void zze(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.zzhy r0 = zze
            if (r0 != 0) goto L_0x0045
            java.lang.Object r0 = zzd
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzhy r1 = zze     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0040
            monitor-enter(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.measurement.zzhy r1 = zze     // Catch:{ all -> 0x003d }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0015
            r3 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001d
            android.content.Context r1 = r1.zza()     // Catch:{ all -> 0x003d }
            if (r1 == r3) goto L_0x003b
        L_0x001d:
            com.google.android.gms.internal.measurement.zzhe.zze()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzib.zzc()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhm.zze()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhr r1 = new com.google.android.gms.internal.measurement.zzhr     // Catch:{ all -> 0x003d }
            r1.<init>(r3)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzih r1 = com.google.android.gms.internal.measurement.zzil.zza(r1)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhb r2 = new com.google.android.gms.internal.measurement.zzhb     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            zze = r2     // Catch:{ all -> 0x003d }
            java.util.concurrent.atomic.AtomicInteger r3 = zzi     // Catch:{ all -> 0x003d }
            r3.incrementAndGet()     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r3     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r3
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzia.zze(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        r2 = r2.zzb(zzc());
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r6.zzb
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r6.zzk
            if (r1 >= r0) goto L_0x00e2
            monitor-enter(r6)
            int r1 = r6.zzk     // Catch:{ all -> 0x00df }
            if (r1 >= r0) goto L_0x00dd
            com.google.android.gms.internal.measurement.zzhy r1 = zze     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x00d7
            com.google.android.gms.internal.measurement.zzhx r2 = r6.zza     // Catch:{ all -> 0x00df }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x00df }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x00df }
            r3 = 0
            if (r2 == 0) goto L_0x0056
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhx r4 = r6.zza     // Catch:{ all -> 0x00df }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x00df }
            boolean r2 = com.google.android.gms.internal.measurement.zzho.zza(r2, r4)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x0054
            com.google.android.gms.internal.measurement.zzhx r2 = r6.zza     // Catch:{ all -> 0x00df }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x00df }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00df }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhx r4 = r6.zza     // Catch:{ all -> 0x00df }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhq r5 = com.google.android.gms.internal.measurement.zzhq.zza     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhe r2 = com.google.android.gms.internal.measurement.zzhe.zza(r2, r4, r5)     // Catch:{ all -> 0x00df }
            goto L_0x0064
        L_0x0054:
            r2 = r3
            goto L_0x0064
        L_0x0056:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhx r4 = r6.zza     // Catch:{ all -> 0x00df }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhq r4 = com.google.android.gms.internal.measurement.zzhq.zza     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzib r2 = com.google.android.gms.internal.measurement.zzib.zza(r2, r3, r4)     // Catch:{ all -> 0x00df }
        L_0x0064:
            if (r2 == 0) goto L_0x0075
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x00df }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x0075
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x00df }
            goto L_0x0076
        L_0x0075:
            r2 = r3
        L_0x0076:
            if (r2 == 0) goto L_0x0079
            goto L_0x00a5
        L_0x0079:
            com.google.android.gms.internal.measurement.zzhx r2 = r6.zza     // Catch:{ all -> 0x00df }
            boolean r4 = r2.zze     // Catch:{ all -> 0x00df }
            if (r4 != 0) goto L_0x00a0
            com.google.android.gms.internal.measurement.zzie r2 = r2.zzi     // Catch:{ all -> 0x00df }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza(r2)     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhx r4 = r6.zza     // Catch:{ all -> 0x00df }
            boolean r5 = r4.zze     // Catch:{ all -> 0x00df }
            if (r5 == 0) goto L_0x0091
            r4 = r3
            goto L_0x0095
        L_0x0091:
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x00df }
            java.lang.String r4 = r6.zzb     // Catch:{ all -> 0x00df }
        L_0x0095:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x00df }
            goto L_0x00a1
        L_0x00a0:
            r2 = r3
        L_0x00a1:
            if (r2 != 0) goto L_0x00a5
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x00df }
        L_0x00a5:
            com.google.android.gms.internal.measurement.zzih r1 = r1.zzb()     // Catch:{ all -> 0x00df }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzif r1 = (com.google.android.gms.internal.measurement.zzif) r1     // Catch:{ all -> 0x00df }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x00df }
            if (r4 == 0) goto L_0x00d2
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhg r1 = (com.google.android.gms.internal.measurement.zzhg) r1     // Catch:{ all -> 0x00df }
            com.google.android.gms.internal.measurement.zzhx r2 = r6.zza     // Catch:{ all -> 0x00df }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x00df }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r6.zzb     // Catch:{ all -> 0x00df }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x00df }
            if (r1 != 0) goto L_0x00ce
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x00df }
            goto L_0x00d2
        L_0x00ce:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x00df }
        L_0x00d2:
            r6.zzl = r2     // Catch:{ all -> 0x00df }
            r6.zzk = r0     // Catch:{ all -> 0x00df }
            goto L_0x00dd
        L_0x00d7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00df }
            r0.<init>(r2)     // Catch:{ all -> 0x00df }
            throw r0     // Catch:{ all -> 0x00df }
        L_0x00dd:
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            throw r0
        L_0x00e2:
            java.lang.Object r0 = r6.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzia.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
