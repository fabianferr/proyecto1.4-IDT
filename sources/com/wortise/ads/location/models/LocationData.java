package com.wortise.ads.location.models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.wortise.ads.s4;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u0017\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0012\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u00101\u001a\u00020-\u0012\b\u00102\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u00105\u001a\u00020\u0002¢\u0006\u0004\b3\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\f\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0016\u001a\u00020\u00128\u0006X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00178\u0006X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00128\u0006X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u00178\u0006X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010!\u001a\u00020\u00178\u0006X\u0004¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b \u0010\u001aR\u001a\u0010&\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020\u00128\u0006X\u0004¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001c\u0010,\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010+R\u001a\u00101\u001a\u00020-8\u0006X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b)\u00100R\u001c\u00102\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b.\u0010+¨\u00067"}, d2 = {"Lcom/wortise/ads/location/models/LocationData;", "Landroid/os/Parcelable;", "Landroid/location/Location;", "j", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "a", "F", "()F", "accuracy", "", "b", "D", "()D", "altitude", "c", "bearing", "d", "latitude", "e", "longitude", "f", "Ljava/lang/String;", "getProvider", "()Ljava/lang/String;", "provider", "g", "speed", "h", "Ljava/lang/Float;", "()Ljava/lang/Float;", "speedAccuracy", "", "i", "J", "()J", "time", "verticalAccuracy", "<init>", "(FDFDDLjava/lang/String;FLjava/lang/Float;JLjava/lang/Float;)V", "location", "(Landroid/location/Location;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: LocationData.kt */
public final class LocationData implements Parcelable {
    public static final Parcelable.Creator<LocationData> CREATOR = new a();
    @SerializedName("accuracy")
    private final float a;
    @SerializedName("altitude")
    private final double b;
    @SerializedName("bearing")
    private final float c;
    @SerializedName("latitude")
    private final double d;
    @SerializedName("longitude")
    private final double e;
    @SerializedName("provider")
    private final String f;
    @SerializedName("speed")
    private final float g;
    @SerializedName("speedAccuracy")
    private final Float h;
    @SerializedName("time")
    private final long i;
    @SerializedName("verticalAccuracy")
    private final Float j;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LocationData.kt */
    public static final class a implements Parcelable.Creator<LocationData> {
        /* renamed from: a */
        public final LocationData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationData(parcel.readFloat(), parcel.readDouble(), parcel.readFloat(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readFloat(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readLong(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()));
        }

        /* renamed from: a */
        public final LocationData[] newArray(int i) {
            return new LocationData[i];
        }
    }

    public LocationData(float f2, double d2, float f3, double d3, double d4, String str, float f4, Float f5, long j2, Float f6) {
        Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_PROVIDER);
        this.a = f2;
        this.b = d2;
        this.c = f3;
        this.d = d3;
        this.e = d4;
        this.f = str;
        this.g = f4;
        this.h = f5;
        this.i = j2;
        this.j = f6;
    }

    public final float a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public final double e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationData)) {
            return false;
        }
        LocationData locationData = (LocationData) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.a), (Object) Float.valueOf(locationData.a)) && Intrinsics.areEqual((Object) Double.valueOf(this.b), (Object) Double.valueOf(locationData.b)) && Intrinsics.areEqual((Object) Float.valueOf(this.c), (Object) Float.valueOf(locationData.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(locationData.d)) && Intrinsics.areEqual((Object) Double.valueOf(this.e), (Object) Double.valueOf(locationData.e)) && Intrinsics.areEqual((Object) this.f, (Object) locationData.f) && Intrinsics.areEqual((Object) Float.valueOf(this.g), (Object) Float.valueOf(locationData.g)) && Intrinsics.areEqual((Object) this.h, (Object) locationData.h) && this.i == locationData.i && Intrinsics.areEqual((Object) this.j, (Object) locationData.j);
    }

    public final float f() {
        return this.g;
    }

    public final Float g() {
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((Float.floatToIntBits(this.a) * 31) + Double.doubleToLongBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Double.doubleToLongBits(this.d)) * 31) + Double.doubleToLongBits(this.e)) * 31) + this.f.hashCode()) * 31) + Float.floatToIntBits(this.g)) * 31;
        Float f2 = this.h;
        int i2 = 0;
        int hashCode = (((floatToIntBits + (f2 == null ? 0 : f2.hashCode())) * 31) + UByte$$ExternalSyntheticBackport0.m(this.i)) * 31;
        Float f3 = this.j;
        if (f3 != null) {
            i2 = f3.hashCode();
        }
        return hashCode + i2;
    }

    public final Float i() {
        return this.j;
    }

    public final Location j() {
        Location location = new Location(this.f);
        location.setAccuracy(a());
        location.setAltitude(b());
        location.setBearing(c());
        location.setLatitude(d());
        location.setLongitude(e());
        location.setSpeed(f());
        location.setTime(h());
        s4.a(location, g());
        s4.b(location, i());
        return location;
    }

    public String toString() {
        return "LocationData(accuracy=" + this.a + ", altitude=" + this.b + ", bearing=" + this.c + ", latitude=" + this.d + ", longitude=" + this.e + ", provider=" + this.f + ", speed=" + this.g + ", speedAccuracy=" + this.h + ", time=" + this.i + ", verticalAccuracy=" + this.j + ')';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeFloat(this.a);
        parcel.writeDouble(this.b);
        parcel.writeFloat(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeString(this.f);
        parcel.writeFloat(this.g);
        Float f2 = this.h;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeLong(this.i);
        Float f3 = this.j;
        if (f3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeFloat(f3.floatValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationData(android.location.Location r17) {
        /*
            r16 = this;
            java.lang.String r0 = "location"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            float r2 = r17.getAccuracy()
            double r3 = r17.getAltitude()
            float r5 = r17.getBearing()
            double r6 = r17.getLatitude()
            double r8 = r17.getLongitude()
            java.lang.String r10 = r17.getProvider()
            java.lang.String r0 = "location.provider"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            float r11 = r17.getSpeed()
            java.lang.Float r12 = com.wortise.ads.s4.a(r17)
            long r13 = r17.getTime()
            java.lang.Float r15 = com.wortise.ads.s4.b(r17)
            r1 = r16
            r1.<init>(r2, r3, r5, r6, r8, r10, r11, r12, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.location.models.LocationData.<init>(android.location.Location):void");
    }
}
