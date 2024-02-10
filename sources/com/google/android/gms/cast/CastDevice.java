package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.cast.internal.zzz;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzs();
    final String zza;
    private final String zzb;
    private InetAddress zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List zzh;
    private final int zzi;
    private final int zzj;
    private final String zzk;
    private final String zzl;
    private final int zzm;
    private final String zzn;
    private final byte[] zzo;
    private final String zzp;
    private final boolean zzq;
    private final zzz zzr;

    CastDevice(String str, String str2, String str3, String str4, String str5, int i, List list, int i2, int i3, String str6, String str7, int i4, String str8, byte[] bArr, String str9, boolean z, zzz zzz) {
        this.zzb = zzd(str);
        String zzd2 = zzd(str2);
        this.zza = zzd2;
        if (!TextUtils.isEmpty(zzd2)) {
            try {
                this.zzc = InetAddress.getByName(zzd2);
            } catch (UnknownHostException e) {
                String str10 = this.zza;
                String message = e.getMessage();
                Log.i("CastDevice", "Unable to convert host address (" + str10 + ") to ipaddress: " + message);
            }
        }
        this.zzd = zzd(str3);
        this.zze = zzd(str4);
        this.zzf = zzd(str5);
        this.zzg = i;
        this.zzh = list == null ? new ArrayList() : list;
        this.zzi = i2;
        this.zzj = i3;
        this.zzk = zzd(str6);
        this.zzl = str7;
        this.zzm = i4;
        this.zzn = str8;
        this.zzo = bArr;
        this.zzp = str9;
        this.zzq = z;
        this.zzr = zzz;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzd(String str) {
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.zzb;
        return str == null ? castDevice.zzb == null : CastUtils.zze(str, castDevice.zzb) && CastUtils.zze(this.zzc, castDevice.zzc) && CastUtils.zze(this.zze, castDevice.zze) && CastUtils.zze(this.zzd, castDevice.zzd) && CastUtils.zze(this.zzf, castDevice.zzf) && this.zzg == castDevice.zzg && CastUtils.zze(this.zzh, castDevice.zzh) && this.zzi == castDevice.zzi && this.zzj == castDevice.zzj && CastUtils.zze(this.zzk, castDevice.zzk) && CastUtils.zze(Integer.valueOf(this.zzm), Integer.valueOf(castDevice.zzm)) && CastUtils.zze(this.zzn, castDevice.zzn) && CastUtils.zze(this.zzl, castDevice.zzl) && CastUtils.zze(this.zzf, castDevice.getDeviceVersion()) && this.zzg == castDevice.getServicePort() && (((bArr = this.zzo) == null && castDevice.zzo == null) || Arrays.equals(bArr, castDevice.zzo)) && CastUtils.zze(this.zzp, castDevice.zzp) && this.zzq == castDevice.zzq && CastUtils.zze(zzb(), castDevice.zzb());
    }

    public String getDeviceId() {
        return this.zzb.startsWith("__cast_nearby__") ? this.zzb.substring(16) : this.zzb;
    }

    public String getDeviceVersion() {
        return this.zzf;
    }

    public String getFriendlyName() {
        return this.zzd;
    }

    public WebImage getIcon(int i, int i2) {
        WebImage webImage = null;
        if (this.zzh.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return (WebImage) this.zzh.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzh) {
            int width = webImage3.getWidth();
            int height = webImage3.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2) {
                    if (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height)) {
                        webImage2 = webImage3;
                    }
                }
            } else if (webImage == null || (webImage.getWidth() > width && webImage.getHeight() > height)) {
                webImage = webImage3;
            }
        }
        if (webImage != null) {
            return webImage;
        }
        if (webImage2 != null) {
            return webImage2;
        }
        return (WebImage) this.zzh.get(0);
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzh);
    }

    public InetAddress getInetAddress() {
        return this.zzc;
    }

    @Deprecated
    public Inet4Address getIpAddress() {
        if (hasIPv4Address()) {
            return (Inet4Address) this.zzc;
        }
        return null;
    }

    public String getModelName() {
        return this.zze;
    }

    public int getServicePort() {
        return this.zzg;
    }

    public boolean hasCapabilities(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int hasCapability : iArr) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i) {
        return (this.zzi & i) == i;
    }

    public boolean hasIPv4Address() {
        return getInetAddress() instanceof Inet4Address;
    }

    public boolean hasIPv6Address() {
        return getInetAddress() instanceof Inet6Address;
    }

    public boolean hasIcons() {
        return !this.zzh.isEmpty();
    }

    public int hashCode() {
        String str = this.zzb;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzb.startsWith("__cast_nearby__") && !this.zzq;
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (!TextUtils.isEmpty(getDeviceId()) && !getDeviceId().startsWith("__cast_ble__") && !TextUtils.isEmpty(castDevice.getDeviceId()) && !castDevice.getDeviceId().startsWith("__cast_ble__")) {
            return CastUtils.zze(getDeviceId(), castDevice.getDeviceId());
        }
        if (TextUtils.isEmpty(this.zzn) || TextUtils.isEmpty(castDevice.zzn)) {
            return false;
        }
        return CastUtils.zze(this.zzn, castDevice.zzn);
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[2];
        String str = this.zzd;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if (length <= 2) {
                str = length == 2 ? "xx" : "x";
            } else {
                str = String.format(Locale.ROOT, "%c%d%c", new Object[]{Character.valueOf(str.charAt(0)), Integer.valueOf(length - 2), Character.valueOf(str.charAt(length - 1))});
            }
        }
        objArr[0] = str;
        objArr[1] = this.zzb;
        return String.format(locale, "\"%s\" (%s)", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zza, false);
        SafeParcelWriter.writeString(parcel, 4, getFriendlyName(), false);
        SafeParcelWriter.writeString(parcel, 5, getModelName(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeviceVersion(), false);
        SafeParcelWriter.writeInt(parcel, 7, getServicePort());
        SafeParcelWriter.writeTypedList(parcel, 8, getIcons(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeString(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeByteArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzq);
        SafeParcelWriter.writeParcelable(parcel, 18, zzb(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzi;
    }

    public final zzz zzb() {
        if (this.zzr == null) {
            boolean hasCapability = hasCapability(32);
            boolean hasCapability2 = hasCapability(64);
            if (hasCapability || hasCapability2) {
                return zzy.zza(1);
            }
        }
        return this.zzr;
    }

    public final String zzc() {
        return this.zzl;
    }
}
