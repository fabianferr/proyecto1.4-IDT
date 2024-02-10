package com.bykv.vk.openvk.preload.geckox.d;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LoadLocalChannelVersionInterceptorMulti */
public class e extends d<String, Map<String, List<Pair<String, Long>>>> {
    private File g;
    private List<String> h;

    public final /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        Long a;
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", (String) obj);
        HashMap hashMap = new HashMap();
        for (String next : this.h) {
            File file = new File(this.g, next);
            String[] list = file.list();
            ArrayList arrayList = new ArrayList();
            if (list != null && list.length > 0) {
                for (String str : list) {
                    File file2 = new File(file, str);
                    if (file2.isDirectory() && (a = j.a(file2)) != null) {
                        arrayList.add(new Pair(str, a));
                    }
                }
            }
            hashMap.put(next, arrayList);
        }
        return bVar.a(hashMap);
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
        this.h = objArr[1];
    }
}
