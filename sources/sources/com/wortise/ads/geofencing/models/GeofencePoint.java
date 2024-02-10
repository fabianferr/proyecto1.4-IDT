package com.wortise.ads.geofencing.models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010(¢\u0006\u0004\b-\u0010.J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001a\u0010!\u001a\u00020\u001d8\u0006X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001a\u0010#\u001a\u00020\u001d8\u0006X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b\"\u0010 R\u001a\u0010'\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R\u001c\u0010,\u001a\u0004\u0018\u00010(8\u0006X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+¨\u0006/"}, d2 = {"Lcom/wortise/ads/geofencing/models/GeofencePoint;", "Landroid/os/Parcelable;", "Landroid/location/Location;", "location", "", "a", "g", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "Ljava/lang/Long;", "()Ljava/lang/Long;", "expiration", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "", "c", "D", "()D", "latitude", "d", "longitude", "e", "F", "()F", "radius", "Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "f", "Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "()Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "transition", "<init>", "(Ljava/lang/Long;Ljava/lang/String;DDFLcom/wortise/ads/geofencing/models/GeofenceTransition;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofencePoint.kt */
public final class GeofencePoint implements Parcelable {
    public static final Parcelable.Creator<GeofencePoint> CREATOR = new a();
    @SerializedName("expiration")
    private final Long a;
    @SerializedName("id")
    private final String b;
    @SerializedName("latitude")
    private final double c;
    @SerializedName("longitude")
    private final double d;
    @SerializedName("radius")
    private final float e;
    @SerializedName("transition")
    private final GeofenceTransition f;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GeofencePoint.kt */
    public static final class a implements Parcelable.Creator<GeofencePoint> {
        /* renamed from: a */
        public final GeofencePoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GeofencePoint(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readInt() == 0 ? null : GeofenceTransition.valueOf(parcel.readString()));
        }

        /* renamed from: a */
        public final GeofencePoint[] newArray(int i) {
            return new GeofencePoint[i];
        }
    }

    public GeofencePoint() {
        this((Long) null, (String) null, 0.0d, 0.0d, 0.0f, (GeofenceTransition) null, 63, (DefaultConstructorMarker) null);
    }

    public GeofencePoint(Long l, String str, double d2, double d3, float f2, GeofenceTransition geofenceTransition) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a = l;
        this.b = str;
        this.c = d2;
        this.d = d3;
        this.e = f2;
        this.f = geofenceTransition;
    }

    public final Long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeofencePoint)) {
            return false;
        }
        GeofencePoint geofencePoint = (GeofencePoint) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) geofencePoint.a) && Intrinsics.areEqual((Object) this.b, (Object) geofencePoint.b) && Intrinsics.areEqual((Object) Double.valueOf(this.c), (Object) Double.valueOf(geofencePoint.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(geofencePoint.d)) && Intrinsics.areEqual((Object) Float.valueOf(this.e), (Object) Float.valueOf(geofencePoint.e)) && this.f == geofencePoint.f;
    }

    public final GeofenceTransition f() {
        return this.f;
    }

    public final Location g() {
        Location location = new Location("");
        location.setLatitude(c());
        location.setLongitude(d());
        return location;
    }

    public int hashCode() {
        Long l = this.a;
        int i = 0;
        int hashCode = (((((((((l == null ? 0 : l.hashCode()) * 31) + this.b.hashCode()) * 31) + Double.doubleToLongBits(this.c)) * 31) + Double.doubleToLongBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
        GeofenceTransition geofenceTransition = this.f;
        if (geofenceTransition != null) {
            i = geofenceTransition.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GeofencePoint(expiration=" + this.a + ", id=" + this.b + ", latitude=" + this.c + ", longitude=" + this.d + ", radius=" + this.e + ", transition=" + this.f + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.a;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeFloat(this.e);
        GeofenceTransition geofenceTransition = this.f;
        if (geofenceTransition == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(geofenceTransition.name());
    }

    public final float a(Location location) {
        Intrinsics.checkNotNullParameter(location, FirebaseAnalytics.Param.LOCATION);
        return location.distanceTo(g());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GeofencePoint(java.lang.Long r10, java.lang.String r11, double r12, double r14, float r16, com.wortise.ads.geofencing.models.GeofenceTransition r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r10
        L_0x0008:
            r2 = r18 & 2
            if (r2 == 0) goto L_0x001a
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            goto L_0x001b
        L_0x001a:
            r2 = r11
        L_0x001b:
            r3 = r18 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0023
            r6 = r4
            goto L_0x0024
        L_0x0023:
            r6 = r12
        L_0x0024:
            r3 = r18 & 8
            if (r3 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r4 = r14
        L_0x002a:
            r3 = r18 & 16
            if (r3 == 0) goto L_0x0030
            r3 = 0
            goto L_0x0032
        L_0x0030:
            r3 = r16
        L_0x0032:
            r8 = r18 & 32
            if (r8 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r1 = r17
        L_0x0039:
            r10 = r9
            r11 = r0
            r12 = r2
            r13 = r6
            r15 = r4
            r17 = r3
            r18 = r1
            r10.<init>(r11, r12, r13, r15, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.geofencing.models.GeofencePoint.<init>(java.lang.Long, java.lang.String, double, double, float, com.wortise.ads.geofencing.models.GeofenceTransition, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
