package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahArr = this.zza;
            if (i < zzahArr.length) {
                zzahArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzah zzah : this.zza) {
            hashMap.put(zzah.zzd, Integer.valueOf((hashMap.containsKey(zzah.zzd) ? ((Integer) hashMap.get(zzah.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = "und";
        }
        return this.zzd;
    }

    public String getValue() {
        zzah[] zzahArr = this.zza;
        if (zzahArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahArr[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append("\n");
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }

    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahArr;
        TextBlock textBlock2 = this;
        if (textBlock2.zzb == null) {
            char c = 0;
            if (textBlock2.zza.length == 0) {
                textBlock2.zzb = new Point[0];
            } else {
                int i = Integer.MIN_VALUE;
                int i2 = Integer.MIN_VALUE;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = 0;
                while (true) {
                    zzahArr = textBlock2.zza;
                    if (i5 >= zzahArr.length) {
                        break;
                    }
                    zzab zzab = zzahArr[i5].zzb;
                    zzab zzab2 = textBlock2.zza[c].zzb;
                    double sin = Math.sin(Math.toRadians((double) zzab2.zze));
                    double cos = Math.cos(Math.toRadians((double) zzab2.zze));
                    Point[] pointArr = new Point[4];
                    Point point = new Point(zzab.zza, zzab.zzb);
                    pointArr[c] = point;
                    point.offset(-zzab2.zza, -zzab2.zzb);
                    double d = (double) pointArr[c].x;
                    Double.isNaN(d);
                    int i6 = i2;
                    double d2 = (double) pointArr[c].y;
                    Double.isNaN(d2);
                    int i7 = (int) ((d * cos) + (d2 * sin));
                    double d3 = (double) (-pointArr[0].x);
                    Double.isNaN(d3);
                    double d4 = d3 * sin;
                    double d5 = (double) pointArr[0].y;
                    Double.isNaN(d5);
                    int i8 = (int) (d4 + (d5 * cos));
                    pointArr[0].x = i7;
                    pointArr[0].y = i8;
                    pointArr[1] = new Point(zzab.zzc + i7, i8);
                    pointArr[2] = new Point(zzab.zzc + i7, zzab.zzd + i8);
                    pointArr[3] = new Point(i7, i8 + zzab.zzd);
                    i2 = i6;
                    for (int i9 = 0; i9 < 4; i9++) {
                        Point point2 = pointArr[i9];
                        i3 = Math.min(i3, point2.x);
                        i = Math.max(i, point2.x);
                        i4 = Math.min(i4, point2.y);
                        i2 = Math.max(i2, point2.y);
                    }
                    i5++;
                    c = 0;
                    textBlock2 = this;
                }
                int i10 = i2;
                zzab zzab3 = zzahArr[0].zzb;
                int i11 = zzab3.zza;
                int i12 = zzab3.zzb;
                double sin2 = Math.sin(Math.toRadians((double) zzab3.zze));
                double cos2 = Math.cos(Math.toRadians((double) zzab3.zze));
                int i13 = i10;
                Point[] pointArr2 = {new Point(i3, i4), new Point(i, i4), new Point(i, i13), new Point(i3, i13)};
                for (int i14 = 0; i14 < 4; i14++) {
                    double d6 = (double) pointArr2[i14].x;
                    Double.isNaN(d6);
                    double d7 = (double) pointArr2[i14].y;
                    Double.isNaN(d7);
                    int i15 = (int) ((d6 * cos2) - (d7 * sin2));
                    double d8 = (double) pointArr2[i14].x;
                    Double.isNaN(d8);
                    double d9 = (double) pointArr2[i14].y;
                    Double.isNaN(d9);
                    pointArr2[i14].x = i15;
                    pointArr2[i14].y = (int) ((d8 * sin2) + (d9 * cos2));
                    pointArr2[i14].offset(i11, i12);
                }
                textBlock = this;
                textBlock.zzb = pointArr2;
                return textBlock.zzb;
            }
        }
        textBlock = textBlock2;
        return textBlock.zzb;
    }

    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah line : this.zza) {
                this.zzc.add(new Line(line));
            }
        }
        return this.zzc;
    }

    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = zzc.zza((Text) this);
        }
        return this.zze;
    }
}
