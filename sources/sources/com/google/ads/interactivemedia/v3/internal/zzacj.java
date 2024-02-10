package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzacj extends zzxi {
    static final zzxj zza = new zzach();
    private final DateFormat zzb = new SimpleDateFormat("MMM d, yyyy");

    private zzacj() {
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            zzacx.zzf();
            return;
        }
        synchronized (this) {
            format = this.zzb.format(date);
        }
        zzacx.zzk(format);
    }

    /* renamed from: zza */
    public final Date read(zzacv zzacv) throws IOException {
        java.util.Date parse;
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        try {
            synchronized (this) {
                parse = this.zzb.parse(zzi);
            }
            return new Date(parse.getTime());
        } catch (ParseException e) {
            String zzf = zzacv.zzf();
            throw new zzwz("Failed parsing '" + zzi + "' as SQL Date; at path " + zzf, e);
        }
    }

    /* synthetic */ zzacj(zzaci zzaci) {
    }
}
