package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbja implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    /* access modifiers changed from: private */
    public SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze != null) {
            try {
                this.zzh = new JSONObject((String) zzbje.zza(new zzbiy(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final Object zzb(zzbiu zzbiu) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                Object zzm = zzbiu.zzm();
                return zzm;
            }
        }
        if (zzbiu.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbiu.zzm();
            }
            return zzbiu.zzb(bundle);
        } else if (zzbiu.zze() != 1 || !this.zzh.has(zzbiu.zzn())) {
            return zzbje.zza(new zzbix(this, zzbiu));
        } else {
            return zzbiu.zza(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzbiu zzbiu) {
        return zzbiu.zzc(this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd() {
        return this.zze.getString("flag_configuration", JsonUtils.EMPTY_JSON);
    }

    public final void zze(Context context) {
        if (!this.zzd) {
            synchronized (this.zzb) {
                if (!this.zzd) {
                    if (!this.zza) {
                        this.zza = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzg = applicationContext;
                    try {
                        this.zzf = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (!(remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null)) {
                            context = remoteContext;
                        }
                        if (context != null) {
                            zzay.zzb();
                            SharedPreferences zza2 = zzbiw.zza(context);
                            this.zze = zza2;
                            if (zza2 != null) {
                                zza2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzblj.zzc(new zzbiz(this));
                            zzf();
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                        }
                    } finally {
                        this.zza = false;
                        this.zzc.open();
                    }
                }
            }
        }
    }
}
