package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzaf;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class Session {
    private static final Logger zza = new Logger("Session");
    private final zzam zzb;
    private final zzay zzc;

    protected Session(Context context, String str, String str2) {
        zzay zzay = new zzay(this, (zzax) null);
        this.zzc = zzay;
        this.zzb = zzaf.zzd(context, str, str2, zzay);
    }

    /* access modifiers changed from: protected */
    public abstract void end(boolean z);

    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzh();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "getCategory", "zzam");
            }
        }
        return null;
    }

    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzi();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "getSessionId", "zzam");
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzp();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isConnected", "zzam");
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzq();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isConnecting", "zzam");
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzr();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isDisconnected", "zzam");
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzs();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isDisconnecting", "zzam");
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzt();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isResuming", "zzam");
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzu();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "isSuspended", "zzam");
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToResumeSession(int i) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzj(i);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToStartSession(int i) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzk(i);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifyFailedToStartSession", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionEnded(int i) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzl(i);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifySessionEnded", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionResumed(boolean z) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzm(z);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifySessionResumed", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionStarted(String str) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzn(str);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifySessionStarted", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionSuspended(int i) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzo(i);
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "notifySessionSuspended", "zzam");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResuming(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onStarting(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public abstract void resume(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void start(Bundle bundle);

    /* access modifiers changed from: protected */
    public void zzi(Bundle bundle) {
    }

    public final int zzk() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                if (zzam.zze() >= 211100000) {
                    return this.zzb.zzf();
                }
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "getSessionStartType", "zzam");
            }
        }
        return 0;
    }

    public final IObjectWrapper zzl() {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzg();
            } catch (RemoteException e) {
                Class<zzam> cls = zzam.class;
                zza.d(e, "Unable to call %s on %s.", "getWrappedObject", "zzam");
            }
        }
        return null;
    }
}
