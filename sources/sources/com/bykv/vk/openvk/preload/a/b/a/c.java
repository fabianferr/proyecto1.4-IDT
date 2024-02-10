package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.e;
import com.bykv.vk.openvk.preload.a.b.j;
import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter */
public final class c extends t<Date> {
    public static final u a = new u() {
        public final <T> t<T> a(f fVar, a<T> aVar) {
            if (aVar.b == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final List<DateFormat> b;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.b()) {
            arrayList.add(j.a(2, 2));
        }
    }

    private synchronized Date a(String str) {
        for (DateFormat parse : this.b) {
            try {
                return parse.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.bykv.vk.openvk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
        } catch (ParseException e) {
            throw new r(str, e);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(com.bykv.vk.openvk.preload.a.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.e();
        } else {
            cVar.b(this.b.get(0).format(date));
        }
    }

    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return a(aVar.i());
        }
        aVar.k();
        return null;
    }
}
