package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.i;

public final class t {
    private String a = null;
    private int b = -1;

    public t(Context context) {
    }

    public String a() {
        if (!TextUtils.isEmpty(this.a) && !"0".equals(this.a)) {
            return this.a;
        }
        String d = i.a().d();
        this.a = d;
        if (!TextUtils.isEmpty(d) && !"0".equals(this.a)) {
            return this.a;
        }
        String b2 = s.a().b();
        this.a = b2;
        return b2;
    }

    public void a(String str) {
        this.a = str;
        s.a().b(str);
    }

    public boolean b() {
        return this.a != null;
    }
}
