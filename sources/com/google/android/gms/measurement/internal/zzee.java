package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public interface zzee extends IInterface {
    String zzd(zzq zzq) throws RemoteException;

    List zze(zzq zzq, boolean z) throws RemoteException;

    List zzf(String str, String str2, zzq zzq) throws RemoteException;

    List zzg(String str, String str2, String str3) throws RemoteException;

    List zzh(String str, String str2, boolean z, zzq zzq) throws RemoteException;

    List zzi(String str, String str2, String str3, boolean z) throws RemoteException;

    void zzj(zzq zzq) throws RemoteException;

    void zzk(zzaw zzaw, zzq zzq) throws RemoteException;

    void zzl(zzaw zzaw, String str, String str2) throws RemoteException;

    void zzm(zzq zzq) throws RemoteException;

    void zzn(zzac zzac, zzq zzq) throws RemoteException;

    void zzo(zzac zzac) throws RemoteException;

    void zzp(zzq zzq) throws RemoteException;

    void zzq(long j, String str, String str2, String str3) throws RemoteException;

    void zzr(Bundle bundle, zzq zzq) throws RemoteException;

    void zzs(zzq zzq) throws RemoteException;

    void zzt(zzlc zzlc, zzq zzq) throws RemoteException;

    byte[] zzu(zzaw zzaw, String str) throws RemoteException;
}
