package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.Toast;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class SessionManager {
    private static final Logger zza = new Logger("SessionManager");
    private final zzao zzb;
    private final Context zzc;

    public SessionManager(zzao zzao, Context context) {
        this.zzb = zzao;
        this.zzc = context;
    }

    public void addSessionManagerListener(SessionManagerListener<Session> sessionManagerListener) throws NullPointerException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        addSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void endCurrentSession(boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            zza.i("End session for %s", this.zzc.getPackageName());
            this.zzb.zzj(true, z);
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "endCurrentSession", "zzao");
        }
    }

    public CastSession getCurrentCastSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Session currentSession = getCurrentSession();
        if (currentSession == null || !(currentSession instanceof CastSession)) {
            return null;
        }
        return (CastSession) currentSession;
    }

    public Session getCurrentSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return (Session) ObjectWrapper.unwrap(this.zzb.zzf());
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "getWrappedCurrentSession", "zzao");
            return null;
        }
    }

    public void removeSessionManagerListener(SessionManagerListener<Session> sessionManagerListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        removeSessionManagerListener(sessionManagerListener, Session.class);
    }

    public void startSession(Intent intent) {
        try {
            zza.i("Start session for %s", this.zzc.getPackageName());
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            if (extras.getString("CAST_INTENT_TO_CAST_ROUTE_ID_KEY") != null) {
                String string = extras.getString("CAST_INTENT_TO_CAST_DEVICE_NAME_KEY");
                if (!extras.getBoolean("CAST_INTENT_TO_CAST_NO_TOAST_KEY")) {
                    Toast.makeText(this.zzc, this.zzc.getString(R.string.cast_connecting_to_device, new Object[]{string}), 0).show();
                }
                int i = CastButtonFactory.zza;
                extras.putBoolean("CAST_CUSTOM_MEDIA_ROUTE_DIALOG_FACTORY_SET_UP_KEY", false);
                this.zzb.zzm(new Bundle(extras));
                intent.removeExtra("CAST_INTENT_TO_CAST_ROUTE_ID_KEY");
            }
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "startSession", "zzao");
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "addCastStateListener", "zzao");
            return 1;
        }
    }

    public final IObjectWrapper zzb() {
        try {
            return this.zzb.zzg();
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "getWrappedThis", "zzao");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(CastStateListener castStateListener) throws NullPointerException {
        Preconditions.checkNotNull(castStateListener);
        try {
            this.zzb.zzh(new zzr(castStateListener));
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "addCastStateListener", "zzao");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(CastStateListener castStateListener) {
        try {
            this.zzb.zzk(new zzr(castStateListener));
        } catch (RemoteException e) {
            Class<zzao> cls = zzao.class;
            zza.d(e, "Unable to call %s on %s.", "removeCastStateListener", "zzao");
        }
    }

    public <T extends Session> void removeSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionManagerListener != null) {
            try {
                this.zzb.zzl(new zzaz(sessionManagerListener, cls));
            } catch (RemoteException e) {
                Class<zzao> cls2 = zzao.class;
                zza.d(e, "Unable to call %s on %s.", "removeSessionManagerListener", "zzao");
            }
        }
    }

    public <T extends Session> void addSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) throws NullPointerException {
        if (sessionManagerListener != null) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkMainThread("Must be called from the main thread.");
            try {
                this.zzb.zzi(new zzaz(sessionManagerListener, cls));
            } catch (RemoteException e) {
                Class<zzao> cls2 = zzao.class;
                zza.d(e, "Unable to call %s on %s.", "addSessionManagerListener", "zzao");
            }
        } else {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
    }
}
