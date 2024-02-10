package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class j extends t<Date> {
    public static final u a = new u() {
        public final <T> t<T> a(f fVar, a<T> aVar) {
            if (aVar.b == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Date a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            return new Date(this.b.parse(aVar.i()).getTime());
        } catch (ParseException e) {
            throw new r((Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.b.format(date));
    }
}
