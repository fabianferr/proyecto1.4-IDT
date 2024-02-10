package com.bykv.vk.openvk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.BsPatch;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import java.io.File;

/* compiled from: MergePatchZipInterceptor */
public class d extends com.bykv.vk.openvk.preload.b.d<Pair<a, UpdatePackage>, Pair<a, UpdatePackage>> {
    private b g;

    public final /* bridge */ /* synthetic */ Object a(com.bykv.vk.openvk.preload.b.b bVar, Object obj) throws Throwable {
        return a((com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>>) bVar, (Pair<a, UpdatePackage>) (Pair) obj);
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
    }

    private static Object a(com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start merge patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        File f = aVar.f();
        aVar.a();
        aVar.e();
        File parentFile = f.getParentFile().getParentFile();
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        File file = new File(parentFile, updatePackage.getLocalVersion() + File.separator + "res.zip");
        File file2 = new File(f.getParentFile(), "res.zip");
        c.a(file2);
        try {
            BsPatch.a(file, f, file2.getParentFile(), file2.getName());
            c.a(f);
            a a = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(file2, file2.length());
            try {
                return bVar.a(new Pair(a, updatePackage));
            } finally {
                a.e();
            }
        } catch (Exception e) {
            throw new RuntimeException("merged patch zip file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + e.getMessage(), e);
        } catch (Throwable th) {
            c.a(f);
            throw th;
        }
    }
}
