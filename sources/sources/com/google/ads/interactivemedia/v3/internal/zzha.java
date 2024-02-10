package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.ads.interactivemedia.v3.impl.data.zzbd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.URL;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzha {
    private final zzvr zza;
    private final float zzb;

    public zzha(ExecutorService executorService, float f) {
        this.zzb = f;
        this.zza = zzvw.zza(executorService);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bitmap zza(String str, zzbd zzbd) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        if (decodeStream == null) {
            return null;
        }
        if (zzbd.width != decodeStream.getWidth() || zzbd.height != decodeStream.getHeight()) {
            return decodeStream;
        }
        double d = (double) this.zzb;
        Double.isNaN(d);
        if (Math.copySign(1.0d - d, 1.0d) <= 0.1d || d == 1.0d) {
            return decodeStream;
        }
        if (Double.isNaN(1.0d) && Double.isNaN(d)) {
            return decodeStream;
        }
        return Bitmap.createScaledBitmap(decodeStream, (int) (this.zzb * ((float) decodeStream.getWidth())), (int) (this.zzb * ((float) decodeStream.getHeight())), true);
    }

    public final Task zzb(String str, zzbd zzbd) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzvd.zzd(this.zza.zza(new zzgy(this, str, zzbd)), new zzgz(this, taskCompletionSource, str), this.zza);
        return taskCompletionSource.getTask();
    }
}
