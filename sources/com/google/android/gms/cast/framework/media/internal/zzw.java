package com.google.android.gms.cast.framework.media.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.Logger;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzw {
    private static final Logger zza = new Logger("MediaSessionUtils");

    public static int zza(NotificationOptions notificationOptions, long j) {
        int i = (j > 10000 ? 1 : (j == 10000 ? 0 : -1));
        int forwardDrawableResId = notificationOptions.getForwardDrawableResId();
        if (i == 0) {
            return notificationOptions.getForward10DrawableResId();
        }
        if (j != 30000) {
            return forwardDrawableResId;
        }
        return notificationOptions.getForward30DrawableResId();
    }

    public static int zzb(NotificationOptions notificationOptions, long j) {
        int i = (j > 10000 ? 1 : (j == 10000 ? 0 : -1));
        int zzd = notificationOptions.zzd();
        if (i == 0) {
            return notificationOptions.zzb();
        }
        if (j != 30000) {
            return zzd;
        }
        return notificationOptions.zzc();
    }

    public static int zzc(NotificationOptions notificationOptions, long j) {
        int i = (j > 10000 ? 1 : (j == 10000 ? 0 : -1));
        int rewindDrawableResId = notificationOptions.getRewindDrawableResId();
        if (i == 0) {
            return notificationOptions.getRewind10DrawableResId();
        }
        if (j != 30000) {
            return rewindDrawableResId;
        }
        return notificationOptions.getRewind30DrawableResId();
    }

    public static int zzd(NotificationOptions notificationOptions, long j) {
        int i = (j > 10000 ? 1 : (j == 10000 ? 0 : -1));
        int zzj = notificationOptions.zzj();
        if (i == 0) {
            return notificationOptions.zzh();
        }
        if (j != 30000) {
            return zzj;
        }
        return notificationOptions.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r4.containsKey(r1) != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r1 != 4) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zze(com.google.android.gms.cast.MediaMetadata r4) {
        /*
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SUBTITLE"
            boolean r1 = r4.containsKey(r0)
            if (r1 != 0) goto L_0x003c
            int r1 = r4.getMediaType()
            r2 = 1
            if (r1 == r2) goto L_0x003a
            r2 = 2
            if (r1 == r2) goto L_0x0037
            r2 = 3
            java.lang.String r3 = "com.google.android.gms.cast.metadata.ARTIST"
            if (r1 == r2) goto L_0x001d
            r2 = 4
            if (r1 == r2) goto L_0x001b
            goto L_0x003c
        L_0x001b:
            r0 = r3
            goto L_0x003c
        L_0x001d:
            boolean r1 = r4.containsKey(r3)
            if (r1 == 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.ALBUM_ARTIST"
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x002e
        L_0x002c:
            r0 = r1
            goto L_0x003c
        L_0x002e:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.COMPOSER"
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x003c
            goto L_0x002c
        L_0x0037:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SERIES_TITLE"
            goto L_0x003c
        L_0x003a:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.STUDIO"
        L_0x003c:
            java.lang.String r4 = r4.getString(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzw.zze(com.google.android.gms.cast.MediaMetadata):java.lang.String");
    }

    public static List zzf(zzg zzg) {
        try {
            return zzg.zzf();
        } catch (RemoteException e) {
            Class<zzg> cls = zzg.class;
            zza.e(e, "Unable to call %s on %s.", "getNotificationActions", "zzg");
            return null;
        }
    }

    public static int[] zzg(zzg zzg) {
        try {
            return zzg.zzg();
        } catch (RemoteException e) {
            Class<zzg> cls = zzg.class;
            zza.e(e, "Unable to call %s on %s.", "getCompactViewActionIndices", "zzg");
            return null;
        }
    }
}
