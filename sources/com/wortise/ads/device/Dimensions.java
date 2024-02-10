package com.wortise.ads.device;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.wortise.ads.r2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0005\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/device/Dimensions;", "Landroid/os/Parcelable;", "Landroid/content/Context;", "context", "", "a", "b", "", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "I", "c", "()I", "width", "height", "shortestWidth", "<init>", "(II)V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Dimensions.kt */
public final class Dimensions implements Parcelable {
    public static final Parcelable.Creator<Dimensions> CREATOR = new b();
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final int a;
    private final int b;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/device/Dimensions$a;", "", "Landroid/content/Context;", "context", "", "width", "height", "Lcom/wortise/ads/device/Dimensions;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Dimensions.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Dimensions a(Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Dimensions(r2.b(context, Integer.valueOf(i)), r2.b(context, Integer.valueOf(i2)));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Dimensions.kt */
    public static final class b implements Parcelable.Creator<Dimensions> {
        /* renamed from: a */
        public final Dimensions createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Dimensions(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public final Dimensions[] newArray(int i) {
            return new Dimensions[i];
        }
    }

    public Dimensions(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return Math.min(this.b, this.a);
    }

    public final int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dimensions)) {
            return false;
        }
        Dimensions dimensions = (Dimensions) obj;
        return this.a == dimensions.a && this.b == dimensions.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "Dimensions(width=" + this.a + ", height=" + this.b + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }

    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r2.d(context, Integer.valueOf(this.b));
    }

    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r2.d(context, Integer.valueOf(this.a));
    }
}
