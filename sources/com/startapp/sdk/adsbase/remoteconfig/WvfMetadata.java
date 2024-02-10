package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import android.os.Build;
import com.startapp.d9;
import com.startapp.k9;
import com.startapp.z3;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class WvfMetadata implements Serializable {
    public static final int[] a;
    private static final long serialVersionUID = 4743531680449306847L;
    @d9(complex = true)
    private ComponentInfoEventConfig infoEvents;
    private double legacy;
    @d9(parser = z3.class)
    private int[] modes = a;

    static {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 21) {
            iArr = new int[]{0, 0, 1};
        } else {
            iArr = new int[]{0, 1, 0};
        }
        a = iArr;
    }

    public ComponentInfoEventConfig a() {
        return this.infoEvents;
    }

    public double b() {
        return this.legacy;
    }

    public int[] c() {
        return this.modes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WvfMetadata wvfMetadata = (WvfMetadata) obj;
        if (Double.compare(this.legacy, wvfMetadata.legacy) != 0 || !k9.a(this.infoEvents, wvfMetadata.infoEvents) || !Arrays.equals(this.modes, wvfMetadata.modes)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.infoEvents, this.modes, Double.valueOf(this.legacy)};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
