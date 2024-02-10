package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.umlaut.crowd.CCS;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzs {
    private final zzfy zza;

    public zzs(zzfy zzfy) {
        this.zza = zzfy;
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzaz().zzg();
        if (!this.zza.zzJ()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzm().zzp.zzb(str2);
                this.zza.zzm().zzq.zzb(this.zza.zzav().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        String str;
        this.zza.zzaz().zzg();
        if (zzd()) {
            if (zze()) {
                this.zza.zzm().zzp.zzb((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.zza.zzq().zzG("auto", "_cmpx", bundle);
            } else {
                String zza2 = this.zza.zzm().zzp.zza();
                if (TextUtils.isEmpty(zza2)) {
                    this.zza.zzay().zzh().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((this.zza.zzm().zzq.zza() / CCS.a) - 1) * CCS.a;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    if (pair.first == null) {
                        str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
                    } else {
                        str = (String) pair.first;
                    }
                    this.zza.zzq().zzG(str, "_cmp", (Bundle) pair.second);
                }
                this.zza.zzm().zzp.zzb((String) null);
            }
            this.zza.zzm().zzq.zzb(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (zzd() && zze()) {
            this.zza.zzm().zzp.zzb((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zza.zzm().zzq.zza() > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        if (zzd() && this.zza.zzav().currentTimeMillis() - this.zza.zzm().zzq.zza() > this.zza.zzf().zzi((String) null, zzeb.zzQ)) {
            return true;
        }
        return false;
    }
}
