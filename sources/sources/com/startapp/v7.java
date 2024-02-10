package com.startapp;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Sta */
public class v7 extends b2 {
    public static final Parcelable.Creator<v7> CREATOR = new a();
    public float f;
    public float g;

    /* compiled from: Sta */
    public class a implements Parcelable.Creator<v7> {
        public Object createFromParcel(Parcel parcel) {
            return new v7(parcel);
        }

        public Object[] newArray(int i) {
            return new v7[i];
        }
    }

    public v7(float f2, float f3) {
        this.f = f2;
        this.g = f3;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return super.toString() + ", Friction: [" + this.f + "], Snap:[" + this.g + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
    }

    public v7(Parcel parcel) {
        super(parcel);
        this.f = parcel.readFloat();
        this.g = parcel.readFloat();
    }
}
