package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzaf;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzf extends AsyncTask {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzi zzb;
    private final zzb zzc;

    public zzf(Context context, int i, int i2, boolean z, long j, int i3, int i4, int i5, zzb zzb2) {
        this.zzc = zzb2;
        this.zzb = zzaf.zze(context.getApplicationContext(), this, new zze(this, (zzd) null), i, i2, false, 2097152, 5, 333, 10000);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        zzi zzi;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (zzi = this.zzb) == null) {
            return null;
        }
        try {
            return zzi.zze(uri);
        } catch (RemoteException e) {
            Class<zzi> cls = zzi.class;
            zza.d(e, "Unable to call %s on %s.", "doFetch", "zzi");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        zzb zzb2 = this.zzc;
        if (zzb2 != null) {
            zzb2.zzb(bitmap);
        }
    }
}
