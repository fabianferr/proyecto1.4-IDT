package com.bykv.vk.openvk.component.video.a.b.e;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.n;
import java.io.IOException;
import java.util.Map;

/* compiled from: NetworkSoureVolleyImpl */
public class d implements b {
    private j a;

    public d() {
        this.a = null;
        this.a = c.d();
    }

    public a a(e eVar) throws IOException {
        l.a aVar = new l.a();
        try {
            if (eVar.e != null) {
                for (Map.Entry next : eVar.e.entrySet()) {
                    String str = (String) next.getKey();
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = (String) next.getValue();
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar.b(str, str2);
                    }
                }
            }
            n a2 = this.a.a(aVar.a(eVar.b).a().b()).a();
            com.bykv.vk.openvk.component.video.api.f.c.b("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(a2.c()));
            return new f(a2, eVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
