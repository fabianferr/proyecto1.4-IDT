package com.wortise.ads.google.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/google/models/GoogleParams;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "ids", "<init>", "(Ljava/util/List;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleParams.kt */
public final class GoogleParams implements Parcelable {
    public static final Parcelable.Creator<GoogleParams> CREATOR = new a();
    @SerializedName("ids")
    private final List<String> a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GoogleParams.kt */
    public static final class a implements Parcelable.Creator<GoogleParams> {
        /* renamed from: a */
        public final GoogleParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoogleParams(parcel.createStringArrayList());
        }

        /* renamed from: a */
        public final GoogleParams[] newArray(int i) {
            return new GoogleParams[i];
        }
    }

    public GoogleParams(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        this.a = list;
    }

    public final List<String> a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GoogleParams) && Intrinsics.areEqual((Object) this.a, (Object) ((GoogleParams) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "GoogleParams(ids=" + this.a + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.a);
    }
}
