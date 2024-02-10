package com.startapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.AnimationUtils;

/* compiled from: Sta */
public abstract class b2 implements Parcelable {
    public float a;
    public float b;
    public float c = Float.MAX_VALUE;
    public float d = -3.4028235E38f;
    public long e = 0;

    public b2() {
    }

    public String toString() {
        StringBuilder a2 = p0.a("Position: [");
        a2.append(this.a);
        a2.append("], Velocity:[");
        a2.append(this.b);
        a2.append("], MaxPos: [");
        a2.append(this.c);
        a2.append("], mMinPos: [");
        a2.append(this.d);
        a2.append("] LastTime:[");
        a2.append(this.e);
        a2.append("]");
        return a2.toString();
    }

    public b2(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }
}
