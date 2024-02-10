package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public abstract class zzcr implements zzcq {
    protected static volatile zzdu zza;
    protected MotionEvent zzb;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected boolean zzp = false;
    protected DisplayMetrics zzq;
    private double zzr;
    private double zzs;
    private boolean zzt = false;

    protected zzcr(Context context) {
        try {
            if (((Boolean) zzfv.zzc().zzb(zzgk.zzcw)).booleanValue()) {
                zzbn.zzd();
            } else {
                zzdv.zza(zza);
            }
            this.zzq = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063 A[SYNTHETIC, Splitter:B:24:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce A[SYNTHETIC, Splitter:B:57:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzl(android.content.Context r22, java.lang.String r23, int r24, android.view.View r25, android.app.Activity r26, byte[] r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = 3
            r7 = 0
            if (r5 == 0) goto L_0x0022
            int r8 = r5.length
            if (r8 <= 0) goto L_0x0022
            com.google.android.gms.internal.pal.zzacm r8 = com.google.android.gms.internal.pal.zzacm.zza()     // Catch:{ zzadi -> 0x0021, NullPointerException -> 0x001c }
            com.google.android.gms.internal.pal.zzi r5 = com.google.android.gms.internal.pal.zzi.zzc(r5, r8)     // Catch:{ zzadi -> 0x0021, NullPointerException -> 0x001c }
            goto L_0x0023
        L_0x001c:
            java.lang.String r0 = java.lang.Integer.toString(r6)
            return r0
        L_0x0021:
        L_0x0022:
            r5 = r7
        L_0x0023:
            long r8 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.pal.zzgc r10 = com.google.android.gms.internal.pal.zzgk.zzcd
            com.google.android.gms.internal.pal.zzgi r11 = com.google.android.gms.internal.pal.zzfv.zzc()
            java.lang.Object r10 = r11.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r11 = 1
            if (r10 == 0) goto L_0x005e
            com.google.android.gms.internal.pal.zzdu r12 = zza
            if (r12 == 0) goto L_0x0045
            com.google.android.gms.internal.pal.zzdu r12 = zza
            com.google.android.gms.internal.pal.zzcp r12 = r12.zzd()
            goto L_0x0046
        L_0x0045:
            r12 = r7
        L_0x0046:
            com.google.android.gms.internal.pal.zzgc r13 = com.google.android.gms.internal.pal.zzgk.zzcw
            com.google.android.gms.internal.pal.zzgi r14 = com.google.android.gms.internal.pal.zzfv.zzc()
            java.lang.Object r13 = r14.zzb(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r11 == r13) goto L_0x005b
            java.lang.String r13 = "te"
            goto L_0x0060
        L_0x005b:
            java.lang.String r13 = "be"
            goto L_0x0060
        L_0x005e:
            r12 = r7
            r13 = r12
        L_0x0060:
            r15 = 2
            if (r2 != r6) goto L_0x0076
            com.google.android.gms.internal.pal.zzr r7 = r1.zzh(r0, r3, r4)     // Catch:{ Exception -> 0x0073 }
            r1.zzt = r11     // Catch:{ Exception -> 0x006e }
            r0 = 1002(0x3ea, float:1.404E-42)
            r3 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0086
        L_0x006e:
            r0 = move-exception
            r20 = r0
            r4 = 2
            goto L_0x00a3
        L_0x0073:
            r0 = move-exception
            r4 = 2
            goto L_0x00a1
        L_0x0076:
            if (r2 != r15) goto L_0x007f
            com.google.android.gms.internal.pal.zzr r0 = r1.zzj(r0, r3, r4)     // Catch:{ Exception -> 0x0073 }
            r3 = 1008(0x3f0, float:1.413E-42)
            goto L_0x0085
        L_0x007f:
            com.google.android.gms.internal.pal.zzr r0 = r1.zzi(r0, r5)     // Catch:{ Exception -> 0x0073 }
            r3 = 1000(0x3e8, float:1.401E-42)
        L_0x0085:
            r7 = r0
        L_0x0086:
            if (r10 == 0) goto L_0x009f
            if (r12 == 0) goto L_0x009f
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0073 }
            long r17 = r4 - r8
            r16 = -1
            r20 = 0
            r14 = r12
            r4 = 2
            r15 = r3
            r19 = r13
            r14.zzc(r15, r16, r17, r19, r20)     // Catch:{ Exception -> 0x009d }
            goto L_0x00c8
        L_0x009d:
            r0 = move-exception
            goto L_0x00a1
        L_0x009f:
            r4 = 2
            goto L_0x00c8
        L_0x00a1:
            r20 = r0
        L_0x00a3:
            if (r10 == 0) goto L_0x00c8
            if (r12 == 0) goto L_0x00c8
            if (r2 != r6) goto L_0x00ae
            r0 = 1003(0x3eb, float:1.406E-42)
            r15 = 1003(0x3eb, float:1.406E-42)
            goto L_0x00ba
        L_0x00ae:
            if (r2 != r4) goto L_0x00b5
            r0 = 1009(0x3f1, float:1.414E-42)
            r15 = 1009(0x3f1, float:1.414E-42)
            goto L_0x00ba
        L_0x00b5:
            r0 = 1001(0x3e9, float:1.403E-42)
            r2 = 1
            r15 = 1001(0x3e9, float:1.403E-42)
        L_0x00ba:
            r16 = -1
            long r17 = java.lang.System.currentTimeMillis()
            long r17 = r17 - r8
            r14 = r12
            r19 = r13
            r14.zzc(r15, r16, r17, r19, r20)
        L_0x00c8:
            long r8 = java.lang.System.currentTimeMillis()
            if (r7 == 0) goto L_0x0110
            com.google.android.gms.internal.pal.zzacz r0 = r7.zzan()     // Catch:{ Exception -> 0x0116 }
            com.google.android.gms.internal.pal.zzaf r0 = (com.google.android.gms.internal.pal.zzaf) r0     // Catch:{ Exception -> 0x0116 }
            int r0 = r0.zzat()     // Catch:{ Exception -> 0x0116 }
            if (r0 != 0) goto L_0x00db
            goto L_0x0110
        L_0x00db:
            com.google.android.gms.internal.pal.zzacz r0 = r7.zzan()     // Catch:{ Exception -> 0x0116 }
            com.google.android.gms.internal.pal.zzaf r0 = (com.google.android.gms.internal.pal.zzaf) r0     // Catch:{ Exception -> 0x0116 }
            r3 = r23
            java.lang.String r0 = com.google.android.gms.internal.pal.zzbn.zza(r0, r3)     // Catch:{ Exception -> 0x0116 }
            if (r10 == 0) goto L_0x0142
            if (r12 == 0) goto L_0x0142
            if (r2 != r6) goto L_0x00f2
            r3 = 1006(0x3ee, float:1.41E-42)
            r15 = 1006(0x3ee, float:1.41E-42)
            goto L_0x00fd
        L_0x00f2:
            if (r2 != r4) goto L_0x00f9
            r3 = 1010(0x3f2, float:1.415E-42)
            r15 = 1010(0x3f2, float:1.415E-42)
            goto L_0x00fd
        L_0x00f9:
            r3 = 1004(0x3ec, float:1.407E-42)
            r15 = 1004(0x3ec, float:1.407E-42)
        L_0x00fd:
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0116 }
            long r18 = r16 - r8
            r16 = -1
            r20 = 0
            r14 = r12
            r17 = r18
            r19 = r13
            r14.zzc(r15, r16, r17, r19, r20)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0142
        L_0x0110:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0142
        L_0x0116:
            r0 = move-exception
            r20 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r10 == 0) goto L_0x0142
            if (r12 == 0) goto L_0x0142
            if (r2 != r6) goto L_0x0129
            r2 = 1007(0x3ef, float:1.411E-42)
            r15 = 1007(0x3ef, float:1.411E-42)
            goto L_0x0134
        L_0x0129:
            if (r2 != r4) goto L_0x0130
            r2 = 1011(0x3f3, float:1.417E-42)
            r15 = 1011(0x3f3, float:1.417E-42)
            goto L_0x0134
        L_0x0130:
            r2 = 1005(0x3ed, float:1.408E-42)
            r15 = 1005(0x3ed, float:1.408E-42)
        L_0x0134:
            r16 = -1
            long r2 = java.lang.System.currentTimeMillis()
            long r17 = r2 - r8
            r14 = r12
            r19 = r13
            r14.zzc(r15, r16, r17, r19, r20)
        L_0x0142:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzcr.zzl(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return zzl(context, str, 3, view, activity, (byte[]) null);
    }

    public final String zzb(Context context) {
        if (!zzdx.zzf()) {
            return zzl(context, (String) null, 1, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public final String zzc(Context context, byte[] bArr) {
        if (!zzdx.zzf()) {
            return zzl(context, (String) null, 1, (View) null, (Activity) null, bArr);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public final String zzd(Context context, View view, Activity activity) {
        return zzl(context, (String) null, 2, view, activity, (byte[]) null);
    }

    public final synchronized void zze(MotionEvent motionEvent) {
        Long l;
        if (this.zzt) {
            this.zzh = 0;
            this.zzd = 0;
            this.zze = 0;
            this.zzf = 0;
            this.zzg = 0;
            this.zzi = 0;
            this.zzj = 0;
            if (this.zzc.size() > 0) {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    ((MotionEvent) it.next()).recycle();
                }
                this.zzc.clear();
            } else {
                MotionEvent motionEvent2 = this.zzb;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
            }
            this.zzb = null;
            this.zzt = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzr = (double) motionEvent.getRawX();
            this.zzs = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.zzr;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.zzs;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.zzk += Math.sqrt((d2 * d2) + (d4 * d4));
            this.zzr = rawX;
            this.zzs = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzb = obtain;
            this.zzc.add(obtain);
            if (this.zzc.size() > 6) {
                ((MotionEvent) this.zzc.remove()).recycle();
            }
            this.zzf++;
            this.zzh = zzg(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zze += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzdw zzk2 = zzk(motionEvent);
                Long l2 = zzk2.zzd;
                if (!(l2 == null || zzk2.zzg == null)) {
                    this.zzi += l2.longValue() + zzk2.zzg.longValue();
                }
                if (!(this.zzq == null || (l = zzk2.zze) == null || zzk2.zzh == null)) {
                    this.zzj += l.longValue() + zzk2.zzh.longValue();
                }
            } catch (zzdm unused) {
            }
        } else if (action2 == 3) {
            this.zzg++;
        }
        this.zzp = true;
    }

    public void zzf(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract long zzg(StackTraceElement[] stackTraceElementArr) throws zzdm;

    /* access modifiers changed from: protected */
    public abstract zzr zzh(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzr zzi(Context context, zzi zzi2);

    /* access modifiers changed from: protected */
    public abstract zzr zzj(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzdw zzk(MotionEvent motionEvent) throws zzdm;
}
