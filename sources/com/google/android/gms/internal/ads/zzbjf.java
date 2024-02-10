package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.mbridge.msdk.MBridgeConstans;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbjf {
    private final String zza = ((String) zzbkm.zzb.zze());
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbjf(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put(CmcdHeadersFactory.STREAMING_FORMAT_SS, "gmob_sdk");
        linkedHashMap.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        linkedHashMap.put("device", zzs.zzq());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, str2);
        zzt.zzp();
        String str3 = "0";
        linkedHashMap.put("is_lite_sdk", true != zzs.zzA(context) ? str3 : "1");
        Future zzb2 = zzt.zzm().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzcbh) zzb2.get()).zzk));
            linkedHashMap.put("network_fine", Integer.toString(((zzcbh) zzb2.get()).zzl));
        } catch (Exception e) {
            zzt.zzo().zzt(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziQ)).booleanValue()) {
            this.zzb.put("is_bstar", true == DeviceProperties.isBstar(context) ? "1" : str3);
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzd() {
        return this.zzb;
    }
}
