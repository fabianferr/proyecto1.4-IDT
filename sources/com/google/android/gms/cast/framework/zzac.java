package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public interface zzac extends IInterface {
    void zze(boolean z, int i) throws RemoteException;

    void zzf(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void zzg(int i) throws RemoteException;

    void zzh(Bundle bundle) throws RemoteException;

    void zzi(ConnectionResult connectionResult) throws RemoteException;

    void zzj(int i) throws RemoteException;
}
