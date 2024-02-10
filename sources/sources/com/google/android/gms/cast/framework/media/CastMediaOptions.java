package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class CastMediaOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new zza();
    private static final Logger zza = new Logger("CastMediaOptions");
    private final String zzb;
    private final String zzc;
    private final zzd zzd;
    private final NotificationOptions zze;
    private final boolean zzf;
    private final boolean zzg;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public static final class Builder {
        private String zza = "com.google.android.gms.cast.framework.media.MediaIntentReceiver";
        private String zzb;
        private ImagePicker zzc;
        private NotificationOptions zzd = new NotificationOptions.Builder().build();
        private boolean zze = true;

        /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.cast.framework.media.zzd] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.cast.framework.media.CastMediaOptions build() {
            /*
                r8 = this;
                com.google.android.gms.cast.framework.media.ImagePicker r0 = r8.zzc
                if (r0 != 0) goto L_0x0006
                r0 = 0
                goto L_0x000a
            L_0x0006:
                com.google.android.gms.cast.framework.media.zzd r0 = r0.zza()
            L_0x000a:
                r4 = r0
                com.google.android.gms.cast.framework.media.CastMediaOptions r0 = new com.google.android.gms.cast.framework.media.CastMediaOptions
                java.lang.String r2 = r8.zza
                java.lang.String r3 = r8.zzb
                com.google.android.gms.cast.framework.media.NotificationOptions r5 = r8.zzd
                r6 = 0
                boolean r7 = r8.zze
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.CastMediaOptions.Builder.build():com.google.android.gms.cast.framework.media.CastMediaOptions");
        }

        public Builder setExpandedControllerActivityClassName(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setImagePicker(ImagePicker imagePicker) {
            this.zzc = imagePicker;
            return this;
        }

        public Builder setMediaIntentReceiverClassName(String str) {
            this.zza = str;
            return this;
        }

        public Builder setMediaSessionEnabled(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setNotificationOptions(NotificationOptions notificationOptions) {
            this.zzd = notificationOptions;
            return this;
        }
    }

    CastMediaOptions(String str, String str2, IBinder iBinder, NotificationOptions notificationOptions, boolean z, boolean z2) {
        zzd zzd2;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            zzd2 = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            zzd2 = queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zzb(iBinder);
        }
        this.zzd = zzd2;
        this.zze = notificationOptions;
        this.zzf = z;
        this.zzg = z2;
    }

    public String getExpandedControllerActivityClassName() {
        return this.zzc;
    }

    public ImagePicker getImagePicker() {
        zzd zzd2 = this.zzd;
        if (zzd2 == null) {
            return null;
        }
        try {
            return (ImagePicker) ObjectWrapper.unwrap(zzd2.zzg());
        } catch (RemoteException e) {
            Class<zzd> cls = zzd.class;
            zza.d(e, "Unable to call %s on %s.", "getWrappedClientObject", "zzd");
            return null;
        }
    }

    public String getMediaIntentReceiverClassName() {
        return this.zzb;
    }

    public boolean getMediaSessionEnabled() {
        return this.zzg;
    }

    public NotificationOptions getNotificationOptions() {
        return this.zze;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getMediaIntentReceiverClassName(), false);
        SafeParcelWriter.writeString(parcel, 3, getExpandedControllerActivityClassName(), false);
        zzd zzd2 = this.zzd;
        if (zzd2 == null) {
            iBinder = null;
        } else {
            iBinder = zzd2.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getNotificationOptions(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 7, getMediaSessionEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zzf;
    }
}
