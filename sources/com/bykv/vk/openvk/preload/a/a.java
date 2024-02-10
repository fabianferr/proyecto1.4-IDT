package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.b.e;
import com.bykv.vk.openvk.preload.a.b.j;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter */
public final class a extends t<Date> {
    private final Class<? extends Date> a;
    private final List<DateFormat> b;

    public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
        Date date = (Date) obj;
        if (date == null) {
            cVar.e();
            return;
        }
        synchronized (this.b) {
            cVar.b(this.b.get(0).format(date));
        }
    }

    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = a(cls);
        arrayList.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = a(cls);
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (e.b()) {
            arrayList.add(j.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    private Date a(String str) {
        synchronized (this.b) {
            for (DateFormat parse : this.b) {
                try {
                    Date parse2 = parse.parse(str);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                Date a2 = com.bykv.vk.openvk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
                return a2;
            } catch (ParseException e) {
                throw new r(str, e);
            }
        }
    }

    public final String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        Date a2 = a(aVar.i());
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }
}
