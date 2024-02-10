package com.wortise.ads.geofencing.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.api.submodels.UserLocation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "a", "Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "()Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "transition", "", "b", "Ljava/util/List;", "getTriggeringGeofences", "()Ljava/util/List;", "triggeringGeofences", "Lcom/wortise/ads/api/submodels/UserLocation;", "c", "Lcom/wortise/ads/api/submodels/UserLocation;", "getTriggeringLocation", "()Lcom/wortise/ads/api/submodels/UserLocation;", "triggeringLocation", "<init>", "(Lcom/wortise/ads/geofencing/models/GeofenceTransition;Ljava/util/List;Lcom/wortise/ads/api/submodels/UserLocation;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceEvent.kt */
public final class GeofenceEvent implements Parcelable {
    public static final Parcelable.Creator<GeofenceEvent> CREATOR = new a();
    @SerializedName("transition")
    private final GeofenceTransition a;
    @SerializedName("triggeringGeofences")
    private final List<String> b;
    @SerializedName("triggeringLocation")
    private final UserLocation c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GeofenceEvent.kt */
    public static final class a implements Parcelable.Creator<GeofenceEvent> {
        /* renamed from: a */
        public final GeofenceEvent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            UserLocation userLocation = null;
            GeofenceTransition valueOf = parcel.readInt() == 0 ? null : GeofenceTransition.valueOf(parcel.readString());
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() != 0) {
                userLocation = UserLocation.CREATOR.createFromParcel(parcel);
            }
            return new GeofenceEvent(valueOf, createStringArrayList, userLocation);
        }

        /* renamed from: a */
        public final GeofenceEvent[] newArray(int i) {
            return new GeofenceEvent[i];
        }
    }

    public GeofenceEvent(GeofenceTransition geofenceTransition, List<String> list, UserLocation userLocation) {
        this.a = geofenceTransition;
        this.b = list;
        this.c = userLocation;
    }

    public final GeofenceTransition a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeofenceEvent)) {
            return false;
        }
        GeofenceEvent geofenceEvent = (GeofenceEvent) obj;
        return this.a == geofenceEvent.a && Intrinsics.areEqual((Object) this.b, (Object) geofenceEvent.b) && Intrinsics.areEqual((Object) this.c, (Object) geofenceEvent.c);
    }

    public int hashCode() {
        GeofenceTransition geofenceTransition = this.a;
        int i = 0;
        int hashCode = (geofenceTransition == null ? 0 : geofenceTransition.hashCode()) * 31;
        List<String> list = this.b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        UserLocation userLocation = this.c;
        if (userLocation != null) {
            i = userLocation.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GeofenceEvent(transition=" + this.a + ", triggeringGeofences=" + this.b + ", triggeringLocation=" + this.c + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        GeofenceTransition geofenceTransition = this.a;
        if (geofenceTransition == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(geofenceTransition.name());
        }
        parcel.writeStringList(this.b);
        UserLocation userLocation = this.c;
        if (userLocation == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        userLocation.writeToParcel(parcel, i);
    }
}
