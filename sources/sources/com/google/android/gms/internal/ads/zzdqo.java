package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzcu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdqo implements zzdoy {
    private final zzbvz zza;
    private final zzdds zzb;
    private final zzdcy zzc;
    private final zzdkl zzd;
    private final Context zze;
    private final zzfdk zzf;
    private final zzcgv zzg;
    private final zzfef zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbvv zzl;
    private final zzbvw zzm;

    public zzdqo(zzbvv zzbvv, zzbvw zzbvw, zzbvz zzbvz, zzdds zzdds, zzdcy zzdcy, zzdkl zzdkl, Context context, zzfdk zzfdk, zzcgv zzcgv, zzfef zzfef, byte[] bArr) {
        this.zzl = zzbvv;
        this.zzm = zzbvw;
        this.zza = zzbvz;
        this.zzb = zzdds;
        this.zzc = zzdcy;
        this.zzd = zzdkl;
        this.zze = context;
        this.zzf = zzfdk;
        this.zzg = zzcgv;
        this.zzh = zzfef;
    }

    private final void zza(View view) {
        try {
            zzbvz zzbvz = this.zza;
            if (zzbvz == null || zzbvz.zzA()) {
                zzbvv zzbvv = this.zzl;
                if (zzbvv == null || zzbvv.zzx()) {
                    zzbvw zzbvw = this.zzm;
                    if (zzbvw != null && !zzbvw.zzv()) {
                        this.zzm.zzq(ObjectWrapper.wrap(view));
                        this.zzc.onAdClicked();
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zziw)).booleanValue()) {
                            this.zzd.zzq();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) zzay.zzc().zzb(zzbjc.zziw)).booleanValue()) {
                    this.zzd.zzq();
                    return;
                }
                return;
            }
            this.zza.zzw(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziw)).booleanValue()) {
                this.zzd.zzq();
            }
        } catch (RemoteException e) {
            zze.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzb(Map map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final boolean zzA(Bundle bundle) {
        return false;
    }

    public final JSONObject zzd(View view, Map map, Map map2) {
        return null;
    }

    public final JSONObject zze(View view, Map map, Map map2) {
        return null;
    }

    public final void zzf() {
        throw null;
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(zzcu zzcu) {
        zze.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzj(View view, View view2, Map map, Map map2, boolean z) {
        if (!this.zzj || !this.zzf.zzM) {
            zza(view);
        }
    }

    public final void zzk(String str) {
    }

    public final void zzl(Bundle bundle) {
    }

    public final void zzn(View view, Map map, Map map2, boolean z) {
        if (!this.zzj) {
            zze.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzf.zzM) {
            zze.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zza(view);
        }
    }

    public final void zzo() {
    }

    public final void zzp(View view, Map map, Map map2) {
        try {
            if (!this.zzi) {
                this.zzi = zzt.zzs().zzn(this.zze, this.zzg.zza, this.zzf.zzD.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbvz zzbvz = this.zza;
                if (zzbvz != null) {
                    if (!zzbvz.zzB()) {
                        this.zza.zzx();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbvv zzbvv = this.zzl;
                if (zzbvv != null) {
                    if (!zzbvv.zzy()) {
                        this.zzl.zzt();
                        this.zzb.zza();
                        return;
                    }
                }
                zzbvw zzbvw = this.zzm;
                if (zzbvw != null && !zzbvw.zzw()) {
                    this.zzm.zzr();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            zze.zzk("Failed to call recordImpression", e);
        }
    }

    public final void zzq() {
    }

    public final void zzr(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zzs(Bundle bundle) {
    }

    public final void zzt(View view) {
    }

    public final void zzu() {
        this.zzj = true;
    }

    public final void zzv(zzcq zzcq) {
        zze.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzw(zzbny zzbny) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(android.view.View r9, java.util.Map r10, java.util.Map r11, android.view.View.OnTouchListener r12, android.view.View.OnClickListener r13) {
        /*
            r8 = this;
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfdk r12 = r8.zzf     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONObject r12 = r12.zzal     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbiu r13 = com.google.android.gms.internal.ads.zzbjc.zzbq     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r13 = r0.zzb(r13)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ RemoteException -> 0x0124 }
            boolean r13 = r13.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            r0 = 1
            if (r13 == 0) goto L_0x00e0
            int r13 = r12.length()     // Catch:{ RemoteException -> 0x0124 }
            if (r13 != 0) goto L_0x0023
            goto L_0x00e0
        L_0x0023:
            if (r10 != 0) goto L_0x002b
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r13.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x002c
        L_0x002b:
            r13 = r10
        L_0x002c:
            if (r11 != 0) goto L_0x0034
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0124 }
            goto L_0x0035
        L_0x0034:
            r1 = r11
        L_0x0035:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ RemoteException -> 0x0124 }
            r2.<init>()     // Catch:{ RemoteException -> 0x0124 }
            r2.putAll(r13)     // Catch:{ RemoteException -> 0x0124 }
            r2.putAll(r1)     // Catch:{ RemoteException -> 0x0124 }
            java.util.Iterator r13 = r12.keys()     // Catch:{ RemoteException -> 0x0124 }
        L_0x0044:
            boolean r1 = r13.hasNext()     // Catch:{ RemoteException -> 0x0124 }
            if (r1 == 0) goto L_0x00e0
            java.lang.Object r1 = r13.next()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ RemoteException -> 0x0124 }
            org.json.JSONArray r3 = r12.optJSONArray(r1)     // Catch:{ RemoteException -> 0x0124 }
            if (r3 == 0) goto L_0x0044
            java.lang.Object r4 = r2.get(r1)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4     // Catch:{ RemoteException -> 0x0124 }
            r5 = 0
            if (r4 != 0) goto L_0x0062
        L_0x005f:
            r0 = 0
            goto L_0x00e0
        L_0x0062:
            java.lang.Object r4 = r4.get()     // Catch:{ RemoteException -> 0x0124 }
            if (r4 != 0) goto L_0x0069
            goto L_0x005f
        L_0x0069:
            java.lang.Class r4 = r4.getClass()     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbiu r6 = com.google.android.gms.internal.ads.zzbjc.zzbr     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbja r7 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ RemoteException -> 0x0124 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ RemoteException -> 0x0124 }
            boolean r6 = r6.booleanValue()     // Catch:{ RemoteException -> 0x0124 }
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "3010"
            boolean r1 = r1.equals(r6)     // Catch:{ RemoteException -> 0x0124 }
            if (r1 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzbvz r1 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            r4 = 0
            if (r1 == 0) goto L_0x0093
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzn()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x0091:
            goto L_0x00ac
        L_0x0093:
            com.google.android.gms.internal.ads.zzbvv r1 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r1 == 0) goto L_0x009c
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzk()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x009c:
            com.google.android.gms.internal.ads.zzbvw r1 = r8.zzm     // Catch:{ RemoteException -> 0x0124 }
            if (r1 == 0) goto L_0x00a5
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzj()     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x00a6
        L_0x00a5:
            r1 = r4
        L_0x00a6:
            if (r1 == 0) goto L_0x00ac
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)     // Catch:{  }
        L_0x00ac:
            if (r4 != 0) goto L_0x00af
            goto L_0x005f
        L_0x00af:
            java.lang.Class r4 = r4.getClass()     // Catch:{ RemoteException -> 0x0124 }
        L_0x00b3:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0044 }
            r1.<init>()     // Catch:{ JSONException -> 0x0044 }
            com.google.android.gms.ads.internal.util.zzbu.zzc(r3, r1)     // Catch:{ JSONException -> 0x0044 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ JSONException -> 0x0044 }
            android.content.Context r3 = r8.zze     // Catch:{ JSONException -> 0x0044 }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ JSONException -> 0x0044 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x0044 }
        L_0x00c8:
            boolean r6 = r1.hasNext()     // Catch:{ JSONException -> 0x0044 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r1.next()     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0044 }
            java.lang.Class r6 = java.lang.Class.forName(r6, r5, r3)     // Catch:{ all -> 0x00c8 }
            boolean r6 = r6.isAssignableFrom(r4)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x00c8
            goto L_0x0044
        L_0x00e0:
            r8.zzk = r0     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r10 = zzb(r10)     // Catch:{ RemoteException -> 0x0124 }
            java.util.HashMap r11 = zzb(r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvz r12 = r8.zza     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x00fa
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzy(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x00fa:
            com.google.android.gms.internal.ads.zzbvv r12 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x010f
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzv(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvv r10 = r8.zzl     // Catch:{ RemoteException -> 0x0124 }
            r10.zzu(r9)     // Catch:{ RemoteException -> 0x0124 }
            return
        L_0x010f:
            com.google.android.gms.internal.ads.zzbvw r12 = r8.zzm     // Catch:{ RemoteException -> 0x0124 }
            if (r12 == 0) goto L_0x0123
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x0124 }
            r12.zzt(r9, r10, r11)     // Catch:{ RemoteException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbvw r10 = r8.zzm     // Catch:{ RemoteException -> 0x0124 }
            r10.zzs(r9)     // Catch:{ RemoteException -> 0x0124 }
        L_0x0123:
            return
        L_0x0124:
            r9 = move-exception
            java.lang.String r10 = "Failed to call trackView"
            com.google.android.gms.ads.internal.util.zze.zzk(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqo.zzx(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    public final void zzy(View view, Map map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbvz zzbvz = this.zza;
            if (zzbvz != null) {
                zzbvz.zzz(wrap);
                return;
            }
            zzbvv zzbvv = this.zzl;
            if (zzbvv != null) {
                zzbvv.zzw(wrap);
                return;
            }
            zzbvw zzbvw = this.zzm;
            if (zzbvw != null) {
                zzbvw.zzu(wrap);
            }
        } catch (RemoteException e) {
            zze.zzk("Failed to call untrackView", e);
        }
    }

    public final boolean zzz() {
        return this.zzf.zzM;
    }
}
