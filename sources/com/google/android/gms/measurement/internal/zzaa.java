package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzaa extends zzkn {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzkz zzkz) {
        super(zzkz);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02cc, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ce, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d6, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fb, code lost:
        if (r5 != null) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fe, code lost:
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r1 = new androidx.collection.ArrayMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030d, code lost:
        if (r13.isEmpty() == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x030f, code lost:
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0313, code lost:
        r3 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x031f, code lost:
        if (r3.hasNext() == false) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0321, code lost:
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgh) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x033b, code lost:
        if (r7 == null) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0341, code lost:
        if (r7.isEmpty() == false) goto L_0x0345;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0345, code lost:
        r17 = r0;
        r0 = r10.zzf.zzu().zzq(r6.zzk(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0359, code lost:
        if (r0.isEmpty() != false) goto L_0x0447;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x035b, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzgg) r6.zzby();
        r5.zzf();
        r5.zzb(r0);
        r20 = r3;
        r0 = r10.zzf.zzu().zzq(r6.zzn(), r7);
        r5.zzh();
        r5.zzd(r0);
        com.google.android.gms.internal.measurement.zzob.zzc();
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x038f, code lost:
        if (r10.zzs.zzf().zzs((java.lang.String) null, com.google.android.gms.measurement.internal.zzeb.zzaA) == false) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0391, code lost:
        r0 = new java.util.ArrayList();
        r3 = r6.zzj().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a2, code lost:
        if (r3.hasNext() == false) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03a4, code lost:
        r8 = (com.google.android.gms.internal.measurement.zzfq) r3.next();
        r23 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03ba, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r8.zza())) != false) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03bc, code lost:
        r0.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03bf, code lost:
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03c3, code lost:
        r5.zze();
        r5.zza(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.zzm().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03da, code lost:
        if (r3.hasNext() == false) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03dc, code lost:
        r6 = (com.google.android.gms.internal.measurement.zzgj) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ee, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzb())) != false) goto L_0x03d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03f0, code lost:
        r0.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03f4, code lost:
        r5.zzg();
        r5.zzc(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03fb, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0400, code lost:
        if (r0 >= r6.zza()) goto L_0x041a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0412, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zze(r0).zza())) == false) goto L_0x0417;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0414, code lost:
        r5.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0417, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x041a, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x041f, code lost:
        if (r0 >= r6.zzc()) goto L_0x0439;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0431, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzi(r0).zzb())) == false) goto L_0x0436;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0433, code lost:
        r5.zzj(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0436, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0439, code lost:
        r1.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgh) r5.zzaE());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0447, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x044b, code lost:
        r17 = r0;
        r20 = r3;
        r21 = r8;
        r1.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0454, code lost:
        r0 = r17;
        r3 = r20;
        r8 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x045c, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0794, code lost:
        if (r5 != null) goto L_0x0796;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0796, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x07a6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x07a7, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x07a9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x07aa, code lost:
        r29 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x07c6, code lost:
        if (r5 == null) goto L_0x07c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x07cf, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0945, code lost:
        if (r13 != null) goto L_0x0947;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0947, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x096d, code lost:
        if (r13 == null) goto L_0x0970;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0a99, code lost:
        if (r7 != false) goto L_0x0aa4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0153, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0175, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0617  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x07a6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:266:0x0702] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07cf  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x087c  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0978  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0aca  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0b5e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b4 A[Catch:{ SQLiteException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c4 A[SYNTHETIC, Splitter:B:70:0x01c4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            r64 = this;
            r10 = r64
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            r0 = r65
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r68
            r10.zzd = r0
            r0 = r69
            r10.zze = r0
            java.util.Iterator r0 = r66.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzfs r1 = (com.google.android.gms.internal.measurement.zzfs) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            com.google.android.gms.internal.measurement.zzny.zzc()
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzea r3 = com.google.android.gms.measurement.internal.zzeb.zzW
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzny.zzc()
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzea r3 = com.google.android.gms.measurement.internal.zzeb.zzV
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017e
            if (r14 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 == 0) goto L_0x014d
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.internal.measurement.zzei r13 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzlk r0 = com.google.android.gms.measurement.internal.zzlb.zzl(r13, r0)     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzaE()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012b }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0159 }
            if (r13 != 0) goto L_0x010c
            goto L_0x013d
        L_0x010c:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0159 }
            if (r16 != 0) goto L_0x0125
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0159 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0159 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x0127
        L_0x0125:
            r12 = r16
        L_0x0127:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x013d
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r12 = r2.zzs     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzeo r12 = r12.zzay()     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ SQLiteException -> 0x0159 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0159 }
        L_0x013d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 != 0) goto L_0x014a
            if (r5 == 0) goto L_0x0148
            r5.close()
        L_0x0148:
            r12 = r4
            goto L_0x017f
        L_0x014a:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014d:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0159 }
            if (r5 == 0) goto L_0x017e
        L_0x0153:
            r5.close()
            goto L_0x017e
        L_0x0157:
            r0 = move-exception
            goto L_0x0178
        L_0x0159:
            r0 = move-exception
            goto L_0x0160
        L_0x015b:
            r0 = move-exception
            r5 = 0
            goto L_0x0178
        L_0x015e:
            r0 = move-exception
            r5 = 0
        L_0x0160:
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0157 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0157 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x017e
            goto L_0x0153
        L_0x0178:
            if (r5 == 0) goto L_0x017d
            r5.close()
        L_0x017d:
            throw r0
        L_0x017e:
            r12 = r0
        L_0x017f:
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x01c4
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0228 }
            if (r4 == 0) goto L_0x01bd
            r4.close()
        L_0x01bd:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0255
        L_0x01c4:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0228 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0228 }
        L_0x01c9:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzgg r13 = com.google.android.gms.internal.measurement.zzgh.zzf()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzlk r0 = com.google.android.gms.measurement.internal.zzlb.zzl(r13, r0)     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgg r0 = (com.google.android.gms.internal.measurement.zzgg) r0     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzaE()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01f1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0228 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020f
        L_0x01f1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r13 = r2.zzs     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzay()     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ SQLiteException -> 0x0226 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0224 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0224 }
        L_0x020f:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0224 }
            if (r0 != 0) goto L_0x021d
            if (r4 == 0) goto L_0x021a
            r4.close()
        L_0x021a:
            r13 = r17
            goto L_0x0255
        L_0x021d:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c9
        L_0x0224:
            r0 = move-exception
            goto L_0x0238
        L_0x0226:
            r0 = move-exception
            goto L_0x022b
        L_0x0228:
            r0 = move-exception
            r18 = r6
        L_0x022b:
            r19 = r7
            goto L_0x0238
        L_0x022e:
            r0 = move-exception
            r5 = 0
            goto L_0x0b5c
        L_0x0232:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0238:
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs     // Catch:{ all -> 0x0b5a }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x0b5a }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x0b5a }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x0b5a }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b5a }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b5a }
            if (r4 == 0) goto L_0x0254
            r4.close()
        L_0x0254:
            r13 = r0
        L_0x0255:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0264
            r12 = r8
            r13 = r9
            r28 = r18
            r29 = r19
            goto L_0x060b
        L_0x0264:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0464
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r0.zzi()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02e2, all -> 0x02de }
            r16 = 0
            r6[r16] = r4     // Catch:{ SQLiteException -> 0x02e2, all -> 0x02de }
            r16 = 1
            r6[r16] = r4     // Catch:{ SQLiteException -> 0x02e2, all -> 0x02de }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02e2, all -> 0x02de }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02dc }
            if (r6 == 0) goto L_0x02d2
        L_0x02a1:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02dc }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02dc }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02dc }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02dc }
            if (r7 != 0) goto L_0x02ba
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02dc }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02dc }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02dc }
        L_0x02ba:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02dc }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02dc }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02dc }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02dc }
            if (r6 != 0) goto L_0x02a1
            if (r5 == 0) goto L_0x02fe
        L_0x02ce:
            r5.close()
            goto L_0x02fe
        L_0x02d2:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02dc }
            if (r5 == 0) goto L_0x02fe
            goto L_0x02ce
        L_0x02d9:
            r0 = move-exception
            goto L_0x045e
        L_0x02dc:
            r0 = move-exception
            goto L_0x02e4
        L_0x02de:
            r0 = move-exception
            r5 = 0
            goto L_0x045e
        L_0x02e2:
            r0 = move-exception
            r5 = 0
        L_0x02e4:
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzs     // Catch:{ all -> 0x02d9 }
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()     // Catch:{ all -> 0x02d9 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ all -> 0x02d9 }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeo.zzn(r4)     // Catch:{ all -> 0x02d9 }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02d9 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02d9 }
            if (r5 == 0) goto L_0x02fe
            goto L_0x02ce
        L_0x02fe:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x0313
        L_0x030f:
            r21 = r8
            goto L_0x045c
        L_0x0313:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x031b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x030f
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgh r6 = (com.google.android.gms.internal.measurement.zzgh) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x044b
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0345
            goto L_0x044b
        L_0x0345:
            com.google.android.gms.measurement.internal.zzkz r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlb r5 = r5.zzu()
            r17 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0447
            com.google.android.gms.internal.measurement.zzka r5 = r6.zzby()
            com.google.android.gms.internal.measurement.zzgg r5 = (com.google.android.gms.internal.measurement.zzgg) r5
            r5.zzf()
            r5.zzb(r0)
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzlb r0 = r0.zzu()
            r20 = r3
            java.util.List r3 = r6.zzn()
            java.util.List r0 = r0.zzq(r3, r7)
            r5.zzh()
            r5.zzd(r0)
            com.google.android.gms.internal.measurement.zzob.zzc()
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            com.google.android.gms.measurement.internal.zzea r3 = com.google.android.gms.measurement.internal.zzeb.zzaA
            r21 = r8
            r8 = 0
            boolean r0 = r0.zzs(r8, r3)
            if (r0 == 0) goto L_0x03fb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x039e:
            boolean r22 = r3.hasNext()
            if (r22 == 0) goto L_0x03c3
            java.lang.Object r22 = r3.next()
            r8 = r22
            com.google.android.gms.internal.measurement.zzfq r8 = (com.google.android.gms.internal.measurement.zzfq) r8
            int r22 = r8.zza()
            r23 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            boolean r3 = r7.contains(r3)
            if (r3 != 0) goto L_0x03bf
            r0.add(r8)
        L_0x03bf:
            r3 = r23
            r8 = 0
            goto L_0x039e
        L_0x03c3:
            r5.zze()
            r5.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzm()
            java.util.Iterator r3 = r3.iterator()
        L_0x03d6:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x03f4
            java.lang.Object r6 = r3.next()
            com.google.android.gms.internal.measurement.zzgj r6 = (com.google.android.gms.internal.measurement.zzgj) r6
            int r8 = r6.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x03d6
            r0.add(r6)
            goto L_0x03d6
        L_0x03f4:
            r5.zzg()
            r5.zzc(r0)
            goto L_0x0439
        L_0x03fb:
            r0 = 0
        L_0x03fc:
            int r3 = r6.zza()
            if (r0 >= r3) goto L_0x041a
            com.google.android.gms.internal.measurement.zzfq r3 = r6.zze(r0)
            int r3 = r3.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0417
            r5.zzi(r0)
        L_0x0417:
            int r0 = r0 + 1
            goto L_0x03fc
        L_0x041a:
            r0 = 0
        L_0x041b:
            int r3 = r6.zzc()
            if (r0 >= r3) goto L_0x0439
            com.google.android.gms.internal.measurement.zzgj r3 = r6.zzi(r0)
            int r3 = r3.zzb()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0436
            r5.zzj(r0)
        L_0x0436:
            int r0 = r0 + 1
            goto L_0x041b
        L_0x0439:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzke r3 = r5.zzaE()
            com.google.android.gms.internal.measurement.zzgh r3 = (com.google.android.gms.internal.measurement.zzgh) r3
            r1.put(r0, r3)
            goto L_0x0454
        L_0x0447:
            r0 = r17
            goto L_0x031b
        L_0x044b:
            r17 = r0
            r20 = r3
            r21 = r8
            r1.put(r5, r6)
        L_0x0454:
            r0 = r17
            r3 = r20
            r8 = r21
            goto L_0x031b
        L_0x045c:
            r0 = r1
            goto L_0x0467
        L_0x045e:
            if (r5 == 0) goto L_0x0463
            r5.close()
        L_0x0463:
            throw r0
        L_0x0464:
            r21 = r8
            r0 = r13
        L_0x0467:
            java.util.Iterator r17 = r2.iterator()
        L_0x046b:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0604
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r20 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgh r1 = (com.google.android.gms.internal.measurement.zzgh) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x04d3
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x049d
            goto L_0x04d3
        L_0x049d:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x04a5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d3
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfq r3 = (com.google.android.gms.internal.measurement.zzfq) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x04a5
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x04ce
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x04cf
        L_0x04ce:
            r3 = 0
        L_0x04cf:
            r7.put(r4, r3)
            goto L_0x04a5
        L_0x04d3:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x051f
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x04e1
            goto L_0x051f
        L_0x04e1:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x04e9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x051f
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgj r3 = (com.google.android.gms.internal.measurement.zzgj) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x04e9
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x04e9
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x04e9
        L_0x051f:
            r23 = r0
            if (r1 == 0) goto L_0x056e
            r0 = 0
        L_0x0524:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x056e
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzlb.zzv(r2, r0)
            if (r2 == 0) goto L_0x0560
            com.google.android.gms.measurement.internal.zzfy r2 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzlb.zzv(r2, r0)
            if (r2 == 0) goto L_0x0562
            r5.set(r0)
            goto L_0x0569
        L_0x0560:
            r22 = r9
        L_0x0562:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0569:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x0524
        L_0x056e:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgh r4 = (com.google.android.gms.internal.measurement.zzgh) r4
            if (r15 == 0) goto L_0x05db
            if (r14 == 0) goto L_0x05db
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x05db
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x05db
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x0590
            goto L_0x05db
        L_0x0590:
            java.util.Iterator r0 = r0.iterator()
        L_0x0594:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05db
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzej r1 = (com.google.android.gms.internal.measurement.zzej) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x05bc
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x05bc:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x05cd
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x05cd:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0594
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0594
        L_0x05db:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r64
            r28 = r18
            r29 = r19
            r16 = r12
            r12 = r21
            r65 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r1.put(r2, r0)
            r9 = r13
            r12 = r16
            r0 = r23
            r13 = r65
            goto L_0x046b
        L_0x0604:
            r13 = r9
            r28 = r18
            r29 = r19
            r12 = r21
        L_0x060b:
            boolean r0 = r66.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x0617
        L_0x0613:
            r24 = r11
            goto L_0x0872
        L_0x0617:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r66.iterator()
        L_0x0626:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0613
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzfs r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x0626
            com.google.android.gms.measurement.internal.zzkz r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r7 = r7.zzi()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzas r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x068f
            com.google.android.gms.measurement.internal.zzfy r14 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeo.zzn(r8)
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r30 = r7
            java.lang.String r32 = r0.zzh()
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r0.zzd()
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r31 = r8
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)
            goto L_0x06c4
        L_0x068f:
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r47 = r7
            java.lang.String r0 = r14.zza
            r48 = r0
            java.lang.String r0 = r14.zzb
            r49 = r0
            long r8 = r14.zzc
            r15 = 1
            long r50 = r8 + r15
            long r8 = r14.zzd
            long r52 = r8 + r15
            long r8 = r14.zze
            long r54 = r8 + r15
            long r8 = r14.zzf
            r56 = r8
            long r8 = r14.zzg
            r58 = r8
            java.lang.Long r0 = r14.zzh
            r60 = r0
            java.lang.Long r0 = r14.zzi
            r61 = r0
            java.lang.Long r0 = r14.zzj
            r62 = r0
            java.lang.Boolean r0 = r14.zzk
            r63 = r0
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r60, r61, r62, r63)
        L_0x06c4:
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r0 = r0.zzi()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07d3
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r15 = r0.zzi()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r65 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r15.zzh()
            r66 = r5
            r24 = r11
            r11 = r28
            r5 = r29
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x07a9, all -> 0x07a6 }
            r29 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x07a4, all -> 0x07a6 }
            r17 = 0
            r0[r17] = r3     // Catch:{ SQLiteException -> 0x07a4, all -> 0x07a6 }
            r17 = 1
            r0[r17] = r14     // Catch:{ SQLiteException -> 0x07a4, all -> 0x07a6 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x07a4, all -> 0x07a6 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x079e }
            if (r0 == 0) goto L_0x078c
            r28 = r11
        L_0x072b:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0788 }
            com.google.android.gms.internal.measurement.zzei r11 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x0764 }
            com.google.android.gms.internal.measurement.zzlk r0 = com.google.android.gms.measurement.internal.zzlb.zzl(r11, r0)     // Catch:{ IOException -> 0x0764 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x0764 }
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzaE()     // Catch:{ IOException -> 0x0764 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0764 }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x0788 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0788 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x0788 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0788 }
            if (r16 != 0) goto L_0x075c
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x079a }
            r7.<init>()     // Catch:{ SQLiteException -> 0x079a }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x079a }
            goto L_0x0760
        L_0x075c:
            r22 = r7
            r7 = r16
        L_0x0760:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x079a }
            goto L_0x0778
        L_0x0764:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.zzfy r7 = r15.zzs     // Catch:{ SQLiteException -> 0x079a }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzay()     // Catch:{ SQLiteException -> 0x079a }
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x079a }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ SQLiteException -> 0x079a }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x079a }
        L_0x0778:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x079a }
            if (r0 != 0) goto L_0x0785
            if (r5 == 0) goto L_0x0783
            r5.close()
        L_0x0783:
            r0 = r2
            goto L_0x07c9
        L_0x0785:
            r7 = r22
            goto L_0x072b
        L_0x0788:
            r0 = move-exception
            r22 = r7
            goto L_0x07b1
        L_0x078c:
            r22 = r7
            r28 = r11
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x079a }
            if (r5 == 0) goto L_0x07c9
        L_0x0796:
            r5.close()
            goto L_0x07c9
        L_0x079a:
            r0 = move-exception
            goto L_0x07b1
        L_0x079c:
            r0 = move-exception
            goto L_0x07cd
        L_0x079e:
            r0 = move-exception
            r22 = r7
            r28 = r11
            goto L_0x07b1
        L_0x07a4:
            r0 = move-exception
            goto L_0x07ac
        L_0x07a6:
            r0 = move-exception
            r5 = 0
            goto L_0x07cd
        L_0x07a9:
            r0 = move-exception
            r29 = r5
        L_0x07ac:
            r22 = r7
            r28 = r11
            r5 = 0
        L_0x07b1:
            com.google.android.gms.measurement.internal.zzfy r2 = r15.zzs     // Catch:{ all -> 0x079c }
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch:{ all -> 0x079c }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch:{ all -> 0x079c }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r3)     // Catch:{ all -> 0x079c }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x079c }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x079c }
            if (r5 == 0) goto L_0x07c9
            goto L_0x0796
        L_0x07c9:
            r4.put(r14, r0)
            goto L_0x07db
        L_0x07cd:
            if (r5 == 0) goto L_0x07d2
            r5.close()
        L_0x07d2:
            throw r0
        L_0x07d3:
            r65 = r2
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x07db:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07e3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0869
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x080d
            com.google.android.gms.measurement.internal.zzfy r3 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x07e3
        L_0x080d:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x0818:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x085c
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzej r7 = (com.google.android.gms.internal.measurement.zzej) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r15 = r10.zzd
            java.lang.Long r14 = r10.zze
            int r7 = r7.zzb()
            boolean r21 = r10.zzf(r3, r7)
            r7 = r14
            r14 = r11
            r16 = r7
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r7 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r7 == 0) goto L_0x0853
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x0818
        L_0x0853:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x085c:
            if (r7 != 0) goto L_0x07e3
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x07e3
        L_0x0869:
            r2 = r65
            r5 = r66
            r11 = r24
            r3 = 0
            goto L_0x0626
        L_0x0872:
            boolean r0 = r67.isEmpty()
            if (r0 == 0) goto L_0x087c
        L_0x0878:
            r11 = r28
            goto L_0x0ab0
        L_0x087c:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r67.iterator()
        L_0x0885:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0878
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgl r4 = (com.google.android.gms.internal.measurement.zzgl) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x097c
            com.google.android.gms.measurement.internal.zzkz r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0954, all -> 0x0951 }
            r14 = 2
            java.lang.String[] r0 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0954, all -> 0x0951 }
            r14 = 0
            r0[r14] = r7     // Catch:{ SQLiteException -> 0x0954, all -> 0x0951 }
            r14 = 1
            r0[r14] = r5     // Catch:{ SQLiteException -> 0x0954, all -> 0x0951 }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0954, all -> 0x0951 }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x094d }
            if (r0 == 0) goto L_0x093f
        L_0x08e2:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x094d }
            com.google.android.gms.internal.measurement.zzer r15 = com.google.android.gms.internal.measurement.zzes.zzc()     // Catch:{ IOException -> 0x0919 }
            com.google.android.gms.internal.measurement.zzlk r0 = com.google.android.gms.measurement.internal.zzlb.zzl(r15, r0)     // Catch:{ IOException -> 0x0919 }
            com.google.android.gms.internal.measurement.zzer r0 = (com.google.android.gms.internal.measurement.zzer) r0     // Catch:{ IOException -> 0x0919 }
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzaE()     // Catch:{ IOException -> 0x0919 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x0919 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x094d }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x094d }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x094d }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x094d }
            if (r16 != 0) goto L_0x0911
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x094d }
            r15.<init>()     // Catch:{ SQLiteException -> 0x094d }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x094d }
            goto L_0x0913
        L_0x0911:
            r15 = r16
        L_0x0913:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x094d }
            r65 = r3
            goto L_0x092f
        L_0x0919:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r14 = r6.zzs     // Catch:{ SQLiteException -> 0x094d }
            com.google.android.gms.measurement.internal.zzeo r14 = r14.zzay()     // Catch:{ SQLiteException -> 0x094d }
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x094d }
            java.lang.String r15 = "Failed to merge filter"
            r65 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)     // Catch:{ SQLiteException -> 0x094b }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x094b }
        L_0x092f:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x094b }
            if (r0 != 0) goto L_0x093c
            if (r13 == 0) goto L_0x093a
            r13.close()
        L_0x093a:
            r0 = r8
            goto L_0x0970
        L_0x093c:
            r3 = r65
            goto L_0x08e2
        L_0x093f:
            r65 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x094b }
            if (r13 == 0) goto L_0x0970
        L_0x0947:
            r13.close()
            goto L_0x0970
        L_0x094b:
            r0 = move-exception
            goto L_0x0958
        L_0x094d:
            r0 = move-exception
            r65 = r3
            goto L_0x0958
        L_0x0951:
            r0 = move-exception
            r5 = 0
            goto L_0x0976
        L_0x0954:
            r0 = move-exception
            r65 = r3
            r13 = 0
        L_0x0958:
            com.google.android.gms.measurement.internal.zzfy r3 = r6.zzs     // Catch:{ all -> 0x0974 }
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()     // Catch:{ all -> 0x0974 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()     // Catch:{ all -> 0x0974 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)     // Catch:{ all -> 0x0974 }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x0974 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0974 }
            if (r13 == 0) goto L_0x0970
            goto L_0x0947
        L_0x0970:
            r2.put(r5, r0)
            goto L_0x0982
        L_0x0974:
            r0 = move-exception
            r5 = r13
        L_0x0976:
            if (r5 == 0) goto L_0x097b
            r5.close()
        L_0x097b:
            throw r0
        L_0x097c:
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x0982:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x098a:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0aa8
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x09b5
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0aa8
        L_0x09b5:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x09c0:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a97
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            com.google.android.gms.measurement.internal.zzfy r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r8 = r8.zzay()
            java.lang.String r8 = r8.zzq()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x0a2a
            com.google.android.gms.measurement.internal.zzfy r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r8 = r8.zzay()
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x09fa
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09fb
        L_0x09fa:
            r15 = 0
        L_0x09fb:
            com.google.android.gms.measurement.internal.zzfy r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzej r13 = r13.zzj()
            r66 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzkz r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzlb r8 = r8.zzu()
            java.lang.String r8 = r8.zzp(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x0a2c
        L_0x0a2a:
            r66 = r0
        L_0x0a2c:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a6d
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x0a3b
            goto L_0x0a6d
        L_0x0a3b:
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a63
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzu r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r66
            goto L_0x09c0
        L_0x0a63:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a99
        L_0x0a6d:
            com.google.android.gms.measurement.internal.zzfy r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a8c
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a8d
        L_0x0a8c:
            r7 = 0
        L_0x0a8d:
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.zzc(r8, r6, r7)
            goto L_0x0a9b
        L_0x0a97:
            r66 = r0
        L_0x0a99:
            if (r7 != 0) goto L_0x0aa4
        L_0x0a9b:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0aa4:
            r0 = r66
            goto L_0x098a
        L_0x0aa8:
            r3 = r65
            r29 = r9
            r28 = r11
            goto L_0x0885
        L_0x0ab0:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0ac4:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b59
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfo r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzkz r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgh r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbv()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r24
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0b40 }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0b3e }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b55
            com.google.android.gms.measurement.internal.zzfy r0 = r3.zzs     // Catch:{ SQLiteException -> 0x0b3e }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0b3e }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0b3e }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeo.zzn(r5)     // Catch:{ SQLiteException -> 0x0b3e }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0b3e }
            goto L_0x0b55
        L_0x0b3e:
            r0 = move-exception
            goto L_0x0b42
        L_0x0b40:
            r0 = move-exception
            r9 = 0
        L_0x0b42:
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzd()
            java.lang.String r6 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeo.zzn(r5)
            r3.zzc(r6, r5, r0)
        L_0x0b55:
            r24 = r4
            goto L_0x0ac4
        L_0x0b59:
            return r1
        L_0x0b5a:
            r0 = move-exception
            r5 = r4
        L_0x0b5c:
            if (r5 == 0) goto L_0x0b61
            r5.close()
        L_0x0b61:
            goto L_0x0b63
        L_0x0b62:
            throw r0
        L_0x0b63:
            goto L_0x0b62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
