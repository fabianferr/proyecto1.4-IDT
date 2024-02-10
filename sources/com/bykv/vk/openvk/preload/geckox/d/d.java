package com.bykv.vk.openvk.preload.geckox.d;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.geckox.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LoadLocalChannelVersionInterceptor */
public class d extends com.bykv.vk.openvk.preload.b.d<List<String>, List<Pair<String, Long>>> {
    private File g;
    private String h;

    public final /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        List<String> list = (List) obj;
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", list);
        File file = new File(this.g, this.h);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Long a = j.a(new File(file, str));
            arrayList.add(new Pair(str, Long.valueOf(a == null ? 0 : a.longValue())));
        }
        return bVar.a(arrayList);
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
        this.h = objArr[1];
    }
}
