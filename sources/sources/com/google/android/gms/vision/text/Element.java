package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public class Element implements Text {
    private zzao zza;

    Element(zzao zzao) {
        this.zza = zzao;
    }

    public String getLanguage() {
        return this.zza.zzc;
    }

    public String getValue() {
        return this.zza.zzb;
    }

    public Rect getBoundingBox() {
        return zzc.zza((Text) this);
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zza.zza);
    }

    public List<? extends Text> getComponents() {
        return new ArrayList();
    }
}
