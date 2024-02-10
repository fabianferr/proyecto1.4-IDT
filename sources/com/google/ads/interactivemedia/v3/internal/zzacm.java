package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzacm extends zzxi {
    static final zzxj zza = new zzack();
    private final DateFormat zzb = new SimpleDateFormat("hh:mm:ss a");

    private zzacm() {
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String format;
        Time time = (Time) obj;
        if (time == null) {
            zzacx.zzf();
            return;
        }
        synchronized (this) {
            format = this.zzb.format(time);
        }
        zzacx.zzk(format);
    }

    /* renamed from: zza */
    public final Time read(zzacv zzacv) throws IOException {
        Time time;
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        try {
            synchronized (this) {
                time = new Time(this.zzb.parse(zzi).getTime());
            }
            return time;
        } catch (ParseException e) {
            String zzf = zzacv.zzf();
            throw new zzwz("Failed parsing '" + zzi + "' as SQL Time; at path " + zzf, e);
        }
    }

    /* synthetic */ zzacm(zzacl zzacl) {
    }
}
