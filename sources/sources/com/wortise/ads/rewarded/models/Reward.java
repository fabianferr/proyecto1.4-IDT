package com.wortise.ads.rewarded.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/rewarded/models/Reward;", "Landroid/os/Parcelable;", "amount", "", "label", "", "success", "", "(ILjava/lang/String;Z)V", "getAmount", "()I", "getLabel", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Reward.kt */
public final class Reward implements Parcelable {
    public static final Parcelable.Creator<Reward> CREATOR = new a();
    @SerializedName("amount")
    private final int amount;
    @SerializedName("label")
    private final String label;
    private final transient boolean success;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Reward.kt */
    public static final class a implements Parcelable.Creator<Reward> {
        /* renamed from: a */
        public final Reward createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Reward(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        /* renamed from: a */
        public final Reward[] newArray(int i) {
            return new Reward[i];
        }
    }

    public Reward(int i, String str, boolean z) {
        this.amount = i;
        this.label = str;
        this.success = z;
    }

    public static /* synthetic */ Reward copy$default(Reward reward, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = reward.amount;
        }
        if ((i2 & 2) != 0) {
            str = reward.label;
        }
        if ((i2 & 4) != 0) {
            z = reward.success;
        }
        return reward.copy(i, str, z);
    }

    public final int component1() {
        return this.amount;
    }

    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.success;
    }

    public final Reward copy(int i, String str, boolean z) {
        return new Reward(i, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) obj;
        return this.amount == reward.amount && Intrinsics.areEqual((Object) this.label, (Object) reward.label) && this.success == reward.success;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int i = this.amount * 31;
        String str = this.label;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.success;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "Reward(amount=" + this.amount + ", label=" + this.label + ", success=" + this.success + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.amount);
        parcel.writeString(this.label);
        parcel.writeInt(this.success ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Reward(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, z);
    }
}
