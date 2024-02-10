package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.device.DeviceType;
import com.wortise.ads.device.ScreenOrientation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/l2;", "", "", "toString", "", "hashCode", "other", "", "equals", "brand", "country", "device", "emulator", "language", "locale", "model", "Lcom/wortise/ads/device/ScreenOrientation;", "orientation", "os", "osRelease", "osVersion", "Lcom/wortise/ads/d6;", "screen", "timezone", "Lcom/wortise/ads/device/DeviceType;", "type", "userAgent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/device/ScreenOrientation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/wortise/ads/d6;Ljava/lang/String;Lcom/wortise/ads/device/DeviceType;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Device.kt */
public final class l2 {
    @SerializedName("brand")
    private final String a;
    @SerializedName("country")
    private final String b;
    @SerializedName("device")
    private final String c;
    @SerializedName("emulator")
    private final boolean d;
    @SerializedName("language")
    private final String e;
    @SerializedName("locale")
    private final String f;
    @SerializedName("model")
    private final String g;
    @SerializedName("orientation")
    private final ScreenOrientation h;
    @SerializedName("os")
    private final String i;
    @SerializedName("osRelease")
    private final String j;
    @SerializedName("osVersion")
    private final Integer k;
    @SerializedName("screen")
    private final d6 l;
    @SerializedName("timezone")
    private final String m;
    @SerializedName("type")
    private final DeviceType n;
    @SerializedName("userAgent")
    private final String o;

    public l2(String str, String str2, String str3, boolean z, String str4, String str5, String str6, ScreenOrientation screenOrientation, String str7, String str8, Integer num, d6 d6Var, String str9, DeviceType deviceType, String str10) {
        DeviceType deviceType2 = deviceType;
        Intrinsics.checkNotNullParameter(str7, "os");
        Intrinsics.checkNotNullParameter(deviceType2, "type");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = screenOrientation;
        this.i = str7;
        this.j = str8;
        this.k = num;
        this.l = d6Var;
        this.m = str9;
        this.n = deviceType2;
        this.o = str10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) l2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) l2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) l2Var.c) && this.d == l2Var.d && Intrinsics.areEqual((Object) this.e, (Object) l2Var.e) && Intrinsics.areEqual((Object) this.f, (Object) l2Var.f) && Intrinsics.areEqual((Object) this.g, (Object) l2Var.g) && this.h == l2Var.h && Intrinsics.areEqual((Object) this.i, (Object) l2Var.i) && Intrinsics.areEqual((Object) this.j, (Object) l2Var.j) && Intrinsics.areEqual((Object) this.k, (Object) l2Var.k) && Intrinsics.areEqual((Object) this.l, (Object) l2Var.l) && Intrinsics.areEqual((Object) this.m, (Object) l2Var.m) && this.n == l2Var.n && Intrinsics.areEqual((Object) this.o, (Object) l2Var.o);
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str4 = this.e;
        int hashCode4 = (i3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ScreenOrientation screenOrientation = this.h;
        int hashCode7 = (((hashCode6 + (screenOrientation == null ? 0 : screenOrientation.hashCode())) * 31) + this.i.hashCode()) * 31;
        String str7 = this.j;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.k;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        d6 d6Var = this.l;
        int hashCode10 = (hashCode9 + (d6Var == null ? 0 : d6Var.hashCode())) * 31;
        String str8 = this.m;
        int hashCode11 = (((hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.n.hashCode()) * 31;
        String str9 = this.o;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode11 + i2;
    }

    public String toString() {
        return "Device(brand=" + this.a + ", country=" + this.b + ", device=" + this.c + ", emulator=" + this.d + ", language=" + this.e + ", locale=" + this.f + ", model=" + this.g + ", orientation=" + this.h + ", os=" + this.i + ", osRelease=" + this.j + ", osVersion=" + this.k + ", screen=" + this.l + ", timezone=" + this.m + ", type=" + this.n + ", userAgent=" + this.o + ')';
    }
}
