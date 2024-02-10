package com.wortise.ads.api.submodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u0002KLB§\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010.\u001a\u00020)\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00105\u001a\u00020\u0019\u0012\u0006\u00107\u001a\u00020\u0019\u0012\b\u00109\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010@\u001a\u00020<\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bI\u0010JJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0014\u001a\u00020\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010%R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b'\u0010\u0017R\u001a\u0010.\u001a\u00020)8\u0006X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0016\u001a\u0004\b*\u0010\u0017\"\u0004\b0\u0010%R\u001a\u00105\u001a\u00020\u00198\u0006X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b/\u00104R\u001a\u00107\u001a\u00020\u00198\u0006X\u0004¢\u0006\f\n\u0004\b6\u00103\u001a\u0004\b2\u00104R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b8\u0010\u0016\u001a\u0004\b6\u0010\u0017R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b:\u0010\u0016\u001a\u0004\b8\u0010\u0017R\u001a\u0010@\u001a\u00020<8\u0006X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b:\u0010?R\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\bA\u0010\u0016\u001a\u0004\b=\u0010\u0017R\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\bC\u0010\u0016\u001a\u0004\bA\u0010\u0017R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\bE\u0010\u0016\u001a\u0004\bC\u0010\u0017R\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\bG\u0010\u0016\u001a\u0004\bE\u0010\u0017¨\u0006M"}, d2 = {"Lcom/wortise/ads/api/submodels/UserLocation;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/wortise/ads/api/submodels/UserLocation$Accuracy;", "a", "Lcom/wortise/ads/api/submodels/UserLocation$Accuracy;", "()Lcom/wortise/ads/api/submodels/UserLocation$Accuracy;", "accuracy", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "adminArea", "", "c", "Ljava/lang/Double;", "()Ljava/lang/Double;", "altitude", "", "d", "Ljava/lang/Float;", "()Ljava/lang/Float;", "bearing", "e", "setCity", "(Ljava/lang/String;)V", "city", "f", "country", "Ljava/util/Date;", "g", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", "date", "h", "setFeature", "feature", "i", "D", "()D", "latitude", "j", "longitude", "k", "postalCode", "l", "provider", "Lcom/wortise/ads/api/submodels/UserLocation$Speed;", "m", "Lcom/wortise/ads/api/submodels/UserLocation$Speed;", "()Lcom/wortise/ads/api/submodels/UserLocation$Speed;", "speed", "n", "subAdminArea", "o", "subLocality", "p", "subThoroughfare", "q", "thoroughfare", "<init>", "(Lcom/wortise/ads/api/submodels/UserLocation$Accuracy;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Lcom/wortise/ads/api/submodels/UserLocation$Speed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Accuracy", "Speed", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserLocation.kt */
public final class UserLocation implements Parcelable {
    public static final Parcelable.Creator<UserLocation> CREATOR = new a();
    @SerializedName("accuracy")
    private final Accuracy a;
    @SerializedName("adminArea")
    private final String b;
    @SerializedName("altitude")
    private final Double c;
    @SerializedName("bearing")
    private final Float d;
    @SerializedName("city")
    private String e;
    @SerializedName("country")
    private final String f;
    @SerializedName("date")
    private final Date g;
    @SerializedName("feature")
    private String h;
    @SerializedName("latitude")
    private final double i;
    @SerializedName("longitude")
    private final double j;
    @SerializedName("postalCode")
    private final String k;
    @SerializedName("provider")
    private final String l;
    @SerializedName("speed")
    private final Speed m;
    @SerializedName("subAdminArea")
    private final String n;
    @SerializedName("subLocality")
    private final String o;
    @SerializedName("subThoroughfare")
    private final String p;
    @SerializedName("thoroughfare")
    private final String q;

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/api/submodels/UserLocation$Accuracy;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "a", "Ljava/lang/Float;", "()Ljava/lang/Float;", "horizontal", "b", "vertical", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: UserLocation.kt */
    public static final class Accuracy implements Parcelable {
        public static final Parcelable.Creator<Accuracy> CREATOR = new a();
        @SerializedName("horizontal")
        private final Float a;
        @SerializedName("vertical")
        private final Float b;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: UserLocation.kt */
        public static final class a implements Parcelable.Creator<Accuracy> {
            /* renamed from: a */
            public final Accuracy createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Float f = null;
                Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
                if (parcel.readInt() != 0) {
                    f = Float.valueOf(parcel.readFloat());
                }
                return new Accuracy(valueOf, f);
            }

            /* renamed from: a */
            public final Accuracy[] newArray(int i) {
                return new Accuracy[i];
            }
        }

        public Accuracy(Float f, Float f2) {
            this.a = f;
            this.b = f2;
        }

        public final Float a() {
            return this.a;
        }

        public final Float b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Accuracy)) {
                return false;
            }
            Accuracy accuracy = (Accuracy) obj;
            return Intrinsics.areEqual((Object) this.a, (Object) accuracy.a) && Intrinsics.areEqual((Object) this.b, (Object) accuracy.b);
        }

        public int hashCode() {
            Float f = this.a;
            int i = 0;
            int hashCode = (f == null ? 0 : f.hashCode()) * 31;
            Float f2 = this.b;
            if (f2 != null) {
                i = f2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Accuracy(horizontal=" + this.a + ", vertical=" + this.b + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Float f = this.a;
            if (f == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeFloat(f.floatValue());
            }
            Float f2 = this.b;
            if (f2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/api/submodels/UserLocation$Speed;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "a", "Ljava/lang/Float;", "()Ljava/lang/Float;", "accuracy", "b", "F", "()F", "value", "<init>", "(Ljava/lang/Float;F)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: UserLocation.kt */
    public static final class Speed implements Parcelable {
        public static final Parcelable.Creator<Speed> CREATOR = new a();
        @SerializedName("accuracy")
        private final Float a;
        @SerializedName("value")
        private final float b;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: UserLocation.kt */
        public static final class a implements Parcelable.Creator<Speed> {
            /* renamed from: a */
            public final Speed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Speed(parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readFloat());
            }

            /* renamed from: a */
            public final Speed[] newArray(int i) {
                return new Speed[i];
            }
        }

        public Speed(Float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public final Float a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Speed)) {
                return false;
            }
            Speed speed = (Speed) obj;
            return Intrinsics.areEqual((Object) this.a, (Object) speed.a) && Intrinsics.areEqual((Object) Float.valueOf(this.b), (Object) Float.valueOf(speed.b));
        }

        public int hashCode() {
            Float f = this.a;
            return ((f == null ? 0 : f.hashCode()) * 31) + Float.floatToIntBits(this.b);
        }

        public String toString() {
            return "Speed(accuracy=" + this.a + ", value=" + this.b + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Float f = this.a;
            if (f == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeFloat(f.floatValue());
            }
            parcel.writeFloat(this.b);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: UserLocation.kt */
    public static final class a implements Parcelable.Creator<UserLocation> {
        /* renamed from: a */
        public final UserLocation createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            return new UserLocation(Accuracy.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), Speed.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final UserLocation[] newArray(int i) {
            return new UserLocation[i];
        }
    }

    public UserLocation(Accuracy accuracy, String str, Double d2, Float f2, String str2, String str3, Date date, String str4, double d3, double d4, String str5, String str6, Speed speed, String str7, String str8, String str9, String str10) {
        Speed speed2 = speed;
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(speed2, "speed");
        this.a = accuracy;
        this.b = str;
        this.c = d2;
        this.d = f2;
        this.e = str2;
        this.f = str3;
        this.g = date;
        this.h = str4;
        this.i = d3;
        this.j = d4;
        this.k = str5;
        this.l = str6;
        this.m = speed2;
        this.n = str7;
        this.o = str8;
        this.p = str9;
        this.q = str10;
    }

    public final Accuracy a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final Double c() {
        return this.c;
    }

    public final Float d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLocation)) {
            return false;
        }
        UserLocation userLocation = (UserLocation) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) userLocation.a) && Intrinsics.areEqual((Object) this.b, (Object) userLocation.b) && Intrinsics.areEqual((Object) this.c, (Object) userLocation.c) && Intrinsics.areEqual((Object) this.d, (Object) userLocation.d) && Intrinsics.areEqual((Object) this.e, (Object) userLocation.e) && Intrinsics.areEqual((Object) this.f, (Object) userLocation.f) && Intrinsics.areEqual((Object) this.g, (Object) userLocation.g) && Intrinsics.areEqual((Object) this.h, (Object) userLocation.h) && Intrinsics.areEqual((Object) Double.valueOf(this.i), (Object) Double.valueOf(userLocation.i)) && Intrinsics.areEqual((Object) Double.valueOf(this.j), (Object) Double.valueOf(userLocation.j)) && Intrinsics.areEqual((Object) this.k, (Object) userLocation.k) && Intrinsics.areEqual((Object) this.l, (Object) userLocation.l) && Intrinsics.areEqual((Object) this.m, (Object) userLocation.m) && Intrinsics.areEqual((Object) this.n, (Object) userLocation.n) && Intrinsics.areEqual((Object) this.o, (Object) userLocation.o) && Intrinsics.areEqual((Object) this.p, (Object) userLocation.p) && Intrinsics.areEqual((Object) this.q, (Object) userLocation.q);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.h;
    }

    public final double h() {
        return this.i;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Double d2 = this.c;
        int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Float f2 = this.d;
        int hashCode4 = (hashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str2 = this.e;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int hashCode6 = (((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.g.hashCode()) * 31;
        String str4 = this.h;
        int hashCode7 = (((((hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + Double.doubleToLongBits(this.i)) * 31) + Double.doubleToLongBits(this.j)) * 31;
        String str5 = this.k;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.l;
        int hashCode9 = (((hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.m.hashCode()) * 31;
        String str7 = this.n;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.o;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.p;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.q;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode12 + i2;
    }

    public final double i() {
        return this.j;
    }

    public final String j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final Speed l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final String o() {
        return this.p;
    }

    public final String p() {
        return this.q;
    }

    public String toString() {
        return "UserLocation(accuracy=" + this.a + ", adminArea=" + this.b + ", altitude=" + this.c + ", bearing=" + this.d + ", city=" + this.e + ", country=" + this.f + ", date=" + this.g + ", feature=" + this.h + ", latitude=" + this.i + ", longitude=" + this.j + ", postalCode=" + this.k + ", provider=" + this.l + ", speed=" + this.m + ", subAdminArea=" + this.n + ", subLocality=" + this.o + ", subThoroughfare=" + this.p + ", thoroughfare=" + this.q + ')';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        Double d2 = this.c;
        if (d2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        }
        Float f2 = this.d;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeSerializable(this.g);
        parcel.writeString(this.h);
        parcel.writeDouble(this.i);
        parcel.writeDouble(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        this.m.writeToParcel(parcel, i2);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
    }
}
