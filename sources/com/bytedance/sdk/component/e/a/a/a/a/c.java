package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DBInsertMemRepo */
public abstract class c {
    private final Context a;
    protected final List<a> b = new ArrayList();
    /* access modifiers changed from: private */
    public boolean c = false;
    private Runnable d = new Runnable() {
        public void run() {
            ArrayList arrayList;
            synchronized (c.this) {
                arrayList = new ArrayList(c.this.b);
                c.this.b.clear();
                boolean unused = c.this.c = false;
            }
            c.this.d(arrayList);
        }
    };

    public abstract String b();

    public c(Context context) {
        this.a = context;
    }

    private void a() {
        if (!this.c) {
            com.bytedance.sdk.component.e.a.g.a.a().postDelayed(this.d, (long) com.bytedance.sdk.component.e.a.g.a.b());
            this.c = true;
        }
    }

    /* access modifiers changed from: protected */
    public void c(List<String> list) {
        if (list != null && !list.isEmpty()) {
            try {
                Iterator<a> it = this.b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        String c2 = next.c();
                        if (!TextUtils.isEmpty(c2) && list.contains(c2)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.e.a.c.c.b("DBInsertMemRepo", b() + "deleteMemList: " + th.getMessage());
            }
        }
    }

    public synchronized void a(a aVar) {
        if (aVar.g() != null && !TextUtils.isEmpty(aVar.c())) {
            this.b.add(aVar);
            a();
        }
    }

    public Context f() {
        return this.a;
    }

    public void d(List<a> list) {
        com.bytedance.sdk.component.e.a.a.a.c.a(f(), b(), list);
    }
}
