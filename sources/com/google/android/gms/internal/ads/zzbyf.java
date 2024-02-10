package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzbyf {
    private final zzcmp zza;
    private final String zzb;

    public zzbyf(zzcmp zzcmp, String str) {
        this.zza = zzcmp;
        this.zzb = str;
    }

    public final void zzf(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zze.zzh("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzg(String str) {
        try {
            JSONObject put = new JSONObject().put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzb);
            zzcmp zzcmp = this.zza;
            if (zzcmp != null) {
                zzcmp.zze("onError", put);
            }
        } catch (JSONException e) {
            zze.zzh("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zze.zzh("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzi(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put(Key.ROTATION, i5));
        } catch (JSONException e) {
            zze.zzh("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzj(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zze.zzh("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zze.zzh("Error occurred while dispatching state change.", e);
        }
    }
}
