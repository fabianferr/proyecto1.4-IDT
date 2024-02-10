package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzic implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzid zza;

    /* synthetic */ zzic(zzid zzid, zzib zzib) {
        this.zza = zzid;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfy zzfy;
        try {
            this.zza.zzs.zzay().zzj().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfy = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        this.zza.zzs.zzaz().zzp(new zzia(this, z, data, str, queryParameter));
                        zzfy = this.zza.zzs;
                    }
                }
                zzfy = this.zza.zzs;
            }
        } catch (RuntimeException e) {
            this.zza.zzs.zzay().zzd().zzb("Throwable caught in onActivityCreated", e);
            zzfy = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzs().zzr(activity, bundle);
            throw th;
        }
        zzfy.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzs().zzt(activity);
        zzki zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaz().zzp(new zzkb(zzu, zzu.zzs.zzav().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzki zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaz().zzp(new zzka(zzu, zzu.zzs.zzav().elapsedRealtime()));
        this.zza.zzs.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
