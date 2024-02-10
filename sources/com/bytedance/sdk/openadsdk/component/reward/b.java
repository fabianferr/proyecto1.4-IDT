package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.Iterator;
import java.util.List;

/* compiled from: ContinueDownloadTask */
public class b extends h {
    private final List<? extends h> a;

    public b(String str, List<? extends h> list) {
        super(str);
        this.a = list;
    }

    public void run() {
        List<? extends h> list;
        if (!(o.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0 || (list = this.a) == null)) {
            Iterator<? extends h> it = list.iterator();
            while (it.hasNext()) {
                aa.a((h) it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.h.a().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
