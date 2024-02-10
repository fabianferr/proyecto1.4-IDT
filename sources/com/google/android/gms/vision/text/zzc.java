package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            i = Math.min(i, point.x);
            i3 = Math.max(i3, point.x);
            i2 = Math.min(i2, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i, i2, i3, i4);
    }

    static Point[] zza(zzab zzab) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzab.zze));
        double cos = Math.cos(Math.toRadians((double) zzab.zze));
        pointArr[0] = new Point(zzab.zza, zzab.zzb);
        double d = (double) zzab.zza;
        double d2 = (double) zzab.zzc;
        Double.isNaN(d2);
        Double.isNaN(d);
        double d3 = (double) zzab.zzb;
        double d4 = (double) zzab.zzc;
        Double.isNaN(d4);
        Double.isNaN(d3);
        pointArr[1] = new Point((int) (d + (d2 * cos)), (int) (d3 + (d4 * sin)));
        double d5 = (double) pointArr[1].x;
        double d6 = (double) zzab.zzd;
        Double.isNaN(d6);
        Double.isNaN(d5);
        int i = (int) (d5 - (d6 * sin));
        double d7 = (double) pointArr[1].y;
        double d8 = (double) zzab.zzd;
        Double.isNaN(d8);
        Double.isNaN(d7);
        pointArr[2] = new Point(i, (int) (d7 + (d8 * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
