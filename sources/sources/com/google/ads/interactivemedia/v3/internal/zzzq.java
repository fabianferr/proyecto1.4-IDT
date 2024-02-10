package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzq extends zzxi {
    public static final zzxj zza = new zzzp();
    private final List zzb;

    public zzzq() {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (zzyo.zza()) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US));
        }
    }

    private final Date zza(zzacv zzacv) throws IOException {
        String zzi = zzacv.zzi();
        synchronized (this.zzb) {
            for (DateFormat parse : this.zzb) {
                try {
                    Date parse2 = parse.parse(zzi);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                return zzabz.zza(zzi, new ParsePosition(0));
            } catch (ParseException e) {
                String zzf = zzacv.zzf();
                throw new zzwz("Failed parsing '" + zzi + "' as Date; at path " + zzf, e);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return zza(zzacv);
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            zzacx.zzf();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.zzb.get(0);
        synchronized (this.zzb) {
            format = dateFormat.format(date);
        }
        zzacx.zzk(format);
    }
}
