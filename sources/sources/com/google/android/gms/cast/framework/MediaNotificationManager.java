package com.google.android.gms.cast.framework;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class MediaNotificationManager {
    private final SessionManager zza;

    public MediaNotificationManager(SessionManager sessionManager) {
        this.zza = sessionManager;
    }

    public void updateNotification() {
        CastSession currentCastSession = this.zza.getCurrentCastSession();
        if (currentCastSession != null) {
            currentCastSession.zzd().zzl(true);
        }
    }
}
