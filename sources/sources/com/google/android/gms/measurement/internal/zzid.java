package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzid extends zzf {
    protected zzic zza;
    final zzs zzb;
    protected boolean zzc = true;
    private zzgy zzd;
    private final Set zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference zzg = new AtomicReference();
    private final Object zzh = new Object();
    private zzai zzi = new zzai((Boolean) null, (Boolean) null);
    private int zzj = 100;
    private final AtomicLong zzk = new AtomicLong(0);
    private long zzl = -1;
    private int zzm = 100;
    private final zzlg zzn = new zzhr(this);

    protected zzid(zzfy zzfy) {
        super(zzfy);
        this.zzb = new zzs(zzfy);
    }

    /* access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z) {
            zzfd zzm2 = this.zzs.zzm();
            zzfy zzfy = zzm2.zzs;
            zzm2.zzg();
            SharedPreferences.Editor edit = zzm2.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzs.zzK() || (bool != null && !bool.booleanValue())) {
            zzab();
        }
    }

    /* access modifiers changed from: private */
    public final void zzab() {
        zzg();
        String zza2 = this.zzs.zzm().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzY(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", (Object) null, this.zzs.zzav().currentTimeMillis());
            } else {
                zzY(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", Long.valueOf(true != ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zza2) ? 0 : 1), this.zzs.zzav().currentTimeMillis());
            }
        }
        if (!this.zzs.zzJ() || !this.zzc) {
            this.zzs.zzay().zzc().zza("Updating Scion state (FE)");
            this.zzs.zzt().zzI();
            return;
        }
        this.zzs.zzay().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzoe.zzc();
        if (this.zzs.zzf().zzs((String) null, zzeb.zzad)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzs.zzaz().zzp(new zzhg(this));
    }

    static /* bridge */ /* synthetic */ void zzv(zzid zzid, zzai zzai, zzai zzai2) {
        boolean z;
        zzah[] zzahArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzah zzah = zzahArr[i];
            if (!zzai2.zzi(zzah) && zzai.zzi(zzah)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zzl2 = zzai.zzl(zzai2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (z || zzl2) {
            zzid.zzs.zzh().zzo();
        }
    }

    static /* synthetic */ void zzw(zzid zzid, zzai zzai, int i, long j, boolean z, boolean z2) {
        zzid.zzg();
        zzid.zza();
        if (j > zzid.zzl || !zzai.zzj(zzid.zzm, i)) {
            zzfd zzm2 = zzid.zzs.zzm();
            zzfy zzfy = zzm2.zzs;
            zzm2.zzg();
            if (zzm2.zzl(i)) {
                SharedPreferences.Editor edit = zzm2.zza().edit();
                edit.putString("consent_settings", zzai.zzh());
                edit.putInt("consent_source", i);
                edit.apply();
                zzid.zzl = j;
                zzid.zzm = i;
                zzid.zzs.zzt().zzF(z);
                if (z2) {
                    zzid.zzs.zzt().zzu(new AtomicReference());
                    return;
                }
                return;
            }
            zzid.zzs.zzay().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzid.zzs.zzay().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzai);
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzs.zzav().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzaz().zzp(new zzhn(this, bundle2));
    }

    public final void zzB() {
        if ((this.zzs.zzau().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzs.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle zza2 = this.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzs.zzv().zzaf(obj)) {
                    this.zzs.zzv().zzN(this.zzn, (String) null, 27, (String) null, (String) null, 0);
                }
                this.zzs.zzay().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzlh.zzah(str)) {
                this.zzs.zzay().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else {
                zzlh zzv = this.zzs.zzv();
                this.zzs.zzf();
                if (zzv.zzaa("param", str, 100, obj)) {
                    this.zzs.zzv().zzO(zza2, str, obj);
                }
            }
        }
        this.zzs.zzv();
        int zzc2 = this.zzs.zzf().zzc();
        if (zza2.size() > zzc2) {
            int i = 0;
            for (String str2 : new TreeSet(zza2.keySet())) {
                i++;
                if (i > zzc2) {
                    zza2.remove(str2);
                }
            }
            this.zzs.zzv().zzN(this.zzn, (String) null, 26, (String) null, (String) null, 0);
            this.zzs.zzay().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzm().zzr.zzb(zza2);
        this.zzs.zzt().zzH(zza2);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str2;
        String str4 = str == null ? MBridgeConstans.DYNAMIC_VIEW_WX_APP : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str3 == FirebaseAnalytics.Event.SCREEN_VIEW || (str3 != null && str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            this.zzs.zzs().zzx(bundle2, j);
        } else {
            zzM(str4, str2, j, bundle2, z2, !z2 || this.zzd == null || zzlh.zzah(str2), z, (String) null);
        }
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzfy.zzO();
        zzM("auto", str2, this.zzs.zzav().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* access modifiers changed from: package-private */
    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzs.zzav().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzH(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzI(str, str2, j, bundle, true, this.zzd == null || zzlh.zzah(str2), true, (String) null);
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r20, java.lang.String r21, long r22, android.os.Bundle r24, boolean r25, boolean r26, boolean r27, java.lang.String r28) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            r19.zzg()
            r19.zza()
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            boolean r0 = r0.zzJ()
            if (r0 == 0) goto L_0x04de
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzh()
            java.util.List r0 = r0.zzn()
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.contains(r9)
            if (r0 == 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zzc(r1, r9, r8)
            return
        L_0x0041:
            boolean r0 = r7.zzf
            r13 = 0
            r14 = 0
            r15 = 1
            if (r0 != 0) goto L_0x00a1
            r7.zzf = r15
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r0 = r0.zzN()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r0 = r0.zzau()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r15, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.Class[] r1 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = "initialize"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.zzau()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzay()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzk()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zzb(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzi()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a1:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            r1.zzaw()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.common.util.Clock r0 = r0.zzav()
            long r5 = r0.currentTimeMillis()
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            r0.zzaw()
            if (r25 == 0) goto L_0x00ef
            boolean r0 = com.google.android.gms.measurement.internal.zzlh.zzal(r21)
            if (r0 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzr
            android.os.Bundle r1 = r1.zza()
            r0.zzL(r12, r1)
        L_0x00ef:
            r0 = 40
            if (r27 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            r1.zzaw()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            java.lang.String r2 = "event"
            boolean r3 = r1.zzac(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x0110
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgv.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzgv.zzb
            boolean r3 = r1.zzZ(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x011d
            r4 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.zzfy r3 = r1.zzs
            r3.zzf()
            boolean r1 = r1.zzY(r2, r0, r9)
            if (r1 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r4 = 0
        L_0x012a:
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()
            java.lang.String r2 = r2.zzd(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            r2.zzf()
            java.lang.String r0 = r1.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x015a
            int r14 = r21.length()
        L_0x015a:
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzlg r2 = r7.zzn
            r3 = 0
            java.lang.String r5 = "_ev"
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r0
            r26 = r14
            r20.zzN(r21, r22, r23, r24, r25, r26)
            return
        L_0x0177:
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            r1.zzaw()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzis r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zzj(r14)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0192
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0192
            r1.zzd = r15
        L_0x0192:
            if (r25 == 0) goto L_0x0198
            if (r27 != 0) goto L_0x0198
            r3 = 1
            goto L_0x0199
        L_0x0198:
            r3 = 0
        L_0x0199:
            com.google.android.gms.measurement.internal.zzlh.zzK(r1, r12, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzlh.zzah(r21)
            if (r25 == 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzgy r4 = r7.zzd
            if (r4 == 0) goto L_0x01e9
            if (r3 != 0) goto L_0x01e9
            if (r1 == 0) goto L_0x01b3
            r16 = 1
            goto L_0x01eb
        L_0x01b3:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()
            java.lang.String r1 = r1.zzd(r9)
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()
            java.lang.String r2 = r2.zzb(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zzc(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgy r0 = r7.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzgy r1 = r7.zzd
            r2 = r20
            r3 = r21
            r4 = r24
            r5 = r22
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01e9:
            r16 = r1
        L_0x01eb:
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x04dd
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            int r1 = r1.zzh(r9)
            if (r1 == 0) goto L_0x0249
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzem r2 = r2.zze()
            com.google.android.gms.measurement.internal.zzfy r3 = r7.zzs
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.zzb(r4, r3)
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzfy r3 = r7.zzs
            r3.zzf()
            java.lang.String r0 = r2.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x022d
            int r14 = r21.length()
        L_0x022d:
            com.google.android.gms.measurement.internal.zzfy r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzlg r3 = r7.zzn
            java.lang.String r4 = "_ev"
            r20 = r2
            r21 = r3
            r22 = r28
            r23 = r1
            r24 = r4
            r25 = r0
            r26 = r14
            r20.zzN(r21, r22, r23, r24, r25, r26)
            return
        L_0x0249:
            java.lang.String r0 = "_sn"
            java.lang.String r1 = "_si"
            java.lang.String r6 = "_o"
            java.lang.String[] r0 = new java.lang.String[]{r6, r0, r2, r1}
            java.util.List r5 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r0.zzv()
            r2 = r28
            r3 = r21
            r4 = r24
            r0 = r6
            r6 = r27
            android.os.Bundle r12 = r1.zzy(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            r1.zzaw()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzis r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zzj(r14)
            r5 = 0
            java.lang.String r4 = "_ae"
            if (r1 == 0) goto L_0x02af
            boolean r1 = r4.equals(r9)
            if (r1 == 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzki r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzkg r1 = r1.zzb
            com.google.android.gms.measurement.internal.zzki r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs
            com.google.android.gms.common.util.Clock r2 = r2.zzav()
            long r2 = r2.elapsedRealtime()
            long r14 = r1.zzb
            long r14 = r2 - r14
            r1.zzb = r2
            int r1 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            r1.zzI(r12, r14)
        L_0x02af:
            com.google.android.gms.internal.measurement.zznv.zzc()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzea r2 = com.google.android.gms.measurement.internal.zzeb.zzac
            boolean r1 = r1.zzs(r13, r2)
            if (r1 == 0) goto L_0x0339
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0318
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0318
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            java.lang.String r2 = r12.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02e4
            r2 = r13
            goto L_0x02ea
        L_0x02e4:
            if (r2 == 0) goto L_0x02ea
            java.lang.String r2 = r2.trim()
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzfy r3 = r1.zzs
            com.google.android.gms.measurement.internal.zzfd r3 = r3.zzm()
            com.google.android.gms.measurement.internal.zzfc r3 = r3.zzo
            java.lang.String r3 = r3.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzlf.zza(r2, r3)
            if (r3 != 0) goto L_0x0308
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfc r1 = r1.zzo
            r1.zzb(r2)
            goto L_0x0339
        L_0x0308:
            com.google.android.gms.measurement.internal.zzfy r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            return
        L_0x0318:
            boolean r1 = r4.equals(r9)
            if (r1 == 0) goto L_0x0339
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfc r1 = r1.zzo
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0339
            r12.putString(r2, r1)
        L_0x0339:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r12)
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzj
            long r1 = r1.zza()
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x03bb
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            boolean r1 = r1.zzk(r10)
            if (r1 == 0) goto L_0x03bb
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzl
            boolean r1 = r1.zzb()
            if (r1 == 0) goto L_0x03bb
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sid"
            r15 = 0
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.common.util.Clock r1 = r1.zzav()
            long r17 = r1.currentTimeMillis()
            r1 = r19
            r13 = r4
            r4 = r15
            r8 = r5
            r5 = r17
            r1.zzY(r2, r3, r4, r5)
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r4 = 0
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.common.util.Clock r1 = r1.zzav()
            long r5 = r1.currentTimeMillis()
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.common.util.Clock r1 = r1.zzav()
            long r5 = r1.currentTimeMillis()
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
            goto L_0x03bd
        L_0x03bb:
            r13 = r4
            r8 = r5
        L_0x03bd:
            java.lang.String r1 = "extend_session"
            long r1 = r12.getLong(r1, r8)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03e4
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzj()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzki r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzkh r1 = r1.zza
            r2 = 1
            r1.zzb(r10, r2)
        L_0x03e4:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r12.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x03f5:
            if (r3 >= r2) goto L_0x0443
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0440
            com.google.android.gms.measurement.internal.zzfy r5 = r7.zzs
            r5.zzv()
            java.lang.Object r5 = r12.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x0415
            r6 = 1
            android.os.Bundle[] r8 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r8[r6] = r5
            goto L_0x043b
        L_0x0415:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x0426
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r8 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r8)
            r8 = r5
            android.os.Bundle[] r8 = (android.os.Bundle[]) r8
            goto L_0x043b
        L_0x0426:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x043a
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            r8 = r5
            android.os.Bundle[] r8 = (android.os.Bundle[]) r8
            goto L_0x043b
        L_0x043a:
            r8 = 0
        L_0x043b:
            if (r8 == 0) goto L_0x0440
            r12.putParcelableArray(r4, r8)
        L_0x0440:
            int r3 = r3 + 1
            goto L_0x03f5
        L_0x0443:
            r8 = 0
        L_0x0444:
            int r1 = r14.size()
            if (r8 >= r1) goto L_0x04ad
            java.lang.Object r1 = r14.get(r8)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r8 == 0) goto L_0x0457
            java.lang.String r2 = "_ep"
            r9 = r20
            goto L_0x045b
        L_0x0457:
            r9 = r20
            r2 = r21
        L_0x045b:
            r1.putString(r0, r9)
            if (r26 == 0) goto L_0x046a
            com.google.android.gms.measurement.internal.zzfy r3 = r7.zzs
            com.google.android.gms.measurement.internal.zzlh r3 = r3.zzv()
            android.os.Bundle r1 = r3.zzt(r1)
        L_0x046a:
            r12 = r1
            com.google.android.gms.measurement.internal.zzaw r15 = new com.google.android.gms.measurement.internal.zzaw
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau
            r3.<init>(r12)
            r1 = r15
            r4 = r20
            r5 = r22
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzt()
            r5 = r28
            r1.zzA(r15, r5)
            if (r16 != 0) goto L_0x04aa
            java.util.Set r1 = r7.zze
            java.util.Iterator r15 = r1.iterator()
        L_0x048d:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x04aa
            java.lang.Object r1 = r15.next()
            com.google.android.gms.measurement.internal.zzgz r1 = (com.google.android.gms.measurement.internal.zzgz) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r12)
            r2 = r20
            r3 = r21
            r5 = r22
            r1.onEvent(r2, r3, r4, r5)
            r5 = r28
            goto L_0x048d
        L_0x04aa:
            int r8 = r8 + 1
            goto L_0x0444
        L_0x04ad:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            r0.zzaw()
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzis r0 = r0.zzs()
            r1 = 0
            com.google.android.gms.measurement.internal.zzik r0 = r0.zzj(r1)
            if (r0 == 0) goto L_0x04dd
            r1 = r21
            boolean r0 = r13.equals(r1)
            if (r0 == 0) goto L_0x04dd
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzki r0 = r0.zzu()
            com.google.android.gms.measurement.internal.zzfy r1 = r7.zzs
            com.google.android.gms.common.util.Clock r1 = r1.zzav()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzkg r0 = r0.zzb
            r3 = 1
            r0.zzd(r3, r3, r1)
        L_0x04dd:
            return
        L_0x04de:
            com.google.android.gms.measurement.internal.zzfy r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzid.zzI(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzJ(zzgz zzgz) {
        zza();
        Preconditions.checkNotNull(zzgz);
        if (!this.zze.add(zzgz)) {
            this.zzs.zzay().zzk().zza("OnEventListener already registered");
        }
    }

    public final void zzK(long j) {
        this.zzg.set((Object) null);
        this.zzs.zzaz().zzp(new zzhl(this, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzL(long j, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zza("Resetting analytics data (FE)");
        zzki zzu = this.zzs.zzu();
        zzu.zzg();
        zzkh zzkh = zzu.zza;
        zzu.zzb.zza();
        zzoz.zzc();
        if (this.zzs.zzf().zzs((String) null, zzeb.zzas)) {
            this.zzs.zzh().zzo();
        }
        boolean zzJ = this.zzs.zzJ();
        zzfd zzm2 = this.zzs.zzm();
        zzm2.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzm2.zzs.zzm().zzo.zza())) {
            zzm2.zzo.zzb((String) null);
        }
        zzoe.zzc();
        if (zzm2.zzs.zzf().zzs((String) null, zzeb.zzad)) {
            zzm2.zzj.zzb(0);
        }
        if (!zzm2.zzs.zzf().zzv()) {
            zzm2.zzi(!zzJ);
        }
        zzm2.zzp.zzb((String) null);
        zzm2.zzq.zzb(0);
        zzm2.zzr.zzb((Bundle) null);
        if (z) {
            this.zzs.zzt().zzC();
        }
        zzoe.zzc();
        if (this.zzs.zzf().zzs((String) null, zzeb.zzad)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    /* access modifiers changed from: protected */
    public final void zzM(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzs.zzaz().zzp(new zzhi(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    /* access modifiers changed from: package-private */
    public final void zzN(String str, String str2, long j, Object obj) {
        this.zzs.zzaz().zzp(new zzhj(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzay().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgu.zza(bundle2, "app_id", String.class, (Object) null);
        zzgu.zza(bundle2, "origin", String.class, (Object) null);
        zzgu.zza(bundle2, "name", String.class, (Object) null);
        zzgu.zza(bundle2, "value", Object.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, (Object) null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, (Object) null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzs.zzv().zzl(string) != 0) {
            this.zzs.zzay().zzd().zzb("Invalid conditional user property name", this.zzs.zzj().zzf(string));
        } else if (this.zzs.zzv().zzd(string, obj) == 0) {
            Object zzB = this.zzs.zzv().zzB(string, obj);
            if (zzB == null) {
                this.zzs.zzay().zzd().zzc("Unable to normalize conditional user property value", this.zzs.zzj().zzf(string), obj);
                return;
            }
            zzgu.zzb(bundle2, zzB);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                this.zzs.zzf();
                if (j2 > 15552000000L || j2 < 1) {
                    this.zzs.zzay().zzd().zzc("Invalid conditional user property timeout", this.zzs.zzj().zzf(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            this.zzs.zzf();
            if (j3 > 15552000000L || j3 < 1) {
                this.zzs.zzay().zzd().zzc("Invalid conditional user property time to live", this.zzs.zzj().zzf(string), Long.valueOf(j3));
            } else {
                this.zzs.zzaz().zzp(new zzhm(this, bundle2));
            }
        } else {
            this.zzs.zzay().zzd().zzc("Invalid conditional user property value", this.zzs.zzj().zzf(string), obj);
        }
    }

    public final void zzR(Bundle bundle, int i, long j) {
        zza();
        String zzg2 = zzai.zzg(bundle);
        if (zzg2 != null) {
            this.zzs.zzay().zzl().zzb("Ignoring invalid consent setting", zzg2);
            this.zzs.zzay().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i, j);
    }

    public final void zzS(zzai zzai, int i, long j) {
        zzai zzai2;
        boolean z;
        boolean z2;
        boolean z3;
        zzai zzai3 = zzai;
        int i2 = i;
        zza();
        if (i2 != -10 && zzai.zze() == null && zzai.zzf() == null) {
            this.zzs.zzay().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            zzai2 = this.zzi;
            z = false;
            if (zzai.zzj(i2, this.zzj)) {
                z3 = zzai3.zzk(this.zzi);
                if (zzai3.zzi(zzah.ANALYTICS_STORAGE) && !this.zzi.zzi(zzah.ANALYTICS_STORAGE)) {
                    z = true;
                }
                zzai3 = zzai3.zzd(this.zzi);
                this.zzi = zzai3;
                this.zzj = i2;
                z2 = z;
                z = true;
            } else {
                z3 = false;
                z2 = false;
            }
        }
        if (!z) {
            this.zzs.zzay().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzai3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z3) {
            this.zzg.set((Object) null);
            this.zzs.zzaz().zzq(new zzhx(this, zzai3, j, i, andIncrement, z2, zzai2));
            return;
        }
        zzhy zzhy = new zzhy(this, zzai3, i, andIncrement, z2, zzai2);
        if (i2 == 30 || i2 == -10) {
            this.zzs.zzaz().zzq(zzhy);
        } else {
            this.zzs.zzaz().zzp(zzhy);
        }
    }

    public final void zzT(zzgy zzgy) {
        zzgy zzgy2;
        zzg();
        zza();
        if (!(zzgy == null || zzgy == (zzgy2 = this.zzd))) {
            Preconditions.checkState(zzgy2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgy;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzs.zzaz().zzp(new zzhw(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void zzV(zzai zzai) {
        zzg();
        boolean z = (zzai.zzi(zzah.ANALYTICS_STORAGE) && zzai.zzi(zzah.AD_STORAGE)) || this.zzs.zzt().zzM();
        if (z != this.zzs.zzK()) {
            this.zzs.zzG(z);
            zzfd zzm2 = this.zzs.zzm();
            zzfy zzfy = zzm2.zzs;
            zzm2.zzg();
            Boolean valueOf = zzm2.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm2.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z) {
        zzX("auto", "_ldl", obj, true, this.zzs.zzav().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0065
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            r0 = 1
            if (r0 == r10) goto L_0x0037
            r4 = 0
            goto L_0x0038
        L_0x0037:
            r4 = r2
        L_0x0038:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzfy r0 = r8.zzs
            com.google.android.gms.measurement.internal.zzfd r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfc r0 = r0.zzh
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r11 = "true"
        L_0x004e:
            r0.zzb(r11)
            r6 = r10
            goto L_0x0063
        L_0x0053:
            if (r11 != 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzfy r10 = r8.zzs
            com.google.android.gms.measurement.internal.zzfd r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfc r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zzb(r0)
            r6 = r11
        L_0x0063:
            r3 = r1
            goto L_0x0067
        L_0x0065:
            r3 = r10
            r6 = r11
        L_0x0067:
            com.google.android.gms.measurement.internal.zzfy r10 = r8.zzs
            boolean r10 = r10.zzJ()
            if (r10 != 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfy r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzeo r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzj()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzfy r10 = r8.zzs
            boolean r10 = r10.zzM()
            if (r10 != 0) goto L_0x0088
            return
        L_0x0088:
            com.google.android.gms.measurement.internal.zzlc r10 = new com.google.android.gms.measurement.internal.zzlc
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzfy r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzjs r9 = r9.zzt()
            r9.zzK(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzid.zzY(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzZ(zzgz zzgz) {
        zza();
        Preconditions.checkNotNull(zzgz);
        if (!this.zze.remove(zzgz)) {
            this.zzs.zzay().zzk().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzaz().zzd(atomicReference, 15000, "boolean test flag value", new zzhp(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzaz().zzd(atomicReference, 15000, "double test flag value", new zzhv(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzaz().zzd(atomicReference, 15000, "int test flag value", new zzhu(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzaz().zzd(atomicReference, 15000, "long test flag value", new zzht(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zzik zzi2 = this.zzs.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zzb;
        }
        return null;
    }

    public final String zzq() {
        zzik zzi2 = this.zzs.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzaz().zzd(atomicReference, 15000, "String test flag value", new zzhs(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000, "get conditional user properties", new zzho(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzlh.zzH(list);
        }
        this.zzs.zzay().zzd().zzb("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final List zzt(boolean z) {
        zza();
        this.zzs.zzay().zzj().zza("Getting user properties (FE)");
        if (!this.zzs.zzaz().zzs()) {
            this.zzs.zzaw();
            if (zzab.zza()) {
                this.zzs.zzay().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzaz().zzd(atomicReference, 5000, "get user properties", new zzhk(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            this.zzs.zzay().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        this.zzs.zzay().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000, "get user properties", new zzhq(this, atomicReference, (String) null, str, str2, z));
        List<zzlc> list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzay().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzlc zzlc : list) {
            Object zza2 = zzlc.zza();
            if (zza2 != null) {
                arrayMap.put(zzlc.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzf().zzs((String) null, zzeb.zzX)) {
                zzag zzf2 = this.zzs.zzf();
                zzf2.zzs.zzaw();
                Boolean zzk2 = zzf2.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk2 != null && zzk2.booleanValue()) {
                    this.zzs.zzay().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaz().zzp(new zzhf(this));
                }
            }
            this.zzs.zzt().zzq();
            this.zzc = false;
            zzfd zzm2 = this.zzs.zzm();
            zzm2.zzg();
            String string = zzm2.zza().getString("previous_os_version", (String) null);
            zzm2.zzs.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm2.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzs.zzg().zzu();
                if (!string.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzG("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        String str3 = str2;
        Object obj2 = obj;
        String str4 = str == null ? MBridgeConstans.DYNAMIC_VIEW_WX_APP : str;
        if (z) {
            i = this.zzs.zzv().zzl(str3);
        } else {
            zzlh zzv = this.zzs.zzv();
            if (zzv.zzac("user property", str3)) {
                if (!zzv.zzZ("user property", zzgx.zza, (String[]) null, str3)) {
                    i = 15;
                } else {
                    zzv.zzs.zzf();
                    if (zzv.zzY("user property", 24, str3)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzlh zzv2 = this.zzs.zzv();
            this.zzs.zzf();
            this.zzs.zzv().zzN(this.zzn, (String) null, i, "_ev", zzv2.zzD(str3, 24, true), str3 != null ? str2.length() : 0);
        } else if (obj2 != null) {
            int zzd2 = this.zzs.zzv().zzd(str3, obj2);
            if (zzd2 != 0) {
                zzlh zzv3 = this.zzs.zzv();
                this.zzs.zzf();
                String zzD = zzv3.zzD(str3, 24, true);
                if ((obj2 instanceof String) || (obj2 instanceof CharSequence)) {
                    i2 = obj.toString().length();
                } else {
                    i2 = 0;
                }
                this.zzs.zzv().zzN(this.zzn, (String) null, zzd2, "_ev", zzD, i2);
                return;
            }
            Object zzB = this.zzs.zzv().zzB(str3, obj2);
            if (zzB != null) {
                zzN(str4, str2, j, zzB);
            }
        } else {
            zzN(str4, str2, j, (Object) null);
        }
    }
}
