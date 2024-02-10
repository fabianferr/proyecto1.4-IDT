package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
public final class k extends t<Time> {
    public static final u a = new u() {
        public final <T> t<T> a(f fVar, a<T> aVar) {
            if (aVar.b == Time.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Time a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            return new Time(this.b.parse(aVar.i()).getTime());
        } catch (ParseException e) {
            throw new r((Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.b.format(time));
    }
}
