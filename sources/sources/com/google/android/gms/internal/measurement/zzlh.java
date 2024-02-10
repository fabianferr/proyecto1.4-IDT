package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzlh {
    private static final zzlg zza;
    private static final zzlg zzb = new zzlg();

    static {
        zzlg zzlg;
        try {
            zzlg = (zzlg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlg = null;
        }
        zza = zzlg;
    }

    static zzlg zza() {
        return zza;
    }

    static zzlg zzb() {
        return zzb;
    }
}
