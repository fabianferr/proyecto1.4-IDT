package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabe extends zzxi {
    zzabe() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        zzacv.zzk();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (zzacv.zzt() != 4) {
            String zzh = zzacv.zzh();
            int zzc = zzacv.zzc();
            if ("year".equals(zzh)) {
                i = zzc;
            } else if ("month".equals(zzh)) {
                i2 = zzc;
            } else if ("dayOfMonth".equals(zzh)) {
                i3 = zzc;
            } else if ("hourOfDay".equals(zzh)) {
                i4 = zzc;
            } else if ("minute".equals(zzh)) {
                i5 = zzc;
            } else if ("second".equals(zzh)) {
                i6 = zzc;
            }
        }
        zzacv.zzm();
        return new GregorianCalendar(i, i2, i3, i4, i5, i6);
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            zzacx.zzf();
            return;
        }
        zzacx.zzb();
        zzacx.zze("year");
        zzacx.zzh((long) calendar.get(1));
        zzacx.zze("month");
        zzacx.zzh((long) calendar.get(2));
        zzacx.zze("dayOfMonth");
        zzacx.zzh((long) calendar.get(5));
        zzacx.zze("hourOfDay");
        zzacx.zzh((long) calendar.get(11));
        zzacx.zze("minute");
        zzacx.zzh((long) calendar.get(12));
        zzacx.zze("second");
        zzacx.zzh((long) calendar.get(13));
        zzacx.zzd();
    }
}
